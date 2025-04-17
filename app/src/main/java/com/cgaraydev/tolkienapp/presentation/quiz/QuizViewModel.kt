package com.cgaraydev.tolkienapp.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaraydev.tolkienapp.data.QuizQuestion
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//FUNCIONAL
//@HiltViewModel
//class QuizViewModel @Inject constructor(
//    private val firestore: FirebaseFirestore
//) : ViewModel() {
//
//    private val _selectedDifficulty = MutableStateFlow("hobbit")
//    val selectedDifficulty: StateFlow<String> = _selectedDifficulty.asStateFlow()
//
//    private val _questions = MutableStateFlow<List<QuizQuestion>>(emptyList())
//    val questions: StateFlow<List<QuizQuestion>> = _questions.asStateFlow()
//
//    private val _currentQuestionIndex = MutableStateFlow(0)
//    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()
//
//    private val _correctAnswers = MutableStateFlow(0)
//    val correctAnswers: StateFlow<Int> = _correctAnswers.asStateFlow()
//
//    fun setDifficulty(difficulty: String) {
//        _selectedDifficulty.value = difficulty
//            }
//
//    fun loadQuestions() {
//        val difficulty = _selectedDifficulty.value
//        Log.d("QuizViewModel", "Dificultad seleccionada: ${_selectedDifficulty.value}")
//
//        firestore.collection("questions")
//            .whereEqualTo("difficulty", difficulty)
//            .get()
//            .addOnSuccessListener { result ->
//                val loadedQuestions = result.mapNotNull { it.toObject(QuizQuestion::class.java) }
//                Log.d("QuizViewModel", "Loaded ${loadedQuestions.size} questions")
//                _questions.value = loadedQuestions.shuffled().take(10)
//                _currentQuestionIndex.value = 0
//                _correctAnswers.value = 0
//            }
//            .addOnFailureListener {
//                _questions.value = emptyList()
//            }
//    }
//
//    fun onOptionSelected(selectedOption: String) {
//        val index = _currentQuestionIndex.value
//        val current = _questions.value.getOrNull(index)
//
//        Log.d("QuizViewModel", "Pregunta ${_currentQuestionIndex.value + 1}: ${current?.question}")
//        Log.d("QuizViewModel", "ID de la pregunta: ${current?.id ?: "sin ID"}")
//        Log.d("QuizViewModel", "Opción seleccionada: $selectedOption")
//        Log.d("QuizViewModel", "Respuesta correcta: ${current?.answer}")
//
//        if (current == null) return
//
//        if (selectedOption == current.answer) {
//            _correctAnswers.value += 1
//        }
//
//        if (index < _questions.value.lastIndex) {
//            _currentQuestionIndex.value += 1
//        } else {
//            Log.d("QuizViewModel", "Quiz finalizado. Correctas: ${_correctAnswers.value}")
//        }
//    }
//}

