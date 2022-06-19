package com.example.spectacle.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spectacle.data.model.tvshow.TVShow
import com.example.spectacle.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<MyViewHolder>()   {

    private val tvShowList = ArrayList<TVShow>()

    fun setList(tvShow:List<TVShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(private val binding: ListItemBinding)
    : RecyclerView.ViewHolder(binding.root){

        fun bind(tvShow: TVShow){
            binding.titleTextView.text = tvShow.name
            binding.descriptionTextView.text = tvShow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
}