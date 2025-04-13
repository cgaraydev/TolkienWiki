package com.cgaraydev.tolkienapp.presentation.tolkien

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun TolkienScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
//            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        CustomSpacer(20)
        TolkienHeader()
        CustomSpacer(20)
        // Sección 1: Introducción y vida temprana
        BiographySection(
            title = "El Arquitecto de la Tierra Media",
            content = """
                John Ronald Reuel Tolkien (1892-1973), conocido mundialmente como J.R.R. Tolkien, fue un escritor, filólogo y profesor universitario británico que revolucionó la literatura fantástica. Creador del legendario mundo de Arda y su continente principal, la Tierra Media, Tolkien combinó su erudición académica con una imaginación sin límites para construir uno de los universos ficticios más detallados de la historia.
                
                Nacido el 3 de enero de 1892 en Bloemfontein (actual Sudáfrica), su infancia estuvo marcada por la tragedia: la muerte de su padre cuando tenía 4 años y de su madre a los 12, quedando al cuidado del padre Francis Morgan.
            """.trimIndent()
        )

        // Sección 2: Formación académica y carrera
        BiographySection(
            title = "El Filólogo de Oxford",
            content = """
                Tolkien estudió en la Universidad de Oxford, especializándose en lenguas antiguas y literatura. Dominaba más de 20 idiomas, incluyendo el anglosajón, el finés y el galés. Esta pasión filológica lo llevó a crear lenguas completas como el Quenya (inspirado en el finés) y el Sindarin (basado en el galés), mucho antes de concebir las historias que las habitarían.
                
                Como profesor de anglosajón en Oxford (1925-1945) y luego de Lengua y Literatura Inglesa (1945-1959), influyó a generaciones de estudiantes con su erudición y su particular visión de los mitos nórdicos y anglosajones.
            """.trimIndent()
        )

        // Sección 3: Experiencia en la guerra
        BiographySection(
            title = "La Sombra de la Guerra",
            content = """
                Participó en la Primera Guerra Mundial como teniente en los Lancashire Fusiliers, experiencia que marcó profundamente su visión del mundo. Luchó en la Batalla del Somme (1916), donde perdió a dos de sus mejores amigos. Estas vivencias se reflejarían luego en los temas de pérdida, camaradería y sacrificio que impregnan su obra.
                
                Durante su convalecencia por la "fiebre de las trincheras", comenzó a escribir "El Libro de los Cuentos Perdidos", embrión de lo que sería su legendarium.
            """.trimIndent()
        )

        // Sección 4: Obra literaria
        BiographySection(
            title = "El Nacimiento de un Legendarium",
            content = """
                Tolkien concibió su obra como una mitología para Inglaterra. "El Hobbit" (1937), escrito inicialmente para sus hijos, fue su primera publicación. Su éxito llevó a la creación de "El Señor de los Anillos" (1954-55), considerada su obra maestra.
                
                Su método de escritura era peculiar: creaba primero las lenguas, luego las culturas que las hablaban, y finalmente las historias. Este proceso resultó en miles de páginas de manuscritos que su hijo Christopher Tolkien editó póstumamente ("El Silmarillion", 1977; "Los Hijos de Húrin", 2007).
            """.trimIndent()
        )

        // Sección 5: Vida personal y legado
        BiographySection(
            title = "El Hombre Detrás del Mito",
            content = """
                Tolkien fue un devoto católico cuya fe influyó en su obra. Su amor por Edith Bratt, a quien conoció a los 16 años, inspiró la historia de Beren y Lúthien (sus nombres aparecen juntos en su lápida). Padre de cuatro hijos, escribió anualmente cartas de Papá Noel llenas de aventuras fantásticas.
                
                Miembro clave de los "Inklings" junto a C.S. Lewis, su obra ha vendido más de 600 millones de copias. Las adaptaciones cinematográficas de Peter Jackson (2001-2003) renovaron el interés global por su universo, consolidando su legado como piedra angular de la fantasía moderna.
            """.trimIndent()
        )

        // Timeline visual
        WorksSection()
        TimelineSection()
//        EnhancedTimelineSection()
    }
}

@Composable
private fun BiographySection(title: String, content: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            color = Golden,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = content,
            color = Color.White,
            style = TextStyle(),
            fontSize = 14.sp,
            lineHeight = 20.sp
        )

        CustomSpacer(16)
    }
}

