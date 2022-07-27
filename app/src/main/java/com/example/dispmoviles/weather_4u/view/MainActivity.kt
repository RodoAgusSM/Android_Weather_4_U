package com.example.dispmoviles.weather_4u.view

import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dispmoviles.weather_4u.R
import com.example.dispmoviles.weather_4u.model.City
import com.example.dispmoviles.weather_4u.model.Forecast
import com.example.dispmoviles.weather_4u.routerInterface.IRouterHTTPRequest
import com.example.dispmoviles.weather_4u.routerInterface.RouterInstanceController
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {
    val cityClass: City = City()
    val calendar = Calendar.getInstance()
    var city: String = "Montevideo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        handleLoading(true)
        getWeather();
        generateSpinner();
        fetchWeather();
    }

    private fun getWeather() {
        val weather_endpoint: String = getString(R.string.api_endpoint)
        val api_key: String = getString(R.string.api_key)
        val router: IRouterHTTPRequest? = RouterInstanceController().getRetrofitInstance(weather_endpoint)?.create(
            IRouterHTTPRequest::class.java
        )
        val coordinates = cityClass.getCityCoordinates(city)
        router?.getWeather(coordinates?.getLat(), coordinates?.getLon(), "Metric", "sp", api_key)
            ?.enqueue(object : Callback<Forecast> {
                override fun onResponse(
                    call: Call<Forecast>,
                    response: Response<Forecast>
                ) {
                    if (response.isSuccessful) {
                        val forecast: Forecast? = response.body()
                        getWeatherIcon(forecast)
                        populateInterface(forecast)
                    } else {
                       println("SOMETHING HAPPENED GET_WEATHER")
                    }
                    handleLoading(false)
                }

                override fun onFailure(call: Call<Forecast>, t: Throwable) {
                    handleLoading(false)
                    println("SOMETHING FAILED GET_WEATHER " + t.message)
                    //changeToError(t.message)
                }
            })
    }

    private fun getWeatherIcon(forecast: Forecast?) {
        val iconExtension = forecast?.getWeather()?.get(0)?.getIcon() + "@" + getString(R.string.icon_extension)
        val weather_icon_endpoint : String = getString(R.string.api_icon)
        val router: IRouterHTTPRequest? = RouterInstanceController().getRetrofitInstanceIcon(weather_icon_endpoint)?.create(
            IRouterHTTPRequest::class.java
        )
        router?.getWeatherIcon("application/json", iconExtension)
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    println("SUCCESS FETCHING DATA ICON ${response.body()}")
                    if (response.isSuccessful) {
                        val icon: ResponseBody? = response.body()
                        generateWeatherIcon(icon)
                    } else {
                        println("SOMETHING HAPPENED GET_WEATHER_ICON")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    println("SOMETHING FAILED GET_WEATHER_ICON" + t.message)
                }
            })
    }

     private fun generateSpinner() {
         val spinner = findViewById<Spinner>(R.id.city_spinner)
         val items = arrayOf(
             "Montevideo",
             "Punta del Este",
             "Rocha",
             "Colonia",
             "Canelones" ,
             "Salto",
             "Paysandú",
             "Tacuarembo",
             "Durazno",
             "Rivera",
             "Florida",
             "Cerro Largo",
             "Río Negro" ,
             "Soriano",
             "Flores",
             "Buenos Aires",
             "New York"
         )
         val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
         spinner.adapter = adapter
         spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
             override fun onNothingSelected(parent: AdapterView<*>?) {}
             override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item: Any = spinner.selectedItem
                 city = item as String
                 getWeather()
             }
         }
     }


    private fun generateWeatherIcon(icon: ResponseBody?) {
        val weather_icon: ImageView = findViewById(R.id.weather_icon)
        val iconBytes = icon?.bytes()
        val bitmap = iconBytes?.let { BitmapFactory.decodeByteArray(iconBytes, 0, it.size) }
        weather_icon.setImageBitmap(bitmap)
    }

    private fun fetchWeather() {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                getWeather()
            }
        }, 0, 1200000)
    }

    private fun populateInterface(forecast: Forecast?){
        val location: TextView = findViewById(R.id.city)
        location.setText(getResources().getStringArray(R.array.spanish).get(10) + " " + city)
        val temp: TextView = findViewById(R.id.temp)
        temp.setText(forecast?.getMain()?.getTemp().toString().split('.')[0] + " " + getResources().getStringArray(R.array.spanish).get(0))
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
        val dateTime: Date = Date()
        calendar.time = dateTime
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
        var castedMin: String?
        if(minutes < 10) castedMin = "0" + minutes.toString()
        else castedMin = minutes.toString()
        val day = calendar.get(Calendar.DATE)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val parsedTime = "$hours:$castedMin"
        val time: TextView = findViewById(R.id.time)
        time.setText(getResources().getStringArray(R.array.spanish).get(8) + " " + parsedTime)
        val parsedDate = "$day/$month/$year"
        val date: TextView = findViewById(R.id.date)
        date.setText(getResources().getStringArray(R.array.spanish).get(9) + " " + parsedDate)
    }

    private fun handleLoading(isLoading: Boolean) {
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        val data_container: LinearLayout = findViewById(R.id.data_container)
        if(isLoading) {
            progressBar.setVisibility(View.VISIBLE)
            data_container.setVisibility(View.GONE)
        }
        else{
            progressBar.setVisibility(View.GONE)
            data_container.setVisibility(View.VISIBLE)
        }
    }
}