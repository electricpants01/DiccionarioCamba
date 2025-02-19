package com.locototeam.diccionariocamba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.locototeam.core.model.Dictionary
import com.locototeam.diccionariocamba.R
import com.locototeam.diccionariocamba.databinding.DictionaryItemBinding

class ItemDictionaryAdapter(
    private val listener: OnItemClickListener,
    private var datasource: List<Dictionary>
) : RecyclerView.Adapter<ItemDictionaryAdapter.DictionaryHolder>() {

    fun interface OnItemClickListener {
        fun onItemClick(item: Dictionary)
    }

    fun updateList(myDatasource: List<Dictionary>) {
        this.datasource = myDatasource
        notifyDataSetChanged()
    }

    class DictionaryHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val binding = DictionaryItemBinding.bind(view)

        fun render(dictionary: Dictionary) {
            binding.txtTitle.text = dictionary.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.dictionary_item, parent, false)
        return DictionaryHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: DictionaryHolder, position: Int) {
        val item = datasource[position]
        holder.render(item)
        holder.binding.root.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int = datasource.size
}