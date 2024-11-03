package com.example.layoutmanager

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(private val colorList: List<Int>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colorList[position]
        holder.colorLayout.setBackgroundColor(color)
        holder.colorHex.text = String.format("#%06X", (0xFFFFFF and color))
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorLayout: FrameLayout = itemView.findViewById(R.id.color_layout)
        val colorHex: TextView = itemView.findViewById(R.id.color_hex)
    }
}
