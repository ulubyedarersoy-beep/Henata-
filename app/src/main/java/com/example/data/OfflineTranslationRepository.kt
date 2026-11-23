package com.example.data

import com.example.model.PhilosophicalQuote

data class OfflineTranslation(
    val quoteTextEnglish: String,
    val philosopherEnglish: String,
    val schoolEnglish: String,
    val formattedCopyText: String
)

class OfflineTranslationRepository {
    fun translateQuote(quote: PhilosophicalQuote): OfflineTranslation {
        val bio = PhilosopherBioCatalog.getBio(quote.philosopher)
        val formatted = buildString {
            append("\"${quote.englishText}\"")
            append("\n— ${bio.englishName} (${quote.school.englishLabel})")
        }
        return OfflineTranslation(
            quoteTextEnglish = quote.englishText,
            philosopherEnglish = bio.englishName,
            schoolEnglish = quote.school.englishLabel,
            formattedCopyText = formatted
        )
    }
}
