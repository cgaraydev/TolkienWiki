package com.cgaraydev.tolkienapp.presentation.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.BookData
import com.cgaraydev.tolkienapp.data.local.datalocal.bookTags
import com.cgaraydev.tolkienapp.data.models.Book
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _books = MutableStateFlow<List<BookData>>(emptyList())
    val books: StateFlow<List<BookData>> = _books.asStateFlow()

    private val _bookDetails = MutableStateFlow<Book?>(null)
    val bookDetails: StateFlow<Book?> = _bookDetails.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()

    private val categoryTagMap = mapOf(
        "Obras de Tolkien" to "tolkien_works",
        "Obras Postumas" to "posthumous",
        "Legendarium" to "legendarium",
        "Fantasia" to "fantasy",
        "Editado por Christopher Tolkien" to "edited_by_christopher_tolkien",
        "Trabajos Academicos" to "academic",
        "Todos" to "books"
    )

    init {
        loadBooks()
    }

    private fun loadBooks() {
        viewModelScope.launch {
            _books.value = bookTags
        }
    }

    fun getBooksByTags(displayName: String): List<BookData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return books.value.filter { it.tags.contains(tag) }
    }

    fun loadBookDetails(bookId: String) {
        _isLoadingDetails.value = true
        _errorDetails.value = null

        firestore.collection("books")
            .document(bookId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    _bookDetails.value =
                        document.toObject(Book::class.java)?.copy(id = bookId)
                } else {
                    _errorDetails.value = "Book not found"
                }
                _isLoadingDetails.value = false
            }
            .addOnFailureListener { exception ->
                _errorDetails.value = "Error loading book details: ${exception.message}"
                _isLoadingDetails.value = false
            }
    }

}