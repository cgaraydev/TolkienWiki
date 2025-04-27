package com.cgaraydev.tolkienapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.memory.MemoryViewModel
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.QuizRed
import com.cgaraydev.tolkienapp.utils.toDateString
import com.cgaraydev.tolkienapp.utils.toTimeString

@Composable
fun RecordsDialog(
    onDismiss: () -> Unit,
    viewModel: MemoryViewModel
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val difficulties = listOf("hobbit", "elfo", "ainur")
    val times by viewModel.getBestTimes(difficulties[selectedTab]).collectAsState(emptyList())
    var showConfirmDialog by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF1E1E1E),
            border = BorderStroke(1.dp, Golden),
            modifier = Modifier
                .width(320.dp)
                .height(440.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Mejores Tiempos",
                    color = Golden,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp),
                )

                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Color.Black,
                    contentColor = Golden,
                    indicator = { tabPositions ->
                        SecondaryIndicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                            height = 2.dp,
                            color = Golden
                        )
                    }
                ) {
                    difficulties.forEachIndexed { index, difficulty ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            selectedContentColor = Golden,
                            unselectedContentColor = Color.Gray,
                            text = {
                                Text(
                                    text = difficulty.uppercase(),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.cardo))
                                )
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    if (times.isEmpty()) {
                        Text(
                            "No hay registros aún",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.cardo))
                        )
                    } else {
                        Column {
                            times.forEachIndexed { index, record ->
                                Text(
                                    text = "${index + 1}. ${record.time.toTimeString()} - ${record.moves} - ${record.date.toDateString()}",
                                    color = Color.White,
                                    modifier = Modifier.padding(4.dp),
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AnimatedGlowButtonCompact(
                        text = "Borrar",
                        onClick = { showConfirmDialog = true },
                        glowColor = QuizRed,
                        modifier = Modifier.weight(1f)
                    )
                    AnimatedGlowButtonCompact(
                        text = "Cerrar",
                        onClick = onDismiss,
                        glowColor = Golden,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
    CustomAlertDialog(
        showDialog = showConfirmDialog,
        title = "BORRAR REGISTROS",
        message = "¿Estás seguro que deseas borrar los registros de la dificultad ${difficulties[selectedTab].uppercase()}?",
        onConfirm = {
            viewModel.clearBestTimes(difficulties[selectedTab])
            showConfirmDialog = false
        },
        onDismiss = { showConfirmDialog = false }
    )
}

@Composable
fun CustomAlertDialog(
    showDialog: Boolean,
    title: String,
    message: String,
    confirmText: String = "BORRAR",
    cancelText: String = "Cancelar",
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (!showDialog) return
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color(0xFF1E1E1E),
            border = BorderStroke(1.dp, QuizRed.copy(alpha = 0.7f)),
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    color = QuizRed,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cardo))
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = message,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cardo))
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(
                            text = cancelText,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.cardo))
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = onConfirm) {
                        Text(
                            text = confirmText,
                            color = QuizRed,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.cardo))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GameResultDialog(
    moves: Int,
    time: Long,
    difficulty: String,
    onDismiss: () -> Unit,
    onRestart: () -> Unit,
    modifier: Modifier = Modifier
) {
    val formattedTime = remember(time) {
        time.toTimeString()
    }
    val funFacts = remember {
        listOf(
            "Gandalf era conocido como Mithrandir entre los elfos",
            "Los hobbits tienen los pies peludos y no usan zapatos",
            "El Anillo Único fue forjado por Sauron en el Monte del Destino",
            "El nombre 'Bag End' (Bolsón Cerrado) proviene de la granja de la tía de Tolkien en Worcestershire",
            "Tolkien creó más de 14 idiomas para la Tierra Media, incluyendo Quenya y Sindarin",
            "El 25 de marzo es el Día Internacional de la Lectura de Tolkien, coincidiendo con la caída de Sauron",
            "El primer libro que escribió sobre la Tierra Media fue 'El Silmarillion', aunque se publicó póstumamente",
            "Tolkien se inspiró en los Alpes suizos para crear Rivendel y las Montañas Nubladas",
            "Tolkien escribió la primera línea de 'El Hobbit' mientras corregía exámenes: 'En un agujero en el suelo vivía un hobbit'",
            "Los ents, como Bárbol, fueron inspirados por los árboles que Tolkien admiraba en su infancia",
            "El personaje de Tom Bombadil fue creado como un enigma, y ni siquiera el Anillo Único podía afectarlo"
        )
    }
    val randomFact = remember { funFacts.random() }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF1E1E1E),
            modifier = modifier
                .fillMaxWidth(0.9f)
                .border(2.dp, Golden, RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "¡Juego completado!",
                    color = Golden,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.cardo))
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Estadísticas
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "ESTADISTICAS",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.cardo)),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        "Tiempo:",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.cardo)),
                    )
                    StatItem(
                        icon = painterResource(R.drawable.ic_clock),
                        value = formattedTime
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Movimientos:",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.cardo)),
                    )
                    StatItem(
                        icon = painterResource(R.drawable.ic_moves),
                        value = moves.toString()
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Dificultad:",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.cardo)),
                    )
                    StatItem(
                        icon = painterResource(R.drawable.ic_ring),
                        value = difficulty.uppercase()
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Datos curiosos
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.3f))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "¿Sabías que?",
                        color = Golden,
                        modifier = Modifier.padding(bottom = 8.dp),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.cardo))
                    )
                    Text(
                        randomFact,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.cardo))
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AnimatedGlowButtonCompact(
                        text = "reiniciar",
                        onClick = onRestart,
                        glowColor = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    AnimatedGlowButtonCompact(
                        text = "cerrar",
                        onClick = onDismiss,
                        glowColor = QuizRed,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

