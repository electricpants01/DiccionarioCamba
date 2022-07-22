package com.locotoDevTeam.diccionariocamba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.DictionaryItemBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary

class ItemDictionaryAdapter(private val context: Context, private val datasource: List<Dictionary>)
    : RecyclerView.Adapter<ItemDictionaryAdapter.DictionaryHolder>() {

    class DictionaryHolder(val view: View): RecyclerView.ViewHolder(view){
        val binding = DictionaryItemBinding.bind(view)

        fun render(dictionary: Dictionary){
            binding.txtTitle.text = dictionary.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.dictionary_item, parent, false)
        return DictionaryHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: DictionaryHolder, position: Int) {
        val item = datasource[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = datasource.size
}