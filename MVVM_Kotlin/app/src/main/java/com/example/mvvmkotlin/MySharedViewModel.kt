package com.example.mvvmkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MySharedViewModel: ViewModel() {

    /**
     * This MutableLive data should be avaliabe only within the MySharedViewModel
     */
    private var _country=MutableLiveData<String>("Germany")

    /**
     * Public varriable
     * Read only variable
     * We will expose only country i.e LiveData variables to fragments
     */
    val country:LiveData<String> =_country

    fun saveCountry(country_new:String){
        _country.value=country_new
    }
}