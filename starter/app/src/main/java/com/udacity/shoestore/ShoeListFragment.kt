package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        // ViewModel Assignment
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        fun addShoe(shoe: Shoe) {

            val shoeBinding: ShoeListItemBinding = ShoeListItemBinding.inflate(layoutInflater, binding.shoeListLayout, true)
            shoeBinding.shoe = shoe
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {shoeData ->
            for (shoe in shoeData) {
                //How to inflate the layout_item.xml
                addShoe(shoe)
            }
        })


//        // Inflate Item Rows to the LinearLayout from the SharedViewModel
//        viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
//            for (shoe in shoeList){
//                // inflate a new shoe row
//                val view = DataBindingUtil.inflate<ShoeListItemBinding>(layoutInflater, R.layout.shoe_list_item, binding.shoeListLayout,true).apply {
//                    this.shoe = shoe
//                }
//            }
//        })



        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        setHasOptionsMenu(true)
        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.LoginFragment) {
            logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
    }
}

