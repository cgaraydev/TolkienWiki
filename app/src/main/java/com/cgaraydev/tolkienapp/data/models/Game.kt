package com.cgaraydev.tolkienapp.data.models

data class Game(
    val id: String = "",
    val name: String = "",
    val poster: String? = null,
    val description: String? = null,
    val category: String? = null,
    val genre: String? = null,
    val year: String? = null,
    val platform: String? = null,
    val developer: String? = null,
    val publisher: String? = null,
    val rating: String? = null,
    val plot: String? = null,
    val wikiUrl: WikiUrl? = null,
    val images: List<ImageData>? = null,
    val tags: List<String>? = null
)
