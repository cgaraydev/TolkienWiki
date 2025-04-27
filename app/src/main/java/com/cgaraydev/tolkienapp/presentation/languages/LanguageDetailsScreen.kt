package com.cgaraydev.tolkienapp.presentation.languages

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.Language
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailHeader
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.DetailScreenTemplate
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun LanguageDetailsScreen(
    languageId: String,
    navController: NavController,
    viewModel: LanguagesViewModel = hiltViewModel()
) {
    val language by viewModel.languageDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    DetailScreenTemplate(
        itemId = languageId,
        viewModel = viewModel,
        loadDetails = { viewModel.loadLanguageDetails(it) },
        isLoading = isLoading,
        error = error,
        item = language
    ) { languageItem ->
        LanguageDetailsContent(
            language = languageItem,
            navController = navController
        )
    }
}

@Composable
fun LanguageDetailsContent(
    language: Language,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(title = language.name)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                CustomSpacer(16)
                Image(
                    painter = painterResource(R.drawable.logo), // Cambia por tu recurso de logo
                    contentDescription = "Logo de idiomas",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(vertical = 16.dp),
                    contentScale = ContentScale.Fit
                )
                CustomSpacer(16)
                DetailRow("Otros nombres", language.otherNames, navController)
                CustomSpacer(16)
                language.history?.let {
                    CustomExpandable("Historia") {
                        HtmlText(
                            htmlText = language.history,
                            navController = navController
                        )
                    }
                }
                WikiLinksExpandable(
                    wikiUrls = language.wikiUrl
                )
                language.images?.let { images ->
                    CustomExpandable(title = "Imágenes") {
                        ImageCarousel(
                            images = images,
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