package org.demre.ei8razasperros.data

import android.util.Log
import androidx.lifecycle.LiveData
import org.demre.ei8razasperros.data.local.RazaDao
import org.demre.ei8razasperros.data.local.RazaDetalleEntity
import org.demre.ei8razasperros.data.local.RazaEntity
import org.demre.ei8razasperros.data.remote.PerrosApi

class Repositorio(private val perrosApi: PerrosApi,private val razaDao: RazaDao) {

    fun obtenerRazaEntentity(): LiveData<List<RazaEntity>> = razaDao.getRazas()
    fun obtenerDetalleEntentity(id: String): LiveData<List<RazaDetalleEntity>> = razaDao.getRazaDetalle(id)
    suspend fun getRazas(){
        val response = perrosApi.getDataPerros()
        if(response.isSuccessful){
            val message = response.body()!!.message// solo scando la parte de message, sin stattus
            val keys = message.keys

            keys.forEach{raza->
                val razaEntity = raza.toRazaEntity()
                razaDao.insertRaza(razaEntity)
            }

        }else{
            Log.e("repositorio", response.errorBody().toString())
        }

    }

    suspend fun getDetallePerro(id: String){
        val response = perrosApi.getDetallePerro(id)
        if(response.isSuccessful){
            response.body()!!.message.forEach{url->
                val razaDetalleEntity = url.toEntity(id) //transformando para realizar TEST(del remoto al entity)
                razaDao.insertDetallePerro(razaDetalleEntity)
            }


        }else{
            Log.e("repositorio", response.errorBody().toString())
        }

    }
}