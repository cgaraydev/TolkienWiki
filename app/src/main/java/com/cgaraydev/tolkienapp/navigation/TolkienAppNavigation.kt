package com.cgaraydev.tolkienapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cgaraydev.tolkienapp.presentation.books.BooksScreen
import com.cgaraydev.tolkienapp.presentation.characters.CharacterDetailsScreen
import com.cgaraydev.tolkienapp.presentation.characters.CharactersScreen
import com.cgaraydev.tolkienapp.presentation.events.EventsScreen
import com.cgaraydev.tolkienapp.presentation.games.GamesScreen
import com.cgaraydev.tolkienapp.presentation.home.HomeScreen
import com.cgaraydev.tolkienapp.presentation.languages.LanguagesScreen
import com.cgaraydev.tolkienapp.presentation.locations.LocationDetailsScreen
import com.cgaraydev.tolkienapp.presentation.locations.LocationsScreen
import com.cgaraydev.tolkienapp.presentation.maps.MapsScreen
import com.cgaraydev.tolkienapp.presentation.movies.MoviesScreen
import com.cgaraydev.tolkienapp.presentation.others.OthersScreen
import com.cgaraydev.tolkienapp.presentation.races.RaceDetailsScreen
import com.cgaraydev.tolkienapp.presentation.races.RacesScreen
import com.cgaraydev.tolkienapp.presentation.tolkien.TolkienScreen
import com.cgaraydev.tolkienapp.presentation.trivia.TriviaScreen
import okhttp3.Route

@Composable
fun TolkienAppNavigation(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }

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

        composable(Routes.Books.route) {
            BooksScreen { navController.popBackStack() }
        }

        composable(Routes.Tolkien.route) {
            TolkienScreen { navController.popBackStack() }
        }

        composable(Routes.Events.route) {
            EventsScreen { navController.popBackStack() }
        }

        composable(Routes.Games.route) {
            GamesScreen { navController.popBackStack() }
        }

        composable(Routes.Languages.route) {
            LanguagesScreen { navController.popBackStack() }
        }
        composable(Routes.Maps.route) {
            MapsScreen { navController.popBackStack() }
        }
        composable(Routes.Movies.route) {
            MoviesScreen { navController.popBackStack() }
        }
        composable(Routes.Others.route) {
            OthersScreen { navController.popBackStack() }
        }

        composable(Routes.Trivia.route) {
            TriviaScreen { navController.popBackStack() }
        }
    }
}