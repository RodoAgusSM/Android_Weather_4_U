package com.example.dispmoviles.weather_4u.routerInterface

import android.provider.Settings.Secure.getString
import com.example.dispmoviles.weather_4u.R
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/*private val key: String = getString(R.string.api_key)

fun getString(apiEndpoint: Any): String {
    return apiEndpoint as String;
}*/

interface IRouterHTTPRequest {
    @GET("weather")
    fun getWeather(
    @Query("q") city: String?,  @Query("units") metric: String?, @Query("lang") language: String?, @Query("APPID") key: String?
    ): Call<JSONObject>?
}