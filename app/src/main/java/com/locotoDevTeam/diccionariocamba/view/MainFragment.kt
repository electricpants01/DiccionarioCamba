package com.locotoDevTeam.diccionariocamba.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentMainBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    val dataSource = listOf<Dictionary>(
        Dictionary(1,"acopaibau", "que sos tonto"),
        Dictionary(2, "chamare", "lugar muy muy lejano")
    )

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
    }

    private fun initSearchView(){
        binding.searchView.setOnClickListener {
            println("chris: hola")
            binding.searchView.requestFocus()
        }
    }

    private fun initRecyclerView() {
        val adapter = ItemDictionaryAdapter(requireContext(), dataSource)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

}