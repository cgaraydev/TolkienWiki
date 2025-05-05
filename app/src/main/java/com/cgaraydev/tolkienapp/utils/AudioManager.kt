package com.cgaraydev.tolkienapp.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.Song
import com.cgaraydev.tolkienapp.presentation.music.MusicViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val player: ExoPlayer = ExoPlayer.Builder(context).build()
    private val playlist = mutableListOf<Song>()
    private var currentVolume by mutableFloatStateOf(0.5f) // Volumen actual (0-1)
    private var currentIndex = -1
    var isMuted = false
    var isPlaying = false
    private val _currentSong = MutableStateFlow<Song?>(null)
    val currentSong: StateFlow<Song?> = _currentSong.asStateFlow()

    init {
        player.volume = 0f
        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_ENDED -> playRandom()
                    Player.STATE_READY -> {
                        player.volume = if (isMuted) 0f else currentVolume
                        // Mostrar Toast SOLO aquí (punto centralizado)
                        _currentSong.value?.let { showSongToast(it) }
                    }
                }
            }
        })
    }


//    private fun showSongToast(song: Song) {
//        Toast.makeText(
//            context,
//            "🎵 ${song.title} - ${song.author}",
//            Toast.LENGTH_SHORT
//        ).apply {
//            setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
//            show()
//        }
//    }

//    private fun showSongToast(song: Song) {
//        val handler = Handler(Looper.getMainLooper())
//        handler.post {
//            val toast = Toast.makeText(context, "", Toast.LENGTH_SHORT).apply {
//                setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
//
//                // Configuración del layout personalizado
//                val customView = LayoutInflater.from(context).inflate(R.layout.custom_toast, null).apply {
//                    findViewById<TextView>(R.id.toast_text).text = "${song.title} • ${song.author}"
//                    findViewById<ImageView>(R.id.toast_icon).setImageResource(R.drawable.ic_music)
//
//                    // Fuente personalizada
//                    val textView = findViewById<TextView>(R.id.toast_text)
//                    try {
//                        textView.typeface = ResourcesCompat.getFont(context, R.font.cardo)
//                    } catch (e: Exception) {
//                        Log.e("AudioManager", "Error al cargar fuente", e)
//                    }
//                }
//
//                // Alternativa moderna (requiere API 30+):
//                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                     this.setView(customView)
//                 } else {
//                     this.view = customView
//                 }
//            }
//            toast.show()
//        }
//    }

    @SuppressLint("InflateParams")
    private fun showSongToast(song: Song) {
        Handler(Looper.getMainLooper()).post {
            // 1. Inflar el layout personalizado
            val toastView = LayoutInflater.from(context).inflate(
                R.layout.custom_toast,
                null
            ).apply {
                findViewById<TextView>(R.id.toast_text).apply {
                    text = "${song.title} • ${song.author}"
                    typeface = ResourcesCompat.getFont(context, R.font.cardo)
                }
                findViewById<ImageView>(R.id.toast_icon).setImageResource(R.drawable.ic_music)
            }

            // 2. Crear el Toast de forma moderna
            Toast(context).apply {
                duration = Toast.LENGTH_SHORT
                setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)

                // Alternativa no-deprecada para API < 30
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    setView(toastView) // Método moderno (API 30+)
                } else {
                    @Suppress("DEPRECATION")
                    view = toastView // Solo para versiones antiguas
                }

                show()
            }
        }
    }


//    @SuppressLint("InflateParams", "SetTextI18n")
//    private fun showSongToast(song: Song) {
//        Handler(Looper.getMainLooper()).post {
//            val inflater = LayoutInflater.from(context)
//            val toastLayout = inflater.inflate(R.layout.custom_toast, null) as LinearLayout
//
//            toastLayout.findViewById<TextView>(R.id.toast_text).apply {
//                text = "${song.title} • ${song.author}"
//                typeface = ResourcesCompat.getFont(context, R.font.cardo)
//            }
//
//            toastLayout.findViewById<ImageView>(R.id.toast_icon).setImageResource(R.drawable.ic_music)
//
//            Toast(context).apply {
//                duration = Toast.LENGTH_SHORT
//                setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
//                view = toastLayout // <-- Funciona aunque esté deprecado
//                show()
//            }
//        }
//    }

    fun setPlaylist(songs: List<Song>) {
        playlist.clear()
        playlist.addAll(songs)
        currentIndex = -1
    }

    fun playRandom() {
        if (playlist.isEmpty()) return

        val nextIndex = (playlist.indices - currentIndex).randomOrNull() ?: return
        currentIndex = nextIndex
        _currentSong.value = playlist[nextIndex]  // Actualizar el StateFlow

        val mediaItem = MediaItem.fromUri(playlist[nextIndex].url)
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

