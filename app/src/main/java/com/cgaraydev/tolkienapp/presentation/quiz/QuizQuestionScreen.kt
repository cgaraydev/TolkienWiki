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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.QuizQuestion
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.QuizRed
import com.cgaraydev.tolkienapp.ui.theme.RingBearer

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
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
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
        Box(
            modifier = Modifier
                .background(
                    color = when (difficulty) {
                        "hobbit" -> Color(0xFF4CAF50).copy(alpha = 0.2f)
                        "elfo" -> Color(0xFF2196F3).copy(alpha = 0.2f)
                        "maia" -> Color(0xFFF44336).copy(alpha = 0.2f)
                        else -> Color.Gray.copy(alpha = 0.2f)
                    },
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 18.dp, vertical = 16.dp)
        ) {
            Text(
                text = "dificultad: " + difficulty.uppercase(),
                color = Color.White,
                fontSize = 14.sp
            )
        }
        Text(
            text = "avance: ${currentIndex + 1}/$totalQuestions",
            color = Golden,
            fontSize = 20.sp
        )
    }
}


@Composable
fun QuestionCard(
    question: QuizQuestion,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    val showFeedback = selectedOption != null

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = question.question,
                color = Color.White,
                fontSize = 22.sp,
                lineHeight = 26.sp,
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
            if (showFeedback && selectedOption != question.answer) {
                CustomSpacer(16)
                FeedbackMessage(
                    correctAnswer = question.answer,
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
        showFeedback && isSelected && !isCorrect -> Icons.Default.Close
        else -> null
    }

    val backgroundColor = animateColorAsState(
        targetValue = when {
            !showFeedback && isSelected -> Golden.copy(alpha = 0.3f)
            showFeedback && isCorrect -> Color(0xFF4CAF50).copy(alpha = 0.3f)
            showFeedback && isSelected && !isCorrect -> Color(0xFFF44336).copy(alpha = 0.3f)
            else -> Color.Transparent
        },
        animationSpec = tween(durationMillis = 300)
    )
    val borderColor = animateColorAsState(
        targetValue = when {
            !showFeedback && isSelected -> Golden
            showFeedback && isCorrect -> Color(0xFF4CAF50)
            showFeedback && isSelected && !isCorrect -> Color(0xFFF44336)
            else -> Color.Gray.copy(alpha = 0.5f)
        },
        animationSpec = tween(durationMillis = 300)
    )
    val textColor = animateColorAsState(
        targetValue = when {
            isSelected -> Color.White
            else -> Color.Gray
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
                fontSize = 22.sp,
                color = textColor.value,
                fontFamily = FontFamily(Font(R.font.cardo)),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FeedbackMessage(correctAnswer: String, explanation: String = "") {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF333333).copy(alpha = 0.5f))
            .border(1.dp, Golden.copy(alpha = 0.7f), RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Respuesta correcta:\n$correctAnswer",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.cardo))
        )
        Text(
            text = explanation,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 16.sp,
            style = TextStyle()
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
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(
            onClick = onFinish,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.LightGray
            ),
            border = BorderStroke(1.dp, QuizRed.copy(alpha = 0.3f))
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = QuizRed.copy(alpha = 0.3f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Terminar",
                fontFamily = RingBearer.bodyMedium.fontFamily
            )
        }

        if (currentIndex < totalQuestions - 1) {
            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Golden,
                    contentColor = Color.Black
                ),
                enabled = selectedOption != null
            ) {
                Text(
                    text = "Siguiente",
                    fontFamily = RingBearer.bodyMedium.fontFamily
                )
            }
        } else {
            Button(
                onClick = onFinish,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Golden,
                    contentColor = Color.Black
                ),
                enabled = selectedOption != null
            ) {
                Text("Ver Resultados")
            }
        }

    }
}


