package com.cgaraydev.tolkienapp.presentation.others

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
fun OthersScreen(
    navController: NavController,
    viewModel: OthersViewModel = hiltViewModel()
) {
    val others by viewModel.others.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.others, label = stringResource(R.string.others))
        CustomHeightSpacer(40)

        if (others.isEmpty()) {
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
                    "Armas", "Plantas", "Navíos",
                    "Artefactos", "Gente", "Casas Nobles",
                    "Periodos", "Todos"
                )

                items(mainCategories) { category ->
                    val othersByCategory = viewModel.getOthersByTag(category)
                    ExpandableSubCategory(
                        title = category,
                        items = othersByCategory,
                        itemCount = othersByCategory.size,
                    ) { other ->
                        ListItem(
                            text = other.name,
                            onClick = {
                                navController.navigate(
                                    Routes.OtherDetails.createRoute(other.id)
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}