package com.cgaraydev.tolkienapp.data.models

data class Scenario(
    val scenarioId: String = "",
    val title: String = "",
    val text: String = "",
    val decision: List<Option> = emptyList()
)