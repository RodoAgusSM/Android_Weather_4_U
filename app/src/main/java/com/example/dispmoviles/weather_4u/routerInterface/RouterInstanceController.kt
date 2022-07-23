package com.example.dispmoviles.weather_4u.routerInterface

import android.provider.Settings.Global.getString
import retrofit2.converter.gson.GsonConverterFactory
import com.example.dispmoviles.weather_4u.R
import retrofit2.Retrofit

class RouterInstanceController {
    private var retrofit: Retrofit? = null
    private val url: String = R.string.api_endpoint as String
    //private val string: String = getString(url)

    fun getRetrofitInstance(URL: String?): Retrofit? {
        //cambiar URL por BASE_URL
        if (retrofit == null || retrofit != null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}