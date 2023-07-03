package com.example.mvvmkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel(){
    private var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun getCounter(): MutableLiveData<Int> {
        return counter
    }

    fun incrementCounter() {
        counter.value = counter.value?.plus(1)
    }
}