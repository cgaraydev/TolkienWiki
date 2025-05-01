package com.cgaraydev.tolkienapp.data.models

data class Scenario(
    val scenarioId: String = "",
    val title: String = "",
    val text: String = "",
    val options: List<Option> = emptyList()
)