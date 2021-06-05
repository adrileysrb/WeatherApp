package com.example.weatherapp


import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var units: String
    lateinit var lang: String
     var LAT: String = "-17.4644"
     var LONG: String = "-48.2035"
    var choose: String = "location"
    val CITY: String = "brasilia,br"
    val API: String = "cfcbc8661ec503e9e5080ce6c21a14ea"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LAT = intent.getStringExtra("Adriley").toString()
        LONG = intent.getStringExtra("Samuel").toString()
        Log.i("Sr", LAT)
        Log.i("Sr", LONG)
        weatherTask().execute()
    }




    inner class weatherTask() : AsyncTask<String, Void, String>(){

        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }
        override fun doInBackground(vararg params: String?): String? {
            Log.i("Adriley", "doInBackground")
            var response:String?
            units = "metric"
            lang = "pt"
            //query by city https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=$units&lang=$lang&appid=$API
            //query by latitude and longitude https://api.openweathermap.org/data/2.5/weather?lat=$LAT&lon=$LONG&units=$units&lang=$lang&appid=$API
            try{
                response = URL(if(choose =="city") "https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=$units&lang=$lang&appid=$API"
                else "https://api.openweathermap.org/data/2.5/weather?lat=$LAT&lon=$LONG&units=$units&lang=$lang&appid=$API" ) //units=imperial
                        .readText(Charsets.UTF_8)
            }
            catch (e: Exception){
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try{
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                val updateAT:Long = jsonObj.getLong("dt")
                val updatedAtText = "Updated at: "+SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(updateAT*1000))
                val temp = main.getString("temp").substringBefore(".") + if(units == "metric") "ºC" else "ºF"

                val tempMin = "Min Temp: "+main.getString("temp_min").substringBefore(".") + if(units == "metric") "ºC" else "ºF"
                val tempMax = "Max Temp: "+main.getString("temp_max").substringBefore(".") + if(units == "metric") "ºC" else "ºF"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")
                val sunsise:Long = sys.getLong("sunrise")
                val sunset:Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")
                val weatherDscription = weather.getString("description").capitalize()
                val address = jsonObj.getString("name")+", "+sys.getString("country")

                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.updated_at).text = updatedAtText
                findViewById<TextView>(R.id.status).text = weatherDscription
                findViewById<TextView>(R.id.temp).text = temp
                findViewById<TextView>(R.id.temp_min).text = tempMin
                findViewById<TextView>(R.id.temp_max).text = tempMax
                findViewById<TextView>(R.id.sunrise).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunsise*1000))
                findViewById<TextView>(R.id.sunset).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
                findViewById<TextView>(R.id.wind).text = windSpeed
                findViewById<TextView>(R.id.pressure).text = pressure
                findViewById<TextView>(R.id.humidity).text = humidity

                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.mainContainer).visibility= View.VISIBLE
            }
            catch (e: java.lang.Exception){
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
        }
    }
}