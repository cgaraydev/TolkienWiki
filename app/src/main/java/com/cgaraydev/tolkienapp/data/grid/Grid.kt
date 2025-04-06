package com.cgaraydev.tolkienapp.data.grid

import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes


data class GridItem(
    val title: String,
    val imageRes: Int,
    val route: String
)

val gridItems = listOf(
    GridItem("Personajes", R.drawable.characters, Routes.Characters.route),
    GridItem("Lugares", R.drawable.locations, Routes.Locations.route),
    GridItem("Razas", R.drawable.races, Routes.Races.route),
    GridItem("Eventos", R.drawable.events, Routes.Events.route),
    GridItem("Mapas", R.drawable.maps, Routes.Maps.route),
    GridItem("Trivia", R.drawable.maps, Routes.Trivia.route)
)