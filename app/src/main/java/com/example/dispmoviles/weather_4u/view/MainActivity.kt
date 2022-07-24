package com.example.dispmoviles.weather_4u.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.example.dispmoviles.weather_4u.R
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
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                       /* val rt: RatingBar = findViewById(R.id.rating)
                        rt.rating = response.body().getStars()
                        val et: EditText = findViewById(R.id.et_evaluate_more_info)
                        et.setText(response.body().getDescription())*/
                        println("SUCCESS FETCHING DATA " + response.body()?.string())
                    } else {
                       println("SOMETHING HAPPENED")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    println("SOMETHING FAILED")
                    println(t.message)
                    //changeToError(t.message)
                }
            })
    }
}