package com.example.grid

import ListData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/list?page=34")
    fun getUser(): Call<ListData>
}