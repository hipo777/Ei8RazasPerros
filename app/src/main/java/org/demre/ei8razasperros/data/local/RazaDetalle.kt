package org.demre.ei8razasperros.data.local

import androidx.room.Entity

@Entity(tableName = "tablaRazasDetalle", primaryKeys = ["razaDetalle","url"])
data class RazaDetalleEntity(
    val razaDetalle:String,
    val url: String
)