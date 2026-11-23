package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.FavoritesRepository
import com.example.data.OfflineTranslation
import com.example.data.OfflineTranslationRepository
import com.example.data.QuoteCatalog
import com.example.model.BatchOrder
import com.example.model.HikmaTab
import com.example.model.PhilosophicalQuote
import com.example.model.PhilosophicalSchool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

data class QuoteTranslationState(
    val isExpanded: Boolean = false,
    val translation: OfflineTranslation? = null
)

data class TimeQuoteSnapshot(
    val dailyQuote: PhilosophicalQuote = QuoteCatalog.getDailyQuote(),
    val hourlyQuote: PhilosophicalQuote = QuoteCatalog.getHourlyQuote(),
    val dailyDateLabel: String = "",
    val hourlyWindowText: String = "",
    val countdownText: String = ""
)

data class HikmaUiState(
    val selectedTab: HikmaTab = HikmaTab.BY_NUMBER,
    val selectedNumber: Int = 1,
    val numberInputText: String = "1",
    val numberInputError: Boolean = false,
    val currentQuote: PhilosophicalQuote = QuoteCatalog.getByNumber(1),
    val selectedCount: Int = 5,
    val countInputText: String = "5",
    val selectedSchool: PhilosophicalSchool = PhilosophicalSchool.ALL,
    val batchOrder: BatchOrder = BatchOrder.SEQUENTIAL,
    val batchQuotes: List<PhilosophicalQuote> = QuoteCatalog.getBatch(5, PhilosophicalSchool.ALL, false),
    val maxCountForSchool: Int = QuoteCatalog.totalCount,
    val favoriteIds: Set<Int> = emptySet(),
    val favoriteQuotes: List<PhilosophicalQuote> = emptyList(),
    val darkModeOverride: Boolean? = null,
    val dailyQuote: PhilosophicalQuote = QuoteCatalog.getDailyQuote(),
    val hourlyQuote: PhilosophicalQuote = QuoteCatalog.getHourlyQuote(),
    val dailyDateLabel: String = "",
    val hourlyWindowText: String = "",
    val countdownText: String = "",
    val customExplanations: Map<Int, String> = emptyMap(),
    val translationsByQuote: Map<Int, QuoteTranslationState> = emptyMap(),
    val editingExplanationQuote: PhilosophicalQuote? = null
)

private data class InternalState(
    val selectedTab: HikmaTab = HikmaTab.BY_NUMBER,
    val selectedNumber: Int = 1,
    val numberInputText: String = "1",
    val numberInputError: Boolean = false,
    val selectedCount: Int = 5,
    val countInputText: String = "5",
    val selectedSchool: PhilosophicalSchool = PhilosophicalSchool.ALL,
    val batchOrder: BatchOrder = BatchOrder.SEQUENTIAL,
    val batchQuotes: List<PhilosophicalQuote> = QuoteCatalog.getBatch(5, PhilosophicalSchool.ALL, false),
    val translationsByQuote: Map<Int, QuoteTranslationState> = emptyMap(),
    val editingExplanationQuote: PhilosophicalQuote? = null
)

class HikmaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = FavoritesRepository(application.applicationContext)
    private val translationRepository = OfflineTranslationRepository()
    private val internalState = MutableStateFlow(InternalState())
    private val timeState = MutableStateFlow(buildTimeSnapshot(Calendar.getInstance()))

    val totalQuoteCount: Int = QuoteCatalog.totalCount

    val uiState: StateFlow<HikmaUiState> = combine(
        internalState,
        repository.favoriteIds,
        repository.darkModeOverride,
        repository.customExplanations,
        timeState
    ) { internal, favIds, darkOverride, explanations, timeSnapshot ->
        val maxForSchool = if (internal.selectedSchool == PhilosophicalSchool.ALL) {
            QuoteCatalog.totalCount
        } else {
            QuoteCatalog.quotes.count { it.school == internal.selectedSchool }
        }
        HikmaUiState(
            selectedTab = internal.selectedTab,
            selectedNumber = internal.selectedNumber,
            numberInputText = internal.numberInputText,
            numberInputError = internal.numberInputError,
            currentQuote = QuoteCatalog.getByNumber(internal.selectedNumber),
            selectedCount = internal.selectedCount.coerceIn(1, maxForSchool.coerceAtLeast(1)),
            countInputText = internal.countInputText,
            selectedSchool = internal.selectedSchool,
            batchOrder = internal.batchOrder,
            batchQuotes = internal.batchQuotes,
            maxCountForSchool = maxForSchool,
            favoriteIds = favIds,
            favoriteQuotes = QuoteCatalog.quotes.filter { favIds.contains(it.id) },
            darkModeOverride = darkOverride,
            dailyQuote = timeSnapshot.dailyQuote,
            hourlyQuote = timeSnapshot.hourlyQuote,
            dailyDateLabel = timeSnapshot.dailyDateLabel,
            hourlyWindowText = timeSnapshot.hourlyWindowText,
            countdownText = timeSnapshot.countdownText,
            customExplanations = explanations,
            translationsByQuote = internal.translationsByQuote,
            editingExplanationQuote = internal.editingExplanationQuote
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HikmaUiState(
            dailyQuote = timeState.value.dailyQuote,
            hourlyQuote = timeState.value.hourlyQuote,
            dailyDateLabel = timeState.value.dailyDateLabel,
            hourlyWindowText = timeState.value.hourlyWindowText,
            countdownText = timeState.value.countdownText
        )
    )

    fun refreshTimeBasedQuotes(calendar: Calendar = Calendar.getInstance()) {
        timeState.value = buildTimeSnapshot(calendar)
    }

    fun selectTab(tab: HikmaTab) {
        internalState.update { it.copy(selectedTab = tab) }
    }

    fun selectNumber(number: Int, switchToNumberTab: Boolean = false) {
        val clamped = number.coerceIn(1, totalQuoteCount)
        internalState.update {
            it.copy(
                selectedTab = if (switchToNumberTab) HikmaTab.BY_NUMBER else it.selectedTab,
                selectedNumber = clamped,
                numberInputText = clamped.toString(),
                numberInputError = false
            )
        }
    }

    fun onNumberInputChanged(text: String) {
        val digitsOnly = normalizeDigits(text).filter { it.isDigit() }
        val parsed = digitsOnly.toIntOrNull()
        if (parsed != null && parsed in 1..totalQuoteCount) {
            internalState.update {
                it.copy(
                    numberInputText = digitsOnly,
                    selectedNumber = parsed,
                    numberInputError = false
                )
            }
        } else {
            internalState.update {
                it.copy(
                    numberInputText = digitsOnly,
                    numberInputError = digitsOnly.isNotEmpty()
                )
            }
        }
    }

    fun submitNumberInput() {
        val parsed = normalizeDigits(internalState.value.numberInputText).toIntOrNull()
        if (parsed != null && parsed in 1..totalQuoteCount) {
            selectNumber(parsed)
        } else {
            internalState.update { it.copy(numberInputError = true) }
        }
    }

    fun stepNumber(delta: Int) {
        val current = internalState.value.selectedNumber
        val next = when {
            current + delta < 1 -> totalQuoteCount
            current + delta > totalQuoteCount -> 1
            else -> current + delta
        }
        selectNumber(next)
    }

    fun pickRandomNumber() {
        val current = internalState.value.selectedNumber
        var next = Random.nextInt(1, totalQuoteCount + 1)
        if (totalQuoteCount > 1 && next == current) {
            next = (current % totalQuoteCount) + 1
        }
        selectNumber(next)
    }

    fun selectCount(count: Int) {
        internalState.update { current ->
            val maxAvailable = maxAvailableFor(current.selectedSchool)
            val clamped = count.coerceIn(1, maxAvailable)
            current.copy(
                selectedCount = clamped,
                countInputText = clamped.toString(),
                batchQuotes = QuoteCatalog.getBatch(
                    count = clamped,
                    school = current.selectedSchool,
                    randomOrder = current.batchOrder == BatchOrder.RANDOM
                )
            )
        }
    }

    fun onCountInputChanged(text: String) {
        val digitsOnly = normalizeDigits(text).filter { it.isDigit() }
        val maxAvailable = maxAvailableFor(internalState.value.selectedSchool)
        val parsed = digitsOnly.toIntOrNull()
        if (parsed != null && parsed >= 1) {
            val clamped = parsed.coerceAtMost(maxAvailable)
            internalState.update { current ->
                current.copy(
                    countInputText = digitsOnly,
                    selectedCount = clamped,
                    batchQuotes = QuoteCatalog.getBatch(
                        count = clamped,
                        school = current.selectedSchool,
                        randomOrder = current.batchOrder == BatchOrder.RANDOM
                    )
                )
            }
        } else {
            internalState.update { it.copy(countInputText = digitsOnly) }
        }
    }

    fun selectSchool(school: PhilosophicalSchool) {
        internalState.update { current ->
            val maxAvailable = maxAvailableFor(school)
            val clamped = current.selectedCount.coerceIn(1, maxAvailable)
            current.copy(
                selectedSchool = school,
                selectedCount = clamped,
                countInputText = clamped.toString(),
                batchQuotes = QuoteCatalog.getBatch(
                    count = clamped,
                    school = school,
                    randomOrder = current.batchOrder == BatchOrder.RANDOM
                )
            )
        }
    }

    fun setBatchOrder(order: BatchOrder) {
        internalState.update { current ->
            current.copy(
                batchOrder = order,
                batchQuotes = QuoteCatalog.getBatch(
                    count = current.selectedCount,
                    school = current.selectedSchool,
                    randomOrder = order == BatchOrder.RANDOM
                )
            )
        }
    }

    fun regenerateBatch() {
        internalState.update { current ->
            current.copy(
                batchOrder = BatchOrder.RANDOM,
                batchQuotes = QuoteCatalog.getBatch(
                    count = current.selectedCount,
                    school = current.selectedSchool,
                    randomOrder = true
                )
            )
        }
    }

    fun toggleFavorite(quoteId: Int) {
        viewModelScope.launch {
            repository.toggleFavorite(quoteId)
        }
    }

    fun toggleTheme(currentlyDark: Boolean) {
        viewModelScope.launch {
            repository.setDarkMode(!currentlyDark)
        }
    }

    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            repository.setDarkMode(enabled)
        }
    }

    fun toggleTranslationPanel(quote: PhilosophicalQuote) {
        val current = internalState.value.translationsByQuote[quote.id]
        if (current?.isExpanded == true) {
            internalState.update { state ->
                state.copy(
                    translationsByQuote = state.translationsByQuote + (
                        quote.id to current.copy(isExpanded = false)
                    )
                )
            }
        } else {
            val offlineTranslation = current?.translation ?: translationRepository.translateQuote(quote)
            internalState.update { state ->
                state.copy(
                    translationsByQuote = state.translationsByQuote + (
                        quote.id to QuoteTranslationState(
                            isExpanded = true,
                            translation = offlineTranslation
                        )
                    )
                )
            }
        }
    }

    fun openExplanationEditor(quote: PhilosophicalQuote) {
        internalState.update { it.copy(editingExplanationQuote = quote) }
    }

    fun dismissExplanationEditor() {
        internalState.update { it.copy(editingExplanationQuote = null) }
    }

    fun saveExplanation(quoteId: Int, explanation: String) {
        viewModelScope.launch {
            repository.saveExplanation(quoteId, explanation)
            internalState.update { it.copy(editingExplanationQuote = null) }
        }
    }

    fun deleteExplanation(quoteId: Int) {
        viewModelScope.launch {
            repository.deleteExplanation(quoteId)
            internalState.update {
                if (it.editingExplanationQuote?.id == quoteId) {
                    it.copy(editingExplanationQuote = null)
                } else {
                    it
                }
            }
        }
    }

    private fun maxAvailableFor(school: PhilosophicalSchool): Int {
        return if (school == PhilosophicalSchool.ALL) {
            QuoteCatalog.totalCount
        } else {
            QuoteCatalog.quotes.count { it.school == school }.coerceAtLeast(1)
        }
    }

    private fun normalizeDigits(input: String): String {
        val sb = StringBuilder(input.length)
        for (ch in input) {
            when (ch) {
                in '٠'..'٩' -> sb.append((ch - '٠' + '0'.code).toChar())
                in '۰'..'۹' -> sb.append((ch - '۰' + '0'.code).toChar())
                else -> sb.append(ch)
            }
        }
        return sb.toString()
    }

    private fun buildTimeSnapshot(calendar: Calendar): TimeQuoteSnapshot {
        val dateFormatter = SimpleDateFormat("EEEE، d MMMM yyyy", Locale("ar"))
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        val remainingSeconds = ((59 - minute) * 60 + (60 - second)).coerceIn(0, 3599)
        val remMin = remainingSeconds / 60
        val remSec = remainingSeconds % 60
        val hourWindow = String.format(Locale.US, "%02d:00 – %02d:59", hour, hour)
        val countdown = String.format(Locale.US, "%02d:%02d", remMin, remSec)

        return TimeQuoteSnapshot(
            dailyQuote = QuoteCatalog.getDailyQuote(calendar),
            hourlyQuote = QuoteCatalog.getHourlyQuote(calendar),
            dailyDateLabel = dateFormatter.format(calendar.time),
            hourlyWindowText = hourWindow,
            countdownText = countdown
        )
    }
}
