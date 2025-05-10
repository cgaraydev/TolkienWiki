package com.cgaraydev.tolkienapp.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableCategory
import com.cgaraydev.tolkienapp.presentation.components.ExpandableSubCategory
import com.cgaraydev.tolkienapp.presentation.components.ListItem
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader
import com.cgaraydev.tolkienapp.ui.theme.Golden

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
    ) {
        ScreenHeader(imageRes = R.drawable.characters, label = stringResource(R.string.characters))
        CustomHeightSpacer(40)

        if (characters.isEmpty()) {
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
                viewModel.categories.forEach { (category, tags) ->
                    item {
                        ExpandableCategory(
                            title = category,
                            items = tags,
                            itemCount = tags.size,
                            titleTextStyle = TextStyle(
                                fontSize = 24.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.cardo))
                            ),
                            countTextStyle = TextStyle(
                                fontSize = 16.sp,
                                color = Color.White.copy(alpha = 0.7f),
                                fontFamily = FontFamily(Font(R.font.cardo))
                            )
                        ) { tag ->
                            val charactersByTag = viewModel.getCharactersByTag(tag)
                            if (charactersByTag.isNotEmpty()) {
                                ExpandableSubCategory(
                                    title = tag.replace("_", "").replaceFirstChar { it.titlecaseChar() },
                                    items = charactersByTag,
                                    itemCount = charactersByTag.size
                                ) { character ->
                                    ListItem(
                                        text = character.name,
                                        onClick = {
                                            navController.navigate(
                                                Routes.CharacterDetails.createRoute(character.id)
                                            )
                                        },
                                        textStyle = TextStyle(
                                            fontSize = 18.sp,
                                            color = Color.White,
                                            fontFamily = FontFamily(Font(R.font.cardo))
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        CustomHeightSpacer(40)
    }
}