package com.cgaraydev.tolkienapp.presentation.components.drawer

import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes

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

object Items {
    val sections = listOf(
        ItemSection(
            "Tierra Media", listOf(
                Item(
                    "Personajes",
                    false,
                    R.drawable.ic_characters,
                    "Personajes",
                    Routes.Characters.route
                ),
                Item(
                    "Ubicaciones",
                    false,
                    R.drawable.ic_locations,
                    "Ubicaciones",
                    Routes.Locations.route
                ),
                Item(
                    "Razas",
                    false,
                    R.drawable.ic_race,
                    "Razas",
                    Routes.Races.route
                ),
                Item(
                    "Eventos",
                    false,
                    R.drawable.ic_maps,
                    "Eventos",
                    Routes.Events.route
                ),
                Item(
                    "Mapas",
                    false,
                    R.drawable.ic_maps,
                    "Mapas",
                    Routes.Maps.route
                ),
                Item(
                    "Lenguas/Escritura",
                    false,
                    R.drawable.ic_ring,
                    "Lenguas",
                    Routes.Languages.route
                ),
                Item(
                    "Otros",
                    false,
                    R.drawable.ic_ring,
                    "Otros",
                    Routes.Others.route
                )
            )
        ),
        ItemSection(
            "Legado Tolkien", listOf(
                Item(
                    "Tolkien",
                    false,
                    R.drawable.ic_ring,
                    "Tolkien",
                    Routes.Tolkien.route
                ),
                Item(
                    "Adaptaciones",
                    false,
                    R.drawable.ic_movies,
                    "Adaptaciones",
                    Routes.Movies.route
                ),
                Item(
                    "Libros",
                    false,
                    R.drawable.ic_books,
                    "Libros",
                    Routes.Books.route
                ),
                Item(
                    "Juegos",
                    false,
                    R.drawable.ic_games,
                    "Juegos",
                    Routes.Games.route
                )
            )
        ),
        ItemSection(
            "Entretenimiento", listOf(
                Item(
                    "Trivia",
                    false,
                    R.drawable.ic_dice,
                    "Trivia",
                    Routes.Trivia.route
                ),
                Item(
                    "Memes",
                    false,
                    R.drawable.ic_movies,
                    "Memes",
                    Routes.Movies.route
                )
            )
        )
    )
}