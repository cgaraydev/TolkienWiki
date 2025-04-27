package com.cgaraydev.tolkienapp.data.local.datalocal

import androidx.annotation.DrawableRes
import com.cgaraydev.tolkienapp.R

data class RaceData(
    val id: String,
    val name: String,
    @DrawableRes
    val imageRes: Int,
    val tags: List<String>? = emptyList()
)

val racesList = listOf(
    RaceData("0", "Águilas", R.drawable.eagles,
        tags = listOf(
            "eagles",
        )),
    RaceData("1", "Ainur", R.drawable.ainur,
        tags = listOf(
            "ainur",
        )),
    RaceData("2", "Arañas", R.drawable.spiders,
        tags = listOf(
            "spiders",
        )),
    RaceData("3", "Balrogs", R.drawable.balrogs,
        tags = listOf(
            "balrogs",
        )),
    RaceData("4", "Dragones", R.drawable.dragons,
        tags = listOf(
            "dragons",
        )),
    RaceData("5", "Elfos", R.drawable.elves,
        tags = listOf(
            "elves",
        )),
    RaceData("6", "Enanos", R.drawable.dwarves,
        tags = listOf(
            "dwarves",
        )),
    RaceData("7", "Ents", R.drawable.ents,
        tags = listOf(
            "ents",
        )),
    RaceData("8", "Hobbits", R.drawable.hobbits,
        tags = listOf(
            "hobbits",
        )),
    RaceData("9", "Hombres", R.drawable.men,
        tags = listOf(
            "men",
        )),
    RaceData("10", "Huargos", R.drawable.wargs,
        tags = listOf(
            "wargs",
        )),
    RaceData("11", "Licántropos", R.drawable.werewolves,
        tags = listOf(
            "werewolves",
        )),
    RaceData("12", "Nazgûl", R.drawable.nazgul,
        tags = listOf(
            "nazgul",
        )),
    RaceData("13", "Orcos", R.drawable.orcs,
        tags = listOf(
            "orcs",
        )),
    RaceData("14", "Trolls", R.drawable.trolls,
        tags = listOf(
            "trolls",
        )),
    RaceData("15", "Ucornos", R.drawable.huorns,
        tags = listOf(
            "huorns",
        ))
)