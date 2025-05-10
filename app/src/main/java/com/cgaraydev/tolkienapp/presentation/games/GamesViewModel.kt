package com.cgaraydev.tolkienapp.presentation.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.local.datalocal.GameData
import com.cgaraydev.tolkienapp.data.local.datalocal.gameTags
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
): ViewModel() {

    private val _games = MutableStateFlow<List<GameData>>(emptyList())
    val games: StateFlow<List<GameData>> = _games.asStateFlow()

    private val categoryMap = mapOf(
        "Juegos de video" to "videogames",
        "Playstation" to "playstation",
        "Xbox" to "xbox",
        "PC" to "pc",
        "Todos" to "games"
    )

    init {
        loadGames()
    }

    private fun loadGames() {
        viewModelScope.launch {
            _games.value = gameTags
        }
    }

    fun getGamesByTag(displayName: String): List<GameData> {
        val tag = categoryMap[displayName] ?: return emptyList()
        return games.value.filter { it.tags.contains(tag) }
    }


}