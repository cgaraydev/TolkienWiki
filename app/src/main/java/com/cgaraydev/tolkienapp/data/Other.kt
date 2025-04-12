package com.cgaraydev.tolkienapp.data

data class Other(
    val id: String = "",
    val name: String = "",
    val poster: String? = null,
    val history: String? = null,
    val category: String? = null,
    val etymology: String? = null,
    val description: String? = null,
    val otherNames: String? = null,
    val location: String? = null,
    val wikiUrl: WikiUrl? = null,
    val images: List<ImageData>? = null,
    val tags: List<String>? = null,
    val owner: String? = null,
    val creator: String? = null,
    val languages: String? = null,
    val founder: String? = null,
    val founded: String? = null,
    val leader: String? = null,
    val heirlooms: String? = null
)
