package com.cgaraydev.tolkienapp.presentation.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.models.Event
import com.cgaraydev.tolkienapp.data.local.datalocal.EventData
import com.cgaraydev.tolkienapp.data.local.datalocal.eventsTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _events = MutableStateFlow<List<EventData>>(emptyList())
    val events: StateFlow<List<EventData>> = _events.asStateFlow()

    private val _eventDetails = MutableStateFlow<Event?>(null)
    val eventDetails: StateFlow<Event?> = _eventDetails.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()

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
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            _events.value = eventsTags
        }
    }

    fun getEventsByTag(displayName: String): List<EventData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return events.value
            .filter { it.tags?.contains(tag) ?: false }
            .sortedBy { it.name }
    }

    fun loadEventDetails(eventId: String) {
        _isLoadingDetails.value = true
        _errorDetails.value = null

        firestore.collection("events")
            .document(eventId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    _eventDetails.value =
                        document.toObject(Event::class.java)?.copy(id = eventId)
                } else {
                    _errorDetails.value = "Event not found"
                }
                _isLoadingDetails.value = false
            }
            .addOnFailureListener { exception ->
                _errorDetails.value = "Error loading event details: ${exception.message}"
                _isLoadingDetails.value = false
            }
    }


}