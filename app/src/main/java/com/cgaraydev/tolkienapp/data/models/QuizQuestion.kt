package com.cgaraydev.tolkienapp.data.models

data class QuizQuestion(
    val id:String ="",
    val question: String = "",
    val options: List<String> = emptyList(),
    val answer: String = "",
    val difficulty: String = "hobbit",
    val explanation: String = ""
)
