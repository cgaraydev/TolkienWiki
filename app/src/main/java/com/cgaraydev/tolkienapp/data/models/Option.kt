package com.cgaraydev.tolkienapp.data.models

data class Option(
    val text: String = "",
    val nextScenarioId: String = "",
    val effects: Effects? = null,
    val effectsSummary: String? = null,
    val result: String? = null
)

data class Effects(
    val health: Int? = null,
    val strength: Int? = null,
    val defense: Int? = null,
    val agility: Int? = null,
    val wisdom: Int? = null,
    val luck: Int? = null,
    val items: List<String>? = null,
    val allies: List<String>? = null
)


data class AttributeChange(
    val attributeName: String,
    val change: Int,
    val newValue: Int
)
