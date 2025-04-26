package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.MemoryCard
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.utils.toTimeString

@Composable
fun GameStats(moves: Int, time: Long, isPaused: Boolean) {
    val formattedTime = remember(time) {
        time.toTimeString()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(
            icon = painterResource(R.drawable.ic_clock),
            value = formattedTime,
            isPaused = isPaused
        )
        StatItem(
            icon = painterResource(R.drawable.ic_moves),
            value = moves.toString(),
            isPaused = isPaused
        )
    }
}

@Composable
fun StatItem(icon: Painter, value: String, isPaused: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = if (isPaused) Color.Gray else Golden,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = value,
                color = if (isPaused) Color.Gray else Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.cardo))
            )
        }
    }
}

@Composable
fun MemoryCardItem(
    card: MemoryCard,
    isInteractionBlocked: Boolean,
    highlight: Boolean = false,
    onClick: () -> Unit
) {
    val rotation by animateFloatAsState(
        targetValue = if (card.isFaceUp) 180f else 0f,
        animationSpec = tween(durationMillis = 400), label = "rotation"
    )

    val scale by animateFloatAsState(
        targetValue = if (card.isFaceUp) 1.1f else 1f,
        animationSpec = tween(durationMillis = 300), label = "scale"
    )

    val borderColor by animateColorAsState(
        targetValue = if (highlight) Color.Green else Golden,
        animationSpec = tween(durationMillis = 500), label = "borderColor"
    )
    Box(
        modifier = Modifier
            .aspectRatio(0.7f)
            .graphicsLayer {
                rotationY = rotation
                scaleX = scale
                scaleY = scale
                cameraDistance = 12f * density
            }
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                enabled = !card.isFaceUp && !card.isMatched && !isInteractionBlocked,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        if (rotation <= 90f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .border(2.dp, borderColor, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Card Back",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
        } else {
            if (card.imageRes != 0) {
                Image(
                    painter = painterResource(id = card.imageRes),
                    contentDescription = card.content,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text(
                    text = card.content,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}


@Composable
fun DifficultySelector(
    selectedDifficulty: String,
    onDifficultySelected: (String) -> Unit
) {
    val difficulties = listOf("hobbit", "elfo", "ainur")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "Selecciona la dificultad:",
            style = TextStyle(color = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.cardo)),
            fontSize = 20.sp
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            difficulties.forEach { difficulty ->
                val isSelected = difficulty == selectedDifficulty
                Box(
                    modifier = Modifier
                        .clickable { onDifficultySelected(difficulty) }
                        .background(
                            color = if (isSelected) Color(0xFFE1C16E) else Color.Transparent,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = difficulty.uppercase(),
                        fontSize = 16.sp,
                        color = if (isSelected) Color.Black else Color.White,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.cardo))
                    )
                }
            }
        }
    }
}

@Composable
fun GameHeader(
    difficulty: String,
    onBack: () -> Unit,
    isPaused: Boolean,
    onTogglePause: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Dificultad: ${difficulty.uppercase()}",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.cardo))
            )
            IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                Icon(
                    painter = painterResource(R.drawable.ic_replay),
                    contentDescription = "Volver",
                    tint = Golden,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        PauseButton(isPaused = isPaused, onToggle = onTogglePause)
    }
}

@Composable
fun PauseButton(isPaused: Boolean, onToggle: () -> Unit) {
    IconButton(
        onClick = onToggle,
        modifier = Modifier.size(48.dp)
    ) {
        Icon(
            painter = if (isPaused) painterResource(R.drawable.ic_play)
            else painterResource(R.drawable.ic_pause),
            contentDescription = if (isPaused) "Reanudar" else "Pausar",
            tint = Golden,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
fun GameBoard(
    cards: List<MemoryCard>,
    matchEffect: Pair<Int, String>?,
    isInteractionBlocked: Boolean,
    gridColumns: Int,
    shouldDim: Boolean,
    onCardClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .alpha(if (shouldDim) 0.7f else 1f)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(gridColumns),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(cards, key = { it.id }) { card ->
                MemoryCardItem(
                    card = card,
                    highlight = matchEffect?.first == card.id,
                    isInteractionBlocked = isInteractionBlocked,
                    onClick = { onCardClick(card.id) }
                )
            }
        }

        if (shouldDim) {
            PauseOverlay(onResume = { })
        }
    }
}

@Composable
fun PauseOverlay(onResume: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f))
            .clickable(onClick = onResume),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "JUEGO EN PAUSA",
            color = Golden,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}