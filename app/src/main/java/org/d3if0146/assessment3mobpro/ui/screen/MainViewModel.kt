package org.d3if0146.assessment3mobpro.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0146.assessment3mobpro.model.Motor
import org.d3if0146.assessment3mobpro.network.MotorApi

class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Motor>())
        private set
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                data.value = MotorApi.service.getMotor()
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}