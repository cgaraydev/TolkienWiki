package com.cgaraydev.tolkienapp.presentation.events

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.EventData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableSubCategory
import com.cgaraydev.tolkienapp.presentation.components.ListItem
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.RingBearer
import com.cgaraydev.tolkienapp.utils.StateHandler


@Composable
fun EventsScreen(
    navController: NavController,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val events by viewModel.events.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.events, label = "Eventos")
        CustomSpacer(40)

        if (events.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Golden)
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                val mainCategories = listOf(
                    "Batallas", "Guerras", "Asedios",
                    "Primera Edad", "Segunda Edad", "Tercera Edad",
                    "Guerra de las Joyas", "Guerra del Anillo", "Todos"
                )

                items(mainCategories) { category ->
                    val eventsByCategory = viewModel.getEventsByTag(category)
                    ExpandableSubCategory(
                        title = category,
                        items = eventsByCategory,
                        itemCount = eventsByCategory.size,
                        titleTextStyle = TextStyle(
                            fontSize = 24.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.cardo))
                        ),
                        countTextStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White.copy(alpha = 0.7f),
                            fontFamily = FontFamily(Font(R.font.cardo))
                        ),
                        borderColor = Golden.copy(alpha = 0.5f)
                    ) { event ->
                        ListItem(
                            item = event,
                            text = event.name,
                            onClick = {
                                navController.navigate(
                                    Routes.EventDetails.createRoute(event.id)
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.cardo))
                            )
                        )
                    }
                }
            }
        }

        CustomSpacer(40)
    }
}


