package com.example.homework

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("/demos/marvel/")
    fun get(@Query("limit")limit:Int):Call<List<Marvel>>

}