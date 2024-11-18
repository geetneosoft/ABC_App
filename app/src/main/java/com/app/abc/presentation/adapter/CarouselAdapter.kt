package com.app.abc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.abc.databinding.CarouselItemBinding
import com.app.abc.domain.model.Category

class CarouselAdapter : ListAdapter<Category, CarouselAdapter.ViewHolder>(DiffCalBack) {

    inner class ViewHolder(private val binding: CarouselItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Category) {
            with(binding.root){
                scaleType = ImageView.ScaleType.CENTER
                setBackgroundResource(data.imageRes)
            }
        }
    }

    object DiffCalBack : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return true
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).run { holder.bindData(this) }
    }
}