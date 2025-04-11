package com.cgaraydev.tolkienapp.navigation

sealed class Routes(val route: String) {

    data object Home : Routes("home")
    data object Characters : Routes("characters")
    data object CharacterDetails : Routes("characterDetails/{characterId}") {
        fun createRoute(characterId: String) = "characterDetails/$characterId"
    }
    data object Locations : Routes("locations")
    data object LocationDetails : Routes("locationDetails/{locationId}") {
        fun createRoute(locationId: String) = "locationDetails/$locationId"
    }
    data object Races : Routes("races")
    data object Maps : Routes("maps")
    data object Tolkien : Routes("tolkien")
    data object Movies : Routes("movies")
    data object Books : Routes("books")
    data object Games : Routes("games")
    data object Trivia : Routes("trivia")
    data object Events : Routes("events")
    data object Languages : Routes("languages")
    data object Others : Routes("others")
}