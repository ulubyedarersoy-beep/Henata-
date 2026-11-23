package com.example.ui

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dialpad
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.outlined.Dialpad
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FormatListNumbered
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.R
import com.example.model.HikmaTab
import com.example.model.PhilosophicalQuote
import com.example.ui.screens.ByCountScreen
import com.example.ui.screens.ByNumberScreen
import com.example.ui.screens.DailyHourlyScreen
import com.example.ui.screens.FavoritesScreen
import com.example.ui.theme.HikmaTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HikmaApp(
    viewModel: HikmaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val systemDark = isSystemInDarkTheme()
    val isDark = uiState.darkModeOverride ?: systemDark

    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val copiedMessage = stringResource(R.string.copied_feedback)
    val translationCopiedMessage = stringResource(R.string.translation_copied_feedback)
    val shareChooserTitle = stringResource(R.string.share_chooser_title)
    val shareUnavailableMessage = stringResource(R.string.share_unavailable_feedback)
    val explanationSavedMessage = stringResource(R.string.explanation_saved_feedback)

    LaunchedEffect(Unit) {
        while (true) {
            viewModel.refreshTimeBasedQuotes()
            delay(1_000L)
        }
    }

    val copyQuote: (PhilosophicalQuote) -> Unit = { quote ->
        val customNote = uiState.customExplanations[quote.id]
        val formatted = buildString {
            append("«${quote.text}»\n— ${quote.philosopher} (#${quote.id})")
            if (!customNote.isNullOrBlank()) {
                append("\n\nشرحي: $customNote")
            }
        }
        clipboardManager.setText(AnnotatedString(formatted))
        scope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()
            snackbarHostState.showSnackbar(copiedMessage)
        }
    }

    val copyTranslation: (String) -> Unit = { formattedTranslation ->
        clipboardManager.setText(AnnotatedString(formattedTranslation))
        scope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()
            snackbarHostState.showSnackbar(translationCopiedMessage)
        }
    }

    val shareQuote: (PhilosophicalQuote) -> Unit = { quote ->
        val chooserIntent = buildShareQuoteIntent(
            quote = quote,
            chooserTitle = shareChooserTitle,
            customExplanation = uiState.customExplanations[quote.id]
        ).apply {
            if (context !is Activity) {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        }
        try {
            context.startActivity(chooserIntent)
        } catch (_: ActivityNotFoundException) {
            scope.launch {
                snackbarHostState.currentSnackbarData?.dismiss()
                snackbarHostState.showSnackbar(shareUnavailableMessage)
            }
        }
    }

    BackHandler(enabled = uiState.selectedTab != HikmaTab.BY_NUMBER) {
        viewModel.selectTab(HikmaTab.BY_NUMBER)
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HikmaTheme(darkTheme = isDark) {
            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                val isWideScreen = maxWidth >= 600.dp

                if (isWideScreen) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.background,
                        contentWindowInsets = WindowInsets.safeDrawing,
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        floatingActionButton = {
                            if (uiState.selectedTab == HikmaTab.BY_NUMBER) {
                                ShareQuoteFab(
                                    onClick = { shareQuote(uiState.currentQuote) }
                                )
                            }
                        }
                    ) { innerPadding ->
                        Row(modifier = Modifier.fillMaxSize()) {
                            NavigationRail(
                                containerColor = MaterialTheme.colorScheme.surface,
                                modifier = Modifier.statusBarsPadding()
                            ) {
                                Spacer(modifier = Modifier.weight(1f))
                                HikmaTab.entries.forEach { tab ->
                                    val selected = uiState.selectedTab == tab
                                    NavigationRailItem(
                                        selected = selected,
                                        onClick = { viewModel.selectTab(tab) },
                                        icon = {
                                            TabIcon(
                                                tab = tab,
                                                selected = selected,
                                                favoritesCount = uiState.favoriteQuotes.size
                                            )
                                        },
                                        label = {
                                            Text(
                                                text = tabLabel(tab),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        },
                                        modifier = Modifier.testTag("nav_rail_${tab.name}")
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                            }

                            HikmaTabContent(
                                uiState = uiState,
                                totalQuoteCount = viewModel.totalQuoteCount,
                                isWideLayout = true,
                                isDarkTheme = isDark,
                                viewModel = viewModel,
                                onCopyQuote = copyQuote,
                                onCopyTranslation = copyTranslation,
                                onShareQuote = shareQuote,
                                contentPadding = innerPadding,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                } else {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.background,
                        contentWindowInsets = WindowInsets.safeDrawing,
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        floatingActionButton = {
                            if (uiState.selectedTab == HikmaTab.BY_NUMBER) {
                                ShareQuoteFab(
                                    onClick = { shareQuote(uiState.currentQuote) }
                                )
                            }
                        },
                        bottomBar = {
                            NavigationBar(
                                containerColor = MaterialTheme.colorScheme.surface,
                                windowInsets = WindowInsets.navigationBars
                            ) {
                                HikmaTab.entries.forEach { tab ->
                                    val selected = uiState.selectedTab == tab
                                    NavigationBarItem(
                                        selected = selected,
                                        onClick = { viewModel.selectTab(tab) },
                                        icon = {
                                            TabIcon(
                                                tab = tab,
                                                selected = selected,
                                                favoritesCount = uiState.favoriteQuotes.size
                                            )
                                        },
                                        label = {
                                            Text(
                                                text = tabLabel(tab),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        },
                                        modifier = Modifier.testTag("nav_bar_${tab.name}")
                                    )
                                }
                            }
                        }
                    ) { innerPadding ->
                        HikmaTabContent(
                            uiState = uiState,
                            totalQuoteCount = viewModel.totalQuoteCount,
                            isWideLayout = false,
                            isDarkTheme = isDark,
                            viewModel = viewModel,
                            onCopyQuote = copyQuote,
                            onCopyTranslation = copyTranslation,
                            onShareQuote = shareQuote,
                            contentPadding = innerPadding,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            uiState.editingExplanationQuote?.let { editingQuote ->
                ExplanationEditorDialog(
                    quote = editingQuote,
                    initialExplanation = uiState.customExplanations[editingQuote.id].orEmpty(),
                    onDismiss = viewModel::dismissExplanationEditor,
                    onSave = { explanationText ->
                        viewModel.saveExplanation(editingQuote.id, explanationText)
                        if (explanationText.isNotBlank()) {
                            scope.launch {
                                snackbarHostState.currentSnackbarData?.dismiss()
                                snackbarHostState.showSnackbar(explanationSavedMessage)
                            }
                        }
                    },
                    onDelete = {
                        viewModel.deleteExplanation(editingQuote.id)
                    }
                )
            }
        }
    }
}

@Composable
private fun HikmaTabContent(
    uiState: HikmaUiState,
    totalQuoteCount: Int,
    isWideLayout: Boolean,
    isDarkTheme: Boolean,
    viewModel: HikmaViewModel,
    onCopyQuote: (PhilosophicalQuote) -> Unit,
    onCopyTranslation: (String) -> Unit,
    onShareQuote: (PhilosophicalQuote) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    when (uiState.selectedTab) {
        HikmaTab.BY_NUMBER -> ByNumberScreen(
            uiState = uiState,
            totalQuoteCount = totalQuoteCount,
            isDarkTheme = isDarkTheme,
            onToggleTheme = { viewModel.toggleTheme(isDarkTheme) },
            onOpenDailyHourlyTab = { viewModel.selectTab(HikmaTab.DAILY_HOURLY) },
            onSelectNumber = { viewModel.selectNumber(it) },
            onNumberInputChanged = viewModel::onNumberInputChanged,
            onSubmitNumberInput = viewModel::submitNumberInput,
            onStepNumber = viewModel::stepNumber,
            onPickRandomNumber = viewModel::pickRandomNumber,
            onToggleFavorite = viewModel::toggleFavorite,
            onCopyQuote = onCopyQuote,
            onShareQuote = onShareQuote,
            onToggleTranslation = viewModel::toggleTranslationPanel,
            onCopyTranslation = onCopyTranslation,
            onOpenExplanationEditor = viewModel::openExplanationEditor,
            onDeleteExplanation = viewModel::deleteExplanation,
            contentPadding = contentPadding,
            modifier = modifier
        )

        HikmaTab.DAILY_HOURLY -> DailyHourlyScreen(
            uiState = uiState,
            isDarkTheme = isDarkTheme,
            onSetDarkMode = viewModel::setDarkMode,
            onToggleFavorite = viewModel::toggleFavorite,
            onCopyQuote = onCopyQuote,
            onShareQuote = onShareQuote,
            onToggleTranslation = viewModel::toggleTranslationPanel,
            onCopyTranslation = onCopyTranslation,
            onOpenExplanationEditor = viewModel::openExplanationEditor,
            onDeleteExplanation = viewModel::deleteExplanation,
            contentPadding = contentPadding,
            modifier = modifier
        )

        HikmaTab.BY_COUNT -> ByCountScreen(
            uiState = uiState,
            isWideLayout = isWideLayout,
            isDarkTheme = isDarkTheme,
            onToggleTheme = { viewModel.toggleTheme(isDarkTheme) },
            onSelectCount = viewModel::selectCount,
            onCountInputChanged = viewModel::onCountInputChanged,
            onSelectSchool = viewModel::selectSchool,
            onSetBatchOrder = viewModel::setBatchOrder,
            onRegenerateBatch = viewModel::regenerateBatch,
            onToggleFavorite = viewModel::toggleFavorite,
            onCopyQuote = onCopyQuote,
            onShareQuote = onShareQuote,
            onOpenInNumberView = { quoteId -> viewModel.selectNumber(quoteId, switchToNumberTab = true) },
            onToggleTranslation = viewModel::toggleTranslationPanel,
            onCopyTranslation = onCopyTranslation,
            onOpenExplanationEditor = viewModel::openExplanationEditor,
            onDeleteExplanation = viewModel::deleteExplanation,
            contentPadding = contentPadding,
            modifier = modifier
        )

        HikmaTab.FAVORITES -> FavoritesScreen(
            uiState = uiState,
            isWideLayout = isWideLayout,
            onToggleFavorite = viewModel::toggleFavorite,
            onCopyQuote = onCopyQuote,
            onShareQuote = onShareQuote,
            onOpenInNumberView = { quoteId -> viewModel.selectNumber(quoteId, switchToNumberTab = true) },
            onToggleTranslation = viewModel::toggleTranslationPanel,
            onCopyTranslation = onCopyTranslation,
            onOpenExplanationEditor = viewModel::openExplanationEditor,
            onDeleteExplanation = viewModel::deleteExplanation,
            onExploreClick = { viewModel.selectTab(HikmaTab.BY_NUMBER) },
            contentPadding = contentPadding,
            modifier = modifier
        )
    }
}

@Composable
private fun ExplanationEditorDialog(
    quote: PhilosophicalQuote,
    initialExplanation: String,
    onDismiss: () -> Unit,
    onSave: (String) -> Unit,
    onDelete: () -> Unit
) {
    var text by remember(quote.id, initialExplanation) { mutableStateOf(initialExplanation) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.explanation_dialog_title),
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "«${quote.text}» — ${quote.philosopher}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text(stringResource(R.string.explanation_input_hint)) },
                    minLines = 3,
                    maxLines = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("explanation_dialog_input")
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onSave(text) },
                modifier = Modifier.testTag("explanation_dialog_save")
            ) {
                Text(text = stringResource(R.string.save_btn))
            }
        },
        dismissButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                if (initialExplanation.isNotBlank()) {
                    TextButton(
                        onClick = onDelete,
                        modifier = Modifier.testTag("explanation_dialog_delete")
                    ) {
                        Text(
                            text = stringResource(R.string.delete_explanation_btn),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.testTag("explanation_dialog_cancel")
                ) {
                    Text(text = stringResource(R.string.cancel_btn))
                }
            }
        }
    )
}

@Composable
private fun TabIcon(
    tab: HikmaTab,
    selected: Boolean,
    favoritesCount: Int
) {
    val icon = when (tab) {
        HikmaTab.BY_NUMBER -> if (selected) Icons.Filled.Dialpad else Icons.Outlined.Dialpad
        HikmaTab.DAILY_HOURLY -> if (selected) Icons.Filled.Today else Icons.Outlined.Today
        HikmaTab.BY_COUNT -> if (selected) Icons.Filled.FormatListNumbered else Icons.Outlined.FormatListNumbered
        HikmaTab.FAVORITES -> if (selected) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
    }

    if (tab == HikmaTab.FAVORITES && favoritesCount > 0) {
        BadgedBox(
            badge = {
                Badge {
                    Text(text = favoritesCount.toString())
                }
            }
        ) {
            Icon(imageVector = icon, contentDescription = tabLabel(tab))
        }
    } else {
        Icon(imageVector = icon, contentDescription = tabLabel(tab))
    }
}

@Composable
private fun tabLabel(tab: HikmaTab): String {
    return when (tab) {
        HikmaTab.BY_NUMBER -> stringResource(R.string.tab_by_number)
        HikmaTab.DAILY_HOURLY -> stringResource(R.string.tab_daily_hourly)
        HikmaTab.BY_COUNT -> stringResource(R.string.tab_by_count)
        HikmaTab.FAVORITES -> stringResource(R.string.tab_favorites)
    }
}

@Composable
private fun ShareQuoteFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null
            )
        },
        text = { Text(text = stringResource(R.string.share_quote)) },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier.testTag("share_current_quote_fab")
    )
}

fun buildShareQuoteIntent(
    quote: PhilosophicalQuote,
    chooserTitle: String,
    customExplanation: String? = null
): Intent {
    val formatted = buildString {
        append("«${quote.text}»\n— ${quote.philosopher} (${quote.school.arabicLabel})\n\n${quote.reflection}")
        if (!customExplanation.isNullOrBlank()) {
            append("\n\nشرحي: $customExplanation")
        }
        append("\n\n#حِكمة #${quote.id}")
    }
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "حِكمة — ${quote.philosopher}")
        putExtra(Intent.EXTRA_TEXT, formatted)
    }
    return Intent.createChooser(sendIntent, chooserTitle)
}
