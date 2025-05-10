package com.cgaraydev.tolkienapp.presentation.memory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.GameBoard
import com.cgaraydev.tolkienapp.presentation.components.GameHeader
import com.cgaraydev.tolkienapp.presentation.components.GameResultDialog
import com.cgaraydev.tolkienapp.presentation.components.GameStats
import com.cgaraydev.tolkienapp.utils.GameState
import kotlinx.coroutines.flow.collectLatest


@Composable
fun MemoryGameScreen(
    navController: NavController,
    difficulty: String,
    snackbarHostState: SnackbarHostState,
    viewModel: MemoryViewModel = hiltViewModel()
) {
    val cards by viewModel.cards.collectAsState()
    val matchEffect by viewModel.matchEffect.collectAsState()
    val isInteractionBlocked by viewModel.isInteractionBlocked.collectAsState()
    val moveCount by viewModel.moveCount.collectAsState()
    val elapsedTime by viewModel.elapsedTime.collectAsState()
    val isGamePaused by viewModel.isGamePaused.collectAsState()
    val gameState by viewModel.gameState.collectAsState()
    val shouldDim by viewModel.shouldDimBackground.collectAsState()
    val gridColumns = viewModel.getGridColumns()

    LaunchedEffect(difficulty) { viewModel.setDifficulty(difficulty) }
    LaunchedEffect(Unit) {
        viewModel.uiEvent.collectLatest {
            snackbarHostState.showSnackbar(it)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        GameHeader(
            difficulty = difficulty,
            onBack = { navController.popBackStack() },
            isPaused = isGamePaused,
            onTogglePause = { viewModel.togglePause() }
        )
        GameStats(moveCount, elapsedTime, isGamePaused)
        CustomHeightSpacer(20)
        GameBoard(
            cards = cards,
            matchEffect = matchEffect,
            isInteractionBlocked = isInteractionBlocked,
            gridColumns = gridColumns,
            shouldDim = shouldDim,
            onCardClick = { viewModel.flipCard(it) }
        )
        if (gameState is GameState.FINISHED) {
            LaunchedEffect(Unit) { viewModel.saveBestTimeIfNeeded() }
            GameResultDialog(
                moves = moveCount,
                time = elapsedTime,
                difficulty = difficulty,
                onDismiss = { navController.popBackStack() },
                onRestart = { viewModel.restartGame() }
            )
        }
    }
}