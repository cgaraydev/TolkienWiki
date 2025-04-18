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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Aniron
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun CustomSpacer(size: Int) {
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
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String?,
    navController: NavController
) {
    value?.let {
        Row(
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Text(
                text = "$label: ",
                style = TextStyle(),
                fontSize = 16.sp,
                color = LightGray,
                fontWeight = FontWeight.Bold
            )
            HtmlText(
                htmlText = value,
                navController = navController
            )
        }
    }
}

@Composable
fun GoodEvilSection(
    title: String,
    goodContent: String?,
    evilContent: String?,
    navController: NavController
) {
    if (goodContent.isNullOrBlank() && evilContent.isNullOrBlank()) return

    CustomExpandable(title = title) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            if (!goodContent.isNullOrBlank()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.good),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    HtmlText(
                        htmlText = goodContent,
                        navController = navController,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            if (!evilContent.isNullOrBlank()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.bad),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    HtmlText(
                        htmlText = evilContent,
                        navController = navController,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun StateHandler(
    isLoading: Boolean,
    error: String?,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Golden
                )
            }

            error != null -> {
                Text(
                    text = error,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center),
                    style = TextStyle()
                )
            }

            else -> {
                content()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AnimatedGlowButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
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
    val borderColor = Color(0xFFE1C16E).copy(alpha = glow * glowAlpha)
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(100)
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E1E1E),
            contentColor = Color(0xFFE1C16E)
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
            text = "iniciar",
            fontFamily = Aniron.bodyMedium.fontFamily,
            fontSize = 18.sp
        )
    }
}


