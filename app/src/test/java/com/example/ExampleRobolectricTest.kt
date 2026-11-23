package com.example

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.test.core.app.ApplicationProvider
import com.example.data.QuoteCatalog
import com.example.ui.buildShareQuoteIntent
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("حِكمة", appName)
    }

    @Test
    fun `app declares no internet permissions for full offline operation`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val packageInfo = context.packageManager.getPackageInfo(
            context.packageName,
            PackageManager.GET_PERMISSIONS
        )
        val requested = packageInfo.requestedPermissions?.toList().orEmpty()
        assertFalse(requested.contains(Manifest.permission.INTERNET))
        assertFalse(requested.contains(Manifest.permission.ACCESS_NETWORK_STATE))
    }

    @Test
    fun `buildShareQuoteIntent creates ACTION_CHOOSER wrapping ACTION_SEND with quote text`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val quote = QuoteCatalog.getByNumber(1)
        val chooserTitle = context.getString(R.string.share_chooser_title)

        val chooserIntent = buildShareQuoteIntent(quote, chooserTitle)
        assertEquals(Intent.ACTION_CHOOSER, chooserIntent.action)
        assertEquals(chooserTitle, chooserIntent.getStringExtra(Intent.EXTRA_TITLE))

        @Suppress("DEPRECATION")
        val targetIntent = chooserIntent.getParcelableExtra<Intent>(Intent.EXTRA_INTENT)
        assertNotNull(targetIntent)
        assertEquals(Intent.ACTION_SEND, targetIntent?.action)
        assertEquals("text/plain", targetIntent?.type)

        val sharedText = targetIntent?.getStringExtra(Intent.EXTRA_TEXT).orEmpty()
        assertTrue(sharedText.contains(quote.text))
        assertTrue(sharedText.contains(quote.philosopher))
    }
}
