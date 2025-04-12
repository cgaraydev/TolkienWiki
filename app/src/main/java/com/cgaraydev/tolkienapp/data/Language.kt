package com.cgaraydev.tolkienapp.data

data class Language(
    val id: String = "",
    val name: String = "",
    val history: String? = null,
    val otherNames: String? = null,
    val wikiUrl: WikiUrl? = null,
    val wordsList: List<Word>? = null,
    val tags: List<String>? = null,
    val images: List<ImageData>? = null
)

data class Word(
    var original: String? = null,
    var translation: String? = null
)
