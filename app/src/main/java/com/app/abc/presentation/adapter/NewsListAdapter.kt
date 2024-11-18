package com.app.abc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.app.abc.R
import com.app.abc.data.model.Article
import com.app.abc.databinding.NewsListItemBinding
import com.app.abc.util.Constants
import com.app.abc.util.convertDateOneFormatToAnother

class NewsListAdapter : ListAdapter<Article,NewsListAdapter.NewsViewHolder>(DiffCallback) {

    object DiffCallback : ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title==newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }


    }

    class NewsViewHolder(private val binding: NewsListItemBinding) : ViewHolder(binding.root){

        fun bind(data : Article){
            with(binding){
                loadImage(imageView =  newsImage, url = data.urlToImage ?: data.url)
                newsTitle.text = data.title
                newsDate.text = data.publishedAt.convertDateOneFormatToAnother(Constants.DATE_PATTERN1,
                    Constants.DATE_PATTERN2)?:"NAN"
            }
        }

        private fun loadImage(imageView: ImageView,url:String?) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(url)
                .centerCrop()
                .error(R.drawable.baseline_no_encryption_gmailerrorred_24)
                .placeholder(R.drawable.baseline_no_encryption_gmailerrorred_24)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}