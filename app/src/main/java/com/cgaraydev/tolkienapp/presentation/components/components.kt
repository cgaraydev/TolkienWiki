package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun CustomHeightSpacer(size: Int = 40) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun CustomDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(color = DarkGray, modifier = modifier.padding(vertical = 8.dp))
}

@Composable
fun CustomTitle(
    text: String,
    fontSize: Int,
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration
) {
    Text(
        text = text,
        color = Golden,
        fontSize = fontSize.sp,
        modifier = modifier,
        textDecoration = textDecoration
    )
}

@Composable
fun ScreenHeader(
    imageRes: Int,
    label: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.4f)
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoadingIndicator(
    size: Dp = 60.dp,
    strokeWidth: Dp = 3.dp,
    text: String = "Cargando",
    color: Color = Golden
) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing)
        )
    )
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(
                modifier = Modifier
                    .size(size)
                    .semantics { contentDescription = "Indicador de carga" }) {

                val brush = Brush.sweepGradient(
                    0.0f to color.copy(alpha = alpha * 0.4f),
                    0.5f to color.copy(alpha = alpha),
                    1.0f to color.copy(alpha = alpha * 0.4f),
                    center = center
                )

                drawArc(
                    brush = brush,
                    startAngle = rotation - 30,
                    sweepAngle = 90f,
                    useCenter = false,
                    size = Size(size.toPx(), size.toPx()),
                    style = Stroke(
                        width = (strokeWidth * 1.5f).toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }

            CustomHeightSpacer(24)

            if (text.isNotEmpty()) {
                Text(
                    text = text.lowercase(),
                    fontSize = 16.sp,
                    color = color.copy(alpha = alpha), // Sincroniza con la animación
                    modifier = Modifier.animateContentSize(),
                    fontFamily = FontFamily(Font(R.font.aniron))
                )
            }
        }
    }
}

@Composable
fun GradientOverlay(
    modifier: Modifier = Modifier,
    alpha: Float = 0.5f,
    startYRatio: Float = 0.7f // Valor entre 0 y 1
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = alpha)
                    ),
                    startY = startYRatio * LocalDensity.current.density * 100
                )
            )
    )
}

