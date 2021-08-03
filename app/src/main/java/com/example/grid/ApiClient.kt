package com.example.grid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    val Base_url :String ="https://picsum.photos/v2/"
    var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {

        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}
//