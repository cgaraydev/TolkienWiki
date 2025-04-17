package com.cgaraydev.tolkienapp.presentation.quiz

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun QuizResultScreen(
    navController: NavController,
    correctAnswers: Int,
    totalQuestions: Int
) {
    val percentage = remember(correctAnswers, totalQuestions) {
        if (totalQuestions > 0) (correctAnswers.toFloat() / totalQuestions.toFloat() * 100).toInt() else 0
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(alpha = 0.8f),
                        Color.Black.copy(alpha = 0.6f),
                        Color.Black.copy(alpha = 0.8f),
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.bg_middle_earth),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.1f
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Anillo de progreso con porcentaje
            ResultProgressIndicator(percentage = percentage)

            // Título con animación
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically { -40 },
                exit = fadeOut()
            ) {
                Text(
                    text = when {
                        percentage >= 80 -> "¡Maestro de la Tierra Media!"
                        percentage >= 50 -> "¡Buen Conocimiento!"
                        else -> "¡Sigue Aprendiendo!"
                    },
                    color = Golden,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.aniron)),
                    textAlign = TextAlign.Center
                )
            }

            // Puntuación detallada
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Respuestas correctas:",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 18.sp
                )
                Text(
                    text = "$correctAnswers / $totalQuestions",
                    color = Golden,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "($percentage%)",
                    color = when {
                        percentage >= 80 -> Color(0xFF4CAF50)
                        percentage >= 50 -> Color(0xFFFFC107)
                        else -> Color(0xFFF44336)
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Botones de acción
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                OutlinedButton(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Golden
                    ),
                    border = BorderStroke(1.dp, Golden)
                ) {
                    Text("Ver Detalles")
                }

                Button(
                    onClick = { navController.navigate(Routes.QuizIntro.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Golden,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier.width(180.dp)
                ) {
                    Text("Nuevo Quiz")
                }
            }
        }
    }
}

@Composable
private fun ResultProgressIndicator(percentage: Int) {
    val animatedPercentage by animateFloatAsState(
        targetValue = percentage.toFloat(),
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
        label = "percentageAnimation"
    )

    Box(
        modifier = Modifier.size(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Fondo del círculo
            drawCircle(
                color = Color.DarkGray.copy(alpha = 0.3f),
                radius = size.minDimension / 2 - 10,
                style = Stroke(width = 12f)
            )

            // Arco de progreso
            drawArc(
                color = when {
                    percentage >= 80 -> Color(0xFF4CAF50)
                    percentage >= 50 -> Golden
                    else -> Color(0xFFF44336)
                },
                startAngle = -90f,
                sweepAngle = 3.6f * animatedPercentage,
                useCenter = false,
                size = Size(size.width - 20, size.height - 20),
                style = Stroke(width = 12f, cap = StrokeCap.Round)
            )

            // Texto porcentual
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    "$percentage%",
                    center.x,
                    center.y + 20,
                    Paint().apply {
                        color = android.graphics.Color.WHITE
                        textSize = 42f
                        textAlign = android.graphics.Paint.Align.CENTER
                        typeface = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD)
                    }
                )
            }
        }
    }
}