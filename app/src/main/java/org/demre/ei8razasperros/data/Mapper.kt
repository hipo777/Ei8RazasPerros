package org.demre.ei8razasperros.data

import org.demre.ei8razasperros.data.local.RazaDetalleEntity
import org.demre.ei8razasperros.data.local.RazaEntity

fun String.toEntity(id: String): RazaDetalleEntity = RazaDetalleEntity(id, this) //función de extensión

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)

