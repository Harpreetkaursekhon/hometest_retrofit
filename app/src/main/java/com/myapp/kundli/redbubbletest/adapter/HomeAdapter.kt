package com.myapp.kundli.redbubbletest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapp.kundli.redbubbletest.R
import com.myapp.kundli.redbubbletest.model.Home
import java.util.ArrayList

class HomeAdapter(private val context: Context,private var homelist:List<Home.AvailableProducts> ): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    return HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val home=homelist[position]
        holder.id.text=home.id
        holder.title.text=home.title
        holder.amount.text=home.price.toString()
        Glide.with(context)
            .load(home.thumbnailUrl)
            .into(holder.image)
    }
    override fun getItemCount(): Int = homelist.size

    fun setData(arrayList: List<Home.AvailableProducts>) {
        this.homelist=arrayList
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id:TextView=itemView.findViewById(R.id.tv_id)
        val title:TextView=itemView.findViewById(R.id.tv_title)
        val amount:TextView=itemView.findViewById(R.id.tv_amount)
        val image:ImageView=itemView.findViewById(R.id.iv_image)

    }
}