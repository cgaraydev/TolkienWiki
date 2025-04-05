package com.cgaraydev.tolkienapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cgaraydev.tolkienapp.presentation.books.BooksScreen
import com.cgaraydev.tolkienapp.presentation.characters.CharactersScreen
import com.cgaraydev.tolkienapp.presentation.events.EventsScreen
import com.cgaraydev.tolkienapp.presentation.games.GamesScreen
import com.cgaraydev.tolkienapp.presentation.home.HomeScreen
import com.cgaraydev.tolkienapp.presentation.languages.LanguagesScreen
import com.cgaraydev.tolkienapp.presentation.locations.LocationsScreen
import com.cgaraydev.tolkienapp.presentation.maps.MapsScreen
import com.cgaraydev.tolkienapp.presentation.movies.MoviesScreen
import com.cgaraydev.tolkienapp.presentation.others.OthersScreen
import com.cgaraydev.tolkienapp.presentation.races.RacesScreen
import com.cgaraydev.tolkienapp.presentation.tolkien.TolkienScreen
import com.cgaraydev.tolkienapp.presentation.trivia.TriviaScreen

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
            HomeScreen()
        }
        composable(Routes.Characters.route) {
            CharactersScreen { navController.popBackStack() }
        }
        composable(Routes.Locations.route) {
            LocationsScreen { navController.popBackStack() }
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
        composable(Routes.Races.route) {
            RacesScreen { navController.popBackStack() }
        }
        composable(Routes.Trivia.route) {
            TriviaScreen { navController.popBackStack() }
        }
    }
}