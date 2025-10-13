package com.aaa.sharedelementtransitionsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aaa.sharedelementtransitionsample.databinding.FragmentImagesSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ImagesSheetDialogFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentImagesSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentImagesSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}