package com.cgaraydev.tolkienapp.presentation.books

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.local.datalocal.BookData
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.ExpandableHorizontalSection
import com.cgaraydev.tolkienapp.presentation.components.ScreenHeader
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun BooksScreen(
    navController: NavController,
    viewModel: BooksViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ScreenHeader(imageRes = R.drawable.books, label = "Libros")
        CustomSpacer(40)

        if (books.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Golden)
            }
        } else {
            BooksContent(viewModel, navController)
        }
        CustomSpacer(40)
    }
}

@Composable
fun BooksContent(
    viewModel: BooksViewModel,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        val mainCategories = listOf(
            "Obras de Tolkien",
            "Obras Postumas",
            "Legendarium",
            "Fantasia",
            "Editado por Christopher Tolkien",
            "Trabajos Academicos",
            "Todos"
        )

        items(mainCategories) { category ->
            val booksByCategory = viewModel.getBooksByTags(category)
            if (booksByCategory.isNotEmpty()) {
                ExpandableHorizontalSection(
                    title = category,
                    items = booksByCategory,
                    itemCount = booksByCategory.size,
                    countTextStyle = TextStyle(
                        fontSize = 16.sp,
                        color = White.copy(alpha = 0.7f),
                        fontFamily = FontFamily(Font(R.font.cardo))
                    ),
                    borderColor = Golden.copy(alpha = 0.5f),
                    contentPadding = PaddingValues(vertical = 12.dp)
                ) { book ->
                    BookCard(book) {
                        navController.navigate(
                            Routes.BookDetails.createRoute(book.id)
                        )
                    }
                }
//                ExpandableSubCategory(
//                    title = category,
//                    items = booksByCategory,
//                    itemCount = booksByCategory.size,
//                    titleTextStyle = TextStyle(
//                        fontSize = 24.sp,
//                        color = White,
//                        fontFamily = FontFamily(Font(R.font.cardo))
//                    ),
//                    countTextStyle = TextStyle(
//                        fontSize = 16.sp,
//                        color = White.copy(alpha = 0.7f),
//                        fontFamily = FontFamily(Font(R.font.cardo))
//                    ),
//                    borderColor = Golden.copy(alpha = 0.5f)
//                ) { book ->
//                    BookCard(book) {
//                        navController.navigate(
//                            Routes.BookDetails.createRoute(book.id)
//                        )
//                    }
//                }
            }
        }
    }
}

@Composable
fun BookCard(book: BookData, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val elevation = animateDpAsState(if (isPressed) 4.dp else 8.dp)
    val scale = animateFloatAsState(if (isPressed) 0.98f else 1f)

    Card(
        modifier = Modifier
            .width(160.dp)
            .height(240.dp)
            .clickable(onClick = onClick)
            .padding(8.dp)
            .graphicsLayer { scaleX = scale.value; scaleY = scale.value }
            .hoverable(interactionSource = interactionSource),
        elevation = CardDefaults.cardElevation(elevation.value)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = book.imageRes,
                contentDescription = "Portada de ${book.title}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                placeholder = painterResource(R.drawable.logo)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0x80000000)
                            ),
                            endY = 0.3f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = book.title,
                    color = White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cardo)),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}


//@Composable
//fun BooksScreen(
//    navController: NavController,
//    viewModel: BooksViewModel = hiltViewModel()
//) {
//    val books by viewModel.books.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        ScreenHeader(imageRes = R.drawable.books, label = "Libros")
//        CustomSpacer(40)
//
//        if (books.isEmpty()) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator(color = Golden)
//            }
//        } else {
//            BooksContent(viewModel, navController)
//        }
//        CustomSpacer(40)
//    }
//}
//
//@Composable
//fun BooksContent(
//    viewModel: BooksViewModel,
//    navController: NavController
//) {
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 12.dp)
//    ) {
//        val mainCategories = listOf(
//            "Obras de Tolkien",
//            "Obras Postumas",
//            "Legendarium",
//            "Fantasia",
//            "Editado por Christopher Tolkien",
//            "Trabajos Academicos",
//            "Todos"
//        )
//
//        items(mainCategories) { category ->
//            val booksByCategory = viewModel.getBooksByTags(category)
//            if (booksByCategory.isNotEmpty()) {
//                Column(
//                    modifier = Modifier.padding(bottom = 24.dp)
//                ) {
//                    Text(
//                        text = category,
//                        color = Golden.copy(alpha = 0.9f),
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.cardo)),
//                        modifier = Modifier.padding(bottom = 12.dp)
//                    )
//
//                    LazyRow(
//                        horizontalArrangement = Arrangement.spacedBy(12.dp),
//                        contentPadding = PaddingValues(horizontal = 8.dp)
//                    ) {
//                        items(booksByCategory) { book ->
//                            BookCard(book) {
//                                navController.navigate(
//                                    Routes.BookDetails.createRoute(book.id)
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun BookCard(book: BookData, onClick: () -> Unit) {
//    val interactionSource = remember { MutableInteractionSource() }
//    val isPressed by interactionSource.collectIsPressedAsState()
//
//    val elevation = animateDpAsState(if (isPressed) 4.dp else 8.dp)
//    val scale = animateFloatAsState(if (isPressed) 0.98f else 1f)
//    Card(
//        modifier = Modifier
//            .width(160.dp)
//            .height(240.dp)
//            .clickable(onClick = onClick)
//            .padding(4.dp)
//            .graphicsLayer { scaleX = scale.value; scaleY = scale.value }
//            .hoverable(interactionSource = interactionSource),
//        elevation = CardDefaults.cardElevation(elevation.value)
//    ) {
//        Box(modifier = Modifier.fillMaxSize()) {
//            AsyncImage(
//                model = book.imageRes,
//                contentDescription = "Portada de ${book.title}",
//                contentScale = ContentScale.Crop,  // Crop en lugar de FillBounds
//                modifier = Modifier.fillMaxSize(),
//                placeholder = painterResource(R.drawable.logo)
//            )
//
//            Box(
//                modifier = Modifier
//                    .align(Alignment.BottomStart)
//                    .fillMaxWidth()
//                    .height(80.dp)
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Transparent,
//                                Color(0x80000000)
//                            ),
//                            endY = 0.3f
//                        )
//                    )
//            )
//
//            Column(
//                modifier = Modifier
//                    .align(Alignment.BottomStart)
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = book.title,
//                    color = White,
//                    fontSize = 16.sp,
//                    fontFamily = FontFamily(Font(R.font.cardo)),
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                )
//
//
//            }
//
////            if (book.tags.contains("featured")) {
////                Box(
////                    modifier = Modifier
////                        .align(Alignment.TopEnd)
////                        .padding(8.dp)
////                        .background(Golden, CircleShape)
////                        .size(24.dp),
////                    contentAlignment = Alignment.Center
////                ) {
////                    Icon(
////                        painter = painterResource(R.drawable.ic_event),
////                        contentDescription = "Destacado",
////                        tint = Color.Black,
////                        modifier = Modifier.size(12.dp)
////                    )
////                }
////            }
//        }
//    }
//}