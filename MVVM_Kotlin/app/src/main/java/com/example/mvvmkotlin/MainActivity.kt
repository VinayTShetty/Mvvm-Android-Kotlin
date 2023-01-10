package com.example.mvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmkotlin.adapter.CountryAdapter
import com.example.mvvmkotlin.viewModel.CountryViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var countryViewModel: CountryViewModel
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intiateRecycleView()
    }

    private fun intiateRecycleView() {
        val countryRecyclerview = findViewById<RecyclerView>(R.id.countryList)
        countryRecyclerview.layoutManager = LinearLayoutManager(this)
        countryAdapter=CountryAdapter()
        countryRecyclerview.adapter = countryAdapter
        intiateViewModel()

    }


    private fun intiateViewModel() {
        countryViewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        countryViewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                countryAdapter.setCountryList(it)
                countryAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error Response", Toast.LENGTH_LONG).show()
            }
        })
        countryViewModel.makeApiCall()
    }
}