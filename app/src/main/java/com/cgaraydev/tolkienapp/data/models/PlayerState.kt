package com.cgaraydev.tolkienapp.data.models

data class PlayerState(
    val health: Int = 100,
    val strength: Int = 50,
    val stealth: Int = 30,
    val morality: Int = 50,
    val items: List<String> = emptyList(),
    val allies: List<String> = emptyList()
)