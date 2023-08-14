package org.demre.ei8razasperros.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertRaza(razaEntity: RazaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE )//
    suspend fun insertRaza(razaEntity: List<RazaEntity>)//para realizar el test.

    @Query("Select * from tabla_razas order by raza ASC")
    fun getRazas(): LiveData<List<RazaEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertDetallePerro(razaDetalleEntity: RazaDetalleEntity)

    @Query("Select * from tablaRazasDetalle where razaDetalle like :id")
    fun getRazaDetalle(id: String): LiveData<List<RazaDetalleEntity>>



}