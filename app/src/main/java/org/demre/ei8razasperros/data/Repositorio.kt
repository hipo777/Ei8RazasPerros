package org.demre.ei8razasperros.data

import androidx.lifecycle.LiveData
import org.demre.ei8razasperros.data.local.RazaDao
import org.demre.ei8razasperros.data.local.RazaEntity
import org.demre.ei8razasperros.data.remote.PerrosApi

class Repositorio(private val perrosApi: PerrosApi,private val razaDao: RazaDao) {

    fun obtenerRazaEntentity(): LiveData<List<RazaEntity>> = razaDao.getRazas()
    suspend fun getRazas(){
        val response = perrosApi.getDataPerros()
        if(response.isSuccessful){
            val message = response.body()!!.message// solo scando la aprte de message, sin stattus
            val keys = message.keys

            keys.forEach{
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }

        }

    }

}