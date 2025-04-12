package com.cgaraydev.tolkienapp.presentation.languages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.data.Language
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.ui.theme.Golden
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

    LaunchedEffect(languageId) {
        viewModel.loadLanguageDetails(languageId)
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

            language != null -> {
                LanguageDetailsContent(language = language!!, navController = navController)
            }
        }
    }

}

@Composable
fun LanguageDetailsContent(
    language: Language,
    navController: NavController
) {
    Column {
        Text(
            text = language.name,
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
                DetailRow("Otros nombres", language.otherNames, navController)
                CustomExpandable("Historia") {
                    HtmlText(
                        htmlText = language.history!!,
                        navController = navController
                    )
                }
                WikiLinksExpandable(
                    wikiUrls = language.wikiUrl
                )
                language.images?.let {
                    CustomExpandable(title = "Imagenes") {
                        ImageCarousel(
                            images = language.images,
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