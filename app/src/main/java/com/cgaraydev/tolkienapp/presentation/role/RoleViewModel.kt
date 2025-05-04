package com.cgaraydev.tolkienapp.presentation.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.models.Option
import com.cgaraydev.tolkienapp.data.models.PlayerState
import com.cgaraydev.tolkienapp.data.models.Scenario
import com.cgaraydev.tolkienapp.utils.AudioManager
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoleViewModel @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val audioManager: AudioManager
) : ViewModel() {

    private val _playerState = MutableStateFlow(PlayerState())
    val playerState: StateFlow<PlayerState> = _playerState.asStateFlow()

    private val _currentScenario = MutableStateFlow<Scenario?>(null)
    val currentScenario: StateFlow<Scenario?> = _currentScenario.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _scenarioText = MutableStateFlow("")
    val scenarioText: StateFlow<String> = _scenarioText.asStateFlow()

    private val _showContinueButton = MutableStateFlow(false)
    val showContinueButton: StateFlow<Boolean> = _showContinueButton.asStateFlow()

    private var _currentDecision: Option? = null

    val isMuted: Boolean
        get() = audioManager.isMuted

    fun toggleMute() {
        audioManager.toggleMute()
    }

    init {
        loadInitialScenario()
    }

    private fun loadInitialScenario() {
        _showContinueButton.value = false
        _isLoading.value = true

        loadScenario("001")
    }

    private fun loadScenario(scenarioId: String) {
                firestore.collection("scenarios")
            .document(scenarioId) // Ahora coincide con tu primer escenario
            .get()
            .addOnSuccessListener { document ->
                _isLoading.value = false
                if (document.exists()) {
                    try {
                        val scenario = document.toObject(Scenario::class.java)
                        _currentScenario.value = scenario
                        _scenarioText.value = scenario?.text ?: ""
                    } catch (e: Exception) {
                        // Manejar error
                    }
                }
            }
            .addOnFailureListener { _ ->
                _isLoading.value = false
            }
    }

    fun selectOption(option: Option) {
        viewModelScope.launch {

            applyOptionEffects(option)

            val resultText = buildString {
                option.result?.let { append(it) }
                option.effectsSummary?.let {
                    if (isNotEmpty()) append("\n\n")
                    append(it)
                }
            }

            if (resultText.isNotEmpty()) {
                _scenarioText.value = resultText
                _currentDecision = option
                _showContinueButton.value = true
            } else {
                _isLoading.value = true
                loadScenario(option.nextScenarioId)
            }
        }
    }

    private fun applyOptionEffects(option: Option) {
        option.effects?.let { effects ->
            _playerState.update { current ->
                current.copy(
                    health = (current.health + (effects.health ?: 0)).coerceIn(0, 100),
                    strength = (current.strength + (effects.strength ?: 0)).coerceIn(1,10),
                    defense = (current.defense + (effects.defense ?: 0)).coerceIn(1,10),
                    agility = (current.agility + (effects.agility ?: 0)).coerceIn(1,10),
                    wisdom = (current.wisdom + (effects.wisdom ?: 0)).coerceIn(1,10),
                    luck = (current.luck + (effects.luck ?: 0)).coerceIn(1,10),
                    items = current.items + (effects.items ?: emptyList()),
                    allies = current.allies + (effects.allies ?: emptyList())
                )
            }
        }
    }

    fun continueToNextScenario() {
        _currentDecision?.let { decision ->
            _showContinueButton.value = false
            _isLoading.value = true
            loadScenario(decision.nextScenarioId)
            _currentDecision = null
        }
    }
}