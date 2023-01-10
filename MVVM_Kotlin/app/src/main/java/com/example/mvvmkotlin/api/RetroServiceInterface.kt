package com.example.mvvmkotlin.api

import com.example.mvvmkotlin.data.CountryItem
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("all")
    fun getAllCountries():Call<ArrayList<CountryItem>>
}