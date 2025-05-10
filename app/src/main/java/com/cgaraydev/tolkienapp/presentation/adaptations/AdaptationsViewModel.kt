package com.cgaraydev.tolkienapp.presentation.adaptations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.AdaptationData
import com.cgaraydev.tolkienapp.data.local.datalocal.adaptationTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdaptationsViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _adaptations = MutableStateFlow<List<AdaptationData>>(emptyList())
    val adaptations: StateFlow<List<AdaptationData>> = _adaptations.asStateFlow()

    private val categoryMap = mapOf(
        "El Señor de los Anillos" to "the_lord_of_the_rings_film_series",
        "El Hobbit" to "the_hobbit_film_series",
        "Animadas" to "animated",
        "Fan Films" to "fan_film",
        "Series de TV" to "tv_series",
        "Todos" to "adaptations"
    )

    init {
        loadAdaptations()
    }

    private fun loadAdaptations() {
        viewModelScope.launch {
            _adaptations.value = adaptationTags
        }
    }

    fun getAdaptationsByTags(displayName: String): List<AdaptationData> {
        val tag = categoryMap[displayName] ?: return emptyList()
        return adaptations.value.filter { it.tags.contains(tag) }
    }

}