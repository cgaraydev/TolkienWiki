package com.cgaraydev.tolkienapp.presentation.characters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.Character
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailHeader
import com.cgaraydev.tolkienapp.presentation.components.DetailImage
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.DetailScreenTemplate
import com.cgaraydev.tolkienapp.presentation.components.GenderIcon
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.utils.HtmlText


@Composable
fun CharacterDetailsScreen(
    characterId: String,
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val character by viewModel.characterDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    DetailScreenTemplate(
        itemId = characterId,
        viewModel = viewModel,
        loadDetails = { viewModel.loadCharacterDetails(it) },
        isLoading = isLoading,
        error = error,
        item = character
    ) { characterItem ->
        CharacterDetailsContent(
            character = characterItem,
            navController = navController
        )
    }
}

@Composable
fun CharacterDetailsContent(
    character: Character,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(title = character.name ?: "")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                DetailImage(
                    imageUrl = character.poster,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    GenderIcon(
                        gender = character.genre
                    )
                }

                DetailRow(
                    label = stringResource(R.string.race),
                    value = character.race,
                    navController = navController

                )

                DetailRow(
                    stringResource(R.string.other_names),
                    character.otherNames,
                    navController
                )
                DetailRow(stringResource(R.string.birth), character.birth, navController)
                DetailRow(stringResource(R.string.death), character.death, navController)
                DetailRow(stringResource(R.string.titles), character.titles, navController)
                DetailRow(stringResource(R.string.house), character.house, navController)
                DetailRow(stringResource(R.string.family), character.family, navController)
                DetailRow(stringResource(R.string.love), character.love, navController)

                CustomSpacer(24)
                CustomExpandable(title = stringResource(R.string.biography)) {
                    HtmlText(
                        htmlText = character.biography ?: "",
                        navController = navController
                    )
                }
                WikiLinksExpandable(
                    wikiUrls = character.wikiUrl
                )
                character.images?.let { images ->
                    CustomExpandable(title = stringResource(R.string.images)) {
                        ImageCarousel(
                            images = images,
                            modifier = Modifier.padding(vertical = 16.dp),
                            navController = navController
                        )
                    }
                }
                CustomSpacer(150)
            }
        }
    }
}

