package com.example.weatherapp

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class DailyWeatherActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_weather)

        var adapter = DailyAdapter(this);
        var viewPager2: RecyclerView = findViewById(R.id.viewPager2)
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        viewPager2.layoutManager = layoutManager
        viewPager2.adapter = adapter
    }
}