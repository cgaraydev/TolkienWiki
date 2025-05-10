package com.cgaraydev.tolkienapp.presentation.tolkien

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.presentation.components.CustomDivider
import com.cgaraydev.tolkienapp.presentation.components.CustomHeightSpacer
import com.cgaraydev.tolkienapp.presentation.components.CustomTitle

data class YouTubeMediaItem(
    val title: String,
    val videoUrl: String,
    val description: String = ""
)

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

data class TimelineEvent(
    val year: String,
    val title: String,
    val description: String = ""
)

val tolkienVideos = listOf(
    YouTubeMediaItem(
        "La vida de J.R.R. Tolkien por Kai47",
        "https://www.youtube.com/watch?v=2dJwHlVYAb0&ab_channel=Kai47",
    ),
    YouTubeMediaItem(
        "J. R. R. Tolkien (I): entre la muerte y la esperanza",
        "https://www.youtube.com/watch?v=EYkjOx5buyE&ab_channel=Fundaci%C3%B3nJuanMarch"
    ),
    YouTubeMediaItem(
        "J. R. R. Tolkien (II): invención y realidad",
        "https://www.youtube.com/watch?v=pdkNvY6pgjI&ab_channel=Fundaci%C3%B3nJuanMarch"
    ),
    YouTubeMediaItem(
        "J.R.R. Tolkien: El Creador del Señor de los Anillos (Documental)",
        "https://www.youtube.com/watch?v=2GAfJ91RE04&ab_channel=BiografiasdeAutores"
    ),
    YouTubeMediaItem(
        "JRR Tolkien - All VIDEO interview compilation - CleanCut",
        "https://www.youtube.com/watch?v=NTz2-im7s9k&t=1s&ab_channel=TalkingAboutTolkien",
    )
)

@Composable
fun TolkienBiographyData() {

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
}

@Composable
fun TolkienIntroductionData() {
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

@Composable
fun TolkienBioData() {
    val uriHandler = LocalUriHandler.current
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
    CustomHeightSpacer(12)
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

val tolkienTimeline = listOf(
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

val tolkienWorks = listOf(
    WorksCategory(
        "Obras Publicadas",
        listOf(
            Work(
                "El Hobbit",
                "George Allen & Unwin, 21 sep 1937",
                R.drawable.thumb_hobbit,
                "Primera edición con ilustraciones del autor. Revisada en 1951."
            ),
            Work(
                "Egidio, el granjero de Ham",
                "George Allen & Unwin, oct 1949",
                R.drawable.thumb_farmer,
                "Fábula humorística. Versión extendida en 1966."
            ),
            Work(
                "El Señor de los Anillos",
                "George Allen & Unwin, 1954-55",
                R.drawable.thumb_lotr,
                "Publicado en 3 volúmenes por escasez de papel postguerra."
            ),
            Work(
                "Las aventuras de Tom Bombadil",
                "George Allen & Unwin, 22 nov 1962",
                R.drawable.thumb_bombadil,
                "16 poemas del 'Libro Rojo'. Incluye ilustraciones de Pauline Baynes."
            ),
            Work(
                "Árbol y Hoja",
                "Unwin Books, 28 may 1964",
                R.drawable.thumb_niggle,
                "Contiene 'Hoja de Niggle' (1945) y el ensayo 'Sobre los cuentos de hadas'."
            ),
            Work(
                "El herrero de Wootton Mayor",
                "George Allen & Unwin, 9 nov 1967",
                R.drawable.thumb_wottoon,
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
                R.drawable.thumb_silmarilion,
                "Edición de textos incompletos. Primer libro editado por Christopher."
            ),
            Work(
                "Cuentos inconclusos",
                "George Allen & Unwin, 2 oct 1980",
                R.drawable.thumb_unfinished,
                "Relatos complementarios a El Señor de los Anillos y El Silmarillion."
            ),
            Work(
                "La Historia de la Tierra Media (12 vols.)",
                "1983-1996",
                R.drawable.thumb_history,
                "Incluye borradores desde 1916 hasta 1950."
            ),
            Work(
                "Los Hijos de Húrin",
                "HarperCollins, abr 2007",
                R.drawable.thumb_hurin,
                "Versión unificada de la historia de Túrin Turambar."
            ),
            Work(
                "Beren y Lúthien",
                "HarperCollins, 2017",
                R.drawable.thumb_beren,
                "Incluye versiones en prosa y verso. Ilustrado por Alan Lee."
            ),
            Work(
                "La Caída de Gondolin",
                "HarperCollins, 2018",
                R.drawable.thumb_gondolin,
                "Última de las 'Grandes Historias'. Ilustraciones de Alan Lee."
            ),
            Work(
                "Las cartas de Papá Noel",
                "Houghton Mifflin, 1976 (ed. Baillie Tolkien)",
                R.drawable.thumb_noel,
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
                R.drawable.thumb_beowulf,
                "Conferencia que revolucionó los estudios anglosajones."
            ),
            Work(
                "Sir Gawain y el Caballero Verde",
                "Oxford, 1925 (con E.V. Gordon)",
                R.drawable.thumb_gawain,
                "Edición crítica del poema medieval."
            ),
            Work(
                "La leyenda de Sigurd y Gudrún",
                "HarperCollins, 2009",
                R.drawable.thumb_sigurd,
                "Poemas nórdicos reconstruidos. Editado póstumamente."
            ),
            Work(
                "Los monstruos y los críticos (ensayos)",
                "George Allen & Unwin, 1983",
                R.drawable.thumb_monstruos,
                "Recopilación de 7 ensayos académicos."
            )
        )
    )
)