package com.aaa.sharedelementtransitionsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aaa.sharedelementtransitionsample.databinding.FragmentABinding

class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            val existingFragment = parentFragmentManager.findFragmentByTag("MimicBottomSheetFragment")
            if (existingFragment != null) return@setOnClickListener
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.nav_up_enter_anim, R.anim.nav_up_exit_anim, R.anim.nav_up_pop_enter_anim, R.anim.nav_up_pop_exit_anim)
                .setReorderingAllowed(true)
                .add(R.id.fragment_container, MimicBottomSheetFragment::class.java, null, "MimicBottomSheetFragment")
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}