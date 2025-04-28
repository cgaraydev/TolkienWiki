package com.cgaraydev.tolkienapp.presentation.components

import android.view.MotionEvent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.presentation.home.HomeViewModel
import com.cgaraydev.tolkienapp.ui.theme.Aniron
import com.cgaraydev.tolkienapp.ui.theme.GlowContainer
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.GoldenButton
import com.cgaraydev.tolkienapp.ui.theme.Gray
import kotlinx.coroutines.delay

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
    glowColor: Color = GoldenButton,
    enabled: Boolean = true,
    borderWidth: Dp = 2.dp
) {
    var isPressed by remember { mutableStateOf(false) }
    val glowAlpha by animateFloatAsState(
        targetValue = if (isPressed) 0.3f else 1f,
        animationSpec = tween(durationMillis = 200),
        label = "GlowAlpha"
    )
    val infiniteGlow = rememberInfiniteTransition()
    val glow by infiniteGlow.animateFloat(
        initialValue = if (enabled) 0.7f else 0f,
        targetValue = if (enabled) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "InfiniteGlow"
    )
    val currentBorderColor = if (enabled) {
        glowColor.copy(alpha = glow * glowAlpha)
    } else {
        Gray.copy(alpha = 0.2f)
    }
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.98f else 1f,
        animationSpec = tween(100)
    )

    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) GlowContainer else Color.Black,
            contentColor = if (enabled) glowColor else Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.Black
        ),
        border = BorderStroke(
            width = borderWidth,
            color = currentBorderColor
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .scale(scale)
            .height(55.dp) // un poquito más compacto
            .shadow(
                elevation = if (enabled) 8.dp else 0.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = currentBorderColor,
                spotColor = currentBorderColor
            )
            .pointerInteropFilter {
                if (enabled) {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> isPressed = true
                        MotionEvent.ACTION_UP -> isPressed = false
                    }
                }
                false
            }
    ) {
        Text(
            text = text,
            fontFamily = Aniron.bodyMedium.fontFamily,
            fontSize = 10.sp,
            maxLines = 1,
            color = if (enabled) glowColor else Gray.copy(alpha = 0.2f)
        )
    }
}

@Composable
fun CustomFAB(
    onClick: () -> Unit,
    icon: ImageVector,
    fabSize: Dp,
    iconSize: Dp,
    backgroundColor: Color,
    iconColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val elevation by animateDpAsState(
        targetValue = if (isPressed) 10.dp else 6.dp,
        animationSpec = tween(durationMillis = 150),
        label = "FABElevation"
    )

    Surface(
        shape = shape,
        color = backgroundColor,
        contentColor = iconColor,
        shadowElevation = elevation,
        modifier = modifier
            .size(fabSize)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    color = borderColor,
                    shape = shape
                )
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Composable
fun DualFABsWithToggle(
    onBackClick: () -> Unit,
    viewModel: HomeViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var showFABs by remember { mutableStateOf(false) }
    var showSearchDialog by remember { mutableStateOf(false) }

    LaunchedEffect(showFABs) {
        if (showFABs) {
            delay(2000)
            showFABs = false
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 14.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        if (!showFABs) {
            CustomFAB(
                onClick = { showFABs = true },
                icon = Icons.Default.MoreVert,
                fabSize = 40.dp,
                iconSize = 24.dp,
                backgroundColor = Color.Black,
                iconColor = Color.White.copy(alpha = 0.6f),
                borderColor = Color.White.copy(alpha = 0.6f),
                shape = CircleShape
            )
        } else {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CustomFAB(
                    onClick = {
                        showFABs = false
                        onBackClick()
                    },
                    icon = Icons.AutoMirrored.Filled.ArrowBack,
                    fabSize = 48.dp,
                    iconSize = 24.dp,
                    backgroundColor = Golden,
                    iconColor = Color.Black,
                    borderColor = Color.Black.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(14.dp)
                )

                CustomFAB(
                    onClick = {
                        showFABs = false
                        showSearchDialog = true
                    },
                    icon = Icons.Default.Search,
                    fabSize = 56.dp,
                    iconSize = 28.dp,
                    backgroundColor = Color(0xFF333333),
                    iconColor = Golden,
                    borderColor = Golden.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(18.dp)
                )
            }
        }
    }
    if (showSearchDialog) {
        SearchDialog(
            onDismiss = { showSearchDialog = false },
            viewModel = viewModel,
            navController = navController
        )
    }
}

//@Composable
//fun DualFABS(
//    onBackClick: () -> Unit,
//    onSearchClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Box(
//        contentAlignment = Alignment.BottomEnd,
//        modifier = modifier.padding(bottom = 24.dp, end = 24.dp)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.End,
//            verticalArrangement = Arrangement.spacedBy(12.dp) // Espacio entre los FABs
//        ) {
//            CustomFAB(
//                onClick = onBackClick,
//                icon = Icons.Default.ArrowBack,
//                fabSize = 40.dp,
//                iconSize = 24.dp,
//                backgroundColor = Golden,
//                iconColor = Color.Black,
//                borderColor = Color.Black.copy(alpha = 0.8f),
//                shape = RoundedCornerShape(14.dp)
//            )
//            CustomFAB(
//                onClick = onSearchClick,
//                icon = Icons.Default.Search,
//                fabSize = 72.dp,
//                iconSize = 32.dp,
//                backgroundColor = Color(0xFF333333),
//                iconColor = Golden,
//                borderColor = Golden.copy(alpha = 0.7f),
//                shape = RoundedCornerShape(18.dp)
//            )
//        }
//    }
//}
