package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel()     {

    //Empty list of shoes
    private val shoeList = mutableListOf<String>()

    //LiveData Object for the current shoe
    private val _shoeItem = MutableLiveData<List<String>>()
    val shoeItem : LiveData<List<String>>
        get() = _shoeItem


    init {
        _shoeItem.value = ""
        Log.i("ShoeViewModel", "ShoeViewModel created!")
        addShoe()
    }

    fun addShoe(shoe: Shoe) {
        shoeItem.value?.add(shoe)

        Log.i("New Shoe Added")
    }
}