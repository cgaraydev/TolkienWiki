package com.cgaraydev.tolkienapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cgaraydev.tolkienapp.presentation.components.drawer.MenuDrawer
import com.cgaraydev.tolkienapp.ui.theme.TolkienAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TolkienAppTheme {
                MenuDrawer()
            }
        }
    }
}






