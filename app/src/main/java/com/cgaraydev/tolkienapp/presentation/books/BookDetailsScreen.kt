package com.cgaraydev.tolkienapp.presentation.books

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.data.models.Book
import com.cgaraydev.tolkienapp.presentation.components.CustomExpandable
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.DetailHeader
import com.cgaraydev.tolkienapp.presentation.components.DetailImage
import com.cgaraydev.tolkienapp.presentation.components.DetailRow
import com.cgaraydev.tolkienapp.presentation.components.DetailScreenTemplate
import com.cgaraydev.tolkienapp.presentation.components.ImageCarousel
import com.cgaraydev.tolkienapp.presentation.components.WikiLinksExpandable
import com.cgaraydev.tolkienapp.utils.HtmlText

@Composable
fun BookDetailsScreen(
    bookId: String,
    navController: NavController,
    viewModel: BooksViewModel = hiltViewModel()
) {
    val book by viewModel.bookDetails.collectAsState()
    val isLoading by viewModel.isLoadingDetails.collectAsState()
    val error by viewModel.errorDetails.collectAsState()

    DetailScreenTemplate(
        itemId = bookId,
        viewModel = viewModel,
        loadDetails = { viewModel.loadBookDetails(it) },
        isLoading = isLoading,
        error = error,
        item = book
    ) { bookItem ->
        BookDetailsContent(
            book = bookItem,
            navController = navController
        )
    }
}

@Composable
fun BookDetailsContent(
    book: Book,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(title = book.title)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                CustomHeightSpacer(16)
                DetailImage(
                    imageUrl = book.poster,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )
                CustomHeightSpacer(16)
                DetailRow("Título original", book.original, navController)
                DetailRow("Año de publicación", book.year, navController)
                DetailRow("Autor", book.author, navController)
                DetailRow("Ilustrador", book.illustrator, navController)
                DetailRow("Editorial original", book.publisher, navController)
                DetailRow("Editorial en español", book.spanishPublisher, navController)
                DetailRow("Páginas", book.pages, navController)
                DetailRow("Categoría", book.category, navController)
                CustomExpandable("Resumen") {
                    HtmlText(
                        htmlText = book.description,
                        navController = navController
                    )
                }
                CustomExpandable("Sinopsis") {
                    HtmlText(
                        htmlText = book.synopsis,
                        navController = navController
                    )
                }
                book.images?.let { images ->
                    if (images.isNotEmpty()) {
                        CustomExpandable(title = "Imágenes del libro") {
                            ImageCarousel(
                                images = images,
                                modifier = Modifier.padding(vertical = 16.dp),
                                navController = navController
                            )
                        }
                    }
                }
                WikiLinksExpandable(wikiUrls = book.wikiUrl)
                CustomHeightSpacer(40)
            }
        }
    }
}