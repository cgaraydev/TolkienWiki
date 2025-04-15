package com.cgaraydev.tolkienapp.presentation.tolkien

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.CustomTitle
import com.cgaraydev.tolkienapp.ui.theme.Golden


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
                CustomSpacer(20)
            }
        }

        item {
            Column(modifier = Modifier.padding(16.dp)) {
                CompleteWorksSection()
                CustomSpacer(20)
            }
        }

        item{
            DidYouKnowSection()
            CustomSpacer(20)
        }

    }
}
//@Composable
//fun TolkienScreen() {
////    val scrollState = rememberScrollState()
//
//    LazyColumn(
//        modifier = Modifier
//            .background(Color.Black)
//            .padding(16.dp)
//    ) {
//        item { TolkienHeader() }
////        item { CustomSpacer(20) }
////        item { BioDataSection() }
////        item { CustomSpacer(20) }
////        item { TolkienBiography() }
////        item { CustomSpacer(20) }
////        item { CompleteWorksSection() }
//
////        WorksSection()
////        CanvasTimelineSection()
////        DidYouKnowSection()
////        YouTubeVideosSection()
////        InfluencesSection()
//    }
//}