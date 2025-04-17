package com.cgaraydev.tolkienapp.data

data class QuizQuestion(
    val id:String ="",
    val question: String = "",
    val options: List<String> = emptyList(),
    val answer: String = "",
    val difficulty: String = "hobbit"
)
