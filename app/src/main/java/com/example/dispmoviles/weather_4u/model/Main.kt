package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("temp")
    private var temp: Float? = null

    @SerializedName("feels_like")
    private var feelsLike: Float? = null

    @SerializedName("temp_main")
    private var tempMain: Float? = null

    @SerializedName("temp_max")
    private var tempMax: Float? = null

    @SerializedName("pressure")
    private var pressure: Float? = null

    @SerializedName("humidity")
    private var humidity: Float? = null

    fun getTemp(): Float? {
        return temp
    }

    fun setTemp(temp: Float?) {
        this.temp = temp
    }

    fun getFeelsLike(): Float? {
        return feelsLike
    }

    fun setFeelsLike(feelsLike: Float?) {
        this.feelsLike = feelsLike
    }

    fun getTempMain(): Float? {
        return tempMain
    }

    fun setTempMain(tempMain: Float?) {
        this.tempMain = tempMain
    }

    fun getTempMax(): Float? {
        return tempMax
    }

    fun setTempMax(tempMax: Float?) {
        this.tempMax = tempMax
    }

    fun getPressure(): Float? {
        return pressure
    }

    fun setPressure(pressure: Float?) {
        this.pressure = pressure
    }

    fun getHumidity(): Float? {
        return humidity
    }

    fun setHumidity(humidity: Float?) {
        this.humidity = humidity
    }
}