package com.example.grid

import ListData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adpater(var users: List<ListData>) : RecyclerView.Adapter<Adpater.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img:ImageView = itemView.findViewById<ImageView>(R.id.image_view)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = users[position]
      //  holder.img.text = currentItem.download_url
        Glide.with(holder.itemView.context)
            .load(currentItem.download_url)
            .into(holder.img)



    }

    override fun getItemCount(): Int {
        return users.size
    }

//    fun updateList(users: String){
//        this.users =  users.toMutableList()
//        users.addall
//        notifyDataSetChanged()
    //}
}