package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Clouds {
    @SerializedName("all")
    private var all: Int? = null

    fun getAll(): Int? {
        return all
    }

    fun setAll(all: Int?) {
        this.all = all
    }
}