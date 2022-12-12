package com.lihan.fragmentnavigationproject.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.lihan.fragmentnavigationproject.R
import com.lihan.fragmentnavigationproject.data.User
import com.lihan.fragmentnavigationproject.databinding.FragmentAddBinding

class AddFragment  : Fragment(R.layout.fragment_add){

    private lateinit var binding : FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            addNewButton.setOnClickListener {
                val time = System.currentTimeMillis()
                val user = User(
                    time,
                    "FromAdd $time"
                )
                setFragmentResult(
                    requestKey = "UserAdd",
                    result = Bundle().apply {
                        putParcelable("user",user)
                    }
                )
                Log.d("TAG", "onViewCreated: add fragment  ")
                findNavController().navigate(
                    AddFragmentDirections.actionAddFragmentToUserFragment3()
                )






            }


        }
    }



}