package com.cgaraydev.tolkienapp.presentation.maps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cgaraydev.tolkienapp.data.local.datalocal.MapData
import com.cgaraydev.tolkienapp.data.local.datalocal.mapsList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor() : ViewModel() {

    private val _mapsLocal = mutableStateOf(mapsList)
    val mapsLocal: State<List<MapData>> = _mapsLocal

    fun getMapById(id: String): MapData? {
        return mapsList.find { it.id == id }
    }

}