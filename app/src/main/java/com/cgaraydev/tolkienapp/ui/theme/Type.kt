package com.cgaraydev.tolkienapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val RingBearer = Typography(
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
        fontSize = 18.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
        fontSize = 28.sp
    )
)

val Aniron = Typography(
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.aniron)),
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.aniron)),
        fontSize = 12.sp
    )
)