//@Composable
//fun EventsScreen(
//    viewModel: EventsViewModel = hiltViewModel(),
//    navController: NavController
//) {
//    val events by viewModel.events.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        ScreenHeader(imageRes = R.drawable.events, label = "Eventos")
//        CustomSpacer(40)
//
//        if (events.isEmpty()) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator(color = Golden)
//            }
//        } else {
//            EventsScreenBody(
//                viewModel = viewModel,
//                navController = navController
//            )
//        }
//
//        CustomSpacer(40)
//    }
//}
//
//@Composable
//fun EventsScreenBody(
//    viewModel: EventsViewModel,
//    navController: NavController
//) {
//    val mainCategories = listOf(
//        "Batallas", "Guerras", "Asedios",
//        "Primera Edad", "Segunda Edad", "Tercera Edad",
//        "Guerra de las Joyas", "Guerra del Anillo", "Todos"
//    )
//
//    EventsCategoriesList(
//        categories = mainCategories,
//        getEventsByTag = { category -> viewModel.getEventsByTag(category) },
//        navController = navController
//    )
//}
//
//@Composable
//fun EventsCategoriesList(
//    categories: List<String>,
//    getEventsByTag: (String) -> List<EventData>,
//    navController: NavController
//) {
//    LazyColumn(
//        modifier = Modifier.padding(horizontal = 16.dp)
//    ) {
//        items(categories) { category ->
//            EventCategoryItem(
//                category = category,
//                events = getEventsByTag(category),
//                navController = navController
//            )
//        }
//    }
//}
//
//@Composable
//fun EventCategoryItem(
//    category: String,
//    events: List<EventData>,
//    navController: NavController
//) {
//    var expanded by remember { mutableStateOf(false) }
//    Card(colors = CardDefaults.cardColors(containerColor = Color.Black)) {
//        Column {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { expanded = !expanded }
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = category,
//                    style = RingBearer.bodyMedium.copy(
//                        fontSize = 24.sp,
//                        color = Golden
//                    ),
//                    modifier = Modifier.weight(1f)
//                )
//                Text(
//                    text = "(${events.size})",
//                    style = RingBearer.bodyMedium.copy(
//                        fontSize = 16.sp,
//                        color = Golden.copy(alpha = 0.7f)
//                    ),
//                    modifier = Modifier.padding(end = 8.dp)
//                )
//                Icon(
//                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
//                    contentDescription = "Expandir/Cerrar",
//                    tint = Golden
//                )
//            }
//            AnimatedVisibility(
//                visible = expanded,
//                enter = fadeIn() + expandVertically(),
//                exit = fadeOut() + shrinkVertically()
//            ) {
//                Column {
//                    events.forEach { event ->
//                        EventItem(event = event, navController = navController)
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun EventItem(
//    event: EventData,
//    navController: NavController
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//            .clickable {
//                navController.navigate(Routes.EventDetails.createRoute(event.id))
//            },
//        colors = CardDefaults.cardColors(
//            containerColor = Color.Black.copy(alpha = 0.7f)
//        )
//    ) {
//        Row(
//            modifier = Modifier.padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = event.name,
//                style = RingBearer.bodyMedium.copy(
//                    fontSize = 16.sp,
//                    color = Color.White
//                ),
//                modifier = Modifier.weight(1f)
//            )
//            Icon(
//                imageVector = Icons.Default.KeyboardArrowUp,
//                contentDescription = "Ver detalle",
//                tint = Golden.copy(alpha = 0.7f)
//            )
//        }
//    }
//}


//@Composable
//fun EventsScreen(
//    viewModel: EventsViewModel = hiltViewModel(),
//    navController: NavController
//) {
//
////    val events by viewModel.events.collectAsState()
////    val events = viewModel.getEvents()
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        ScreenHeader(imageRes = R.drawable.events, label = "Eventos")
//        CustomSpacer(40)
//        EventsScreenBody(
////            events = events,
//            viewModel = viewModel,
//            navController = navController
//        )
//        CustomSpacer(40)
//    }
//}
//
//@Composable
//fun EventsScreenBody(
////    events: List<EventData>,
//    viewModel: EventsViewModel,
//    navController: NavController
//) {
//    val mainCategories = listOf(
//        "Batallas",
//        "Guerras",
//        "Asedios",
//        "Primera Edad",
//        "Segunda Edad",
//        "Tercera Edad",
//        "Guerra de las Joyas",
//        "Guerra del Anillo",
//        "Todos"
//    )
////    if (events.isEmpty()) {
////        Box(
////            modifier = Modifier.fillMaxSize(),
////            contentAlignment = Alignment.Center
////        ) {
////            CircularProgressIndicator(color = Golden)
////        }
////    } else {
////        EventsCategoriesList(viewModel, navController)
////    }
//    EventsCategoriesList(
//        categories = mainCategories,
//        getEventsByTag = { category -> viewModel.getEventsByTag(category) },
//        navController = navController
//    )
//}
//
//@Composable
//fun EventsCategoriesList(
//    categories: List<String>,
////    viewModel: EventsViewModel,
//    getEventsByTag: (String) -> List<EventData>,
//    navController: NavController
//) {
//    LazyColumn(
//        modifier = Modifier.padding(horizontal = 16.dp)
//    ) {
//        items(categories) { category ->
//            EventCategoryItem(
//                category = category,
//                events = getEventsByTag(category),
//                navController = navController
//            )
//        }
////        val mainCategories = listOf(
////            "Batallas",
////            "Guerras",
////            "Asedios",
////            "Primera Edad",
////            "Segunda Edad",
////            "Tercera Edad",
////            "Guerra de las Joyas",
////            "Guerra del Anillo",
////            "Todos"
////        )
////        mainCategories.forEach { category ->
////            item {
////                EventCategoryItem(category, viewModel, navController)
////            }
////        }
//    }
//}
//
//@Composable
//fun EventCategoryItem(
//    category: String,
//    events: List<EventData>,
////    viewModel: EventsViewModel,
//    navController: NavController
//) {
//    var expanded by remember { mutableStateOf(false) }
////    val events = viewModel.getEventsByTag(category)
//
//    Card(colors = CardDefaults.cardColors(containerColor = Color.Black)) {
//        Column {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { expanded = !expanded }
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = category,
//                    style = RingBearer.bodyMedium.copy(
//                        fontSize = 24.sp,
//                        color = Golden
//                    ),
//                    modifier = Modifier.weight(1f)
//                )
//                Text(
//                    text = "(${events.size})",
//                    style = RingBearer.bodyMedium.copy(
//                        fontSize = 16.sp,
//                        color = Golden.copy(alpha = 0.7f)
//                    ),
//                    modifier = Modifier.padding(end = 8.dp)
//                )
//                Icon(
//                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
//                    else Icons.Default.KeyboardArrowDown,
//                    contentDescription = "Expandir/Cerrar",
//                    tint = Golden
//                )
//            }
//            AnimatedVisibility(
//                visible = expanded,
//                enter = fadeIn() + expandVertically(),
//                exit = fadeOut() + shrinkVertically()
//            ) {
//                Column {
//                    events.forEach { event ->
//                        EventItem(
//                            event = event,
//                            navController = navController
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun EventItem(
//    event: EventData,
//    navController: NavController
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//            .clickable {
//                navController.navigate(Routes.EventDetails.createRoute(event.id))
//            },
//        colors = CardDefaults.cardColors(
//            containerColor = Color.Black.copy(alpha = 0.7f)
//        )
//    ) {
//        Row(
//            modifier = Modifier.padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = event.name,
//                style = RingBearer.bodyMedium.copy(
//                    fontSize = 16.sp,
//                    color = Color.White
//                ),
//                modifier = Modifier.weight(1f)
//            )
//
//            Icon(
//                imageVector = Icons.Default.KeyboardArrowUp,
//                contentDescription = "Ver detalle",
//                tint = Golden.copy(alpha = 0.7f)
//            )
//        }
//    }
//
//}
//
