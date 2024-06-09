package org.d3if0146.assessment3mobpro.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.d3if0146.assessment3mobpro.model.Motor
import org.d3if0146.assessment3mobpro.network.ApiStatus
import org.d3if0146.assessment3mobpro.network.MotorApi

class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Motor>())
        private set

    var status = MutableStateFlow(ApiStatus.LOADING)
        private set
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.value = ApiStatus.LOADING
            try {
                data.value = MotorApi.service.getMotor()
                status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {

                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}