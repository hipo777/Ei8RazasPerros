package org.demre.ei8razasperros.data

import org.junit.Assert.*

import org.junit.Test
class MapperRazaDetalleTest {
    @Test
    fun toEntity() {
        //Given, Dado este valor

        val url = "datoUrl"
        val id = "datoId"

        // When, hago esto

        val resultadoDeTransformacion = url.toEntity(id)

        // Then, espero este resultado

        assertEquals(id, resultadoDeTransformacion.razaDetalle)
        assertEquals(url, resultadoDeTransformacion.url)
    }
}