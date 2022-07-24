package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Coordinates {
    @SerializedName("lon")
    private var lon: Float? = null

    @SerializedName("lat")
    private var lat: Float? = null

    fun getLon(): Float? {
        return lon
    }

    fun setLon(lon: Float?) {
        this.lon = lon
    }

    fun getLat(): Float? {
        return lat
    }

    fun setLat(lat: Float?) {
        this.lat = lat
    }
}