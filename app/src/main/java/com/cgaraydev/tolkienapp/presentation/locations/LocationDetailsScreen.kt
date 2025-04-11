package com.cgaraydev.tolkienapp.presentation.locations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun LocationDetailsScreen(
    locationId: String,
    navController: NavController,
    viewModel: LocationsViewModel = hiltViewModel()
) {
}