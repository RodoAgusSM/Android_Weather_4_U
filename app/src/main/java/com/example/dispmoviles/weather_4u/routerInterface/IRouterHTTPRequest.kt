package com.example.dispmoviles.weather_4u.routerInterface

import com.example.dispmoviles.weather_4u.model.Forecast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/*private val key: String = getString(R.string.api_key)

fun getString(apiEndpoint: Any): String {
    return apiEndpoint as String;
}*/

interface IRouterHTTPRequest {
    @GET("weather")
    fun getWeather(
        @Query("q") city: String?,  @Query("units") metric: String?, @Query("lang") language: String?, @Query("APPID") key: String?
    ): Call<Forecast>?

    @GET("{iconPath}")
    fun getWeatherIcon(@Header("Content-Type") cType: String?, @Path(value = "iconPath", encoded = true) iconPath: String): Call<ResponseBody>?
}