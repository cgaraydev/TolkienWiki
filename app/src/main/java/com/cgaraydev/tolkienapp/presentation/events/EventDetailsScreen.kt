package com.cgaraydev.tolkienapp.presentation.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.Event
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.GoodEvilSection
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.PosterImage
import com.cgaraydev.tolkienapp.presentation.components.StateHandler
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun EventDetailsScreen(
    eventId: String,
    navController: NavController,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val event by viewModel.eventDetails.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(eventId) {
        viewModel.loadEventDetails(eventId)
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Golden
            )
        } else if (error != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = error!!, color = Color.Red)
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { viewModel.loadEventDetails(eventId) },
                    colors = ButtonDefaults.buttonColors(containerColor = Golden)
                ) {
                    Text("Reintentar", color = Color.Black)
                }
            }
        } else {
            event?.let {
                EventDetailsContent(event = it, navController = navController)
            } ?: Text(
                text = "Evento no encontrado",
                modifier = Modifier.align(Alignment.Center),
                color = Color.Red
            )
        }
    }
}

@Composable
fun EventDetailsContent(
    event: Event,
    navController: NavController
) {
    Column {
        Text(
            text = event.name,
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
                PosterImage(imagePath = event.poster)
                CustomSpacer(16)
                DetailRow("Otros nombres", event.otherNames, navController)
                DetailRow("Categoria", event.category, navController)
                DetailRow("Conflicto", event.conflict, navController)
                DetailRow("Fecha", event.date, navController)
                DetailRow("Lugar", event.location, navController)
                DetailRow("Desenlace", event.outcome, navController)
                DetailRow("Involucrados", event.involved, navController)
                DetailRow("Etimologia", event.etymology, navController)
                DetailRow("Batallas", event.battles, navController)
                CustomExpandable("Historia") {
                    HtmlText(htmlText = event.history ?: "", navController = navController)
                }
                GoodEvilSection(
                    title = stringResource(R.string.commanders),
                    goodContent = event.commanders?.good,
                    evilContent = event.commanders?.evil,
                    navController = navController
                )
                GoodEvilSection(
                    title = stringResource(R.string.strength),
                    goodContent = event.strength?.good,
                    evilContent = event.strength?.evil,
                    navController = navController
                )
                GoodEvilSection(
                    title = stringResource(R.string.casualties),
                    goodContent = event.casualties?.good,
                    evilContent = event.casualties?.evil,
                    navController = navController
                )
                WikiLinksExpandable(wikiUrls = event.wikiUrl)
                event.images?.let {
                    CustomExpandable(title = stringResource(R.string.images)) {
                        ImageCarousel(
                            images = it,
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


//
//@Composable
//fun EventDetailsScreen(
//    eventId: String,
//    navController: NavController,
//    viewModel: EventsViewModel = hiltViewModel()
//) {
//
//    val event by viewModel.eventDetails.collectAsState()
//    val isLoading by viewModel.isLoadingDetails.collectAsState()
//    val error by viewModel.errorDetails.collectAsState()
//
//    LaunchedEffect(eventId) {
//        viewModel.loadEventDetails(eventId)
//    }
//
//    StateHandler(
//        isLoading = isLoading,
//        error = error
//    ) {
//        event?.let {
//            EventDetailsContent(
//                event = it,
//                navController = navController
//            )
//        } ?: run {
//            Text(
//                text = "Evento no encontrado.",
//                color = Color.Red,
//            )
//        }
//    }
//}
//
//@Composable
//fun EventDetailsContent(
//    event: Event,
//    navController: NavController
//) {
//    Column {
//        Text(
//            text = event.name,
//            fontSize = 48.sp,
//            color = Color.White,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 20.dp),
//            textAlign = TextAlign.Center
//        )
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            item {
//                PosterImage(imagePath = event.poster)
//                CustomSpacer(16)
//                DetailRow("Otros nombres", event.otherNames, navController)
//                DetailRow("Categoria", event.category, navController)
//                DetailRow("Conflicto", event.conflict, navController)
//                DetailRow("Fecha", event.date, navController)
//                DetailRow("Lugar", event.location, navController)
//                DetailRow("Desenlace", event.outcome, navController)
//                DetailRow("Involucrados", event.involved, navController)
//                DetailRow("Etimologia", event.etymology, navController)
//                DetailRow("Batallas", event.battles, navController)
//                CustomExpandable("Historia") {
//                    HtmlText(
//                        htmlText = event.history!!,
//                        navController = navController
//                    )
//                }
//                GoodEvilSection(
//                    title = stringResource(R.string.commanders),
//                    goodContent = event.commanders?.good,
//                    evilContent = event.commanders?.evil,
//                    navController = navController
//                )
//
//                GoodEvilSection(
//                    title = stringResource(R.string.strength),
//                    goodContent = event.strength?.good,
//                    evilContent = event.strength?.evil,
//                    navController = navController
//                )
//
//                GoodEvilSection(
//                    title = stringResource(R.string.casualties),
//                    goodContent = event.casualties?.good,
//                    evilContent = event.casualties?.evil,
//                    navController = navController
//                )
//                WikiLinksExpandable(
//                    wikiUrls = event.wikiUrl
//                )
//                event.images?.let {
//                    CustomExpandable(title = stringResource(R.string.images)) {
//                        ImageCarousel(
//                            images = event.images,
//                            modifier = Modifier.padding(vertical = 16.dp),
//                            navController = navController
//                        )
//                    }
//                }
//                CustomSpacer(40)
//            }
//        }
//    }
//}
