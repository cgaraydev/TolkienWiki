package com.cgaraydev.tolkienapp.presentation.adaptations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.cgaraydev.tolkienapp.data.local.datalocal.AdaptationData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomCard
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableHorizontalSection
import com.cgaraydev.tolkienapp.presentation.components.LoadingIndicator
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader

@Composable
fun AdaptationsScreen(
    navController: NavController,
    viewModel: AdaptationsViewModel = hiltViewModel()
) {
    val adaptations by viewModel.adaptations.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(
            imageRes = R.drawable.adaptations,
            label = stringResource(R.string.adaptations)
        )
        CustomHeightSpacer()

        if (adaptations.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoadingIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                val mainCategories = listOf(
                    "El Señor de los Anillos", "El Hobbit",
                    "Animadas", "Fan Films", "Series de TV",
                    "Todos"
                )

                items(mainCategories) { category ->
                    val adaptationsByCategory = viewModel.getAdaptationsByTags(category)
                    if (adaptationsByCategory.isNotEmpty()) {
                        ExpandableHorizontalSection(
                            title = category,
                            items = adaptationsByCategory,
                            itemCount = adaptationsByCategory.size
                        ) { adaptation ->
                            AdaptationCard(adaptation = adaptation) {
                                navController.navigate(
                                    Routes.AdaptationDetails.createRoute(adaptation.id)
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AdaptationCard(
    modifier: Modifier = Modifier,
    adaptation: AdaptationData,
    onClick: () -> Unit,
) {
    CustomCard(
        modifier = modifier
            .width(160.dp)
            .height(240.dp)
            .padding(8.dp),
        imageRes = adaptation.imageRes,
        title = adaptation.name,
        onClick = onClick,
        contentDescription = "Portada de ${adaptation.name}"
    )
}