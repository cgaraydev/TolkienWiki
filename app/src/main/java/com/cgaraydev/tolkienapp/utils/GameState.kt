package com.cgaraydev.tolkienapp.utils

sealed class GameState {
    data object PLAYING : GameState()
    data object FINISHED : GameState()
}
