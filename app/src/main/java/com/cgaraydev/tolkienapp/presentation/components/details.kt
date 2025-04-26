package com.cgaraydev.tolkienapp.presentation.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.WikiUrl
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.QuizRed

@Composable
fun <T> DetailScreenTemplate(
    itemId: String,
    viewModel: ViewModel,
    loadDetails: (String) -> Unit,
    isLoading: Boolean,
    error: String?,
    item: T?,
    content: @Composable (T) -> Unit
) {
    LaunchedEffect(itemId) {
        loadDetails(itemId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
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
                    text = error,
                    color = QuizRed,
                    modifier = Modifier.align(Alignment.Center),
                    fontFamily = FontFamily(Font(R.font.cardo))
                )
            }

            item != null -> {
                content(item)
            }
        }
    }
}

@Composable
fun DetailHeader(
    title: String,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = TextStyle(
        fontSize = 48.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.cardo))
    )
) {
    Text(
        text = title,
        style = titleStyle,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        textAlign = TextAlign.Center
    )
}

//@Composable
//fun DetailImage(
//    imageUrl: String?,
//    modifier: Modifier = Modifier,
//    baseUrl: String = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/",
//    contentDescription: String? = null,
//    shape: Shape = RoundedCornerShape(12.dp),
//    contentScale: ContentScale = ContentScale.FillBounds
//) {
//    imageUrl?.let { url ->
//        AsyncImage(
//            model = "$baseUrl$url",
//            contentDescription = contentDescription,
//            modifier = modifier
//                .fillMaxWidth()
//                .height(350.dp)
//                .clip(shape),
//            contentScale = contentScale
//        )
//    }
//}

@Composable
fun DetailImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    baseUrl: String = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/",
    contentDescription: String? = null,
    shape: Shape = RoundedCornerShape(12.dp),
    loadingColor: Color = Golden
) {
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color.Black)
    ) {
        if (imageUrl == null) {
            // Sin imagen
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(350.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_unknown),
                    contentDescription = "Sin imagen disponible",
                    tint = loadingColor,
                    modifier = Modifier.size(48.dp)
                )
            }
        } else {
            // Imagen remota
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("$baseUrl$imageUrl")
                    .crossfade(true)
                    .listener(
                        onSuccess = { _, _ -> isLoading = false },
                        onError = { _, _ ->
                            isLoading = false
                            hasError = true
                        }
                    )
                    .build(),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit, // O Crop si prefieres llenado con recorte
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 250.dp, max = 400.dp)
                    .align(Alignment.Center)
            )

            if (isLoading || hasError) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black.copy(alpha = 0.7f)),
                    contentAlignment = Alignment.Center
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(color = loadingColor)
                    } else {
                        Icon(
                            painter = painterResource(R.drawable.ic_unknown),
                            contentDescription = "Error al cargar imagen",
                            tint = loadingColor,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            }
        }
    }
}


//@Composable
//fun DetailImage(
//    imageUrl: String?,
//    modifier: Modifier = Modifier,
//    baseUrl: String = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/",
//    contentDescription: String? = null,
//    shape: Shape = RoundedCornerShape(12.dp),
//    contentScale: ContentScale = ContentScale.FillBounds,
//    loadingColor: Color = Golden
//) {
//    // Estado para controlar manualmente la carga
//    var isLoading by remember { mutableStateOf(true) }
//    var hasError by remember { mutableStateOf(false) }
//
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(350.dp)
//            .clip(shape)
//    ) {
//        if (imageUrl == null) {
//            // Caso cuando no hay URL de imagen
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Black.copy(alpha = 0.7f)),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    painter = painterResource(R.drawable.ic_unknown),
//                    contentDescription = "Sin imagen disponible",
//                    tint = loadingColor,
//                    modifier = Modifier.size(48.dp)
//                )
//            }
//        } else {
//            // Usamos AsyncImage con Coil directamente
//            AsyncImage(
//                model = "$baseUrl$imageUrl",
//                contentDescription = contentDescription,
//                modifier = Modifier.fillMaxSize(),
//                contentScale = contentScale,
//                // Manejo de estados con transform
//                transform = { state ->
//                    isLoading = state is AsyncImagePainter.State.Loading
//                    hasError = state is AsyncImagePainter.State.Error
//                    state
//                }
//            )
//
//            // Overlay para estados de carga/error
//            if (isLoading || hasError) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Black.copy(alpha = 0.7f)),
//                    contentAlignment = Alignment.Center
//                ) {
//                    if (isLoading) {
//                        CircularProgressIndicator(color = loadingColor)
//                    } else if (hasError) {
//                        Icon(
//                            painter = painterResource(R.drawable.ic_unknown),
//                            contentDescription = "Error al cargar imagen",
//                            tint = loadingColor,
//                            modifier = Modifier.size(48.dp)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}

