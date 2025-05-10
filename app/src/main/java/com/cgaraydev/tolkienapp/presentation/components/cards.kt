package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cgaraydev.tolkienapp.R

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    imageRes: Int,
    title: String,
    onClick: () -> Unit,
    contentDescription: String = title,
    placeholder: Painter? = painterResource(R.drawable.logo),
    elevation: Dp = 8.dp,
    pressedElevation: Dp = 4.dp,
    scale: Float = 1f,
    pressedScale: Float = 0.98f,
    gradientColors: List<Color> = listOf(Color.Transparent, Color(0x80000000)),
    gradientEndY: Float = 0.3f,
    textStyle: TextStyle = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.cardo))
    ),
    maxLines: Int = 2,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: (@Composable () -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val animatedElevation = animateDpAsState(if (isPressed) pressedElevation else elevation)
    val animatedScale = animateFloatAsState(if (isPressed) pressedScale else scale)

    Card(
        modifier = modifier
            .clickable(onClick = onClick)
            .graphicsLayer { scaleX = animatedScale.value; scaleY = animatedScale.value }
            .hoverable(interactionSource = interactionSource),
        elevation = CardDefaults.cardElevation(animatedElevation.value)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = imageRes,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                placeholder = placeholder
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = gradientColors,
                            endY = gradientEndY
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .padding(contentPadding)
            ) {
                Text(
                    text = title,
                    style = textStyle,
                    maxLines = maxLines,
                    overflow = TextOverflow.Ellipsis,
                )

                content?.invoke()
            }
        }
    }
}