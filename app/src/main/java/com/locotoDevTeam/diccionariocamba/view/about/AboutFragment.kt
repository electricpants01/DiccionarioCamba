package com.locotoDevTeam.diccionariocamba.view.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment() {

    lateinit var aboutBinding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        aboutBinding = FragmentAboutBinding.bind(view)
        return aboutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // open url = https://docs.google.com/forms/d/e/1FAIpQLSez3UYkmU4nKYl5mx1vi6fHZmLhYs6iELgGXnzV2jDwSN7ksQ/viewform?usp=sf_link
        aboutBinding.formImageView.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/e/1FAIpQLSez3UYkmU4nKYl5mx1vi6fHZmLhYs6iELgGXnzV2jDwSN7ksQ/viewform?usp=sf_link"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

}