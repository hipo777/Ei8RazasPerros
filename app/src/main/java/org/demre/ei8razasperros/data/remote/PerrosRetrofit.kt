package org.demre.ei8razasperros.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PerrosRetrofit {

    companion object{

        private const val BASE_URL = "https://dog.ceo/api/"

        fun gesRetroFitAves(): PerrosApi{

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(PerrosApi::class.java)
        }
    }
}