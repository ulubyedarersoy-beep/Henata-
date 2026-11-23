package com.example.data

import com.example.model.PhilosophicalQuote
import com.example.model.PhilosophicalSchool
import java.util.Calendar

object QuoteCatalog {

    val quotes: List<PhilosophicalQuote> =
        QuoteCatalogPart1.quotes +
            QuoteCatalogPart2.quotes +
            QuoteCatalogPart3.quotes +
            QuoteCatalogPart4.quotes +
            QuoteCatalogPart5.quotes +
            QuoteCatalogPart6.quotes +
            QuoteCatalogPart7.quotes +
            QuoteCatalogPart8.quotes

    val totalCount: Int = quotes.size

    fun getByNumber(number: Int): PhilosophicalQuote {
        val safeIndex = (number - 1).coerceIn(0, quotes.lastIndex)
        return quotes[safeIndex]
    }

    fun getBatch(
        count: Int,
        school: PhilosophicalSchool,
        randomOrder: Boolean
    ): List<PhilosophicalQuote> {
        val filtered = if (school == PhilosophicalSchool.ALL) {
            quotes
        } else {
            quotes.filter { it.school == school }
        }
        val pool = if (randomOrder) filtered.shuffled() else filtered
        return pool.take(count.coerceIn(1, pool.size.coerceAtLeast(1)))
    }

    fun getQuoteCountForPhilosopher(philosopherName: String): Int {
        return quotes.count { it.philosopher == philosopherName }
    }

    fun getDailyQuote(calendar: Calendar = Calendar.getInstance()): PhilosophicalQuote {
        val year = calendar.get(Calendar.YEAR)
        val dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)
        val daySerial = year * 366 + dayOfYear
        // Coprime stride (137) with 400 ensures unique daily cycling across all 400 quotes
        val index = ((daySerial * 137 + 29) % totalCount + totalCount) % totalCount
        return quotes[index]
    }

    fun getHourlyQuote(calendar: Calendar = Calendar.getInstance()): PhilosophicalQuote {
        val year = calendar.get(Calendar.YEAR)
        val dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val hourSerial = (year * 366L + dayOfYear) * 24L + hourOfDay
        val dailyId = getDailyQuote(calendar).id
        // Coprime stride (173) with 400 ensures unique hourly rotation
        var index = (((hourSerial * 173L + 61L) % totalCount).toInt() + totalCount) % totalCount
        if (quotes[index].id == dailyId && totalCount > 1) {
            index = (index + 1) % totalCount
        }
        return quotes[index]
    }
}
