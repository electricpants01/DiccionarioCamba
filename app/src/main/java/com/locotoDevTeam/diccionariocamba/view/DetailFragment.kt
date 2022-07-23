package com.locotoDevTeam.diccionariocamba.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.FragmentDetailBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary


class DetailFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var dictionary: Dictionary

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        binding = FragmentDetailBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData(){
        binding.txtTitle.text = dictionary.word
        binding.txtDescription.text = dictionary.definition
    }


}