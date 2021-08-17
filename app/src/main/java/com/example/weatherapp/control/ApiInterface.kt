package com.example.weatherapp.control

import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("onecall")
    fun getExample(
        @Query("lat") lat: String,
        @Query("lon") lon: String?,
        @Query("exclude") exclude: String?,
        @Query("appid") appid: String?
    ): Call<Json4Kotlin_Base?>?



}