package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.PhilosophicalQuote
import com.example.ui.HikmaUiState
import com.example.ui.QuoteTranslationState
import com.example.ui.components.CompactQuoteCard

@Composable
fun FavoritesScreen(
    uiState: HikmaUiState,
    isWideLayout: Boolean,
    onToggleFavorite: (Int) -> Unit,
    onCopyQuote: (PhilosophicalQuote) -> Unit,
    onShareQuote: (PhilosophicalQuote) -> Unit,
    onOpenInNumberView: (Int) -> Unit,
    onToggleTranslation: (PhilosophicalQuote) -> Unit,
    onCopyTranslation: (String) -> Unit,
    onOpenExplanationEditor: (PhilosophicalQuote) -> Unit,
    onDeleteExplanation: (Int) -> Unit,
    onExploreClick: () -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    if (uiState.favoriteQuotes.isEmpty()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.widthIn(max = 420.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_favorites_empty),
                    contentDescription = stringResource(R.string.favorites_empty_title),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                        .clip(MaterialTheme.shapes.large)
                )

                Text(
                    text = stringResource(R.string.favorites_empty_title),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.favorites_empty_desc),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Button(
                    onClick = onExploreClick,
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("explore_quotes_button")
                ) {
                    Text(text = stringResource(R.string.explore_quotes_btn))
                }
            }
        }
        return
    }

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
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.tab_favorites),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )

                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ) {
                    Text(
                        text = "${uiState.favoriteQuotes.size}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }

        itemsIndexed(
            items = uiState.favoriteQuotes,
            key = { _, quote -> quote.id }
        ) { index, quote ->
            CompactQuoteCard(
                quote = quote,
                positionInList = index + 1,
                isFavorite = true,
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
