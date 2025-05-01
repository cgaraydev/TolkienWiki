package com.cgaraydev.tolkienapp.data.models

data class Option(
    val text: String = "",
    val nextScenarioId: String = "",
    val condition: Condition? = null,
    val effects: Effects? = null
)

data class HealthCondition(
    val min: Int = 0,
    val max: Int = Int.MAX_VALUE
)

data class Condition(
    val health: HealthCondition? = null,
    val stealth: Int? = null
)

data class Effects(
    val health: Int? = null,
    val strength: Int? = null,
    val stealth: Int? = null,
    val morality: Int? = null,
    val items: List<String>? = null,
    val allies: List<String>? = null
)
