package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.hikmaDataStore: DataStore<Preferences> by preferencesDataStore(name = "hikma_prefs")

class FavoritesRepository(private val context: Context) {

    private val favoriteIdsKey = stringSetPreferencesKey("favorite_quote_ids")
    private val darkModeOverrideKey = booleanPreferencesKey("dark_mode_override")

    val favoriteIds: Flow<Set<Int>> = context.hikmaDataStore.data.map { prefs ->
        prefs[favoriteIdsKey]
            ?.mapNotNull { it.toIntOrNull() }
            ?.toSet()
            ?: emptySet()
    }

    val darkModeOverride: Flow<Boolean?> = context.hikmaDataStore.data.map { prefs ->
        prefs[darkModeOverrideKey]
    }

    val customExplanations: Flow<Map<Int, String>> = context.hikmaDataStore.data.map { prefs ->
        buildMap {
            for ((key, value) in prefs.asMap()) {
                if (key.name.startsWith(EXPLANATION_KEY_PREFIX) && value is String) {
                    val quoteId = key.name.removePrefix(EXPLANATION_KEY_PREFIX).toIntOrNull()
                    if (quoteId != null && value.isNotBlank()) {
                        put(quoteId, value)
                    }
                }
            }
        }
    }

    suspend fun toggleFavorite(quoteId: Int) {
        context.hikmaDataStore.edit { prefs ->
            val current = prefs[favoriteIdsKey]?.toMutableSet() ?: mutableSetOf()
            val idString = quoteId.toString()
            if (current.contains(idString)) {
                current.remove(idString)
            } else {
                current.add(idString)
            }
            prefs[favoriteIdsKey] = current
        }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.hikmaDataStore.edit { prefs ->
            prefs[darkModeOverrideKey] = enabled
        }
    }

    suspend fun saveExplanation(quoteId: Int, explanation: String) {
        val key = stringPreferencesKey("$EXPLANATION_KEY_PREFIX$quoteId")
        val trimmed = explanation.trim()
        context.hikmaDataStore.edit { prefs ->
            if (trimmed.isEmpty()) {
                prefs.remove(key)
            } else {
                prefs[key] = trimmed
            }
        }
    }

    suspend fun deleteExplanation(quoteId: Int) {
        val key = stringPreferencesKey("$EXPLANATION_KEY_PREFIX$quoteId")
        context.hikmaDataStore.edit { prefs ->
            prefs.remove(key)
        }
    }

    companion object {
        private const val EXPLANATION_KEY_PREFIX = "explanation_"
    }
}
