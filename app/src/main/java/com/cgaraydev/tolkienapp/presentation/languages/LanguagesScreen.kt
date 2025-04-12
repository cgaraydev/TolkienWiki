package com.cgaraydev.tolkienapp.presentation.languages

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.LanguageData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.RingBearer

@Composable
fun LanguagesScreen(
    viewModel: LanguagesViewModel = hiltViewModel(),
    navController: NavController
) {
    val languages by viewModel.languages.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.languages, label = "Lenguas/Escritura")
        CustomSpacer(40)
        LanguagesScreenBody(languages, viewModel, navController)
        CustomSpacer(40)
    }

}

@Composable
fun LanguagesScreenBody(
    languages: List<LanguageData>,
    viewModel: LanguagesViewModel,
    navController: NavController
) {
    if (languages.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Golden)
        }
    } else {
        LanguagesCategoriesList(viewModel, navController)
    }

}

@Composable
fun LanguagesCategoriesList(
    viewModel: LanguagesViewModel,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        val mainCategories = listOf(
            "Lenguas Humanas",
            "Lenguas Enanas",
            "Lenguas Elficas",
            "Escritura",
            "Todos"
        )
        mainCategories.forEach { category ->
            item {
                LanguageCategoryItem(category, viewModel, navController)
            }
        }
    }

}

@Composable
fun LanguageCategoryItem(
    category: String,
    viewModel: LanguagesViewModel,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }
    val languages = viewModel.getLanguagesByTag(category)

    Card(colors = CardDefaults.cardColors(containerColor = Color.Black)) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = category,
                    style = RingBearer.bodyMedium.copy(
                        fontSize = 24.sp,
                        color = Golden
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "(${languages.size})",
                    style = RingBearer.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Golden.copy(alpha = 0.7f)
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expandir/Cerrar",
                    tint = Golden
                )
            }
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column {
                    languages.forEach { language ->
                        LanguageItem(
                            language = language,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LanguageItem(
    language: LanguageData,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable {
                navController.navigate(Routes.LanguageDetails.createRoute(language.id))
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.7f)
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = language.name,
                style = RingBearer.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color.White
                ),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Ver detalle",
                tint = Golden.copy(alpha = 0.7f)
            )
        }
    }

}