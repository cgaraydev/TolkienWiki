package com.cgaraydev.tolkienapp.presentation.memory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.MemoryCard
import com.cgaraydev.tolkienapp.data.local.datalocal.charactersCards
import com.cgaraydev.tolkienapp.utils.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

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

    private var _isInteractionBlocked = MutableStateFlow(false)
    var isInteractionBlocked: StateFlow<Boolean> = _isInteractionBlocked.asStateFlow()

    private val _moveCount = MutableStateFlow(0)
    val moveCount: StateFlow<Int> = _moveCount.asStateFlow()

    private val _elapsedTime = MutableStateFlow(0L) // tiempo en segundos
    val elapsedTime: StateFlow<Long> = _elapsedTime.asStateFlow()

    private val _isGamePaused = MutableStateFlow(false)
    val isGamePaused: StateFlow<Boolean> = _isGamePaused.asStateFlow()

    private val _gameState = MutableStateFlow<GameState>(GameState.PLAYING)
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<String>()
    val uiEvent: SharedFlow<String> = _uiEvent

    private var timerJob: Job? = null

    private var isFirstMove = true


    init {
        viewModelScope.launch {
            delay(1000)
            startTimer()
        }
    }

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

    fun flipCard(cardId: Int) {
        if (_isGamePaused.value || _gameState.value != GameState.PLAYING) return

        val currentCards = _cards.value
        val card = currentCards.find { it.id == cardId } ?: return

        // No permitir interacción si ya está girada, emparejada o está bloqueado
        if (card.isFaceUp || card.isMatched || isInteractionBlocked.value) return

        // Voltear la carta
        _cards.value = currentCards.map {
            if (it.id == cardId) it.copy(isFaceUp = true) else it
        }

        // Obtener cartas volteadas
        val flippedCards = _cards.value.filter { it.isFaceUp && !it.isMatched }

        if (flippedCards.size == 2) {
            _moveCount.value += 1
            _isInteractionBlocked.value = true // 🔒 Bloquear interacción mientras se comparan

            viewModelScope.launch {
                delay(500)
                val (first, second) = flippedCards
                val matched = first.content == second.content
                if (matched) {
                    _matchEffect.value = first.id to first.content
                    _uiEvent.emit("Has encontrado a ${first.content}!")
//                    delay(800) // Tiempo suficiente para mostrar el mensaje
                    _matchEffect.value = null
                    _cards.value = _cards.value.map { card ->
                        if (card.id == first.id || card.id == second.id) {
                            card.copy(isMatched = true)
                        } else {
                            card
                        }
                    }
                    if (_cards.value.all { it.isMatched }) {
                        println("Todas las cartas emparejadas!") // Para confirmar
                        _gameState.value = GameState.FINISHED
                    }
                }
                _cards.value = _cards.value.map {
                    when (it.id) {
                        first.id, second.id -> {
                            if (matched) it.copy(isMatched = true)
                            else it.copy(isFaceUp = false)
                        }

                        else -> it
                    }
                }
                _isInteractionBlocked.value = false // 🔓 Desbloquear después de la comparación
            }
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (true) {
                if (!_isGamePaused.value && _gameState.value == GameState.PLAYING) {
                    _elapsedTime.value += 1
                }
                delay(1000)
            }
        }
    }

    fun togglePause() {
        _isGamePaused.value = !_isGamePaused.value
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }

    fun restartGame() {
        timerJob?.cancel()
        _moveCount.value = 0
        _elapsedTime.value = 0L
        _isGamePaused.value = false
        _gameState.value = GameState.PLAYING
        generateCardsForDifficulty(_selectedDifficulty.value)
        isFirstMove = true

        viewModelScope.launch {
            delay(1000)
            startTimer()
        }
    }
}

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

