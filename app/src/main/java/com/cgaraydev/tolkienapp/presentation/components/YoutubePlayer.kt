package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.tolkien.YouTubeMediaItem
import com.cgaraydev.tolkienapp.presentation.tolkien.tolkienVideos
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.utils.YouTubeThumbnail
import com.cgaraydev.tolkienapp.utils.extractYouTubeId
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YouTubeMediaSection() {
    var expanded by remember { mutableStateOf(false) }
    val videos = tolkienVideos
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .padding(bottom = 20.dp)
        ) {
            Text(
                text = "Media",
                color = Golden,
                fontSize = 24.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) "Mostrar menos" else "Mostrar más",
                tint = Golden
            )
        }
        if (expanded) {
            Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                videos.forEach { video ->
                    YouTubeMediaItem(
                        video = video,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun YouTubeMediaItem(
    video: YouTubeMediaItem,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = video.title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(bottom = 8.dp, top = 16.dp)
                .fillMaxWidth()
        )
        YouTubeCardEmbedded(video)
    }
}

@Composable
fun YouTubeCardEmbedded(video: YouTubeMediaItem) {
    var isPlaying by remember { mutableStateOf(false) }
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        if (isPlaying) {
            // Modo reproductor activo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            ) {
                AndroidView(
                    factory = { context ->
                        YouTubePlayerView(context).apply {
                            enableAutomaticInitialization = false
                            lifecycle.addObserver(this)
                        }
                    },
                    update = { playerView ->
                        extractYouTubeId(video.videoUrl)?.let { id ->
                            playerView.initialize(
                                object : AbstractYouTubePlayerListener() {
                                    override fun onReady(youTubePlayer: YouTubePlayer) {
                                        youTubePlayer.loadVideo(id, 0f)
                                    }
                                },
                                true
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { isPlaying = false }
                )
                // Botón para minimizar
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Minimizar",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable { isPlaying = false }
                )
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            ) {
                YouTubeThumbnail(video.videoUrl)
                Icon(
                    painter = painterResource(R.drawable.ic_youtube),
                    contentDescription = "Reproducir",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { isPlaying = true }
                )
            }
        }
    }
}
