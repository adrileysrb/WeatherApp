package com.example.weatherapp


import Daily
import Json4Kotlin_Base
import Json4Kotlin_Base2
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.control.ApiClient
import com.example.weatherapp.control.ApiInterface
import control.ApiInterface2
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

// SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunsise*1000))
class MainActivity : AppCompatActivity() {
    var days:List<Daily> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
        findViewById<RelativeLayout>(R.id.mainContainer).visibility= View.VISIBLE
        getData()
    }

    fun getData() {
        var lat: String = "-17.4644"
        var lon: String = "-48.2035"
        var exclude: String = "minutely,hourly"
        var appid: String = "cfcbc8661ec503e9e5080ce6c21a14ea"
        var BASE_URL: String = "https://api.openweathermap.org/data/2.5/";
        val retrofitClient = ApiClient
            .getRetrofitInstance(BASE_URL)

        val endpoint = retrofitClient.create(ApiInterface::class.java)
        val callback = endpoint.getExample(lat, lon, exclude, appid)

        callback!!.enqueue(object : Callback<Json4Kotlin_Base?> {
            override fun onResponse(
                call: Call<Json4Kotlin_Base?>,
                response: Response<Json4Kotlin_Base?>
            ) {
                if (response.isSuccessful && response.body()?.daily != null) {
                    days = response.body()!!.daily

                }

            }
            override fun onFailure(call: Call<Json4Kotlin_Base?>, t: Throwable) {}
        })
    }
    fun getData2() {
        var lat:String = "-17.4644"
        var lon:String = "-48.2035"
        var units = "metric"
        var lang = "pt"
        var appid:String = "cfcbc8661ec503e9e5080ce6c21a14ea"
        var BASE_URL: String = "https://api.openweathermap.org/data/2.5/";
        val retrofitClient = ApiClient
            .getRetrofitInstance(BASE_URL)

        val endpoint = retrofitClient.create(ApiInterface2::class.java)
        val callback = endpoint.getExample(lat, lon, units, lang, appid)

        callback!!.enqueue(object : Callback<Json4Kotlin_Base2?> {
            override fun onResponse(call: Call<Json4Kotlin_Base2?>, response: Response<Json4Kotlin_Base2?>) {
                if(response.isSuccessful && response.body()?.wind != null){


                }

            }

            override fun onFailure(call: Call<Json4Kotlin_Base2?>, t: Throwable) {

            }

        })}
/*
*  try {
                findViewById<TextView>(R.id.temp).text = result!!.get(1).feels_like.toString()
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.mainContainer).visibility= View.VISIBLE
            } catch (e: java.lang.Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
* */


}