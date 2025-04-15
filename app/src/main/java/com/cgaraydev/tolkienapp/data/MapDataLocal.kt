package com.cgaraydev.tolkienapp.data

import androidx.annotation.DrawableRes
import com.cgaraydev.tolkienapp.R

data class MapData(
    val id: String,
    val name: String,
    val imageUrl: String,
    @DrawableRes val thumbnailRes: Int
)

val mapsList = listOf(
    MapData(
        id = "0",
        name = "Angband",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fangband_1.jpg?alt=media&token=1b8b6854-d937-4a1e-b5c3-9e47eb516e07",
        thumbnailRes = R.drawable.thumb_angband
    ),
    MapData(
        id = "1",
        name = "Arda",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Farda_1.jpg?alt=media&token=6d701d73-209e-442a-b013-31de692746fa",
        thumbnailRes = R.drawable.thumb_arda
    ),
    MapData(
        id = "2",
        name = "Beleriand",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2FBeleriand.jpg?alt=media&token=2bb5b6d5-4436-40af-8594-bc3511038d74",
        thumbnailRes = R.drawable.thumb_beleriand
    ),
    MapData(
        id = "3",
        name = "Mapa de Thrór",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Ferebor_1.png?alt=media&token=08e720d7-cae2-4b87-bbdf-7a91fc3a1257",
        thumbnailRes = R.drawable.thumb_erebor
    ),
    MapData(
        id = "4",
        name = "Reinos Beleriand",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fmap_politics_1.png?alt=media&token=90159fe6-3c9d-445b-b4ef-055938ff1bea",
        thumbnailRes = R.drawable.thumb_map_politics
    ),
    MapData(
        id = "5",
        name = "Tierra Media",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fmiddle_earth_1.png?alt=media&token=5ff44156-8d15-4870-afc2-d07738d6af72",
        thumbnailRes = R.drawable.thumb_map_middle_earth_1
    ),
    MapData(
        id = "6",
        name = "Tierra Media",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fmiddle_earth_2.png?alt=media&token=179e0592-a5dc-419a-8ddf-57ec2ecf9588",
        thumbnailRes = R.drawable.thumb_map_middle_earth_2
    ),
    MapData(
        id = "7",
        name = "Tierra Media",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fmiddle_earth_3.jpg?alt=media&token=8835dc5a-d360-456e-b608-66093350b912",
        thumbnailRes = R.drawable.thumb_map_middle_earth_3
    ),
    MapData(
        id = "8",
        name = "Tierra Media",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fmiddle_earth_4.jpg?alt=media&token=a2b18373-d1f3-4854-ae51-6ebb73a886b6",
        thumbnailRes = R.drawable.thumb_map_middle_earth_4
    ),
    MapData(
        id = "9",
        name = "Mordor",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fmordor_1.png?alt=media&token=734154e4-b309-472f-bb8f-0533f26d3942",
        thumbnailRes = R.drawable.thumb_mordor
    ),
    MapData(
        id = "10",
        name = "Númenor",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fnumenor_1.png?alt=media&token=64783980-a65b-4501-8b56-1f85473b900d",
        thumbnailRes = R.drawable.thumb_numenor
    ),
    MapData(
        id = "11",
        name = "La Comarca",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/locations%2Fthe_shire%2Fthe_shire_4.png?alt=media&token=37839997-bf3f-4974-8d2d-3759a0311cda",
        thumbnailRes = R.drawable.thumb_map_the_shire_1
    ),
    MapData(
        id = "12",
        name = "La Comarca",
        imageUrl = "https://firebasestorage.googleapis.com/v0/b/lotrwiki-2dd76.appspot.com/o/maps%2Fthe_shire_2.png?alt=media&token=c7e122d5-7042-412e-aec2-14b18de06165",
        thumbnailRes = R.drawable.thumb_map_the_shire_2
    )
)