package com.example.mvvmkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(private val arg_num:Int):ViewModel(){
    private var counter = MutableLiveData<Int>()

    init {
        counter.value = arg_num
    }

    fun getCounter(): MutableLiveData<Int> {
        return counter
    }

    fun incrementCounter() {
        counter.value = counter.value?.plus(1)
    }
}