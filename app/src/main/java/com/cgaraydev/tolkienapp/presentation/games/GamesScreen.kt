package com.cgaraydev.tolkienapp.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.GameData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomCard
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableHorizontalSection
import com.cgaraydev.tolkienapp.presentation.components.LoadingIndicator
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader

@Composable
fun GamesScreen(
    navController: NavController,
    viewModel: GamesViewModel = hiltViewModel()
) {
    val games by viewModel.games.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(
            imageRes = R.drawable.games,
            label = stringResource(R.string.games)
        )
        CustomHeightSpacer()

        if (games.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoadingIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                val mainCategories = listOf(
                    "Juegos de video", "Playstation",
                    "Xbox", "PC", "Todos"
                )

                items(mainCategories) { category ->
                    val gamesByCategory = viewModel.getGamesByTag(category)
                    if (gamesByCategory.isNotEmpty()) {
                        ExpandableHorizontalSection(
                            title = category,
                            items = gamesByCategory,
                            itemCount = gamesByCategory.size
                        ) { game ->
                            GameCard(
                                game = game
                            ) {
                                navController.navigate(Routes.GameDetails.createRoute(game.id))
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    game: GameData,
    onClick: () -> Unit
){
    CustomCard(
        modifier = modifier
            .width(160.dp)
            .height(240.dp)
            .padding(8.dp),
        imageRes = game.imageRes,
        title = game.name,
        onClick = onClick,
        contentDescription = "Portada de ${game.name}"
    )
}