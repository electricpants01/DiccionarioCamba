package com.locotoDevTeam.diccionariocamba.view.detail

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.FragmentDetailBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary

interface DetailFragmentListener {
    fun onDetailFragmentDismissed()
}

class DetailFragment(private var detailListener: DetailFragmentListener) : BottomSheetDialogFragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var dictionary: Dictionary
    val viewModel: DetailViewModel by activityViewModels()


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
        initBottomSheetBehavior()
        initSubscriptions()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        detailListener.onDetailFragmentDismissed()
        println("chris 1")
    }

    private fun initBottomSheetBehavior(){
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        dialog?.let {
            val bottomSheet = it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    private fun initData(){
        binding.txtTitle.text = dictionary.word
        binding.txtDescription.text = dictionary.definition
        viewModel.isFavorite.postValue(dictionary.isFavorite)
        binding.ivFavorite.setOnClickListener {
            dictionary.isFavorite = !dictionary.isFavorite
            viewModel.updateFavorites(dictionary.id, dictionary.isFavorite, requireContext())
        }
    }

    private fun initSubscriptions(){
        viewModel.isFavorite.observe(viewLifecycleOwner){ isFavorite ->
            if(isFavorite) {
                binding.ivFavorite.setImageResource(R.drawable.ic_baseline_star_24)
                binding.ivFavorite.setColorFilter(requireContext().resources.getColor(R.color.yellow_color))
            }
            else {
                binding.ivFavorite.setImageResource(R.drawable.ic_baseline_star_border_24)
                binding.ivFavorite.setColorFilter(requireContext().resources.getColor(R.color.black))
            }
        }
    }


}