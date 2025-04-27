package com.cgaraydev.tolkienapp.presentation.events

import androidx.compose.foundation.layout.Column
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
import com.cgaraydev.tolkienapp.data.models.Event
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailHeader
import com.cgaraydev.tolkienapp.presentation.components.DetailImage
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.DetailScreenTemplate
import com.cgaraydev.tolkienapp.presentation.components.GoodEvilSection
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
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

    DetailScreenTemplate(
        itemId = eventId,
        viewModel = viewModel,
        loadDetails = { viewModel.loadEventDetails(it) },
        isLoading = isLoading,
        error = error,
        item = event
    ) { eventItem ->
        EventDetailsContent(
            event = eventItem,
            navController = navController
        )
    }
}

@Composable
fun EventDetailsContent(
    event: Event,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(title = event.name)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                CustomSpacer(16)
                DetailImage(
                    imageUrl = event.poster,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )
                CustomSpacer(16)
                DetailRow("Otros nombres", event.otherNames, navController)
                DetailRow("Categoria", event.category, navController)
                DetailRow("Conflicto", event.conflict, navController)
                DetailRow("Fecha", event.date, navController)
                DetailRow("Lugar", event.location, navController)
                DetailRow("Desenlace", event.outcome, navController)
                DetailRow("Involucrados", event.involved, navController)
                DetailRow("Etimología", event.etymology, navController)
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