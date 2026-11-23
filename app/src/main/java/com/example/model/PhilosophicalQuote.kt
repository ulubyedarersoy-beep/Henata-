package com.example.model

enum class PhilosophicalSchool(val arabicLabel: String, val englishLabel: String) {
    ALL("جميع المدارس", "All Schools"),
    ISLAMIC("الفلسفة الإسلامية", "Islamic Philosophy"),
    GREEK("الفلسفة اليونانية", "Greek Philosophy"),
    STOIC("المدرسة الرواقية", "Stoicism"),
    ENLIGHTENMENT("فلسفة التنوير", "Enlightenment"),
    EXISTENTIAL("الفلسفة الوجودية", "Existentialism"),
    ASIAN("الفلسفة الآسيوية", "Asian Philosophy")
}

data class PhilosophicalQuote(
    val id: Int,
    val text: String,
    val englishText: String = "",
    val philosopher: String,
    val school: PhilosophicalSchool,
    val era: String,
    val reflection: String
)

data class PhilosopherBio(
    val name: String,
    val englishName: String,
    val roleTitle: String,
    val originAndEra: String,
    val school: PhilosophicalSchool,
    val summary: String
)

enum class HikmaTab {
    BY_NUMBER,
    DAILY_HOURLY,
    BY_COUNT,
    FAVORITES
}

enum class BatchOrder(val arabicLabel: String) {
    SEQUENTIAL("بالترتيب"),
    RANDOM("عشوائي")
}
