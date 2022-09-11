package com.example.challange_chapter3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Huruf_adapter(val listHuruf : ArrayList<ListHuruf>) : RecyclerView.Adapter<Huruf_adapter.ViewHolder>() {
    var onClick : ((ListHuruf) -> Unit)? = null
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var huruf = view.findViewById<TextView>(R.id.txtHuruf)
        var cardView = view.findViewById<CardView>(R.id.cardViewId)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Huruf_adapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_huruf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Huruf_adapter.ViewHolder, position: Int) {
        holder.huruf.text = listHuruf[position].huruf
        holder.cardView.setOnClickListener{
            onClick?.invoke(listHuruf[position])
        }
    }

    override fun getItemCount(): Int {
        return listHuruf.size
    }
}