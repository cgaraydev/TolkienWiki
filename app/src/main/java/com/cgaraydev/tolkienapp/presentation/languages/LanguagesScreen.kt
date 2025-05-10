package com.cgaraydev.tolkienapp.presentation.languages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableSubCategory
import com.cgaraydev.tolkienapp.presentation.components.ListItem
import com.cgaraydev.tolkienapp.presentation.components.LoadingIndicator
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader

@Composable
fun LanguagesScreen(
    navController: NavController,
    viewModel: LanguagesViewModel = hiltViewModel()
) {
    val languages by viewModel.languages.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.languages, label = stringResource(R.string.languages))
        CustomHeightSpacer(40)

        if (languages.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoadingIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                val mainCategories = listOf(
                    "Lenguas Humanas", "Lenguas Enanas",
                    "Lenguas Elficas", "Escritura",
                    "Todos"
                )

                items(mainCategories) { category ->
                    val languagesByCategory = viewModel.getLanguagesByTag(category)
                    ExpandableSubCategory(
                        title = category,
                        items = languagesByCategory,
                        itemCount = languagesByCategory.size
                    ) { language ->
                        ListItem(
                            text = language.name,
                            onClick = {
                                navController.navigate(
                                    Routes.LanguageDetails.createRoute(language.id)
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}