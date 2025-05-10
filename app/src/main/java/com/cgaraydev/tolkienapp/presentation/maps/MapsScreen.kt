package com.cgaraydev.tolkienapp.presentation.maps

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.MapData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.AnimatedTextTitle
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.GradientOverlay
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader

@Composable
fun MapsScreen(
    navController: NavController,
    viewModel: MapsViewModel = hiltViewModel()
) {
    val maps by viewModel.mapsLocal

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.maps, label = stringResource(R.string.maps))
        CustomHeightSpacer(40)

        MapsGrid(
            maps = maps,
            onClick = { mapId ->
                navController.navigate(Routes.MapDetails.createRoute(mapId))
            })
    }
}

@Composable
fun MapsGrid(
    maps: List<MapData>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp), // Padding lateral reducido
        verticalArrangement = Arrangement.spacedBy(12.dp), // Espaciado reducido
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(maps) { map ->
            MapCard(
                map = map,
                modifier = Modifier.padding(4.dp), // Padding interno
                onClick = { onClick(map.id) }
            )
        }
    }
}

@Composable
fun MapCard(
    map: MapData,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val elevation by animateDpAsState(if (isPressed) 8.dp else 4.dp)

    Card(
        modifier = modifier
            .aspectRatio(1f)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = onClick
            ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(elevation),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box {
            Image(
                painter = painterResource(map.thumbnailRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            GradientOverlay(alpha = 0.9f, startYRatio = 0.1f)

            AnimatedTextTitle(
                text = map.name,
                modifier = Modifier.align(Alignment.BottomCenter),
                fontSize = 16.sp,
                shadowOffset = Offset(8f, 6f)
            )
        }
    }
}

