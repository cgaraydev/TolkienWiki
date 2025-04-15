package com.cgaraydev.tolkienapp.presentation.tolkien

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.components.CustomDivider
import com.cgaraydev.tolkienapp.presentation.components.CustomSpacer
import com.cgaraydev.tolkienapp.presentation.components.CustomTitle
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.LightGray

@Composable
fun TolkienHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.tolkien),
            contentDescription = "Retrato de J.R.R. Tolkien",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
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
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}

@Composable
fun BioDataSection() {
    val uriHandler = LocalUriHandler.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            BioDataRow("Nombre", "John Ronald Reuel Tolkien")
            CustomDivider()
            BioDataRow(
                "Nacimiento",
                "3 de enero de 1892\nBloemfontein, Estado Libre de Orange (actual Sudáfrica)"
            )
            CustomDivider()
            BioDataRow(
                "Fallecimiento", "2 de septiembre de 1973 (81 años)\nBournemouth, Inglaterra"
            )
            CustomDivider()
            BioDataRow("Sepultura", "Cementerio de Wolvercote")
            CustomDivider()
            BioDataRow("Religión", "Catolicismo tradicionalista y catolicismo")
            CustomDivider()
            BioDataRow("Educación", "Exeter College, Universidad de Oxford")
            CustomDivider()
            BioDataRow("Padres", "Arthur Reuel Tolkien, Mabel Suffield")
            CustomDivider()
            BioDataRow("Cónyuge", "Edith Mary Bratt")
            CustomDivider()
            BioDataRow(
                "Hijos",
                "John (1917-2003), Michael (1920-1984), Christopher (1924-2020) y Priscilla (1929-2022)"
            )
            CustomDivider()
            BioDataRow(
                "Ocupación",
                "Escritor, filólogo, poeta y profesor de Anglosajón, Lengua y Literatura inglesa en la Universidad de Oxford"
            )
            CustomDivider()
            BioDataRow("Residencia", "Reino Unido")
            CustomDivider()
            CustomSpacer(12)
            CustomTitle(
                "Sitio Oficial:",
                14,
                Modifier.alpha(0.7f),
                textDecoration = TextDecoration.None
            )
            ClickableText(
                text = AnnotatedString("www.tolkienestate.com"),
                style = TextStyle(
                    color = Color(0xFF64B5F6),
                    fontSize = 16.sp
                ),
                onClick = { uriHandler.openUri("https://www.tolkienestate.com/") },
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun BioDataRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Golden,
            fontSize = 14.sp,
            modifier = Modifier
                .width(120.dp)
                .alpha(0.7f)
        )
        Text(
            text = value,
            color = White,
            style = TextStyle().copy(
                fontSize = 14.sp
            ),
            lineHeight = 16.sp
        )
    }
}

@Composable
fun TolkienIntroduction() {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Text(
            text = """
                John Ronald Reuel Tolkien (1892-1973), el arquitecto literario de la Tierra Media, fue un hombre de múltiples facetas: filólogo de Oxford cuyos trabajos académicos redefinieron el estudio del anglosajón, soldado que sobrevivió al infierno de las trincheras en la Primera Guerra Mundial, y creador de uno de los universos ficticios más detallados de la literatura universal.
            """.trimIndent(),
            style = TextStyle().copy(fontSize = 14.sp, lineHeight = 20.sp, color = White),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = """
                Nacido en Bloemfontein (Sudáfrica) y educado en Inglaterra, Tolkien ocupó las cátedras más prestigiosas de Oxford como profesor de Anglosajón (1925-1945) y luego de Lengua y Literatura Inglesa (1945-1959). Miembro clave de los Inklings junto a C.S. Lewis, su obra maestra -"El Señor de los Anillos"- comenzó como una simple secuela de "El Hobbit" y se convirtió en la piedra angular de la fantasía moderna.
            """.trimIndent(),
            style = TextStyle().copy(fontSize = 14.sp, lineHeight = 20.sp, color = White),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = """
                Más que un escritor, Tolkien fue un "subcreador" de mundos completos: inventó más de 15 lenguas con su gramática y vocabulario, desarrolló miles de años de historia ficticia, y trazó genealogías, mapas y calendarios para sus culturas imaginarias. Nombrado Comendador del Imperio Británico en 1972, su legado se extiende mucho más allá de los 600 millones de libros vendidos, influenciando generaciones de escritores y redefiniendo lo que la literatura fantástica podía lograr.
            """.trimIndent(),
            style = TextStyle().copy(fontSize = 14.sp, lineHeight = 20.sp, color = White),
        )
    }
}

