package com.cgaraydev.tolkienapp.presentation.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.AnimatedGlowButton
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DifficultySelector
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun QuizIntroScreen(
    navController: NavController,
    viewModel: QuizViewModel = hiltViewModel()
) {
    val selectedDifficulty by viewModel.selectedDifficulty.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(alpha = 0.7f),
                        Color.Black.copy(alpha = 0.2f),
                        Color.Black.copy(alpha = 0.7f),
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
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Reto de la Tierra Media",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Golden
            )
            CustomSpacer(20)
            Text(
                text = "¡Demuestra tu conocimiento sobre la Tierra Media!",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            CustomSpacer(20)
            DifficultySelector(
                selectedDifficulty = selectedDifficulty,
                onDifficultySelected = { difficulty ->
                    viewModel.setDifficulty(difficulty)
                }
            )
            CustomSpacer(32)
            AnimatedGlowButton(
                text = "iniciar",
                onClick = {
                    navController.navigate(Routes.QuizQuestions.createRoute(selectedDifficulty))
                }
            )
        }
    }
}