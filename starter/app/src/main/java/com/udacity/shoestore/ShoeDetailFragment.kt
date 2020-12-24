package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail,
            container,
            false)

        //use requiredActivity() to create activity level viewModel
        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.shoeViewModel = shoeViewModel
        binding.shoe= Shoe("",0.0,"","")
        //binding.setLifecycleOwner(this)

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

//        binding.saveButton.setOnClickListener { v: View ->
//            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
//        }


        return binding.root
    }
}