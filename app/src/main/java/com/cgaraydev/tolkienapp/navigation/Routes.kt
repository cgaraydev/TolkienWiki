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
    data object RaceDetails : Routes("raceDetails/{raceId}") {
        fun createRoute(raceId: String) = "raceDetails/$raceId"
    }

    data object Events : Routes("events")
    data object EventDetails : Routes("eventDetails/{eventId}") {
        fun createRoute(eventId: String) = "eventDetails/$eventId"
    }

    data object Others : Routes("others")
    data object OtherDetails : Routes("otherDetails/{otherId}") {
        fun createRoute(otherId: String) = "otherDetails/$otherId"
    }

    data object Languages : Routes("languages")
    data object LanguageDetails : Routes("languageDetails/{languageId}"){
        fun createRoute(languageId: String) = "languageDetails/$languageId"
    }

    data object Maps : Routes("maps")
    data object MapDetails : Routes("mapDetails/{mapId}") {
        fun createRoute(mapId: String) = "mapDetails/$mapId"
    }

    data object Tolkien : Routes("tolkien")

    data object QuizIntro : Routes("quizIntro")
    data object QuizQuestions : Routes("quizQuestions/{difficulty}") {
        fun createRoute(difficulty: String) = "quizQuestions/$difficulty"
    }
    data object QuizResult : Routes("quizResult/{correct}/{total}"){
        fun createRoute(correct: Int, total: Int) = "quizResult/$correct/$total"
    }






    data object Movies : Routes("movies")
    data object Books : Routes("books")
    data object Games : Routes("games")
}