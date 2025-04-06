package com.cgaraydev.tolkienapp.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.grid.GridItem
import com.cgaraydev.tolkienapp.data.grid.gridItems
import com.cgaraydev.tolkienapp.data.quotes.Quote
import com.cgaraydev.tolkienapp.data.quotes.tolkienQuotes
import com.cgaraydev.tolkienapp.ui.theme.Aniron
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.Gray
import com.cgaraydev.tolkienapp.ui.theme.RingBearer
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 80.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderSection()
        QuotesSection(tolkienQuotes)
        Spacer(modifier = Modifier.height(80.dp))
        ExploreText()
        Spacer(modifier = Modifier.height(16.dp))
        GridSection(gridItems, navController)

    }
}

@Composable
fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Text(
            text = "Bienvenido a Arda",
            style = RingBearer.bodyLarge.copy(
                fontSize = 32.sp,
                color = Golden,
                letterSpacing = 0.5.sp
            ),
            color = Golden
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "Explora personajes, lugares, eventos y otros elementos del legendarium de J.R.R. Tolkien.",
            style = RingBearer.bodyMedium,
            color = Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.tolkien),
                contentDescription = "J.R.R. Tolkien",
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun GridSection(items: List<GridItem>, navController: NavController) {
    Column(Modifier.fillMaxWidth()) {
        items.chunked(2).forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                rowItems.forEach { item ->
                    GridCard(item, navController, modifier = Modifier.weight(1f))
                }
                if (rowItems.size == 1) {
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}

@Composable
fun GridCard(
    item: GridItem,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.DarkGray)
            .border(2.dp, Golden, RoundedCornerShape(12.dp))
            .clickable { navController.navigate(item.route) }
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(40.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        )
                    )
                )
        )
        Text(
            text = item.title,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }
}

@Composable
fun QuotesSection(quotes: List<Quote>) {
    var currentQuoteIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(6000)
            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.size
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { -it })
        ) {
            val currentQuote = quotes[currentQuoteIndex]
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "\"${currentQuote.text}\"",
                    style = Aniron.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = currentQuote.character,
                    style = Aniron.bodySmall,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ExploreText() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Explora: ",
            style = RingBearer.bodyLarge.copy(
                fontSize = 18.sp,
                color = Golden,
                letterSpacing = 0.5.sp
            ),
            color = Golden
        )
    }
}
