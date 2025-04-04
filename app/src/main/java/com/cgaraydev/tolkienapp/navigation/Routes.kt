package com.cgaraydev.tolkienapp.navigation

sealed class Routes(val route: String) {
    data object Home: Routes("home")
    data object Characters: Routes("characters")
    data object Locations: Routes("locations")
    data object Races: Routes("races")
    data object Maps: Routes("maps")
    data object Tolkien: Routes("tolkien")
    data object Movies: Routes("movies")
    data object Books: Routes("books")
    data object Games: Routes("games")
    data object Trivia: Routes("trivia")
    data object Events: Routes("events")
    data object Languages: Routes("languages")
    data object Others: Routes("others")
}