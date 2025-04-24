package com.cgaraydev.tolkienapp.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cgaraydev.tolkienapp.presentation.books.BooksScreen
import com.cgaraydev.tolkienapp.presentation.characters.CharacterDetailsScreen
import com.cgaraydev.tolkienapp.presentation.characters.CharactersScreen
import com.cgaraydev.tolkienapp.presentation.events.EventDetailsScreen
import com.cgaraydev.tolkienapp.presentation.events.EventsScreen
import com.cgaraydev.tolkienapp.presentation.games.GamesScreen
import com.cgaraydev.tolkienapp.presentation.home.HomeScreen
import com.cgaraydev.tolkienapp.presentation.languages.LanguageDetailsScreen
import com.cgaraydev.tolkienapp.presentation.languages.LanguagesScreen
import com.cgaraydev.tolkienapp.presentation.locations.LocationDetailsScreen
import com.cgaraydev.tolkienapp.presentation.locations.LocationsScreen
import com.cgaraydev.tolkienapp.presentation.maps.MapDetailsScreen
import com.cgaraydev.tolkienapp.presentation.maps.MapsScreen
import com.cgaraydev.tolkienapp.presentation.memory.MemoryGameScreen
import com.cgaraydev.tolkienapp.presentation.memory.MemoryIntroScreen
import com.cgaraydev.tolkienapp.presentation.movies.MoviesScreen
import com.cgaraydev.tolkienapp.presentation.others.OtherDetailsScreen
import com.cgaraydev.tolkienapp.presentation.others.OthersScreen
import com.cgaraydev.tolkienapp.presentation.quiz.QuizIntroScreen
import com.cgaraydev.tolkienapp.presentation.quiz.QuizQuestionScreen
import com.cgaraydev.tolkienapp.presentation.quiz.QuizResultScreen
import com.cgaraydev.tolkienapp.presentation.races.RaceDetailsScreen
import com.cgaraydev.tolkienapp.presentation.races.RacesScreen
import com.cgaraydev.tolkienapp.presentation.tolkien.TolkienScreen

@Composable
fun TolkienAppNavigation(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState
) {
    NavHost(
        navController = navController,
        startDestination = Routes.MemoryIntro.route,
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }

        //CHARACTERS
        composable(Routes.Characters.route) {
            CharactersScreen(navController = navController)
        }
        composable(
            route = Routes.CharacterDetails.route,
            arguments = listOf(navArgument("characterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val characterId =
                backStackEntry.arguments?.getString("characterId") ?: return@composable
            CharacterDetailsScreen(characterId = characterId, navController = navController)
        }

        //LOCATIONS
        composable(Routes.Locations.route) {
            LocationsScreen(navController = navController)
        }
        composable(
            route = Routes.LocationDetails.route,
            arguments = listOf(navArgument("locationId") { type = NavType.StringType })
        ) { backStackEntry ->
            val locationId =
                backStackEntry.arguments?.getString("locationId") ?: return@composable
            LocationDetailsScreen(locationId = locationId, navController = navController)
        }

        //RACES
        composable(Routes.Races.route) {
            RacesScreen(navController = navController)
        }
        composable(
            route = Routes.RaceDetails.route,
            arguments = listOf(navArgument("raceId") { type = NavType.StringType })
        ) { backStackEntry ->
            val raceId =
                backStackEntry.arguments?.getString("raceId") ?: return@composable
            RaceDetailsScreen(raceId = raceId, navController = navController)
        }

        //EVENTS
        composable(Routes.Events.route) {
            EventsScreen(navController = navController)
        }
        composable(
            route = Routes.EventDetails.route,
            arguments = listOf(navArgument("eventId") { type = NavType.StringType })
        ) { backStackEntry ->
            val eventId =
                backStackEntry.arguments?.getString("eventId") ?: return@composable
            EventDetailsScreen(eventId = eventId, navController = navController)
        }

        //OTHERS
        composable(Routes.Others.route) {
            OthersScreen(navController = navController)
        }
        composable(
            route = Routes.OtherDetails.route,
            arguments = listOf(navArgument("otherId") { type = NavType.StringType })
        ) { backStackEntry ->
            val otherId =
                backStackEntry.arguments?.getString("otherId") ?: return@composable
            OtherDetailsScreen(otherId = otherId, navController = navController)
        }

        //LANGUAGES
        composable(Routes.Languages.route) {
            LanguagesScreen(navController = navController)
        }
        composable(
            route = Routes.LanguageDetails.route,
            arguments = listOf(navArgument("languageId") { type = NavType.StringType })
        ) { backStackEntry ->
            val languageId =
                backStackEntry.arguments?.getString("languageId") ?: return@composable
            LanguageDetailsScreen(languageId = languageId, navController = navController)
        }

        //MAPS
        composable(Routes.Maps.route) {
            MapsScreen(navController = navController)
        }
        composable(
            route = Routes.MapDetails.route,
            arguments = listOf(navArgument("mapId") { type = NavType.StringType })
        ) { backStackEntry ->
            val mapId =
                backStackEntry.arguments?.getString("mapId") ?: return@composable
            MapDetailsScreen(mapId = mapId, navController = navController)
        }

        //TOLKIEN
        composable(Routes.Tolkien.route) {
            TolkienScreen()
        }

        //QUIZ
        composable(Routes.QuizIntro.route) {
            QuizIntroScreen(navController)
        }
        composable(
            route = Routes.QuizQuestions.route,
            arguments = listOf(navArgument("difficulty") { type = NavType.StringType })
        ) { backStackEntry ->
            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: "hobbit"
            QuizQuestionScreen(navController, difficulty)
        }
        composable(
            route = Routes.QuizResult.route,
            arguments = listOf(
                navArgument("correct") { type = NavType.IntType },
                navArgument("total") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val correct = backStackEntry.arguments?.getInt("correct") ?: 0
            val total = backStackEntry.arguments?.getInt("total") ?: 0
            QuizResultScreen(navController, correct, total)
        }

        //MEMORY GAME
        composable(Routes.MemoryIntro.route) {
            MemoryIntroScreen(navController)
        }
        composable(
            route = Routes.MemoryGame.route,
            arguments = listOf(navArgument("difficulty") { type = NavType.StringType })
        ) { backStackEntry ->
            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: "hobbit"
            MemoryGameScreen(navController, difficulty, snackbarHostState)
        }





        composable(Routes.Books.route) {
            BooksScreen { navController.popBackStack() }
        }





        composable(Routes.Games.route) {
            GamesScreen { navController.popBackStack() }
        }



        composable(Routes.Movies.route) {
            MoviesScreen { navController.popBackStack() }
        }


    }
}