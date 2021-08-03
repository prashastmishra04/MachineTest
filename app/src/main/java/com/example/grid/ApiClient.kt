package com.example.grid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    val Base_url :String ="https://picsum.photos/"
    var retrofit: Retrofit? = null
    private var mInstance: ApiClient? = null


    fun getApiClient(): Retrofit? {

        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }

    @Synchronized
    fun getInstance(): ApiClient? {
        if (mInstance == null) {
            mInstance = ApiClient()
        }
        return mInstance
    }

    fun getApi(): ApiInterface? {
        return retrofit!!.create(ApiInterface::class.java)
    }
}
//https://picsum.photos/v2/list?page=34