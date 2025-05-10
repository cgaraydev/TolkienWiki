package com.cgaraydev.tolkienapp.presentation.events

import androidx.lifecycle.ViewModel
import com.cgaraydev.tolkienapp.data.local.datalocal.EventData
import com.cgaraydev.tolkienapp.data.local.datalocal.eventsTags
import com.cgaraydev.tolkienapp.data.models.Event
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _events = MutableStateFlow<List<EventData>>(emptyList())
    val events: StateFlow<List<EventData>> = _events.asStateFlow()

    private val _eventDetails = MutableStateFlow<Event?>(null)
    val eventDetails: StateFlow<Event?> = _eventDetails.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val categoryTagMap = mapOf(
        "Batallas" to "battles",
        "Guerras" to "wars_and_conflicts",
        "Asedios" to "sieges",
        "Primera Edad" to "first_age_conflicts",
        "Segunda Edad" to "second_age_conflicts",
        "Tercera Edad" to "third_age_conflicts",
        "Guerra de las Joyas" to "war_of_the_jewels_conflicts",
        "Guerra del Anillo" to "war_of_the_ring_conflicts",
        "Todos" to "events"
    )

    init {
        loadEvents()
    }

    private fun loadEvents() {
        _events.value = eventsTags // Datos locales
    }

    fun getEventsByTag(displayName: String): List<EventData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return events.value.filter { it.tags?.contains(tag) ?: false }
    }

    fun loadEventDetails(eventId: String) {
        _isLoading.value = true
        _error.value = null

        firestore.collection("events").document(eventId).get()
            .addOnSuccessListener { doc ->
                _eventDetails.value = doc.toObject(Event::class.java)?.copy(id = eventId)
                _isLoading.value = false
            }
            .addOnFailureListener { e ->
                _error.value = e.message ?: "Error al cargar detalles"
                _isLoading.value = false
            }
    }
}