//    fun flipCard(cardId: Int) {
//        val currentCards = _cards.value
//        val card = currentCards.find { it.id == cardId } ?: return
//
//        if (card.isFaceUp || card.isMatched) return
//
//        // Volteamos la carta inmediatamente para bloquear interacciones rápidas
//        _cards.value = currentCards.map {
//            if (it.id == cardId) it.copy(isFaceUp = true) else it
//        }
//
//        val flippedCards = _cards.value.filter { it.isFaceUp && !it.isMatched }
//
//        if (flippedCards.size == 2) {
//            viewModelScope.launch {
//                delay(1000)
//                val (first, second) = flippedCards
//                val matched = first.content == second.content
//                _matchEffect.value = if (matched) first.id to first.content else null
//
//                _cards.value = _cards.value.map {
//                    when (it.id) {
//                        first.id, second.id -> {
//                            if (matched) it.copy(isMatched = true) else it.copy(isFaceUp = false)
//                        }
//                        else -> it
//                    }
//                }
//
//                _matchEffect.value = null
//            }
//        }
//    }
//
//    fun flipCard(cardId: Int) {
//        if (isInteractionBlocked.value) return
//
//        val card = _cards.value.find { it.id == cardId }
//        if (card == null || card.isFaceUp || card.isMatched) return
//
//        _isInteractionBlocked.value = true // bloqueo inmediato
//
//        val updated = _cards.value.map { c ->
//            if (c.id == cardId) c.copy(isFaceUp = true) else c
//        }
//        _cards.value = updated
//
//        val newlyFlipped = updated.filter { it.isFaceUp && !it.isMatched }
//
//        viewModelScope.launch {
//            if (newlyFlipped.size == 2) {
//                delay(1000)
//                val (first, second) = newlyFlipped
//                if (first.content == second.content) {
//                    _matchEffect.value = first.id to first.content
//                    _cards.value = updated.map {
//                        if (it.id == first.id || it.id == second.id) {
//                            it.copy(isMatched = true)
//                        } else it
//                    }
//                } else {
//                    _cards.value = updated.map {
//                        if (it.id == first.id || it.id == second.id) {
//                            it.copy(isFaceUp = false)
//                        } else it
//                    }
//                }
//                _matchEffect.value = null
//                _isInteractionBlocked.value = false
//            } else {
//                delay(400) // Delay breve tras voltear una sola carta
//                _isInteractionBlocked.value = false
//            }
//        }
//    }


//    fun flipCard(cardId: Int) {
//        if (isInteractionBlocked.value) return
//
//        val card = _cards.value.find { it.id == cardId }
//        if (card == null || card.isFaceUp || card.isMatched) return
//
//        _isInteractionBlocked.value = true
//
//        val updated = _cards.value.map { c ->
//            if (c.id == cardId) c.copy(isFaceUp = true) else c
//        }
//        _cards.value = updated
//
//        val newlyFlipped = updated.filter { it.isFaceUp && !it.isMatched }
//        if (newlyFlipped.size == 2) {
//            viewModelScope.launch {
//                delay(1000)
//
//                val (first, second) = newlyFlipped
//                if (first.content == second.content) {
//                    _matchEffect.value = first.id to first.content
//                    _cards.value = updated.map {
//                        if (it.id == first.id || it.id == second.id) {
//                            it.copy(isMatched = true)
//                        } else it
//                    }
//                } else {
//                    _cards.value = updated.map {
//                        if (it.id == first.id || it.id == second.id) {
//                            it.copy(isFaceUp = false)
//                        } else it
//                    }
//                }
//                _isInteractionBlocked.value = false
//                _matchEffect.value = null
//            }
//        } else {
//            _isInteractionBlocked.value = false
//        }
//    }

// Lógica para voltear una carta
//    fun flipCard(cardId: Int) {
//        if (isInteractionBlocked.value) return
//
//        // Actualiza la carta seleccionada
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
//        // Si se seleccionaron dos cartas, verifica si coinciden
//        if (selectedCards.size == 2) {
//            _isInteractionBlocked.value = true
//            viewModelScope.launch {
//                delay(1000) // Espera antes de verificar
//
//                val (first, second) = selectedCards
//                if (first.content == second.content) { // Si las cartas coinciden
//                    _matchEffect.value = first.id to first.content
//                    _cards.update { list ->
//                        list.map {
//                            if (it.id == first.id || it.id == second.id) {
//                                it.copy(isMatched = true) // Marca las cartas como emparejadas
//                            } else it
//                        }
//                    }
//                } else { // Si las cartas no coinciden
//                    _cards.update { list ->
//                        list.map {
//                            if (it.id == first.id || it.id == second.id) {
//                                it.copy(isFaceUp = false) // Vuelve a poner las cartas boca abajo
//                            } else it
//                        }
//                    }
//                }
//
//                selectedCards.clear() // Limpia las cartas seleccionadas
//                _isInteractionBlocked.value = false
//                _matchEffect.value = null // Restablece el efecto de coincidencia
//            }
//        }
//    }
//}
