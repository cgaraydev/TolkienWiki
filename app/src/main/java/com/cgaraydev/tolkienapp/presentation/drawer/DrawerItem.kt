package com.cgaraydev.tolkienapp.presentation.drawer


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Golden
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerItem(
    label: String,
    icon: Int,
    contentDescription: String,
    route: String,
    currentRoute: String?,
    navController: NavController,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    val selected = route == currentRoute
    NavigationDrawerItem(
        label = {
            Text(
                text = label.uppercase(),
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.aniron))
            )
        },
        icon = {
            Icon(
                painter = painterResource(icon),
                contentDescription = contentDescription,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        },
        selected = selected,
        onClick = {
            navigateToSection(
                route = route,
                navController = navController,
                scope = coroutineScope,
                drawerState = drawerState
            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Golden.copy(alpha = 0.1f), // Gris más claro para selección
            unselectedContainerColor = Color(0xFF121212), // Fondo consistente con el drawer
        ),
        modifier = Modifier.background(Color(0xFF121212)), // Fondo consistente
        shape = RoundedCornerShape(4.dp) // Esquinas ligeramente redondeadas
    )
}


private fun navigateToSection(
    route: String,
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    scope.launch {
        launch { drawerState.close() }
        if (navController.currentDestination?.route != route) {
            navController.navigate(route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = false
                }
                launchSingleTop = true
                restoreState = false
            }
        }
    }
}
