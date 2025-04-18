package com.cgaraydev.tolkienapp.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.models.Character
import com.cgaraydev.tolkienapp.data.local.datalocal.CharacterData
import com.cgaraydev.tolkienapp.data.local.datalocal.charactersTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterData>>(emptyList())
    val characters: StateFlow<List<CharacterData>> = _characters.asStateFlow()

    private val _characterDetails = MutableStateFlow<Character?>(null)
    val characterDetails: StateFlow<Character?> = _characterDetails.asStateFlow()

    private val _isLoadingDetails = MutableStateFlow(false)
    val isLoadingDetails: StateFlow<Boolean> = _isLoadingDetails.asStateFlow()

    private val _errorDetails = MutableStateFlow<String?>(null)
    val errorDetails: StateFlow<String?> = _errorDetails.asStateFlow()

    private val categoryTagMap = mapOf(
        //Races
        "Aguilas" to "eagles",
        "Ainur" to "ainur",
        "Arañas" to "spiders",
        "Balrogs" to "balrogs",
        "Cuervos" to "ravens",
        "Dragones" to "dragons",
        "Elfos" to "elves",
        "Enanos" to "dwarves",
        "Ents" to "ents",
        "Hobbits" to "hobbits",
        "Hombres" to "men",
        "Orcos" to "orcs",
        //Ages
        "Primera Edad" to "first_age",
        "Segunda Edad" to "second_age",
        "Tercera Edad" to "third_age",
        "Cuarta Edad" to "fourth_age",
        //Books
        "El Hobbit" to "the_hobbit",
        "El Señor de los Anillos" to "lord_of_the_rings",
        "El Silmarillion" to "silmarillion",
        "El Libro de los Cuentos Perdidos" to "book_of_lost_tales",
        "Los Hijos de Hurin" to "children_of_hurin",
        //Others
        "La Comunidad del Anillo" to "fellowship_of_the_ring",
        "Compañía de Thorin" to "thorin_company",
        "Edain" to "edain",
        "Noldor" to "noldor",
        "Istari" to "istari"
    )

    val categories = mapOf(
        "Razas" to listOf(
            "Aguilas",
            "Ainur",
            "Arañas",
            "Balrogs",
            "Cuervos",
            "Dragones",
            "Elfos",
            "Enanos",
            "Ents",
            "Hobbits",
            "Hombres",
            "Orcos"
        ),
        "Edades" to listOf(
            "Primera Edad",
            "Segunda Edad",
            "Tercera Edad",
            "Cuarta Edad"
        ),
        "Libros" to listOf(
            "El Hobbit",
            "El Señor de los Anillos",
            "El Silmarillion",
            "El Libro de los Cuentos Perdidos",
            "Los Hijos de Hurin"
        ),
        "Otros" to listOf(
            "La Comunidad del Anillo",
            "Compañía de Thorin",
            "Edain",
            "Noldor",
            "Istari"
        )
    )

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            _characters.value = charactersTags
        }
    }

    fun getCharactersByTag(displayName: String): List<CharacterData> {
        val tag = categoryTagMap[displayName] ?: return emptyList()
        return characters.value
            .filter { it.tags?.contains(tag) ?: false }
            .sortedBy { it.name }
    }

    fun loadCharacterDetails(characterId: String) {
        _isLoadingDetails.value = true
        _errorDetails.value = null

        firestore.collection("characters")
            .document(characterId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    _characterDetails.value =
                        document.toObject(Character::class.java)?.copy(id = characterId)
                } else {
                    _errorDetails.value = "Character not found"
                }
                _isLoadingDetails.value = false
            }
            .addOnFailureListener { exception ->
                _errorDetails.value = "Error loading character details: ${exception.message}"
                _isLoadingDetails.value = false
            }
    }
}


