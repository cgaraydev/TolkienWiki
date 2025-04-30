package com.cgaraydev.tolkienapp.presentation.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.WikiUrl
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun <T> ExpandableCategory(
    title: String,
    items: List<T>,
    itemCount: Int = items.size,
    titleTextStyle: TextStyle = TextStyle(
        fontSize = 26.sp,
        fontFamily = FontFamily(Font(R.font.cardo)),
        color = Color.White
    ),
    countTextStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color.White
    ),
    containerColor: Color = Color.Black,
    content: @Composable (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title.uppercase(),
                    style = titleTextStyle,
                    modifier = Modifier.weight(1f)
                )
                if (items.isNotEmpty()) {
                    Text(
                        text = "($itemCount)",
                        style = countTextStyle,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            AnimatedVisibility(
                visible = expanded && items.isNotEmpty(),
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column {
                    items.forEach { item ->
                        content(item)
                    }
                }
            }
        }
    }
}

@Composable
fun <T> ExpandableSubCategory(
    title: String,
    items: List<T>,
    itemCount: Int = items.size,
    titleTextStyle: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontFamily = FontFamily(Font(R.font.cardo)),
        color = Color.White
    ),
    countTextStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.cardo))
    ),
    containerColor: Color = Color.Black,
    borderColor: Color = Golden.copy(alpha = 0.5f),
    content: @Composable (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, borderColor)
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
                    style = titleTextStyle,
                    modifier = Modifier.weight(1f)
                )
                if (items.isNotEmpty()) {
                    Text(
                        text = "($itemCount)",
                        style = countTextStyle,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            AnimatedVisibility(visible = expanded && items.isNotEmpty()) {
                Column {
                    items.forEachIndexed { index, item ->
                        // Mostrar divider solo si no es el último elemento
                        val showDivider = index < items.lastIndex
                        Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                            content(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun <T> ExpandableHorizontalSection(
    title: String,
    items: List<T>,
    itemCount: Int = items.size,
    titleTextStyle: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.cardo)),
        color = Color.White
    ),
    countTextStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.cardo))
    ),
    containerColor: Color = Color.Black,
    borderColor: Color = Golden.copy(alpha = 0.5f),
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
    content: @Composable (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Column {
            // Header (igual que en ExpandableSubCategory)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = titleTextStyle,
                    modifier = Modifier.weight(1f)
                )
                if (items.isNotEmpty()) {
                    Text(
                        text = "($itemCount)",
                        style = countTextStyle,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            // Contenido horizontal (la diferencia principal)
            AnimatedVisibility(visible = expanded && items.isNotEmpty()) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    items(items) { item ->
                        content(item)
                    }
                }
            }
        }
    }
}


@Composable
fun <T> ListItem(
    item: T,
    text: String,
    onClick: () -> Unit,
    textStyle: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.cardo)),
        color = Color.White
    ),
    containerColor: Color = Color.Black,
//    icon: Painter = painterResource(R.drawable.ic_forward),
//    iconTint: Color = Color.White,
    showDivider: Boolean = true,
    dividerColor: Color = Golden.copy(alpha = 0.5f),
    dividerPadding: PaddingValues = PaddingValues(horizontal = 16.dp)
) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable(onClick = onClick),
            colors = CardDefaults.cardColors(
                containerColor = containerColor
            )
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    style = textStyle,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.ic_forward),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        if (showDivider) {
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalDivider(
                color = dividerColor,
                modifier = Modifier.padding(dividerPadding)
            )
        }
    }
}

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
            wikiUrls?.tolkienGateway?.takeIf { it.isNotEmpty() }
                ?.let { "Tolkien Gateway" to it },
            wikiUrls?.lotrFandom?.takeIf { it.isNotEmpty() }?.let { "LotR Fandom (EN)" to it },
            wikiUrls?.lotrFandomEs?.takeIf { it.isNotEmpty() }
                ?.let { "LotR Fandom (ES)" to it },
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