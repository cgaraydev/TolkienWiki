package com.cgaraydev.tolkienapp.presentation.others

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.models.Other
import com.cgaraydev.tolkienapp.data.local.datalocal.OtherData
import com.cgaraydev.tolkienapp.data.local.datalocal.othersTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OthersViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _others = MutableStateFlow<List<OtherData>>(emptyList())
    val others: StateFlow<List<OtherData>> = _others.asStateFlow()

    private val _otherDetails = MutableStateFlow<Other?>(null)
    val otherDetails: StateFlow<Other?> = _otherDetails.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()

    private val categoryTagMap = mapOf(
        "Armas" to "weapons",
        "Plantas" to "plants",
        "Navíos" to "ships",
        "Artefactos" to "objects",
        "Gente" to "people",
        "Casas Nobles" to "noble_houses",
        "Periodos" to "years",
        "Todos" to "others"
    )

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            _others.value = othersTags
        }
    }

    fun getOthersByTag(displayName: String): List<OtherData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return others.value
            .filter { it.tags?.contains(tag) ?: false }
            .sortedBy { it.name }
    }

    fun loadOtherDetails(otherId: String) {
        _isLoadingDetails.value = true
        _errorDetails.value = null

        firestore.collection("others")
            .document(otherId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    _otherDetails.value =
                        document.toObject(Other::class.java)?.copy(id = otherId)
                } else {
                    _errorDetails.value = "Page not found"
                }
                _isLoadingDetails.value = false
            }
            .addOnFailureListener { exception ->
                _errorDetails.value = "Error loading page details: ${exception.message}"
                _isLoadingDetails.value = false
            }
    }
}