package com.cgaraydev.tolkienapp.presentation.music

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.utils.AudioManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val audioManager: AudioManager
) : ViewModel() {

    private val _isMuted = MutableStateFlow(false)
    val isMuted: StateFlow<Boolean> = _isMuted.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _currentVolume = MutableStateFlow(0.5f)
    val currentVolume: StateFlow<Float> = _currentVolume.asStateFlow()

    init {
        val urls = listOf(
            "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/music.mp3?alt=media&token=ab4981c2-6696-40cb-9bad-bbf18196af6b",
            "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/music_2.mp3?alt=media&token=5e3b6f81-6eea-42bd-b95f-5966c127f220",
            "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/music_3.mp3?alt=media&token=f91c19a3-6031-45d8-947a-f1fe08cec454"
        )
        audioManager.setPlaylist(urls)
        _isMuted.value = audioManager.isMuted
        _isPlaying.value = audioManager.isPlaying

        viewModelScope.launch {
            delay(2000)
            audioManager.playRandom()
            _isPlaying.value = audioManager.isPlaying // Actualizar estado después de comenzar
        }
    }

    fun setVolume(volume: Float) {
        audioManager.setVolume(volume)
        _currentVolume.value = volume
    }

    fun toggleMute() {
        audioManager.toggleMute()
        _isMuted.value = audioManager.isMuted
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