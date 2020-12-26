package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class ShoeViewModel: ViewModel()     {

//    private val shoeName = MutableLiveData<String>()
//    private val shoeSize = MutableLiveData<String>()
//    private val shoeCompany = MutableLiveData<String>()
//    private val shoeDescription = MutableLiveData<String>()
//
//    var shoe: Shoe = Shoe("", 0.0, "", "", mutableListOf())
//        get() = field.apply {
//            name = shoeName.value!!
//            size = shoeSize.value?.toDouble() ?: 0.0
//            company = shoeCompany.value!!
//            description = shoeDescription.value!!
//        }

    //Create Live Data Object
    private var _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    fun onSaveClick(v: View, shoe: Shoe){
        _shoeList.value?.add(shoe)
        navigateUp(v)
    }

    init {
        //_shoeList.value = ArrayList()
    }

    fun navigateUp(v: View){
        v.findNavController().navigateUp()
    }

}