package com.locototeam.diccionariocamba.view.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.locototeam.diccionariocamba.R
import com.locototeam.diccionariocamba.databinding.FragmentAboutBinding
import com.locototeam.diccionariocamba.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment() {

    private val binding by viewBinding(FragmentAboutBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // open url = https://docs.google.com/forms/d/e/1FAIpQLSez3UYkmU4nKYl5mx1vi6fHZmLhYs6iELgGXnzV2jDwSN7ksQ/viewform?usp=sf_link
        binding.formImageView.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/e/1FAIpQLSez3UYkmU4nKYl5mx1vi6fHZmLhYs6iELgGXnzV2jDwSN7ksQ/viewform?usp=sf_link"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

}