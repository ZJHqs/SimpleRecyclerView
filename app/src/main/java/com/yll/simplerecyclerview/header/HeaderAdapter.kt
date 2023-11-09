package com.yll.simplerecyclerview.header

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yll.simplerecyclerview.R

class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var flowerCount: Int = 0

    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val flowerNumberTextView: TextView = view.findViewById(R.id.flower_number_text)

        fun bind(flowerCount: Int) {
            flowerNumberTextView.text = flowerCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header, parent, false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(flowerCount)
    }

    fun updateFlowerCount(updateFlowerCount: Int) {
        flowerCount = updateFlowerCount
        notifyItemChanged(0)
    }
}