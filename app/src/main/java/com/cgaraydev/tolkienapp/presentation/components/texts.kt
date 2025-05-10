package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.Pumpkin

@Composable
fun AnimatedTextTitle(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    paddingValues: PaddingValues = PaddingValues(12.dp),
    textAlign: TextAlign = TextAlign.Center,
    shadowOffset: Offset = Offset(8f, 6f),
    shadowBlur: Float = 12f
) {
    val infiniteTransition = rememberInfiniteTransition()

    val breathAlpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val shadowColor by infiniteTransition.animateColor(
        initialValue = Golden,
        targetValue = Pumpkin,
        animationSpec = infiniteRepeatable(
            tween(4000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Text(
        text = text.uppercase(),
        color = Color.White.copy(alpha = breathAlpha),
        fontSize = fontSize,
        fontFamily = FontFamily(Font(R.font.aniron)),
        modifier = modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        style = TextStyle(
            shadow = Shadow(
                color = shadowColor,
                offset = shadowOffset,
                blurRadius = shadowBlur
            )
        ),
        textAlign = textAlign
    )
}

