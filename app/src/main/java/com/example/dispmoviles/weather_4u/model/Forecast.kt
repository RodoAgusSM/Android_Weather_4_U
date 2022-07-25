package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Forecast {
    @SerializedName("coord")
    private var coord: Coordinates? = null

    @SerializedName("weather")
    private var weather: ArrayList<Weather>? = null

    @SerializedName("base")
    private var base: String? = null

    @SerializedName("main")
    private var main: Main? = null

    @SerializedName("visibility")
    private var visibility: Int? = null

    @SerializedName("wind")
    private var wind: Wind? = null

    @SerializedName("clouds")
    private var clouds: Clouds? = null

    @SerializedName("dt")
    private var dt: Float? = null

    @SerializedName("sys")
    private var sys: Sys? = null

    @SerializedName("timezone")
    private var timezone: Float? = null

    @SerializedName("id")
    private var id: Int? = null

    @SerializedName("name")
    private var name: String? = null

    @SerializedName("cod")
    private var cod: Int? = null

    fun getCoord(): Coordinates? {
        return coord
    }

    fun setCoord(coord: Coordinates) {
        this.coord = coord
    }

    fun getWeather(): ArrayList<Weather>? {
        return weather
    }

    fun setWeather(name: ArrayList<Weather>?) {
        this.weather = weather
    }

    fun getBase(): String? {
        return base
    }

    fun setBase(base: String?) {
        this.base = base
    }

    fun getMain(): Main? {
        return main
    }

    fun setMain(main: Main) {
        this.main = main
    }

    fun getVisibility(): Int? {
        return visibility
    }

    fun setVisibility(visibility: Int?) {
        this.visibility = visibility
    }

    fun getWind(): Wind? {
        return wind
    }

    fun setWind(wind: Wind?) {
        this.wind = wind
    }

    fun geClouds(): Clouds? {
        return clouds
    }

    fun setClouds(clouds: Clouds?) {
        this.clouds = clouds
    }

    fun geDt(): Float? {
        return dt
    }

    fun setDt(dt: Float?) {
        this.dt = dt
    }

    fun getSys(): Sys? {
        return sys
    }

    fun setSys(sys: Sys?) {
        this.sys = sys
    }

    fun getTimezone(): Float? {
        return timezone
    }

    fun setTimezone(timezone: Float?) {
        this.timezone = timezone
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getCod(): Int? {
        return cod
    }

    fun setCod(cod: Int?) {
        this.cod = cod
    }
}