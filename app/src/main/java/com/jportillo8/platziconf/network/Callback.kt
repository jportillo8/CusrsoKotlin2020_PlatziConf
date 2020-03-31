package com.jportillo8.platziconf.network

import java.lang.Exception

//callback nos permite implementar las funciones que nesecitamos cuando recibimos informacion externa
//El parametro T es tipo de dato que puede ser diferente cada vez
interface Callback<T> {
    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)
}