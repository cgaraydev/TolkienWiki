package com.cgaraydev.tolkienapp.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.Character
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.ui.theme.Golden
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

    LaunchedEffect(characterId) {
        viewModel.loadCharacterDetails(characterId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Golden
                )
            }

            error != null -> {
                Text(
                    text = error!!,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            character != null -> {
                CharacterDetailsContent(character = character!!, navController = navController)
            }
        }
    }
}

@Composable
fun CharacterDetailsContent(
    character: Character,
    navController: NavController
) {
    Column {
        Text(
            text = character.name!!,
            fontSize = 48.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            textAlign = TextAlign.Center
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                CustomSpacer(16)
                character.poster?.let { url ->
                    AsyncImage(
                        model = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/$url",
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    CustomSpacer(16)
                }
                Row {
                    val iconVector = when (character.genre?.lowercase()) {
                        stringResource(R.string.male) -> R.drawable.ic_male
                        stringResource(R.string.female) -> R.drawable.ic_female
                        else -> R.drawable.ic_unknown
                    }
                    DetailRow(stringResource(R.string.race), character.race, navController)
                    Spacer(Modifier.weight(1f))
                    Icon(
                        painter = painterResource(iconVector),
                        contentDescription = null,
                        tint = Golden
                    )
                }
                DetailRow(stringResource(R.string.other_names), character.otherNames, navController)
                DetailRow(stringResource(R.string.birth), character.birth, navController)
                DetailRow(stringResource(R.string.death), character.death, navController)
                DetailRow(stringResource(R.string.titles), character.titles, navController)
                DetailRow(stringResource(R.string.house), character.house, navController)
                DetailRow(stringResource(R.string.family), character.family, navController)
                DetailRow(stringResource(R.string.love), character.love, navController)
                CustomSpacer(24)
                CustomExpandable(title = stringResource(R.string.biography)) {
                    HtmlText(
                        htmlText = character.biography!!,
                        navController = navController,
                    )
                }
                WikiLinksExpandable(
                    wikiUrls = character.wikiUrl
                )
                character.images?.let {
                    CustomExpandable(title = stringResource(R.string.images)) {
                        ImageCarousel(
                            images = character.images,
                            modifier = Modifier.padding(vertical = 16.dp),
                            navController = navController
                        )
                    }
                }
                CustomSpacer(40)
            }
        }
    }
}


