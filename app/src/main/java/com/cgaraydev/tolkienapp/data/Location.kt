package com.cgaraydev.tolkienapp.data

data class Location(
    val id: String = "",
    val name: String = "",
    val poster: String? = null,
    val capital: String? = null,
    val inhabitants: String? = null,
    val languages: String? = null,
    val founded: String? = null,
    val destroyed: String? = null,
    val otherNames: String? = null,
    val type: String? = null,
    val events: String? = null,
    val location: String? = null,
    val history: String? = null,
    val majorTowns: String? = null,
    val regions: String? = null,
    val etymology: String? = null,
    val images: List<ImageData> = emptyList(),
    val tags: List<String> = emptyList(),
    val wikiUrl: WikiUrl? = null
)
