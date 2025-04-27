package com.cgaraydev.tolkienapp.presentation.locations

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
import com.cgaraydev.tolkienapp.data.models.Location
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailHeader
import com.cgaraydev.tolkienapp.presentation.components.DetailImage
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.DetailScreenTemplate
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun LocationDetailsScreen(
    locationId: String,
    navController: NavController,
    viewModel: LocationsViewModel = hiltViewModel()
) {
    val location by viewModel.locationDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    DetailScreenTemplate(
        itemId = locationId,
        viewModel = viewModel,
        loadDetails = { viewModel.loadLocationDetails(it) },
        isLoading = isLoading,
        error = error,
        item = location
    ) { locationItem ->
        LocationDetailsContent(
            location = locationItem,
            navController = navController
        )
    }
}

@Composable
fun LocationDetailsContent(
    location: Location,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(title = location.name)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                CustomSpacer(16)
                DetailImage(
                    imageUrl = location.poster,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )
                CustomSpacer(16)
                DetailRow("Tipo", location.type, navController)
                DetailRow("Otros nombres", location.otherNames, navController)
                DetailRow("Fundada", location.founded, navController)
                DetailRow("Destruida", location.destroyed, navController)
                DetailRow("Ubicación", location.location, navController)
                DetailRow("Eventos", location.events, navController)
                DetailRow("Idiomas", location.languages, navController)
                DetailRow("Etimología", location.etymology, navController)
                DetailRow("Habitantes", location.inhabitants, navController)
                CustomSpacer(24)
                CustomExpandable(title = stringResource(R.string.biography)) {
                    HtmlText(
                        htmlText = location.history ?: "",
                        navController = navController
                    )
                }
                WikiLinksExpandable(
                    wikiUrls = location.wikiUrl
                )
                location.images?.let {
                    CustomExpandable(title = "Imágenes") {
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