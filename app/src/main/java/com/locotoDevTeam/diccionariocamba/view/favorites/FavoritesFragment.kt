package com.locotoDevTeam.diccionariocamba.view.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentFavoritesBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.view.detail.DetailFragment

class FavoritesFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener {

    lateinit var binding: FragmentFavoritesBinding
    val viewmodel: FavoritesViewModel by viewModels()
    lateinit var adapter: ItemDictionaryAdapter

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
        viewmodel.getAllFavorites(requireContext())
        initRecyclerView()
        initSubscriptions()
    }

    private fun initRecyclerView(){
        adapter = ItemDictionaryAdapter(this@FavoritesFragment, listOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(item: Dictionary) {
        val dialog = DetailFragment()
        dialog.dictionary = item
        if (!dialog.isAdded) dialog.show(childFragmentManager, "detailFragment")

    }

    private fun initSubscriptions(){
        viewmodel.favoriteList.observe(viewLifecycleOwner) { favoriteList ->
            if(favoriteList.isEmpty()){
                binding.lottieFavorites.visibility = View.VISIBLE
                adapter.updateList(emptyList())
            }else{
                binding.lottieFavorites.visibility = View.GONE
                adapter.updateList(favoriteList)
            }
            adapter.notifyDataSetChanged()
        }
    }

}