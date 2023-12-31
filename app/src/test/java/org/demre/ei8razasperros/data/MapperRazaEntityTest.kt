package org.demre.ei8razasperros.data

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MapperRazaEntityTest {

    @Test
    fun toRazaEntity() {

        //Given, Dado este valor

        val raza = "esUnaRaza"

        // When, hago esto

        val resultadoDeTransformacion = raza.toRazaEntity()

        // Then, espero este resultado

        //assertEquals(raza, resultadoDeTransformacion.raza)//el de abajo es otra alternativa mejor.
        assertThat(resultadoDeTransformacion.raza).isEqualTo(raza)

    }
}