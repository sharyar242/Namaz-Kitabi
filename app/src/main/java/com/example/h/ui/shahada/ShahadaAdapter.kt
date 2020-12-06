package com.example.h.ui.shahada

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.h.R
import com.example.h.data.model.Articles
import kotlinx.android.synthetic.main.item_article.view.*

class ShahadaAdapter: RecyclerView.Adapter<ShahadaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        fun populateModels(article : Articles){
           //
        }
    }

    private var list : List<Articles> = listOf()

        set(value) {
            field= value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view  =LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModels(list[position])
    }

    override fun getItemCount(): Int = list.size

}