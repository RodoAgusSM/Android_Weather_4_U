package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

class Sys {
    @SerializedName("type")
    private var type: Int? = null

    @SerializedName("id")
    private var id: Int? = null

    @SerializedName("country")
    private var country: String? = null

    @SerializedName("sunrise")
    private var sunrise: Float? = null

    @SerializedName("sunset")
    private var sunset: Float? = null

    fun getType(): Int? {
        return type
    }

    fun setType(type: Int?) {
        this.type = type
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getSunrise(): Float? {
        return sunrise
    }

    fun setSunrise(sunrise: Float?) {
        this.sunrise = sunrise
    }

    fun getSunset(): Float? {
        return sunset
    }

    fun setSunset(sunset: Float?) {
        this.sunset = sunset
    }

    fun sunsetSunriseTime(whichOne: Boolean): String {
       val ret = if(whichOne) {
            val javaTimestamp = this.sunrise?.toLong()?.times(1000L)
            val date = javaTimestamp?.let { Date(it) }
            val dateTime: String = SimpleDateFormat("H:mm").format(date)
            dateTime;
        } else {
            val javaTimestamp = this.sunset?.toLong()?.times(1000L)
            val date = javaTimestamp?.let { Date(it) }
            val dateTime: String = SimpleDateFormat("H:mm").format(date)
            dateTime;
        }
        return ret;
    }
}