package com.example.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.OfflinePin
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Shuffle
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.PhilosophicalQuote
import com.example.ui.HikmaUiState
import com.example.ui.QuoteTranslationState
import com.example.ui.components.FeaturedQuoteCard
import kotlin.math.roundToInt

private val QuickPickNumbers = listOf(1, 25, 75, 125, 200, 275, 350, 400)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ByNumberScreen(
    uiState: HikmaUiState,
    totalQuoteCount: Int,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onOpenDailyHourlyTab: () -> Unit,
    onSelectNumber: (Int) -> Unit,
    onNumberInputChanged: (String) -> Unit,
    onSubmitNumberInput: () -> Unit,
    onStepNumber: (Int) -> Unit,
    onPickRandomNumber: () -> Unit,
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
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(contentPadding)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.widthIn(max = 680.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Atmospheric Hero Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(148.dp)
                    .clip(MaterialTheme.shapes.large)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_codex_header),
                    contentDescription = stringResource(R.string.app_subtitle),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF1A1D26).copy(alpha = 0.45f),
                                    Color(0xFF1A1D26).copy(alpha = 0.84f)
                                )
                            )
                        )
                )
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFF1A1D26).copy(alpha = 0.72f),
                    border = BorderStroke(1.dp, Color(0xFFE0B05C).copy(alpha = 0.45f)),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(14.dp)
                        .testTag("offline_ready_badge")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.OfflinePin,
                            contentDescription = null,
                            tint = Color(0xFFE0B05C),
                            modifier = Modifier.size(15.dp)
                        )
                        Text(
                            text = stringResource(R.string.offline_ready_badge),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFFAF6EE)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(18.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.displaySmall,
                            color = Color(0xFFFAF6EE),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.app_subtitle),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFE0B05C)
                        )
                    }

                    Surface(
                        onClick = onToggleTheme,
                        shape = RoundedCornerShape(50),
                        color = Color(0xFF1A1D26).copy(alpha = 0.72f),
                        border = BorderStroke(1.dp, Color(0xFFE0B05C).copy(alpha = 0.45f)),
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("theme_toggle_button")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = if (isDarkTheme) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                                contentDescription = stringResource(R.string.toggle_theme),
                                tint = Color(0xFFE0B05C),
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = stringResource(
                                    if (isDarkTheme) R.string.day_mode_label else R.string.night_mode_label
                                ),
                                style = MaterialTheme.typography.labelMedium,
                                color = Color(0xFFFAF6EE)
                            )
                        }
                    }
                }
            }

            // Quick Glimpse Pills for Daily & Hourly Quotes
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedCard(
                    onClick = onOpenDailyHourlyTab,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("home_daily_quote_shortcut"),
                    shape = MaterialTheme.shapes.medium,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.WbSunny,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                        Column {
                            Text(
                                text = stringResource(R.string.daily_quote_title),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "#${uiState.dailyQuote.id} • ${uiState.dailyQuote.philosopher}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                OutlinedCard(
                    onClick = onOpenDailyHourlyTab,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("home_hourly_quote_shortcut"),
                    shape = MaterialTheme.shapes.medium,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Schedule,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                        Column {
                            Text(
                                text = stringResource(R.string.hourly_quote_title),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "#${uiState.hourlyQuote.id} • ${uiState.countdownText}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            // Number Picker Codex Card
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
                        Column {
                            Text(
                                text = stringResource(R.string.tab_by_number),
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = stringResource(R.string.quote_range_hint, totalQuoteCount),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        FilledTonalButton(
                            onClick = {
                                focusManager.clearFocus()
                                onPickRandomNumber()
                            },
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .testTag("random_quote_button")
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Shuffle,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = stringResource(R.string.random_quote_btn))
                        }
                    }

                    // Giant Number Stepper Display
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            FilledIconButton(
                                onClick = {
                                    focusManager.clearFocus()
                                    onStepNumber(-1)
                                },
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                ),
                                modifier = Modifier
                                    .minimumInteractiveComponentSize()
                                    .testTag("previous_number_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Remove,
                                    contentDescription = stringResource(R.string.previous_quote)
                                )
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                AnimatedContent(
                                    targetState = uiState.selectedNumber,
                                    transitionSpec = {
                                        (slideInVertically(
                                            animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                                        ) { height -> -height / 3 } + fadeIn())
                                            .togetherWith(
                                                slideOutVertically { height -> height / 3 } + fadeOut()
                                            )
                                            .using(SizeTransform(clip = false))
                                    },
                                    label = "selected_number_anim"
                                ) { number ->
                                    Text(
                                        text = "#$number",
                                        style = MaterialTheme.typography.displayLarge,
                                        color = MaterialTheme.colorScheme.primary,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.testTag("selected_number_display")
                                    )
                                }
                                Text(
                                    text = stringResource(R.string.quote_number_label, uiState.selectedNumber),
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            FilledIconButton(
                                onClick = {
                                    focusManager.clearFocus()
                                    onStepNumber(1)
                                },
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                ),
                                modifier = Modifier
                                    .minimumInteractiveComponentSize()
                                    .testTag("next_number_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = stringResource(R.string.next_quote)
                                )
                            }
                        }
                    }

                    // Tactile Slider
                    Column {
                        Slider(
                            value = uiState.selectedNumber.toFloat(),
                            onValueChange = { value ->
                                focusManager.clearFocus()
                                onSelectNumber(value.roundToInt())
                            },
                            valueRange = 1f..totalQuoteCount.toFloat(),
                            steps = if (totalQuoteCount <= 40) (totalQuoteCount - 2).coerceAtLeast(0) else 0,
                            colors = SliderDefaults.colors(
                                thumbColor = MaterialTheme.colorScheme.primary,
                                activeTrackColor = MaterialTheme.colorScheme.primary,
                                inactiveTrackColor = MaterialTheme.colorScheme.outlineVariant
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("number_slider")
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "١",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "${totalQuoteCount / 2}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "$totalQuoteCount",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Direct Numeric Input Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedTextField(
                            value = uiState.numberInputText,
                            onValueChange = onNumberInputChanged,
                            label = { Text(stringResource(R.string.enter_number_label)) },
                            singleLine = true,
                            isError = uiState.numberInputError,
                            supportingText = if (uiState.numberInputError) {
                                {
                                    Text(
                                        text = stringResource(R.string.invalid_number_range, totalQuoteCount),
                                        color = MaterialTheme.colorScheme.error
                                    )
                                }
                            } else null,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    focusManager.clearFocus()
                                    onSubmitNumberInput()
                                }
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("direct_number_input")
                        )

                        Button(
                            onClick = {
                                focusManager.clearFocus()
                                onSubmitNumberInput()
                            },
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .height(52.dp)
                                .minimumInteractiveComponentSize()
                                .testTag("apply_number_button")
                        ) {
                            Text(text = stringResource(R.string.apply_number))
                        }
                    }

                    // Quick Numbers Chips
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = stringResource(R.string.quick_numbers_title),
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            QuickPickNumbers.forEach { num ->
                                val selected = uiState.selectedNumber == num
                                FilterChip(
                                    selected = selected,
                                    onClick = {
                                        focusManager.clearFocus()
                                        onSelectNumber(num)
                                    },
                                    label = {
                                        Text(
                                            text = "#$num",
                                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                        selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                                    ),
                                    modifier = Modifier
                                        .minimumInteractiveComponentSize()
                                        .testTag("quick_number_chip_$num")
                                )
                            }
                        }
                    }
                }
            }

            // Revealed Philosophical Quote Card
            AnimatedContent(
                targetState = uiState.currentQuote,
                transitionSpec = {
                    (fadeIn(animationSpec = spring(stiffness = Spring.StiffnessMediumLow)) +
                        slideInVertically { it / 12 })
                        .togetherWith(fadeOut())
                },
                label = "featured_quote_transition"
            ) { quote ->
                FeaturedQuoteCard(
                    quote = quote,
                    isFavorite = uiState.favoriteIds.contains(quote.id),
                    customExplanation = uiState.customExplanations[quote.id],
                    translationState = uiState.translationsByQuote[quote.id] ?: QuoteTranslationState(),
                    onToggleFavorite = { onToggleFavorite(quote.id) },
                    onCopy = { onCopyQuote(quote) },
                    onShare = { onShareQuote(quote) },
                    onToggleTranslation = { onToggleTranslation(quote) },
                    onCopyTranslation = onCopyTranslation,
                    onOpenExplanationEditor = { onOpenExplanationEditor(quote) },
                    onDeleteExplanation = { onDeleteExplanation(quote.id) }
                )
            }

            Spacer(modifier = Modifier.height(76.dp))
        }
    }
}
