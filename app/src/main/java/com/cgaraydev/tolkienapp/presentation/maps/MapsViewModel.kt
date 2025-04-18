package com.cgaraydev.tolkienapp.presentation.maps

import androidx.lifecycle.ViewModel
import com.cgaraydev.tolkienapp.data.local.datalocal.MapData
import com.cgaraydev.tolkienapp.data.local.datalocal.mapsList
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    fun getMaps(): List<MapData> {
        return mapsList
    }

    fun getMapById(id: String): MapData? {
        return mapsList.find { it.id == id }
    }

}