//@Composable
//fun DetailRow(
//    modifier: Modifier = Modifier,
//    label: String,
//    value: String?,
//    navController: NavController? = null,
//    onClick: (() -> Unit)? = null,
//    labelStyle: TextStyle = TextStyle(
//        fontSize = 18.sp,
//        color = Golden,
//        fontFamily = FontFamily(Font(R.font.cardo))
//    ),
//    valueStyle: TextStyle = TextStyle(
//        fontSize = 16.sp,
//        color = Color.White,
//        fontFamily = FontFamily(Font(R.font.cardo))
//    )
//) {
//    if (value != null && value.isNotBlank()) {
//        Row(
//            modifier = modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .clickable(enabled = onClick != null || navController != null) {
//                    onClick?.invoke()
//                    // Puedes agregar lógica de navegación aquí si es necesario
//                },
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "$label:",
//                style = labelStyle,
//                modifier = Modifier.width(120.dp)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(
//                text = value,
//                style = valueStyle,
//                modifier = Modifier.weight(1f)
//            )
//        }
//    }
//}

@Composable
fun CustomExpandable(
    title: String,
    modifier: Modifier = Modifier,
    initiallyExpanded: Boolean = false,
    titleStyle: TextStyle = TextStyle(
        fontSize = 18.sp,
        color = Golden,
        fontFamily = FontFamily(Font(R.font.cardo))
    ),
    content: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(initiallyExpanded) }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        border = BorderStroke(
            width = if (expanded) 1.dp else 0.dp,
            color = Golden.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = titleStyle
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    tint = Golden
                )
            }

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    content()

                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Golden.copy(alpha = 0.8f),
                        modifier = Modifier
                            .size(32.dp)
                            .fillMaxWidth()
                            .clickable { expanded = false }
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun WikiLinksExpandable(
    wikiUrls: WikiUrl?,
    modifier: Modifier = Modifier,
    linkStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.cardo))
    )
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    val validLinks = remember(wikiUrls) {
        listOfNotNull(
            wikiUrls?.tolkienGateway?.takeIf { it.isNotEmpty() }?.let { "Tolkien Gateway" to it },
            wikiUrls?.lotrFandom?.takeIf { it.isNotEmpty() }?.let { "LotR Fandom (EN)" to it },
            wikiUrls?.lotrFandomEs?.takeIf { it.isNotEmpty() }?.let { "LotR Fandom (ES)" to it },
            wikiUrls?.wikipedia?.takeIf { it.isNotEmpty() }?.let { "Wikipedia" to it },
            wikiUrls?.elFenomeno?.takeIf { it.isNotEmpty() }?.let { "El Fenómeno" to it }
        )
    }

    if (validLinks.isNotEmpty()) {
        CustomExpandable(
            title = "Enlaces Externos",
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                validLinks.forEach { (name, url) ->
                    Row(
                        modifier = Modifier
                            .clickable {
                                try {
                                    uriHandler.openUri(url)
                                } catch (e: Exception) {
                                    Toast.makeText(
                                        context,
                                        "No se pudo abrir el enlace",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = name,
                            style = linkStyle,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_link),
                            contentDescription = null,
                            tint = Golden,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    if (name != validLinks.last().first) {
                        HorizontalDivider(
                            color = Golden.copy(alpha = 0.3f),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel(
    images: List<String>,
    modifier: Modifier = Modifier,
    baseUrl: String = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/",
    navController: NavController? = null
) {
    val pagerState = rememberPagerState { images.size }

    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) { page ->
            AsyncImage(
                model = "$baseUrl${images[page]}",
                contentDescription = "Imagen ${page + 1}",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
//                        navController?.navigate(
//                            Routes.ImageViewer.createRoute(images[page])
//                        )
                    },
                contentScale = ContentScale.Crop
            )
        }

        // Indicadores
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(images.size) { index ->
                val color = if (pagerState.currentPage == index) Golden else Golden.copy(alpha = 0.3f)
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color)
                )
            }
        }
    }
}