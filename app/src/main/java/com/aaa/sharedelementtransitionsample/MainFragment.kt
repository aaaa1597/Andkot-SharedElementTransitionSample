package com.aaa.sharedelementtransitionsample

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aaa.sharedelementtransitionsample.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* 共有要素トランジション設定 */
        sharedElementReturnTransition = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)

        binding.imageView1.setOnClickListener {
            val dialog = ImagesSheetDialogFragment()
            dialog.sharedElementReturnTransition = TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.move)
            dialog.showWithSharedElement(requireActivity().supportFragmentManager, binding.imageView1)
        }

        binding.imageView2.setOnClickListener {
            ImagesSheetDialogFragment().show(parentFragmentManager, "ImagesSheetDialogFragment")
        }

        binding.imageView3.setOnClickListener {
            ImagesSheetDialogFragment().show(parentFragmentManager, "ImagesSheetDialogFragment")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}