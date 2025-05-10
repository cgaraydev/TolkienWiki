package com.cgaraydev.tolkienapp.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.RingBearer

// UI STATE
//sealed class UiState<out T> {
//    object Loading : UiState<Nothing>()
//    data class Success<T>(val data: T) : UiState<T>()
//    data class Error(val message: String, val retry: (() -> Unit)? = null) : UiState<Nothing>()
//    object Empty : UiState<Nothing>()
//}
//
//@Composable
//fun <T> StateHandler(
//    state: UiState<T>,
//    onLoading: @Composable () -> Unit = {
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            CircularProgressIndicator()
//        }
//    },
//    onError: @Composable (String, (() -> Unit)?) -> Unit = { message, retry ->
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = message, color = Color.White)
//                retry?.let {
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Button(onClick = it) {
//                        Text("Reintentar")
//                    }
//                }
//            }
//        }
//    },
//    onEmpty: @Composable (() -> Unit)? = null,
//    onSuccess: @Composable (T) -> Unit
//) {
//    when (state) {
//        is UiState.Loading -> onLoading()
//        is UiState.Error -> onError(state.message, state.retry)
//        is UiState.Empty -> onEmpty?.invoke() ?: Text("Sin datos")
//        is UiState.Success -> onSuccess(state.data)
//    }
//}