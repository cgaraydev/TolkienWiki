package com.cgaraydev.tolkienapp.data

data class OtherData(
    val id: String,
    val name: String,
    val tags: List<String>? = emptyList()
)

val othersTags = listOf(
    OtherData(
        id = "0",
        name = "Aeglos (lanza)",
        tags = listOf(
            "aeglos",
            "aiglos",
            "weapons",
            "spears",
            "others"
        )
    ),
    OtherData(
        id = "1",
        name = "Aeglos (planta)",
        tags = listOf(
            "aeglos",
            "plants",
            "flowers",
            "others"
        )
    ),
    OtherData(
        id = "2",
        name = "Alcarondas",
        tags = listOf(
            "alcarondas",
            "ships",
            "others"
        )
    ),
    OtherData(
        id = "3",
        name = "Aldudénië",
        tags = listOf(
            "aldudenie",
            "poems",
            "lays_and_tales",
            "others",
            "songs_and_verses"
        )
    ),
    OtherData(
        id = "4",
        name = "Aliento Negro",
        tags = listOf(
            "aliento negro",
            "black breath",
            "weapons",
            "magic",
            "nazgul",
            "others"
        )
    ),
    OtherData(
        id = "5",
        name = "Alto Rey de los Noldor",
        tags = listOf(
            "alto rey de los noldor",
            "alto rey",
            "high king",
            "titles",
            "elven_titles",
            "noldor",
            "rulers_in_beleriand",
            "rulers_middle_earth",
            "others"
        )
    ),
    OtherData(
        id = "6",
        name = "Andúril",
        tags = listOf(
            "anduril",
            "swords",
            "weapons",
            "others"
        )
    ),
    OtherData(
        id = "7",
        name = "Angainor",
        tags = listOf(
            "angainor",
            "chains",
            "objects",
            "others",
            "creations_of_the_valar"
        )
    ),
    OtherData(
        id = "8",
        name = "Anglachel",
        tags = listOf(
            "anglachel",
            "weapons",
            "swords",
            "others"
        )
    ),
    OtherData(
        id = "9",
        name = "Angrist",
        tags = listOf(
            "angrist",
            "weapons",
            "others",
            "knives",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "10",
        name = "Anguirel",
        tags = listOf(
            "anguirel",
            "weapons",
            "swords",
            "others"
        )
    ),
    OtherData(
        id = "11",
        name = "Anillo de Barahir",
        tags = listOf(
            "anillo de barahir",
            "ring of barahir",
            "objects",
            "others",
            "rings_jewels",
            "heirlooms"
        )
    ),
    OtherData(
        id = "12",
        name = "Anillo de Thrór",
        tags = listOf(
            "anillo de thror",
            "rings_jewels",
            "objects",
            "others",
            "ring of thror",
            "heirlooms"
        )
    ),
    OtherData(
        id = "13",
        name = "Anillo Único",
        tags = listOf(
            "anillo unico",
            "anillo",
            "daño de isildur",
            "anillo de poder",
            "unico",
            "the one ring",
            "objects",
            "rings_jewels",
            "rings_of_power",
            "magical_objects",
            "others"
        )
    ),
    OtherData(
        id = "14",
        name = "Anillos de Poder",
        tags = listOf(
            "anillos de poder",
            "rings of power",
            "objects",
            "others",
            "rings_jewels"
        )
    ),
    OtherData(
        id = "15",
        name = "Años Valianos",
        tags = listOf(
            "año valiano",
            "valian years",
            "time",
            "eras",
            "others",
            "years"
        )
    ),
    OtherData(
        id = "16",
        name = "Aranrúth",
        tags = listOf(
            "aranruth",
            "weapons",
            "swords",
            "others",
            "heirlooms"
        )
    ),
    OtherData(
        id = "17",
        name = "Aratar",
        tags = listOf(
            "aratar",
            "titles",
            "others",
            "organizations",
            "valar",
            "valarin_titles",
            "ainur_concepts_locations"
        )
    ),
    OtherData(
        id = "18",
        name = "Árbol Blanco de Gondor",
        tags = listOf(
            "arbol blanco",
            "arbol blanco de gondor",
            "plants",
            "others",
            "trees",
            "symbols"
        )
    ),
    OtherData(
        id = "19",
        name = "Arco de Bregor",
        tags = listOf(
            "arco de bregor",
            "bregor",
            "weapons",
            "bows",
            "others",
            "heirlooms"
        )
    ),
    OtherData(
        id = "20",
        name = "Arco de los Galadhrim",
        tags = listOf(
            "arco de los galadhrim",
            "weapons",
            "bows",
            "gifts_of_galadriel",
            "others"
        )
    ),
    OtherData(
        id = "21",
        name = "Dúnedain de Arnor",
        tags = listOf(
            "dunedain del norte",
            "dunedain de arnor",
            "arnorianos",
            "others",
            "people",
            "dunedain",
            "men"
        )
    ),
    OtherData(
        id = "22",
        name = "Athelas",
        tags = listOf(
            "athelas",
            "plants",
            "others",
            "herbs"
        )
    ),
    OtherData(
        id = "23",
        name = "Aurigas",
        tags = listOf(
            "aurigas",
            "wainriders",
            "people",
            "men",
            "easterling",
            "servants_of_sauron"
        )
    ),
    OtherData(
        id = "24",
        name = "Avari",
        tags = listOf(
            "avari",
            "elfos oscuros",
            "oscuro",
            "others",
            "people",
            "elves",
            "moriquendi"
        )
    ),
    OtherData(
        id = "25",
        name = "Balchoth",
        tags = listOf(
            "balchoth",
            "easterling",
            "men",
            "others",
            "people",
            "servants_of_sauron"
        )
    ),
    OtherData(
        id = "26",
        name = "Barbas de Fuego",
        tags = listOf(
            "barbas de fuego",
            "firebeards",
            "people",
            "others",
            "dwarves",
            "dwarven_clans"
        )
    ),
    OtherData(
        id = "27",
        name = "Barbatiesas",
        tags = listOf(
            "barbatiesas",
            "stiffbeards",
            "others",
            "people",
            "dwarven_clans",
            "dwarves"
        )
    ),
    OtherData(
        id = "28",
        name = "Belthronding",
        tags = listOf(
            "belthronding",
            "weapons",
            "bows",
            "others"
        )
    ),
    OtherData(
        id = "29",
        name = "Beórnidas",
        tags = listOf(
            "beornidas",
            "beornings",
            "people",
            "others",
            "northmen",
            "free_people"
        )
    ),
    OtherData(
        id = "30",
        name = "Caja con tierra",
        tags = listOf(
            "caja con tierra del jardin de galadriel",
            "objects",
            "others",
            "gifts_of_galadriel"
        )
    ),
    OtherData(
        id = "31",
        name = "Calaquendi",
        tags = listOf(
            "calaquendi",
            "elves",
            "others",
            "people"
        )
    ),
    OtherData(
        id = "32",
        name = "Casa de Anárion",
        tags = listOf(
            "casa de anarion",
            "others",
            "noble_houses",
            "organizations",
            "gondorians",
            "mannish_noble_houses",
            "house_of_anarion"
        )
    ),
    OtherData(
        id = "33",
        name = "Casa de Bëor",
        tags = listOf(
            "casa de beor",
            "others",
            "noble_houses",
            "organizations",
            "mannish_noble_houses",
            "lineages",
            "house_of_beor"
        )
    ),
    OtherData(
        id = "34",
        name = "Casa de Dol Amroth",
        tags = listOf(
            "casa de dol amroth",
            "others",
            "noble_houses",
            "organizations",
            "mannish_noble_houses",
            "house_of_valandil",
            "gondorians",
            "lineages",
            "lords_of_gondor",
            "princes_of_dol_amroth"
        )
    ),
    OtherData(
        id = "35",
        name = "Casa de Durin",
        tags = listOf(
            "casa de durin",
            "others",
            "noble_houses",
            "dwarves",
            "longbeards",
            "lineages",
            "organizations"
        )
    ),
    OtherData(
        id = "36",
        name = "Casa de Elendil",
        tags = listOf(
            "casa de elendil",
            "others",
            "noble_houses",
            "mannish_noble_houses",
            "lineages",
            "organizations",
            "house_of_elendil"
        )
    ),
    OtherData(
        id = "37",
        name = "Casa de Elros",
        tags = listOf(
            "casa de elros",
            "others",
            "noble_houses",
            "mannish_noble_houses",
            "lineages",
            "organizations",
            "house_of_elros"
        )
    ),
    OtherData(
        id = "38",
        name = "Casa de Eorl",
        tags = listOf(
            "casa de eorl",
            "others",
            "noble_houses",
            "mannish_noble_houses",
            "organizations",
            "lineages",
            "rohirrim",
            "kings_of_rohan",
            "house_of_eorl"
        )
    ),
    OtherData(
        id = "39",
        name = "Casa de Fëanor",
        tags = listOf(
            "casa de feanor",
            "others",
            "noble_houses",
            "noldor",
            "lineages",
            "house_of_feanor",
            "elven_noble_houses"
        )
    ),
    OtherData(
        id = "40",
        name = "Casa de Finarfin",
        tags = listOf(
            "casa de finarfin",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "house_of_finarfin",
            "noldor",
            "lineages"
        )
    ),
    OtherData(
        id = "41",
        name = "Casa de Fingolfin",
        tags = listOf(
            "casa de fingolfin",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "house_of_fingolfin",
            "noldor",
            "lineages"
        )
    ),
    OtherData(
        id = "42",
        name = "Casa de Finwë",
        tags = listOf(
            "casa de finwe",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "house_of_finwe",
            "lineages",
            "noldor"
        )
    ),
    OtherData(
        id = "43",
        name = "Casa de Hador",
        tags = listOf(
            "casa de hador",
            "others",
            "noble_houses",
            "house_of_hador",
            "lineages",
            "mannish_noble_houses",
            "hadorianos"
        )
    ),
    OtherData(
        id = "44",
        name = "Casa de Haleth",
        tags = listOf(
            "casa de haleth",
            "house_of_haleth",
            "noble_houses",
            "others",
            "lineages",
            "mannish_noble_houses",
            "organizations",
            "haladin"
        )
    ),
    OtherData(
        id = "45",
        name = "Casa de Húrin",
        tags = listOf(
            "casa de hurin",
            "house_of_hurin",
            "others",
            "noble_houses",
            "organizations",
            "mannish_noble_houses",
            "lineages",
            "stewards"
        )
    ),
    OtherData(
        id = "46",
        name = "Casa de Isildur",
        tags = listOf(
            "casa de isildur",
            "house_of_isildur",
            "others",
            "noble_houses",
            "organizations",
            "lineages",
            "mannish_noble_houses"
        )
    ),
    OtherData(
        id = "47",
        name = "Casa de la Flor Dorada",
        tags = listOf(
            "casa de la flor dorada",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "houses_gondolindrim",
            "organizations"
        )
    ),
    OtherData(
        id = "48",
        name = "Casa de la Fuente",
        tags = listOf(
            "casa de la fuente",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "houses_gondolindrim",
            "organizations"
        )
    ),
    OtherData(
        id = "49",
        name = "Casa de la Golondrina",
        tags = listOf(
            "casa de la golondrina",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "houses_gondolindrim",
            "organizations"
        )
    ),
    OtherData(
        id = "50",
        name = "Casa de la Torre de Nieve",
        tags = listOf(
            "casa de la torre de nieve",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "houses_gondolindrim",
            "organizations"
        )
    ),
    OtherData(
        id = "51",
        name = "Casa de Telcontar",
        tags = listOf(
            "casa de telcontar",
            "others",
            "noble_houses",
            "mannish_noble_houses",
            "house_of_telcontar",
            "lineages",
            "ruler_of_gondor"
        )
    ),
    OtherData(
        id = "52",
        name = "Casa del Ala de Cisne",
        tags = listOf(
            "casa del ala de cisne",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "organizations",
            "houses_gondolindrim"
        )
    ),
    OtherData(
        id = "53",
        name = "Casa del Árbol",
        tags = listOf(
            "casa del arbol",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "organizations",
            "houses_gondolindrim"
        )
    ),
    OtherData(
        id = "54",
        name = "Casa del Arco Celestial",
        tags = listOf(
            "casa del arco celestial",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "organizations",
            "houses_gondolindrim"
        )
    ),
    OtherData(
        id = "55",
        name = "Casa del Arpa",
        tags = listOf(
            "casa del arpa",
            "others",
            "noble_houses",
            "organizations",
            "houses_gondolindrim",
            "elven_noble_houses"
        )
    ),
    OtherData(
        id = "56",
        name = "Casa del Martillo Iracundo",
        tags = listOf(
            "casa del martillo iracundo",
            "others",
            "noble_houses",
            "organizations",
            "houses_gondolindrim",
            "elven_noble_houses"
        )
    ),
    OtherData(
        id = "57",
        name = "Casa del Pilar",
        tags = listOf(
            "casa del pilar",
            "others",
            "noble_houses",
            "houses_gondolindrim",
            "elven_noble_houses",
            "organizations"
        )
    ),
    OtherData(
        id = "58",
        name = "Casa del Rey",
        tags = listOf(
            "casa del rey",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "organizations",
            "houses_gondolindrim"
        )
    ),
    OtherData(
        id = "59",
        name = "Casa del Topo",
        tags = listOf(
            "casa del topo",
            "others",
            "noble_houses",
            "elven_noble_houses",
            "houses_gondolindrim",
            "organizations"
        )
    ),
    OtherData(
        id = "60",
        name = "Celeborn (Árbol Blanco)",
        tags = listOf(
            "celeborn",
            "trees",
            "plants",
            "others"
        )
    ),
    OtherData(
        id = "61",
        name = "Cetro de Annúminas",
        tags = listOf(
            "cetro de annuminas",
            "objects",
            "others",
            "heirlooms"
        )
    ),
    OtherData(
        id = "62",
        name = "Consejo del Cetro",
        tags = listOf(
            "consejo del cetro",
            "others",
            "organizations",
            "numenor_concepts",
            "rulers_of_numenor"
        )
    ),
    OtherData(
        id = "63",
        name = "Compañía de Thorin",
        tags = listOf(
            "compañia de thorin",
            "thorin y compañia",
            "organizations",
            "others",
            "thorin_company"
        )
    ),
    OtherData(
        id = "64",
        name = "Compañía Gris",
        tags = listOf(
            "compania gris",
            "organizations",
            "others",
            "grey_company",
            "dunedain_of_the_north",
            "dunedain"
        )
    ),
    OtherData(
        id = "65",
        name = "Cómputo de la Comarca",
        tags = listOf(
            "computo de la comarca",
            "others",
            "calendars",
            "time"
        )
    ),
    OtherData(
        id = "66",
        name = "Comunidad del Anillo",
        tags = listOf(
            "comunidad del anillo",
            "compania del anillo",
            "organizations",
            "others",
            "fellowship_of_the_ring"
        )
    ),
    OtherData(
        id = "67",
        name = "Concilio Blanco",
        tags = listOf(
            "concilio blanco",
            "organizations",
            "white_council",
            "others",
            "concilio de los sabios"
        )
    ),
    OtherData(
        id = "68",
        name = "Corona de Gondor",
        tags = listOf(
            "corona de gondor",
            "others",
            "objects",
            "heirlooms",
            "symbols",
            "crowns"
        )
    ),
    OtherData(
        id = "69",
        name = "Corona de Hierro",
        tags = listOf(
            "corona de hierro",
            "others",
            "objects",
            "crowns"
        )
    ),
    OtherData(
        id = "70",
        name = "Corsarios de Umbar",
        tags = listOf(
            "corsarios de umbar",
            "others",
            "people",
            "men",
            "servants_of_sauron",
            "haradrim",
            "black_numenoreans",
            "army_of_mordor"
        )
    ),
    OtherData(
        id = "71",
        name = "Cota de Malla de Mithril",
        tags = listOf(
            "cota de malla de mithril",
            "cota de mithril",
            "objects",
            "others",
            "armor",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "72",
        name = "Cram",
        tags = listOf(
            "cram",
            "others",
            "food_drinks"
        )
    ),
    OtherData(
        id = "73",
        name = "Cuarta Edad",
        tags = listOf(
            "ages",
            "fourth_age",
            "cuarta edad",
            "chronology",
            "time",
            "others"
        )
    ),
    OtherData(
        id = "74",
        name = "Cuerda de los Elfos",
        tags = listOf(
            "cuerda de los elfos",
            "others",
            "objects"
        )
    ),
    OtherData(
        id = "75",
        name = "Cuerno de Gondor",
        tags = listOf(
            "cuerno de gondor",
            "cuerno de vorondil",
            "others",
            "objects",
            "horns",
            "heirlooms",
            "gondor"
        )
    ),
    OtherData(
        id = "76",
        name = "Cuerno de la Marca",
        tags = listOf(
            "cuerno de la marca",
            "cuerno de rohan",
            "others",
            "objects",
            "heirlooms",
            "horns",
            "rohan"
        )
    ),
    OtherData(
        id = "77",
        name = "Dagas de los Túmulos",
        tags = listOf(
            "dagas de los tumulos",
            "dagas de oesternesse",
            "others",
            "weapons",
            "blades",
            "daggers",
            "swords",
            "knives"
        )
    ),
    OtherData(
        id = "78",
        name = "Dailir",
        tags = listOf(
            "dailir",
            "weapons",
            "arrows",
            "others"
        )
    ),
    OtherData(
        id = "79",
        name = "Dardo",
        tags = listOf(
            "dardo",
            "aguijon",
            "sting",
            "others",
            "weapons",
            "swords",
            "daggers"
        )
    ),
    OtherData(
        id = "80",
        name = "Doce Casas de los Gondolindrim",
        tags = listOf(
            "doce casas de los gondolindrim",
            "noble_houses",
            "houses_gondolindrim",
            "others"
        )
    ),
    OtherData(
        id = "81",
        name = "Don de Ilúvatar",
        tags = listOf(
            "don de iluvatar",
            "don de los hombres",
            "concepts",
            "others"
        )
    ),
    OtherData(
        id = "82",
        name = "Dos Lámparas",
        tags = listOf(
            "dos lamparas",
            "objects",
            "lamps",
            "creations_of_the_valar",
            "before_first_age"
        )
    ),
    OtherData(
        id = "83",
        name = "Dramborleg",
        tags = listOf(
            "dramborleg",
            "weapons",
            "others",
            "axes",
            "realm_of_gondolin",
            "heirlooms"
        )
    ),
    OtherData(
        id = "84",
        name = "Drúedain",
        tags = listOf(
            "druedain",
            "men",
            "others",
            "people"
        )
    ),
    OtherData(
        id = "85",
        name = "Dúnedain",
        tags = listOf(
            "dunedain",
            "people",
            "others",
            "men"
        )
    ),
    OtherData(
        id = "86",
        name = "Dunlendinos",
        tags = listOf(
            "dunlendinos",
            "dunlendings",
            "people",
            "others",
            "servants_of_saruman",
            "servants_of_sauron"
        )
    ),
    OtherData(
        id = "87",
        name = "Eä",
        tags = listOf(
            "ea",
            "middle_earth_cosmology",
            "others"
        )
    ),
    OtherData(
        id = "88",
        name = "Eämbar",
        tags = listOf(
            "eambar",
            "ships",
            "others",
            "numenor_buildings"
        )
    ),
    OtherData(
        id = "89",
        name = "Eärrámë",
        tags = listOf(
            "earrame",
            "others",
            "ships"
        )
    ),
    OtherData(
        id = "90",
        name = "Edades",
        tags = listOf(
            "historia de arda",
            "edades",
            "others",
            "time",
            "ages",
            "periods",
            "chronology"
        )
    ),
    OtherData(
        id = "91",
        name = "Edades de las Lámparas",
        tags = listOf(
            "edades de las lamparas",
            "dias antes de los dias",
            "ages",
            "time",
            "others",
            "periods",
            "before_first_age",
            "valian_years"
        )
    ),
    OtherData(
        id = "92",
        name = "Edades de los Árboles",
        tags = listOf(
            "edades de los arboles",
            "ages",
            "time",
            "others",
            "periods",
            "before_first_age",
            "years_of_the_trees",
            "years"
        )
    ),
    OtherData(
        id = "93",
        name = "Edades del Sol",
        tags = listOf(
            "edades del sol",
            "ages",
            "time",
            "others",
            "periods",
            "years"
        )
    ),
    OtherData(
        id = "94",
        name = "Edain",
        tags = listOf(
            "edain",
            "others",
            "men",
            "people"
        )
    ),
    OtherData(
        id = "95",
        name = "Ejército de Valinor",
        tags = listOf(
            "ejercito de valinor",
            "ejercito de los valar",
            "ejercito del oeste",
            "others",
            "armies"
        )
    ),
    OtherData(
        id = "96",
        name = "Ejército del Oeste",
        tags = listOf(
            "ejercito del oeste",
            "others",
            "armies"
        )
    ),
    OtherData(
        id = "97",
        name = "Elanor (flor)",
        tags = listOf(
            "elanor",
            "others",
            "plants",
            "flowers"
        )
    ),
    OtherData(
        id = "98",
        name = "Eldar",
        tags = listOf(
            "eldar",
            "elves",
            "others",
            "people",
            "elven_peoples"
        )
    ),
    OtherData(
        id = "99",
        name = "Elendilmir",
        tags = listOf(
            "elendilmir",
            "estrella de elendil",
            "others",
            "objects",
            "rings_jewels",
            "heirlooms",
            "arnor"
        )
    ),
    OtherData(
        id = "100",
        name = "Elfos Silvanos",
        tags = listOf(
            "elfos silvanos",
            "elfos del bosque",
            "tawarwaith",
            "others",
            "people",
            "elven_peoples",
            "moriquendi",
            "silvan",
            "elves"
        )
    ),
    OtherData(
        id = "101",
        name = "Enanos Mezquinos",
        tags = listOf(
            "enanos mezquinos",
            "petty_dwarves",
            "dwarven_clans",
            "dwarves",
            "others",
            "people"
        )
    ),
    OtherData(
        id = "102",
        name = "Entulessë",
        tags = listOf(
            "entulesse",
            "ships",
            "others"
        )
    ),
    OtherData(
        id = "103",
        name = "Éored",
        tags = listOf(
            "eored",
            "others",
            "armies",
            "rohirrim"
        )
    ),
    OtherData(
        id = "104",
        name = "Éothéod",
        tags = listOf(
            "eotheod",
            "people",
            "men",
            "others",
            "northmen"
        )
    ),
    OtherData(
        id = "105",
        name = "Epessë",
        tags = listOf(
            "epesse",
            "others"
        )
    ),
    OtherData(
        id = "106",
        name = "Espejo de Galadriel",
        tags = listOf(
            "espejo de galadriel",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "107",
        name = "Falathrim",
        tags = listOf(
            "falathrim",
            "others",
            "people",
            "elven_peoples",
            "moriquendi",
            "sindar",
            "grey_elves"
        )
    ),
    OtherData(
        id = "108",
        name = "Falmari",
        tags = listOf(
            "falmari",
            "people",
            "elven_peoples",
            "others",
            "teleri"
        )
    ),
    OtherData(
        id = "109",
        name = "Familia Arenas",
        tags = listOf(
            "familia arenas",
            "sandyman",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "110",
        name = "Familia Boffin",
        tags = listOf(
            "familia boffin",
            "boffin",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "111",
        name = "Familia Bolger",
        tags = listOf(
            "familia bolger",
            "bolger",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "112",
        name = "Familia Bolsón",
        tags = listOf(
            "familia bolson",
            "bolson",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "113",
        name = "Familia Brandigamo",
        tags = listOf(
            "familia brandigamo",
            "brandigamo",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "114",
        name = "Familia Ciñatiesa",
        tags = listOf(
            "familia ciñatiesa",
            "ciñatiesa",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "115",
        name = "Familia Coto",
        tags = listOf(
            "familia coto",
            "coto",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "116",
        name = "Familia Gamyi",
        tags = listOf(
            "familia gamyi",
            "gamyi",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "117",
        name = "Familia Ganapié",
        tags = listOf(
            "familia ganapie",
            "ganapie",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "118",
        name = "Familia Jardner",
        tags = listOf(
            "familia jardner",
            "jardner",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "119",
        name = "Familia Sacovilla-Bolsón",
        tags = listOf(
            "sacovilla-bolson",
            "sacovilla",
            "bolson",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "120",
        name = "Familia Tuk",
        tags = listOf(
            "familia tuk",
            "tuk",
            "others",
            "hobbit_families"
        )
    ),
    OtherData(
        id = "121",
        name = "Fëanturi",
        tags = listOf(
            "feanturi",
            "valarin_titles",
            "others"
        )
    ),
    OtherData(
        id = "122",
        name = "Fieles",
        tags = listOf(
            "fieles",
            "organizations",
            "others",
            "faithful",
            "numenor_key_people"
        )
    ),
    OtherData(
        id = "123",
        name = "Flecha Negra",
        tags = listOf(
            "flecha negra",
            "weapons",
            "arrows",
            "others",
            "heirlooms",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "124",
        name = "Flecha Roja",
        tags = listOf(
            "flecha roja",
            "weapons",
            "others",
            "arrows"
        )
    ),
    OtherData(
        id = "125",
        name = "Frasco de Galadriel",
        tags = listOf(
            "frasco de galadriel",
            "luz de earendil",
            "others",
            "objects",
            "magical_objects",
            "gifts_of_galadriel"
        )
    ),
    OtherData(
        id = "126",
        name = "Galadhrim",
        tags = listOf(
            "galadhrim",
            "galadrim",
            "others",
            "people",
            "elven_peoples",
            "silvan",
            "elves"
        )
    ),
    OtherData(
        id = "127",
        name = "Galathilion",
        tags = listOf(
            "galathilion",
            "arbol blanco",
            "others",
            "plants",
            "trees",
            "creations_of_the_valar"
        )
    ),
    OtherData(
        id = "128",
        name = "Galvorn",
        tags = listOf(
            "galvorn",
            "materials",
            "others"
        )
    ),
    OtherData(
        id = "129",
        name = "Gaurwaith",
        tags = listOf(
            "gaurwaith",
            "proscritos",
            "others",
            "organizations",
            "edain"
        )
    ),
    OtherData(
        id = "130",
        name = "Gil-Estel",
        tags = listOf(
            "gil-estel",
            "estrella de earendil",
            "others",
            "stars",
            "middle_earth_cosmology"
        )
    ),
    OtherData(
        id = "131",
        name = "Glamdring",
        tags = listOf(
            "glamdring",
            "demoledora",
            "weapons",
            "others",
            "swords"
        )
    ),
    OtherData(
        id = "132",
        name = "Glingal y Belthil",
        tags = listOf(
            "glingal",
            "belthil",
            "plants",
            "trees",
            "others",
            "realm_of_gondolin"
        )
    ),
    OtherData(
        id = "133",
        name = "Gondorianos",
        tags = listOf(
            "gondorianos",
            "hombres de gondor",
            "men",
            "gondorians",
            "people",
            "others"
        )
    ),
    OtherData(
        id = "134",
        name = "Gran Armamento",
        tags = listOf(
            "gran armamento",
            "others",
            "armies",
            "numenor_key_people",
            "ships"
        )
    ),
    OtherData(
        id = "135",
        name = "Gremio de los Aventureros",
        tags = listOf(
            "gremio de los aventureros",
            "organizations",
            "others",
            "numenor_key_people"
        )
    ),
    OtherData(
        id = "136",
        name = "Grond (ariete)",
        tags = listOf(
            "grond",
            "weapons",
            "others",
            "army_of_mordor"
        )
    ),
    OtherData(
        id = "137",
        name = "Grond (maza)",
        tags = listOf(
            "grond",
            "weapons",
            "others",
            "maces"
        )
    ),
    OtherData(
        id = "138",
        name = "Guardias de la Ciudadela",
        tags = listOf(
            "guardias de la ciudadela",
            "guardias de la torre",
            "gondor",
            "armies",
            "others",
            "minas_tirith"
        )
    ),
    OtherData(
        id = "139",
        name = "Gurthang",
        tags = listOf(
            "gurthang",
            "others",
            "weapons",
            "swords"
        )
    ),
    OtherData(
        id = "140",
        name = "Gwaith-i-Mírdain",
        tags = listOf(
            "gwaith i mirdain",
            "gwaith-i-mirdain",
            "organizations",
            "others",
            "smiths"
        )
    ),
    OtherData(
        id = "141",
        name = "Haradrim",
        tags = listOf(
            "haradrim",
            "haradwaith",
            "others",
            "people",
            "men",
            "servants_of_sauron",
            "army_of_mordor"
        )
    ),
    OtherData(
        id = "142",
        name = "Hijos de Fëanor",
        tags = listOf(
            "hijos de feanor",
            "others",
            "people"
        )
    ),
    OtherData(
        id = "143",
        name = "Hírilorn",
        tags = listOf(
            "hirilorn",
            "others",
            "plants",
            "trees",
            "doriath"
        )
    ),
    OtherData(
        id = "144",
        name = "Hithlain",
        tags = listOf(
            "hithlain",
            "others",
            "materials"
        )
    ),
    OtherData(
        id = "145",
        name = "Hobbits Albos",
        tags = listOf(
            "hobbits albos",
            "hobbits",
            "others",
            "people",
            "hobbits_breeds",
            "fallohides",
            "albos"
        )
    ),
    OtherData(
        id = "146",
        name = "Hobbits Fuertes",
        tags = listOf(
            "hobbits fuertes",
            "fuertes",
            "stoors",
            "others",
            "people",
            "hobbits_breeds",
            "hobbits"
        )
    ),
    OtherData(
        id = "147",
        name = "Hobbits Pelosos",
        tags = listOf(
            "hobbits pelosos",
            "pelosos",
            "hobbits",
            "people",
            "others",
            "hobbits_breeds",
            "harfoots"
        )
    ),
    OtherData(
        id = "148",
        name = "Hombres del Norte",
        tags = listOf(
            "hombres del norte",
            "northmen",
            "men",
            "people",
            "others"
        )
    ),
    OtherData(
        id = "149",
        name = "Hombres del Rey",
        tags = listOf(
            "hombres del rey",
            "kings_men",
            "others",
            "organizations",
            "servants_of_sauron",
            "numenor_key_people"
        )
    ),
    OtherData(
        id = "150",
        name = "Istari",
        tags = listOf(
            "istari",
            "magos",
            "organizations",
            "others",
            "maiar"
        )
    ),
    OtherData(
        id = "151",
        name = "Ithildin",
        tags = listOf(
            "ithildin",
            "others",
            "materials",
            "magical_objects"
        )
    ),
    OtherData(
        id = "152",
        name = "Jefe de los Dúnedain",
        tags = listOf(
            "jefe de los dunedain",
            "chieftain_of_the_dunedain",
            "titles",
            "others",
            "dunedain",
            "rulers_middle_earth"
        )
    ),
    OtherData(
        id = "153",
        name = "Kelvar",
        tags = listOf(
            "kelvar",
            "others",
            "concepts"
        )
    ),
    OtherData(
        id = "154",
        name = "Laiquendi",
        tags = listOf(
            "laiquendi",
            "elfos verdes",
            "others",
            "people",
            "elven_peoples",
            "elves",
            "moriquendi",
            "nandor"
        )
    ),
    OtherData(
        id = "155",
        name = "Lambengolmor",
        tags = listOf(
            "lambengolmor",
            "loremasters",
            "others",
            "elven_titles",
            "elves"
        )
    ),
    OtherData(
        id = "156",
        name = "Laurelin",
        tags = listOf(
            "laurelin",
            "plants",
            "others",
            "trees",
            "valinor",
            "before_first_age"
        )
    ),
    OtherData(
        id = "157",
        name = "Lembas",
        tags = listOf(
            "lembas",
            "others",
            "food_drinks"
        )
    ),
    OtherData(
        id = "158",
        name = "Llama Imperecedera",
        tags = listOf(
            "llama imperecedera",
            "others",
            "concepts",
            "middle_earth_cosmology"
        )
    ),
    OtherData(
        id = "159",
        name = "Luna",
        tags = listOf(
            "luna",
            "middle_earth_cosmology",
            "creations_of_the_valar",
            "others"
        )
    ),
    OtherData(
        id = "160",
        name = "Maiar",
        tags = listOf(
            "maiar",
            "others",
            "people",
            "ainur"
        )
    ),
    OtherData(
        id = "161",
        name = "Mallorn",
        tags = listOf(
            "mallorn",
            "others",
            "plants",
            "trees"
        )
    ),
    OtherData(
        id = "162",
        name = "Mapa de Thrór",
        tags = listOf(
            "mapa de thror",
            "others",
            "maps",
            "objects",
            "thrors_map",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "163",
        name = "Mathoms",
        tags = listOf(
            "mathom",
            "mathoms",
            "others",
            "objects"
        )
    ),
    OtherData(
        id = "164",
        name = "Medio-elfos",
        tags = listOf(
            "medio elfos",
            "medio-elfos",
            "peredhil",
            "others",
            "people",
            "hybrid_peoples"
        )
    ),
    OtherData(
        id = "165",
        name = "Mithril",
        tags = listOf(
            "mithril",
            "others",
            "materials"
        )
    ),
    OtherData(
        id = "166",
        name = "Montaraces de Ithilien",
        tags = listOf(
            "montaraces de ithilien",
            "organizations",
            "others",
            "rangers_of_ithilien",
            "rangers"
        )
    ),
    OtherData(
        id = "167",
        name = "Montaraces del Norte",
        tags = listOf(
            "montaraces del norte",
            "organizations",
            "others",
            "rangers",
            "rangers_of_the_north"
        )
    ),
    OtherData(
        id = "168",
        name = "Morenos",
        tags = listOf(
            "morenos",
            "blacklocks",
            "people",
            "others",
            "dwarven_clans"
        )
    ),
    OtherData(
        id = "169",
        name = "Moriquendi",
        tags = listOf(
            "moriquendi",
            "others",
            "people",
            "elven_peoples",
            "elves"
        )
    ),
    OtherData(
        id = "170",
        name = "Nalgudos",
        tags = listOf(
            "nalgudos",
            "broadbeams",
            "people",
            "others",
            "dwarven_clans"
        )
    ),
    OtherData(
        id = "171",
        name = "Nandor",
        tags = listOf(
            "nandor",
            "people",
            "elven_peoples",
            "others",
            "elves",
            "moriquendi"
        )
    ),
    OtherData(
        id = "172",
        name = "Narsil",
        tags = listOf(
            "narsil",
            "others",
            "swords",
            "weapons",
            "heirlooms",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "173",
        name = "Narya",
        tags = listOf(
            "narya",
            "others",
            "rings_jewels",
            "rings_of_power",
            "magical_objects",
            "objects"
        )
    ),
    OtherData(
        id = "174",
        name = "Nauglamír",
        tags = listOf(
            "nauglamir",
            "others",
            "rings_jewels",
            "dwarven_objects",
            "objects"
        )
    ),
    OtherData(
        id = "175",
        name = "Nenya",
        tags = listOf(
            "nenya",
            "others",
            "objects",
            "magical_objects",
            "rings_jewels",
            "rings_of_power"
        )
    ),
    OtherData(
        id = "176",
        name = "Nimloth",
        tags = listOf(
            "nimloth",
            "plants",
            "others",
            "trees",
            "numenor_plants",
            "arbol blanco"
        )
    ),
    OtherData(
        id = "177",
        name = "Nimphelos",
        tags = listOf(
            "nimphelos",
            "objects",
            "others",
            "rings_jewels"
        )
    ),
    OtherData(
        id = "178",
        name = "Niphredil",
        tags = listOf(
            "niphredil",
            "plants",
            "flowers",
            "others"
        )
    ),
    OtherData(
        id = "179",
        name = "Noldor",
        tags = listOf(
            "noldor",
            "others",
            "people",
            "elven_peoples",
            "high_elves",
            "elves"
        )
    ),
    OtherData(
        id = "180",
        name = "Nueve Anillos",
        tags = listOf(
            "nueve anillos",
            "rings_jewels",
            "rings of power",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "181",
        name = "Númenóreanos",
        tags = listOf(
            "numenoreanos",
            "numenorean",
            "people",
            "others",
            "men",
            "edain"
        )
    ),
    OtherData(
        id = "182",
        name = "Númenóreanos Negros",
        tags = listOf(
            "numenoreanos negros",
            "black_numenoreans",
            "servants_of_sauron",
            "others",
            "people",
            "men"
        )
    ),
    OtherData(
        id = "183",
        name = "Ojo de Sauron",
        tags = listOf(
            "ojo de sauron",
            "symbols",
            "others",
            "objects",
            "mordor"
        )
    ),
    OtherData(
        id = "184",
        name = "Olvar",
        tags = listOf(
            "olvar",
            "others",
            "concepts",
            "plants"
        )
    ),
    OtherData(
        id = "185",
        name = "Orcrist",
        tags = listOf(
            "orcrist",
            "others",
            "weapons",
            "swords",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "186",
        name = "Orientales",
        tags = listOf(
            "orientales",
            "cetrinos",
            "easterling",
            "others",
            "people",
            "men",
            "servants_of_morgoth",
            "servants_of_sauron",
            "army_of_mordor"
        )
    ),
    OtherData(
        id = "187",
        name = "Palantíri",
        tags = listOf(
            "palantiri",
            "palantir",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "188",
        name = "Piedra de Amon Sûl",
        tags = listOf(
            "piedra de amon sul",
            "palantir",
            "others",
            "objects",
            "magical_objects",
            "palantiri"
        )
    ),
    OtherData(
        id = "189",
        name = "Piedra de Annúminas",
        tags = listOf(
            "piedra de annuminas",
            "palantir",
            "palantiri",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "190",
        name = "Piedra de Anor",
        tags = listOf(
            "piedra de anor",
            "palantir",
            "palantiri",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "191",
        name = "Piedra de Elostirion",
        tags = listOf(
            "piedra de elostirion",
            "palantir",
            "palantiri",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "192",
        name = "Piedra de Ithil",
        tags = listOf(
            "piedra de ithil",
            "palantir",
            "palantiri",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "193",
        name = "Piedra de Orthanc",
        tags = listOf(
            "piedra de orthanc",
            "objects",
            "magical_objects",
            "others",
            "palantir",
            "palantiri"
        )
    ),
    OtherData(
        id = "194",
        name = "Piedra de Osgiliath",
        tags = listOf(
            "piedra de osgiliath",
            "palantir",
            "palantiri",
            "magical_objects",
            "objects",
            "others"
        )
    ),
    OtherData(
        id = "195",
        name = "Piedra del Arca",
        tags = listOf(
            "piedra del arca",
            "arkenstone",
            "others",
            "rings_jewels",
            "heirlooms",
            "dwarven_objects"
        )
    ),
    OtherData(
        id = "196",
        name = "Piedra del Elfo",
        tags = listOf(
            "piedra del elfo",
            "elfstone",
            "elessar",
            "objects",
            "magical_objects",
            "rings_jewels",
            "gifts_of_galadriel",
            "heirlooms"
        )
    ),
    OtherData(
        id = "197",
        name = "Piedra Maestra",
        tags = listOf(
            "piedra maestra",
            "palantir",
            "palantiri",
            "others",
            "objects",
            "magical_objects"
        )
    ),
    OtherData(
        id = "198",
        name = "Pies de Piedra",
        tags = listOf(
            "pies de piedra",
            "stonefoots",
            "people",
            "dwarven_clans",
            "others"
        )
    ),
    OtherData(
        id = "199",
        name = "Portadores de Anillos",
        tags = listOf(
            "portador del anillo",
            "portadores de anillos",
            "ring_bearer",
            "others",
            "titles",
            "bearer_of_the_one_ring"
        )
    ),
    OtherData(
        id = "200",
        name = "Primera Edad",
        tags = listOf(
            "primera edad",
            "first_age",
            "ages",
            "eras",
            "time"
        )
    ),
    OtherData(
        id = "201",
        name = "Prohibición de los Valar",
        tags = listOf(
            "prohibicion de los valar",
            "creations_of_the_valar",
            "decrees",
            "numenor_concepts",
            "others"
        )
    ),
    OtherData(
        id = "202",
        name = "Proscritos de Barahir",
        tags = listOf(
            "proscritos de barahir",
            "barahir_outlaws",
            "xii beorings",
            "others",
            "organizations",
            "edain",
            "house_of_beor"
        )
    ),
    OtherData(
        id = "203",
        name = "Pueblo de Durin",
        tags = listOf(
            "pueblo de durin",
            "longbeards",
            "barbiluengos",
            "dwarven_clans",
            "dwarves",
            "others",
            "people"
        )
    ),
    OtherData(
        id = "204",
        name = "Pueblos Libres",
        tags = listOf(
            "pueblos libres",
            "free_people",
            "others",
            "organizations"
        )
    ),
    OtherData(
        id = "205",
        name = "Puñal de Morgul",
        tags = listOf(
            "puñal de morgul",
            "weapons",
            "others",
            "knives",
            "nazgul"
        )
    ),
    OtherData(
        id = "206",
        name = "Puños de Hierro",
        tags = listOf(
            "puños de hierro",
            "ironfists",
            "others",
            "people",
            "dwarven_clans",
            "dwarves"
        )
    ),
    OtherData(
        id = "207",
        name = "Quendi",
        tags = listOf(
            "quendi",
            "elves",
            "others"
        )
    ),
    OtherData(
        id = "208",
        name = "Regalos de Galadriel",
        tags = listOf(
            "regalos de galadriel",
            "gifts_of_galadriel",
            "objects",
            "others"
        )
    ),
    OtherData(
        id = "209",
        name = "Rey Bajo la Montaña",
        tags = listOf(
            "rey bajo la montaña",
            "titles",
            "dwarven_titles",
            "others",
            "kings_under_the_mountain",
            "kings_of_durins_folk"
        )
    ),
    OtherData(
        id = "210",
        name = "Rey de Arnor",
        tags = listOf(
            "rey de arnor",
            "arnor",
            "mannish_titles",
            "titles",
            "kings",
            "kings_of_arnor",
            "rulers_middle_earth",
            "others",
            "ruler_of_arnor"
        )
    ),
    OtherData(
        id = "211",
        name = "Rey de Arthedain",
        tags = listOf(
            "rey de arthedain",
            "arthedain",
            "kings_of_arthedain",
            "rulers_middle_earth",
            "mannish_titles",
            "arnor",
            "kings",
            "others"
        )
    ),
    OtherData(
        id = "212",
        name = "Rey de Gondor",
        tags = listOf(
            "rey de gondor",
            "gondor",
            "rulers_middle_earth",
            "others",
            "mannish_titles",
            "kings_of_gondor",
            "ruler_of_gondor"
        )
    ),
    OtherData(
        id = "213",
        name = "Rey de Númenor",
        tags = listOf(
            "rey de numenor",
            "reyes de numenor",
            "numenor",
            "titles",
            "others",
            "mannish_titles",
            "kings_of_numenor",
            "rulers_of_numenor",
            "numenor_key_people"
        )
    ),
    OtherData(
        id = "214",
        name = "Rey de Rohan",
        tags = listOf(
            "rey de rohan",
            "rohan",
            "titles",
            "others",
            "mannish_titles",
            "kings_of_rohan",
            "ruler_of_rohan",
            "rulers_middle_earth"
        )
    ),
    OtherData(
        id = "215",
        name = "Rey de Valle",
        tags = listOf(
            "rey de valle",
            "ciudad de valle",
            "valle",
            "titles",
            "others",
            "mannish_titles",
            "rulers_middle_earth",
            "kings_of_dale"
        )
    ),
    OtherData(
        id = "216",
        name = "Ringil",
        tags = listOf(
            "ringil",
            "others",
            "weapons",
            "swords"
        )
    ),
    OtherData(
        id = "217",
        name = "Rohirrim",
        tags = listOf(
            "rohirrim",
            "rohan",
            "others",
            "people",
            "northmen"
        )
    ),
    OtherData(
        id = "218",
        name = "Segunda Edad",
        tags = listOf(
            "segunda edad",
            "second_age",
            "ages",
            "eras",
            "time",
            "others"
        )
    ),
    OtherData(
        id = "219",
        name = "Senescal de Gondor",
        tags = listOf(
            "senescal",
            "regente",
            "stewards",
            "rulling_stewards",
            "ruler_of_gondor",
            "others",
            "titles",
            "mannish_titles"
        )
    ),
    OtherData(
        id = "220",
        name = "Señor de Andúnië",
        tags = listOf(
            "señor de andunie",
            "numenor_key_people",
            "others",
            "titles",
            "mannish_titles",
            "house_of_elros",
            "house_of_valandil",
            "rulers_of_numenor",
            "lords_of_andunie"
        )
    ),
    OtherData(
        id = "221",
        name = "Señor de Los Gamos",
        tags = listOf(
            "señor de los gamos",
            "others",
            "titles",
            "hobbitish_titles",
            "masters_of_buckland"
        )
    ),
    OtherData(
        id = "222",
        name = "Seregon",
        tags = listOf(
            "seregon",
            "others",
            "plants",
            "flowers"
        )
    ),
    OtherData(
        id = "223",
        name = "Siete Anillos",
        tags = listOf(
            "siete anillos",
            "rings_of_power",
            "rings_jewels",
            "others",
            "magical_objects",
            "objects"
        )
    ),
    OtherData(
        id = "224",
        name = "Siete Padres de los Enanos",
        tags = listOf(
            "siete padres",
            "others",
            "dwarves"
        )
    ),
    OtherData(
        id = "225",
        name = "Silmarils",
        tags = listOf(
            "silmarils",
            "objects",
            "others",
            "rings_jewels",
            "heirlooms"
        )
    ),
    OtherData(
        id = "226",
        name = "Sindar",
        tags = listOf(
            "sindar",
            "people",
            "elven_peoples",
            "others",
            "grey_elves"
        )
    ),
    OtherData(
        id = "227",
        name = "Sol",
        tags = listOf(
            "sol",
            "middle_earth_cosmology",
            "others",
            "creations_of_the_valar"
        )
    ),
    OtherData(
        id = "228",
        name = "Teleri",
        tags = listOf(
            "teleri",
            "people",
            "elven_peoples",
            "others"
        )
    ),
    OtherData(
        id = "229",
        name = "Telperion",
        tags = listOf(
            "telperion",
            "arbol blanco",
            "plants",
            "others",
            "trees",
            "valinor",
            "creations_of_the_valar",
            "before_first_age"
        )
    ),
    OtherData(
        id = "230",
        name = "Tercera Edad",
        tags = listOf(
            "tercera edad",
            "ages",
            "others",
            "third_age",
            "eras",
            "time"
        )
    ),
    OtherData(
        id = "231",
        name = "Tahin de la Comarca",
        tags = listOf(
            "thains",
            "thain de la comarca",
            "others",
            "titles",
            "hobbitish_titles"
        )
    ),
    OtherData(
        id = "232",
        name = "Tres Anillos",
        tags = listOf(
            "tres anillos",
            "objects",
            "magical_objects",
            "others",
            "rings_jewels"
        )
    ),
    OtherData(
        id = "233",
        name = "Última Alianza de Elfos y Hombres",
        tags = listOf(
            "ultima alianza",
            "ultima alianza de elfos y hombres",
            "organizations",
            "armies",
            "others"
        )
    ),
    OtherData(
        id = "234",
        name = "Ulumúri",
        tags = listOf(
            "ulumuri",
            "objects",
            "others"
        )
    ),
    OtherData(
        id = "235",
        name = "Úmanyar",
        tags = listOf(
            "umanyar",
            "people",
            "others",
            "elven_peoples"
        )
    ),
    OtherData(
        id = "236",
        name = "Unión de Maedhros",
        tags = listOf(
            "union de maedhros",
            "organizations",
            "armies",
            "others"
        )
    ),
    OtherData(
        id = "237",
        name = "Uruk-hai",
        tags = listOf(
            "uruk-hai",
            "uruk_hai",
            "uruks",
            "others",
            "people",
            "servants_of_sauron",
            "servants_of_saruman"
        )
    ),
    OtherData(
        id = "238",
        name = "Vaina de Andúril",
        tags = listOf(
            "gifts_of_galadriel",
            "vaina de anduril",
            "others",
            "objects"
        )
    ),
    OtherData(
        id = "239",
        name = "Valar",
        tags = listOf(
            "valar",
            "others",
            "people",
            "ainur",
            "heavenly_beigns"
        )
    ),
    OtherData(
        id = "240",
        name = "Valaróma",
        tags = listOf(
            "valaroma",
            "others",
            "objects"
        )
    ),
    OtherData(
        id = "241",
        name = "Vanyar",
        tags = listOf(
            "vanyar",
            "minyar",
            "others",
            "elves",
            "elven_peoples",
            "people",
            "high_elves"
        )
    ),
    OtherData(
        id = "242",
        name = "Variags",
        tags = listOf(
            "variags",
            "others",
            "people",
            "men",
            "servants_of_sauron",
            "khand"
        )
    ),
    OtherData(
        id = "243",
        name = "Vilya",
        tags = listOf(
            "vilya",
            "objects",
            "others",
            "magical_objects",
            "rings_jewels",
            "rings_of_power"
        )
    ),
    OtherData(
        id = "244",
        name = "Vingilot",
        tags = listOf(
            "vingilot",
            "ships",
            "others"
        )
    ),
    OtherData(
        id = "245",
        name = "Yelmo-Dragón de Dor-Lómin",
        tags = listOf(
            "yelmo dragon de dor lomin",
            "yelmo dragon",
            "yelmo de hador",
            "armor",
            "others",
            "heirlooms",
            "dwarven_objects"
        )
    )
)