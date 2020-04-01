package com.jportillo8.platziconf.model

import java.io.Serializable
import java.util.*
//Podemos pasar este objeto entre activitis
class Conference: Serializable {
    //Inicializacion Vacia sin tener que dar un valor inicial
    lateinit var title: String
    lateinit var description: String
    lateinit var tag: String
    lateinit var datetime: Date
    lateinit var speaker: String

}