//FUNCIONAL
//@HiltViewModel
//class QuizViewModel @Inject constructor(
//    private val firestore: FirebaseFirestore
//) : ViewModel() {
//
//    private val _selectedDifficulty = MutableStateFlow("hobbit")
//    val selectedDifficulty: StateFlow<String> = _selectedDifficulty.asStateFlow()
//
//    private val _questions = MutableStateFlow<List<QuizQuestion>>(emptyList())
//    val questions: StateFlow<List<QuizQuestion>> = _questions.asStateFlow()
//
//    private val _currentQuestionIndex = MutableStateFlow(0)
//    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()
//
//    private val _correctAnswers = MutableStateFlow(0)
//    val correctAnswers: StateFlow<Int> = _correctAnswers.asStateFlow()
//
//    fun setDifficulty(difficulty: String) {
//        _selectedDifficulty.value = difficulty
//        Log.d("QuizViewModel", "Dificultad actualizada a: $difficulty")
//    }
//
//    fun loadQuestions() {
//        val difficulty = _selectedDifficulty.value
//        Log.d("QuizViewModel", "Dificultad seleccionada: ${_selectedDifficulty.value}")
//
//        firestore.collection("questions")
//            .whereEqualTo("difficulty", difficulty)
//            .get()
//            .addOnSuccessListener { result ->
//                val loadedQuestions = result.mapNotNull { it.toObject(QuizQuestion::class.java) }
//                Log.d("QuizViewModel", "Loaded ${loadedQuestions.size} questions")
//                _questions.value = loadedQuestions.shuffled().take(10)
//                _currentQuestionIndex.value = 0
//                _correctAnswers.value = 0
//            }
//            .addOnFailureListener {
//                _questions.value = emptyList()
//            }
//    }
//
//    fun onOptionSelected(selectedOption: String) {
//        val index = _currentQuestionIndex.value
//        val current = _questions.value.getOrNull(index)
//
//        Log.d("QuizViewModel", "Pregunta ${_currentQuestionIndex.value + 1}: ${current?.question}")
//        Log.d("QuizViewModel", "ID de la pregunta: ${current?.id ?: "sin ID"}")
//        Log.d("QuizViewModel", "Opción seleccionada: $selectedOption")
//        Log.d("QuizViewModel", "Respuesta correcta: ${current?.answer}")
//
//        if (current == null) return
//
//        if (selectedOption == current.answer) {
//            _correctAnswers.value += 1
//        }
//
//        if (index < _questions.value.lastIndex) {
//            _currentQuestionIndex.value += 1
//        } else {
//            Log.d("QuizViewModel", "Quiz finalizado. Correctas: ${_correctAnswers.value}")
//        }
//    }
//}

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _selectedDifficulty = MutableStateFlow("hobbit")
    val selectedDifficulty: StateFlow<String> = _selectedDifficulty.asStateFlow()

    private val _questions = MutableStateFlow<List<QuizQuestion>>(emptyList())
    val questions: StateFlow<List<QuizQuestion>> = _questions.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()

    private val _correctAnswers = MutableStateFlow(0)
    val correctAnswers: StateFlow<Int> = _correctAnswers.asStateFlow()

    private val _selectedOption = MutableStateFlow<String?>(null)
    val selectedOption: StateFlow<String?> = _selectedOption.asStateFlow()

//    private val _isChangingQuestion = MutableStateFlow(false)
//    val isChangingQuestion: StateFlow<Boolean> = _isChangingQuestion.asStateFlow()

    fun setDifficulty(difficulty: String) {
        _selectedDifficulty.value = difficulty
        Log.d("QuizViewModel", "Dificultad actualizada a: $difficulty")
    }

    fun loadQuestions() {
        val difficulty = _selectedDifficulty.value
        Log.d("QuizViewModel", "Dificultad seleccionada: ${_selectedDifficulty.value}")

        firestore.collection("questions")
            .whereEqualTo("difficulty", difficulty)
            .get()
            .addOnSuccessListener { result ->
                val loadedQuestions = result.mapNotNull { it.toObject(QuizQuestion::class.java) }
                Log.d("QuizViewModel", "Loaded ${loadedQuestions.size} questions")
                _questions.value = loadedQuestions.shuffled().take(10)
                _currentQuestionIndex.value = 0
                _correctAnswers.value = 0
            }
            .addOnFailureListener {
                _questions.value = emptyList()
            }
    }


    fun selectOption(option: String) {
        val current = _questions.value.getOrNull(_currentQuestionIndex.value) ?: return
        _selectedOption.value = option
        if (option == current.answer) {
            _correctAnswers.value += 1
        }
    }

    fun nextQuestion() {
        viewModelScope.launch {
//            _isChangingQuestion.value = true
            _selectedOption.value = null
            delay(50)
            _currentQuestionIndex.value += 1
//            _isChangingQuestion.value = false
        }
    }


}