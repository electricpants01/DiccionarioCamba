package com.locotoDevTeam.diccionariocamba.view.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentMainBinding
import com.locotoDevTeam.diccionariocamba.model.DataSource
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.util.SharedPrefs
import com.locotoDevTeam.diccionariocamba.view.detail.DetailFragment

class MainFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener {

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
        initDataSource()
        initSearchView()
        initSubscriptions()
        //
        viewmodel.getAllDictionaries(requireContext())
    }

    private fun initDataSource() {
        // insert data first time
        val prefs = SharedPrefs(requireContext())
        val firstLoad = prefs.getBoolean(SharedPrefs.FIRST_LOAD)
        println("first load es ${firstLoad}")
        if(!firstLoad) { // First load has not been done yet
            println("chris entro")
            val dataSource = DataSource().loadDatabaseFirstTime()
            viewmodel.insertDictionary(dataSource, requireContext())
            prefs.saveBoolean(SharedPrefs.FIRST_LOAD, true)
        }
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
                viewmodel.searchInDictionary(newText!!, requireContext())
                return false
            }
        })
    }

    private fun initRecyclerView() {
        adapter = ItemDictionaryAdapter(this, listOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(item: Dictionary) {
        val dialog = DetailFragment()
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