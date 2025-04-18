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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.WikiUrl
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray

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