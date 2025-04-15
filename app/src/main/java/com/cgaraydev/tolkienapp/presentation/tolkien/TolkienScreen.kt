package com.cgaraydev.tolkienapp.presentation.tolkien

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.YouTubeMediaSection

@Composable
fun TolkienScreen() {
    LazyColumn(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                TolkienHeader()
                CustomSpacer(20)
                BioDataSection()
                CustomSpacer(20)
                TolkienBiography()
            }
        }
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                CompleteWorksSection()
            }
        }
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                DidYouKnowSection()
            }
        }
        item {
            YouTubeMediaSection()
            CustomSpacer(20)
        }
    }
}
