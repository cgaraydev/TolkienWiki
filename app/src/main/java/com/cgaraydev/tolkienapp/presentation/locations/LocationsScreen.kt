package com.cgaraydev.tolkienapp.presentation.locations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableCategory
import com.cgaraydev.tolkienapp.presentation.components.ExpandableSubCategory
import com.cgaraydev.tolkienapp.presentation.components.ListItem
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun LocationsScreen(
    navController: NavController,
    viewModel: LocationsViewModel = hiltViewModel()
) {
    val locations by viewModel.locations.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.locations, label = "Ubicaciones")
        CustomSpacer(40)

        if (locations.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Golden)
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                val mainCategories = listOf(
                    "Ciudades", "Ríos", "Montañas", "Bosques",
                    "Valles", "Fortalezas", "Continentes", "Todas"
                )

                items(mainCategories) { category ->
                    val locationsByCategory = viewModel.getLocationsByTag(category)
                    ExpandableSubCategory(
                        title = category,
                        items = locationsByCategory,
                        itemCount = locationsByCategory.size,
                        titleTextStyle = TextStyle(
                            fontSize = 24.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.cardo))
                        ),
                        countTextStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White.copy(alpha = 0.7f),
                            fontFamily = FontFamily(Font(R.font.cardo))
                        )
                    ) { location ->
                        ListItem(
                            item = location,
                            text = location.name,
                            onClick = {
                                navController.navigate(
                                    Routes.LocationDetails.createRoute(location.id)
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 18.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.cardo))
                            )
                        )
                    }
                }
            }
        }
        CustomSpacer(40)
    }
}