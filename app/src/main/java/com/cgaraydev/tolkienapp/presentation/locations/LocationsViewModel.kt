package com.cgaraydev.tolkienapp.presentation.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.LocationData
import com.cgaraydev.tolkienapp.data.locationsTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _locations = MutableStateFlow<List<LocationData>>(emptyList())
    val locations: StateFlow<List<LocationData>> = _locations.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()

    private val categoryTagMap = mapOf(
        "Ciudades" to "cities",
        "Ríos" to "river",
        "Montañas" to "mountains",
        "Bosques" to "forests",
        "Valles" to "valley",
        "Fortalezas" to "fortresses",
        "Regiones" to "regions",
        "Continentes" to "continents",
        "Todas" to "locations"

    )


    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            _locations.value = locationsTags
        }
    }

    fun getLocationsByTag(displayName: String): List<LocationData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return locations.value
            .filter { it.tags?.contains(tag) ?: false }
            .sortedBy { it.name }
    }
}