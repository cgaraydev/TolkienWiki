package com.cgaraydev.tolkienapp.presentation.role

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.components.LoadingIndicator
import com.cgaraydev.tolkienapp.presentation.components.PlayerStatsHeader
import com.cgaraydev.tolkienapp.presentation.components.ScenarioCard

@Composable
fun RoleScreen(
    navController: NavController,
    viewModel: RoleViewModel = hiltViewModel()
) {
    val playerState by viewModel.playerState.collectAsState()
    val currentScenario by viewModel.currentScenario.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val scenarioText by viewModel.scenarioText.collectAsState()
    val showContinueButton by viewModel.showContinueButton.collectAsState()

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.8f)),
            contentAlignment = Alignment.Center
        ) {
            LoadingIndicator()
        }
        return
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PlayerStatsHeader(playerState)
            ScenarioCard(
                title = currentScenario?.title ?: "",
                text = scenarioText,
                decisions = if (showContinueButton) emptyList() else currentScenario?.decision
                    ?: emptyList(),
                showContinueButton = showContinueButton,
                onOptionSelected = viewModel::selectOption,
                onContinue = viewModel::continueToNextScenario
            )
            IconButton(
                onClick = { viewModel.toggleMute() },
//                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (viewModel.isMuted) R.drawable.ic_language else R.drawable.ic_event
                    ),
                    contentDescription = "Toggle Mute",
                    tint = Color.White
                )
            }
        }
    }
}










