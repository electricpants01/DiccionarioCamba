package com.locotoDevTeam.diccionariocamba.view.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentMainBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.util.SharedPrefs
import com.locotoDevTeam.diccionariocamba.view.DetailFragment

class MainFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener {

    lateinit var binding: FragmentMainBinding
//    val viewmodel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

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
        initDataSource()
    }

    private fun initDataSource() {
        // insert data first time
        val prefs = SharedPrefs(requireContext())
        val firstLoad = prefs.getBoolean(SharedPrefs.FIRST_LOAD)
        println("chris fristload $firstLoad")
    }

    private fun initSearchView(){
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
            binding.searchView.onActionViewExpanded()
        }
    }

    private fun initRecyclerView() {
        val adapter = ItemDictionaryAdapter(this, listOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(item: Dictionary) {
        val dialog = DetailFragment()
        dialog.dictionary = item
        dialog.show(childFragmentManager, "detailFragment")
    }

    private fun initSubscriptions(){

    }

}