package org.demre.ei8razasperros.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PerrosApi {

    @GET("breeds/list/all")
    suspend fun getDataPerros(): Response<RazaPerros>

    @GET("breed/{id}/images")
    suspend fun getDetallePerro(@Path("id") id: String): Response<PerroDetalle>


}