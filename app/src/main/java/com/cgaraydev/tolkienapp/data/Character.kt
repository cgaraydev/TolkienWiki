package com.cgaraydev.tolkienapp.data

data class Character(
    val id: String? = null,
    val name: String? = null,
    val poster: String? = null,
    val race: String? = null,
    val birth: String? = null,
    val death: String? = null,
    val titles: String? = null,
    val love: String? = null,
    val genre: String? = null,
    val otherNames: String? = null,
    val family: String? = null,
    val etymology: String? = null,
    val house: String? = null,
    val wikiUrl: WikiUrl? = null,
    val biography: String? = null,
    val images: List<ImageData> = emptyList(),
    val faction: String? = null,
    val tags: List<String> = emptyList()
)