package com.suhovey73.a04_basicuiconponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suhovey73.a04_basicuiconponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater()) // Need to use "inflaterLayout"

        setContentView(binding.root)

        binding.btnGetNextImage.setOnClickListener {

        }
    }
}