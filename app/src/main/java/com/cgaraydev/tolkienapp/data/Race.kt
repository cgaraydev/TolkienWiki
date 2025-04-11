package com.cgaraydev.tolkienapp.data


data class Race(
    val id: String = "",
    val name: String = "",
    val poster: String? = null,
    val history: String? = null,
    val otherNames: String? = null,
    val origins: String? = null,
    val location: String? = null,
    val languages: String? = null,
    val people: String? = null,
    val members: String? = null,
    val lifespan: String? = null,
    val height: String? = null,
    val characteristics: String? = null,
    val etymology: String? = null,
    val category: String? = null,
    val wikiUrl: WikiUrl? = null,
    val images: List<ImageData> = emptyList(),
    val tags: List<String> = emptyList()
)