//@Composable
//fun QuizProgressIndicator(
//    currentIndex: Int,
//    totalQuestions: Int,
//    modifier: Modifier = Modifier
//) {
//    val progress = (currentIndex + 1).toFloat() / totalQuestions.toFloat()
//    val sweepAngle = 360f * progress
//
//    Box(
//        modifier = modifier
//            .size(150.dp)
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawCircle(
//                color = Color.DarkGray.copy(alpha = 0.3f),
//                radius = size.minDimension / 2 - 10,
//                style = Stroke(width = 10f)
//            )
//            drawArc(
//                color = Golden,
//                startAngle = -90f,
//                sweepAngle = sweepAngle,
//                useCenter = false,
//                size = Size(size.width - 20, size.height - 20),
//                style = Stroke(width = 10f, cap = StrokeCap.Round)
//            )
//            drawContext.canvas.nativeCanvas.apply {
//                drawText(
//                    "${(progress * 100).toInt()}%",
//                    center.x,
//                    center.y + 15,
//                    Paint().apply {
//                        color = android.graphics.Color.WHITE
//                        textSize = 30f
//                        textAlign = android.graphics.Paint.Align.CENTER
//                        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
//                    }
//                )
//            }
//        }
//    }
//}


//@Composable
//fun QuizQuestionScreen(
//    viewModel: QuizViewModel = hiltViewModel()
//) {
//    val uiState by viewModel.uiState.collectAsState()
//
//    StateHandler(
//        isLoading = uiState is QuizUiState.Loading,
//        error = (uiState as? QuizUiState.Error)?.message,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        when (uiState) {
//            is QuizUiState.Success -> {
//                val questions = (uiState as QuizUiState.Success).questions
//                if (questions.isNotEmpty()) {
//                    QuestionFlow(questions = questions)
//                } else {
//                    Text(
//                        text = "No se encontraron preguntas",
//                        color = Color.White,
////                        modifier = Modifier.align(Alignment.Center)
//                    )
//                }
//            }
//            else -> {} // Estados manejados por StateHandler
//        }
//    }
//}
//
//@Composable
//private fun QuestionFlow(questions: List<QuizQuestion>) {
//    var currentQuestionIndex by remember { mutableIntStateOf(0) }
//    var selectedAnswer by remember { mutableStateOf<String?>(null) } // Cambiado a String
//
//    val currentQuestion = questions[currentQuestionIndex]
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Progreso
//        Text(
//            text = "Pregunta ${currentQuestionIndex + 1}/${questions.size}",
//            color = Golden,
//            fontFamily = Aniron.bodyMedium.fontFamily,
//            fontSize = 18.sp
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Pregunta
//        Card(
//            modifier = Modifier.fillMaxWidth(),
//            colors = CardDefaults.cardColors(
//                containerColor = Color(0x22FFFFFF)
//            ),
//            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//        ) {
//            Text(
//                text = currentQuestion.question,
//                modifier = Modifier.padding(16.dp),
//                color = Color.White,
//                fontFamily = Aniron.bodyMedium.fontFamily,
//                fontSize = 20.sp
//            )
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Opciones de respuesta
//        currentQuestion.options.forEach { option ->
//            AnswerOption(
//                text = option,
//                isSelected = option == selectedAnswer,
//                isCorrect = option == currentQuestion.answer, // Comparación directa
//                onClick = { selectedAnswer = option }
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Botón de navegación
//        Button(
//            onClick = {
//                if (currentQuestionIndex < questions.size - 1) {
//                    currentQuestionIndex++
//                    selectedAnswer = null
//                }
//            },
//            enabled = selectedAnswer != null,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Golden,
//                contentColor = Color.Black
//            ),
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text(
//                text = if (currentQuestionIndex < questions.size - 1) "Siguiente" else "Finalizar",
//                fontFamily = Aniron.bodyMedium.fontFamily
//            )
//        }
//    }
//}
//
//@Composable
//private fun AnswerOption(
//    text: String,
//    isSelected: Boolean,
//    isCorrect: Boolean,
//    onClick: () -> Unit
//) {
//    val backgroundColor = when {
//        isSelected && isCorrect -> Color(0xFF4D8B2B).copy(alpha = 0.3f) // Verde
//        isSelected && !isCorrect -> Color(0xFFB71C1C).copy(alpha = 0.3f) // Rojo
//        else -> Color(0x22FFFFFF) // Transparente
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = onClick),
//        colors = CardDefaults.cardColors(
//            containerColor = backgroundColor
//        ),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Text(
//            text = text,
//            modifier = Modifier.padding(16.dp),
//            color = Color.White,
//            fontFamily = Aniron.bodyMedium.fontFamily
//        )
//    }
//}
//@Composable
//fun QuizQuestionScreen(
//    viewModel: QuizViewModel = hiltViewModel()
//) {
//    val uiState by viewModel.uiState.collectAsState()
//
//    StateHandler(
//        isLoading = uiState is QuizUiState.Loading,
//        error = (uiState as? QuizUiState.Error)?.message,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        when (uiState) {
//            is QuizUiState.Success -> {
//                val questions = (uiState as QuizUiState.Success).questions
//                QuestionFlow(questions = questions)
//            }
//            else -> {} // Estado manejado por StateHandler
//        }
//    }
//}
//
//@Composable
//private fun QuestionFlow(questions: List<QuizQuestion>) {
//    var currentQuestionIndex by remember { mutableIntStateOf(0) }
//    var selectedAnswer by remember { mutableStateOf<Int?>(null) }
//
//    val currentQuestion = questions[currentQuestionIndex]
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Header con progreso
//        Text(
//            text = "Pregunta ${currentQuestionIndex + 1}/${questions.size}",
//            color = Golden,
//            fontFamily = Aniron.bodyMedium.fontFamily,
//            fontSize = 18.sp
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Tarjeta de pregunta
//        Card(
//            modifier = Modifier.fillMaxWidth(),
////             = Color(0x22FFFFFF),
////            elevation = 8.dp
//        ) {
//            Text(
//                text = currentQuestion.question,
//                modifier = Modifier.padding(16.dp),
//                color = Color.White,
//                fontFamily = Aniron.bodyMedium.fontFamily,
//                fontSize = 20.sp
//            )
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Opciones de respuesta
//        currentQuestion.options.forEachIndexed { index, option ->
//            val isSelected = selectedAnswer == index
//            val isCorrect = index == currentQuestion.answer.toInt()
//
//            AnswerOption(
//                text = option,
//                isSelected = isSelected,
//                isCorrect = isCorrect,
//                onClick = { selectedAnswer = index }
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Botón de siguiente/finalizar
//        Button(
//            onClick = {
//                if (currentQuestionIndex < questions.size - 1) {
//                    currentQuestionIndex++
//                    selectedAnswer = null
//                }
//            },
//            enabled = selectedAnswer != null,
//            colors = ButtonDefaults.buttonColors(
////                bac = Golden,
//                contentColor = Color.Black
//            ),
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text(
//                text = if (currentQuestionIndex < questions.size - 1) "Siguiente" else "Finalizar",
//                fontFamily = Aniron.bodyMedium.fontFamily
//            )
//        }
//    }
//}
//
//@Composable
//private fun AnswerOption(
//    text: String,
//    isSelected: Boolean,
//    isCorrect: Boolean,
//    onClick: () -> Unit
//) {
//    val backgroundColor = when {
//        isSelected && isCorrect -> Color(0xFF4D8B2B).copy(alpha = 0.3f)
//        isSelected && !isCorrect -> Color(0xFFB71C1C).copy(alpha = 0.3f)
//        else -> Color(0x22FFFFFF)
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = onClick),
////        backgroundColor = backgroundColor,
////        elevation = 4.dp
//    ) {
//        Text(
//            text = text,
//            modifier = Modifier.padding(16.dp),
//            color = Color.White,
//            fontFamily = Aniron.bodyMedium.fontFamily
//        )
//    }
//}

//@Composable
//fun QuizQuestionScreen(
//    viewModel: QuizViewModel = hiltViewModel()
//) {
//    val uiState by viewModel.uiState.collectAsState()
//
//    StateHandler(
//        isLoading = uiState is QuizUiState.Loading,
//        error = (uiState as? QuizUiState.Error)?.message,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        if (uiState is QuizUiState.Success) {
//            val questions = (uiState as QuizUiState.Success).questions
//            QuestionFlow(questions = questions)
//        }
//    }
//}
//
//@Composable
//private fun QuestionFlow(questions: List<QuizQuestion>) {
//    var currentQuestionIndex by remember { mutableIntStateOf(0) }
//    var selectedAnswer by remember { mutableStateOf<String?>(null) }
//
//    val currentQuestion = questions[currentQuestionIndex]
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Pregunta ${currentQuestionIndex + 1}/${questions.size}",
//            color = Golden,
//            fontFamily = Aniron.bodyMedium.fontFamily,
//            fontSize = 18.sp
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Card(
//            modifier = Modifier.fillMaxWidth(),
//            colors = CardDefaults.cardColors(containerColor = Color(0x22FFFFFF)),
//            elevation = CardDefaults.cardElevation(8.dp)
//        ) {
//            Text(
//                text = currentQuestion.question,
//                modifier = Modifier.padding(16.dp),
//                color = Color.White,
//                fontFamily = Aniron.bodyMedium.fontFamily,
//                fontSize = 20.sp
//            )
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        currentQuestion.options.forEach { option ->
//            AnswerOption(
//                text = option,
//                isSelected = option == selectedAnswer,
//                isCorrect = option == currentQuestion.answer,
//                onClick = { selectedAnswer = option }
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        Button(
//            onClick = {
//                if (currentQuestionIndex < questions.size - 1) {
//                    currentQuestionIndex++
//                    selectedAnswer = null
//                }
//            },
//            enabled = selectedAnswer != null,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Golden,
//                contentColor = Color.Black
//            ),
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text(
//                text = if (currentQuestionIndex < questions.size - 1) "Siguiente" else "Finalizar",
//                fontFamily = Aniron.bodyMedium.fontFamily
//            )
//        }
//    }
//}
//
//@Composable
//private fun AnswerOption(
//    text: String,
//    isSelected: Boolean,
//    isCorrect: Boolean,
//    onClick: () -> Unit
//) {
//    val backgroundColor = when {
//        isSelected && isCorrect -> Color(0xFF4D8B2B).copy(alpha = 0.3f)
//        isSelected && !isCorrect -> Color(0xFFB71C1C).copy(alpha = 0.3f)
//        else -> Color(0x22FFFFFF)
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = onClick),
//        colors = CardDefaults.cardColors(containerColor = backgroundColor),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Text(
//            text = text,
//            modifier = Modifier.padding(16.dp),
//            color = Color.White,
//            fontFamily = Aniron.bodyMedium.fontFamily
//        )
//    }
//}

//FUNCIONAL
//@Composable
//fun QuizQuestionScreen(
//    navController: NavController,
//    viewModel: QuizViewModel = hiltViewModel()
//){
//    val questions by viewModel.questions.collectAsState()
//    val currentIndex by viewModel.currentQuestionIndex.collectAsState()
//    val correctAnswers by viewModel.correctAnswers.collectAsState()
//
//    LaunchedEffect(Unit) {
//        viewModel.loadQuestions()
//    }
//
//    if(questions.isEmpty()){
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("Cargando preguntas...")
//        }
//        return
//    }
//
//    if(currentIndex >= questions.size){
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("¡Has terminado el quiz!\nCorrectas: $correctAnswers de ${questions.size}")
//        }
//        return
//    }
//
//    val question = questions[currentIndex]
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ){
//        Text(
//            text = "Pregunta ${currentIndex + 1} de ${questions.size}",
//        )
//
//        Text(
//            text = question.question,
//        )
//
//        question.options.forEach { option ->
//            Button(
//                onClick = {viewModel.onOptionSelected(option)},
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(option)
//            }
//        }
//    }
//}

//    if(questions.isNotEmpty()){
//        val question = questions[0]
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ){
//            Text(question.question)
//            question.options.forEach { option ->
//                Button(
//                    onClick = {
//                        Log.d("QuizQuestionScreen", "Seleccionado: $option")
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                ){
//                    Text(option)
//                }
//            }
//        }
//    } else {
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("Cargando preguntas...")
//        }
//    }

//FUNCIONAL
//@Composable
//fun QuizQuestionScreen(
//    navController: NavController,
//    difficulty:String,
//    viewModel: QuizViewModel = hiltViewModel()
//){
//    val questions by viewModel.questions.collectAsState()
//    val currentIndex by viewModel.currentQuestionIndex.collectAsState()
//    val correctAnswers by viewModel.correctAnswers.collectAsState()
//
//    LaunchedEffect(difficulty) {
//        viewModel.setDifficulty(difficulty)
//        viewModel.loadQuestions()
//    }
//
//    if(questions.isEmpty()){
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("Cargando preguntas...")
//        }
//        return
//    }
//
//    if(currentIndex >= questions.size){
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("¡Has terminado el quiz!\nCorrectas: $correctAnswers de ${questions.size}")
//        }
//        return
//    }
//
//    val question = questions[currentIndex]
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ){
//        Text(
//            text = "Pregunta ${currentIndex + 1} de ${questions.size}",
//        )
//
//        Text(
//            text = question.question,
//        )
//
//        question.options.forEach { option ->
//            Button(
//                onClick = {viewModel.onOptionSelected(option)},
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(option)
//            }
//        }
//    }
//}
