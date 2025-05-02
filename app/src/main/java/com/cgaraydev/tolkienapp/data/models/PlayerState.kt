package com.cgaraydev.tolkienapp.data.models

data class PlayerState(
    val health: Int = 100,        // 0-100 (0 = muerte)
    val strength: Int = 5,        // 1-10 (nunca < 1)
    val defense: Int = 5,         // 1-10
    val wisdom: Int = 5,          // 1-10 (antes "intelligence")
    val luck: Int = 5,            // 1-10
    val agility: Int = 5,         // 1-10
    val items: List<String> = emptyList(),
    val allies: List<String> = emptyList()
) {
    // Función para aplicar efectos garantizando mínimos
    fun applyEffects(effects: Map<String, Int>): PlayerState {
        var newState = this.copy()

        effects.forEach { (key, value) ->
            newState = when (key) {
                "health" -> newState.copy(
                    health = (health + value).coerceIn(0, 100)
                )
                "strength" -> newState.copy(
                    strength = (strength + value).coerceAtLeast(1)
                )
                "defense" -> newState.copy(
                    defense = (defense + value).coerceAtLeast(1)
                )
                "wisdom" -> newState.copy(
                    wisdom = (wisdom + value).coerceAtLeast(1)
                )
                "luck" -> newState.copy(
                    luck = (luck + value).coerceAtLeast(1)
                )
                "agility" -> newState.copy(
                    agility = (agility + value).coerceAtLeast(1)
                )
                else -> newState
            }
        }
        return newState
    }
}