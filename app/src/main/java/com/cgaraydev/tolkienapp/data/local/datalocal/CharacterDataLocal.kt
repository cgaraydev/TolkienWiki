package com.cgaraydev.tolkienapp.data.local.datalocal

data class CharacterData(
    val id: String,
    val name: String,
    val tags: List<String>? = emptyList()
)

val charactersTags = listOf(
    CharacterData(
        id = "0",
        name = "Aegnor",
        tags = listOf(
            "aegon",
            "elves",
            "noldor",
            "house_of_finarfin",
            "calaquendi",
            "silmarillion",
            "rulers_in_beleriand",
            "first_age"
        )
    ),
    CharacterData(
        id = "1",
        name = "Aerandir",
        tags = listOf(
            "mariners",
            "silmarillion",
            "first_age",
            "aerandir",
            "unknown_race"
        )
    ),
    CharacterData(
        id = "2",
        name = "Aerin",
        tags = listOf(
            "edain",
            "aerin",
            "house_of_hador",
            "silmarillion",
            "first_age",
            "men",
            "children_of_hurin",
            "book_of_lost_tales"
        )
    ),
    CharacterData(
        id = "3",
        name = "Algund",
        tags = listOf(
            "gaurwaith",
            "edain",
            "first_age",
            "silmarillion",
            "house_of_hador",
            "men",
            "algund",
            "unfinished_tales",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "4",
        name = "Amandil",
        tags = listOf(
            "lords_of_andunie",
            "amandil",
            "faithful",
            "silmarillion",
            "mariners",
            "second_age",
            "numenorean",
            "men",
            "house_of_valandil"
        )
    ),
    CharacterData(
        id = "5",
        name = "Amarië",
        tags = listOf(
            "elves",
            "vanyar",
            "silmarillion",
            "calaquendi",
            "first_age",
            "amarie"
        )
    ),
    CharacterData(
        id = "6",
        name = "Amlach",
        tags = listOf(
            "edain",
            "amlach",
            "first_age",
            "house_of_hador",
            "silmarillion",
            "men"
        )
    ),
    CharacterData(
        id = "7",
        name = "Amrod y Amras",
        tags = listOf(
            "silmarillion",
            "house_of_feanor",
            "noldor",
            "elves",
            "first_age",
            "amrod",
            "amras",
            "amrod y amras",
            "sons_of_feanor",
            "book_of_lost_tales",
            "twins"
        )
    ),
    CharacterData(
        id = "8",
        name = "Anárion",
        tags = listOf(
            "faithful",
            "anarion",
            "kings_of_gondor",
            "numenorean",
            "ruler_of_gondor",
            "numenor_key_people",
            "death_in_battle",
            "mariners",
            "men",
            "second_age",
            "house_of_anarion",
            "house_of_elendil",
            "silmarillion"
        )
    ),
    CharacterData(
        id = "9",
        name = "Anborn",
        tags = listOf(
            "dunedain",
            "anborn",
            "third_age",
            "lord_of_the_rings",
            "gondorians",
            "rangers_of_ithilien",
            "men",
            "minor_character"
        )
    ),
    CharacterData(
        id = "10",
        name = "Ancalagon",
        tags = listOf(
            "dragons",
            "ancalagon",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "uruloke",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "11",
        name = "Andreth",
        tags = listOf(
            "andreth",
            "house_of_beor",
            "edain",
            "first_age",
            "men",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "12",
        name = "Andróg",
        tags = listOf(
            "edain",
            "androg",
            "house_of_hador",
            "gaurwaith",
            "first_age",
            "children_of_hurin",
            "men"
        )
    ),
    CharacterData(
        id = "13",
        name = "Angbor",
        tags = listOf(
            "lord_of_the_rings",
            "angbor",
            "men",
            "dunedain",
            "third_age",
            "gondorians",
            "lords_of_gondor",
            "minor_character"
        )
    ),
    CharacterData(
        id = "14",
        name = "Angrim",
        tags = listOf(
            "silmarillion",
            "angrim",
            "edain",
            "house_of_beor",
            "first_age",
            "men",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "15",
        name = "Angrod",
        tags = listOf(
            "elves",
            "angrod",
            "noldor",
            "calaquendi",
            "silmarillion",
            "first_age",
            "house_of_finarfin",
            "rulers_in_beleriand",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "16",
        name = "Annael",
        tags = listOf(
            "elves",
            "annael",
            "sindar",
            "silmarillion",
            "first_age",
            "moriquendi",
            "children_of_hurin",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "17",
        name = "Ar-Adûnakhôr",
        tags = listOf(
            "men",
            "second_age",
            "house_of_elros",
            "numenorean",
            "ar-adunakhor",
            "adunakhor",
            "herunumen",
            "kings_of_numenor",
            "kings_men",
            "silmarillion",
            "rulers_of_numenor",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "18",
        name = "Ar-Gimilzôr",
        tags = listOf(
            "men",
            "ar-gimilzor",
            "gimilzor",
            "kings_of_numenor",
            "kings_men",
            "numenorean",
            "second_age",
            "rulers_of_numenor",
            "silmarillion",
            "house_of_elros"
        )
    ),
    CharacterData(
        id = "19",
        name = "Ar-Pharazôn",
        tags = listOf(
            "men",
            "ar-pharazon",
            "pharazon",
            "kings_of_numenor",
            "numenorean",
            "house_of_elros",
            "silmarillion",
            "second_age",
            "rulers_of_numenor",
            "mariners",
            "servants_of_sauron",
            "numenor_key_people",
            "kings_men",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "rings_of_power_canon"
        )
    ),
    CharacterData(
        id = "20",
        name = "Ar-Sakalthôr",
        tags = listOf(
            "men",
            "ar-sakalthor",
            "sakalthor",
            "numenorean",
            "rulers_of_numenor",
            "kings_of_numenor",
            "kings_men",
            "silmarillion",
            "second_age",
            "house_of_elros",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "21",
        name = "Aragorn II",
        tags = listOf(
            "men",
            "aragorn",
            "lord_of_the_rings",
            "silmarillion",
            "dunedain",
            "fourth_age",
            "third_age",
            "fellowship_of_the_ring",
            "house_of_isildur",
            "ruler_of_gondor",
            "ruler_of_arnor",
            "council_of_elrond",
            "chieftain_of_the_dunedain",
            "house_of_telcontar",
            "mariners",
            "kings_of_gondor",
            "kings_of_arnor",
            "featured",
            "dunedain_of_the_north",
            "arnorians"
        )
    ),
    CharacterData(
        id = "22",
        name = "Aranwë",
        tags = listOf(
            "elves",
            "aranwe",
            "noldor",
            "house_of_fingolfin",
            "silmarillion",
            "first_age",
            "gondolindrim",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "23",
        name = "Aratan",
        tags = listOf(
            "men",
            "aratan",
            "arnorians",
            "house_of_isildur",
            "dunedain",
            "second_age",
            "third_age",
            "silmarillion",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "24",
        name = "Arathorn II",
        tags = listOf(
            "men",
            "arathorn",
            "dunedain",
            "dunedain_of_the_north",
            "house_of_isildur",
            "silmarillion",
            "third_age",
            "chieftain_of_the_dunedain",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "25",
        name = "Aredhel",
        tags = listOf(
            "elves",
            "aredhel",
            "noldor",
            "calaquendi",
            "silmarillion",
            "first_age",
            "gondolindrim",
            "house_of_fingolfin",
            "book_of_lost_tales",
            "princesses",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "26",
        name = "Arien",
        tags = listOf(
            "ainur",
            "arien",
            "maiar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "middle_earth_cosmology",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "27",
        name = "Arminas",
        tags = listOf(
            "elves",
            "arminas",
            "noldor",
            "first_age",
            "children_of_hurin",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "28",
        name = "Arquero Coto",
        tags = listOf(
            "hobbits",
            "arquero coto",
            "bowman cotton",
            "coto",
            "cotton",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "29",
        name = "Arthad",
        tags = listOf(
            "men",
            "arthad",
            "barahir_outlaws",
            "edain",
            "silmarillion",
            "first_age",
            "house_of_beor"
        )
    ),
    CharacterData(
        id = "30",
        name = "Arwen",
        tags = listOf(
            "elves",
            "noldor",
            "arwen",
            "undomiel",
            "half_elf",
            "lord_of_the_rings",
            "fourth_age",
            "third_age",
            "queens_of_gondor"
        )
    ),
    CharacterData(
        id = "31",
        name = "Aulë",
        tags = listOf(
            "ainur",
            "aule",
            "valar",
            "aratar",
            "silmarillion",
            "first_age",
            "smiths",
            "the_history_of_middle_earth",
            "beren_and_luthien",
            "book_of_lost_tales"
        )
    ),
    CharacterData(
        id = "32",
        name = "Azaghâl",
        tags = listOf(
            "azaghal",
            "dwarves",
            "first_age",
            "silmarillion",
            "belegost",
            "death_in_battle",
            "kings"
        )
    ),
    CharacterData(
        id = "33",
        name = "Azog",
        tags = listOf(
            "orcs",
            "azog",
            "third_age",
            "rulers_middle_earth",
            "the_hobbit",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "34",
        name = "Balin",
        tags = listOf(
            "dwarves",
            "balin",
            "third_age",
            "the_hobbit",
            "thorin_company",
            "rulers_middle_earth",
            "longbeards",
            "unfinished_tales",
            "death_in_battle",
            "durins_folk"
        )
    ),
    CharacterData(
        id = "35",
        name = "Bandobras Tuk",
        tags = listOf(
            "hobbits",
            "bandobras tuk",
            "tuk",
            "third_age",
            "the_hobbit",
            "took"
        )
    ),
    CharacterData(
        id = "36",
        name = "Baragund",
        tags = listOf(
            "men",
            "baragund",
            "edain",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "barahir_outlaws"
        )
    ),
    CharacterData(
        id = "37",
        name = "Barahir",
        tags = listOf(
            "men",
            "barahir",
            "edain",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "barahir_outlaws",
            "lords_of_ladros",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "38",
        name = "Baran",
        tags = listOf(
            "men",
            "baran",
            "edain",
            "silmarillion",
            "first_age",
            "house_of_beor",
            "chieftain_of_the_house_of_beor"
        )
    ),
    CharacterData(
        id = "39",
        name = "Bárbol",
        tags = listOf(
            "ents",
            "barbol",
            "treebeard",
            "lord_of_the_rings",
            "first_age",
            "third_age",
            "rulers_middle_earth",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "40",
        name = "Bardo",
        tags = listOf(
            "men",
            "bardo",
            "the_hobbit",
            "third_age",
            "kings_of_dale",
            "lake_men",
            "bardings"
        )
    ),
    CharacterData(
        id = "41",
        name = "Baya de Oro",
        tags = listOf(
            "lord_of_the_rings",
            "baya de oro",
            "goldberry",
            "enigmas",
            "third_age",
            "forest_folk",
            "the_adventures_of_tom_bombadil",
            "minor_character",
            "unknown_race"
        )
    ),
    CharacterData(
        id = "42",
        name = "Beleg",
        tags = listOf(
            "elves",
            "beleg",
            "cuthalion",
            "sindar",
            "silmarillion",
            "first_age",
            "gaurwaith",
            "children_of_hurin",
            "book_of_lost_tales",
            "moriquendi",
            "beren_and_luthien",
            "the_history_of_middle_earth",
            "grey_elves"
        )
    ),
    CharacterData(
        id = "43",
        name = "Belegund",
        tags = listOf(
            "men",
            "edain",
            "belegund",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "barahir_outlaws",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "44",
        name = "Belen",
        tags = listOf(
            "men",
            "belen",
            "edain",
            "first_age",
            "house_of_beor"
        )
    ),
    CharacterData(
        id = "45",
        name = "Beleth",
        tags = listOf(
            "men",
            "beleth",
            "edain",
            "first_age",
            "house_of_beor"
        )
    ),
    CharacterData(
        id = "46",
        name = "Belladonna Tuk",
        tags = listOf(
            "hobbits",
            "belladonna tuk",
            "belladonna took",
            "took",
            "baggins",
            "the_hobbit",
            "third_age"
        )
    ),
    CharacterData(
        id = "47",
        name = "Bëor",
        tags = listOf(
            "men",
            "beor",
            "edain",
            "first_age",
            "silmarillion",
            "house_of_beor",
            "chieftain_of_the_house_of_beor"
        )
    ),
    CharacterData(
        id = "48",
        name = "Beorn",
        tags = listOf(
            "men",
            "beorn",
            "skin_changer",
            "third_age",
            "the_hobbit",
            "beornings",
            "rulers_middle_earth",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "49",
        name = "Bereg",
        tags = listOf(
            "men",
            "bereg",
            "edain",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "50",
        name = "Beregond",
        tags = listOf(
            "men",
            "beregond",
            "lord_of_the_rings",
            "gondorians",
            "white_company",
            "third_age",
            "fourth_age"
        )
    ),
    CharacterData(
        id = "51",
        name = "Beren",
        tags = listOf(
            "men",
            "beren",
            "edain",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "barahir_outlaws",
            "book_of_lost_tales",
            "lords_of_ladros",
            "the_history_of_middle_earth",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "52",
        name = "Bergil",
        tags = listOf(
            "men",
            "bergil",
            "gondorians",
            "third_age",
            "lord_of_the_rings",
            "fourth_age"
        )
    ),
    CharacterData(
        id = "53",
        name = "Beril",
        tags = listOf(
            "edain",
            "beril",
            "men",
            "first_age",
            "house_of_beor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "54",
        name = "Bifur",
        tags = listOf(
            "dwarves",
            "bifur",
            "the_hobbit",
            "third_age",
            "thorin_company",
            "longbeards"
        )
    ),
    CharacterData(
        id = "55",
        name = "Bilbo Bolsón",
        tags = listOf(
            "hobbits",
            "bilbo bolson",
            "baggins",
            "bolson",
            "the_hobbit",
            "thorin_company",
            "third_age",
            "fellowship_of_the_ring",
            "ring_bearer",
            "council_of_elrond",
            "lord_of_the_rings"
        )
    ),
    CharacterData(
        id = "56",
        name = "Bill Helechal",
        tags = listOf(
            "men",
            "bree_men",
            "bill helechal",
            "bill ferny",
            "third_age",
            "servants_of_sauron",
            "servants_of_saruman",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "57",
        name = "Bob",
        tags = listOf(
            "hobbits",
            "bob",
            "bree",
            "third_age",
            "lord_of_the_rings",
            "minor_character",
            "bree_hobbits"
        )
    ),
    CharacterData(
        id = "58",
        name = "Boca de Sauron",
        tags = listOf(
            "black_numenoreans",
            "boca de sauron",
            "mouth of sauron",
            "lord_of_the_rings",
            "servants_of_sauron",
            "third_age",
            "men"
        )
    ),
    CharacterData(
        id = "59",
        name = "Bofur",
        tags = listOf(
            "dwarves",
            "bofur",
            "the_hobbit",
            "third_age",
            "thorin_company",
            "longbeards"
        )
    ),
    CharacterData(
        id = "60",
        name = "Bolgo",
        tags = listOf(
            "orcs",
            "bolgo",
            "the_hobbit",
            "rulers_middle_earth",
            "third_age",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "61",
        name = "Bombur",
        tags = listOf(
            "dwarves",
            "bombur",
            "thorin_company",
            "the_hobbit",
            "third_age",
            "longbeards"
        )
    ),
    CharacterData(
        id = "62",
        name = "Bór",
        tags = listOf(
            "men",
            "bor",
            "easterling",
            "silmarillion",
            "first_age",
            "rulers_in_beleriand",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "63",
        name = "Borlach",
        tags = listOf(
            "men",
            "borlach",
            "silmarillion",
            "first_age",
            "easterling",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "64",
        name = "Borlad",
        tags = listOf(
            "men",
            "borlad",
            "easterling",
            "first_age",
            "silmarillion",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "65",
        name = "Boromir",
        tags = listOf(
            "men",
            "boromir",
            "lord_of_the_rings",
            "fellowship_of_the_ring",
            "third_age",
            "gondorians",
            "house_of_hurin",
            "council_of_elrond",
            "featured",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "66",
        name = "Boromir (Señor de Ladros)",
        tags = listOf(
            "men",
            "boromir",
            "lords_of_ladros",
            "edain",
            "silmarillion",
            "first_age",
            "house_of_beor",
            "ladros"
        )
    ),
    CharacterData(
        id = "67",
        name = "Boron",
        tags = listOf(
            "men",
            "boron",
            "edain",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "chieftain_of_the_house_of_beor"
        )
    ),
    CharacterData(
        id = "68",
        name = "Borthand",
        tags = listOf(
            "men",
            "borthand",
            "easterling",
            "first_age",
            "silmarillion",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "69",
        name = "Brandir",
        tags = listOf(
            "men",
            "brandir",
            "edain",
            "house_of_haleth",
            "first_age",
            "silmarillion",
            "children_of_hurin",
            "book_of_lost_tales",
            "chieftain_of_brethil",
            "chieftain_of_the_haladin"
        )
    ),
    CharacterData(
        id = "70",
        name = "Bregolas",
        tags = listOf(
            "men",
            "bregolas",
            "edain",
            "house_of_beor",
            "silmarillion",
            "first_age",
            "lords_of_ladros",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "71",
        name = "Bregor",
        tags = listOf(
            "men",
            "bregor",
            "edain",
            "house_of_beor",
            "lords_of_ladros",
            "silmarillion",
            "first_age",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "72",
        name = "Brodda",
        tags = listOf(
            "easterling",
            "brodda",
            "men",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "children_of_hurin",
            "book_of_lost_tales",
            "servants_of_morgoth",
            "rulers_in_the_great_lands"
        )
    ),
    CharacterData(
        id = "73",
        name = "Bungo Bolsón",
        tags = listOf(
            "hobbits",
            "bungo bolson",
            "bolson",
            "baggins",
            "third_age",
            "the_hobbit"
        )
    ),
    CharacterData(
        id = "74",
        name = "Capitán de la Guardia",
        tags = listOf(
            "men",
            "capitan de la guardia",
            "the_hobbit",
            "lake_men",
            "third_age"
        )
    ),
    CharacterData(
        id = "75",
        name = "Caranthir",
        tags = listOf(
            "elves",
            "caranthir",
            "house_of_feanor",
            "noldor",
            "first_age",
            "silmarillion",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "sons_of_feanor",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "76",
        name = "Carc",
        tags = listOf(
            "the_hobbit",
            "carc",
            "ravens",
            "third_age"
        )
    ),
    CharacterData(
        id = "77",
        name = "Carcharoth",
        tags = listOf(
            "carcharoth",
            "wolves",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "werewolves",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "78",
        name = "Carl Coto",
        tags = listOf(
            "hobbits",
            "carl coto",
            "coto",
            "third_age",
            "cotton",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "79",
        name = "Cebadilla Mantecona",
        tags = listOf(
            "men",
            "cebadilla mantecona",
            "mantecona",
            "barliman butterbur",
            "bree_men",
            "lord_of_the_rings",
            "third_age"
        )
    ),
    CharacterData(
        id = "80",
        name = "Celeborn",
        tags = listOf(
            "elves",
            "celeborn",
            "sindar",
            "lord_of_the_rings",
            "silmarillion",
            "galadhrim",
            "grey_elves",
            "unfinished_tales",
            "falmari",
            "first_age",
            "third_age",
            "fourth_age",
            "moriquendi",
            "second_age",
            "lord_of_the_rings",
            "rulers_middle_earth"
        )
    ),
    CharacterData(
        id = "81",
        name = "Celebrían",
        tags = listOf(
            "elves",
            "celebrian",
            "grey_elves",
            "moriquendi",
            "second_age",
            "third_age",
            "sindar",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "house_of_finarfin"
        )
    ),
    CharacterData(
        id = "82",
        name = "Celebrimbor",
        tags = listOf(
            "elves",
            "celebrimbor",
            "calaquendi",
            "silmarillion",
            "first_age",
            "house_of_feanor",
            "noldor",
            "second_age",
            "smiths",
            "rulers_middle_earth",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "83",
        name = "Celegorm",
        tags = listOf(
            "elves",
            "celegorm",
            "noldor",
            "house_of_feanor",
            "sons_of_feanor",
            "first_age",
            "silmarillion",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "84",
        name = "Ceorl",
        tags = listOf(
            "men",
            "ceorl",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "85",
        name = "Círdan",
        tags = listOf(
            "elves",
            "cirdan",
            "nowe",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "second_age",
            "third_age",
            "fourth_age",
            "moriquendi",
            "mariners",
            "sindar",
            "nelyar",
            "rulers_middle_earth",
            "grey_elves",
            "ring_bearer",
            "white_council"
        )
    ),
    CharacterData(
        id = "86",
        name = "Ciryon",
        tags = listOf(
            "men",
            "ciryon",
            "silmarillion",
            "house_of_isildur",
            "second_age",
            "third_age",
            "dunedain",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "87",
        name = "Curufin",
        tags = listOf(
            "elves",
            "curufin",
            "sons_of_feanor",
            "noldor",
            "silmarillion",
            "house_of_feanor",
            "first_age",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "the_history_of_middle_earth",
            "death_in_battle",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "88",
        name = "Daeron",
        tags = listOf(
            "elves",
            "daeron",
            "sindar",
            "silmarillion",
            "first_age",
            "minstrels",
            "grey_elves",
            "loremasters",
            "moriquendi",
            "book_of_lost_tales",
            "chroniclers_of_arda",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "89",
        name = "Dagnir",
        tags = listOf(
            "men",
            "dagnir",
            "barahir_outlaws",
            "silmarillion",
            "first_age",
            "edain",
            "house_of_beor"
        )
    ),
    CharacterData(
        id = "90",
        name = "Dáin II",
        tags = listOf(
            "dwarves",
            "dain",
            "pie de hierro",
            "ironfoot",
            "durins_folk",
            "the_hobbit",
            "third_age",
            "longbeards",
            "death_in_battle",
            "kings_of_durins_folk",
            "kings_under_the_mountain",
            "lords_of_the_iron_hills"
        )
    ),
    CharacterData(
        id = "91",
        name = "Dairuin",
        tags = listOf(
            "men",
            "dairuin",
            "edain",
            "silmarillion",
            "first_age",
            "house_of_beor",
            "barahir_outlaws",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "92",
        name = "Damrod",
        tags = listOf(
            "men",
            "damrod",
            "gondorians",
            "third_age",
            "rangers",
            "lord_of_the_rings",
            "dunedain",
            "rangers_of_ithilien",
            "minor_character"
        )
    ),
    CharacterData(
        id = "93",
        name = "Daño de Durin",
        tags = listOf(
            "balrogs",
            "daño de durin",
            "lord_of_the_rings",
            "maiar",
            "first_age",
            "second_age",
            "third_age",
            "servants_of_morgoth",
            "ainur",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "94",
        name = "Denethor (Laiquendi)",
        tags = listOf(
            "elves",
            "denethor",
            "nandor",
            "first_age",
            "silmarillion",
            "rulers_in_beleriand",
            "death_in_battle",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "95",
        name = "Denethor II",
        tags = listOf(
            "men",
            "denethor",
            "third_age",
            "lord_of_the_rings",
            "gondorians",
            "house_of_hurin",
            "ruler_of_gondor",
            "rulling_stewards",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "96",
        name = "Déorwine",
        tags = listOf(
            "men",
            "deorwine",
            "third_age",
            "rohirrim",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "97",
        name = "Derufin",
        tags = listOf(
            "men",
            "derufin",
            "third_age",
            "lord_of_the_rings",
            "gondorians",
            "minor_character"
        )
    ),
    CharacterData(
        id = "98",
        name = "Dervorin",
        tags = listOf(
            "men",
            "dervorin",
            "gondorians",
            "lord_of_the_rings",
            "third_age",
            "dunedain",
            "minor_character",
            "dunedain"
        )
    ),
    CharacterData(
        id = "99",
        name = "Dior",
        tags = listOf(
            "half_elf",
            "dior",
            "silmarillion",
            "first_age",
            "rulers_in_beleriand",
            "sindar",
            "house_of_beor",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "death_in_battle",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "100",
        name = "Dori",
        tags = listOf(
            "dwarves",
            "dori",
            "the_hobbit",
            "third_age",
            "thorin_company",
            "longbeards",
            "durins_folk"
        )
    ),
    CharacterData(
        id = "101",
        name = "Dorlas",
        tags = listOf(
            "men",
            "dorlas",
            "edain",
            "first_age",
            "silmarillion",
            "house_of_haleth",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "102",
        name = "Draugluin",
        tags = listOf(
            "werewolves",
            "draugluin",
            "first_age",
            "servants_of_morgoth",
            "silmarillion",
            "servants_of_sauron",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "103",
        name = "Duilin (hijo de Duinhir)",
        tags = listOf(
            "men",
            "duilin",
            "gondorians",
            "lord_of_the_rings",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "104",
        name = "Duinhir",
        tags = listOf(
            "men",
            "duinhir",
            "gondorians",
            "third_age",
            "lord_of_the_rings",
            "minor_character",
            "lords_of_gondor"
        )
    ),
    CharacterData(
        id = "105",
        name = "Dúnhere",
        tags = listOf(
            "men",
            "dunhere",
            "rohirrim",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "106",
        name = "Durin I",
        tags = listOf(
            "dwarves",
            "durin",
            "durins_folk",
            "silmarillion",
            "first_age",
            "longbeards",
            "kings_of_durins_folk",
            "kings_of_khazad_dum",
            "durins_folk"
        )
    ),
    CharacterData(
        id = "107",
        name = "Dwalin",
        tags = listOf(
            "dwarves",
            "dwalin",
            "third_age",
            "fourth_age",
            "the_hobbit",
            "thorin_company",
            "longbeards",
            "durins_folk"
        )
    ),
    CharacterData(
        id = "108",
        name = "Eärendil",
        tags = listOf(
            "half_elf",
            "earendil",
            "silmarillion",
            "first_age",
            "second_age",
            "gondolindrim",
            "house_of_fingolfin",
            "house_of_hador",
            "mariners",
            "noldor",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "109",
        name = "Eärendur (Señor de Andúnië)",
        tags = listOf(
            "numenorean",
            "earendur",
            "men",
            "second_age",
            "silmarillion",
            "lords_of_andunie",
            "faithful",
            "house_of_valandil",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "110",
        name = "Eärendur (Rey de Arnor)",
        tags = listOf(
            "men",
            "earendur",
            "silmarillion",
            "house_of_isildur",
            "ruler_of_arnor",
            "third_age",
            "dunedain_of_the_north",
            "dunedain",
            "kings_of_arnor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "111",
        name = "Eärnil II",
        tags = listOf(
            "men",
            "earnil",
            "earnil ii",
            "gondorians",
            "silmarillion",
            "house_of_anarion",
            "ruler_of_gondor",
            "third_age",
            "kings_of_gondor",
            "dunedain",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "112",
        name = "Eärnur",
        tags = listOf(
            "men",
            "earnur",
            "silmarillion",
            "gondorians",
            "house_of_anarion",
            "mariners",
            "ruler_of_gondor",
            "third_age",
            "dunedain",
            "kings_of_gondor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "113",
        name = "Eärwen",
        tags = listOf(
            "elves",
            "earwen",
            "falmari",
            "first_age",
            "silmarillion",
            "house_of_finarfin",
            "calaquendi",
            "teleri",
            "princesses",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "114",
        name = "Ecthelion",
        tags = listOf(
            "elves",
            "ecthelion",
            "noldor",
            "first_age",
            "silmarillion",
            "calaquendi",
            "gondolindrim",
            "realm_of_gondolin",
            "house_of_the_fountain",
            "book_of_lost_tales",
            "lords_of_the_twelve_houses",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "115",
        name = "Edrahil",
        tags = listOf(
            "elves",
            "edrahil",
            "noldor",
            "silmarillion",
            "first_age"
        )
    ),
    CharacterData(
        id = "116",
        name = "Eilinel",
        tags = listOf(
            "men",
            "eilinel",
            "first_age",
            "silmarillion",
            "edain",
            "house_of_beor",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "117",
        name = "Elemmírë (Elfo)",
        tags = listOf(
            "elves",
            "elemmire",
            "vanyar",
            "first_age",
            "calaquendi",
            "silmarillion"
        )
    ),
    CharacterData(
        id = "118",
        name = "Elendil",
        tags = listOf(
            "men",
            "elendil",
            "numenorean",
            "faithful",
            "house_of_elendil",
            "house_of_valandil",
            "numenor",
            "silmarillion",
            "dunedain",
            "mariners",
            "ruler_of_arnor",
            "ruler_of_gondor",
            "second_age",
            "numenor_key_people",
            "kings_of_arnor",
            "kings_of_gondor",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "119",
        name = "Elendur",
        tags = listOf(
            "men",
            "numenorean",
            "silmarillion",
            "second_age",
            "house_of_isildur",
            "third_age",
            "dunedain_of_the_north",
            "dunedain",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "120",
        name = "Elenwë",
        tags = listOf(
            "elves",
            "elenwe",
            "vanyar",
            "calaquendi",
            "silmarillion",
            "first_age",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "121",
        name = "Elfhelm",
        tags = listOf(
            "men",
            "elfhelm",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "122",
        name = "Ella-Laraña",
        tags = listOf(
            "spiders",
            "ella-laraña",
            "ella laraña",
            "shelob",
            "servants_of_sauron",
            "lord_of_the_rings",
            "third_age",
            "spirits"
        )
    ),
    CharacterData(
        id = "123",
        name = "Elladan y Elrohir",
        tags = listOf(
            "half_elf",
            "elladan",
            "elrohir",
            "lord_of_the_rings",
            "third_age",
            "fourth_age",
            "noldor",
            "twins",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "124",
        name = "Elrond",
        tags = listOf(
            "elrond",
            "council_of_elrond",
            "the_hobbit",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "second_age",
            "half_elf",
            "third_age",
            "house_of_hador",
            "rulers_middle_earth",
            "featured",
            "beren_and_luthien",
            "unfinished_tales",
            "ring_bearer",
            "twins",
            "white_council"
        )
    ),
    CharacterData(
        id = "125",
        name = "Elros",
        tags = listOf(
            "half_elf",
            "elros",
            "numenorean",
            "rulers_of_numenor",
            "kings_of_numenor",
            "numenor_key_people",
            "silmarillion",
            "first_age",
            "house_of_elros",
            "house_of_hador",
            "mariners",
            "second_age",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "twins"
        )
    ),
    CharacterData(
        id = "126",
        name = "Eluréd y Elurín",
        tags = listOf(
            "half_elf",
            "elured",
            "elurin",
            "silmarillion",
            "first_age",
            "sindar",
            "grey_elves",
            "the_history_of_middle_earth",
            "twins"
        )
    ),
    CharacterData(
        id = "127",
        name = "Elwing",
        tags = listOf(
            "silmarillion",
            "elwing",
            "first_age",
            "half_elf",
            "sindar",
            "book_of_lost_tales",
            "grey_elves",
            "princesses",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "128",
        name = "Emeldir",
        tags = listOf(
            "men",
            "emeldir",
            "edain",
            "first_age",
            "silmarillion",
            "house_of_beor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "129",
        name = "Eöl",
        tags = listOf(
            "elves",
            "eol",
            "sindar",
            "silmarillion",
            "first_age",
            "avari",
            "moriquendi",
            "nandor",
            "rulers_in_beleriand",
            "smiths",
            "book_of_lost_tales",
            "tatyar",
            "grey_elves"
        )
    ),
    CharacterData(
        id = "130",
        name = "Éomer",
        tags = listOf(
            "men",
            "eomer",
            "rohirrim",
            "third_age",
            "lord_of_the_rings",
            "ruler_of_rohan",
            "fourth_age",
            "kings_of_rohan"
        )
    ),
    CharacterData(
        id = "131",
        name = "Eönwë",
        tags = listOf(
            "maiar",
            "silmarillion",
            "first_age",
            "second_age",
            "ruler_aman",
            "ainur",
            "book_of_lost_tales",
            "rulers_in_aman",
            "valarindi",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "132",
        name = "Éothain",
        tags = listOf(
            "men",
            "eothain",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "133",
        name = "Éowyn",
        tags = listOf(
            "men",
            "eowyn",
            "dernhelm",
            "rohirrim",
            "third_age",
            "lord_of_the_rings",
            "fourth_age",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "134",
        name = "Erellont",
        tags = listOf(
            "silmarillion",
            "erellont",
            "first_age",
            "mariners",
            "unknown_race"
        )
    ),
    CharacterData(
        id = "135",
        name = "Erestor",
        tags = listOf(
            "elves",
            "erestor",
            "lord_of_the_rings",
            "third_age",
            "council_of_elrond",
            "minor_character",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "136",
        name = "Erkenbrand",
        tags = listOf(
            "men",
            "erkenbrand",
            "rohirrim",
            "lord_of_the_rings",
            "third_age"
        )
    ),
    CharacterData(
        id = "137",
        name = "Eru Ilúvatar",
        tags = listOf(
            "silmarillion",
            "eru iluvatar",
            "eru",
            "iluvatar",
            "book_of_lost_tales",
            "heavenly_beigns"
        )
    ),
    CharacterData(
        id = "138",
        name = "Estë",
        tags = listOf(
            "silmarillion",
            "este",
            "first_age",
            "valar",
            "ainur",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "139",
        name = "Falathar",
        tags = listOf(
            "silmarillion",
            "falathar",
            "first_age",
            "mariners",
            "unknown_race"
        )
    ),
    CharacterData(
        id = "140",
        name = "Faramir",
        tags = listOf(
            "men",
            "faramir",
            "gondorians",
            "lord_of_the_rings",
            "third_age",
            "fourth_age",
            "house_of_hurin",
            "rangers",
            "stewards",
            "rulling_stewards",
            "featured",
            "princes_of_ithilien",
            "rangers_of_ithilien",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "141",
        name = "Fastred",
        tags = listOf(
            "men",
            "fastred",
            "death_in_battle",
            "rohirrim",
            "minor_character",
            "third_age",
            "lord_of_the_rings"
        )
    ),
    CharacterData(
        id = "142",
        name = "Fëanor",
        tags = listOf(
            "elves",
            "feanor",
            "calaquendi",
            "silmarillion",
            "first_age",
            "house_of_feanor",
            "house_of_finwe",
            "noldor",
            "ruler_aman",
            "rulers_in_beleriand",
            "smiths",
            "book_of_lost_tales",
            "high_king_of_the_noldor",
            "the_history_of_middle_earth",
            "death_in_battle",
            "loremasters"
        )
    ),
    CharacterData(
        id = "143",
        name = "Fíli",
        tags = listOf(
            "dwarves",
            "fili",
            "thorin_company",
            "third_age",
            "the_hobbit",
            "longbeards",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "144",
        name = "Finarfin",
        tags = listOf(
            "elves",
            "finarfin",
            "calaquendi",
            "first_age",
            "silmarillion",
            "house_of_finarfin",
            "house_of_finwe",
            "noldor",
            "ruler_aman",
            "high_king_of_the_noldor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "145",
        name = "Finduilas",
        tags = listOf(
            "elves",
            "finduilas",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "house_of_finarfin",
            "moriquendi",
            "noldor",
            "book_of_lost_tales",
            "princesses",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "146",
        name = "Fingolfin",
        tags = listOf(
            "elves",
            "fingolfin",
            "noldor",
            "silmarillion",
            "first_age",
            "calaquendi",
            "house_of_fingolfin",
            "house_of_finwe",
            "rulers_in_beleriand",
            "high_king_of_the_noldor",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "147",
        name = "Fingon",
        tags = listOf(
            "noldor",
            "fingon",
            "elves",
            "house_of_fingolfin",
            "silmarillion",
            "first_age",
            "calaquendi",
            "rulers_in_beleriand",
            "high_king_of_the_noldor",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "148",
        name = "Finrod",
        tags = listOf(
            "elves",
            "finrod felagund",
            "finrod",
            "felagund",
            "noldor",
            "house_of_finarfin",
            "silmarillion",
            "first_age",
            "calaquendi",
            "rulers_in_beleriand",
            "kings",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "149",
        name = "Finwë",
        tags = listOf(
            "elves",
            "finwe",
            "noldor",
            "house_of_finwe",
            "silmarillion",
            "first_age",
            "calaquendi",
            "ruler_aman",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "tatyar",
            "high_king_of_the_noldor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "150",
        name = "Folco Boffin",
        tags = listOf(
            "hobbits",
            "folco",
            "folco boffin",
            "boffin",
            "lord_of_the_rings",
            "boffin",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "151",
        name = "Forlong",
        tags = listOf(
            "men",
            "forlong",
            "gondorians",
            "third_age",
            "lord_of_the_rings",
            "lords_of_gondor",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "152",
        name = "Forweg",
        tags = listOf(
            "men",
            "forweg",
            "edain",
            "house_of_hador",
            "first_age",
            "children_of_hurin",
            "gaurwaith"
        )
    ),
    CharacterData(
        id = "153",
        name = "Fredegar Bolger",
        tags = listOf(
            "hobbits",
            "fredegar bolger",
            "fredegar",
            "bolger",
            "lord_of_the_rings",
            "third_age"
        )
    ),
    CharacterData(
        id = "154",
        name = "Frodo Bolsón",
        tags = listOf(
            "hobbits",
            "frodo",
            "frodo bolson",
            "bolson",
            "council_of_elrond",
            "fellowship_of_the_ring",
            "ring_bearer",
            "baggins",
            "lord_of_the_rings",
            "silmarillion",
            "third_age",
            "chroniclers_of_arda",
            "featured",
            "bearer_of_the_one_ring"
        )
    ),
    CharacterData(
        id = "155",
        name = "Fuinur",
        tags = listOf(
            "black_numenoreans",
            "fuinur",
            "silmarillion",
            "mariners",
            "numenorean",
            "second_age",
            "servants_of_sauron"
        )
    ),
    CharacterData(
        id = "156",
        name = "Fundin",
        tags = listOf(
            "dwarves",
            "fundin",
            "durins_folk",
            "third_age",
            "longbeards"
        )
    ),
    CharacterData(
        id = "157",
        name = "Galadriel",
        tags = listOf(
            "elves",
            "galadriel",
            "noldor",
            "house_of_finarfin",
            "white_council",
            "calaquendi",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "rulers_middle_earth",
            "second_age",
            "third_age",
            "featured",
            "beren_and_luthien",
            "unfinished_tales",
            "galadhrim",
            "ring_bearer",
            "rulers_of_lorien"
        )
    ),
    CharacterData(
        id = "158",
        name = "Galdor (Señor de Dor-lómin)",
        tags = listOf(
            "men",
            "galdor",
            "edain",
            "house_of_hador",
            "silmarillion",
            "first_age",
            "lords_of_dor_lomin"
        )
    ),
    CharacterData(
        id = "159",
        name = "Galdor de los Puertos",
        tags = listOf(
            "lord_of_the_rings",
            "galdor",
            "third_age",
            "moriquendi",
            "sindar",
            "council_of_elrond",
            "grey_elves",
            "minor_character"
        )
    ),
    CharacterData(
        id = "160",
        name = "Galion",
        tags = listOf(
            "elves",
            "galion",
            "silvan",
            "third_age",
            "the_hobbit",
            "nandor"
        )
    ),
    CharacterData(
        id = "161",
        name = "Gamling",
        tags = listOf(
            "men",
            "gamling",
            "gamelin",
            "rohirrim",
            "lord_of_the_rings",
            "third_age"
        )
    ),
    CharacterData(
        id = "162",
        name = "Gandalf",
        tags = listOf(
            "ainur",
            "gandalf",
            "mithrandir",
            "olorin",
            "thorin_company",
            "council_of_elrond",
            "fellowship_of_the_ring",
            "white_council",
            "the_hobbit",
            "lord_of_the_rings",
            "silmarillion",
            "third_age",
            "first_age",
            "wizards",
            "maiar",
            "ring_bearer",
            "istari",
            "featured",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "163",
        name = "Gárulf",
        tags = listOf(
            "men",
            "garulf",
            "rohirrim",
            "third_age",
            "lord_of_the_rings",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "164",
        name = "Gelmir (mensajero de Círdan)",
        tags = listOf(
            "elves",
            "gelmir",
            "noldor",
            "silmarillion",
            "first_age",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "165",
        name = "Gelmir (hijo de Guilin)",
        tags = listOf(
            "elves",
            "gelmir",
            "noldor",
            "silmarillion",
            "first_age"
        )
    ),
    CharacterData(
        id = "166",
        name = "Ghân-buri-Ghân",
        tags = listOf(
            "druedain",
            "ghan",
            "ghan buri ghan",
            "ghan-buri-ghan",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "167",
        name = "Gil-galad",
        tags = listOf(
            "elves",
            "gil galad",
            "gil-galad",
            "noldor",
            "silmarillion",
            "first_age",
            "second_age",
            "house_of_finarfin",
            "moriquendi",
            "rulers_in_beleriand",
            "rulers_middle_earth",
            "high_king_of_the_noldor",
            "ring_bearer",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "168",
        name = "Gildor (Edain)",
        tags = listOf(
            "men",
            "gildor",
            "edain",
            "barahir_outlaws",
            "first_age",
            "silmarillion",
            "house_of_beor"
        )
    ),
    CharacterData(
        id = "169",
        name = "Gildor Inglorion",
        tags = listOf(
            "elves",
            "gildor inglorion",
            "noldor",
            "calaquendi",
            "lord_of_the_rings",
            "house_of_finarfin",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "170",
        name = "Gimilkhâd",
        tags = listOf(
            "men",
            "gimilkhad",
            "numenorean",
            "second_age",
            "silmarillion",
            "house_of_elros",
            "kings_men",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "171",
        name = "Gimli",
        tags = listOf(
            "dwarves",
            "gimli",
            "third_age",
            "fourth_age",
            "lord_of_the_rings",
            "fellowship_of_the_ring",
            "council_of_elrond",
            "longbeards",
            "durins_folk",
            "rulers_middle_earth",
            "featured",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "172",
        name = "Girion",
        tags = listOf(
            "men",
            "girion",
            "rulers_middle_earth",
            "men_of_dale",
            "rulers_of_dale",
            "third_age",
            "the_hobbit",
            "death_in_battle",
            "lords_of_dale"
        )
    ),
    CharacterData(
        id = "173",
        name = "Glaurung",
        tags = listOf(
            "dragons",
            "glaurung",
            "first_age",
            "servants_of_morgoth",
            "silmarillion",
            "children_of_hurin",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "174",
        name = "Gléowine",
        tags = listOf(
            "men",
            "gleowine",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "minstrels",
            "minor_character"
        )
    ),
    CharacterData(
        id = "175",
        name = "Glirhuin",
        tags = listOf(
            "silmarillion",
            "glirhuin",
            "men",
            "edain",
            "first_age",
            "house_of_haleth",
            "minstrels",
            "seers"
        )
    ),
    CharacterData(
        id = "176",
        name = "Glóin",
        tags = listOf(
            "gloin",
            "dwarves",
            "durins_folk",
            "the_hobbit",
            "third_age",
            "fourth_age",
            "thorin_company",
            "council_of_elrond",
            "lord_of_the_rings",
            "longbeards",
            "minor_character"
        )
    ),
    CharacterData(
        id = "177",
        name = "Glóredhel",
        tags = listOf(
            "men",
            "gloredhel",
            "edain",
            "silmarillion",
            "children_of_hurin",
            "first_age",
            "house_of_hador",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "178",
        name = "Glorfindel",
        tags = listOf(
            "elves",
            "glorfindel",
            "noldor",
            "council_of_elrond",
            "lords_of_the_twelve_houses",
            "calaquendi",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "gondolindrim",
            "second_age",
            "third_age",
            "book_of_lost_tales",
            "death_in_battle",
            "children_of_hurin",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "179",
        name = "Gobernador de Esgaroth",
        tags = listOf(
            "men",
            "the_hobbit",
            "third_age",
            "lake_men",
            "rulers_middle_earth",
            "esgaroth"
        )
    ),
    CharacterData(
        id = "180",
        name = "Golasgil",
        tags = listOf(
            "men",
            "golasgil",
            "lord_of_the_rings",
            "gondorians",
            "third_age",
            "lords_of_gondor",
            "minor_character"
        )
    ),
    CharacterData(
        id = "181",
        name = "Golfimbul",
        tags = listOf(
            "golfimbul",
            "orcs",
            "the_hobbit",
            "third_age",
            "rulers_middle_earth",
            "death_in_battle",
            "goblins"
        )
    ),
    CharacterData(
        id = "182",
        name = "Gollum",
        tags = listOf(
            "hobbits",
            "the_hobbit",
            "gollum",
            "smeagol",
            "lord_of_the_rings",
            "third_age",
            "ring_bearer",
            "stoors",
            "bearer_of_the_one_ring",
            "featured"
        )
    ),
    CharacterData(
        id = "183",
        name = "Gorbag",
        tags = listOf(
            "orcs",
            "gorbag",
            "lord_of_the_rings",
            "servants_of_sauron",
            "third_age",
            "uruk_hai",
            "morgul_orcs",
            "minor_character"
        )
    ),
    CharacterData(
        id = "184",
        name = "Gorlim",
        tags = listOf(
            "gorlim",
            "edain",
            "men",
            "house_of_beor",
            "barahir_outlaws",
            "first_age",
            "silmarillion",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "185",
        name = "Gothmog (Balrog)",
        tags = listOf(
            "gothmog",
            "balrogs",
            "first_age",
            "silmarillion",
            "servants_of_morgoth",
            "children_of_hurin",
            "maiar",
            "ainur",
            "book_of_lost_tales",
            "valarindi",
            "umaiar",
            "the_history_of_middle_earth",
            "demons"
        )
    ),
    CharacterData(
        id = "186",
        name = "Gothmog (Minas Morgul)",
        tags = listOf(
            "gothmog",
            "lord_of_the_rings",
            "unknown_race",
            "enigmas",
            "servants_of_sauron",
            "third_age"
        )
    ),
    CharacterData(
        id = "187",
        name = "Gran Trasgo",
        tags = listOf(
            "gran trasgo",
            "great goblin",
            "the_hobbit",
            "third_age",
            "rulers_middle_earth",
            "orcs",
            "goblins"
        )
    ),
    CharacterData(
        id = "188",
        name = "Gríma",
        tags = listOf(
            "grima",
            "lengua de serpiente",
            "men",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "servants_of_saruman",
            "servants_of_sauron",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "189",
        name = "Grimbold",
        tags = listOf(
            "grimbold",
            "third_age",
            "rohirrim",
            "lord_of_the_rings",
            "death_in_battle",
            "minor_character"
        )
    ),
    CharacterData(
        id = "190",
        name = "Grishnákh",
        tags = listOf(
            "grishnakh",
            "orcs",
            "lord_of_the_rings",
            "servants_of_sauron",
            "third_age",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "191",
        name = "Grithnir",
        tags = listOf(
            "men",
            "edain",
            "grithnir",
            "first_age",
            "house_of_hador",
            "children_of_hurin",
            "book_of_lost_tales"
        )
    ),
    CharacterData(
        id = "192",
        name = "Guardián del Agua",
        tags = listOf(
            "guardian del agua",
            "lord_of_the_rings",
            "unknown_race",
            "enigmas",
            "third_age",
            "watcher in the water",
            "monsters",
            "minor_character"
        )
    ),
    CharacterData(
        id = "193",
        name = "Guilin",
        tags = listOf(
            "elves",
            "noldor",
            "guilin",
            "first_age",
            "silmarillion",
            "calaquendi"
        )
    ),
    CharacterData(
        id = "194",
        name = "Guille, Berto y Tom",
        tags = listOf(
            "guille",
            "berto",
            "tom",
            "third_age",
            "the_hobbit",
            "trolls"
        )
    ),
    CharacterData(
        id = "195",
        name = "Gundor",
        tags = listOf(
            "edain",
            "men",
            "gundor",
            "first_age",
            "house_of_hador",
            "silmarillion"
        )
    ),
    CharacterData(
        id = "196",
        name = "Guthláf",
        tags = listOf(
            "guthlaf",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "men"
        )
    ),
    CharacterData(
        id = "197",
        name = "Gwaihir",
        tags = listOf(
            "eagles",
            "gwaihir",
            "lord_of_the_rings",
            "first_age",
            "second_age",
            "third_age"
        )
    ),
    CharacterData(
        id = "198",
        name = "Gwindor",
        tags = listOf(
            "gwindor",
            "elves",
            "noldor",
            "first_age",
            "children_of_hurin",
            "silmarillion",
            "book_of_lost_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "199",
        name = "Hador",
        tags = listOf(
            "hador",
            "house_of_hador",
            "men",
            "edain",
            "first_age",
            "silmarillion",
            "lords_of_dor_lomin",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "200",
        name = "Halbarad",
        tags = listOf(
            "halbarad",
            "grey_company",
            "men",
            "dunedain",
            "third_age",
            "lord_of_the_rings",
            "rangers",
            "dunedain_of_the_north",
            "rangers_of_the_north",
            "minor_character"
        )
    ),
    CharacterData(
        id = "201",
        name = "Haldad",
        tags = listOf(
            "men",
            "edain",
            "haldad",
            "silmarillion",
            "first_age",
            "house_of_haleth",
            "rulers_in_beleriand",
            "chieftain_of_the_haladin"
        )
    ),
    CharacterData(
        id = "202",
        name = "Haldan",
        tags = listOf(
            "men",
            "edain",
            "haldan",
            "silmarillion",
            "first_age",
            "house_of_haleth",
            "chieftain_of_the_haladin",
            "lords_of_brethil"
        )
    ),
    CharacterData(
        id = "203",
        name = "Haldar",
        tags = listOf(
            "men",
            "edain",
            "silmarillion",
            "first_age",
            "haldar",
            "house_of_haleth",
            "twins"
        )
    ),
    CharacterData(
        id = "204",
        name = "Haldir (Jefe de los Haladin)",
        tags = listOf(
            "men",
            "edain",
            "house_of_haleth",
            "haldir",
            "first_age",
            "silmarillion",
            "chieftain_of_brethil",
            "lords_of_brethil",
            "unfinished_tales",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "205",
        name = "Haldir",
        tags = listOf(
            "elves",
            "silvan",
            "haldir",
            "third_age",
            "lord_of_the_rings",
            "galadhrim",
            "nandor",
            "minor_character"
        )
    ),
    CharacterData(
        id = "206",
        name = "Haleth",
        tags = listOf(
            "silmarillion",
            "edain",
            "men",
            "house_of_haleth",
            "haleth",
            "first_age",
            "chieftain_of_the_haladin",
            "twins",
            "lords_of_brethil"
        )
    ),
    CharacterData(
        id = "207",
        name = "Halmir",
        tags = listOf(
            "men",
            "edain",
            "halmir",
            "silmarillion",
            "first_age",
            "house_of_haleth",
            "chieftain_of_brethil",
            "lords_of_brethil",
            "chieftain_of_the_haladin"
        )
    ),
    CharacterData(
        id = "208",
        name = "Háma",
        tags = listOf(
            "men",
            "rohirrim",
            "lord_of_the_rings",
            "hama",
            "third_age"
        )
    ),
    CharacterData(
        id = "209",
        name = "Hamfast Gamyi",
        tags = listOf(
            "hobbits",
            "hamfast",
            "gamyi",
            "lord_of_the_rings",
            "gamgee",
            "third_age",
            "fourth_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "210",
        name = "Handir",
        tags = listOf(
            "men",
            "edain",
            "handir",
            "house_of_haleth",
            "first_age",
            "silmarillion",
            "chieftain_of_brethil",
            "chieftain_of_the_haladin",
            "lords_of_brethil"
        )
    ),
    CharacterData(
        id = "211",
        name = "Harding",
        tags = listOf(
            "men",
            "rohirrim",
            "harding",
            "third_age",
            "lord_of_the_rings",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "212",
        name = "Hareth",
        tags = listOf(
            "hareth",
            "silmarillion",
            "first_age",
            "men",
            "edain",
            "house_of_haleth",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "213",
        name = "Enrique Madreselva",
        tags = listOf(
            "harry goatleaf",
            "herri madreselva",
            "lord_of_the_rings",
            "third_age",
            "men",
            "bree_men",
            "servants_of_saruman",
            "servants_of_sauron"
        )
    ),
    CharacterData(
        id = "214",
        name = "Hathaldir",
        tags = listOf(
            "men",
            "edain",
            "first_age",
            "hathaldir",
            "barahir_outlaws",
            "silmarillion",
            "house_of_beor"
        )
    ),
    CharacterData(
        id = "215",
        name = "Hathol",
        tags = listOf(
            "men",
            "edain",
            "silmarillion",
            "first_age",
            "hathol",
            "house_of_hador",
            "chieftain_of_the_haladin"
        )
    ),
    CharacterData(
        id = "216",
        name = "Herefara",
        tags = listOf(
            "men",
            "rohirrim",
            "herefara",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "217",
        name = "Herubrand",
        tags = listOf(
            "men",
            "rohirrim",
            "herubrand",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "218",
        name = "Herumor",
        tags = listOf(
            "men",
            "black_numenoreans",
            "silmarillion",
            "herumor",
            "mariners",
            "numenorean",
            "second_age",
            "servants_of_sauron"
        )
    ),
    CharacterData(
        id = "219",
        name = "Hirgon",
        tags = listOf(
            "men",
            "hirgon",
            "gondorians",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "220",
        name = "Hirluin",
        tags = listOf(
            "hirluin",
            "gondorians",
            "men",
            "third_age",
            "lord_of_the_rings",
            "dunedain",
            "lords_of_gondor",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "221",
        name = "Hob Guardacercas",
        tags = listOf(
            "hobbits",
            "hob guardacercas",
            "hob hayward",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "222",
        name = "Hombres Muertos de el Sagrario",
        tags = listOf(
            "lord_of_the_rings",
            "hombres muertos de el sagrario",
            "oathbreakers",
            "muertos",
            "gondorians",
            "undead",
            "servants_of_sauron",
            "armies"
        )
    ),
    CharacterData(
        id = "223",
        name = "Horn",
        tags = listOf(
            "men",
            "rohirrim",
            "horn",
            "lord_of_the_rings",
            "third_age",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "224",
        name = "Huan",
        tags = listOf(
            "silmarillion",
            "dogs",
            "first_age",
            "huan",
            "book_of_lost_tales",
            "other_races",
            "the_history_of_middle_earth",
            "valar_animals"
        )
    ),
    CharacterData(
        id = "225",
        name = "Hunthor",
        tags = listOf(
            "men",
            "hunthor",
            "house_of_haleth",
            "edain",
            "children_of_hurin",
            "silmarillion",
            "first_age"
        )
    ),
    CharacterData(
        id = "226",
        name = "Huor",
        tags = listOf(
            "huor",
            "men",
            "first_age",
            "silmarillion",
            "edain",
            "house_of_hador",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "227",
        name = "Húrin",
        tags = listOf(
            "hurin",
            "men",
            "edain",
            "first_age",
            "silmarillion",
            "children_of_hurin",
            "house_of_hador",
            "lords_of_dor_lomin",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "228",
        name = "Húrin (Guardián de las Llaves)",
        tags = listOf(
            "men",
            "gondorians",
            "hurin",
            "third_age",
            "lord_of_the_rings",
            "dunedain",
            "minor_character"
        )
    ),
    CharacterData(
        id = "229",
        name = "Ibûn",
        tags = listOf(
            "dwarves",
            "petty_dwarves",
            "ibun",
            "first_age",
            "silmarillion",
            "children_of_hurin",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "230",
        name = "Idril",
        tags = listOf(
            "elves",
            "noldor",
            "idril",
            "first_age",
            "calaquendi",
            "silmarillion",
            "gondolindrim",
            "house_of_fingolfin",
            "book_of_lost_tales",
            "rulers_in_beleriand",
            "princesses",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "231",
        name = "Ilmarë",
        tags = listOf(
            "silmarillion",
            "maiar",
            "ilmare",
            "ainur",
            "book_of_lost_tales",
            "valarindi",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "232",
        name = "Imlach",
        tags = listOf(
            "men",
            "imlach",
            "silmarillion",
            "first_age",
            "edain",
            "house_of_hador",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "233",
        name = "Imrahil",
        tags = listOf(
            "men",
            "gondorians",
            "imrahil",
            "lord_of_the_rings",
            "third_age",
            "fourth_age",
            "dunedain",
            "princes_of_dol_amroth",
            "lords_of_gondor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "234",
        name = "Indis",
        tags = listOf(
            "elves",
            "indis",
            "vanyar",
            "calaquendi",
            "silmarillion",
            "first_age",
            "house_of_ingwe",
            "minyar",
            "queens",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "235",
        name = "Indor",
        tags = listOf(
            "men",
            "edain",
            "first_age",
            "children_of_hurin",
            "indor",
            "house_of_hador"
        )
    ),
    CharacterData(
        id = "236",
        name = "Ingold",
        tags = listOf(
            "men",
            "gondorians",
            "ingold",
            "lord_of_the_rings",
            "third_age",
            "dunedain",
            "minor_character"
        )
    ),
    CharacterData(
        id = "237",
        name = "Ingwë",
        tags = listOf(
            "elves",
            "vanyar",
            "calaquendi",
            "ingwe",
            "house_of_ingwe",
            "silmarillion",
            "first_age",
            "ruler_aman",
            "book_of_lost_tales",
            "house_of_imin",
            "minyar",
            "kings",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "238",
        name = "Inzilbêth",
        tags = listOf(
            "men",
            "numenorean",
            "second_age",
            "inzilbeth",
            "silmarillion",
            "faithful",
            "queens_of_numenor",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "239",
        name = "Ioreth",
        tags = listOf(
            "men",
            "ioreth",
            "lord_of_the_rings",
            "third_age",
            "gondorians",
            "minor_character"
        )
    ),
    CharacterData(
        id = "240",
        name = "Iorlas",
        tags = listOf(
            "men",
            "gondorians",
            "iorlas",
            "lord_of_the_rings",
            "third_age"
        )
    ),
    CharacterData(
        id = "241",
        name = "Irmo (Lórien)",
        tags = listOf(
            "valar",
            "irmo",
            "lorien",
            "silmarillion",
            "first_age",
            "ainur",
            "book_of_lost_tales"
        )
    ),
    CharacterData(
        id = "242",
        name = "Isildur",
        tags = listOf(
            "men",
            "isildur",
            "house_of_elendil",
            "house_of_isildur",
            "numenorean",
            "ring_bearer",
            "silmarillion",
            "mariners",
            "ruler_of_arnor",
            "ruler_of_gondor",
            "second_age",
            "third_age",
            "numenor_key_people",
            "bearer_of_the_one_ring",
            "featured",
            "unfinished_tales",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "243",
        name = "Khamûl",
        tags = listOf(
            "lord_of_the_rings",
            "khamul",
            "third_age",
            "easterling",
            "nazgul",
            "second_age",
            "servants_of_sauron",
            "ring_bearer",
            "army_of_mordor",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "244",
        name = "Khîm",
        tags = listOf(
            "dwarves",
            "khim",
            "first_age",
            "petty_dwarves",
            "silmarillion",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "245",
        name = "Kíli",
        tags = listOf(
            "dwarves",
            "kili",
            "third_age",
            "the_hobbit",
            "thorin_company",
            "durins_folk",
            "longbeards",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "246",
        name = "Lagduf",
        tags = listOf(
            "lagduf",
            "orcs",
            "lord_of_the_rings",
            "third_age",
            "servants_of_sauron",
            "minor_character"
        )
    ),
    CharacterData(
        id = "247",
        name = "Landroval",
        tags = listOf(
            "eagles",
            "landroval",
            "lord_of_the_rings",
            "first_age",
            "second_age",
            "third_age",
            "minor_character",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "248",
        name = "Legolas",
        tags = listOf(
            "legolas",
            "sindar",
            "elves",
            "third_age",
            "lord_of_the_rings",
            "council_of_elrond",
            "fellowship_of_the_ring",
            "fourth_age",
            "moriquendi",
            "rulers_middle_earth",
            "featured",
            "grey_elves"
        )
    ),
    CharacterData(
        id = "249",
        name = "Lenwë",
        tags = listOf(
            "elves",
            "nandor",
            "lenwe",
            "first_age",
            "silmarillion",
            "rulers_middle_earth",
            "nelyar"
        )
    ),
    CharacterData(
        id = "250",
        name = "Lindir",
        tags = listOf(
            "elves",
            "lindir",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "251",
        name = "Lindórië",
        tags = listOf(
            "men",
            "lindorie",
            "numenorean",
            "house_of_valandil",
            "silmarillion",
            "faithful",
            "second_age",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "252",
        name = "Lobelia Sacovilla-Bolsón",
        tags = listOf(
            "hobbits",
            "ciñatiesa",
            "sacovilla",
            "bracegirdle",
            "the_hobbit",
            "lord_of_the_rings",
            "sackville-baggins",
            "third_age",
            "lobelia",
            "sacovilla-bolson",
            "minor_character"
        )
    ),
    CharacterData(
        id = "253",
        name = "Lorgan",
        tags = listOf(
            "silmarillion",
            "easterling",
            "lorgan",
            "first_age",
            "men",
            "servants_of_morgoth"
        )
    ),
    CharacterData(
        id = "254",
        name = "Lotho Sacovilla-Bolsón",
        tags = listOf(
            "hobbits",
            "lotho",
            "sacovilla",
            "bolson",
            "sacovilla-bolson",
            "sackville_baggins",
            "third_age",
            "lord_of_the_rings",
            "servants_of_saruman",
            "rulers_middle_earth",
            "minor_character",
            "shirriffs"
        )
    ),
    CharacterData(
        id = "255",
        name = "Lugdush",
        tags = listOf(
            "orcs",
            "lugdush",
            "uruk-hai",
            "third_age",
            "lord_of_the_rings",
            "servants_of_saruman",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "256",
        name = "Lúthien",
        tags = listOf(
            "silmarillion",
            "luthien",
            "first_age",
            "moriquendi",
            "half_elf",
            "half_maia",
            "book_of_lost_tales",
            "house_of_elwe",
            "tinuviel",
            "grey_elves",
            "fays",
            "princesses",
            "the_history_of_middle_earth",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "257",
        name = "Mablung",
        tags = listOf(
            "elves",
            "sindar",
            "mablung",
            "silmarillion",
            "first_age",
            "children_of_hurin",
            "moriquendi",
            "book_of_lost_tales",
            "grey_elves",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "258",
        name = "Mablung (Montaraz de Ithilien)",
        tags = listOf(
            "men",
            "mablung",
            "rangers",
            "third_age",
            "dunedain",
            "gondorians",
            "lord_of_the_rings",
            "rangers_of_ithilien",
            "minor_character"
        )
    ),
    CharacterData(
        id = "259",
        name = "Maedhros",
        tags = listOf(
            "maedhros",
            "elves",
            "noldor",
            "house_of_feanor",
            "silmarillion",
            "first_age",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "sons_of_feanor",
            "the_history_of_middle_earth",
            "high_king_of_the_noldor"
        )
    ),
    CharacterData(
        id = "260",
        name = "Maeglin",
        tags = listOf(
            "elves",
            "sindar",
            "maeglin",
            "silmarillion",
            "first_age",
            "gondolindrim",
            "house_of_fingolfin",
            "moriquendi",
            "servants_of_morgoth",
            "noldor",
            "smiths",
            "lords_of_the_twelve_houses",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "261",
        name = "Granjero Maggot",
        tags = listOf(
            "maggot",
            "farmer",
            "granjero",
            "third_age",
            "hobbits",
            "lord_of_the_rings",
            "the_adventures_of_tom_bombadil",
            "minor_character"
        )
    ),
    CharacterData(
        id = "262",
        name = "Maglor",
        tags = listOf(
            "elves",
            "maglor",
            "first_age",
            "silmarillion",
            "house_of_feanor",
            "noldor",
            "minstrels",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "sons_of_feanor",
            "loremasters",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "263",
        name = "Magor",
        tags = listOf(
            "men",
            "magor",
            "first_age",
            "house_of_hador",
            "edain",
            "rulers_in_beleriand",
            "silmarillion",
            "chieftain_of_the_house_of_hador"
        )
    ),
    CharacterData(
        id = "264",
        name = "Mahtan",
        tags = listOf(
            "elves",
            "noldor",
            "calaquendi",
            "silmarillion",
            "mahtan",
            "first_age",
            "smiths",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "265",
        name = "Malach",
        tags = listOf(
            "men",
            "edain",
            "malach",
            "house_of_hador",
            "first_age",
            "silmarillion",
            "chieftain_of_the_house_of_hador"
        )
    ),
    CharacterData(
        id = "266",
        name = "Manwë",
        tags = listOf(
            "valar",
            "ainur",
            "manwe",
            "silmarillion",
            "first_age",
            "ruler_aman",
            "second_age",
            "third_age",
            "aratar",
            "book_of_lost_tales",
            "kings",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "267",
        name = "Marach",
        tags = listOf(
            "men",
            "edain",
            "first_age",
            "marach",
            "silmarillion",
            "house_of_hador",
            "chieftain_of_the_house_of_hador"
        )
    ),
    CharacterData(
        id = "268",
        name = "Mardil",
        tags = listOf(
            "men",
            "gondorians",
            "silmarillion",
            "house_of_hurin",
            "ruling_stewards",
            "mardil",
            "third_age",
            "stewards",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "269",
        name = "Mauhúr",
        tags = listOf(
            "orcs",
            "mauhur",
            "uruk-hai",
            "third_age",
            "lord_of_the_rings",
            "servants_of_saruman"
        )
    ),
    CharacterData(
        id = "270",
        name = "Melian",
        tags = listOf(
            "melian",
            "maiar",
            "ainur",
            "first_age",
            "silmarillion",
            "children_of_hurin",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "fays",
            "queens",
            "the_history_of_middle_earth",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "271",
        name = "Morgoth",
        tags = listOf(
            "melkor",
            "morgoth",
            "silmarillion",
            "first_age",
            "valar",
            "ainur",
            "children_of_hurin",
            "rulers_middle_earth",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "beren_and_luthien",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "272",
        name = "Meneldil",
        tags = listOf(
            "men",
            "numenorean",
            "meneldil",
            "second_age",
            "third_age",
            "ruler_of_gondor",
            "silmarillion",
            "house_of_anarion",
            "dunedain",
            "the_history_of_middle_earth",
            "gondorians",
            "kings_of_gondor"
        )
    ),
    CharacterData(
        id = "273",
        name = "Meneldor",
        tags = listOf(
            "eagles",
            "lord_of_the_rings",
            "third_age",
            "meneldor",
            "minor_character"
        )
    ),
    CharacterData(
        id = "274",
        name = "Meriadoc Brandigamo",
        tags = listOf(
            "meriadoc",
            "brandigamo",
            "merry",
            "hobbits",
            "fellowship_of_the_ring",
            "lord_of_the_rings",
            "brandybuck",
            "third_age",
            "fourth_age",
            "masters_of_buckland",
            "featured",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "275",
        name = "Mîm",
        tags = listOf(
            "dwarves",
            "mim",
            "silmarillion",
            "children_of_hurin",
            "first_age",
            "petty_dwarves",
            "smiths",
            "book_of_lost_tales",
            "unfinished_tales",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "276",
        name = "Míriel",
        tags = listOf(
            "elves",
            "miriel",
            "noldor",
            "silmarillion",
            "first_age",
            "calaquendi",
            "tatyar",
            "queens",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "277",
        name = "Morwen",
        tags = listOf(
            "men",
            "morwen",
            "edain",
            "house_of_beor",
            "children_of_hurin",
            "silmarillion",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "278",
        name = "Muzgash",
        tags = listOf(
            "orcs",
            "muzgash",
            "third_age",
            "lord_of_the_rings",
            "servants_of_sauron",
            "minor_character"
        )
    ),
    CharacterData(
        id = "279",
        name = "Nahar",
        tags = listOf(
            "nahar",
            "silmarillion",
            "horses",
            "valar_animals"
        )
    ),
    CharacterData(
        id = "280",
        name = "Namo (Mandos)",
        tags = listOf(
            "namo",
            "mandos",
            "ainur",
            "valar",
            "feanturi",
            "aratar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "281",
        name = "Nellas",
        tags = listOf(
            "elves",
            "nellas",
            "children_of_hurin",
            "first_age",
            "sindar",
            "grey_elves",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "282",
        name = "Nerdanel",
        tags = listOf(
            "elves",
            "nerdanel",
            "noldor",
            "calaquendi",
            "silmarillion",
            "first_age",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "283",
        name = "Nessa",
        tags = listOf(
            "valar",
            "ainur",
            "nessa",
            "silmarillion",
            "first_age",
            "valarindi",
            "book_of_lost_tales",
            "the_history_of_middle_earth",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "284",
        name = "Nienna",
        tags = listOf(
            "valar",
            "ainur",
            "nienna",
            "aratar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "queens",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "285",
        name = "Nienor",
        tags = listOf(
            "nienor",
            "niniel",
            "edain",
            "men",
            "house_of_hador",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "286",
        name = "Nimloth",
        tags = listOf(
            "nimloth",
            "elves",
            "sindar",
            "silmarillion",
            "first_age",
            "moriquendi",
            "queens",
            "grey_elves",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "287",
        name = "Nob",
        tags = listOf(
            "hobbits",
            "nob",
            "third_age",
            "lord_of_the_rings",
            "minor_character",
            "bree_hobbits"
        )
    ),
    CharacterData(
        id = "288",
        name = "Nori",
        tags = listOf(
            "nori",
            "dwarves",
            "third_age",
            "thorin_company",
            "the_hobbit",
            "durins_folk",
            "longbeards"
        )
    ),
    CharacterData(
        id = "289",
        name = "Odo Ganapié",
        tags = listOf(
            "odo",
            "ganapie",
            "proudfoot",
            "hobbits",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "290",
        name = "Ohtar",
        tags = listOf(
            "dunedain",
            "men",
            "ohtar",
            "silmarillion",
            "second_age",
            "third_age",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "291",
        name = "Óin",
        tags = listOf(
            "oin",
            "dwarves",
            "thorin_company",
            "the_hobbit",
            "third_age",
            "longbeards"
        )
    ),
    CharacterData(
        id = "292",
        name = "Olwë",
        tags = listOf(
            "elves",
            "teleri",
            "falmari",
            "olwe",
            "calaquendi",
            "silmarillion",
            "first_age",
            "ruler_aman",
            "nelyar",
            "the_history_of_middle_earth",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "293",
        name = "Ori",
        tags = listOf(
            "ori",
            "dwarves",
            "thorin_company",
            "the_hobbit",
            "third_age",
            "longbeards",
            "durins_folk"
        )
    ),
    CharacterData(
        id = "294",
        name = "Orleg",
        tags = listOf(
            "orleg",
            "edain",
            "first_age",
            "children_of_hurin",
            "men",
            "gaurwaith"
        )
    ),
    CharacterData(
        id = "295",
        name = "Orodreth",
        tags = listOf(
            "elves",
            "noldor",
            "orodreth",
            "calaquendi",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "house_of_finarfin",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "death_in_battle",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "296",
        name = "Oromë",
        tags = listOf(
            "orome",
            "valar",
            "ainur",
            "aratar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "valarindi",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "297",
        name = "Oropher",
        tags = listOf(
            "oropher",
            "elves",
            "sindar",
            "moriquendi",
            "first_age",
            "second_age",
            "rulers_middle_earth",
            "grey_elves",
            "kings",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "death_in_battle",
            "lords_of_the_silvan_elves"
        )
    ),
    CharacterData(
        id = "298",
        name = "Orophin",
        tags = listOf(
            "elves",
            "silvan",
            "orophin",
            "third_age",
            "lord_of_the_rings",
            "galadhrim",
            "nandor",
            "minor_character"
        )
    ),
    CharacterData(
        id = "299",
        name = "Ossë",
        tags = listOf(
            "osse",
            "silmarillion",
            "maiar",
            "ainur",
            "first_age",
            "second_age",
            "servants_of_morgoth",
            "book_of_lost_tales"
        )
    ),
    CharacterData(
        id = "300",
        name = "Otho Sacovilla-Bolsón",
        tags = listOf(
            "otho",
            "sacovilla",
            "bolson",
            "sackville-baggins",
            "sacovilla-bolson",
            "hobbits",
            "third_age",
            "lord_of_the_rings",
            "minor_character"
        )
    ),
    CharacterData(
        id = "301",
        name = "Papá Dospiés",
        tags = listOf(
            "papa",
            "dospies",
            "daddy",
            "twofoot",
            "third_age",
            "lord_of_the_rings",
            "hobbits",
            "minor_character"
        )
    ),
    CharacterData(
        id = "302",
        name = "Peregrin Tuk",
        tags = listOf(
            "peregrin",
            "took",
            "tuk",
            "pippin",
            "hobbits",
            "fellowship_of_the_ring",
            "thains",
            "lord_of_the_rings",
            "fourth_age",
            "third_age",
            "featured",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "303",
        name = "Radagast",
        tags = listOf(
            "maiar",
            "ainur",
            "istari",
            "radagast",
            "third_age",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "wizards",
            "unfinished_tales",
            "white_council"
        )
    ),
    CharacterData(
        id = "304",
        name = "Radbug",
        tags = listOf(
            "radbug",
            "lord_of_the_rings",
            "orcs",
            "servants_of_sauron",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "305",
        name = "Radhruin",
        tags = listOf(
            "men",
            "edain",
            "house_of_beor",
            "barahir_outlaws",
            "silmarillion",
            "radhruin",
            "first_age",
            "beren_and_luthien"
        )
    ),
    CharacterData(
        id = "306",
        name = "Ragnor",
        tags = listOf(
            "men",
            "edain",
            "ragnor",
            "first_age",
            "silmarillion",
            "house_of_beor",
            "barahir_outlaws",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "307",
        name = "Rey Brujo",
        tags = listOf(
            "rey brujo",
            "witch king",
            "servants_of_sauron",
            "second_age",
            "nazgul",
            "silmarillion",
            "third_age",
            "witch",
            "brujo",
            "men",
            "wraith",
            "featured",
            "ring_bearer",
            "kings",
            "death_in_battle",
            "army_of_mordor"
        )
    ),
    CharacterData(
        id = "308",
        name = "Rey de los Muertos",
        tags = listOf(
            "lord_of_the_rings",
            "rey de los muertos",
            "servants_of_sauron",
            "third_age",
            "men",
            "wraith",
            "second_age",
            "kings",
            "minor_character",
            "undead"
        )
    ),
    CharacterData(
        id = "309",
        name = "Rían",
        tags = listOf(
            "men",
            "rian",
            "edain",
            "silmarillion",
            "first_age",
            "house_of_beor",
            "unfinished_tales",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "310",
        name = "Roäc",
        tags = listOf(
            "ravens",
            "roac",
            "the_hobbit",
            "third_age"
        )
    ),
    CharacterData(
        id = "311",
        name = "Robin Madriguera",
        tags = listOf(
            "robin",
            "madriguera",
            "smallburrow",
            "third_age",
            "hobbits",
            "lord_of_the_rings",
            "servants_of_saruman",
            "minor_character",
            "shirriffs"
        )
    ),
    CharacterData(
        id = "312",
        name = "Rochallor",
        tags = listOf(
            "rochallor",
            "horses",
            "silmarillion",
            "first_age"
        )
    ),
    CharacterData(
        id = "313",
        name = "Rosa Coto",
        tags = listOf(
            "rosie",
            "rosa",
            "coto",
            "cotton",
            "rosita",
            "hobbits",
            "lord_of_the_rings",
            "third_age",
            "fourth_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "314",
        name = "Rúmil (Tirion)",
        tags = listOf(
            "elves",
            "rumil",
            "noldor",
            "calaquendi",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "chroniclers_of_arda",
            "the_history_of_middle_earth",
            "story_tellers",
            "loremasters"
        )
    ),
    CharacterData(
        id = "315",
        name = "Rúmil (Lórien)",
        tags = listOf(
            "elves",
            "rumil",
            "silvan",
            "lord_of_the_rings",
            "third_age",
            "galadhrim",
            "nandor",
            "minor_character"
        )
    ),
    CharacterData(
        id = "316",
        name = "Sador",
        tags = listOf(
            "edain",
            "sador",
            "children_of_hurin",
            "house_of_hador",
            "first_age",
            "unfinished_tales",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "317",
        name = "Saeros",
        tags = listOf(
            "elves",
            "nandor",
            "saeros",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "318",
        name = "Salmar",
        tags = listOf(
            "maiar",
            "ainur",
            "salmar",
            "silmarillion",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "319",
        name = "Samsagaz Gamyi",
        tags = listOf(
            "hobbits",
            "samsagaz",
            "sam",
            "samwise",
            "gamyi",
            "gamgee",
            "council_of_elrond",
            "ring_bearer",
            "fellowship_of_the_ring",
            "third_age",
            "lord_of_the_rings",
            "fourth_age",
            "mayors_of_michel_delving",
            "bearer_of_the_one_ring",
            "chroniclers_of_arda",
            "featured"
        )
    ),
    CharacterData(
        id = "320",
        name = "Saruman",
        tags = listOf(
            "saruman",
            "maiar",
            "ainur",
            "istari",
            "third_age",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "rulers_middle_earth",
            "servants_of_sauron",
            "smiths",
            "wizards",
            "white_council"
        )
    ),
    CharacterData(
        id = "321",
        name = "Sauron",
        tags = listOf(
            "sauron",
            "annatar",
            "maiar",
            "ainur",
            "ring_bearer",
            "lord_of_the_rings",
            "silmarillion",
            "first_age",
            "second_age",
            "third_age",
            "rulers_middle_earth",
            "servants_of_morgoth",
            "smiths",
            "gorthaur",
            "mairon",
            "numenor_key_people",
            "bearer_of_the_one_ring",
            "featured",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "322",
        name = "Señor de las Águilas",
        tags = listOf(
            "eagles",
            "lord of eagles",
            "señor",
            "gran aguila",
            "aguilas",
            "the_hobbit",
            "rulers_middle_earth",
            "third_age"
        )
    ),
    CharacterData(
        id = "323",
        name = "Shagrat",
        tags = listOf(
            "shagrat",
            "uruk-hai",
            "servants_of_sauron",
            "lord_of_the_rings",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "324",
        name = "Silmariën",
        tags = listOf(
            "silmarien",
            "men",
            "numenorean",
            "silmarillion",
            "house_of_elros",
            "second_age",
            "numenor_key_people",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "princesses"
        )
    ),
    CharacterData(
        id = "325",
        name = "Smaug",
        tags = listOf(
            "dragons",
            "smaug",
            "the_hobbit",
            "third_age",
            "death_in_battle",
            "kings"
        )
    ),
    CharacterData(
        id = "326",
        name = "Snaga (Isengard)",
        tags = listOf(
            "snaga",
            "orcs",
            "third_age",
            "lord_of_the_rings",
            "servants_of_saruman",
            "minor_character"
        )
    ),
    CharacterData(
        id = "327",
        name = "Tar-Ancalimon",
        tags = listOf(
            "men",
            "ancalimon",
            "tar-ancalimon",
            "silmarillion",
            "house_of_elros",
            "rulers_of_numenor",
            "second_age",
            "numenorean",
            "kings_men",
            "kings_of_numenor",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "328",
        name = "Tar-Atanamir",
        tags = listOf(
            "men",
            "tar-atanamir",
            "atanamir",
            "house_of_elros",
            "silmarillion",
            "rulers_of_numenor",
            "second_age",
            "numenorean",
            "kings_of_numenor",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "329",
        name = "Tar-Ciryatan",
        tags = listOf(
            "men",
            "tar-ciryatan",
            "ciryatan",
            "house_of_elros",
            "silmarillion",
            "rulers_of_numenor",
            "second_age",
            "numenorean",
            "kings_of_numenor",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "330",
        name = "Tar-Elendil",
        tags = listOf(
            "men",
            "numenorean",
            "tar-elendil",
            "elendil",
            "house_of_elros",
            "silmarillion",
            "second_age",
            "rulers_of_numenor",
            "kings_of_numenor",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "331",
        name = "Tar-Minastir",
        tags = listOf(
            "men",
            "numenorean",
            "tar-minastir",
            "minastir",
            "silmarillion",
            "second_age",
            "rulers_of_numenor",
            "house_of_elros",
            "kings_of_numenor",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "332",
        name = "Tar-Míriel",
        tags = listOf(
            "men",
            "tar-miriel",
            "tar miriel",
            "miriel",
            "second_age",
            "silmarillion",
            "house_of_elros",
            "numenorean",
            "faithful",
            "kings_of_numenor",
            "queens_of_numenor"
        )
    ),
    CharacterData(
        id = "333",
        name = "Tar-Palantir",
        tags = listOf(
            "men",
            "numenorean",
            "tar-palantir",
            "tar palantir",
            "palantir",
            "second_age",
            "silmarillion",
            "house_of_elros",
            "faithful",
            "kings_of_numenor",
            "numenor_key_people",
            "rulers_of_numenor",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "334",
        name = "Ted Arenas",
        tags = listOf(
            "hobbits",
            "ted",
            "ted arenas",
            "arenas",
            "third_age",
            "lord_of_the_rings",
            "sandyman",
            "minor_character"
        )
    ),
    CharacterData(
        id = "335",
        name = "Telchar",
        tags = listOf(
            "telchar",
            "dwarves",
            "first_age",
            "silmarillion",
            "smiths",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "336",
        name = "Telemnar",
        tags = listOf(
            "telemnar",
            "gondorians",
            "men",
            "silmarillion",
            "house_of_anarion",
            "ruler_of_gondor",
            "third_age",
            "dunedain",
            "kings_of_gondor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "337",
        name = "Théoden",
        tags = listOf(
            "men",
            "theoden",
            "rohirrim",
            "third_age",
            "lord_of_the_rings",
            "kings_of_rohan",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "338",
        name = "Théodred",
        tags = listOf(
            "theodred",
            "men",
            "rohirrim",
            "third_age",
            "lord_of_the_rings",
            "minor_character",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "339",
        name = "Thingol",
        tags = listOf(
            "elves",
            "sindar",
            "elu thingol",
            "singollo",
            "elu",
            "thingol",
            "elwe",
            "silmarillion",
            "first_age",
            "calaquendi",
            "children_of_hurin",
            "house_of_elwe",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "nelyar",
            "rulers_in_the_great_lands",
            "kings",
            "teleri",
            "grey_elves",
            "the_history_of_middle_earth",
            "unfinished_tales",
            "beren_and_luthien",
            "kings_of_doriath"
        )
    ),
    CharacterData(
        id = "340",
        name = "Thorin II",
        tags = listOf(
            "thorin",
            "thorin II",
            "thorin ii",
            "escudo de roble",
            "oakenshield",
            "dwarves",
            "third_age",
            "the_hobbit",
            "thorin_company",
            "durins_folk",
            "longbeards",
            "smiths",
            "kings_of_durins_folk",
            "kings_under_the_mountain",
            "featured",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "341",
        name = "Thorondor",
        tags = listOf(
            "eagles",
            "thorondor",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "rulers_in_beleriand",
            "book_of_lost_tales",
            "kings",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "342",
        name = "Thráin II",
        tags = listOf(
            "thrain",
            "thrain ii",
            "dwarves",
            "the_hobbit",
            "durins_folk",
            "longbeards",
            "third_age",
            "kings_of_durins_folk",
            "kings_under_the_mountain",
            "ring_bearer"
        )
    ),
    CharacterData(
        id = "343",
        name = "Thranduil",
        tags = listOf(
            "thranduil",
            "elvenking",
            "elves",
            "sindar",
            "the_hobbit",
            "lord_of_the_rings",
            "silmarillion",
            "moriquendi",
            "rulers_middle_earth",
            "second_age",
            "third_age",
            "grey_elves",
            "kings",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "minor_character",
            "lords_of_the_silvan_elves"
        )
    ),
    CharacterData(
        id = "344",
        name = "Thrór",
        tags = listOf(
            "dwarves",
            "thror",
            "durins_folk",
            "the_hobbit",
            "longbeards",
            "third_age",
            "kings_of_durins_folk",
            "kings_under_the_mountain",
            "ring_bearer"
        )
    ),
    CharacterData(
        id = "345",
        name = "Thuringwethil",
        tags = listOf(
            "thuringwethil",
            "silmarillion",
            "unknown_race",
            "vampire",
            "enigmas",
            "first_age",
            "servants_of_morgoth",
            "servants_of_sauron",
            "bats",
            "fays",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "346",
        name = "Tilion",
        tags = listOf(
            "tilion",
            "maiar",
            "ainur",
            "silmarillion",
            "first_age",
            "middle_earth_cosmology"
        )
    ),
    CharacterData(
        id = "347",
        name = "Tolman Coto",
        tags = listOf(
            "tolman",
            "tom coto",
            "tolman coto",
            "tom",
            "cotton",
            "coto",
            "third_age",
            "lord_of_the_rings",
            "fourth_age",
            "hobbits",
            "minor_character"
        )
    ),
    CharacterData(
        id = "348",
        name = "Tom Bombadil",
        tags = listOf(
            "tom",
            "bombadil",
            "lord_of_the_rings",
            "enigmas",
            "first_age",
            "second_age",
            "third_age",
            "ring_bearer",
            "bearer_of_the_one_ring",
            "forest_folk",
            "spirits",
            "unknown_race"
        )
    ),
    CharacterData(
        id = "349",
        name = "Tulkas",
        tags = listOf(
            "ainur",
            "tulkas",
            "valar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "350",
        name = "Tuor",
        tags = listOf(
            "men",
            "edain",
            "first_age",
            "silmarillion",
            "tuor",
            "gondolindrim",
            "house_of_hador",
            "mariners",
            "lords_of_the_twelve_houses",
            "book_of_lost_tales",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "351",
        name = "Turgon",
        tags = listOf(
            "turgon",
            "house_of_fingolfin",
            "elves",
            "noldor",
            "silmarillion",
            "calaquendi",
            "first_age",
            "gondolindrim",
            "rulers_in_beleriand",
            "lords_of_the_twelve_houses",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "high_king_of_the_noldor",
            "unfinished_tales",
            "the_history_of_middle_earth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "352",
        name = "Túrin",
        tags = listOf(
            "turin",
            "men",
            "edain",
            "turambar",
            "gaurwaith",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "house_of_hador",
            "book_of_lost_tales",
            "rulers_in_the_great_lands",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "353",
        name = "Uglúk",
        tags = listOf(
            "ugluk",
            "orcs",
            "uruk-hai",
            "third_age",
            "lord_of_the_rings",
            "servants_of_saruman",
            "minor_character",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "354",
        name = "Uinen",
        tags = listOf(
            "uinen",
            "maiar",
            "ainur",
            "silmarillion",
            "first_age",
            "second_age",
            "book_of_lost_tales",
            "fays",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "355",
        name = "Uldor",
        tags = listOf(
            "men",
            "uldor",
            "easterling",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "rulers_in_beleriand",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "356",
        name = "Ulfang",
        tags = listOf(
            "men",
            "easterling",
            "ulfang",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "rulers_in_beleriand",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "357",
        name = "Ulfast",
        tags = listOf(
            "men",
            "easterling",
            "ulfast",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "358",
        name = "Ulmo",
        tags = listOf(
            "valar",
            "ulmo",
            "ainur",
            "aratar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "359",
        name = "Ulrad",
        tags = listOf(
            "edain",
            "ulrad",
            "men",
            "silmarillion",
            "first_age",
            "gaurwaith",
            "children_of_hurin"
        )
    ),
    CharacterData(
        id = "360",
        name = "Ulwarth",
        tags = listOf(
            "ulwarth",
            "men",
            "easterling",
            "silmarillion",
            "first_age",
            "servants_of_morgoth",
            "death_in_battle"
        )
    ),
    CharacterData(
        id = "361",
        name = "Ungoliant",
        tags = listOf(
            "ungoliant",
            "silmarillion",
            "enigmas",
            "first_age",
            "servants_of_morgoth",
            "spiders",
            "spirits",
            "book_of_lost_tales",
            "demons",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "362",
        name = "Urthel",
        tags = listOf(
            "urthel",
            "men",
            "edain",
            "house_of_beor",
            "first_age",
            "silmarillion",
            "barahir_outlaws",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "363",
        name = "Urwen",
        tags = listOf(
            "men",
            "urwen",
            "lalaith",
            "edain",
            "children_of_hurin",
            "silmarillion",
            "first_age",
            "house_of_hador",
            "unfinished_tales"
        )
    ),
    CharacterData(
        id = "364",
        name = "Vairë",
        tags = listOf(
            "valar",
            "vaire",
            "ainur",
            "silmarillion",
            "first_age",
            "queens",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "365",
        name = "Valandil (Rey de Arnor)",
        tags = listOf(
            "men",
            "arnorians",
            "valandil",
            "silmarillion",
            "house_of_isildur",
            "ruler_of_arnor",
            "second_age",
            "third_age",
            "dunedain",
            "dunedain_of_the_north",
            "kings_of_arnor",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "366",
        name = "Vána",
        tags = listOf(
            "vana",
            "ainur",
            "valar",
            "silmarillion",
            "first_age",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "367",
        name = "Varda",
        tags = listOf(
            "varda",
            "valar",
            "ainur",
            "aratar",
            "silmarillion",
            "first_age",
            "ruler_aman",
            "third_age",
            "book_of_lost_tales",
            "queens",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "368",
        name = "Viejo Hombre-Sauce",
        tags = listOf(
            "lord_of_the_rings",
            "viejo hombre sauce",
            "hombre-sauce",
            "old man willow",
            "third_age",
            "enigmas",
            "trees",
            "sauce",
            "forest_folk",
            "the_adventures_of_tom_bombadil",
            "minor_character"
        )
    ),
    CharacterData(
        id = "369",
        name = "Gerontiuis Tuk",
        tags = listOf(
            "gerontius",
            "tuk",
            "took",
            "viejo tuk",
            "hobbits",
            "third_age",
            "the_hobbit",
            "thains"
        )
    ),
    CharacterData(
        id = "370",
        name = "Voronwë",
        tags = listOf(
            "elves",
            "voronwe",
            "noldor",
            "silmarillion",
            "first_age",
            "gondolindrim",
            "house_of_fingolfin",
            "mariners",
            "moriquendi",
            "book_of_lost_tales",
            "unfinished_tales",
            "the_history_of_middle_earth"
        )
    ),
    CharacterData(
        id = "371",
        name = "Wídfara",
        tags = listOf(
            "widfara",
            "men",
            "rohirrim",
            "lord_of_the_rings",
            "third_age",
            "minor_character"
        )
    ),
    CharacterData(
        id = "372",
        name = "Yavanna",
        tags = listOf(
            "yavanna",
            "ainur",
            "valar",
            "aratar",
            "silmarillion",
            "first_age",
            "second_age",
            "third_age",
            "book_of_lost_tales",
            "the_history_of_middle_earth"
        )
    )
)