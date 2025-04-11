package com.cgaraydev.tolkienapp.presentation.components.drawer


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.GoldenLight
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
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = if (selected) Golden else Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        icon = {
            Icon(
                painter = painterResource(icon),
                contentDescription = contentDescription,
                tint = if (selected) Golden else Color.White,
                modifier = Modifier.size(32.dp)
            )
        },
        selected = selected,
        onClick = {
            coroutineScope.launch { drawerState.close() }

            if(route != currentRoute){
                navController.navigate(route){
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = GoldenLight,
            unselectedContainerColor = Color.Black
        ),
    )
}
