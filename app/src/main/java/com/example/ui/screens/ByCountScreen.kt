package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.BatchOrder
import com.example.model.PhilosophicalQuote
import com.example.model.PhilosophicalSchool
import com.example.ui.HikmaUiState
import com.example.ui.QuoteTranslationState
import com.example.ui.components.CompactQuoteCard
import kotlin.math.roundToInt

private val QuickCounts = listOf(1, 3, 5, 10, 15, 25, 50, 100)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ByCountScreen(
    uiState: HikmaUiState,
    isWideLayout: Boolean,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onSelectCount: (Int) -> Unit,
    onCountInputChanged: (String) -> Unit,
    onSelectSchool: (PhilosophicalSchool) -> Unit,
    onSetBatchOrder: (BatchOrder) -> Unit,
    onRegenerateBatch: () -> Unit,
    onToggleFavorite: (Int) -> Unit,
    onCopyQuote: (PhilosophicalQuote) -> Unit,
    onShareQuote: (PhilosophicalQuote) -> Unit,
    onOpenInNumberView: (Int) -> Unit,
    onToggleTranslation: (PhilosophicalQuote) -> Unit,
    onCopyTranslation: (String) -> Unit,
    onOpenExplanationEditor: (PhilosophicalQuote) -> Unit,
    onDeleteExplanation: (Int) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val columns = if (isWideLayout) 2 else 1

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item(span = { GridItemSpan(columns) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 860.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Header Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(R.string.tab_by_count),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.count_selector_title),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    FilterChip(
                        selected = isDarkTheme,
                        onClick = onToggleTheme,
                        leadingIcon = {
                            Icon(
                                imageVector = if (isDarkTheme) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                                contentDescription = stringResource(R.string.toggle_theme),
                                modifier = Modifier.size(18.dp)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(
                                    if (isDarkTheme) R.string.day_mode_label else R.string.night_mode_label
                                )
                            )
                        },
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("count_theme_toggle_button")
                    )
                }

                // Count Picker Card
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Surface(
                                shape = MaterialTheme.shapes.small,
                                color = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ) {
                                Text(
                                    text = stringResource(R.string.count_selected_label, uiState.batchQuotes.size),
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                        .testTag("count_summary_badge")
                                )
                            }

                            FilledTonalButton(
                                onClick = onRegenerateBatch,
                                modifier = Modifier
                                    .minimumInteractiveComponentSize()
                                    .testTag("regenerate_batch_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Refresh,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(text = stringResource(R.string.regenerate_batch))
                            }
                        }

                        // Quick Count Chips
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            QuickCounts.filter { it <= uiState.maxCountForSchool }.forEach { count ->
                                val selected = uiState.selectedCount == count
                                FilterChip(
                                    selected = selected,
                                    onClick = { onSelectCount(count) },
                                    label = {
                                        Text(
                                            text = "$count",
                                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                                    ),
                                    modifier = Modifier
                                        .minimumInteractiveComponentSize()
                                        .testTag("quick_count_chip_$count")
                                )
                            }
                        }

                        // Slider + Custom Count Field
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            val maxSlider = uiState.maxCountForSchool.coerceAtLeast(2).toFloat()
                            Slider(
                                value = uiState.selectedCount.toFloat().coerceIn(1f, maxSlider),
                                onValueChange = { onSelectCount(it.roundToInt()) },
                                valueRange = 1f..maxSlider,
                                steps = if (uiState.maxCountForSchool <= 25) (uiState.maxCountForSchool - 2).coerceAtLeast(0) else 0,
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("count_slider")
                            )

                            OutlinedTextField(
                                value = uiState.countInputText,
                                onValueChange = onCountInputChanged,
                                label = {
                                    Text(
                                        text = stringResource(
                                            R.string.custom_count_hint,
                                            uiState.maxCountForSchool
                                        ),
                                        maxLines = 1
                                    )
                                },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier
                                    .width(124.dp)
                                    .testTag("custom_count_input")
                            )
                        }

                        // Order Selection (Sequential vs Random)
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BatchOrder.entries.forEach { order ->
                                val isSelected = uiState.batchOrder == order
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { onSetBatchOrder(order) },
                                    label = { Text(text = order.arabicLabel) },
                                    modifier = Modifier
                                        .minimumInteractiveComponentSize()
                                        .testTag("batch_order_${order.name}")
                                )
                            }
                        }

                        // School Filter Row
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(PhilosophicalSchool.entries) { school ->
                                val isSelected = uiState.selectedSchool == school
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { onSelectSchool(school) },
                                    label = { Text(text = school.arabicLabel) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                                        selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer
                                    ),
                                    modifier = Modifier
                                        .minimumInteractiveComponentSize()
                                        .testTag("school_chip_${school.name}")
                                )
                            }
                        }
                    }
                }
            }
        }

        itemsIndexed(
            items = uiState.batchQuotes,
            key = { _, quote -> quote.id }
        ) { index, quote ->
            CompactQuoteCard(
                quote = quote,
                positionInList = index + 1,
                isFavorite = uiState.favoriteIds.contains(quote.id),
                customExplanation = uiState.customExplanations[quote.id],
                translationState = uiState.translationsByQuote[quote.id] ?: QuoteTranslationState(),
                onToggleFavorite = { onToggleFavorite(quote.id) },
                onCopy = { onCopyQuote(quote) },
                onShare = { onShareQuote(quote) },
                onOpenInNumberView = { onOpenInNumberView(quote.id) },
                onToggleTranslation = { onToggleTranslation(quote) },
                onCopyTranslation = onCopyTranslation,
                onOpenExplanationEditor = { onOpenExplanationEditor(quote) },
                onDeleteExplanation = { onDeleteExplanation(quote.id) }
            )
        }

        item(span = { GridItemSpan(columns) }) {
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
