package com.example.weatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class DailyAdapter(
    private val context: Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<DailyAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var text1: TextView
        var text2: TextView
        var text3: TextView
        var lottie: LottieAnimationView
        init {
            view.setOnClickListener(this)
            text1 = view.findViewById(R.id.text_lottie)
            text2 = view.findViewById(R.id.text2_lottie)
            text3 = view.findViewById(R.id.text3_lottie)
            lottie = view.findViewById(R.id.lottie_daily)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            listener.onItemClick()
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.daily_itens, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text = "1"
        holder.text2.text = "2"
        holder.text2.text = "3"
        holder.lottie.setAnimation(R.raw.sunny);
        holder.lottie.playAnimation()
    }

    override fun getItemCount(): Int {
        return 7
    }
}