package com.locotoDevTeam.diccionariocamba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.ItemKolodaBinding
import com.locotoDevTeam.diccionariocamba.model.ImageSC

class ItemKolodaAdapter(private val context: Context, private val dataSource: List<ImageSC>)
    : BaseAdapter(){

//    class ItemKolodaHolder(private val view: View): RecyclerView.ViewHolder(view) {
//        val binding = ItemKolodaBinding.bind(view)
//
//        fun render(imageSC: ImageSC, word: String, definition: String) {
//            binding.shapeableImageView.setImageResource(imageSC.imageResource)
//        }
//    }

    override fun getCount(): Int = dataSource.size

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(parent!!.context).inflate(R.layout.item_koloda, parent, false)
        return layoutInflater
    }
}