package com.cgaraydev.tolkienapp.presentation.components.grid

import com.cgaraydev.tolkienapp.R


data class GridItem(
    val title: String,
    val imageRes: Int
)

val gridItems = listOf(
    GridItem("Personajes", R.drawable.characters),
    GridItem("Lugares", R.drawable.locations),
    GridItem("Razas", R.drawable.races),
    GridItem("Eventos", R.drawable.events),
    GridItem("Mapas", R.drawable.maps),
    GridItem("Trivia", R.drawable.maps)
)