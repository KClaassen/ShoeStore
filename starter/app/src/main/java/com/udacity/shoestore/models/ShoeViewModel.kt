package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel()     {

    //Create empty list of shoes
    private var _shoeList = MutableLiveData<ArrayList<Shoe>>()

    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList


    init {
        _shoeList.value = ArrayList<Shoe>()
    }

//    fun addShoe(shoe: Shoe) {
//        shoeList.add(shoe)
//        _shoeList.value = shoeList
//    }
}