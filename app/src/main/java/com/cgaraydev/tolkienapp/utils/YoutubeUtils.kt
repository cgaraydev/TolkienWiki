package com.cgaraydev.tolkienapp.utils

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

fun extractYouTubeId(url: String): String? {
    val regex = Regex(
        """(?: youtube\.com/(?:[^/]+/.+/|(?:v|e(?:mbed)?)/|.*[?&]v=)| youtu\.be/ )([\w-]{11})""",
        RegexOption.COMMENTS
    )
    return regex.find(url)?.groups?.get(1)?.value
}

@Composable
fun YouTubeThumbnail(videoUrl: String) {
    val thumbnailUrl = remember(videoUrl) {
        val videoId = extractYouTubeId(videoUrl)
        "https://img.youtube.com/vi/$videoId/hqdefault.jpg"
    }

    AsyncImage(
        model = thumbnailUrl,
        contentDescription = "Miniatura de YouTube",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f),
        contentScale = ContentScale.Crop
    )
}

//TEST
fun main() {
    val testUrls = listOf(
        "https://www.youtube.com/watch?v=NTz2-im7s9k",
        "https://youtu.be/NTz2-im7s9k",
        "https://www.youtube.com/embed/NTz2-im7s9k",
        "https://www.youtube.com/v/NTz2-im7s9k",
        "https://www.youtube.com/watch?v=NTz2-im7s9k&ab_channel=TalkingAboutTolkien"
    )

    testUrls.forEach {
        println("Extracted ID: ${extractYouTubeId(it)}")
    }
}