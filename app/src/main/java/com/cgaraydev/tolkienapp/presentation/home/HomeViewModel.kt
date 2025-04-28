package com.cgaraydev.tolkienapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.CharacterData
import com.cgaraydev.tolkienapp.data.local.datalocal.EventData
import com.cgaraydev.tolkienapp.data.local.datalocal.LanguageData
import com.cgaraydev.tolkienapp.data.local.datalocal.LocationData
import com.cgaraydev.tolkienapp.data.local.datalocal.OtherData
import com.cgaraydev.tolkienapp.data.local.datalocal.RaceData
import com.cgaraydev.tolkienapp.presentation.characters.CharactersViewModel
import com.cgaraydev.tolkienapp.presentation.events.EventsViewModel
import com.cgaraydev.tolkienapp.presentation.languages.LanguagesViewModel
import com.cgaraydev.tolkienapp.presentation.locations.LocationsViewModel
import com.cgaraydev.tolkienapp.presentation.others.OthersViewModel
import com.cgaraydev.tolkienapp.presentation.races.RacesViewModel
import com.cgaraydev.tolkienapp.utils.SearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val charactersViewModel: CharactersViewModel,
    private val locationsViewModel: LocationsViewModel,
    private val racesViewModel: RacesViewModel,
    private val eventsViewModel: EventsViewModel,
    private val languagesViewModel: LanguagesViewModel,
    private val othersViewModel: OthersViewModel
) : ViewModel() {

    // Resultados de búsqueda unificados
    private val _searchResults = MutableStateFlow<List<SearchResult>>(emptyList())
    val searchResults: StateFlow<List<SearchResult>> = _searchResults.asStateFlow()

    // Estado de carga
    private val _isSearching = MutableStateFlow(false)
    val isSearching: StateFlow<Boolean> = _isSearching.asStateFlow()

    // Modelo para resultados unificados

    private fun calculateRelevanceScore(item: Any, query: String): Int {
        val queryParts = query.lowercase().split(" ").filter { it.isNotBlank() }
        if (queryParts.isEmpty()) return 0

        return when (item) {
            is CharacterData -> calculateScoreForItem(item.name, item.tags, queryParts)
            is LocationData -> calculateScoreForItem(item.name, item.tags, queryParts)
            is RaceData -> calculateScoreForItem(item.name, item.tags, queryParts)
            is EventData -> calculateScoreForItem(item.name, item.tags, queryParts)
            is LanguageData -> calculateScoreForItem(item.name, item.tags, queryParts)
            is OtherData -> calculateScoreForItem(item.name, item.tags, queryParts)
            else -> 0
        }
    }

    private fun calculateScoreForItem(
        name: String,
        tags: List<String>?,
        queryParts: List<String>
    ): Int {
        var totalScore = 0
        val lowerName = name.lowercase()
        val lowerTags = tags?.map { it.lowercase() } ?: emptyList()

        queryParts.forEach { term ->
            // Puntuación por nombre
            when {
                lowerName == term -> totalScore += 1000
                lowerName.startsWith(term) -> totalScore += 500
                lowerName.contains(term) -> totalScore += 200
            }

            // Puntuación por tags
            lowerTags.forEach { tag ->
                when {
                    tag == term -> totalScore += 300
                    tag.startsWith(term) -> totalScore += 150
                    tag.contains(term) -> totalScore += 50
                }
            }
        }

        return totalScore
    }

    fun searchAllCollections(query: String) {
        _isSearching.value = true

        if (query.isBlank()) {
            _searchResults.value = emptyList()
            _isSearching.value = false
            return
        }

        val normalizedQuery = query.lowercase().trim()

        viewModelScope.launch {
            val results = mutableListOf<Pair<SearchResult, Int>>()

            // Buscar en personajes
            charactersViewModel.characters.value.forEach { character ->
                val score = calculateRelevanceScore(character, normalizedQuery)
                if (score > 0) {
                    results.add(SearchResult.CharacterResult(character) to score)
                }
            }

            // Buscar en ubicaciones (similar)
            locationsViewModel.locations.value.forEach { location ->
                val score = calculateRelevanceScore(location, normalizedQuery)
                if (score > 0) {
                    results.add(SearchResult.LocationResult(location) to score)
                }
            }

            //Buscar en razas (similar)
            racesViewModel.racesLocal.value.forEach { race ->
                val score = calculateRelevanceScore(race, normalizedQuery)
                if (score > 0) {
                    results.add(SearchResult.RaceResult(race) to score)
                }
            }
            // Buscar en eventos (similar)
            eventsViewModel.events.value.forEach { event ->
                val score = calculateRelevanceScore(event, normalizedQuery)
                if (score > 0) {
                    results.add(SearchResult.EventResult(event) to score)
                }
            }
            // Buscar en lenguajes (similar)
            languagesViewModel.languages.value.forEach { language ->
                val score = calculateRelevanceScore(language, normalizedQuery)
                if (score > 0) {
                    results.add(SearchResult.LanguageResult(language) to score)
                }
            }
            // Buscar en otros (similar)
            othersViewModel.others.value.forEach { other ->
                val score = calculateRelevanceScore(other, normalizedQuery)
                if (score > 0) {
                    results.add(SearchResult.OtherResult(other) to score)
                }
            }

            // Ordenar por puntuación descendente y luego por nombre
            _searchResults.value = results
                .sortedWith(compareByDescending<Pair<SearchResult, Int>> { it.second }
                    .thenBy { it.first.name })
                .map { it.first }

            _isSearching.value = false
        }
    }

    fun clearSearch() {
        _searchResults.value = emptyList()
    }
}