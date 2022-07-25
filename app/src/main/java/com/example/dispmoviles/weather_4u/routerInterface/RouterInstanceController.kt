package com.example.dispmoviles.weather_4u.routerInterface

import android.provider.Settings.Global.getString
import retrofit2.converter.gson.GsonConverterFactory
import com.example.dispmoviles.weather_4u.R
import retrofit2.Retrofit

class RouterInstanceController() {
    private var retrofit: Retrofit? = null
    private var retrofitIcon: Retrofit? = null
    fun getRetrofitInstance(URL: String?): Retrofit? {
        if (retrofit == null || retrofit != null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    fun getRetrofitInstanceIcon(URL: String?): Retrofit? {
        if (retrofitIcon == null || retrofitIcon != null) {
            retrofitIcon = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitIcon
    }
}