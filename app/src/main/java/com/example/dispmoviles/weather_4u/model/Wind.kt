package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName
import kotlin.math.truncate

class Wind {
    @SerializedName("speed")
    private var speed: Float = 0.0F

    @SerializedName("deg")
    private var deg: Float? = null

    @SerializedName("gust")
    private var gust: Float? = null

    fun getSpeed(): Float {
        return speed
    }

    fun setSpeed(speed: Float) {
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

    val directions =  arrayOf<String>(
    "N",
    "NNE",
    "NE",
    "ENE",
    "E",
    "ESE",
    "SE",
    "SSE",
    "S",
    "SSO",
    "SO",
    "OSO",
    "O",
    "ONO",
    "NO",
    "NNO",
    );

    private fun obtainCardinal(): Int? {
        return (this.getDeg()?.plus(11.25))?.div(22.5)?.toInt()
    }

    fun windDirection(): String {
       return this.directions[this.obtainCardinal()?.rem(16)!!]
    }

    fun windSpeed(): Int {
       return (truncate(this.speed)).times(3.6).toInt()
    }

}