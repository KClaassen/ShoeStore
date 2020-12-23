package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        // Set the viewmodel for databinding - this allows the bound layout access to all the data in the ViewModel
        binding.shoeViewModel = viewModel

        // Specify the fragment view as the lifecycle owner of the binding. This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.saveButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }


        return binding.root
    }
}