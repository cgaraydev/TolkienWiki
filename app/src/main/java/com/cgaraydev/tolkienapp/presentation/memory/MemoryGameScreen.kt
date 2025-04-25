package com.cgaraydev.tolkienapp.presentation.memory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.GameResultDialog
import com.cgaraydev.tolkienapp.presentation.components.GameStats
import com.cgaraydev.tolkienapp.presentation.components.MemoryCardItem
import com.cgaraydev.tolkienapp.ui.theme.Golden
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


    LaunchedEffect(difficulty) {
        viewModel.setDifficulty(difficulty)
    }


    LaunchedEffect(Unit) {
        viewModel.uiEvent.collectLatest { message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    val gridColumns = when (difficulty) {
        "hobbit" -> 4
        "elfo" -> 6
        "ainur" -> 8
        else -> 4
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "dificultad: " + difficulty.uppercase(),
                    color = Color.White,
                    fontSize = 14.sp,
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_replay),
                        contentDescription = null,
                        tint = Golden,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            IconButton(
                onClick = { viewModel.togglePause() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = if (isGamePaused) {
                        painterResource(R.drawable.ic_play)
                    } else {
                        painterResource(R.drawable.ic_pause)
                    },
                    contentDescription = null,
                    tint = Golden,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        GameStats(moveCount, elapsedTime, isGamePaused)
        CustomSpacer(20)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(
                    when {
                        isGamePaused -> 0.5f
                        gameState is GameState.FINISHED -> 0.7f
                        else -> 1f
                    }
                )
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
                    val highlight = matchEffect?.first == card.id
                    MemoryCardItem(
                        card = card,
                        highlight = highlight,
                        isInteractionBlocked = isInteractionBlocked,
                        onClick = {
                            viewModel.flipCard(card.id)
                        }
                    )
                }

            }
            if (isGamePaused) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.7f))
                        .clickable { viewModel.togglePause() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "JUEGO EN PAUSA",
                        color = Golden,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            if (gameState is GameState.FINISHED) {
                LaunchedEffect(Unit) {
                    viewModel.saveBestTimeIfNeeded()
                }
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
}



