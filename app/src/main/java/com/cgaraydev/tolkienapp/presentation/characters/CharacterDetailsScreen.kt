package com.cgaraydev.tolkienapp.presentation.characters

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.Character
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun CharacterDetailsScreen(
    characterId: String,
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val character by viewModel.characterDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.loadCharacterDetails(characterId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 80.dp)
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Golden
                )
            }

            error != null -> {
                Text(
                    text = error!!,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            character != null -> {
                CharacterDetailsContent(character = character!!, navController = navController)
            }
        }
    }
}

@Composable
fun CharacterDetailsContent(
    character: Character,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = character.name!!,
                fontSize = 48.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            CustomSpacer(16)
            character.poster?.let { url ->
                AsyncImage(
                    model = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/$url",
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.FillBounds
                )
                CustomSpacer(16)
            }
            Row {
                val iconVector = when (character.genre?.lowercase()) {
                    "masculino" -> R.drawable.ic_male
                    "femenino" -> R.drawable.ic_female
                    else -> R.drawable.ic_unknown
                }
                DetailRow("Raza", character.race, navController)
                Spacer(Modifier.weight(1f))
                Icon(
                    painter = painterResource(iconVector),
                    contentDescription = null,
                    tint = Golden
                )
            }
            DetailRow("Otros nombres", character.otherNames, navController)
            DetailRow("Nacimiento", character.birth, navController)
            DetailRow("Muerte", character.death, navController)
            DetailRow("Titulos", character.titles, navController)
            DetailRow("Casa", character.house, navController)
            DetailRow("Familia", character.family, navController)
            DetailRow("Cónyuge", character.love, navController)
            CustomSpacer(24)
            CustomExpandable(title = "Biografia") {
                HtmlText(
                    htmlText = character.biography!!,
                    navController = navController,
                )
            }
            CustomExpandable(title = "Imagenes") {
                ImageCarousel(
                    images = character.images,
                    modifier = Modifier.padding(vertical = 16.dp),
                    navController = navController
                )
            }
            CustomSpacer(40)

        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String?,
    navController: NavController
) {
    value?.let {
        Row(
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Text(
                text = "$label: ",
                style = TextStyle(),
                fontSize = 16.sp,
                color = LightGray,
                fontWeight = FontWeight.Bold
            )
            HtmlText(
                htmlText = value,
                navController = navController
            )
        }
    }
}
