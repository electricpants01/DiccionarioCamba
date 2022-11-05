package com.locotoDevTeam.diccionariocamba.view.slide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemKolodaAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentSlideBinding
import com.locotoDevTeam.diccionariocamba.model.DataSource


class SlideFragment : Fragment() {

    lateinit var sliderBinding: FragmentSlideBinding
    val viewmodel: SlideViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_slide, container, false)
        sliderBinding = FragmentSlideBinding.bind(view)
        return sliderBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        viewmodel.getAllDictionaries(requireContext())
        initSubscribers()
    }

    private fun initRecycler(){
        val adapter = ItemKolodaAdapter(requireContext(), emptyList())
        sliderBinding.koloda.adapter = adapter
    }

    private fun initSubscribers(){
        viewmodel.dictionaryList.observe(viewLifecycleOwner) { dictionaries ->
            println("chris trajiste ${dictionaries.size} diccionarios")
            val adapter = ItemKolodaAdapter(requireContext(), dictionaries.shuffled())
            sliderBinding.koloda.adapter = adapter
        }
    }
}