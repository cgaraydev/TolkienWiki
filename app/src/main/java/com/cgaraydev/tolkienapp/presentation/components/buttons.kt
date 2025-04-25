package com.cgaraydev.tolkienapp.presentation.components

import android.view.MotionEvent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.ui.theme.Aniron
import com.cgaraydev.tolkienapp.ui.theme.GlowContainer
import com.cgaraydev.tolkienapp.ui.theme.GoldenButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AnimatedGlowButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    glowColor: Color = GoldenButton
) {
    var isPressed by remember { mutableStateOf(false) }
    val glowAlpha by animateFloatAsState(
        targetValue = if (isPressed) 0.3f else 1f,
        animationSpec = tween(durationMillis = 200),
        label = "GlowAlpha"
    )
    val infiniteGlow = rememberInfiniteTransition()
    val glow by infiniteGlow.animateFloat(
        initialValue = 0.7f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "InfiniteGlow"
    )
    val borderColor = glowColor.copy(alpha = glow * glowAlpha)
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(100)
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = GlowContainer,
            contentColor = glowColor
        ),
        border = BorderStroke(2.dp, borderColor),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .scale(scale)
            .height(65.dp)
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = borderColor,
                spotColor = borderColor
            )
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> isPressed = true
                    MotionEvent.ACTION_UP -> isPressed = false
                }
                false
            }
    ) {
        Text(
            text = text,
            fontFamily = Aniron.bodyMedium.fontFamily,
            fontSize = 16.sp
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AnimatedGlowButtonCompact(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    glowColor: Color = GoldenButton
) {
    var isPressed by remember { mutableStateOf(false) }
    val glowAlpha by animateFloatAsState(
        targetValue = if (isPressed) 0.3f else 1f,
        animationSpec = tween(durationMillis = 200),
        label = "GlowAlpha"
    )
    val infiniteGlow = rememberInfiniteTransition()
    val glow by infiniteGlow.animateFloat(
        initialValue = 0.7f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "InfiniteGlow"
    )
    val borderColor = glowColor.copy(alpha = glow * glowAlpha)
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(100)
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = GlowContainer,
            contentColor = glowColor
        ),
        border = BorderStroke(2.dp, borderColor),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .scale(scale)
            .height(55.dp) // un poquito más compacto
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = borderColor,
                spotColor = borderColor
            )
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> isPressed = true
                    MotionEvent.ACTION_UP -> isPressed = false
                }
                false
            }
    ) {
        Text(
            text = text,
            fontFamily = Aniron.bodyMedium.fontFamily,
            fontSize = 14.sp
        )
    }
}