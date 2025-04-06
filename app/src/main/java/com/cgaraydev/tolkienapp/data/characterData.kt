package com.cgaraydev.tolkienapp.data

data class CharacterData(
    val id: String,
    val name: String,
    val tags: List<String>? = emptyList()
)

val characters = listOf(
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
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),
    CharacterData(
        id = "",
        name = "",
        tags = listOf(

        )
    ),

    )