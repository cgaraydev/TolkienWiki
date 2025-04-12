package com.cgaraydev.tolkienapp.data

data class LanguageData(
    val id: String,
    val name: String,
    val tags: List<String>? = emptyList()
)

val languagesTags = listOf(
    LanguageData(
        id = "0",
        name = "Adûnaico",
        tags = listOf(
            "adunaico",
            "languages",
            "adunaic",
            "mannish_languages"
        )
    ),
    LanguageData(
        id = "1",
        name = "Cirth",
        tags = listOf(
            "cirth",
            "writing_systems"
        )
    ),
    LanguageData(
        id = "2",
        name = "Éntico",
        tags = listOf(
            "entico",
            "entish",
            "languages",
            "ents"
        )
    ),
    LanguageData(
        id = "3",
        name = "Iglishmêk",
        tags = listOf(
            "iglishmek",
            "languages",
            "dwarvish_languages"
        )
    ),
    LanguageData(
        id = "4",
        name = "Khuzdul",
        tags = listOf(
            "khuzdul",
            "dwarvish_languages",
            "languages"
        )
    ),
    LanguageData(
        id = "5",
        name = "Lengua Hobbit",
        tags = listOf(
            "lengua hobbit",
            "hobbitico",
            "hobbitish",
            "languages",
            "mannish_languages"
        )
    ),
    LanguageData(
        id = "6",
        name = "Lengua Negra",
        tags = listOf(
            "lengua negra",
            "black speech",
            "languages"
        )
    ),
    LanguageData(
        id = "7",
        name = "Letras Lunares",
        tags = listOf(
            "letras lunares",
            "writing_systems"
        )
    ),
    LanguageData(
        id = "8",
        name = "Noldorin",
        tags = listOf(
            "noldorin",
            "quenya noldorin",
            "languages",
            "elvish_languages"
        )
    ),
    LanguageData(
        id = "9",
        name = "Oestron",
        tags = listOf(
            "oestron",
            "mannish_languages",
            "westron",
            "languages"
        )
    ),
    LanguageData(
        id = "10",
        name = "Quenya",
        tags = listOf(
            "quenya",
            "languages",
            "elvish_languages"
        )
    ),
    LanguageData(
        id = "11",
        name = "Rohírrico",
        tags = listOf(
            "rohirrico",
            "rohanese",
            "languages",
            "mannish_languages"
        )
    ),
    LanguageData(
        id = "12",
        name = "Sarati",
        tags = listOf(
            "sarati",
            "writing_systems"
        )
    ),
    LanguageData(
        id = "13",
        name = "Lengua Silvana",
        tags = listOf(
            "lengua silvana",
            "nandorin",
            "languages",
            "elvish_languages"
        )
    ),
    LanguageData(
        id = "14",
        name = "Sindarin",
        tags = listOf(
            "sindarin",
            "languages",
            "elvish_languages"
        )
    ),
    LanguageData(
        id = "15",
        name = "Taliska",
        tags = listOf(
            "taliska",
            "languages",
            "mannish_languages"
        )
    ),
    LanguageData(
        id = "16",
        name = "Telerin",
        tags = listOf(
            "telerin",
            "languages",
            "elvish_languages"
        )
    ),
    LanguageData(
        id = "17",
        name = "Tengwar",
        tags = listOf(
            "tengwar",
            "writing_systems"
        )
    ),
    LanguageData(
        id = "18",
        name = "Valarin",
        tags = listOf(
            "valarin",
            "languages"
        )
    )
)