//@Composable
//private fun EnhancedTimelineSection() {
//    val timelineEvents = listOf(
//        TimelineEvent("1892", "Nace en Bloemfontein, Sudáfrica"),
//        TimelineEvent("1895", "Se muda a Inglaterra con su madre y hermano"),
//        TimelineEvent("1904", "Fallece su madre, queda bajo tutela del Padre Morgan"),
//        TimelineEvent("1911", "Ingresa a Oxford, conoce a Edith Bratt"),
//        TimelineEvent("1916", "Participa en la Batalla del Somme (WWI)"),
//        TimelineEvent("1917", "Comienza a escribir el Legendarium"),
//        TimelineEvent("1925", "Profesor de Anglosajón en Oxford"),
//        TimelineEvent("1937", "Publica 'El Hobbit'"),
//        TimelineEvent("1945", "Profesor de Lengua y Literatura Inglesa"),
//        TimelineEvent("1954-55", "Publica 'El Señor de los Anillos'"),
//        TimelineEvent("1962", "Publica 'Las aventuras de Tom Bombadil'"),
//        TimelineEvent("1971", "Fallece su esposa Edith"),
//        TimelineEvent("1973", "Muere en Bournemouth, Inglaterra"),
//        TimelineEvent("1977", "Christopher Tolkien publica 'El Silmarillion'")
//    )
//
//    Column(modifier = Modifier.padding(vertical = 16.dp)) {
//        Text(
//            text = "Línea de Vida",
//            color = Golden,
//            fontSize = 24.sp,
//            fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        LazyColumn {
//            itemsIndexed(timelineEvents) { index, event ->
//                TimelineItem(
//                    event = event,
//                    isFirst = index == 0,
//                    isLast = index == timelineEvents.size - 1
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun TimelineItem(event: TimelineEvent, isFirst: Boolean, isLast: Boolean) {
//    Row(
//        modifier = Modifier.padding(start = 8.dp, end = 16.dp, bottom = 12.dp),
//        verticalAlignment = Alignment.Top
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.width(40.dp)
//        ) {
//            if (!isFirst) {
//                Box(
//                    modifier = Modifier
//                        .width(2.dp)
//                        .height(12.dp)
//                        .background(Golden.copy(alpha = 0.5f))
//                )
//            }
//
//            Box(
//                modifier = Modifier
//                    .size(12.dp)
//                    .background(Golden, CircleShape)
//            )
//
//            if (!isLast) {
//                Box(
//                    modifier = Modifier
//                        .width(2.dp)
//                        .height(12.dp)
//                        .background(Golden.copy(alpha = 0.5f))
//                )
//            }
//        }
//
//        Column(modifier = Modifier.padding(start = 12.dp)) {
//            Text(
//                text = event.year,
//                color = Golden,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold
//            )
//            Text(
//                text = event.description,
//                color = Color.White,
//                fontSize = 14.sp,
//                modifier = Modifier.padding(top = 4.dp)
//            )
//        }
//    }
//}
//
//data class TimelineEvent(val year: String, val description: String)

@Composable
private fun TimelineSection() {
    val timelineEvents = listOf(
        Pair("1892", "Nacimiento en Bloemfontein, Sudáfrica"),
        Pair("1904", "Fallecimiento de su madre, Mabel Tolkien"),
        Pair("1911", "Viaje a Suiza, inspiración para Rivendel"),
        Pair("1916", "Participa en la Batalla del Somme"),
        Pair("1917", "Comienza a escribir el Legendarium"),
        Pair("1920", "Se convierte en lector de inglés en la Universidad de Leeds"),
        Pair("1937", "Publicación de 'El Hobbit'"),
        Pair("1954-55", "Publicación de 'El Señor de los Anillos'"),
        Pair("1969", "Venta de los derechos cinematográficos de 'El Señor de los Anillos'"),
        Pair("1972", "Nombrado Comendador de la Orden del Imperio Británico"),
        Pair("1973", "Fallecimiento en Bournemouth, Inglaterra")
    )

    Text(
        text = "Cronología Tolkien",
        color = Golden,
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
        modifier = Modifier.padding(vertical = 16.dp)
    )

    Column {
        timelineEvents.forEach { (year, event) ->
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Golden, CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = year,
                        color = Golden,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = event,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
            if (year != timelineEvents.last().first) {
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .width(1.dp)
                        .padding(start = 5.dp)
                        .background(Golden.copy(alpha = 0.5f))
                )
            }
        }
    }
}

@Composable
fun TolkienHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.tolkien),
            contentDescription = "Retrato de J.R.R. Tolkien",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        ),
                        startY = 0.3f
                    )
                )
        )

        Text(
            text = "J.R.R. Tolkien",
            color = Golden,
            fontSize = 36.sp,
            fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}

@Composable
fun WorksSection() {
    val works = listOf(
        Work("El Hobbit", "1937", R.drawable.logo),
        Work("El Señor de los Anillos", "1954-55", R.drawable.logo),
        Work("El Silmarillion", "1977", R.drawable.logo),
        Work("Los Hijos de Húrin", "2007", R.drawable.logo)
    )

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Obras Fundamentales",
            color = Golden,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(works) { work ->
                WorkCard(work = work)
            }
        }
    }
}

@Composable
fun WorkCard(work: Work) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(220.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(work.imageRes),
                contentDescription = "Portada de ${work.title}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.9f)
                            )
                        )
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = work.title,
                    color = Golden,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = work.year,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

data class Work(val title: String, val year: String, @DrawableRes val imageRes: Int)