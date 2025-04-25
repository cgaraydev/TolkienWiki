package com.cgaraydev.tolkienapp.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.cgaraydev.tolkienapp.data.models.Record
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "best_times")

class BestTimesManager(private val context: Context) {

    companion object {
        private val HOBBIT_TIMES = stringPreferencesKey("hobbit_times")
        private val ELFO_TIMES = stringPreferencesKey("elfo_times")
        private val AINUR_TIMES = stringPreferencesKey("ainur_times")
    }

    private fun getKey(difficulty: String) = when (difficulty) {
        "hobbit" -> HOBBIT_TIMES
        "elfo" -> ELFO_TIMES
        "ainur" -> AINUR_TIMES
        else -> throw IllegalArgumentException("Dificultad no válida")
    }

    suspend fun saveTime(difficulty: String, time: Long, moves: Int) {
        context.dataStore.edit { prefs ->
            val current = prefs[getKey(difficulty)] ?: ""
            val newRecords = (current.split("|") + "$time,$moves,${System.currentTimeMillis()}")
                .filter { it.isNotEmpty() }
                .map {
                    val parts = it.split(",")
                    Record(parts[0].toLong(), parts[1].toInt(), parts[2].toLong())
                }
                .sortedBy { it.time }
                .take(5)
                .joinToString("|") { "${it.time},${it.moves},${it.date}" }

            prefs[getKey(difficulty)] = newRecords
        }
    }

    fun getTimes(difficulty: String): Flow<List<Record>> {
        return context.dataStore.data.map { prefs ->
            prefs[getKey(difficulty)]?.split("|")
                ?.filter { it.isNotEmpty() }
                ?.map {
                    val parts = it.split(",")
                    Record(parts[0].toLong(), parts[1].toInt(), parts[2].toLong())
                }
                ?.sortedBy { it.time } ?: emptyList()
        }
    }

    suspend fun clearTimes(difficulty: String) {
        context.dataStore.edit { prefs ->
            prefs.remove(getKey(difficulty))
        }
    }

}