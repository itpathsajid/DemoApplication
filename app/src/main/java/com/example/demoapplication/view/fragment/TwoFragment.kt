package com.example.demoapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demoapplication.R
import com.example.demoapplication.databinding.FragmentTwoBinding
import com.google.android.play.core.internal.ac


class TwoFragment : Fragment() {

    private lateinit var mBinding : FragmentTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTwoBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.txtTwo.setOnClickListener {
            findNavController().navigate(TwoFragmentDirections.actionTwoFragmentToThreeFragment().apply { test = "Sajid" })
        }
    }
}