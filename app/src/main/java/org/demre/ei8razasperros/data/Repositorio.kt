package org.demre.ei8razasperros.data

import org.demre.ei8razasperros.data.local.RazaDao
import org.demre.ei8razasperros.data.local.RazaEntity
import org.demre.ei8razasperros.data.remote.RazaAPI

class Repositorio(private val razaAPI: RazaAPI, private val razaDao: RazaDao) {

    suspend fun getRazas() {
        val response = razaAPI.getData() //Obteniendo los datos de la Api.
        if(response.isSuccessful) {  //Comprueba la llegada de datos.
            val message = response.body()!!.message //Obteniendo la parte de message, sin status.
            val keys = message.keys
            keys.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }
        }
    }
}