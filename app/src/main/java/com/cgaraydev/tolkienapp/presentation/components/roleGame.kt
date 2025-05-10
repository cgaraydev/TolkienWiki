package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.Option
import com.cgaraydev.tolkienapp.data.models.PlayerState
import com.cgaraydev.tolkienapp.ui.theme.AgilityGold
import com.cgaraydev.tolkienapp.ui.theme.DefensePurple
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.HealthRed
import com.cgaraydev.tolkienapp.ui.theme.IntelligenceCyan
import com.cgaraydev.tolkienapp.ui.theme.LuckGreen
import com.cgaraydev.tolkienapp.ui.theme.StrengthBlue
import kotlinx.coroutines.launch

@Composable
fun ScrollableScenarioText(
    text: String,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val density = LocalDensity.current

    // Separamos el texto en result (parte superior) y effectsSummary (parte inferior)
    val parts = remember(text) {
        text.split("\n\n", limit = 2).let {
            Pair(
                it.getOrElse(0) { "" },
                it.getOrElse(1) { "" }
            )
        }
    }

    // Calculamos si el contenido es scrollable
    val isScrollable by remember {
        derivedStateOf { scrollState.maxValue > 0 }
    }

    Box(
        modifier = modifier
    ) {
        // Contenedor principal del texto con scroll
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(end = 12.dp)
        ) {
            // Parte 1: Resultado (estilo destacado)
            if (parts.first.isNotEmpty()) {
                Text(
                    text = parts.first,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cardo)),
                    lineHeight = 24.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Parte 2: EffectsSummary (estilo secundario)
            if (parts.second.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = parts.second,
                    color = Golden.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.cardo)),
                    lineHeight = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Barra de scroll personalizada - solo visible cuando hay scroll
        if (isScrollable) {
            val scrollbarWidth = with(density) { 4.dp.toPx() }
            val scrollbarPadding = with(density) { 4.dp.toPx() }
            val scrollbarColor = Golden.copy(alpha = 0.7f)
            val minThumbHeight = with(density) { 16.dp.toPx() }

            // Calculamos proporciones para el thumb (parte móvil)
            val viewportHeight = scrollState.viewportSize.toFloat()
            val totalHeight = scrollState.maxValue + viewportHeight
            val thumbHeight = (viewportHeight / totalHeight * viewportHeight)
                .coerceAtLeast(minThumbHeight)
                .coerceAtMost(viewportHeight * 0.8f)

            Canvas(
                modifier = Modifier
                    .width(with(density) { (scrollbarWidth + scrollbarPadding * 2).toDp() })
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
                    .pointerInput(Unit) {
                        detectVerticalDragGestures { _, dragAmount ->
                            coroutineScope.launch {
                                val scrollableRange = scrollState.maxValue.toFloat()
                                val dragFraction = dragAmount / size.height
                                scrollState.scrollBy(dragFraction * scrollableRange)
                            }
                        }
                    }
            ) {
                // Posición del thumb basada en el scroll actual
                val thumbPosition = if (scrollState.maxValue > 0) {
                    (scrollState.value.toFloat() / scrollState.maxValue) *
                            (size.height - thumbHeight)
                } else 0f

                // Dibujamos el thumb de la barra de scroll
                drawRoundRect(
                    color = scrollbarColor,
                    topLeft = Offset(x = scrollbarPadding, y = thumbPosition),
                    size = Size(width = scrollbarWidth, height = thumbHeight),
                    cornerRadius = CornerRadius(2.dp.toPx())
                )
            }
        }
    }
}

@Composable
fun StatItem(icon: Int, value: Int, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = value.toString(),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.cardo)),
            fontSize = 18.sp
        )
    }
}

@Composable
fun OptionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2D2D2D),
            contentColor = Golden
        ),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.5f))
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.cardo)),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ContinueButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2D2D2D),
            contentColor = Golden
        ),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Continuar",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Continuar",
            fontFamily = FontFamily(Font(R.font.cardo))
        )
    }
}

@Composable
private fun DecisionsColumn(
    decisions: List<Option>,
    onOptionSelected: (Option) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        decisions.forEach { option ->
            OptionButton(
                text = option.text,
                onClick = { onOptionSelected(option) }
            )
        }
    }
}

@Composable
fun ScenarioCard(
    title: String,
    text: String,
    decisions: List<Option>,
    showContinueButton: Boolean,
    onOptionSelected: (Option) -> Unit,
    onContinue: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = title,
                color = Golden,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.cardo))
            )

            ScrollableScenarioText(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            if (showContinueButton) {
                ContinueButton(onClick = onContinue)
            } else {
                DecisionsColumn(decisions, onOptionSelected)
            }
            Spacer(Modifier.size(10.dp))
        }
    }
}

@Composable
fun PlayerStatsHeader(playerState: PlayerState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(
                icon = R.drawable.ic_health,
                value = playerState.health,
                color = HealthRed
            )
            StatItem(
                icon = R.drawable.ic_strength,
                value = playerState.strength,
                color = StrengthBlue
            )
            StatItem(
                icon = R.drawable.ic_shield,
                value = playerState.defense,
                color = DefensePurple
            )
            StatItem(
                icon = R.drawable.ic_agility,
                value = playerState.agility,
                color = AgilityGold
            )
            StatItem(
                icon = R.drawable.ic_intelligence,
                value = playerState.wisdom,
                color = IntelligenceCyan
            )
            StatItem(
                icon = R.drawable.ic_luck,
                value = playerState.luck,
                color = LuckGreen
            )
        }
    }
}


