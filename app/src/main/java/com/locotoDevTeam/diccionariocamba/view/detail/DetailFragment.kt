package com.locotoDevTeam.diccionariocamba.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.FragmentDetailBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : BottomSheetDialogFragment() {

    lateinit var dictionary: Dictionary
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel: DetailViewModel by activityViewModels()

    companion object {
        const val DICTIONARY_ID = "dictionaryId"

        fun newInstance(dictionaryId: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(DICTIONARY_ID to dictionaryId)
            }
        }
    }

    private val dictionaryId by lazy {
        requireArguments().getInt(DICTIONARY_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchDictionary(dictionaryId)
        //
        initData()
        initBottomSheetBehavior()
    }

    private fun initBottomSheetBehavior() {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    private fun initData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collectLatest { uiState ->
                uiState.dictionary?.let { dictionary ->
                    with(binding) {
                        txtTitle.text = dictionary.word
                        txtDescription.text = dictionary.definition
                        if (dictionary.isFavorite) {
                            ivFavorite.setImageResource(R.drawable.ic_baseline_star_24)
                            ivFavorite.setColorFilter(requireContext().resources.getColor(R.color.yellow_color))
                        } else {
                            ivFavorite.setImageResource(R.drawable.ic_baseline_star_border_24)
                            ivFavorite.setColorFilter(requireContext().resources.getColor(R.color.black))
                        }
                        ivFavorite.setOnClickListener {
                            viewModel.updateFavorites(dictionary.id, dictionary.isFavorite)
                        }
                    }
                }
            }
        }
    }
}