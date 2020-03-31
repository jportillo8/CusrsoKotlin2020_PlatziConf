package com.jportillo8.platziconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.jportillo8.platziconf.model.Conference
import com.jportillo8.platziconf.model.Speaker

const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    //Persistiendo dentro de la aplicacion
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    //Es como un constructor apenas inicializamos la clase
    init {
        //Ya tendriamos los datos que descargados , tendriamos la persistencia
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->  //Informacion para almacenar en el viewModel
                for (doc in result){
                    val list = result.toObjects(Speaker::class.java)//Tendriamos todos los docs speakers
                    callback.onSuccess(list)//Lo enviamos a traves del callback
                    break
                }
            }
    }
    fun getShedule(callback: Callback<List<Conference>>){
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->  //Informacion para almacenar en el viewModel
                for (doc in result){
                    val list = result.toObjects(Conference::class.java)//Tendriamos todos los docs conferencias
                    callback.onSuccess(list)//Lo enviamos a traves del callback
                    break
                }
            }
    }
}

