package com.cgaraydev.tolkienapp.presentation.tolkien

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.CustomTitle
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray

@Composable
fun TolkienHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.tolkien),
            contentDescription = "Retrato de J.R.R. Tolkien",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        ),
                        startY = 0.3f
                    )
                )
        )
        Text(
            text = "J.R.R. Tolkien",
            color = Golden,
            fontSize = 36.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}

@Composable
fun BioDataSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
           TolkienBioData()
        }
    }
}

@Composable
fun BioDataRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Golden,
            fontSize = 14.sp,
            modifier = Modifier
                .width(120.dp)
                .alpha(0.7f)
        )
        Text(
            text = value,
            color = White,
            style = TextStyle().copy(
                fontSize = 14.sp
            ),
            lineHeight = 16.sp
        )
    }
}

@Composable
fun TolkienIntroduction() {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
      TolkienIntroductionData()
    }
}

@Composable
fun ExpandableBiographySection(
    title: String,
    quote: String,
    content: String
) {
    var expanded by remember { mutableStateOf(false) }
    val arrowIcon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Encabezado clickeable
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .fillMaxWidth()
                .padding(bottom = if (expanded) 0.dp else 8.dp)
        ) {
            Text(
                text = title,
                color = Golden,
                fontSize = 22.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = arrowIcon,
                contentDescription = if (expanded) "Contraer sección" else "Expandir sección",
                tint = Golden,
                modifier = Modifier.size(24.dp)
            )
        }

        // Contenido expandible (quote + content)
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Column {
                // Cita
                Text(
                    text = quote,
                    style = TextStyle(
                        color = LightGray,
                        fontFamily = FontFamily(Font(R.font.aniron)),
                        fontSize = 12.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
                // Contenido principal
                Text(
                    text = content,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = White
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        // Separador (solo visible cuando está contraído)
        AnimatedVisibility(
            visible = !expanded,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Golden.copy(alpha = 0.2f))
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun TolkienBiography() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        CustomTitle(
            "Biografía",
            26,
            Modifier.align(Alignment.CenterHorizontally),
            textDecoration = TextDecoration.Underline
        )
        CustomHeightSpacer(20)
        TolkienIntroduction()
        TolkienBiographyData()
        ExpandableTimelineSection()
    }
}

@Composable
fun ExpandableTimelineSection() {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        // Encabezado clickeable
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .fillMaxWidth()
                .padding(bottom = if (expanded) 0.dp else 8.dp, top = 8.dp)
        ) {
            Text(
                text = "Cronología",
                color = Golden,
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) "Contraer" else "Expandir",
                tint = Golden
            )
        }

        // Contenido de la línea de tiempo
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            CanvasTimelineSection()
        }

        // Separador
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Golden.copy(alpha = 0.2f))
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CanvasTimelineSection() {
    val timelineEvents = tolkienTimeline
    val lineColor = Golden
    val pointColor = Golden
    val textColor = White
    val secondaryTextColor = White.copy(alpha = 0.8f)

    Column(modifier = Modifier.padding(vertical = 16.dp)) {

        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth()
        ) {
            val itemHeight = 80.dp
            val lineX = 20.dp
            val pointRadius = 5.dp
            val lineWidth = 2.dp

            // Calculamos la altura total necesaria
            val totalHeight = with(LocalDensity.current) {
                itemHeight.toPx() * timelineEvents.size
            }

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(with(LocalDensity.current) { totalHeight.toDp() })
            ) {
                // Dibujamos la línea vertical principal
                drawLine(
                    color = lineColor.copy(alpha = 0.7f),
                    start = Offset(lineX.toPx(), 0f),
                    end = Offset(lineX.toPx(), size.height),
                    strokeWidth = lineWidth.toPx()
                )

                // Dibujamos los puntos y conectores
                timelineEvents.forEachIndexed { index, _ ->
                    val yPos = itemHeight.toPx() * (index + 0.5f)

                    // Punto principal
                    drawCircle(
                        color = pointColor,
                        radius = pointRadius.toPx(),
                        center = Offset(lineX.toPx(), yPos)
                    )
                }
            }

            // Contenido de texto superpuesto
            Column(modifier = Modifier.padding(start = 40.dp)) {
                timelineEvents.forEach { event ->
                    TimelineTextItem(
                        event = event,
                        height = itemHeight,
                        textColor = textColor,
                        secondaryTextColor = secondaryTextColor
                    )
                }
            }
        }
    }
}

@Composable
private fun TimelineTextItem(
    event: TimelineEvent,
    height: Dp,
    textColor: Color,
    secondaryTextColor: Color
) {
    Column(
        modifier = Modifier
            .height(height)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = event.year,
            color = Golden,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = event.title,
            color = textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
        if (event.description.isNotBlank()) {
            Text(
                text = event.description,
                color = secondaryTextColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun CompleteWorksSection() {
    val worksCategories = tolkienWorks

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        CustomTitle(
            text = "Obra de Tolkien",
            fontSize = 24,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            textDecoration = TextDecoration.Underline
        )
        worksCategories.forEach { category ->
            Column(
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(
                    text = category.title,
                    color = Golden.copy(alpha = 0.9f),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    items(category.works) { work ->
                        WorkCard(work) {}
                    }
                }
            }
        }
    }
}

@Composable
fun WorkCard(work: Work, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp)
            .clickable(onClick = onClick), // Navegación futura
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(work.imageRes),
                contentDescription = "Portada de ${work.title}",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            // Fondo degradado mejorado para legibilidad
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.8f),
                            ),
                            endY = 0.6f
                        )
                    )
            )

            // Contenido textual con padding dinámico
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = work.title,
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = work.year.split(",")[0], // Muestra solo el año si hay editorial
                    color = White.copy(alpha = 0.9f),
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

