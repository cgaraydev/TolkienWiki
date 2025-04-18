package com.cgaraydev.tolkienapp.utils

import com.cgaraydev.tolkienapp.data.models.QuizQuestion

sealed class QuizUiState {
    object Loading : QuizUiState()
    data class Success(val questions: List<QuizQuestion>) : QuizUiState()
    data class Error(val message: String) : QuizUiState()
}
