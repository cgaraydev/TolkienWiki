package com.cgaraydev.tolkienapp.presentation.memory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.MemoryCard
import com.cgaraydev.tolkienapp.data.local.datalocal.charactersCards
import com.cgaraydev.tolkienapp.data.models.Record
import com.cgaraydev.tolkienapp.utils.BestTimesManager
import com.cgaraydev.tolkienapp.utils.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoryViewModel @Inject constructor(
    private val bestTimesManager: BestTimesManager
) : ViewModel() {

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

    val shouldDimBackground: StateFlow<Boolean> =
        combine(isGamePaused, gameState) { paused, state ->
            paused || state is GameState.FINISHED
        }.stateIn(viewModelScope, SharingStarted.Lazily, false)


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

    fun getGridColumns(): Int = when(selectedDifficulty.value) {
        "hobbit" -> 4
        "elfo" -> 6
        "ainur" -> 8
        else -> 4
    }

    // Genera las cartas en base a la dificultad seleccionada
    private fun generateCardsForDifficulty(difficulty: String) {
        val totalCards = when (difficulty) {
            "hobbit" -> 16  // 4x4
            "elfo" -> 36    // 6x6
            "ainur" -> 64    // 8x8
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

    fun saveBestTimeIfNeeded() {
        if (_gameState.value == GameState.FINISHED) {
            viewModelScope.launch {
                bestTimesManager.saveTime(
                    _selectedDifficulty.value,
                    _elapsedTime.value,
                    _moveCount.value
                )
            }
        }
    }

    //    fun getBestTimes(difficulty: String): Flow<List<Long>> {
//        return bestTimesManager.getTimes(difficulty)
//    }
    fun getBestTimes(difficulty: String): Flow<List<Record>> {
        return bestTimesManager.getTimes(difficulty)
    }

    fun clearBestTimes(difficulty: String) {
        viewModelScope.launch {
            bestTimesManager.clearTimes(difficulty)
        }
    }


}