@Composable
fun ExpandableBiographySection(
    title: String,
    quote: String,
    content: String
) {
    var expanded by remember { mutableStateOf(false) }
    val arrowIcon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Encabezado clickeable
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .fillMaxWidth()
                .padding(bottom = if (expanded) 0.dp else 8.dp)
        ) {
            Text(
                text = title,
                color = Golden,
                fontSize = 22.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = arrowIcon,
                contentDescription = if (expanded) "Contraer sección" else "Expandir sección",
                tint = Golden,
                modifier = Modifier.size(24.dp)
            )
        }

        // Contenido expandible (quote + content)
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Column {
                // Cita
                Text(
                    text = quote,
                    style = TextStyle(
                        color = LightGray,
                        fontFamily = FontFamily(Font(R.font.aniron)),
                        fontSize = 12.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
                // Contenido principal
                Text(
                    text = content,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = White
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        // Separador (solo visible cuando está contraído)
        AnimatedVisibility(
            visible = !expanded,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Golden.copy(alpha = 0.2f))
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun TolkienBiography() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        CustomTitle(
            "Biografía",
            26,
            Modifier.align(Alignment.CenterHorizontally),
            textDecoration = TextDecoration.Underline
        )
        CustomSpacer(20)
        TolkienIntroduction()

        // Sección 1: Infancia y formación
        ExpandableBiographySection(
            title = "Los Primeros Años: De África a Birmingham",
            quote = """
                "Mis primeros recuerdos son del África caliente - el polvo, el acacia, los grandes cielos pálidos" 
                (Carta a Christopher Tolkien, 1944)
            """.trimIndent(),
            content = """
        John Ronald Reuel Tolkien llegó al mundo un gélido 3 de enero de 1892 en Bloemfontein, capital del Estado Libre de Orange (actual Sudáfrica), donde su padre Arthur administraba una sucursal bancaria. El clima africano, los vastos paisajes y las lenguas indígenas dejarían una huella imperecedera en su imaginación infantil.
        
        La tragedia marcó sus primeros años: en 1896, con solo 4 años, perdió a su padre por fiebre reumática. Su madre Mabel lo llevó entonces a Inglaterra, donde se establecieron en el pintoresco pueblo de Sarehole, cerca de Birmingham. Allí, el joven Ronald (como lo llamaban en familia) desarrolló su amor por la campiña inglesa y las leyendas antiguas. La muerte de Mabel en 1904, cuando Tolkien tenía 12 años, lo dejó bajo la tutela del padre Francis Xavier Morgan, un sacerdote católico que sería su figura paterna.
        
        Su genio lingüístico se manifestó temprano:
        • A los 7 años compuso "La historia del dragón verde", su primer relato fantástico
        • A los 10 dominaba latín y griego, y comenzó a inventar lenguas
        • En la King Edward's School (1903-1911) descubrió el anglosajón y el galés medio   
             
        En esta época formó la "Sociedad del Té Club y Sociedad Barroviana" (TCBS) con sus amigos Christopher Wiseman, Robert Gilson y Geoffrey Bache Smith - un grupo de debate literario que Tolkien recordaría toda su vida, especialmente tras perder a dos de sus miembros en la Primera Guerra Mundial.
        
        En 1911, con una beca en Exeter College, Oxford, inició sus estudios en Filología Comparada, especializándose en lenguas germánicas. Su fascinación por el finés (que inspiraría el quenya) y el galés (base del sindarin) comenzó a tomar forma en estos años, sentando las bases de su futuro legendarium.
            """.trimIndent()
        )

        // Sección 2: Vida personal y fe
        ExpandableBiographySection(
            title = "Edith y la Fe: Los Pilares de su Vida",
            quote = """
        "Nunca llamé a Edith Lúthien - pero ella fue la fuente de la historia que en el tiempo se convirtió en la parte principal del Silmarillion. En aquellos días sus cabellos eran ravenosos, su piel clara, sus ojos más brillantes de lo que los has visto"
        (Carta a Christopher Tolkien, 1972)
            """.trimIndent(),
            content = """
        En 1908, un Tolkien de 16 años vivía en una pensión de Birmingham cuando conoció a Edith Bratt, una joven de 19 años huérfana como él. Este encuentro casual marcaría el curso de su vida. El padre Francis Morgan, al descubrir el romance, prohibió todo contacto hasta que Tolkien cumpliera 21 años, temiendo que distrajera sus estudios. El 3 de enero de 1913, exactamente a medianoche de su cumpleaños 21, Tolkien escribió a Edith declarando su amor. Ella rompió su compromiso con otro hombre para casarse con él tres años después, convirtiéndose al catolicismo bajo su influencia - decisión que Tolkien luego lamentaría por la presión ejercida.
        
        La fe católica fue el segundo gran pilar de su vida. Criado por el padre Morgan tras la muerte de su madre, Tolkien mantuvo una profunda espiritualidad que impregnó su obra:                
        - El sacrificio de Gandalf: Refleja el tema cristiano de la muerte redentora y resurrección, con claros paralelos en su caída en Moria y retorno como Gandalf el Blanco
        - La Caída de Númenor: Representa su versión del pecado original, donde la prohibición de viajar a las Tierras Imperecederas se rompe por orgullo humano
        - Eucatástrofe: Término que acuñó para describir el "gozo que surge del desastre repentino", concepto que vinculaba directamente con la Resurrección en su ensayo "Sobre los Cuentos de Hadas"
        
        Como padre de John, Michael, Christopher y Priscilla, Tolkien creó una rica vida familiar: 
        - Las famosas "Cartas de Papá Noel" (1920-1943), ilustradas manuscritas que detallaban aventuras del Polar Bear y el elfo Ilbereth
        - Las "batallas de cojines" dominicales donde toda la familia participaba
        - Las lecturas en voz alta de sus obras en progreso, probando sus historias con su audiencia más crítica
        
        La lápida que comparte con Edith en Wolvercote Cementery reza "Beren" y "Lúthien", nombres de los amantes inmortales de su legendarium - testimonio eterno de un amor que trascendió la vida real para convertirse en mito literario.  """.trimIndent()
        )

        // Sección 3: Guerra y academia
        ExpandableBiographySection(
            title = "Las Trincheras y las Aulas: De la Guerra a Oxford",
            quote = """
        "Los oficiales subalternos estaban siendo eliminados a una velocidad espantosa... Debería haber sido asesinado en el Somme... Esa espantosa guerra destruyó para siempre mi generación de amigos."
        (Carta a Christopher Tolkien, 1941)
            """.trimIndent(),
            content = """
        En julio de 1916, Tolkien llegó al frente occidental como teniente en los Lancashire Fusiliers, justo cuando comenzaba la ofensiva británica en el Somme. Durante cuatro meses en las trincheras, vivió el infierno de la guerra moderna: el barro perpetuo, el constante bombardeo de artillería y la pérdida diaria de camaradas. Su batallón sufrió más de 600 bajas en el asalto a la trinchera Regina. La muerte de su amigo Robert Gilson el primer día de la batalla y de Geoffrey Smith en 1918 marcarían para siempre su visión de la camaradería y el sacrificio, temas centrales en su obra.

        Durante su convalecencia en 1917 por la "fiebre de las trincheras" (una infección transmitida por piojos), comenzó a escribir "El Libro de los Cuentos Perdidos", donde aparecen por primera vez los mitos de Gondolin y los primeros esbozos de lenguas élficas. Estos escritos mostraban ya su característica fusión de elementos mitológicos con profundas reflexiones sobre la mortalidad.

        Como profesor de anglosajón en Oxford (1925-1945), Tolkien revolucionó la enseñanza de la literatura medieval. Su ensayo "Beowulf: Los monstruos y los críticos" (1936) estableció que los elementos fantásticos no eran meros adornos, sino el corazón mismo del poema. En sus clases, recitaba pasajes completos en inglés antiguo con tal intensidad que los estudiantes recordaban décadas después el poder de su voz al describir la llegada de Grendel. Como profesor de Lengua y Literatura Inglesa (1945-1959), desarrolló un innovador currículo que integraba filología, historia literaria y apreciación estética, formando generaciones de académicos.
        """.trimIndent()
        )

        // Sección 4: Creación literaria
        ExpandableBiographySection(
            title = "El Arte de la Subcreación",
            quote = """
                "Nadie me cree cuando digo que mi libro largo es un intento de crear un mundo donde una forma de lenguaje coherente sea plausible"
                (Carta a su editor)
            """.trimIndent(),
            content = """
        La génesis de "El Hobbit" ocurrió durante una tediosa sesión de corrección de exámenes en el verano de 1930, cuando Tolkien escribió en un papel en blanco: "En un agujero en el suelo vivía un hobbit". Esta frase espontánea, que inicialmente desarrolló como cuento para sus hijos, se publicaría en 1937 y marcaría el inicio de su carrera como autor de fantasía. El éxito inesperado del libro llevó a su editorial a pedir una secuela, que se convertiría en "El Señor de los Anillos".

        Tolkien abordaba la creación literaria con metodología de filólogo. Su proceso, que denominó "subcreación", comenzaba con el desarrollo de lenguas completas como el quenya (basado en el finés) y el sindarin (inspirado en el galés). A partir de estos sistemas lingüísticos, construía culturas enteras, genealogías y tradiciones históricas, para finalmente componer los relatos que explicaban su evolución. Este enfoque invertido -de la lengua al mito- le permitió crear una profundidad histórica sin precedentes en la literatura fantástica.

        Tras su muerte en 1973, su hijo Christopher dedicó décadas a organizar y publicar el vasto legendarium que Tolkien dejó inédito. "El Silmarillion" (1977) ofreció por primera vez una visión completa de la mitología que subyacía a sus obras más conocidas. Ediciones posteriores como "Los Hijos de Húrin" (2007) y los doce volúmenes de "La Historia de la Tierra Media" revelaron la extraordinaria complejidad de un universo literario cincuenta años en construcción.
            """.trimIndent()
        )

        // Sección 5: Legado
        ExpandableBiographySection(
            title = "El Legado Eterno de la Tierra Media",
            quote = """
                "El círculo se ha cerrado, pero la historia continúa. Todavía hay muchas páginas por leer en el Libro Rojo de la Frontera Occidental"
                (J.R.R. Tolkien)
            """.trimIndent(),
            content = """
        Tras la muerte de Tolkien en 1973, su hijo Christopher asumió la monumental tarea de organizar más de 70 cajas de manuscritos, mapas y notas. Durante 45 años (1975-2020), editó meticulosamente el material inédito, comenzando con "El Silmarillion" (1977) que presentó por primera vez la mitología completa de Arda. La serie "La Historia de la Tierra Media" (12 volúmenes, 1983-1996) reveló el proceso creativo detrás de sus obras, mientras que "Los Hijos de Húrin" (2007) reconstruyó una de sus grandes historias trágicas.

        Su influencia en autores posteriores es incalculable:
        - George R.R. Martin reconoce su deuda con la complejidad política de "El Señor de los Anillos"
        - J.K. Rowling adoptó su enfoque de educación mágica para Harry Potter
        - Ursula K. Le Guin se inspiró en sus sistemas lingüísticos para "Terramar"
        - Terry Pratchett parodió y homenajeó sus obras en "Mundodisco"

        Tolkien recibió numerosos honores:
        - Nombrado Comendador de la Orden del Imperio Británico (1972)
        - Premio Internacional de Fantasía (1957)
        - Premio Locus a mejor obra de fantasía ("El Silmarillion", 1978)
        - Su retrato aparece en billetes de £20 conmemorativos (2016)

        Aspectos específicos de su legado:
        - Lingüístico: Revolucionó el arte de crear lenguas (quenya, sindarin)
        - Literario: Estableció los cánones de la alta fantasía épica
        - Académico: Su ensayo sobre Beowulf sigue siendo lectura obligatoria
        - Cultural: Inspiró géneros como el rol (D&D), música (Led Zeppelin) y arte digital

        Medio siglo después, su obra sigue generando estudios académicos anuales, convenciones internacionales (Tolkien Society) y nuevas adaptaciones (Amazon's "Rings of Power"). La Universidad de Oxford mantiene su archivo personal, visitado por investigadores de todo el mundo, testamento de un legado que sigue creciendo como los árboles de su amada Comarca.
            """.trimIndent()
        )
        ExpandableTimelineSection()
    }
}

@Composable
fun ExpandableTimelineSection() {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        // Encabezado clickeable
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .fillMaxWidth()
                .padding(bottom = if (expanded) 0.dp else 8.dp, top = 8.dp)
        ) {
            Text(
                text = "Cronología",
                color = Golden,
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) "Contraer" else "Expandir",
                tint = Golden
            )
        }

        // Contenido de la línea de tiempo
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            CanvasTimelineSection()
        }

        // Separador
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Golden.copy(alpha = 0.2f))
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun DidYouKnowSection() {
    val facts = listOf(
        Fact(
            "Creó 15 lenguas completas con gramática y vocabulario",
            "Incluyendo quenya, sindarin y khuzdul. El quenya se inspiró en el finés.",
            "https://tolkiengateway.net/wiki/Languages"
        ),
        Fact(
            "Escribió 23 cartas anuales como Papá Noel (1920-1943)",
            "Con ilustraciones y personajes como el Oso Polar y el elfo secretario Ilbereth.",
            "https://es.wikipedia.org/wiki/Las_cartas_de_Pap%C3%A1_Noel"
        ),
        Fact(
            "Gandalf se inspiró en una postal de montaña suiza",
            "Durante un viaje en 1911, vio a un anciano con larga barba blanca y sombrero redondo.",
            "https://lotr.fandom.com/wiki/Gandalf#Inspiration"
        ),
        Fact(
            "Rechazó a los Beatles para la película de El Señor de los Anillos",
            "En 1968, querían interpretar a los protagonistas (Lennon como Gollum).",
            "https://tolkiengateway.net/wiki/The_Lord_of_the_Rings_movies#Earlier_attempts"
        ),
        Fact(
            "Tradujo partes del Libro de Jonás para la Biblia de Jerusalén",
            "Su versión se usó en la edición católica de 1966.",
            "https://tolkiengateway.net/wiki/Bible_translation"
        ),
        Fact(
            "Inventó la palabra 'hobbit' sin saber su origen",
            "Apareció en un examen que corregía: \"En un agujero en el suelo vivía un hobbit\".",
            "https://es.wikipedia.org/wiki/El_Hobbit#Origen"
        ),
        Fact(
            "Fue amigo cercano de C.S. Lewis (autor de Narnia)",
            "Se reunían en el grupo literario \"Los Inklings\" para leer sus obras.",
            "https://tolkiengateway.net/wiki/Inklings"
        ),
        Fact(
            "Luchó en la Batalla del Somme (1916)",
            "Sobrevivió a una de las batallas más sangrientas de la Primera Guerra Mundial, donde perdió a dos amigos íntimos.",
            "https://tolkiengateway.net/wiki/World_War_I"
        )
    )

    var expandedFactIndex by remember { mutableIntStateOf(-1) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "¿Sabías que...?",
            color = Golden,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        facts.forEachIndexed { index, fact ->
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable {
                        expandedFactIndex = if (expandedFactIndex == index) -1 else index
                    },
                colors = CardDefaults.cardColors(
                    containerColor = DarkGray.copy(alpha = 0.2f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = fact.title,
                            color = White,
                            fontSize = 14.sp,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = if (expandedFactIndex == index)
                                Icons.Default.KeyboardArrowUp
                            else
                                Icons.Default.KeyboardArrowDown,
                            contentDescription = if (expandedFactIndex == index)
                                "Mostrar menos"
                            else
                                "Mostrar más",
                            tint = Golden
                        )
                    }

                    AnimatedVisibility(visible = expandedFactIndex == index) {
                        Column(modifier = Modifier.padding(top = 8.dp)) {
                            Text(
                                text = fact.detail,
                                color = LightGray,
                                fontSize = 13.sp,
                                lineHeight = 18.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Fuente: ${fact.source}",
                                color = LightGray.copy(alpha = 0.7f),
                                fontSize = 10.sp,
                                fontStyle = FontStyle.Italic
                            )
                        }
                    }
                }
            }
        }
    }
}

