package com.example.dispmoviles.weather_4u.model

import com.google.gson.annotations.SerializedName

class Forecast {
    @SerializedName("id")
    private var id: Int? = null

    @SerializedName("main")
    private var main: String? = null

    @SerializedName("description")
    private var description: String? = null

    @SerializedName("icon")
    private var icon: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getMain(): String? {
        return main
    }

    fun setMain(main: String?) {
        this.main = main
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(lat: String?) {
        this.description = description
    }

    fun getIcon(): String? {
        return icon
    }

    fun setIcon(icon: String?) {
        this.icon = icon
    }
}