package com.cgaraydev.tolkienapp.presentation.drawer.model

data class Item(
    val label: String,
    val selected: Boolean,
    val icon: Int,
    val contentDescription: String,
    val route: String
)

data class ItemSection(
    val title: String,
    val items: List<Item>
)