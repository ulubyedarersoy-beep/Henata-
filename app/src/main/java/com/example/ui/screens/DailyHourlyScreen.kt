package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.PhilosophicalQuote
import com.example.ui.HikmaUiState
import com.example.ui.QuoteTranslationState
import com.example.ui.components.FeaturedQuoteCard

@Composable
fun DailyHourlyScreen(
    uiState: HikmaUiState,
    isDarkTheme: Boolean,
    onSetDarkMode: (Boolean) -> Unit,
    onToggleFavorite: (Int) -> Unit,
    onCopyQuote: (PhilosophicalQuote) -> Unit,
    onShareQuote: (PhilosophicalQuote) -> Unit,
    onToggleTranslation: (PhilosophicalQuote) -> Unit,
    onCopyTranslation: (String) -> Unit,
    onOpenExplanationEditor: (PhilosophicalQuote) -> Unit,
    onDeleteExplanation: (Int) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(contentPadding)
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.widthIn(max = 680.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Header
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = stringResource(R.string.tab_daily_hourly),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.daily_hourly_header_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Explicit Night Mode Switch Card
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ) {
                            Icon(
                                imageVector = if (isDarkTheme) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                                contentDescription = null,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Column {
                            Text(
                                text = stringResource(R.string.night_mode_label),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = stringResource(
                                    if (isDarkTheme) R.string.night_mode_label else R.string.day_mode_label
                                ),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = onSetDarkMode,
                        modifier = Modifier.testTag("daily_night_mode_switch")
                    )
                }
            }

            // Daily Quote Section ("حكمة اليوم")
            SectionBanner(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.WbSunny,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(22.dp)
                    )
                },
                title = stringResource(R.string.daily_quote_title),
                subtitle = stringResource(R.string.daily_quote_subtitle),
                badgeText = uiState.dailyDateLabel,
                modifier = Modifier.testTag("daily_quote_section_header")
            )

            FeaturedQuoteCard(
                quote = uiState.dailyQuote,
                isFavorite = uiState.favoriteIds.contains(uiState.dailyQuote.id),
                customExplanation = uiState.customExplanations[uiState.dailyQuote.id],
                translationState = uiState.translationsByQuote[uiState.dailyQuote.id] ?: QuoteTranslationState(),
                onToggleFavorite = { onToggleFavorite(uiState.dailyQuote.id) },
                onCopy = { onCopyQuote(uiState.dailyQuote) },
                onShare = { onShareQuote(uiState.dailyQuote) },
                onToggleTranslation = { onToggleTranslation(uiState.dailyQuote) },
                onCopyTranslation = onCopyTranslation,
                onOpenExplanationEditor = { onOpenExplanationEditor(uiState.dailyQuote) },
                onDeleteExplanation = { onDeleteExplanation(uiState.dailyQuote.id) },
                modifier = Modifier.testTag("daily_featured_quote_card")
            )

            // Hourly Quote Section ("حكمة الساعة")
            SectionBanner(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(22.dp)
                    )
                },
                title = stringResource(R.string.hourly_quote_title),
                subtitle = stringResource(R.string.hourly_quote_subtitle),
                badgeText = "${uiState.hourlyWindowText} • ${
                    stringResource(R.string.hourly_countdown_label, uiState.countdownText)
                }",
                modifier = Modifier.testTag("hourly_quote_section_header")
            )

            FeaturedQuoteCard(
                quote = uiState.hourlyQuote,
                isFavorite = uiState.favoriteIds.contains(uiState.hourlyQuote.id),
                customExplanation = uiState.customExplanations[uiState.hourlyQuote.id],
                translationState = uiState.translationsByQuote[uiState.hourlyQuote.id] ?: QuoteTranslationState(),
                onToggleFavorite = { onToggleFavorite(uiState.hourlyQuote.id) },
                onCopy = { onCopyQuote(uiState.hourlyQuote) },
                onShare = { onShareQuote(uiState.hourlyQuote) },
                onToggleTranslation = { onToggleTranslation(uiState.hourlyQuote) },
                onCopyTranslation = onCopyTranslation,
                onOpenExplanationEditor = { onOpenExplanationEditor(uiState.hourlyQuote) },
                onDeleteExplanation = { onDeleteExplanation(uiState.hourlyQuote.id) },
                modifier = Modifier.testTag("hourly_featured_quote_card")
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun SectionBanner(
    icon: @Composable () -> Unit,
    title: String,
    subtitle: String,
    badgeText: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                icon()
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            if (badgeText.isNotBlank()) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ) {
                    Text(
                        text = badgeText,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                    )
                }
            }
        }
    }
}
