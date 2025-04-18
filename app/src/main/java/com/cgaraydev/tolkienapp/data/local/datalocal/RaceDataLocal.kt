package com.cgaraydev.tolkienapp.data.local.datalocal

import androidx.annotation.DrawableRes
import com.cgaraydev.tolkienapp.R

data class RaceData(
    val id: String,
    val name: String,
    @DrawableRes
    val imageRes: Int
)

val racesList = listOf(
    RaceData("0", "Águilas", R.drawable.eagles),
    RaceData("1", "Ainur", R.drawable.ainur),
    RaceData("2", "Arañas", R.drawable.spiders),
    RaceData("3", "Balrogs", R.drawable.balrogs),
    RaceData("4", "Dragones", R.drawable.dragons),
    RaceData("5", "Elfos", R.drawable.elves),
    RaceData("6", "Enanos", R.drawable.dwarves),
    RaceData("7", "Ents", R.drawable.ents),
    RaceData("8", "Hobbits", R.drawable.hobbits),
    RaceData("9", "Hombres", R.drawable.men),
    RaceData("10", "Huargos", R.drawable.wargs),
    RaceData("11", "Licántropos", R.drawable.werewolves),
    RaceData("12", "Nazgûl", R.drawable.nazgul),
    RaceData("13", "Orcos", R.drawable.orcs),
    RaceData("14", "Trolls", R.drawable.trolls),
    RaceData("15", "Ucornos", R.drawable.huorns)
)