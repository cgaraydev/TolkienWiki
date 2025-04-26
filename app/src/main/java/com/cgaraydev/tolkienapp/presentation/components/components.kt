package com.cgaraydev.tolkienapp.presentation.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun CustomSpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun CustomDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(color = DarkGray, modifier = modifier.padding(vertical = 8.dp))
}

@Composable
fun CustomTitle(
    text: String,
    fontSize: Int,
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration
) {
    Text(
        text = text,
        color = Golden,
        fontSize = fontSize.sp,
        modifier = modifier,
        textDecoration = textDecoration
    )
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
fun RaceWithGenderRow(
    race: String?,
    gender: String?,
    navController: NavController? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Parte izquierda - Raza
        Box(modifier = Modifier.weight(1f)) {
            DetailRow(
                label = stringResource(R.string.race),
                value = race,
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Parte derecha - Icono de género
        GenderIcon(gender = gender)
    }
}

@Composable
fun GenderIcon(
    gender: String?,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    tint: Color = Golden,
    paddingStart: Dp = 16.dp
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
                    .padding(start = paddingStart)
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
                modifier = Modifier.weight(1f).alignBy(FirstBaseline)
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
fun GlowingSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    icon: Painter = painterResource(R.drawable.ic_ring),
    backgroundColor: Color = Color(0xFF1E1E1E),
    contentColor: Color = Color.White,
    accentColor: Color = Golden,
) {
    val infiniteGlow = rememberInfiniteTransition()
    val glow by infiniteGlow.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "SnackbarGlow"
    )

    val borderColor = accentColor.copy(alpha = glow)
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "SnackbarScale"
    )

    Surface(
        color = backgroundColor,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .scale(scale)
            .border(
                BorderStroke(1.5.dp, borderColor),
                shape = RoundedCornerShape(12.dp)
            )
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = borderColor,
                spotColor = borderColor
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Golden,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = message,
                color = contentColor,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.cardo)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                maxLines = 2,
                softWrap = true
            )

            Icon(
                painter = icon,
                contentDescription = null,
                tint = Golden,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}

//@Composable
//fun GoodEvilSection(
//    title: String,
//    goodContent: String?,
//    evilContent: String?,
//    navController: NavController
//) {
//    if (goodContent.isNullOrBlank() && evilContent.isNullOrBlank()) return
//
//    CustomExpandable(title = title) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(24.dp)
//        ) {
//            if (!goodContent.isNullOrBlank()) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(
//                        text = stringResource(R.string.good),
//                        style = TextStyle(
//                            color = Color.White,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    )
//                    HtmlText(
//                        htmlText = goodContent,
//                        navController = navController,
//                        modifier = Modifier.padding(horizontal = 16.dp)
//                    )
//                }
//            }
//
//            if (!evilContent.isNullOrBlank()) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(
//                        text = stringResource(R.string.bad),
//                        style = TextStyle(
//                            color = Color.White,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    )
//                    HtmlText(
//                        htmlText = evilContent,
//                        navController = navController,
//                        modifier = Modifier.padding(horizontal = 16.dp)
//                    )
//                }
//            }
//        }
//    }
//}

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
//                    backgroundColor = Color(0xFF1E3A1E) // Verde oscuro para el bien
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(R.string.good),
//                            style = MaterialTheme.typography.h6.copy(
//                                color = Color(0xFF4CAF50), // Verde brillante
//                                fontWeight = FontWeight.Bold
//                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        HorizontalDivider(color = Color(0xFF4CAF50))
                        HtmlText(
                            htmlText = goodContent,
                            navController = navController,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }

            if (!evilContent.isNullOrBlank()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
//                    backgroundColor = Color(0xFF3A1E1E) // Rojo oscuro para el mal
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(R.string.bad),
//                            style = MaterialTheme.typography.h6.copy(
//                                color = Color(0xFFF44336), // Rojo
//                                fontWeight = FontWeight.Bold
//                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        HorizontalDivider(color = Color(0xFFF44336))
                        HtmlText(
                            htmlText = evilContent,
                            navController = navController,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}


