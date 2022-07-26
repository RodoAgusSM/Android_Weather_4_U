package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Coordinates(lat: Double, lon: Double) {

    init
    {
        this.setLat(lat)
        this.setLon(lon)
    }

    @SerializedName("lon")
    private var lon: Double? = null

    @SerializedName("lat")
    private var lat: Double? = null

    fun getLon(): Double? {
        return lon
    }

    fun setLon(lon: Double?) {
        this.lon = lon
    }

    fun getLat(): Double? {
        return lat
    }

    fun setLat(lat: Double?) {
        this.lat = lat
    }
}