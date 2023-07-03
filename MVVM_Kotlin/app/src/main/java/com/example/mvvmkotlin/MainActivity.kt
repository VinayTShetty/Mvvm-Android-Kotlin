package com.example.mvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    lateinit var counter_textView: TextView
    lateinit var counter_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter_textView = findViewById<TextView>(R.id.textview_countter)
        counter_button = findViewById<Button>(R.id.button_click)

        myViewModel = ViewModelProvider(this, MyViewModelFactory(25)).get(MyViewModel::class.java)

        myViewModel.getCounter().observe(this, Observer { count ->
            counter_textView.text = count.toString()
        })

        counter_button.setOnClickListener {
            myViewModel.incrementCounter()
        }
    }
}