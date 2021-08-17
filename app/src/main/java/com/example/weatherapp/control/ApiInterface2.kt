package control

import Json4Kotlin_Base2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface2 {
    @GET("weather")
    fun getExample(
        @Query("lat") lat: String,
        @Query("lon") lon: String?,
        @Query("units") units: String?,
        @Query("lang") lang: String?,
        @Query("appid") appid: String?
    ): Call<Json4Kotlin_Base2?>?

}