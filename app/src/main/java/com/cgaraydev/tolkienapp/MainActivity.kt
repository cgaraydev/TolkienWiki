package com.cgaraydev.tolkienapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.cgaraydev.tolkienapp.presentation.drawer.MenuDrawer
import com.cgaraydev.tolkienapp.presentation.music.MusicViewModel
import com.cgaraydev.tolkienapp.ui.theme.TolkienAppTheme
import com.cgaraydev.tolkienapp.utils.AudioLifecycleObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val musicViewModel: MusicViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(AudioLifecycleObserver(musicViewModel))
        enableEdgeToEdge()
        setContent {
            TolkienAppTheme {
                MenuDrawer()
            }
        }
    }
}






