package com.locototeam.diccionariocamba.view.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.locototeam.core.model.Dictionary
import com.locototeam.diccionariocamba.R
import com.locototeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locototeam.diccionariocamba.databinding.FragmentFavoritesBinding
import com.locototeam.diccionariocamba.view.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener{

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
        initRecyclerView()
        initSubscriptions()
    }

    private fun initRecyclerView() {
        adapter = ItemDictionaryAdapter(this@FavoritesFragment, listOf())
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(item: Dictionary) {
        val dialog = DetailFragment.newInstance(item.id)
        if (!dialog.isAdded) dialog.show(childFragmentManager, "detailFragment")

    }

    private fun initSubscriptions() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewmodel.uiState.collectLatest { uiState ->

                if (uiState.favoriteList.isEmpty()) {
                    binding.lottieFavorites.visibility = View.VISIBLE
                    adapter.updateList(emptyList())
                } else {
                    binding.lottieFavorites.visibility = View.GONE
                    adapter.updateList(uiState.favoriteList)
                }
            }
        }
    }

}