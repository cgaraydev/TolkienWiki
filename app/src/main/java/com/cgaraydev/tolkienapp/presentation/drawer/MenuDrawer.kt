package com.cgaraydev.tolkienapp.presentation.drawer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.navigation.TolkienAppNavigation
import com.cgaraydev.tolkienapp.presentation.components.AudioControlsToggle
import com.cgaraydev.tolkienapp.presentation.components.DualFABsWithToggle
import com.cgaraydev.tolkienapp.presentation.components.GlowingSnackbar
import com.cgaraydev.tolkienapp.presentation.home.HomeViewModel
import com.cgaraydev.tolkienapp.presentation.music.MusicViewModel
import com.cgaraydev.tolkienapp.ui.theme.Golden
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDrawer(
    viewModel: HomeViewModel = hiltViewModel(),
    musicViewModel: MusicViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val snackbarHostState = remember { SnackbarHostState() }
    val currentDestination = currentBackStackEntry?.destination?.route

    val shouldShowFAB = currentDestination !in listOf(
        Routes.QuizQuestions.route,
        Routes.MemoryGame.route,
        Routes.RoleGame.route
    )

    // Color de fondo semi-transparente para el contenido cuando el drawer está abierto
    val contentColor = if (drawerState.isOpen) Color.Black.copy(alpha = 0.2f) else Color.Black

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        scrimColor = Color.Transparent, // Eliminamos el scrim por defecto para nuestro efecto personalizado
        drawerContent = {
            ModalDrawerSheet(
                drawerContentColor = Color.White,
                drawerContainerColor = Color(0xFF121212), // Un negro más claro para el drawer
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(Color(0xFF121212))
                ) {
                    val sections = remember { Items.sections }
                    val expandedStates = remember {
                        mutableStateMapOf<String, Boolean>().apply {
                            sections.forEach { section ->
                                put(section.title, false)
                            }
                        }
                    }

                    // Header del drawer
                    DrawerHeader(
                        closeDrawer = { scope.launch { drawerState.close() } }
                    )
                    Spacer(Modifier.height(16.dp))

                    LazyColumn {
                        // Sección INICIO (no expandible)
                        item {
                            val inicioSection = sections.firstOrNull { it.title.isEmpty() }
                            inicioSection?.items?.forEach { item ->
                                DrawerItem(
                                    label = item.label,
                                    icon = item.icon,
                                    contentDescription = item.contentDescription,
                                    currentRoute = currentRoute,
                                    route = item.route,
                                    coroutineScope = scope,
                                    drawerState = drawerState,
                                    navController = navController
                                )
                            }

                            // Primer divider después de Inicio
                            HorizontalDivider(
                                color = Golden.copy(alpha = 0.8f),
                                thickness = 1.dp,
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 8.dp)
                            )
                        }

                        // Secciones expandibles
                        sections.filter { it.title.isNotEmpty() }.forEachIndexed { index, section ->
                            item {
                                val expanded = expandedStates[section.title] ?: false

                                Column {
                                    // Encabezado de sección
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                expandedStates[section.title] = !expanded
                                            }
                                            .padding(vertical = 12.dp, horizontal = 16.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = section.title.uppercase(),
                                            fontFamily = FontFamily(Font(R.font.aniron)),
                                            fontSize = 10.sp,
                                            color = Golden.copy(alpha = 0.7f),
                                            modifier = Modifier.weight(1f)
                                        )

                                        if (section.items.isNotEmpty()) {
                                            Icon(
                                                imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                                                else Icons.Default.KeyboardArrowDown,
                                                contentDescription = if (expanded) "Collapse" else "Expand",
                                                tint = Golden.copy(alpha = 0.7f),
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                    }

                                    // Items de la sección con animación
                                    AnimatedVisibility(
                                        visible = expanded,
                                        enter = expandVertically() + fadeIn(),
                                        exit = shrinkVertically() + fadeOut(),
                                        modifier = Modifier.background(Color(0xFF121212))
                                    ) {
                                        Column(modifier = Modifier.background(Color(0xFF121212))) {
                                            section.items.forEach { item ->
                                                DrawerItem(
                                                    label = item.label,
                                                    icon = item.icon,
                                                    contentDescription = item.contentDescription,
                                                    currentRoute = currentRoute,
                                                    route = item.route,
                                                    coroutineScope = scope,
                                                    drawerState = drawerState,
                                                    navController = navController
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            // Divider entre secciones (excepto después de la última)
                            if (index < sections.filter { it.title.isNotEmpty() }.size - 1) {
                                item {
                                    HorizontalDivider(
                                        color = Golden,
                                        thickness = 1.dp,
                                        modifier = Modifier.padding(
                                            horizontal = 20.dp,
                                            vertical = 8.dp
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {
        // Contenido principal con efecto de oscurecimiento cuando el drawer está abierto
        Box(modifier = Modifier.background(contentColor)) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "") },
                        actions = {
                            AudioControlsToggle(musicViewModel)
                        },
                        navigationIcon = {
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu",
                                    tint = if (drawerState.isOpen) Color.Gray else Color.White
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Black,
                            titleContentColor = Color.White,
                            navigationIconContentColor = Color.White
                        ),
                        modifier = Modifier.statusBarsPadding()
                    )
                },
                floatingActionButton = {
                    if (shouldShowFAB) {
                        Box(
                            modifier = Modifier
                                .navigationBarsPadding()
                                .padding(bottom = 16.dp)
                        ) {
                            DualFABsWithToggle(
                                onBackClick = { navController.navigateUp() },
                                viewModel = viewModel,
                                navController = navController
                            )
                        }
                    }
                },
                snackbarHost = {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier
                            .navigationBarsPadding()
                            .padding(bottom = 16.dp)
                    ) { data ->
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(tween(300)) + expandVertically(expandFrom = Alignment.Top),
                            exit = fadeOut(tween(300)) + shrinkVertically(shrinkTowards = Alignment.Bottom)
                        ) {
                            GlowingSnackbar(message = data.visuals.message)
                        }
                    }
                },
                contentWindowInsets = WindowInsets(0, 0, 0, 0)
            ) { padding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .navigationBarsPadding()
                        .imePadding()
                ) {
                    TolkienAppNavigation(
                        navController = navController,
                        snackbarHostState = snackbarHostState
                    )
                }
            }
        }
    }
}