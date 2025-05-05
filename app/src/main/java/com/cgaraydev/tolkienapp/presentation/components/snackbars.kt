package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Golden
import kotlinx.coroutines.delay

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

@Composable
fun CustomToast(
    message: String,
    duration: Long = 2000L,
    modifier: Modifier = Modifier
) {
    var show by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(duration)
        show = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomCenter) // <-- Aquí posicionamos el toast
    ) {
        AnimatedVisibility(
            visible = show,
            enter = fadeIn() + slideInVertically { it },
            exit = fadeOut() + slideOutVertically { it },
            modifier = modifier.padding(bottom = 56.dp) // <-- Padding desde abajo
        ) {
            Surface(
                color = Color(0xE61E1E1E),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Golden),
                shadowElevation = 8.dp,
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(12.dp))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_music),
                        contentDescription = null,
                        tint = Golden
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = message,
                        fontFamily = FontFamily(Font(R.font.cardo)),
                        color = Color.White
                    )
                }
            }
        }
    }
}

//@Composable
//fun GlowingToast(
//    message: String,
//    icon: Painter = painterResource(R.drawable.ic_music),
//    duration: ToastDuration = ToastDuration.SHORT,
//    onDismiss: () -> Unit
//) {
//    val context = LocalContext.current
//    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
//    val infiniteGlow = rememberInfiniteTransition()
//    val glow by infiniteGlow.animateFloat(
//        initialValue = 0.6f,
//        targetValue = 1f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.BottomCenter)
//            .padding(bottom = 56.dp)
//    ) {
//        Surface(
//            color = Color(0xFF1E1E1E).copy(alpha = 0.9f),
//            shape = RoundedCornerShape(12.dp),
//            shadowElevation = 8.dp,
//            modifier = Modifier
//                .widthIn(max = screenWidth * 0.8f)
//                .border(
//                    BorderStroke(1.5.dp, Golden.copy(alpha = glow)),
//                    shape = RoundedCornerShape(12.dp)
//                )
//                .shadow(
//                    elevation = 12.dp,
//                    shape = RoundedCornerShape(12.dp),
//                    ambientColor = Golden.copy(alpha = glow * 0.3f),
//                    spotColor = Golden.copy(alpha = glow * 0.5f)
//                )
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
//            ) {
//                Icon(
//                    painter = icon,
//                    contentDescription = null,
//                    tint = Golden,
//                    modifier = Modifier.size(24.dp)
//                )
//
//                Spacer(modifier = Modifier.width(8.dp))
//
//                Text(
//                    text = message,
//                    color = Color.White,
//                    fontFamily = FontFamily(Font(R.font.cardo)),
//                    fontSize = 16.sp,
//                    maxLines = 2
//                )
//            }
//        }
//    }
//
//    // Auto-dismiss después de la duración
//    LaunchedEffect(duration) {
//        delay(duration.toMillis())
//        onDismiss()
//    }
//}
//
//enum class ToastDuration(val milliseconds: Long) {
//    SHORT(2000L),
//    LONG(3500L)
//}
//
//fun ToastDuration.toMillis() = this.milliseconds