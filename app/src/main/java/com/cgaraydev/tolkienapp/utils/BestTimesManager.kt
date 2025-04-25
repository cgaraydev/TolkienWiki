package com.cgaraydev.tolkienapp.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "best_times")

class BestTimesManager(private val context: Context) {

    companion object {
        private val HOBBIT_TIMES = stringPreferencesKey("hobbit_times")
        private val ELFO_TIMES = stringPreferencesKey("elfo_times")
        private val AINUR_TIMES = stringPreferencesKey("ainur_times")
    }

    private fun getKey(difficulty: String) = when(difficulty) {
        "hobbit" -> HOBBIT_TIMES
        "elfo" -> ELFO_TIMES
        "ainur" -> AINUR_TIMES
        else -> throw IllegalArgumentException("Dificultad no válida")
    }

    suspend fun saveTime(difficulty: String, time: Long) {
        context.dataStore.edit { prefs ->
            val current = prefs[getKey(difficulty)] ?: ""
            val newTimes = (current.split(",") + time.toString())
                .filter { it.isNotEmpty() }
                .map { it.toLong() }
                .sorted()
                .take(10) // Guardamos solo los 10 mejores
                .joinToString(",")

            prefs[getKey(difficulty)] = newTimes
        }
    }

    fun getTimes(difficulty: String): Flow<List<Long>> {
        return context.dataStore.data.map { prefs ->
            prefs[getKey(difficulty)]?.split(",")
                ?.filter { it.isNotEmpty() }
                ?.map { it.toLong() }
                ?.sorted() ?: emptyList()
        }
    }
}