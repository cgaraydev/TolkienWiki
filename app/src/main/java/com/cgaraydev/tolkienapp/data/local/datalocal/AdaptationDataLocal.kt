package com.cgaraydev.tolkienapp.data.local.datalocal

import androidx.annotation.DrawableRes
import com.cgaraydev.tolkienapp.R

data class AdaptationData(
    val id: String,
    val name: String,
    @DrawableRes val imageRes: Int,
    val tags: List<String>,
)

val adaptationTags = listOf(
    AdaptationData(
        id = "0",
        name = "La Comunidad del Anillo",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la comunidad del anillo",
            "el señor de los anillos la comunidad del anillo",
            "the_fellowship_of_the_ring",
            "the_lord_of_the_rings_film_series",
            "movies",
            "adaptations",
            "2001",
            "live_action"
        )
    ),
    AdaptationData(
        id = "1",
        name = "Las Dos Torres",
        imageRes = R.drawable.logo,
        tags = listOf(
            "las dos torres",
            "el señor de los anillos las dos torres",
            "the_two_towers",
            "the_lord_of_the_rings_film_series",
            "movies",
            "adaptations",
            "2002",
            "live_action"
        )
    ),
    AdaptationData(
        id = "2",
        name = "El Retorno del Rey",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el retorno del rey",
            "el señor de los anillos el retorno del rey",
            "the_return_of_the_king",
            "the_lord_of_the_rings_film_series",
            "movies",
            "adaptations",
            "2003",
            "live_action"
        )
    ),
    AdaptationData(
        id = "3",
        name = "Un Viaje Inesperado",
        imageRes = R.drawable.logo,
        tags = listOf(
            "un viaje inesperado",
            "el hobbit un viaje inesperado",
            "an_unexpected_journey",
            "the_hobbit_film_series",
            "movies",
            "adaptations",
            "2012",
            "live_action"
        )
    ),
    AdaptationData(
        id = "4",
        name = "La Desolación de Smaug",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la desolacion de smaug",
            "el hobbit la desolacion de smaug",
            "the_desolation_of_smaug",
            "the_hobbit_film_series",
            "movies",
            "adaptations",
            "2013",
            "live_action"
        )
    ),
    AdaptationData(
        id = "5",
        name = "La Batalla de los Cinco Ejércitos",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la batalla de los cinco ejércitos",
            "el hobbit la batalla de los cinco ejércitos",
            "the_battle_of_the_five_armies",
            "the_hobbit_film_series",
            "movies",
            "adaptations",
            "2014",
            "live_action"
        )
    ),
    AdaptationData(
        id = "6",
        name = "El Hobbit (1977)",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el hobbit 1977",
            "the_hobbit_1977",
            "rankin_bass",
            "movies",
            "adaptations",
            "animated",
            "1977"
        )
    ),
    AdaptationData(
        id = "7",
        name = "El Señor de los Anillos (1978)",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos 1978",
            "the_lord_of_the_rings_1978",
            "bakshi",
            "movies",
            "adaptations",
            "animated",
            "1978"
        )
    ),
    AdaptationData(
        id = "8",
        name = "El Retorno del Rey (1980)",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el retorno del rey 1980",
            "the_return_of_the_king_1980",
            "rankin_bass",
            "movies",
            "adaptations",
            "animated",
            "1980"
        )
    ),
    AdaptationData(
        id = "9",
        name = "La Guerra de los Rohirrim",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la guerra de los rohirrim",
            "the_war_of_the_rohirrim",
            "movies",
            "adaptations",
            "animated",
            "2024"
        )
    ),
    AdaptationData(
        id = "10",
        name = "Los Anillos de Poder",
        imageRes = R.drawable.logo,
        tags = listOf(
            "los anillos de poder",
            "tv_series",
            "the_rings_of_power",
            "2022",
            "adaptations",
            "live_action"
        )
    ),
    AdaptationData(
        id = "11",
        name = "La Caza de Gollum (Fan Film)",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la caza de gollum",
            "the_hunt_for_gollum",
            "movies",
            "adaptations",
            "live_action",
            "fan_film",
            "2009"
        )
    ),
    AdaptationData(
        id = "12",
        name = "Nacido de la esperanza (Fan Film)",
        imageRes = R.drawable.logo,
        tags = listOf(
            "nacido de la esperanza",
            "born_of_hope",
            "movies",
            "adaptations",
            "live_action",
            "fan_film",
            "2009"
        )
    ),
    AdaptationData(
        id = "13",
        name = "Hobitit",
        imageRes = R.drawable.logo,
        tags = listOf(
            "hobitit",
            "tv_series",
            "adaptations",
            "live_action",
            "1993"
        )
    )
)

