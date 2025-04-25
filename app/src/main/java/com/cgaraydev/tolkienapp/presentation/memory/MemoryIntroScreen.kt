package com.cgaraydev.tolkienapp.presentation.memory

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.AnimatedGlowButton
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
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
                fontWeight = FontWeight.Bold,
                color = Golden,
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
                onClick = {
                    navController.navigate(Routes.MemoryGame.createRoute(selectedDifficulty))
                }
            )
            Text(
                text = "Ver Mejores Tiempos",
                color = Golden,
                modifier = Modifier
                    .clickable { showRecords = true }
                    .padding(16.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun DifficultySelector(
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
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            difficulties.forEach { difficulty ->
                val isSelected = difficulty == selectedDifficulty
                Box(modifier = Modifier
                    .clickable { onDifficultySelected(difficulty) }
                    .background(
                        color = if (isSelected) Color(0xFFE1C16E) else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)) {
                    Text(
                        text = difficulty,
                        fontSize = 16.sp,
                        color = if (isSelected) Color.Black else Color.White,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun RecordsDialog(
    onDismiss: () -> Unit,
    viewModel: MemoryViewModel
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val difficulties = listOf("hobbit", "elfo", "ainur")
    val times by viewModel.getBestTimes(difficulties[selectedTab]).collectAsState(emptyList())

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF1E1E1E),
            border = BorderStroke(1.dp, Golden)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("🏆 Mejores Tiempos",
                    color = Golden,
                    fontSize = 20.sp)

                TabRow(selectedTabIndex = selectedTab) {
                    difficulties.forEachIndexed { index, difficulty ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = { Text(difficulty.uppercase()) }
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                if (times.isEmpty()) {
                    Text("No hay registros aún", color = Color.White)
                } else {
                    Column {
                        times.forEachIndexed { index, time ->
                            Text(
                                text = "${index + 1}. ${time.toTimeString()}",
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Golden,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Cerrar")
                }
            }
        }
    }
}

fun Long.toTimeString(): String {
    return "${(this / 60).toString().padStart(2, '0')}:${(this % 60).toString().padStart(2, '0')}"
}