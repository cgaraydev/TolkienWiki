package com.cgaraydev.tolkienapp.presentation.music

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.models.Song
import com.cgaraydev.tolkienapp.utils.AudioManager
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val audioManager: AudioManager,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _isMuted = MutableStateFlow(false)
    val isMuted: StateFlow<Boolean> = _isMuted.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _currentVolume = MutableStateFlow(0.5f)
    val currentVolume: StateFlow<Float> = _currentVolume.asStateFlow()


    init {
        viewModelScope.launch {
            loadTracks()
        }
    }

    private suspend fun loadTracks() {
        try {
            val songs = firestore.collection("songs")
                .get()
                .await()
                .map { it.toObject(Song::class.java) }
            audioManager.setPlaylist(songs)
            audioManager.playRandom()
            _isPlaying.value = audioManager.isPlaying
        } catch (e: Exception) {
            Log.e("MusicViewModel", "Error al cargar canciones", e)
        }
    }

    fun setVolume(volume: Float) {
        audioManager.setVolume(volume)
        _currentVolume.value = volume
    }

    fun togglePlayPause() {
        audioManager.togglePlayPause()
        _isPlaying.value = audioManager.isPlaying
    }

    fun nextTrack() {
        audioManager.skipToNext()
    }

    override fun onCleared() {
        audioManager.release()
        super.onCleared()
    }

    fun pauseAudio() {
        audioManager.pause()
        _isPlaying.value = false
    }

}