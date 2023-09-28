package com.example.coroutinewithmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutinewithmvvm.databinding.ItemLayoutBinding
import com.example.coroutinewithmvvm.model.JsonData

class RecyclerAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var data = mutableListOf<JsonData>()
    fun setData(data: List<JsonData>) {
        this.data = data.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = data[position]
        holder.binding.name.text = data.title.substring(0,10)
        Glide.with(holder.itemView.context).load(data.url).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}
class MainViewHolder(val binding:ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
}