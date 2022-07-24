package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Wind {
    @SerializedName("speed")
    private var speed: Float? = null

    @SerializedName("deg")
    private var deg: Float? = null

    @SerializedName("gust")
    private var gust: Float? = null

    fun getSpeed(): Float? {
        return speed
    }

    fun setSpeed(speed: Float?) {
        this.speed = speed
    }

    fun getDeg(): Float? {
        return deg
    }

    fun setDeg(deg: Float?) {
        this.deg = deg
    }

    fun getGust(): Float? {
        return gust
    }

    fun setGust(gust: Float?) {
        this.gust = gust
    }
}