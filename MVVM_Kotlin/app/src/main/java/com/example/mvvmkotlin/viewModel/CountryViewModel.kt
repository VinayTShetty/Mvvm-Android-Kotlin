package com.example.mvvmkotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlin.api.RetroInstance
import com.example.mvvmkotlin.api.RetroServiceInterface
import com.example.mvvmkotlin.data.CountryItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CountryViewModel : ViewModel() {
    var liveCountryData = MutableLiveData<ArrayList<CountryItem>>()

    init {
        liveCountryData = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<ArrayList<CountryItem>> {
        return liveCountryData
    }

    fun makeApiCall() {
        val retroInstance: Retrofit = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getAllCountries()
        /**
         * shortcut for this callBack Mehtod to get
         * ctrl+shit+space
         * watch the video 7:42 to get Manual Adding of this Code.
         *
         */
        call.enqueue(object : Callback<ArrayList<CountryItem>?> {
            override fun onResponse(call: Call<ArrayList<CountryItem>?>, response: Response<ArrayList<CountryItem>?>) {
                liveCountryData.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<CountryItem>?>, t: Throwable) {
                liveCountryData.postValue(null)
            }
        })
    }
}