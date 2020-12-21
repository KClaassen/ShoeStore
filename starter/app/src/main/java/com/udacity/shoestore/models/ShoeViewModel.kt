package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel()     {

    private val shoesList = mutableListOf<Shoe>()

    private val _shoeItem = MutableLiveData<List<Shoe>>()
    val shoeItem : LiveData<List<Shoe>>
        get() = _shoeItem

    fun addShoe(shoe: Shoe) {
        shoesList.add(shoe)
        _shoeItem.value = shoesList
    }
}