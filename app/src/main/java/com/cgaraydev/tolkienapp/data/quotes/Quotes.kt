package com.cgaraydev.tolkienapp.data.quotes

data class Quote(
    val text: String,
    val character: String
)

val tolkienQuotes = listOf(
    Quote("No todos los que vagan están perdidos.", "J.R.R. Tolkien"),
    Quote("Incluso la persona más pequeña puede cambiar el curso del futuro.", "Galadriel"),
    Quote("Un mago nunca llega tarde, ni pronto, llega exactamente cuando se lo propone.", "Gandalf"),
    Quote("Preferiría compartir una vida contigo que enfrentar todas las edades de este mundo sola.", "Arwen"),
    Quote("La muerte es solo otro camino, uno que todos debemos tomar.", "Gandalf"),
    Quote("Infiel es el que se despide cuando el camino se oscurece.", "Gimli"),
    Quote("No hay que apresurarse a juzgar a los demás, porque incluso los más sabios pueden equivocarse.", "Gandalf"),
    Quote("El corazón del hombre es más resistente de lo que él se imagina.", "Fëanor"),
    Quote("El destino es el camino que no se elige.", "Eru Ilúvatar"),
    Quote("La música es el lenguaje del alma.", "Lúthien"),
    Quote("El mundo está lleno de cosas bellas, pero a veces hay que buscarlas en lugares oscuros.", "Tuor"),
    Quote("Un hogar es donde está el corazón.", "Bilbo"),
    Quote("La justicia debe prevalecer, incluso en los tiempos más oscuros.", "Manwë"),
    Quote("La belleza es una luz en la oscuridad.", "Eärendil")
)