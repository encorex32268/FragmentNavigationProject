package com.lihan.fragmentnavigationproject.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lihan.fragmentnavigationproject.R
import com.lihan.fragmentnavigationproject.databinding.FragmentHomeBinding

class HomeFragment  : Fragment(R.layout.fragment_home){

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            showUserListButton.setOnClickListener {
                Log.d("TAG", "onViewCreated: ")
            }

            toUserPageButton.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToUserFragment()
                )
            }
            toAddButton.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToAddFragment2()
                )
            }
        }
    }

}