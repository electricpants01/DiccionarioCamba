package com.locototeam.diccionariocamba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.locototeam.diccionariocamba.R
import com.locototeam.diccionariocamba.databinding.ItemKolodaBinding
import com.locototeam.diccionariocamba.model.DataSource
import com.locototeam.core.model.Dictionary

class ItemKolodaAdapter(private val context: Context, private val dataSource: List<Dictionary>) :
    BaseAdapter() {

    class ItemKolodaHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemKolodaBinding.bind(view)
        val dataSourceImages = DataSource().loadImages()

        fun render(current: Dictionary) {
            binding.shapeableImageView.setImageResource(dataSourceImages.random().imageResource)
            binding.txtTitle.text = current.word
            binding.txtDefinition.text = current.definition
        }
    }

    override fun getCount(): Int = dataSource.size

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val layoutInflater =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_koloda, parent, false)
        val holder = ItemKolodaHolder(layoutInflater)
        holder.render(dataSource[position])
        return layoutInflater
    }
}