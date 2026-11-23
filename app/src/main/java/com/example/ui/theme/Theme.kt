package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val HikmaDarkColorScheme = darkColorScheme(
    primary = LuminousGoldPrimary,
    onPrimary = OnGoldDark,
    primaryContainer = GoldContainerDark,
    onPrimaryContainer = OnGoldContainerDark,
    secondary = SoftBronzeSecondary,
    onSecondary = Color(0xFF282016),
    secondaryContainer = BronzeContainerDark,
    onSecondaryContainer = Color(0xFFEFE1CC),
    tertiary = MintSageTertiary,
    onTertiary = Color(0xFF0E2B23),
    tertiaryContainer = SageContainerDark,
    onTertiaryContainer = Color(0xFFC0EBE0),
    background = ObsidianBackground,
    onBackground = WarmParchmentText,
    surface = MidnightSlateSurface,
    onSurface = WarmParchmentText,
    surfaceVariant = CharcoalElevatedSurface,
    onSurfaceVariant = MutedSilverText,
    surfaceContainerLow = MidnightSlateSurface,
    surfaceContainer = CharcoalElevatedSurface,
    surfaceContainerHigh = Color(0xFF2A2F3D),
    outline = ObsidianOutline,
    outlineVariant = ObsidianOutlineVariant
)

private val HikmaLightColorScheme = lightColorScheme(
    primary = AntiqueGoldPrimary,
    onPrimary = Color.White,
    primaryContainer = GoldContainerLight,
    onPrimaryContainer = OnGoldContainerLight,
    secondary = BronzeSecondary,
    onSecondary = Color.White,
    secondaryContainer = BronzeContainerLight,
    onSecondaryContainer = Color(0xFF2B2114),
    tertiary = SageTertiary,
    onTertiary = Color.White,
    tertiaryContainer = SageContainerLight,
    onTertiaryContainer = Color(0xFF0E2B23),
    background = ParchmentBackground,
    onBackground = DeepIndigoInk,
    surface = IvorySurface,
    onSurface = DeepIndigoInk,
    surfaceVariant = WarmSandContainer,
    onSurfaceVariant = SlateMutedInk,
    surfaceContainerLow = IvorySurface,
    surfaceContainer = WarmSandContainer,
    surfaceContainerHigh = Color(0xFFEBE1CC),
    outline = ParchmentOutline,
    outlineVariant = ParchmentOutlineVariant
)

val HikmaShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

@Composable
fun HikmaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) HikmaDarkColorScheme else HikmaLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = HikmaTypography,
        shapes = HikmaShapes,
        content = content
    )
}
