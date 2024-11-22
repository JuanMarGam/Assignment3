package com.example.juanjosemarquezgamboa_comp304lab3_ex1.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun WeatherAppTheme(content: @Composable () -> Unit) {
    val orangeColors = lightColorScheme(
        primary = Color(0xFFFF9800), // Vibrant orange
        secondary = Color(0xFFFFC107), // Amber for secondary
        background = Color(0xFFFFF3E0), // Light orange tint
        surface = Color(0xFFFFE0B2), // Soft orange for surfaces
        onPrimary = Color.White, // White text on primary
        onSecondary = Color.Black, // Black text on secondary
        onBackground = Color.Black, // Black text on background
        onSurface = Color.Black // Black text on surface
    )

    MaterialTheme(
        colorScheme = orangeColors,
        typography = Typography(
            titleLarge = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            headlineMedium = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
            bodyLarge = TextStyle(fontSize = 16.sp),
            bodyMedium = TextStyle(fontSize = 14.sp),
        ),
        shapes = Shapes(
            medium = RoundedCornerShape(16.dp)
        ),
        content = content
    )
}