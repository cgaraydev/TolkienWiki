package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.DarkGreen
import com.cgaraydev.tolkienapp.ui.theme.DarkRed
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray
import com.cgaraydev.tolkienapp.ui.theme.QuizRed
import com.cgaraydev.tolkienapp.utils.HtmlText

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
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    contentScale = ContentScale.Fit
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

@Composable
fun GenderIcon(
    gender: String?,
    modifier: Modifier = Modifier,
    size: Dp = 30.dp,
    tint: Color = Golden,
) {
    gender?.takeIf { it.isNotBlank() }?.let { g ->
        val iconRes = when (g.lowercase()) {
            stringResource(R.string.male) -> R.drawable.ic_male
            stringResource(R.string.female) -> R.drawable.ic_female
            else -> null
        }
        iconRes?.let {
            Icon(
                painter = painterResource(it),
                contentDescription = "Género: $g",
                tint = tint,
                modifier = modifier
                    .size(size)
            )
        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String?,
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    labelStyle: TextStyle = TextStyle(
        fontSize = 18.sp,
        color = LightGray,
        fontFamily = FontFamily(Font(R.font.cardo)),
        fontWeight = FontWeight.Bold
    ),
    valueStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.cardo))
    )
) {
    if (!value.isNullOrBlank()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(enabled = onClick != null || navController != null) {
                    onClick?.invoke()
                },
        ) {
            // Label con alineación precisa
            Text(
                text = "$label: ",
                style = labelStyle,
                modifier = Modifier.alignBy(FirstBaseline)
            )

            // Contenedor para el HtmlText con alineación controlada
            Box(
                modifier = Modifier
                    .weight(1f)
                    .alignBy(FirstBaseline)
            ) {
                if (navController != null) {
                    HtmlText(
                        htmlText = value,
                        navController = navController,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = valueStyle
                    )
                } else {
                    Text(
                        text = value,
                        style = valueStyle,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (!goodContent.isNullOrBlank()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = DarkGreen.copy(alpha = 0.4f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(R.string.good),
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.cardo)),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        HorizontalDivider(color = Golden)
                        HtmlText(
                            htmlText = goodContent,
                            navController = navController,
                            modifier = Modifier.padding(top = 8.dp),
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.cardo))
                            )
                        )
                    }
                }
            }

            if (!evilContent.isNullOrBlank()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = DarkRed.copy(alpha = 0.4f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(R.string.bad),
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.cardo)),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        HorizontalDivider(color = Golden)
                        HtmlText(
                            htmlText = evilContent,
                            navController = navController,
                            modifier = Modifier.padding(top = 8.dp),
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
    }
}