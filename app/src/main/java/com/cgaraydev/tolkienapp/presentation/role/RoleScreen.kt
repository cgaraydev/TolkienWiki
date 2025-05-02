package com.cgaraydev.tolkienapp.presentation.role

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.data.models.Option
import com.cgaraydev.tolkienapp.data.models.PlayerState
import com.cgaraydev.tolkienapp.data.models.Scenario
import com.cgaraydev.tolkienapp.ui.theme.AgilityGold
import com.cgaraydev.tolkienapp.ui.theme.DefensePurple
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.HealthRed
import com.cgaraydev.tolkienapp.ui.theme.IntelligenceCyan
import com.cgaraydev.tolkienapp.ui.theme.LuckGreen
import com.cgaraydev.tolkienapp.ui.theme.StrengthBlue

@Composable
fun RoleScreen(
    navController: NavController,
    viewModel: RoleViewModel = hiltViewModel()
) {
    val playerState by viewModel.playerState.collectAsState()
    val currentScenario by viewModel.currentScenario.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage = remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            viewModel.loadInitialScenario()
        } catch (e: Exception) {
            errorMessage.value = "Error al cargar: ${e.message}"
        }
    }

    if (errorMessage.value != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(errorMessage.value ?: "Error", color = Color.Red)
                Button(onClick = {
                    errorMessage.value = null
                    viewModel.loadInitialScenario()
                }) {
                    Text("Reintentar")
                }
            }
        }
        return
    }

    // Pantalla de carga
    if (isLoading || currentScenario == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Golden)
        }
        return
    }

    // Pantalla principal del juego
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header con stats del jugador
            PlayerStatsHeader(playerState)

            // Tarjeta del escenario
            ScenarioCard(
                scenario = currentScenario!!,
                onOptionSelected = { option ->
                    viewModel.selectOption(option)
                }
            )
        }
    }
}

@Composable
fun PlayerStatsHeader(playerState: PlayerState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(
                icon = R.drawable.ic_health,
                value = playerState.health,
                color = HealthRed
            )
            StatItem(
                icon = R.drawable.ic_strength,
                value = playerState.strength,
                color = StrengthBlue
            )
            StatItem(
                icon = R.drawable.ic_shield,
                value = playerState.defense,
                color = DefensePurple
            )
            StatItem(
                icon = R.drawable.ic_agility,
                value = playerState.agility,
                color = AgilityGold
            )
            StatItem(
                icon = R.drawable.ic_intelligence,
                value = playerState.wisdom,
                color = IntelligenceCyan
            )
            StatItem(
                icon = R.drawable.ic_luck,
                value = playerState.luck,
                color = LuckGreen
            )

        }
    }
}

@Composable
fun StatItem(icon: Int, value: Int, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = value.toString(),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.cardo)),
            fontSize = 18.sp
        )
    }
}

@Composable
fun ScenarioCard(
    scenario: Scenario,
    onOptionSelected: (Option) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Título del escenario
            Text(
                text = scenario.title,
                color = Golden,
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.cardo)),
                fontWeight = FontWeight.Bold
            )

            // Descripción
            Text(
                text = scenario.text,
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.cardo)),
                lineHeight = 24.sp
            )

            // Opciones
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                scenario.options.forEach { option ->
                    OptionButton(
                        text = option.text,
                        onClick = { onOptionSelected(option) }
                    )
                }
            }
        }
    }
}

@Composable
fun OptionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2D2D2D),
            contentColor = Golden
        ),
        border = BorderStroke(1.dp, Golden.copy(alpha = 0.5f))
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.cardo)),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}