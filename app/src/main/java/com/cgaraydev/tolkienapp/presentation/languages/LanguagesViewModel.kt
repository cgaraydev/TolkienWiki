package com.cgaraydev.tolkienapp.presentation.languages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.models.Language
import com.cgaraydev.tolkienapp.data.local.datalocal.LanguageData
import com.cgaraydev.tolkienapp.data.local.datalocal.languagesTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguagesViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _languages = MutableStateFlow<List<LanguageData>>(emptyList())
    val languages: StateFlow<List<LanguageData>> = _languages.asStateFlow()

    private val _languageDetails = MutableStateFlow<Language?>(null)
    val languageDetails: StateFlow<Language?> = _languageDetails.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()

    private val categoryTagMap = mapOf(
        "Lenguas Humanas" to "mannish_languages",
        "Lenguas Enanas" to "dwarvish_languages",
        "Lenguas Elficas" to "elvish_languages",
        "Escritura" to "writing_systems",
        "Todos" to "languages"
    )

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            _languages.value = languagesTags
        }
    }

    fun getLanguagesByTag(displayName: String): List<LanguageData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return languages.value
            .filter { it.tags?.contains(tag) ?: false }
            .sortedBy { it.name }
    }

    fun loadLanguageDetails(languageId: String) {
        _isLoadingDetails.value = true
        _errorDetails.value = null

        firestore.collection("languages")
            .document(languageId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    _languageDetails.value =
                        document.toObject(Language::class.java)?.copy(id = languageId)
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