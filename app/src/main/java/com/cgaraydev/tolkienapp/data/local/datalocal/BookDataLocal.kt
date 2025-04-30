package com.cgaraydev.tolkienapp.data.local.datalocal

import androidx.annotation.DrawableRes
import com.cgaraydev.tolkienapp.R

data class BookData(
    val id: String,
    val title: String,
    @DrawableRes val imageRes: Int,
    val tags: List<String>,
)

val bookTags = listOf(
    BookData(
        id = "0",
        title = "El Hobbit",
        imageRes = R.drawable.thumb_hobbit,
        tags = listOf(
            "the_hobbit",
            "el hobbit",
            "books",
            "tolkien_works",
            "novels",
            "featured",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "book_on_arda"
        )
    ),
    BookData(
        id = "1",
        title = "El Señor de los Anillos",
        imageRes = R.drawable.thumb_lotr,
        tags = listOf(
            "el señor de los anillos",
            "the_lord_of_the_rings",
            "books",
            "tolkien_works",
            "featured",
            "legendarium",
            "novels",
            "fantasy",
            "allen_and_unwin",
            "book_on_arda"
        )
    ),
    BookData(
        id = "2",
        title = "El Silmarillion",
        imageRes = R.drawable.thumb_silmarilion,
        tags = listOf(
            "el silmarillion",
            "the_silmarillion",
            "books",
            "tolkien_works",
            "featured",
            "legendarium",
            "novels",
            "fantasy",
            "allen_and_unwin",
            "book_on_arda"
        )
    ),
    BookData(
        id = "3",
        title = "Cuentos Inconclusos de Númenor y la Tierra Media",
        imageRes = R.drawable.thumb_unfinished,
        tags = listOf(
            "cuentos inconclusos de numenor y la tierra media",
            "unfinished_tales",
            "books",
            "fantasy",
            "featured",
            "legendarium",
            "tales",
            "posthumous",
            "edited_by_christopher_tolkien",
            "allen_and_unwin",
            "tolkien_works",
            "book_on_arda"
        )
    ),
    BookData(
        id = "4",
        title = "Los Hijos de Húrin",
        imageRes = R.drawable.thumb_hurin,
        tags = listOf(
            "los hijos de hurin",
            "the_children_of_hurin",
            "books",
            "tolkien_works",
            "edited_by_christopher_tolkien",
            "posthumous",
            "fantasy",
            "legendarium",
            "harper_collins",
            "featured",
            "tales",
            "book_on_arda"
        )
    ),
    BookData(
        id = "5",
        title = "Beren y Lúthien",
        imageRes = R.drawable.thumb_beren,
        tags = listOf(
            "beren y luthien",
            "beren_and_luthien",
            "books",
            "tales",
            "featured",
            "fantasy",
            "tolkien_works",
            "harper_collins",
            "posthumous",
            "legendarium",
            "edited_by_christopher_tolkien",
            "book_on_arda"
        )
    ),
    BookData(
        id = "6",
        title = "La Caída de Gondolin",
        imageRes = R.drawable.thumb_gondolin,
        tags = listOf(
            "la caida de gondolin",
            "the_fall_of_gondolin",
            "books",
            "tolkien_works",
            "edited_by_christopher_tolkien",
            "harper_collins",
            "posthumous",
            "fantasy",
            "featured",
            "legendarium",
            "tales",
            "book_on_arda"
        )
    ),
    BookData(
        id = "7",
        title = "La Naturaleza de la Tierra Media",
        imageRes = R.drawable.thumb_nature,
        tags = listOf(
            "la naturaleza de la tierra media",
            "the_nature_of_middle_earth",
            "books",
            "posthumous",
            "tolkien_works",
            "edited_by_others",
            "legendarium",
            "harper_collins",
            "fantasy",
            "book_on_arda"
        )
    ),
    BookData(
        id = "8",
        title = "La Caída de Númenor",
        imageRes = R.drawable.thumb_numenor,
        tags = listOf(
            "la caida de numenor",
            "the_fall_of_numenor",
            "books",
            "tolkien_works",
            "edited_by_others",
            "legendarium",
            "harper_collins",
            "fantasy",
            "posthumous",
            "book_on_arda"
        )
    ),
    BookData(
        id = "9",
        title = "El libro de los cuentos perdidos 1",
        imageRes = R.drawable.thumb_unfinished1,
        tags = listOf(
            "el libro de los cuentos perdidos",
            "the_book_of_lost_tales",
            "book_on_arda",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "10",
        title = "El libro de los cuentos perdidos 2",
        imageRes = R.drawable.thumb_unfinished2,
        tags = listOf(
            "el libro de los cuentos perdidos",
            "the_book_of_lost_tales",
            "book_on_arda",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "11",
        title = "Las baladas de Beleriand",
        imageRes = R.drawable.thumb_beleriand_map,
        tags = listOf(
            "las baladas de beleriand",
            "the_lays_of_beleriand",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "12",
        title = "La Formación de la Tierra Media",
        imageRes = R.drawable.thumb_shaping,
        tags = listOf(
            "la formacion de la tierra media",
            "the_shaping_of_middle_earth",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "13",
        title = "El Camino Perdido y Otros Escritos",
        imageRes = R.drawable.thumb_lost,
        tags = listOf(
            "el camino perdido y otros escritos",
            "the_lost_road_and_other_writings",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "14",
        title = "El Retorno de la Sombra",
        imageRes = R.drawable.thumb_shadow,
        tags = listOf(
            "el retorno de la sombra",
            "the_return_of_the_shadow",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_the_lord_of_the_rings"
        )
    ),
    BookData(
        id = "15",
        title = "La Traición de Isengard",
        imageRes = R.drawable.thumb_treason,
        tags = listOf(
            "la traicion de isengard",
            "the_treason_of_isengard",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_the_lord_of_the_rings"
        )
    ),
    BookData(
        id = "16",
        title = "La Guerra del Anillo",
        imageRes = R.drawable.thumb_war,
        tags = listOf(
            "la guerra del anillo",
            "The War of the Ring",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_the_lord_of_the_rings"
        )
    ),
    BookData(
        id = "17",
        title = "El Fin de la Tercera Edad",
        imageRes = R.drawable.thumb_end,
        tags = listOf(
            "el fin de la tercera edad",
            "the_end_of_the_third_age",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_the_lord_of_the_rings"
        )
    ),
    BookData(
        id = "18",
        title = "La Caída de Númenor",
        imageRes = R.drawable.thumb_numenor2,
        tags = listOf(
            "la caida de numenor",
            "the_fall_of_numenor",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "19",
        title = "El Anillo de Morgoth",
        imageRes = R.drawable.thumb_morgoth,
        tags = listOf(
            "el anillo de morgoth",
            "morgoths_ring",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "20",
        title = "La Guerra de las Joyas",
        imageRes = R.drawable.thumb_jewels,
        tags = listOf(
            "la guerra de las joyas",
            "the_war_of_the_jewels",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "21",
        title = "Los Pueblos de la Tierra Media",
        imageRes = R.drawable.thumb_people,
        tags = listOf(
            "los pueblos de la tierra media",
            "the_peoples_of_middle_earth",
            "books",
            "edited_by_christopher_tolkien",
            "tolkien_works",
            "legendarium",
            "fantasy",
            "allen_and_unwin",
            "posthumous",
            "the_history_of_middle_earth"
        )
    ),
    BookData(
        id = "22",
        title = "Hoja de Niggle",
        imageRes = R.drawable.thumb_leaf,
        tags = listOf(
            "hoja de niggle",
            "leaf_by_niggle",
            "tolkien_works",
            "short_stories",
            "fantasy",
            "not_on_arda",
            "books",
            "harper_collins"
        )
    ),
    BookData(
        id = "23",
        title = "Egidio, el granjero de Ham",
        imageRes = R.drawable.thumb_farmer,
        tags = listOf(
            "egidio el granjero de ham",
            "farmer_giles_of_ham",
            "tolkien_works",
            "short_stories",
            "fantasy",
            "not_on_arda",
            "books",
            "allen_and_unwin"
        )
    ),
    BookData(
        id = "24",
        title = "Las Aventuras de Tom Bombadil",
        imageRes = R.drawable.thumb_bombadil,
        tags = listOf(
            "las aventuras de tom bombadil",
            "the_adventures_of_tom_bombadil",
            "tolkien_works",
            "poems",
            "fantasy",
            "book_on_arda",
            "legendarium",
            "books",
            "allen_and_unwin"
        )
    ),
    BookData(
        id = "25",
        title = "Árbol y Hoja",
        imageRes = R.drawable.thumb_niggle,
        tags = listOf(
            "arbol y hoja",
            "tree_and_leaf",
            "books",
            "fantasy",
            "collection",
            "tolkien_works",
            "not_on_arda",
            "allen_and_unwin"
        )
    ),
    BookData(
        id = "26",
        title = "El Herrero de Wootton Mayor",
        imageRes = R.drawable.thumb_wottoon,
        tags = listOf(
            "el herrero de Wootton Mayor",
            "smith_of_wootton_major",
            "books",
            "tolkien_works",
            "not_on_arda",
            "allen_and_unwin",
            "fantasy",
            "tales",
            "short_stories"
        )
    ),
    BookData(
        id = "27",
        title = "La última canción de Bilbo",
        imageRes = R.drawable.thumb_song,
        tags = listOf(
            "la ultima cancion de bilbo",
            "bilbos_last_song",
            "book_on_arda",
            "books",
            "poems",
            "fantasy",
            "legendarium",
            "tolkien_works"
        )
    ),
    BookData(
        id = "28",
        title = "Cartas de Papá Noel",
        imageRes = R.drawable.thumb_noel,
        tags = listOf(
            "cartas de papa noel",
            "letters_from_father_christmas",
            "books",
            "not_on_arda",
            "letters",
            "allen_and_unwin",
            "tolkien_works",
            "posthumous",
            "short_stories"
        )
    ),
    BookData(
        id = "29",
        title = "Señor Bliss",
        imageRes = R.drawable.thumb_bliss,
        tags = listOf(
            "señor bliss",
            "mr_bliss",
            "books",
            "short_stories",
            "not_on_arda",
            "posthumous",
            "tolkien_works",
            "allen_and_unwin"
        )
    ),
    BookData(
        id = "30",
        title = "Cuentos desde el Reino Peligroso",
        imageRes = R.drawable.thumb_realm,
        tags = listOf(
            "cuentos desde el reino peligroso",
            "tales from the perilous realm",
            "books",
            "tolkien_works",
            "posthumous",
            "tales",
            "harper_collins",
            "short_stories"
        )
    ),
    BookData(
        id = "31",
        title = "Roverandom",
        imageRes = R.drawable.thumb_roverandom,
        tags = listOf(
            "roverandom",
            "books",
            "fantasy",
            "not_on_arda",
            "tolkien_works",
            "edited_by_others",
            "posthumous",
            "tales",
            "short_stories"
        )
    ),
    BookData(
        id = "32",
        title = "La leyenda de Sigurd y Gudrún",
        imageRes = R.drawable.thumb_sigurd,
        tags = listOf(
            "la leyenda de sigurd y gudrun",
            "the_legend_of_sigurd_and_gurdun",
            "books",
            "not_on_arda",
            "tolkien_works",
            "poems",
            "posthumous",
            "edited_by_christopher_tolkien",
            "fiction"
        )
    ),
    BookData(
        id = "33",
        title = "La Historia de Kullervo",
        imageRes = R.drawable.thumb_kullervo,
        tags = listOf(
            "la historia de kullervo",
            "the_story_of_kullervo",
            "books",
            "not_on_arda",
            "posthumous",
            "tolkien_works",
            "fantasy",
            "edited_by_others",
            "poems"
        )
    ),
    BookData(
        id = "34",
        title = "La Balada de Aotrou e Itroun",
        imageRes = R.drawable.thumb_lay,
        tags = listOf(
            "la balada de aotrou e itroun",
            "the_lay_of_aotrou_and_itroun",
            "books",
            "not_on_arda",
            "posthumous",
            "tolkien_works",
            "fantasy",
            "edited_by_others",
            "poems"
        )
    ),
    BookData(
        id = "35",
        title = "Finn and Hengest",
        imageRes = R.drawable.thumb_finn,
        tags = listOf(
            "finn and hengest",
            "books",
            "academic",
            "tolkien_works",
            "posthumous",
            "edited_by_others",
            "not_on_arda",
            "essays"
        )
    ),
    BookData(
        id = "36",
        title = "Los monstruos y los críticos y otros ensayos",
        imageRes = R.drawable.thumb_monstruos,
        tags = listOf(
            "los monstruos los criticos y otros ensayos",
            "the_monsters_critics_and_other_essays",
            "books",
            "academic",
            "tolkien_works",
            "posthumous",
            "edited_by_christopher_tolkien",
            "not_on_arda",
            "essays"
        )
    ),
    BookData(
        id = "37",
        title = "Beowulf: traducción y comentario",
        imageRes = R.drawable.thumb_beowulf,
        tags = listOf(
            "beowulf",
            "books",
            "academic",
            "tolkien_works",
            "posthumous",
            "edited_by_christopher_tolkien",
            "not_on_arda",
            "fiction"
        )
    )
)