data class Fact(
    val title: String,
    val detail: String,
    val source: String
)

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CanvasTimelineSection() {
    val timelineEvents = listOf(
        TimelineEvent("1892", "Nacimiento", "Bloemfontein, Sudáfrica"),
        TimelineEvent("1896", "Muerte del padre", "Arthur Tolkien fallece en Sudáfrica"),
        TimelineEvent("1904", "Muerte de la madre", "Mabel Tolkien muere de diabetes"),
        TimelineEvent("1911", "Viaje a Suiza", "Inspiración para las Montañas Nubladas"),
        TimelineEvent("1916", "Batalla del Somme", "Sirve como teniente en la WWI"),
        TimelineEvent("1925", "Profesor en Oxford", "Catedrático de anglosajón"),
        TimelineEvent("1937", "Publica 'El Hobbit'", "Ilustrado por el propio Tolkien"),
        TimelineEvent("1954-55", "El Señor de los Anillos", "Publicado en 3 volúmenes"),
        TimelineEvent("1973", "Fallecimiento", "Muere en Bournemouth, Inglaterra")
    )

    val lineColor = Golden
    val pointColor = Golden
    val textColor = White
    val secondaryTextColor = White.copy(alpha = 0.8f)

    Column(modifier = Modifier.padding(vertical = 16.dp)) {

        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth()
        ) {
            val itemHeight = 80.dp
            val lineX = 20.dp
            val pointRadius = 5.dp
            val lineWidth = 2.dp

            // Calculamos la altura total necesaria
            val totalHeight = with(LocalDensity.current) {
                itemHeight.toPx() * timelineEvents.size
            }

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(with(LocalDensity.current) { totalHeight.toDp() })
            ) {
                // Dibujamos la línea vertical principal
                drawLine(
                    color = lineColor.copy(alpha = 0.7f),
                    start = Offset(lineX.toPx(), 0f),
                    end = Offset(lineX.toPx(), size.height),
                    strokeWidth = lineWidth.toPx()
                )

                // Dibujamos los puntos y conectores
                timelineEvents.forEachIndexed { index, _ ->
                    val yPos = itemHeight.toPx() * (index + 0.5f)

                    // Punto principal
                    drawCircle(
                        color = pointColor,
                        radius = pointRadius.toPx(),
                        center = Offset(lineX.toPx(), yPos)
                    )
                }
            }

            // Contenido de texto superpuesto
            Column(modifier = Modifier.padding(start = 40.dp)) {
                timelineEvents.forEach { event ->
                    TimelineTextItem(
                        event = event,
                        height = itemHeight,
                        textColor = textColor,
                        secondaryTextColor = secondaryTextColor
                    )
                }
            }
        }
    }
}

