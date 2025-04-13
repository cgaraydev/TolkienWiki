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
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.ImageData
import com.cgaraydev.tolkienapp.data.WikiUrl
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray
import com.cgaraydev.tolkienapp.utils.Constants.BASE_IMAGE_URL
import com.cgaraydev.tolkienapp.utils.HtmlText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomSpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun CustomExpandable(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        border = BorderStroke(
            width = if (expanded) 1.dp else 0.dp,
            color = Golden.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = TextStyle().copy(color = LightGray, fontSize = 16.sp)
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = LightGray
                )
            }
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    content()
                    CustomSpacer(12)
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close),
                        tint = LightGray.copy(alpha = 0.8f),
                        modifier = Modifier
                            .size(32.dp)
                            .fillMaxWidth()
                            .clickable { expanded = false }
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp)
                    )
                    CustomSpacer(8)
                }
            }
        }
    }
}

@Composable
fun ZoomableImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    maxScale: Float = 5f,
    resetTrigger: Boolean = false,
    onGestureStateChange: (Boolean) -> Unit = {}
) {
    var scale by remember { mutableFloatStateOf(1f) }
    LaunchedEffect(resetTrigger) {
        if (resetTrigger) {
            scale = 1f
            onGestureStateChange(false)
        }
    }
    Box(
        modifier = modifier
            .clipToBounds()
            .pointerInput(Unit) {
                detectTransformGestures(
                    panZoomLock = false,
                ) { _, _, zoom, _ ->
                    scale = (scale * zoom).coerceIn(1f, maxScale)
                    onGestureStateChange(scale > 1f)
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        scale = if (scale > 1f) 1f else 2f
                        onGestureStateChange(scale > 1f)
                    }
                )
            }
    ) {
        val fullImageUrl =
            "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/$imageUrl"
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(fullImageUrl)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale
                )
                .fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel(
    images: List<ImageData>,
    modifier: Modifier = Modifier,
    maxScale: Float = 5f,
    navController: NavController,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    if (images.isEmpty()) return
    val pagerState = rememberPagerState { images.size }
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .height(350.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = false
            ) { page ->
                ZoomableImage(
                    imageUrl = images[page].url,
                    maxScale = maxScale,
                    resetTrigger = pagerState.currentPage == page,
                    modifier = Modifier.fillMaxSize()
                )
            }
            if (pagerState.currentPage > 0) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .background(Color.Black.copy(alpha = 0.3f), CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_left),
                        contentDescription = stringResource(R.string.prev),
                        tint = Color.White
                    )
                }
            }
            if (pagerState.currentPage < images.size - 1) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .background(Color.Black.copy(alpha = 0.3f), CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_right),
                        contentDescription = stringResource(R.string.next),
                        tint = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(images.size) { index ->
                    val color =
                        if (pagerState.currentPage == index) Golden else Color.White.copy(alpha = 0.3f)
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(if (pagerState.currentPage == index) 10.dp else 6.dp)
                            .clip(CircleShape)
                            .background(color)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                    )
                }
            }
        }
        val currentArtist = images.getOrNull(pagerState.currentPage)?.artist ?: ""
        if (currentArtist.isNotEmpty()) {
            HtmlText(
                htmlText = currentArtist,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                navController = navController
            )
        }
    }
}

@Composable
fun WikiLinksExpandable(
    wikiUrls: WikiUrl?,
    modifier: Modifier = Modifier
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
        CustomExpandable(title = stringResource(R.string.links), modifier = modifier) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
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
                                        context.getString(R.string.link_down),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = name,
                            color = Color.White,
                            style = TextStyle(),
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f),
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_link),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenHeader(
    imageRes: Int,
    label: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.4f)
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier.align(Alignment.Center)
        )
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
//

@Composable
fun GoodEvilSection(
    title: String,
    goodContent: String?,
    evilContent: String?,
    navController: NavController
) {
    if (goodContent.isNullOrBlank() && evilContent.isNullOrBlank()) return

    CustomExpandable(title = title) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            if (!goodContent.isNullOrBlank()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.good),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    HtmlText(
                        htmlText = goodContent,
                        navController = navController,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            if (!evilContent.isNullOrBlank()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.bad),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    HtmlText(
                        htmlText = evilContent,
                        navController = navController,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun StateHandler(
    isLoading: Boolean,
    error: String?,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
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
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center),
                    style = TextStyle()
                )
            }

            else -> {
                content()
            }
        }
    }
}

@Composable
fun PosterImage(
    imagePath: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    if (imagePath.isNullOrBlank()) return

    val imageUrl = "${BASE_IMAGE_URL}$imagePath"

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Black.copy(alpha = 0.2f))
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ZoomableImage2(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val scale = remember { mutableFloatStateOf(1f) }
    val offsetX = remember { mutableFloatStateOf(0f) }
    val offsetY = remember { mutableFloatStateOf(0f) }

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale.floatValue *= zoom
                    offsetX.floatValue += pan.x
                    offsetY.floatValue += pan.y
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        // Resetear zoom al hacer doble tap
                        scale.floatValue = 1f
                        offsetX.floatValue = 0f
                        offsetY.floatValue = 0f
                    }
                )
            }
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Mapa detallado",
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale.floatValue
                    scaleY = scale.floatValue
                    translationX = offsetX.floatValue
                    translationY = offsetY.floatValue
                }
                .fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}