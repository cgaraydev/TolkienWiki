package com.cgaraydev.tolkienapp.data.models

data class Event(
    val id: String = "",
    val name: String = "",
    val poster: String? = null,
    val history: String? = null,
    val category: String? = null,
    val conflict: String? = null,
    val date: String? = null,
    val location: String? = null,
    val otherNames: String? = null,
    val outcome: String? = null,
    val combatants: Combatants? = null,
    val commanders: Commanders? = null,
    val strength: Strength? = null,
    val casualties: Casualties? = null,
    val wikiUrl: WikiUrl? = null,
    val images: List<ImageData>? = null,
    val tags: List<String> = emptyList(),
    val involved: String? = null,
    val etymology: String? = null,
    val battles: String? = null
)

data class Combatants(
    var good: String? = null,
    var evil: String? = null
)

data class Commanders(
    var good: String? = null,
    var evil: String? = null
)

data class Casualties(
    var good: String? = null,
    var evil: String? = null
)

data class Strength(
    var good: String? = null,
    var evil: String? = null
)
