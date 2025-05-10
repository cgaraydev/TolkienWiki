package com.cgaraydev.tolkienapp.presentation.events

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
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableSubCategory
import com.cgaraydev.tolkienapp.presentation.components.ListItem
import com.cgaraydev.tolkienapp.presentation.components.LoadingIndicator
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader

@Composable
fun EventsScreen(
    navController: NavController,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val events by viewModel.events.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.events, label = stringResource(R.string.events))
        CustomSpacer(40)

        if (events.isEmpty()) {
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
                    "Batallas", "Guerras", "Asedios",
                    "Primera Edad", "Segunda Edad", "Tercera Edad",
                    "Guerra de las Joyas", "Guerra del Anillo", "Todos"
                )

                items(mainCategories) { category ->
                    val eventsByCategory = viewModel.getEventsByTag(category)
                    ExpandableSubCategory(
                        title = category,
                        items = eventsByCategory,
                        itemCount = eventsByCategory.size
                    ) { event ->
                        ListItem(
                            text = event.name,
                            onClick = {
                                navController.navigate(
                                    Routes.EventDetails.createRoute(event.id)
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}