package com.cgaraydev.tolkienapp.presentation.quiz

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.QuizQuestion
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.AnimatedGlowButtonCompact
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.Gray
import com.cgaraydev.tolkienapp.ui.theme.QuizRed

@Composable
fun QuizQuestionScreen(
    navController: NavController,
    difficulty: String,
    viewModel: QuizViewModel = hiltViewModel()
) {
    val questions by viewModel.questions.collectAsState()
    val currentIndex by viewModel.currentQuestionIndex.collectAsState()
    val correctAnswers by viewModel.correctAnswers.collectAsState()
    val selectedOption by viewModel.selectedOption.collectAsState()


    LaunchedEffect(difficulty) {
        viewModel.setDifficulty(difficulty)
        viewModel.loadQuestions()
    }


    if (questions.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Golden)
        }
        return
    }

    if (currentIndex >= questions.size) {
        LaunchedEffect(Unit) {
            navController.navigate(
                Routes.QuizResult.createRoute(
                    correct = correctAnswers,
                    total = questions.size
                )
            ) {
                popUpTo(Routes.QuizIntro.route) { inclusive = false }
            }
        }
        return
    }

    val question = questions[currentIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            QuizHeader(difficulty, currentIndex, questions.size)


            QuestionCard(
                question = question,
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    viewModel.selectOption(option)
                }
            )


            Spacer(modifier = Modifier.weight(1f))
            QuizActions(
                currentIndex = currentIndex,
                totalQuestions = questions.size,
                selectedOption = selectedOption,
                onNext = {
                    viewModel.nextQuestion()
                },
                onFinish = {
                    navController.navigate(
                        Routes.QuizResult.createRoute(
                            correct = correctAnswers,
                            total = questions.size
                        )
                    ) {
                        popUpTo(Routes.QuizIntro.route) {
                            inclusive = false
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun QuizHeader(
    difficulty: String,
    currentIndex: Int,
    totalQuestions: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Dificultad: " + difficulty.uppercase(),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.cardo)),
            fontSize = 14.sp
        )

        Text(
            text = "Avance: ${currentIndex + 1}/$totalQuestions",
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.cardo)),
        )
    }
}


@Composable
fun QuestionCard(
    question: QuizQuestion,
    selectedOption: String?,
    modifier: Modifier = Modifier,
    onOptionSelected: (String) -> Unit
) {
    val showFeedback = selectedOption != null

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Golden.copy(alpha = 0.7f)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .heightIn(max = 500.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = question.question,
                color = Color.White,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.cardo))
            )
            question.options.forEach { option ->
                val isSelected = option == selectedOption
                val isCorrect = option == question.answer

                OptionButton(
                    text = option,
                    isSelected = isSelected,
                    isCorrect = isCorrect,
                    showFeedback = showFeedback,
                    onClick = { if (!showFeedback) onOptionSelected(option) }
                )
            }
            if (showFeedback) {
                CustomHeightSpacer(16)
                FeedbackMessage(
                    explanation = question.explanation,
                    isCorrect = selectedOption == question.answer // Pasar si fue correcta
                )
            }
        }
    }
}

@Composable
fun OptionButton(
    text: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    showFeedback: Boolean,
    onClick: () -> Unit
) {
    val icon = when {
        showFeedback && isCorrect -> Icons.Default.Check
        showFeedback && isSelected -> Icons.Default.Close
        else -> null
    }

    val backgroundColor = animateColorAsState(
        targetValue = when {
            showFeedback && isCorrect -> Color(0xFF4CAF50).copy(alpha = 0.3f)
            showFeedback && isSelected -> Color(0xFFF44336).copy(alpha = 0.3f)
            else -> Color.Transparent
        },
        animationSpec = tween(durationMillis = 300)
    )
    val borderColor = animateColorAsState(
        targetValue = when {
            showFeedback && isCorrect -> Color(0xFF4CAF50)
            showFeedback && isSelected -> Color(0xFFF44336)
            else -> Gray.copy(alpha = 0.5f)
        },
        animationSpec = tween(durationMillis = 300)
    )
    val textColor = animateColorAsState(
        targetValue = when {
            isSelected -> Color.White
            else -> Gray.copy(alpha = 0.5f)
        },
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = !showFeedback,
                onClick = onClick
            )
            .background(
                color = backgroundColor.value,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor.value,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = if (isCorrect) "Correcto" else "Incorrecto",
                    tint = if (isCorrect) Color(0xFF4CAF50) else Color(0xFFF44336),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                fontSize = 18.sp,
                color = textColor.value,
                fontFamily = FontFamily(Font(R.font.cardo)),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FeedbackMessage(explanation: String, isCorrect: Boolean) {
    val borderColor = if (isCorrect) Color(0xFF4CAF50) else Golden.copy(alpha = 0.7f)
    val icon = if (isCorrect) Icons.Default.Check else Icons.Default.Info

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF333333).copy(alpha = 0.5f))
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = if (isCorrect) "Correcto" else "Información",
                tint = if (isCorrect) Color(0xFF4CAF50) else Golden,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (isCorrect) "¡Correcto!" else "Aprendamos:",
                color = if (isCorrect) Color(0xFF4CAF50) else Golden,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.cardo))
            )
        }
        Text(
            text = explanation,
            color = Color.White.copy(alpha = 0.9f),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.cardo)),
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}


@Composable
private fun QuizActions(
    currentIndex: Int,
    totalQuestions: Int,
    selectedOption: String?,
    onNext: () -> Unit,
    onFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.Black,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AnimatedGlowButtonCompact(
                text = "Terminar",
                onClick = onFinish,
                glowColor = QuizRed.copy(alpha = 0.7f),
                borderWidth = 1.dp,
                modifier = Modifier.weight(1f),
                height = 40.dp
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (currentIndex < totalQuestions - 1) {
                AnimatedGlowButtonCompact(
                    text = "Siguiente",
                    onClick = onNext,
                    enabled = selectedOption != null,
                    modifier = Modifier.weight(1f),
                    height = 40.dp
                )
            } else {
                AnimatedGlowButtonCompact(
                    text = "Ver Resultados",
                    onClick = onFinish,
                    enabled = selectedOption != null,
                    modifier = Modifier.weight(1f),
                    height = 40.dp
                )
            }
        }
    }
}