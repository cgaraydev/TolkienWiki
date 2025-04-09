package com.cgaraydev.tolkienapp.presentation.characters

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.CharacterData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.Gray
import com.cgaraydev.tolkienapp.ui.theme.RingBearer

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val characters by viewModel.characters.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 80.dp)
    ) {
        CharactersScreenHeader()
        CustomSpacer(40)
        CharactersScreenBody(characters, viewModel, navController)
        CustomSpacer(40)
//        SearchCharacter()
    }
}

@Composable
fun CategoriesList(
    viewModel: CharactersViewModel,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        viewModel.categories.forEach { (category, tags) ->
            item {
                ExpandableCategory(
                    title = category,
                    tags = tags,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun ExpandableCategory(
    title: String,
    tags: List<String>,
    viewModel: CharactersViewModel,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = title,
                    style = RingBearer.bodyMedium.copy(
                        fontSize = 24.sp,
                        color = Golden
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Golden
                )
            }
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column {
                    tags.forEach { tag ->
                        val characters = viewModel.getCharactersByTag(tag)
                        if (characters.isNotEmpty()) {
                            ExpandableSubCategory(
                                title = tag.replace("_", "")
                                    .replaceFirstChar { it.titlecaseChar() },
                                characters = characters,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExpandableSubCategory(
    title: String,
    characters: List<CharacterData>,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = RingBearer.bodyMedium.copy(
                        fontSize = 18.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "(${characters.size})",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 14.sp,
                    color = Color.Black
                )

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            AnimatedVisibility(visible = expanded) {
                Column {
                    characters.forEach { character ->
                        CharacterItem(
                            character = character,
                            onClick = {
                                navController.navigate(
                                    Routes.CharacterDetails.createRoute(
                                        character.id
                                    )
                                )
                                Log.d("characterscreen", character.id + " " + character.name)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(
    character: CharacterData,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = character.name,
                style = RingBearer.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Ver detalle",
                tint = Gray
            )
        }
    }
}

@Composable
fun CharactersScreenHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.characters),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.4f)
        )
        Text(
            text = "Personajes",
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun CharactersScreenBody(
    characters: List<CharacterData>,
    viewModel: CharactersViewModel,
    navController: NavController
) {
    if (characters.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Golden)
        }
    } else {
        CategoriesList(viewModel, navController)
    }
}

