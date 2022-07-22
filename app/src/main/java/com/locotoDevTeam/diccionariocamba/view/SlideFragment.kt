package com.locotoDevTeam.diccionariocamba.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemKolodaAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentSlideBinding
import com.locotoDevTeam.diccionariocamba.model.DataSource
import com.yalantis.library.Koloda


class SlideFragment : Fragment() {

    lateinit var sliderBinding: FragmentSlideBinding
    val dataSource = DataSource().loadImages()
    lateinit var recyclerView: RecyclerView
    lateinit var koloda: Koloda

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

    }

    private fun initRecycler(){
        val adapter = ItemKolodaAdapter(requireContext(), dataSource)
        koloda.adapter = adapter
    }
}