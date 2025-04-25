package com.cgaraydev.tolkienapp.presentation.memory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.AnimatedGlowButton
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DifficultySelector
import com.cgaraydev.tolkienapp.presentation.components.RecordsDialog
import com.cgaraydev.tolkienapp.ui.theme.Golden


@Composable
fun MemoryIntroScreen(
    navController: NavController,
    viewModel: MemoryViewModel = hiltViewModel()
) {
    val selectedDifficulty by viewModel.selectedDifficulty.collectAsState()
    var showRecords by remember { mutableStateOf(false) }
    if (showRecords) {
        RecordsDialog(
            onDismiss = { showRecords = false },
            viewModel = viewModel
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Memorice de la Tierra Media",
                fontSize = 32.sp,
                color = Golden,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            CustomSpacer(20)
            DifficultySelector(
                selectedDifficulty = selectedDifficulty,
                onDifficultySelected = viewModel::setDifficulty
            )
            CustomSpacer(32)
            AnimatedGlowButton(
                text = "iniciar",
                onClick = {
                    navController.navigate(Routes.MemoryGame.createRoute(selectedDifficulty))
                }
            )
            Text(
                text = "Ver Mejores Tiempos",
                color = Golden,
                modifier = Modifier
                    .clickable { showRecords = true }
                    .padding(top = 30.dp),
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.cardo)),
                textDecoration = TextDecoration.Underline
            )
        }
    }
}