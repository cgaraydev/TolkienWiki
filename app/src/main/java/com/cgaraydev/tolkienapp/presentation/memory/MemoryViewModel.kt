package com.cgaraydev.tolkienapp.presentation.memory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.MemoryCard
import com.cgaraydev.tolkienapp.data.local.datalocal.charactersCards
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//FUNCIONAL
//@HiltViewModel
//class MemoryViewModel @Inject constructor() : ViewModel() {
//
//    private val _selectedDifficulty = MutableStateFlow("hobbit")
//    val selectedDifficulty: StateFlow<String> = _selectedDifficulty.asStateFlow()
//
//    private val _cards = MutableStateFlow<List<MemoryCard>>(emptyList())
//    val cards: StateFlow<List<MemoryCard>> = _cards.asStateFlow()
//
//    private var selectedCards = mutableListOf<MemoryCard>()
//    private var isInteractionBlocked = false
//
//    fun setDifficulty(difficulty: String) {
//        _selectedDifficulty.value = difficulty
//        generateCardsForDifficulty(difficulty)
//    }
//
//    private fun generateCardsForDifficulty(difficulty: String) {
//        val totalCards = when (difficulty) {
//            "hobbit" -> 16  // 4x4
//            "elfo" -> 36    // 5x5
//            "maia" -> 64    // 6x6
//            else -> 16
//        }
//        val pairs = totalCards / 2
//        val generated = charactersCards
//            .shuffled()
//            .take(pairs)
//            .flatMap { card ->
//                listOf(
//                    card.copy(id = card.id * 2),
//                    card.copy(id = card.id * 2 + 1)
//                )
//            }
//            .shuffled()
//        _cards.value = generated
//    }
//
//    fun flipCard(cardId: Int) {
//        if (isInteractionBlocked) return
//
//        val updated = _cards.value.map { card ->
//            if (card.id == cardId && !card.isFaceUp && !card.isMatched) {
//                card.copy(isFaceUp = true)
//            } else card
//        }
//        val flippedCard = updated.find { it.id == cardId }
//
//        if (flippedCard != null) {
//            selectedCards.add(flippedCard)
//            _cards.value = updated
//        }
//
//        if (selectedCards.size == 2) {
//            isInteractionBlocked = true
//            viewModelScope.launch {
//                delay(1000)
//                val (first, second) = selectedCards
//                if (first.content == second.content){
//                    _cards.update { list ->
//                        list.map {
//                            if (it.id == first.id || it.id == second.id) {
//                                it.copy(isMatched = true)
//                            } else it
//                        }
//                    }
//                } else {
//                    _cards.update { list ->
//                        list.map {
//                            if (it.id == first.id || it.id == second.id){
//                                it.copy(isFaceUp = false)
//                            } else it
//                        }
//                    }
//                }
//                selectedCards.clear()
//                isInteractionBlocked = false
//            }
//        }
//    }
//}

@HiltViewModel
class MemoryViewModel @Inject constructor() : ViewModel() {

    // Estado para la dificultad seleccionada
    private val _selectedDifficulty = MutableStateFlow("hobbit")
    val selectedDifficulty: StateFlow<String> = _selectedDifficulty.asStateFlow()

    // Estado para las cartas que se muestran en la pantalla
    private val _cards = MutableStateFlow<List<MemoryCard>>(emptyList())
    val cards: StateFlow<List<MemoryCard>> = _cards.asStateFlow()

    // Estado para el efecto de coincidencia (cuando dos cartas coinciden)
    private val _matchEffect = MutableStateFlow<Pair<Int, String>?>(null)
    val matchEffect: StateFlow<Pair<Int, String>?> = _matchEffect.asStateFlow()

    // Lista temporal para las cartas seleccionadas
    private var selectedCards = mutableListOf<MemoryCard>()
    private var isInteractionBlocked = false // Para bloquear interacciones mientras se verifican las cartas

    // Configura la dificultad y genera las cartas
    fun setDifficulty(difficulty: String) {
        _selectedDifficulty.value = difficulty
        generateCardsForDifficulty(difficulty)
    }

    // Genera las cartas en base a la dificultad seleccionada
    private fun generateCardsForDifficulty(difficulty: String) {
        val totalCards = when (difficulty) {
            "hobbit" -> 16  // 4x4
            "elfo" -> 36    // 6x6
            "maia" -> 64    // 8x8
            else -> 16
        }
        val pairs = totalCards / 2
        val generated = charactersCards
            .shuffled()
            .take(pairs)
            .flatMap { card ->
                listOf(
                    card.copy(id = card.id * 2),
                    card.copy(id = card.id * 2 + 1)
                )
            }
            .shuffled()

        _cards.value = generated // Establece las cartas generadas
    }

    // Lógica para voltear una carta
    fun flipCard(cardId: Int) {
        if (isInteractionBlocked) return

        // Actualiza la carta seleccionada
        val updated = _cards.value.map { card ->
            if (card.id == cardId && !card.isFaceUp && !card.isMatched) {
                card.copy(isFaceUp = true)
            } else card
        }
        val flippedCard = updated.find { it.id == cardId }

        if (flippedCard != null) {
            selectedCards.add(flippedCard)
            _cards.value = updated
        }

        // Si se seleccionaron dos cartas, verifica si coinciden
        if (selectedCards.size == 2) {
            isInteractionBlocked = true
            viewModelScope.launch {
                delay(1000) // Espera antes de verificar

                val (first, second) = selectedCards
                if (first.content == second.content) { // Si las cartas coinciden
                    _matchEffect.value = first.id to first.content
                    _cards.update { list ->
                        list.map {
                            if (it.id == first.id || it.id == second.id) {
                                it.copy(isMatched = true) // Marca las cartas como emparejadas
                            } else it
                        }
                    }
                } else { // Si las cartas no coinciden
                    _cards.update { list ->
                        list.map {
                            if (it.id == first.id || it.id == second.id) {
                                it.copy(isFaceUp = false) // Vuelve a poner las cartas boca abajo
                            } else it
                        }
                    }
                }

                selectedCards.clear() // Limpia las cartas seleccionadas
                isInteractionBlocked = false
                _matchEffect.value = null // Restablece el efecto de coincidencia
            }
        }
    }
}
