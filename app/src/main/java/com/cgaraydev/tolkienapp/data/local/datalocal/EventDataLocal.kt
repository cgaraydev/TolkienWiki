package com.cgaraydev.tolkienapp.data.local.datalocal


data class EventData(
    val id: String,
    val name: String,
    val tags: List<String>? = emptyList()
)

val eventsTags = listOf(
    EventData(
        id = "0",
        name = "Asaltos a Lothlórien y Rohan oriental",
        tags = listOf(
            "asalto a lothlorien",
            "batallas de lorien",
            "battles",
            "events",
            "war_of_the_ring_conflicts",
            "third_age_conflicts",
            "wars_and_conflicts"
        )
    ),
    EventData(
        id = "1",
        name = "Asedio de Angband",
        tags = listOf(
            "asedio de angband",
            "sitio de angband",
            "events",
            "wars_and_conflicts",
            "sieges",
            "war_of_the_jewels_conflicts",
            "battles_of_beleriand",
            "first_age_conflicts"
        )
    ),
    EventData(
        id = "2",
        name = "Asedio de Barad-dûr",
        tags = listOf(
            "asedio de barad dur",
            "sitio de barad dur",
            "sieges",
            "events",
            "second_age_conflicts",
            "war_of_the_last_alliance_conflicts",
            "wars_and_conflicts"
        )
    ),
    EventData(
        id = "3",
        name = "Asedio de Gondor",
        tags = listOf(
            "asedio de gondor",
            "sitio de gondor",
            "sieges",
            "third_age_conflicts",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "events"
        )
    ),
    EventData(
        id = "4",
        name = "Ataque a Dol Guldur",
        tags = listOf(
            "ataque a dol guldur",
            "battles",
            "wars_and_conflicts",
            "third_age_conflicts",
            "events"
        )
    ),
    EventData(
        id = "5",
        name = "Ataque sorpresa a Umbar",
        tags = listOf(
            "ataque sorpresa a umbar",
            "events",
            "battles",
            "third_age_conflicts",
            "wars_and_conflicts"
        )
    ),
    EventData(
        id = "6",
        name = "Batalla bajo los árboles",
        tags = listOf(
            "batalla bajo los arboles",
            "events",
            "battles",
            "wars_and_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "7",
        name = "Batalla de Azanulbizar",
        tags = listOf(
            "batalla de azanulbizar",
            "events",
            "battles",
            "wars_and_conflicts",
            "war_of_the_dwarves_and_orcs_conflicts"
        )
    ),
    EventData(
        id = "8",
        name = "Batalla de Cuernavilla",
        tags = listOf(
            "batalla de cuernavilla",
            "batalla del abismo de helm",
            "battles",
            "wars_and_conflicts",
            "third_age_conflicts",
            "war_of_the_ring_conflicts",
            "sieges"
        )
    ),
    EventData(
        id = "9",
        name = "Batalla de Dagorlad",
        tags = listOf(
            "batalla de dagorlad",
            "events",
            "battles",
            "wars_and_conflicts",
            "war_of_the_last_alliance_conflicts",
            "second_age_conflicts"
        )
    ),
    EventData(
        id = "10",
        name = "Batalla de Delagua",
        tags = listOf(
            "batalla de delagua",
            "events",
            "battles",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "11",
        name = "Batalla de Eglarest",
        tags = listOf(
            "batalla de eglarest",
            "battles",
            "events",
            "first_age_conflicts",
            "wars_and_conflicts",
            "war_of_wrath_conflicts"
        )
    ),
    EventData(
        id = "12",
        name = "Batalla de Fornost",
        tags = listOf(
            "batalla de fornost",
            "events",
            "battles",
            "wars_and_conflicts",
            "third_age_conflicts",
            "angmar_war_conflicts"
        )
    ),
    EventData(
        id = "13",
        name = "Batalla de la Cima",
        tags = listOf(
            "batalla de la cima",
            "events",
            "battles",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "14",
        name = "Batalla de Lammoth",
        tags = listOf(
            "batalla de lammoth",
            "battles",
            "events",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts"
        )
    ),
    EventData(
        id = "15",
        name = "Batalla en las Mil Cavernas",
        tags = listOf(
            "batalla en las mil cavernas",
            "events",
            "battles",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts"
        )
    ),
    EventData(
        id = "16",
        name = "Batalla de los Campos del Celebrant",
        tags = listOf(
            "batalla de los campos del celebrant",
            "battles",
            "events",
            "third_age_conflicts",
            "wars_and_conflicts",
            "wainriders_blachoth_war_conflicts"
        )
    ),
    EventData(
        id = "17",
        name = "Batalla de los Campos del Pelennor",
        tags = listOf(
            "batalla de los campos del pelennor",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "18",
        name = "Batalla de los Campos Verdes",
        tags = listOf(
            "batalla de los campos verdes",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "19",
        name = "Batalla de los Cinco Ejércitos",
        tags = listOf(
            "batalla de los cinco ejercitos",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "sieges"
        )
    ),
    EventData(
        id = "20",
        name = "Batalla de los Cruces del Erui",
        tags = listOf(
            "batalla de los cruces del erui",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "kin_strife_conflicts"
        )
    ),
    EventData(
        id = "21",
        name = "Batalla de los Cruces del Poros",
        tags = listOf(
            "batalla de los cruces del poros",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "22",
        name = "Batalla de los Llanos",
        tags = listOf(
            "batalla de los llanos",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "wainriders_blachoth_war_conflicts"
        )
    ),
    EventData(
        id = "23",
        name = "Batalla de los Poderes",
        tags = listOf(
            "batalla de los poderes",
            "battles",
            "events",
            "wars_and_conflicts",
            "first_age_conflicts",
            "sieges",
            "years_of_the_trees_conflicts"
        )
    ),
    EventData(
        id = "24",
        name = "Batalla de Pelargir",
        tags = listOf(
            "batalla de pelargir",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "25",
        name = "Batalla de Sarn Athrad",
        tags = listOf(
            "batalla de sarn athrad",
            "battles",
            "events",
            "first_age_conflicts",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts"
        )
    ),
    EventData(
        id = "26",
        name = "Batalla de Tumhalad",
        tags = listOf(
            "batalla de tumhalad",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts"
        )
    ),
    EventData(
        id = "27",
        name = "Batalla de la Ciudad de Valle",
        tags = listOf(
            "batalla de valle",
            "events",
            "battles",
            "wars_and_conflicts",
            "third_age_conflicts",
            "war_of_the_ring_conflicts",
            "sieges"
        )
    ),
    EventData(
        id = "28",
        name = "Batalla del Ascar y el Gelion",
        tags = listOf(
            "batalla del ascar y el gelion",
            "battles",
            "events",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts"
        )
    ),
    EventData(
        id = "29",
        name = "Batalla del Campamento",
        tags = listOf(
            "batalla del campamento",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "wainriders_blachoth_war_conflicts"
        )
    ),
    EventData(
        id = "30",
        name = "Batalla del Gwathló",
        tags = listOf(
            "batalla del gwathlo",
            "battles",
            "events",
            "wars_and_conflicts",
            "second_age_conflicts",
            "war_of_the_elves_and_sauron_conflicts"
        )
    ),
    EventData(
        id = "31",
        name = "Batalla del Morannon",
        tags = listOf(
            "batalla del morannon",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "war_of_the_ring_conflicts"
        )
    ),
    EventData(
        id = "32",
        name = "Búsqueda de Erebor",
        tags = listOf(
            "busqueda de erebor",
            "events",
            "quests",
            "third_age",
            "the_hobbit"
        )
    ),
    EventData(
        id = "33",
        name = "Búsqueda del Silmaril",
        tags = listOf(
            "busqueda del silmaril",
            "events",
            "quests",
            "first_age"
        )
    ),
    EventData(
        id = "34",
        name = "Caída de Amon Sûl",
        tags = listOf(
            "caida de amon sul",
            "destruccion de amon sul",
            "batalla de amon sul",
            "sieges",
            "events",
            "third_age_conflicts",
            "wars_and_conflicts",
            "angmar_war_conflicts"
        )
    ),
    EventData(
        id = "35",
        name = "Caída de Barad-dûr",
        tags = listOf(
            "caida de barad dur",
            "events",
            "third_age",
            "war_of_the_ring_conflicts",
            "wars_and_conflicts"
        )
    ),
    EventData(
        id = "36",
        name = "Caída de Dol Guldur",
        tags = listOf(
            "caida de dol guldur",
            "batalla de dol guldur",
            "events",
            "battles",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "37",
        name = "Caída de Gondolin",
        tags = listOf(
            "caida de gondolin",
            "events",
            "sieges",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts",
            "battles"
        )
    ),
    EventData(
        id = "38",
        name = "Caída de las Falas",
        tags = listOf(
            "caida de las falas",
            "battles",
            "events",
            "sieges",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts"
        )
    ),
    EventData(
        id = "39",
        name = "Caída de Nargothrond",
        tags = listOf(
            "caida de nargothrond",
            "sieges",
            "events",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts"
        )
    ),
    EventData(
        id = "40",
        name = "Caída de Númenor",
        tags = listOf(
            "caida de numenor",
            "events",
            "second_age",
            "numenor_events"
        )
    ),
    EventData(
        id = "41",
        name = "Cámara de los Ents",
        tags = listOf(
            "camara de los ents",
            "events",
            "third_age",
            "ents"
        )
    ),
    EventData(
        id = "42",
        name = "Cambio del Mundo",
        tags = listOf(
            "cambio del mundo",
            "events",
            "second_age"
        )
    ),
    EventData(
        id = "43",
        name = "Caza del Lobo",
        tags = listOf(
            "caza del lobo",
            "events",
            "first_age"
        )
    ),
    EventData(
        id = "44",
        name = "Concilio de Elrond",
        tags = listOf(
            "concilio de elrond",
            "events",
            "third_age",
            "council_of_elrond"
        )
    ),
    EventData(
        id = "45",
        name = "Creación de los Ainur",
        tags = listOf(
            "creacion de los ainur",
            "events"
        )
    ),
    EventData(
        id = "46",
        name = "Dagor Aglareb",
        tags = listOf(
            "dagor aglareb",
            "batalla gloriosa",
            "events",
            "battles",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts"
        )
    ),
    EventData(
        id = "47",
        name = "Dagor Bragollach",
        tags = listOf(
            "dagor bragollach",
            "batalla de la llama subita",
            "events",
            "battles",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts"
        )
    ),
    EventData(
        id = "48",
        name = "Dagor Dagorath",
        tags = listOf(
            "dagor dagorath",
            "ultima batalla",
            "batalla de batallas",
            "events",
            "battles",
            "wars_and_conflicts",
            "oaths_prophecies",
            "later_ages",
            "wars"
        )
    ),
    EventData(
        id = "49",
        name = "Dagor-nuin-Giliath",
        tags = listOf(
            "dagor nuin giliath",
            "batalla bajo las estrellas",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts"
        )
    ),
    EventData(
        id = "50",
        name = "Desastre de los Campos Gladios",
        tags = listOf(
            "desastre de los campos gladios",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "51",
        name = "Despertar de los Elfos",
        tags = listOf(
            "despertar de los elfos",
            "events",
            "years_of_the_trees"
        )
    ),
    EventData(
        id = "52",
        name = "Despertar de los Hombres",
        tags = listOf(
            "despertar de los hombres",
            "events",
            "first_age"
        )
    ),
    EventData(
        id = "53",
        name = "Día de Durin",
        tags = listOf(
            "dia de durin",
            "events"
        )
    ),
    EventData(
        id = "54",
        name = "Disolución de la Comunidad",
        tags = listOf(
            "disolucion de la comunidad",
            "ruptura de la comunidad",
            "events",
            "third_age",
            "war_of_the_ring_conflicts"
        )
    ),
    EventData(
        id = "55",
        name = "Encadenamiento de Melkor",
        tags = listOf(
            "encadenamiento de melkor",
            "events",
            "years_of_the_trees",
            "eras",
            "periods"
        )
    ),
    EventData(
        id = "56",
        name = "Exilio de los Noldor",
        tags = listOf(
            "exilio de los noldor",
            "events",
            "years_of_the_trees",
            "noldor"
        )
    ),
    EventData(
        id = "57",
        name = "Fiesta de Despedida de Bilbo",
        tags = listOf(
            "fiesta de despedida de bilbo",
            "fiesta de cumpleaños de bilbo",
            "events",
            "festivals_feasts",
            "third_age"
        )
    ),
    EventData(
        id = "58",
        name = "Gran Peste",
        tags = listOf(
            "gran plaga",
            "gran peste",
            "events",
            "third_age"
        )
    ),
    EventData(
        id = "59",
        name = "Gran Viaje",
        tags = listOf(
            "gran viaje",
            "gran marcha",
            "events",
            "years_of_the_trees",
            "elves",
            "journeys"
        )
    ),
    EventData(
        id = "60",
        name = "Guerra con Angmar",
        tags = listOf(
            "guerra con angmar",
            "events",
            "wars",
            "third_age_conflicts",
            "wars_and_conflicts",
            "angmar_war_conflicts"
        )
    ),
    EventData(
        id = "61",
        name = "Guerra con los Aurigas y Balchoth",
        tags = listOf(
            "guerra con aurigas y balchoth",
            "aurigas",
            "balchoth",
            "wars",
            "wars_and_conflicts",
            "third_age_conflicts",
            "wainriders_blachoth_war_conflicts"
        )
    ),
    EventData(
        id = "62",
        name = "Guerra de la Cólera",
        tags = listOf(
            "guerra de la colera",
            "wars",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts",
            "events",
            "battles"
        )
    ),
    EventData(
        id = "63",
        name = "Guerra de la Última Alianza",
        tags = listOf(
            "guerra de la ultima alianza",
            "events",
            "wars_and_conflicts",
            "sieges",
            "wars",
            "second_age_conflicts",
            "war_of_the_last_alliance_conflicts"
        )
    ),
    EventData(
        id = "64",
        name = "Guerra de las Joyas",
        tags = listOf(
            "guerra de las joyas",
            "guerras de beleriand",
            "wars",
            "wars_and_conflicts",
            "first_age_conflicts",
            "war_of_the_jewels_conflicts",
            "events"
        )
    ),
    EventData(
        id = "65",
        name = "Guerra de los Elfos y Sauron",
        tags = listOf(
            "guerra de los elfos y sauron",
            "wars_and_conflicts",
            "wars",
            "second_age_conflicts",
            "events"
        )
    ),
    EventData(
        id = "66",
        name = "Guerra de los Enanos y Dragones",
        tags = listOf(
            "guerra de los enanos y dragones",
            "wars",
            "wars_and_conflicts",
            "third_age_conflicts",
            "events"
        )
    ),
    EventData(
        id = "67",
        name = "Guerra de los Enanos y los Orcos",
        tags = listOf(
            "guerra de los enanos y los orcos",
            "events",
            "wars",
            "wars_and_conflicts",
            "third_age_conflicts",
            "war_of_the_dwarves_and_orcs_conflicts"
        )
    ),
    EventData(
        id = "68",
        name = "Guerra del Anillo",
        tags = listOf(
            "guerra del anillo",
            "events",
            "wars",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "69",
        name = "Guerras Corsarias",
        tags = listOf(
            "guerras corsarias",
            "wars",
            "wars_and_conflicts",
            "corsair_conflicts",
            "third_age_conflicts",
            "events"
        )
    ),
    EventData(
        id = "70",
        name = "Juramento de Cirion y Eorl",
        tags = listOf(
            "juramento de cirion y eorl",
            "oaths_prophecies",
            "third_age",
            "events"
        )
    ),
    EventData(
        id = "71",
        name = "Juramento de Fëanor",
        tags = listOf(
            "juramento de feanor",
            "oaths_prophecies",
            "events",
            "years_of_the_trees"
        )
    ),
    EventData(
        id = "72",
        name = "Largo Invierno",
        tags = listOf(
            "largo invierno",
            "events",
            "third_age",
            "periods"
        )
    ),
    EventData(
        id = "73",
        name = "Lucha entre Parientes",
        tags = listOf(
            "lucha entre parientes",
            "events",
            "wars",
            "wars_and_conflicts",
            "third_age_conflicts",
            "gondor"
        )
    ),
    EventData(
        id = "74",
        name = "Maldición de Mandos",
        tags = listOf(
            "maldicion de mandos",
            "events",
            "oaths_prophecies",
            "years_of_the_trees"
        )
    ),
    EventData(
        id = "75",
        name = "Matanza de los Hermanos de Alqualondë",
        tags = listOf(
            "matanza de los hermanos de alqualonde",
            "primera matanza entre hermanos",
            "events",
            "battles",
            "wars_and_conflicts",
            "kinslayings",
            "years_of_the_trees_conflicts"
        )
    ),
    EventData(
        id = "76",
        name = "Mereth Aderthad",
        tags = listOf(
            "mereth aderthad",
            "events",
            "festivals_feasts",
            "first_age"
        )
    ),
    EventData(
        id = "77",
        name = "Misión del Anillo",
        tags = listOf(
            "mision del anillo",
            "events",
            "third_age",
            "journeys",
            "quests"
        )
    ),
    EventData(
        id = "78",
        name = "Música de los Ainur",
        tags = listOf(
            "musica de los ainur",
            "ainulindale",
            "events",
            "ainur_concepts_locations"
        )
    ),
    EventData(
        id = "79",
        name = "Nírnaeth Arnoediad",
        tags = listOf(
            "nirnaeth arnoediad",
            "battles",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts",
            "events"
        )
    ),
    EventData(
        id = "80",
        name = "Nurtalë Valinóreva",
        tags = listOf(
            "nurtale valinoreva",
            "ocultamiento de valinor",
            "events",
            "first_age"
        )
    ),
    EventData(
        id = "81",
        name = "Oscurecimiento de Valinor",
        tags = listOf(
            "oscurecimiento de valinor",
            "events",
            "first_age",
            "years_of_the_trees"
        )
    ),
    EventData(
        id = "82",
        name = "Primavera de Arda",
        tags = listOf(
            "primavera de arda",
            "events",
            "periods",
            "eras",
            "valian_years"
        )
    ),
    EventData(
        id = "83",
        name = "Primer Asedio a Imladris",
        tags = listOf(
            "primer asedio a imladris",
            "events",
            "sieges",
            "wars_and_conflicts",
            "war_of_the_elves_and_sauron_conflicts",
            "second_age_conflicts"
        )
    ),
    EventData(
        id = "84",
        name = "Primera Batalla de Beleriand",
        tags = listOf(
            "primera batalla de beleriand",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "sieges",
            "years_of_the_trees_conflicts"
        )
    ),
    EventData(
        id = "85",
        name = "Primera Batalla de los Vados del Isen",
        tags = listOf(
            "primera batalla de los vados del isen",
            "battles",
            "wars_and_conflicts",
            "events",
            "third_age_conflicts",
            "war_of_the_ring_conflicts"
        )
    ),
    EventData(
        id = "86",
        name = "Primera Guerra",
        tags = listOf(
            "primera guerra",
            "wars",
            "wars_and_conflicts",
            "before_first_age",
            "valian_years",
            "events"
        )
    ),
    EventData(
        id = "87",
        name = "Saneamiento de La Comarca",
        tags = listOf(
            "saneamiento de la comarca",
            "events",
            "third_age",
            "war_of_the_ring_conflicts"
        )
    ),
    EventData(
        id = "88",
        name = "Saqueo de Erebor",
        tags = listOf(
            "saqueo de erebor",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "battles"
        )
    ),
    EventData(
        id = "89",
        name = "Saqueo de Eregion",
        tags = listOf(
            "saqueo de eregion",
            "asedio de eregion",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_elves_and_sauron_conflicts",
            "second_age_conflicts",
            "sieges"
        )
    ),
    EventData(
        id = "90",
        name = "Segunda Batalla de Dagorlad",
        tags = listOf(
            "segunda batalla de dagorlad",
            "battles",
            "events",
            "wars_and_conflicts",
            "wainriders_blachoth_war_conflicts",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "91",
        name = "Segunda Batalla de los Vados del Isen",
        tags = listOf(
            "segunda batalla de los vados del isen",
            "battles",
            "events",
            "wars_and_conflicts",
            "third_age_conflicts",
            "war_of_the_ring_conflicts"
        )
    ),
    EventData(
        id = "92",
        name = "Segunda Matanza de Hermanos",
        tags = listOf(
            "segunda matanza de hermanos",
            "kinslayings",
            "battles",
            "events",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "first_age_conflicts"
        )
    ),
    EventData(
        id = "93",
        name = "Sueño de Yavanna",
        tags = listOf(
            "sueño de yavanna",
            "events",
            "periods",
            "eras"
        )
    ),
    EventData(
        id = "94",
        name = "Tercera Matanza de Hermanos",
        tags = listOf(
            "tercera matanza de hermanos",
            "battles",
            "events",
            "first_age_conflicts",
            "wars_and_conflicts",
            "war_of_the_jewels_conflicts",
            "kinslayings"
        )
    ),
    EventData(
        id = "95",
        name = "Última Marcha de los Ents",
        tags = listOf(
            "ultima marcha de los ents",
            "batalla de isengard",
            "battles",
            "wars_and_conflicts",
            "war_of_the_ring_conflicts",
            "events",
            "third_age_conflicts"
        )
    ),
    EventData(
        id = "96",
        name = "Último Debate",
        tags = listOf(
            "ultimo debate",
            "events",
            "third_age"
        )
    )
)