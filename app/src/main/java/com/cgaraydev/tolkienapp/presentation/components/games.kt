package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.MemoryCard
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun GameStats(moves: Int, time: Long, isPaused: Boolean) {
    val formattedTime = remember(time) {
        String.format("%02d:%02d", time / 60, time % 60)
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
                fontWeight = FontWeight.Bold
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
fun GameResultDialog(
    moves: Int,
    time: Long,
    difficulty: String,
    onDismiss: () -> Unit,
    onRestart: () -> Unit,
    modifier: Modifier = Modifier
) {
    val formattedTime = remember(time) {
        String.format("%02d:%02d", time / 60, time % 60)
    }
    val funFacts = remember {
        listOf(
            "Gandalf era conocido como Mithrandir entre los elfos",
            "Los hobbits tienen los pies peludos y no usan zapatos",
            "El Anillo Único fue forjado por Sauron en el Monte del Destino"
        )
    }
    val randomFact = remember { funFacts.random() }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF1E1E1E),
            modifier = modifier
                .fillMaxWidth(0.9f)
                .border(2.dp, Golden, RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "¡Juego Completado!",
                    color = Golden,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Estadísticas
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem(
                        icon = painterResource(R.drawable.ic_clock),
                        value = formattedTime
                    )
                    StatItem(
                        icon = painterResource(R.drawable.ic_moves),
                        value = moves.toString()
                    )
                    StatItem(
                        icon = painterResource(R.drawable.ic_ring),
                        value = difficulty.uppercase()
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Datos curiosos
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.3f))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "¿Sabías que?",
                        color = Golden,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        randomFact,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Botones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Golden
                        ),
                        border = BorderStroke(1.dp, Golden)
                    ) {
                        Text("Salir")
                    }
                    Button(
                        onClick = onRestart,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Golden,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Jugar de nuevo")
                    }
                }
            }
        }
    }
}