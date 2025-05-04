package com.cgaraydev.tolkienapp.utils

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.cgaraydev.tolkienapp.presentation.home.HomeViewModel
import com.cgaraydev.tolkienapp.presentation.music.MusicViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val player: ExoPlayer = ExoPlayer.Builder(context).build()
    private val playlist = mutableListOf<String>()
    private var currentVolume by mutableFloatStateOf(0.5f) // Volumen actual (0-1)
    private var currentIndex = -1
    var isMuted = false
    var isPlaying = false

    init {
        player.volume = 0f
        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                if (state == Player.STATE_ENDED) {
                    playRandom()
                } else if (state == Player.STATE_READY) {
                    player.volume = if (isMuted) 0f else currentVolume
                }
            }
        })
    }

    fun setPlaylist(urls: List<String>) {
        playlist.clear()
        playlist.addAll(urls)
        currentIndex = -1
    }

    fun playRandom() {
        if (playlist.isEmpty()) return

        val nextIndex = (playlist.indices - currentIndex).randomOrNull() ?: return
        currentIndex = nextIndex

        val mediaItem = MediaItem.fromUri(playlist[nextIndex])
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = !isMuted
        isPlaying = true
    }

    fun setVolume(volume: Float) {
        currentVolume = volume.coerceIn(0f, 1f)
        if (!isMuted) {
            player.volume = currentVolume
        }
    }

    fun togglePlayPause() {
        if (isPlaying) {
            player.pause()
        } else {
            player.play()
        }
        isPlaying = !isPlaying
    }

    fun toggleMute() {
        isMuted = !isMuted
        player.volume = if (isMuted) 0f else currentVolume
        if (!isMuted && isPlaying) player.play()
    }

    fun skipToNext() {
        playRandom()
    }

    fun release() {
        player.release()
    }

    fun pause() {
        player.pause()
        isPlaying = false
    }

}

class AudioLifecycleObserver(
    private val viewModel: MusicViewModel
) : DefaultLifecycleObserver {

    override fun onStop(owner: LifecycleOwner) {
        viewModel.pauseAudio() // Solo pausar cuando la app pierde el foco
    }
}