@Composable
private fun TimelineTextItem(
    event: TimelineEvent,
    height: Dp,
    textColor: Color,
    secondaryTextColor: Color
) {
    Column(
        modifier = Modifier
            .height(height)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = event.year,
            color = Golden,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = event.title,
            color = textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
        if (event.description.isNotBlank()) {
            Text(
                text = event.description,
                color = secondaryTextColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

data class TimelineEvent(
    val year: String,
    val title: String,
    val description: String = ""
)


@Composable
fun CompleteWorksSection() {
    val worksCategories = listOf(
        WorksCategory(
            "Obras Publicadas",
            listOf(
                Work(
                    "El Hobbit",
                    "George Allen & Unwin, 21 sep 1937",
                    R.drawable.hobbit_thumb,
                    "Primera edición con ilustraciones del autor. Revisada en 1951."
                ),
                Work(
                    "Egidio, el granjero de Ham",
                    "George Allen & Unwin, oct 1949",
                    R.drawable.farmer_thumb,
                    "Fábula humorística. Versión extendida en 1966."
                ),
                Work(
                    "El Señor de los Anillos",
                    "George Allen & Unwin, 1954-55",
                    R.drawable.lotr_thumb,
                    "Publicado en 3 volúmenes por escasez de papel postguerra."
                ),
                Work(
                    "Las aventuras de Tom Bombadil",
                    "George Allen & Unwin, 22 nov 1962",
                    R.drawable.bombadil_thumb,
                    "16 poemas del 'Libro Rojo'. Incluye ilustraciones de Pauline Baynes."
                ),
                Work(
                    "Árbol y Hoja",
                    "Unwin Books, 28 may 1964",
                    R.drawable.niggle_thumb,
                    "Contiene 'Hoja de Niggle' (1945) y el ensayo 'Sobre los cuentos de hadas'."
                ),
                Work(
                    "El herrero de Wootton Mayor",
                    "George Allen & Unwin, 9 nov 1967",
                    R.drawable.wottoon_thumb,
                    "Última obra publicada en vida. Ilustrada por Pauline Baynes."
                )
            )
        ),
        WorksCategory(
            "Obras Póstumas",
            listOf(
                Work(
                    "El Silmarillion",
                    "George Allen & Unwin, 15 sep 1977",
                    R.drawable.silmarilion_thumb,
                    "Edición de textos incompletos. Primer libro editado por Christopher."
                ),
                Work(
                    "Cuentos inconclusos",
                    "George Allen & Unwin, 2 oct 1980",
                    R.drawable.unfinished_thumb,
                    "Relatos complementarios a El Señor de los Anillos y El Silmarillion."
                ),
                Work(
                    "La Historia de la Tierra Media (12 vols.)",
                    "1983-1996",
                    R.drawable.history_thumb,
                    "Incluye borradores desde 1916 hasta 1950."
                ),
                Work(
                    "Los Hijos de Húrin",
                    "HarperCollins, abr 2007",
                    R.drawable.hurin_thumb,
                    "Versión unificada de la historia de Túrin Turambar."
                ),
                Work(
                    "Beren y Lúthien",
                    "HarperCollins, 2017",
                    R.drawable.beren_thumb,
                    "Incluye versiones en prosa y verso. Ilustrado por Alan Lee."
                ),
                Work(
                    "La Caída de Gondolin",
                    "HarperCollins, 2018",
                    R.drawable.gondolin_thumb,
                    "Última de las 'Grandes Historias'. Ilustraciones de Alan Lee."
                ),
                Work(
                    "Las cartas de Papá Noel",
                    "Houghton Mifflin, 1976 (ed. Baillie Tolkien)",
                    R.drawable.noel_thumb,
                    "Cartas ilustradas a sus hijos (1920-1943)."
                )
            )
        ),
        WorksCategory(
            "Trabajos Académicos",
            listOf(
                Work(
                    "Beowulf: Los monstruos y los críticos",
                    "Oxford, 1936",
                    R.drawable.beowulf_thumb,
                    "Conferencia que revolucionó los estudios anglosajones."
                ),
                Work(
                    "Sir Gawain y el Caballero Verde",
                    "Oxford, 1925 (con E.V. Gordon)",
                    R.drawable.gawain_thumb,
                    "Edición crítica del poema medieval."
                ),
                Work(
                    "La leyenda de Sigurd y Gudrún",
                    "HarperCollins, 2009",
                    R.drawable.sigurd_thumb,
                    "Poemas nórdicos reconstruidos. Editado póstumamente."
                ),
                Work(
                    "Los monstruos y los críticos (ensayos)",
                    "George Allen & Unwin, 1983",
                    R.drawable.monstruos_thumb,
                    "Recopilación de 7 ensayos académicos."
                )
            )
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        CustomTitle(
            text = "Obra de Tolkien",
            fontSize = 24,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            textDecoration = TextDecoration.Underline
        )
        worksCategories.forEach { category ->
            Column(
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(
                    text = category.title,
                    color = Golden.copy(alpha = 0.9f),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    items(category.works) { work ->
                        WorkCard(work) {}
                    }
                }
            }
        }
    }
}

@Composable
private fun WorkCard(work: Work, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp)
            .clickable(onClick = onClick), // Navegación futura
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(work.imageRes),
                contentDescription = "Portada de ${work.title}",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            // Fondo degradado mejorado para legibilidad
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.8f),
                            ),
                            endY = 0.6f
                        )
                    )
            )

            // Contenido textual con padding dinámico
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = work.title,
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = work.year.split(",")[0], // Muestra solo el año si hay editorial
                    color = White.copy(alpha = 0.9f),
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

