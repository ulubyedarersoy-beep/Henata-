package com.example

import com.example.data.OfflineTranslationRepository
import com.example.data.PhilosopherBioCatalog
import com.example.data.QuoteCatalog
import com.example.model.PhilosophicalSchool
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar

class ExampleUnitTest {

    @Test
    fun `catalog contains 400 unique numbered quotes with english translations`() {
        assertEquals(400, QuoteCatalog.totalCount)
        assertEquals((1..400).toList(), QuoteCatalog.quotes.map { it.id })
        assertEquals(400, QuoteCatalog.quotes.map { it.text }.toSet().size)
        assertTrue(QuoteCatalog.quotes.all { it.englishText.isNotBlank() })
    }

    @Test
    fun `catalog covers Islamic, Asian, and European philosophical schools`() {
        assertTrue(QuoteCatalog.quotes.any { it.school == PhilosophicalSchool.ISLAMIC })
        assertTrue(QuoteCatalog.quotes.any { it.school == PhilosophicalSchool.ASIAN })
        assertTrue(QuoteCatalog.quotes.any { it.school == PhilosophicalSchool.GREEK })
        assertTrue(QuoteCatalog.quotes.any { it.school == PhilosophicalSchool.STOIC })
        assertTrue(QuoteCatalog.quotes.any { it.school == PhilosophicalSchool.ENLIGHTENMENT })
        assertTrue(QuoteCatalog.quotes.any { it.school == PhilosophicalSchool.EXISTENTIAL })
    }

    @Test
    fun `getByNumber returns exact quote and clamps bounds`() {
        assertEquals(1, QuoteCatalog.getByNumber(1).id)
        assertEquals(142, QuoteCatalog.getByNumber(142).id)
        assertEquals(400, QuoteCatalog.getByNumber(400).id)
        assertEquals(1, QuoteCatalog.getByNumber(0).id)
        assertEquals(400, QuoteCatalog.getByNumber(999).id)
    }

    @Test
    fun `getBatch returns requested count and respects school filter`() {
        val twentyFiveQuotes = QuoteCatalog.getBatch(
            count = 25,
            school = PhilosophicalSchool.ALL,
            randomOrder = false
        )
        assertEquals(25, twentyFiveQuotes.size)
        assertEquals((1..25).toList(), twentyFiveQuotes.map { it.id })

        val asianTen = QuoteCatalog.getBatch(
            count = 10,
            school = PhilosophicalSchool.ASIAN,
            randomOrder = false
        )
        assertEquals(10, asianTen.size)
        assertTrue(asianTen.all { it.school == PhilosophicalSchool.ASIAN })
    }

    @Test
    fun `daily quote is deterministic per day and rotates across consecutive days`() {
        val dayOne = Calendar.getInstance().apply {
            set(2026, Calendar.NOVEMBER, 22, 10, 0, 0)
        }
        val dayOneLater = Calendar.getInstance().apply {
            set(2026, Calendar.NOVEMBER, 22, 22, 30, 0)
        }
        val dayTwo = Calendar.getInstance().apply {
            set(2026, Calendar.NOVEMBER, 23, 10, 0, 0)
        }

        assertEquals(QuoteCatalog.getDailyQuote(dayOne).id, QuoteCatalog.getDailyQuote(dayOneLater).id)
        assertNotEquals(QuoteCatalog.getDailyQuote(dayOne).id, QuoteCatalog.getDailyQuote(dayTwo).id)
    }

    @Test
    fun `hourly quote rotates per hour and differs from daily quote`() {
        val hourTen = Calendar.getInstance().apply {
            set(2026, Calendar.NOVEMBER, 22, 10, 15, 0)
        }
        val hourEleven = Calendar.getInstance().apply {
            set(2026, Calendar.NOVEMBER, 22, 11, 15, 0)
        }

        val daily = QuoteCatalog.getDailyQuote(hourTen)
        val hourlyTen = QuoteCatalog.getHourlyQuote(hourTen)
        val hourlyEleven = QuoteCatalog.getHourlyQuote(hourEleven)

        assertNotEquals(daily.id, hourlyTen.id)
        assertNotEquals(hourlyTen.id, hourlyEleven.id)
    }

    @Test
    fun `philosopher bios exist for every philosopher in catalog`() {
        val distinctPhilosophers = QuoteCatalog.quotes.map { it.philosopher }.distinct()
        distinctPhilosophers.forEach { name ->
            val bio = PhilosopherBioCatalog.getBio(name)
            assertEquals(name, bio.name)
            assertTrue(bio.englishName.isNotBlank())
            assertTrue(bio.summary.isNotBlank())
            assertTrue(QuoteCatalog.getQuoteCountForPhilosopher(name) >= 1)
        }
    }

    @Test
    fun `offline translation repository translates all 400 quotes without network`() {
        val repo = OfflineTranslationRepository()
        QuoteCatalog.quotes.forEach { quote ->
            val translation = repo.translateQuote(quote)
            assertEquals(quote.englishText, translation.quoteTextEnglish)
            assertTrue(translation.philosopherEnglish.isNotBlank())
            assertTrue(translation.schoolEnglish.isNotBlank())
            assertTrue(translation.formattedCopyText.contains(quote.englishText))
        }
    }
}
