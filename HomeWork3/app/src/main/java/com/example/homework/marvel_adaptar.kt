package com.example.homework

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class marvel_adaptar(private val list: List<Marvel>) :
    RecyclerView.Adapter<marvel_adaptar.marvel_ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): marvel_adaptar.marvel_ViewHolder {
        return marvel_ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: marvel_ViewHolder, position: Int) {
        val item = list[position]
        holder.name.text=item.name
        holder.bio.text = item.bio
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class marvel_ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val name:TextView=itemView.findViewById(R.id.textView_name)
        val  bio:TextView = itemView.findViewById(R.id.textView_bio)

    }
}
