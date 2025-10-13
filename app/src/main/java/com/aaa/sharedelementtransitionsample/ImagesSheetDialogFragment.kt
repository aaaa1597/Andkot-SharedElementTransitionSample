package com.aaa.sharedelementtransitionsample

import android.app.Dialog
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aaa.sharedelementtransitionsample.databinding.FragmentImagesSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ImagesSheetDialogFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentImagesSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentImagesSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.let { window ->
            window.sharedElementEnterTransition =
                TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        }
    }

    fun showWithSharedElement(fragmentManager: androidx.fragment.app.FragmentManager,sharedView: View) {
        val transaction = fragmentManager.beginTransaction()
        transaction.addSharedElement(sharedView, sharedView.transitionName)
        transaction.addToBackStack(null)
        show(transaction, this::class.java.simpleName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}