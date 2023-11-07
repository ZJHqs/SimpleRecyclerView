package com.yll.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yll.simplerecyclerview.data.Flower

class FlowerAdapter(private val onClickListener: (flower: Flower) -> Unit):
    ListAdapter<Flower, FlowerAdapter.FlowerViewHolder>(FlowerDiffCallback) {

    class FlowerViewHolder(itemView: View, val onClickListener: (flower: Flower) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val flowerImageView: ImageView = itemView.findViewById(R.id.flower_image)
        private val flowerTextView: TextView = itemView.findViewById(R.id.flower_text)
        private var currentFlower: Flower? = null

        init {
            itemView.setOnClickListener {
                currentFlower?.let {
                    onClickListener(it)
                }
            }
        }

        fun bind(flower: Flower) {
            currentFlower = flower
            flowerTextView.text = flower.name
            flowerImageView.setImageResource(flower.image)
        }
    }


    object FlowerDiffCallback: androidx.recyclerview.widget.DiffUtil.ItemCallback<Flower>() {
        override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flower_item, parent, false)
        return FlowerViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}