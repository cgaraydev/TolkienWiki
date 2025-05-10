package com.cgaraydev.tolkienapp.data.local.datalocal

import androidx.annotation.DrawableRes
import com.cgaraydev.tolkienapp.R

data class GameData(
    val id: String,
    val name: String,
    @DrawableRes val imageRes: Int,
    val tags: List<String>,
)

val gameTags = listOf(
    GameData(
        id = "0",
        name = "La Comunidad del Anillo",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos la comunidad del anillo 2002",
            "the_lord_of_the_rings_the_fellowship_of_the_ring_2002",
            "videogames",
            "games",
            "2002",
            "game_boy",
            "playstation",
            "xbox",
            "pc",
            "action",
            "adventure"
        )
    ),
    GameData(
        id = "1",
        name = "La Guerra del Anillo",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos la guerra del anillo 2003",
            "the_lord_of_the_rings_war_of_the_ring_2003",
            "videogames",
            "games",
            "2003",
            "pc",
            "strategy"
        )
    ),
    GameData(
        id = "2",
        name = "El hobbit",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el hobbit 2003",
            "the_hobbit_2003",
            "videogames",
            "games",
            "2003",
            "gamecube",
            "adventure",
            "playstation",
            "platforms",
            "pc",
            "game_boy",
            "xbox"
        )
    ),
    GameData(
        id = "3",
        name = "War in Middle Earth",
        imageRes = R.drawable.logo,
        tags = listOf(
            "war in middle earth",
            "games",
            "videogames",
            "strategy",
            "1988",
            "other_platforms"
        )
    ),
    GameData(
        id = "4",
        name = "The Hobbit (1982)",
        imageRes = R.drawable.logo,
        tags = listOf(
            "the_hobbit_1982",
            "el hobbit 1982",
            "videogames",
            "games",
            "1982",
            "adventure",
            "text_adventure",
            "other_platforms"
        )
    ),
    GameData(
        id = "5",
        name = "El Señor de los Anillos: Game One",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos game one",
            "the_lord_of_the_rings_game_one",
            "videogames",
            "games",
            "1985",
            "adventure",
            "text_adventure",
            "other_platforms"
        )
    ),
    GameData(
        id = "6",
        name = "Shadows of Mordor",
        imageRes = R.drawable.logo,
        tags = listOf(
            "shadows of mordor",
            "videogames",
            "games",
            "1987",
            "adventure",
            "text_adventure",
            "other_platforms"
        )
    ),
    GameData(
        id = "7",
        name = "The Lord of the Rings, Vol. I",
        imageRes = R.drawable.logo,
        tags = listOf(
            "the lord of the rings vol i",
            "videogames",
            "games",
            "1990",
            "adventure",
            "rpg",
            "other_platforms"
        )
    ),
    GameData(
        id = "8",
        name = "J. R. R. Tolkien's Riders of Rohan",
        imageRes = R.drawable.logo,
        tags = listOf(
            "riders of rohan",
            "videogames",
            "games",
            "other_platforms",
            "strategy",
            "1991"
        )
    ),
    GameData(
        id = "9",
        name = "The Lord of the Rings, Vol. II: The Two Towers",
        imageRes = R.drawable.logo,
        tags = listOf(
            "the lord of the rings vol ii",
            "videogames",
            "games",
            "1990",
            "adventure",
            "rpg",
            "other_platforms"
        )
    ),
    GameData(
        id = "10",
        name = "The Lord of the Rings Online",
        imageRes = R.drawable.logo,
        tags = listOf(
            "the lord of the rings online",
            "2007",
            "games",
            "videogames",
            "mmorpg",
            "pc"
        )
    ),
    GameData(
        id = "11",
        name = "The Lord of the Rings: The Card Game",
        imageRes = R.drawable.logo,
        tags = listOf(
            "the lord of the rings card game",
            "card_games",
            "games",
            "2011"
        )
    ),
    GameData(
        id = "12",
        name = "El Señor de los Anillos: Gollum",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos gollum",
            "games",
            "videogames",
            "2023",
            "action",
            "adventure",
            "playstation",
            "xbox",
            "pc",
            "nintendo_switch"
        )
    ),
    GameData(
        id = "13",
        name = "The Lord of the Rings: Return to Moria",
        imageRes = R.drawable.logo,
        tags = listOf(
            "the lord of the rings return to moria",
            "games",
            "videogames",
            "pc",
            "playstation",
            "xbox",
            "survival",
            "construction",
            "2023"
        )
    ),
    GameData(
        id = "14",
        name = "El Señor de los Anillos: Las Dos torres",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos las dos torres",
            "games",
            "videogames",
            "action",
            "hack_and_slash",
            "2002",
            "playstation",
            "gamecube",
            "xbox",
            "game_boy",
            "pc",
            "mac"
        )
    ),
    GameData(
        id = "15",
        name = "El Señor de los Anillos: El Retorno del Rey",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos el retorno del rey",
            "games",
            "videogames",
            "action",
            "hack_and_slash",
            "2003",
            "playstation",
            "gamecube",
            "xbox",
            "game_boy",
            "pc",
            "mac"
        )
    ),
    GameData(
        id = "16",
        name = "El Señor de los Anillos: la Tercera Edad",
        imageRes = R.drawable.logo,
        tags = listOf(
            "el señor de los anillos la tercera edad",
            "games",
            "videogames",
            "rpg",
            "2004",
            "playstation",
            "gamecube",
            "xbox",
            "game_boy"
        )
    ),
    GameData(
        id = "17",
        name = "El Señor de los Anillos: La Batalla por la Tierra Media",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la batalla por la tierra media",
            "the_battle_for_middle_earth",
            "videogames",
            "games",
            "strategy",
            "2004",
            "pc"
        )
    ),
    GameData(
        id = "18",
        name = "The Lord of the Rings: Tactics",
        imageRes = R.drawable.logo,
        tags = listOf(
            "tactics",
            "the_lord_of_the_rings_tactics",
            "games",
            "videogames",
            "2005",
            "playstation",
            "rpg"
        )
    ),
    GameData(
        id = "19",
        name = "El Señor de los Anillos: La Batalla por la Tierra Media II",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la batalla por la tierra media",
            "the_battle_for_middle_earth",
            "games",
            "videogames",
            "strategy",
            "2006",
            "pc",
            "xbox"
        )
    ),
    GameData(
        id = "20",
        name = "El Señor de los Anillos: la conquista",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la conquista",
            "the_lord_of_the_rings_conquest",
            "2009",
            "games",
            "videogames",
            "action",
            "adventure",
            "pc",
            "xbox",
            "playstation",
            "nintendo"
        )
    ),
    GameData(
        id = "21",
        name = "El Señor de los Anillos: las aventuras de Aragorn",
        imageRes = R.drawable.logo,
        tags = listOf(
            "las aventuras de aragorn",
            "the_adventures_of_aragorn",
            "videogames",
            "games",
            "2010",
            "action",
            "adventure",
            "nintendo",
            "playstation"
        )
    ),
    GameData(
        id = "22",
        name = "El Señor de los Anillos: la guerra del norte",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la guerra del norte",
            "war_in_the_north",
            "2011",
            "games",
            "videogames",
            "action",
            "rpg",
            "playstation",
            "xbox",
            "pc",
            "mac"
        )
    ),
    GameData(
        id = "23",
        name = "Guardianes de la Tierra Media",
        imageRes = R.drawable.logo,
        tags = listOf(
            "guardianes de la tierra media",
            "guardians_of_middle_earth",
            "games",
            "videogames",
            "2012",
            "mmo",
            "playstation",
            "xbox",
            "pc"
        )
    ),
    GameData(
        id = "24",
        name = "Lego El Señor de los Anillos",
        imageRes = R.drawable.logo,
        tags = listOf(
            "lego el señor de los anillos",
            "lego_the_lord_of_the_rings",
            "games",
            "videogames",
            "2012",
            "action",
            "adventure",
            "playstation",
            "xbox",
            "nintendo",
            "pc",
            "mobile",
            "mac"
        )
    ),
    GameData(
        id = "25",
        name = "Lego El hobbit",
        imageRes = R.drawable.logo,
        tags = listOf(
            "lego el hobbit",
            "lego_the_hobbit",
            "games",
            "videogames",
            "action",
            "adventure",
            "2014",
            "playstation",
            "xbox",
            "pc",
            "mac",
            "nintendo"
        )
    ),
    GameData(
        id = "26",
        name = "La Tierra Media: Sombras de Mordor",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la tierra media sombras de mordor",
            "middle_earth_shadow_of_mordor",
            "games",
            "videogames",
            "2014",
            "rpg",
            "action",
            "adventure",
            "playstation",
            "xbox",
            "pc"
        )
    ),
    GameData(
        id = "27",
        name = "La Tierra Media: Sombras de Guerra",
        imageRes = R.drawable.logo,
        tags = listOf(
            "la tierra media sombras de guerra",
            "middle_earth_shadow_of_war",
            "2017",
            "games",
            "videogames",
            "pc",
            "playstation",
            "xbox",
            "action",
            "adventure",
            "rpg"
        )
    )
)