package com.cgaraydev.tolkienapp.utils

import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.data.local.datalocal.BookData
import com.cgaraydev.tolkienapp.data.local.datalocal.CharacterData
import com.cgaraydev.tolkienapp.data.local.datalocal.EventData
import com.cgaraydev.tolkienapp.data.local.datalocal.LanguageData
import com.cgaraydev.tolkienapp.data.local.datalocal.LocationData
import com.cgaraydev.tolkienapp.data.local.datalocal.OtherData
import com.cgaraydev.tolkienapp.data.local.datalocal.RaceData

sealed class SearchResult {
    data class CharacterResult(val data: CharacterData) : SearchResult()
    data class LocationResult(val data: LocationData) : SearchResult()
    data class RaceResult(val data: RaceData) : SearchResult()
    data class EventResult(val data: EventData) : SearchResult()
    data class LanguageResult(val data: LanguageData) : SearchResult()
    data class OtherResult(val data: OtherData) : SearchResult()
    data class BookResult(val data: BookData) : SearchResult()

    val id: String
        get() = when (this) {
            is CharacterResult -> data.id
            is LocationResult -> data.id
            is EventResult -> data.id
            is LanguageResult -> data.id
            is OtherResult -> data.id
            is RaceResult -> data.id
            is BookResult -> data.id
        }

    val name: String
        get() = when (this) {
            is CharacterResult -> data.name
            is LocationResult -> data.name
            is EventResult -> data.name
            is LanguageResult -> data.name
            is OtherResult -> data.name
            is RaceResult -> data.name
            is BookResult -> data.title
        }

    val type: String
        get() = when (this) {
            is CharacterResult -> "character"
            is LocationResult -> "location"
            is EventResult -> "event"
            is LanguageResult -> "language"
            is OtherResult -> "other"
            is RaceResult -> "race"
            is BookResult -> "book"
        }


}

fun navigateToDetails(result: SearchResult, navController: NavController) {
    when (result) {
        is SearchResult.CharacterResult ->
            navController.navigate("characterDetails/${result.data.id}")

        is SearchResult.LocationResult ->
            navController.navigate("locationDetails/${result.data.id}")

        is SearchResult.EventResult ->
            navController.navigate("eventDetails/${result.data.id}")

        is SearchResult.LanguageResult ->
            navController.navigate("languageDetails/${result.data.id}")

        is SearchResult.OtherResult ->
            navController.navigate("otherDetails/${result.data.id}")

        is SearchResult.RaceResult ->
            navController.navigate("raceDetails/${result.data.id}")

        is SearchResult.BookResult ->
            navController.navigate("bookDetails/${result.data.id}")
    }
}