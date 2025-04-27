package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.home.HomeViewModel
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray
import com.cgaraydev.tolkienapp.utils.SearchResult
import com.cgaraydev.tolkienapp.utils.navigateToDetails

@Composable
fun SearchDialog(
    onDismiss: () -> Unit,
    viewModel: HomeViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    val searchResults by viewModel.searchResults.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    Dialog(
        onDismissRequest = {
            viewModel.clearSearch()
            onDismiss()
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = Color.Black,
            border = BorderStroke(1.dp, Golden)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                        viewModel.searchAllCollections(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Buscar en los anales de Arda...",
                            color = LightGray.copy(alpha = 0.5f),
                            fontFamily = FontFamily(Font(R.font.cardo)),
                            fontSize = 16.sp
                        )
                    },
                    maxLines = 2,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Black,
                        unfocusedContainerColor = Color.Black,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        cursorColor = Golden,
                        focusedIndicatorColor = Golden,
                        unfocusedIndicatorColor = Golden.copy(alpha = 0.3f)
                    ),
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = {
                                searchQuery = ""
                                viewModel.clearSearch()
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Limpiar",
                                    tint = Golden.copy(alpha = 0.7f)
                                )
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = { viewModel.searchAllCollections(searchQuery) }
                    ),
                    shape = RoundedCornerShape(12.dp),
                    textStyle = LocalTextStyle.current.copy(fontFamily = FontFamily(Font(R.font.cardo)))
                )
                Text(
                    text = "Búsqueda avanzada →",
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier
                        .clickable { }
                        .align(Alignment.End)
                        .padding(vertical = 8.dp),
                    fontFamily = FontFamily(Font(R.font.cardo)),
                    fontSize = 14.sp
                )
                if (isSearching) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            color = Golden,
                            strokeWidth = 2.dp,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(searchResults) { result ->
                        SearchResultItem(
                            result = result,
                            onClick = {
                                navigateToDetails(result, navController)
                                onDismiss()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchResultItem(
    result: SearchResult,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF121212)
        ),
        border = BorderStroke(0.5.dp, Golden.copy(alpha = 0.2f))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .background(Golden.copy(alpha = 0.2f), shape = CircleShape)
            ) {
                Icon(
                    painter = when (result) {
                        is SearchResult.CharacterResult -> painterResource(R.drawable.ic_characters)
                        is SearchResult.LocationResult -> painterResource(R.drawable.ic_locations)
                        is SearchResult.EventResult -> painterResource(R.drawable.ic_event)
                        is SearchResult.LanguageResult -> painterResource(R.drawable.ic_language)
                        is SearchResult.OtherResult -> painterResource(R.drawable.ic_ring)
                        is SearchResult.RaceResult -> painterResource(R.drawable.ic_race)
                    },
                    contentDescription = null,
                    tint = Golden,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = result.name,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.cardo)),
                    maxLines = 2,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = when (result) {
                        is SearchResult.CharacterResult -> "Personaje"
                        is SearchResult.LocationResult -> "Ubicación"
                        is SearchResult.EventResult -> "Evento"
                        is SearchResult.LanguageResult -> "Lengua/Escritura"
                        is SearchResult.OtherResult -> "Otro"
                        is SearchResult.RaceResult -> "Raza"
                    },
                    color = Golden.copy(alpha = 0.6f),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = FontFamily(Font(R.font.cardo))
                    )
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Ver detalles",
                tint = Golden.copy(alpha = 0.7f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}