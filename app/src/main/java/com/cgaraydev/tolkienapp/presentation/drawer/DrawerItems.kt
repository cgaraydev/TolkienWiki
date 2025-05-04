package com.cgaraydev.tolkienapp.presentation.drawer

import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.drawer.model.Item
import com.cgaraydev.tolkienapp.presentation.drawer.model.ItemSection

object Items {
    val sections = listOf(
        ItemSection(
            "", listOf(
                Item(
                    label = "Inicio",
                    selected = false,
                    icon = R.drawable.ic_home,
                    contentDescription = "Inicio",
                    route = Routes.Home.route
                )
            )
        ),
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
                    R.drawable.ic_event,
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
                    R.drawable.ic_language,
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
                    R.drawable.ic_tolkien,
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
                    "Videojuegos",
                    false,
                    R.drawable.ic_games,
                    "Videojuegos",
                    Routes.Games.route
                )
            )
        ),
        ItemSection(
            "Entretenimiento", listOf(
                Item(
                    "Quiz",
                    false,
                    R.drawable.ic_quiz,
                    "Quiz",
                    Routes.QuizIntro.route
                ),
                Item(
                    "Memorice",
                    false,
                    R.drawable.ic_memory,
                    "Memorice",
                    Routes.MemoryIntro.route
                ),
                Item(
                    "RPG de texto",
                    false,
                    R.drawable.ic_strength,
                    "RPG",
                    Routes.RoleGame.route
                ),
                Item(
                    "Memes",
                    false,
                    R.drawable.ic_meme,
                    "Memes",
                    Routes.Movies.route
                )
            )
        )
    )
}