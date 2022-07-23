package com.locotoDevTeam.diccionariocamba.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentFavoritesBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary

class FavoritesFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener {

    lateinit var binding: FragmentFavoritesBinding
    val dataSource = listOf<Dictionary>(
        Dictionary(1,"acopaibau", "que sos tonto"),
        Dictionary(2, "chamare", "lugar muy muy lejano")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        binding = FragmentFavoritesBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val adpater = ItemDictionaryAdapter(this@FavoritesFragment, dataSource)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adpater
    }

    override fun onItemClick(item: Dictionary) {
        println("chris: ${item.word}")
        val dialog = DetailFragment()
        dialog.dictionary = item
        dialog.show(childFragmentManager, "detailFragment")
    }

}