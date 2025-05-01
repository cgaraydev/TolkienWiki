package com.cgaraydev.tolkienapp.presentation.role

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cgaraydev.tolkienapp.data.models.Option
import com.cgaraydev.tolkienapp.data.models.PlayerState
import com.cgaraydev.tolkienapp.data.models.Scenario
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RoleViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _playerState = MutableStateFlow(PlayerState())
    val playerState: StateFlow<PlayerState> = _playerState.asStateFlow()

    private val _currentScenario = MutableStateFlow<Scenario?>(null)
    val currentScenario: StateFlow<Scenario?> = _currentScenario.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadInitialScenario() {
        _isLoading.value = true

        firestore.collection("scenarios")
            .document("001") // Ahora coincide con tu primer escenario
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    try {
                        val scenario = document.toObject(Scenario::class.java)
                        if (scenario != null) {
                            _currentScenario.value = scenario
                        } else {
                        }
                    } catch (e: Exception) {
                    }
                } else {
                }
                _isLoading.value = false
            }
            .addOnFailureListener { e ->
                _isLoading.value = false
            }
    }


    fun selectOption(option: Option) {
        option.effects?.let { effects ->
            // Aplicar efectos al estado del jugador
            _playerState.update { current ->
                current.copy(
                    health = (current.health + (effects.health ?: 0)).coerceAtLeast(0),
                    strength = (current.strength + (effects.strength ?: 0)).coerceAtLeast(0),
                    stealth = (current.stealth + (effects.stealth ?: 0)).coerceAtLeast(0),
                    morality = (current.morality + (effects.morality ?: 0)).coerceAtLeast(0),
                    items = current.items + (effects.items ?: emptyList()),
                    allies = current.allies + (effects.allies ?: emptyList())
                )
            }
        }

        // Cargar siguiente escenario
        _isLoading.value = true

        firestore.collection("scenarios")
            .document(option.nextScenarioId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    try {
                        val scenario = document.toObject(Scenario::class.java)
                        if (scenario != null) {
                            _currentScenario.value = scenario
                        } else {
                        }
                    } catch (e: Exception) {
                    }
                } else {
                }
                _isLoading.value = false
            }
            .addOnFailureListener { e ->
                _isLoading.value = false
            }
    }
}