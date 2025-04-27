package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun GlowingSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    icon: Painter = painterResource(R.drawable.ic_ring),
    backgroundColor: Color = Color(0xFF1E1E1E),
    contentColor: Color = Color.White,
    accentColor: Color = Golden,
) {
    val infiniteGlow = rememberInfiniteTransition()
    val glow by infiniteGlow.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "SnackbarGlow"
    )

    val borderColor = accentColor.copy(alpha = glow)
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "SnackbarScale"
    )

    Surface(
        color = backgroundColor,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .scale(scale)
            .border(
                BorderStroke(1.5.dp, borderColor),
                shape = RoundedCornerShape(12.dp)
            )
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = borderColor,
                spotColor = borderColor
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Golden,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = message,
                color = contentColor,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.cardo)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                maxLines = 2,
                softWrap = true
            )

            Icon(
                painter = icon,
                contentDescription = null,
                tint = Golden,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}
