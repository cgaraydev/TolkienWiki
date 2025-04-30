package com.cgaraydev.tolkienapp.data.models


data class Book(
    val id: String = "",
    val title: String = "",
    val original: String = "",
    val poster: String = "",
    val year: String = "",
    val author: String = "",
    val illustrator: String = "",
    val publisher: String = "",
    val spanishPublisher: String = "",
    val legendarium: Boolean = true,
    val pages: String = "",
    val description: String = "",
    val synopsis: String = "",
    val category: String = "",
    val wikiUrl: WikiUrl? = null,
    val images: List<ImageData>? = null,
    val tags: List<String> = emptyList(),
)
