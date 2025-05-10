package com.cgaraydev.tolkienapp.presentation.races

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.data.local.datalocal.RaceData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.AnimatedTextTitle
import com.cgaraydev.tolkienapp.presentation.components.GradientOverlay

@Composable
fun RacesScreen(
    viewModel: RacesViewModel = hiltViewModel(),
    navController: NavController
) {
    val racesLocal by viewModel.racesLocal

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(racesLocal) { race ->
                RaceItem(race = race, navController = navController)
            }
        }
    }
}
//
//@SuppressLint("UnusedBoxWithConstraintsScope")
//@Composable
//fun RaceItem(
//    race: RaceData,
//    navController: NavController
//) {
//
//    val interactionSource = remember { MutableInteractionSource() }
//    val isPressed by interactionSource.collectIsPressedAsState()
//    val elevation by animateDpAsState(if (isPressed) 8.dp else 4.dp)
//
//    val infiniteTransition = rememberInfiniteTransition()
//
//    val breathAlpha by infiniteTransition.animateFloat(
//        initialValue = 0.6f,
//        targetValue = 1f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(1200, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    val shadowColor by infiniteTransition.animateColor(
//        initialValue = Golden,
//        targetValue = Pumpkin,
//        animationSpec = infiniteRepeatable(
//            tween(4000, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(200.dp)
//            .clickable(
//                interactionSource = interactionSource,
//                indication = rememberRipple(),
//                onClick = { navController.navigate(Routes.RaceDetails.createRoute(race.id)) }
//            ),
//        shape = RoundedCornerShape(12.dp),
//        elevation = CardDefaults.cardElevation(elevation),
//        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
//    ) {
//        Box {
//            Image(
//                painter = painterResource(race.imageRes),
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Transparent,
//                                Color.Black.copy(alpha = 0.5f)
//                            ),
//                            startY = 100f
//                        )
//                    )
//            ) {
//                Text(
//                    text = race.name.uppercase(),
//                    color = Color.White.copy(alpha = breathAlpha), // ¡Aquí está la clave!
//                    fontSize = 26.sp,
//                    fontFamily = FontFamily(Font(R.font.aniron)),
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(16.dp)
//                        .fillMaxWidth(),
//                    style = TextStyle(
//                        shadow = Shadow(
//                            color = shadowColor,
//                            offset = Offset(15f, 10f),
//                            blurRadius = 20f
//                        )
//                    ),
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    }
//}

@Composable
fun RaceItem(
    race: RaceData,
    navController: NavController
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val elevation by animateDpAsState(if (isPressed) 8.dp else 4.dp)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = { navController.navigate(Routes.RaceDetails.createRoute(race.id)) }
            ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(elevation),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box {
            Image(
                painter = painterResource(race.imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            GradientOverlay(alpha = 0.5f, startYRatio = 1f)

            AnimatedTextTitle(
                text = race.name,
                modifier = Modifier.align(Alignment.BottomCenter),
                fontSize = 26.sp,
                paddingValues = PaddingValues(16.dp),
                shadowOffset = Offset(15f, 10f),
                shadowBlur = 20f
            )
        }
    }
}