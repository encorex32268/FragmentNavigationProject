package com.lihan.fragmentnavigationproject.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.lihan.fragmentnavigationproject.R
import com.lihan.fragmentnavigationproject.data.User
import com.lihan.fragmentnavigationproject.databinding.FragmentUserBinding

class UserFragment  : Fragment(R.layout.fragment_user){

    private lateinit var binding : FragmentUserBinding

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            findNavController().navigate(
                UserFragmentDirections.actionUserFragmentToHomeFragment()
            )
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater)
        requireActivity().onBackPressedDispatcher.addCallback(callback)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            setFragmentResultListener("UserAdd"){ key , bundle->
                val result = bundle.getParcelable<User>("user")
                Log.d("TAG", "onViewCreated: ${result?.id}/${result?.name} ")
            }
            addUserButton.setOnClickListener {
                findNavController().navigate(
                    UserFragmentDirections.actionUserFragmentToAddFragment()
                )
            }
            toHomeButton.setOnClickListener {

            }


        }

    }





}