data class WorksCategory(
    val title: String,
    val works: List<Work>
)

data class Work(
    val title: String,
    val year: String,
    @DrawableRes val imageRes: Int,
    val description: String = ""
)

//@Composable
//fun YouTubeVideosSection() {
//    val videos = listOf(
//        Video(
//            "Biografía de J.R.R. Tolkien",
//            "https://www.youtube.com/watch?v=YofaG5PGcBw",
//            "https://img.youtube.com/vi/YofaG5PGcBw/mqdefault.jpg"
//        ),
//        Video(
//            "El mundo de Tolkien",
//            "https://www.youtube.com/watch?v=G4i2OaZfvJw",
//            "https://img.youtube.com/vi/G4i2OaZfvJw/mqdefault.jpg"
//        ),
//        Video(
//            "Las lenguas de la Tierra Media",
//            "https://www.youtube.com/watch?v=5fK3h2FgwO8",
//            "https://img.youtube.com/vi/5fK3h2FgwO8/mqdefault.jpg"
//        )
//    )
//
//    Column(modifier = Modifier.padding(vertical = 16.dp)) {
//        Text(
//            text = "Videos Recomendados",
//            color = Golden,
//            fontSize = 24.sp,
//            fontFamily = FontFamily(Font(R.font.ring_bearer_medium)),
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        LazyRow(
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            items(videos) { video ->
//                YouTubeVideoCard(video)
//            }
//        }
//    }
//}
//
//@Composable
//fun YouTubeVideoCard(video: Video) {
//    var showDialog by remember { mutableStateOf(false) }
//
//    Card(
//        modifier = Modifier
//            .width(220.dp)
//            .clickable { showDialog = true },
//        shape = RoundedCornerShape(8.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column {
//            // Usar Coil para cargar la imagen
//            AsyncImage(
//                model = video.thumbnailUrl,
//                contentDescription = video.title,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(120.dp),
//                contentScale = ContentScale.Crop
//            )
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(120.dp)
//                    .background(Color.Black.copy(alpha = 0.5f))
//                    .padding(8.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    imageVector = Icons.Default.PlayArrow,
//                    contentDescription = "Reproducir",
//                    tint = Color.White,
//                    modifier = Modifier.size(48.dp)
//                )
//            }
//
//            Text(
//                text = video.title,
//                color = Color.White,
//                fontSize = 14.sp,
//                modifier = Modifier.padding(8.dp),
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//    }
//
//    if (showDialog) {
//        AlertDialog(
//            onDismissRequest = { showDialog = false },
//            title = { Text("Reproducir video") },
//            text = { Text("¿Deseas ver este video en YouTube?") },
//            confirmButton = {
//                TextButton(
//                    onClick = {
//                        showDialog = false
//                        // Implementar la lógica para abrir el video
//                        // val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
//                        // context.startActivity(intent)
//                    }
//                ) {
//                    Text("Abrir YouTube")
//                }
//            },
//            dismissButton = {
//                TextButton(onClick = { showDialog = false }) {
//                    Text("Cancelar")
//                }
//            }
//        )
//    }
//}
//
//data class Video(val title: String, val url: String, val thumbnailUrl: String)
