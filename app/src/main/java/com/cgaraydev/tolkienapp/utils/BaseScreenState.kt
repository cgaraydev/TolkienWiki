package com.cgaraydev.tolkienapp.utils

sealed interface BaseScreenState<out T> {
    data object Loading : BaseScreenState<Nothing>
    data class Success<T>(val data: T) : BaseScreenState<T>
    data class Error(val message: String) : BaseScreenState<Nothing>
}