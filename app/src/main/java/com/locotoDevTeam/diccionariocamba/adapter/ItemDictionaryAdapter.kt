package com.locotoDevTeam.diccionariocamba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.DictionaryItemBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary

class ItemDictionaryAdapter(private val listener: OnItemClickListener, private var datasource: List<Dictionary>)
    : RecyclerView.Adapter<ItemDictionaryAdapter.DictionaryHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Dictionary)
    }

    fun updateList(myDatasource: List<Dictionary>) {
        this.datasource = listOf()
        this.datasource = myDatasource
        notifyDataSetChanged()
    }

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
        holder.binding.myCardView.setOnClickListener {
            print("chris se presiono")
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int = datasource.size
}