package com.jportillo8.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jportillo8.platziconf.model.Conference
import com.jportillo8.platziconf.network.Callback
import com.jportillo8.platziconf.network.FirestoreService

//Comunicar firestore con UI
class ScheduleViewModel : ViewModel(){
    val firestoreService = FirestoreService()

    //viewModel con livedata
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()

    //nos permite actulizar la UI de carga
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSchedulesFromFirebase()
    }

    fun getSchedulesFromFirebase() {
        firestoreService.getShedule(object : Callback<List<Conference>> {
            override fun onSuccess(result: List<Conference>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })
    }

    //Esto nos permite saber cuando termina un proceso sea exitoso o fallido
    //por que en la vista necesitamos ocultar nuestro proceso de carga
    fun processFinished() {
        isLoading.value = true
    }

}