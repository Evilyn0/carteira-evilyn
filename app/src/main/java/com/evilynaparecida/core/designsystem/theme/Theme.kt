package com.evilynaparecida.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkScheme = darkColorScheme(
    primary = RedPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF2B0003),
    onPrimaryContainer = Color.White,
    secondary = RedPrimary,
    onSecondary = Color.White,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = Color(0xFF1A1A1A),
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkCardBorder,
    outlineVariant = DarkCardBorder.copy(alpha = 0.5f),
    error = Color(0xFFFF5252)
)

private val lightScheme = lightColorScheme(
    primary = RedPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFEBEE),
    onPrimaryContainer = Color(0xFFB71C1C),
    secondary = RedPrimary,
    onSecondary = Color.White,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = Color(0xFFF2F2F2),
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightCardBorder,
    outlineVariant = LightCardBorder.copy(alpha = 0.5f),
    error = Color(0xFFB00020)
)

@Composable
fun EvilynAparecidaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkScheme else lightScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

@Composable
fun CarteirinhaDigital2DEVESTTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    EvilynAparecidaTheme(darkTheme = darkTheme, content = content)
}
