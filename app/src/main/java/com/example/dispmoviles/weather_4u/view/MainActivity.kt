package com.example.dispmoviles.weather_4u.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dispmoviles.weather_4u.R
import com.example.dispmoviles.weather_4u.model.Forecast
import com.example.dispmoviles.weather_4u.model.Weather
import com.example.dispmoviles.weather_4u.routerInterface.IRouterHTTPRequest
import com.example.dispmoviles.weather_4u.routerInterface.RouterInstanceController
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    //private val url: String = getString(R.string.api_endpoint)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        getWeather()
    }

    private fun getWeather() {
        val router: IRouterHTTPRequest? = RouterInstanceController().getRetrofitInstance("https://api.openweathermap.org/data/2.5/")?.create(
            IRouterHTTPRequest::class.java
        )
        router?.getWeather("Montevideo", "Metric", "sp", "d4e98b5087ab0e565089d21ec367ff89")
            ?.enqueue(object : Callback<Forecast> {
                override fun onResponse(
                    call: Call<Forecast>,
                    response: Response<Forecast>
                ) {
                    if (response.isSuccessful) {
                        val forecast: Forecast? = response.body()
                        populateInterface(forecast)

                        println("SUCCESS FETCHING DATA $forecast")
                    } else {
                       println("SOMETHING HAPPENED")
                    }
                }

                override fun onFailure(call: Call<Forecast>, t: Throwable) {
                    println("SOMETHING FAILED " + t.message)
                    //changeToError(t.message)
                }
            })
    }

    private fun populateInterface(forecast: Forecast?){
        val temp: TextView = findViewById(R.id.temp)
        temp.setText(forecast?.getMain()?.getTemp().toString().split('.')[0] + " " + getResources().getStringArray(R.array.spanish).get(0))
        println("SUCCESS FETCHING DATA ${forecast?.getMain()?.getFeelsLike()}")
        val feelsLike: TextView = findViewById(R.id.feels_like)
        feelsLike.setText(getResources().getStringArray(R.array.spanish).get(1) + " " + forecast?.getMain()?.getFeelsLike().toString().split('.')[0] + getResources().getStringArray(R.array.spanish).get(0))
        val description: TextView = findViewById(R.id.description)
        description.setText(forecast?.getWeather()?.get(0)?.getDescription())
        val humiduty: TextView = findViewById(R.id.humidity)
        humiduty.setText(getResources().getStringArray(R.array.spanish).get(2) + " " + forecast?.getMain()?.getHumidity().toString().split('.')[0] + getResources().getStringArray(R.array.spanish).get(3))
        val pressure: TextView = findViewById(R.id.pressure)
        pressure.setText(getResources().getStringArray(R.array.spanish).get(4) + " " + forecast?.getMain()?.getPressure().toString().split('.')[0] + " " + getResources().getStringArray(R.array.spanish).get(5))
        val wind: TextView = findViewById(R.id.wind)
        wind.setText(getResources().getStringArray(R.array.spanish).get(6) + " " + forecast?.getWind()?.windDirection() + " " + forecast?.getWind()?.windSpeed() + " " + getResources().getStringArray(R.array.spanish).get(7))
    }
}