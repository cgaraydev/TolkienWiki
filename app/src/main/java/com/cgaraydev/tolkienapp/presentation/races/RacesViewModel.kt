package com.cgaraydev.tolkienapp.presentation.races

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.cgaraydev.tolkienapp.data.local.datalocal.EventData
import com.cgaraydev.tolkienapp.data.local.datalocal.RaceData
import com.cgaraydev.tolkienapp.data.models.Race
import com.cgaraydev.tolkienapp.data.local.datalocal.racesList
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RacesViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _racesLocal = mutableStateOf(racesList)
    val racesLocal: State<List<RaceData>> = _racesLocal

    private val _raceDetails = MutableStateFlow<Race?>(null)
    val raceDetails: StateFlow<Race?> = _raceDetails.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()


    fun loadRaceDetails(raceId: String) {
        _isLoadingDetails.value = true
        _errorDetails.value = null

        firestore.collection("races")
            .document(raceId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    _raceDetails.value =
                        document.toObject(Race::class.java)?.copy(id = raceId)
                } else {
                    _errorDetails.value = "Race not found"
                }
                _isLoadingDetails.value = false
            }
            .addOnFailureListener { exception ->
                _errorDetails.value = "Error loading race details: ${exception.message}"
                _isLoadingDetails.value = false
            }
    }

}