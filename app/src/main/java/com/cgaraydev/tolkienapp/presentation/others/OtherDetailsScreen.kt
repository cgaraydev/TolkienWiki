package com.cgaraydev.tolkienapp.presentation.others

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.data.models.Other
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailHeader
import com.cgaraydev.tolkienapp.presentation.components.DetailImage
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.DetailScreenTemplate
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.utils.HtmlText


@Composable
fun OtherDetailsScreen(
    otherId: String,
    navController: NavController,
    viewModel: OthersViewModel = hiltViewModel()
) {
    val other by viewModel.otherDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    DetailScreenTemplate(
        itemId = otherId,
        viewModel = viewModel,
        loadDetails = { viewModel.loadOtherDetails(it) },
        isLoading = isLoading,
        error = error,
        item = other
    ) { otherItem ->
        OtherDetailsContent(
            other = otherItem,
            navController = navController
        )
    }
}

@Composable
fun OtherDetailsContent(
    other: Other,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(title = other.name)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                CustomHeightSpacer(16)
                DetailImage(
                    imageUrl = other.poster,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )

                CustomHeightSpacer(16)

                DetailRow("Otros nombres", other.otherNames, navController)
                DetailRow("Categoría", other.category, navController)
                DetailRow("Descripción", other.description, navController)
                DetailRow("Ubicaciones", other.location, navController)
                DetailRow("Propietario", other.owner, navController)
                DetailRow("Creador", other.creator, navController)
                DetailRow("Idiomas", other.languages, navController)
                DetailRow("Fundador", other.founder, navController)
                DetailRow("Fundado", other.founded, navController)
                DetailRow("Líder", other.leader, navController)
                DetailRow("Artefactos", other.heirlooms, navController)
                DetailRow("Etimología", other.etymology, navController)
                CustomHeightSpacer(16)

                other.history?.let {
                    CustomExpandable("Historia") {
                        HtmlText(
                            htmlText = it,
                            navController = navController
                        )
                    }
                }

                WikiLinksExpandable(wikiUrls = other.wikiUrl)

                other.images?.let { images ->
                    CustomExpandable(title = "Imágenes") {
                        ImageCarousel(
                            images = images,
                            modifier = Modifier.padding(vertical = 16.dp),
                            navController = navController
                        )
                    }
                }
                CustomHeightSpacer(40)
            }
        }
    }
}