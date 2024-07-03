package com.locotoDevTeam.diccionariocamba.view.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentMainBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.view.detail.DetailFragment
import com.locotoDevTeam.diccionariocamba.view.detail.DetailFragmentListener


class MainFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener, DetailFragmentListener {

    lateinit var binding: FragmentMainBinding
    private val viewmodel: MainFragmentViewModel by activityViewModels()
    lateinit var adapter: ItemDictionaryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSearchView()
        initSubscriptions()
        //
        viewmodel.getAllDictionaries()
    }

    private fun initSearchView(){
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
            binding.searchView.onActionViewExpanded()
        }
        
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewmodel.searchInDictionary(newText!!)
                return false
            }
        })
    }

    private fun initRecyclerView() {
        adapter = ItemDictionaryAdapter(this, listOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    override fun onDetailFragmentDismissed() {
        print("do something when detail fragment is dismissed")
    }

    override fun onItemClick(item: Dictionary) {
        val dialog = DetailFragment(this@MainFragment)
        dialog.dictionary = item
        dialog.show(childFragmentManager, "detailFragment")
    }

    private fun initSubscriptions(){

        viewmodel.dictionaryList.observe(viewLifecycleOwner) {
            adapter.updateList(it)
            adapter.notifyDataSetChanged()
        }
    }

}