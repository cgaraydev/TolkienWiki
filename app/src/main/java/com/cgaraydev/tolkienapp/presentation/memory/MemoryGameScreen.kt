package com.cgaraydev.tolkienapp.presentation.memory

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.MemoryCard
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.MatchGreen
import kotlinx.coroutines.launch

//FUNCIONAL
//@Composable
//fun MemoryGameScreen(
//    navController: NavController,
//    difficulty: String,
//    viewModel: MemoryViewModel = hiltViewModel()
//) {
//
//    val cards by viewModel.cards.collectAsState()
//
//    LaunchedEffect(difficulty) {
//        viewModel.setDifficulty(difficulty)
//    }
//
//    val gridColumns = when (difficulty) {
//        "hobbit" -> 4
//        "elfo" -> 6
//        "maia" -> 8
//        else -> 4
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .padding(16.dp)
//    ) {
//        Text(
//            "Memorice de la Tierra Media",
//            color = Color.White,
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center
//        )
//        CustomSpacer(20)
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(gridColumns),
//            verticalArrangement = Arrangement.spacedBy(10.dp),
//            horizontalArrangement = Arrangement.spacedBy(10.dp),
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            items(cards, key = { it.id }) { card ->
//                MemoryCardItem(
//                    card = card,
//                    onClick = {
//                        viewModel.flipCard(card.id)
//                    }
//                )
//            }
//        }
//    }
//}
//
//
//@Composable
//fun MemoryCardItem(
//    card: MemoryCard,
//    onClick: () -> Unit
//) {
//    val rotation by animateFloatAsState(
//        targetValue = if (card.isFaceUp) 180f else 0f,
//        animationSpec = tween(durationMillis = 400)
//    )
//    Box(
//        modifier = Modifier
//            .aspectRatio(0.7f)
//            .graphicsLayer {
//                rotationY = rotation
//                cameraDistance = 12f * density
//
//            }
//            .clip(RoundedCornerShape(12.dp))
//            .clickable { onClick() },
//        contentAlignment = Alignment.Center
//    ) {
//        if (rotation <= 90f) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.White)
//                    .border(2.dp, Golden, RoundedCornerShape(12.dp)),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.logo),
//                    contentDescription = "Card Back",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(4.dp)
//                )
//            }
//        } else {
//            if (card.imageRes != 0) {
//                Image(
//                    painter = painterResource(id = card.imageRes),
//                    contentDescription = card.content,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//            } else {
//                Text(
//                    text = card.content,
//                    color = Color.White,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.padding(8.dp)
//                )
//            }
//        }
//    }
//
//}

@Composable
fun MemoryGameScreen(
    navController: NavController,
    difficulty: String,
    viewModel: MemoryViewModel = hiltViewModel()
) {
    val cards by viewModel.cards.collectAsState()
    val matchEffect by viewModel.matchEffect.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() } // Corregido
    val scope = rememberCoroutineScope()

    LaunchedEffect(difficulty) {
        viewModel.setDifficulty(difficulty)
    }

    LaunchedEffect(matchEffect) {
        matchEffect?.second?.let { name ->
            scope.launch {
                snackbarHostState.showSnackbar("Has encontrado a $name")
            }
        }
    }

    val gridColumns = when (difficulty) {
        "hobbit" -> 4
        "elfo" -> 6
        "maia" -> 8
        else -> 4
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // Corregido
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                "Memorice de la Tierra Media",
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            CustomSpacer(20)
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
                        onClick = {
                            viewModel.flipCard(card.id)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MemoryCardItem(
    card: MemoryCard,
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
            .clickable { onClick() },
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
