package com.cgaraydev.tolkienapp.presentation.races

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cgaraydev.tolkienapp.data.Race
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun RaceDetailsScreen(
    raceId: String,
    navController: NavController,
    viewModel: RacesViewModel = hiltViewModel()
) {
    val race by viewModel.raceDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    LaunchedEffect(raceId) {
        viewModel.loadRaceDetails(raceId)
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

            race != null -> {
                RaceDetailsContent(race = race!!, navController = navController)
            }
        }
    }
}

@Composable
fun RaceDetailsContent(
    race: Race,
    navController: NavController
) {
    Column {
        Text(
            text = race.name,
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
                race.poster.let { url ->
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
                DetailRow("Otros nombres", race.otherNames, navController)
                DetailRow("Ubicaciones", race.location, navController)
                DetailRow("Idiomas", race.languages, navController)
                DetailRow("Pueblos", race.people, navController)
                DetailRow("Miembros destacados", race.members, navController)
                DetailRow("Esperanza de vida", race.lifespan, navController)
                DetailRow("Etimologia", race.etymology, navController)
                CustomSpacer(16)
                race.origins?.let {
                    CustomExpandable("Origenes") {
                        HtmlText(
                            htmlText = race.origins,
                            navController = navController
                        )
                    }
                }
                race.characteristics?.let {
                    CustomExpandable("Caracteristicas") {
                        HtmlText(
                            htmlText = race.characteristics,
                            navController = navController
                        )
                    }
                }
                CustomExpandable("Historia") {
                    HtmlText(
                        htmlText = race.history!!,
                        navController = navController
                    )
                }
                WikiLinksExpandable(
                    wikiUrls = race.wikiUrl
                )
                race.images?.let {
                    CustomExpandable(title = "Imagenes") {
                        ImageCarousel(
                            images = race.images,
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