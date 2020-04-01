package com.jportillo8.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.jportillo8.platziconf.model.Speaker
import com.jportillo8.platziconf.network.Callback
import com.jportillo8.platziconf.network.FirestoreService
import androidx.lifecycle.ViewModel

import java.lang.Exception

class SpeakerViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh (){
        getSpeakersFromFirebase()
    }

    private fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object: Callback<List<Speaker>>{
            override fun onSuccess(result: List<Speaker>?) {
                listSpeaker.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })
    }

    fun processFinished() {
        isLoading.value = true
    }

}