package com.suhovey73.a04_basicuiconponents

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.suhovey73.a04_basicuiconponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setImageNewParams()

        binding.btnGetNextImage.setOnClickListener {
            getNextRandomImage()
        }
    }

    private fun getNextRandomImage() {
        val circularProgressDrawable = CircularProgressDrawable(binding.imageView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.setColorSchemeColors(Color.RED)
        circularProgressDrawable.start()

        binding.imageView.setBackgroundColor(Color.TRANSPARENT)

        Glide.with(this)
            .load("https://picsum.photos/800/600")
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .placeholder(circularProgressDrawable)
            .override(300, 200)
            .fitCenter()
            .into(binding.imageView)
    }

    private fun setImageNewParams() {

        with(binding.imageView) {
            setImageResource(R.drawable.ic_launcher_foreground)
            setBackgroundResource(R.drawable.background_shape)

            layoutParams.width = resources.getDimensionPixelSize(R.dimen.image_width_big)
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.image_height_big)

            requestLayout()
        }
    }
}