package com.suhovey73.a04_basicuiconponents

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.ColorInt
import com.suhovey73.a04_basicuiconponents.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var tvByFindViewById: TextView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvByFindViewById = findViewById(R.id.tvOnAccessBy_findViewById)

        binding.btnChangePropertyByFindViewById.setOnClickListener {
            tvByFindViewById.setTextColor(randomColor())
        }

        binding.btnChangePropertyByViewBinding.setOnClickListener {
            binding.tvOnAccessByViewBinding.setTextColor(randomColor())
        }
    }

    private fun randomColor(): Int {
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        return color
    }

}