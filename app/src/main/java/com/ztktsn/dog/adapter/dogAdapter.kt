package com.ztktsn.dog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ztktsn.dog.R
import com.ztktsn.dog.dog

class DogAdapter : ListAdapter<dog, DogAdapter.DogViewHolder>(DogBreedDiffCallback) {

    object DogBreedDiffCallback : DiffUtil.ItemCallback<dog>() {
        override fun areItemsTheSame(oldItem: dog, newItem: dog): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: dog, newItem: dog): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogBreed = getItem(position)
        holder.bind(dogBreed)
    }

    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dogNameTextView: TextView = itemView.findViewById(R.id.dogName)
        private val barkingTextView: TextView = itemView.findViewById(R.id.barking)
        private val sheddingTextView: TextView = itemView.findViewById(R.id.shedding)
        private val energyTextView: TextView = itemView.findViewById(R.id.energy)
        private val lifeExpectancyTextView: TextView = itemView.findViewById(R.id.lifeExpectancy)
        private val dogImageView: ImageView = itemView.findViewById(R.id.dogImage)

        fun bind(dogBreed: dog) {
            dogNameTextView.text = dogBreed.name
            barkingTextView.text = "Barking : ${dogBreed.barking}"
            sheddingTextView.text = "Shedding: ${dogBreed.shedding}"
            energyTextView.text = "Energy: ${dogBreed.energy}"
            lifeExpectancyTextView.text = "Life Expectancy: ${dogBreed.minLifeExpectancy}-${dogBreed.maxLifeExpectancy} years"

            Glide.with(dogImageView.context)
                .load(dogBreed.imageLink)
                .into(dogImageView)
        }
    }
}