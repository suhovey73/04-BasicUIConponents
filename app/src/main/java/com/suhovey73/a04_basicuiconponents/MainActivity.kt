package com.suhovey73.a04_basicuiconponents

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.suhovey73.a04_basicuiconponents.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var circularProgressDrawable: CircularProgressDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        circularProgressDrawable = CircularProgressDrawable(binding.imageView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.setColorSchemeColors(Color.RED)

        setImageNewParams()

        binding.btnGetNextImage.setOnClickListener {
            getNextRandomImage()
        }

        binding.btnGetNextImage.setOnLongClickListener {
            getRandomNumber()
        }
    }

    private fun getRandomNumber(): Boolean {
        val rndNum = Random.nextInt(10000)
        val msg = "Random number is: $rndNum"
        val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()

        return true
    }

    private fun getNextRandomImage() {

        binding.imageView.setBackgroundColor(Color.TRANSPARENT)

        circularProgressDrawable.start()

        Glide.with(this)
            .load("https://picsum.photos/800/600")
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    circularProgressDrawable.stop()
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    circularProgressDrawable.stop()
                    resource.let { binding.imageView.setImageDrawable(resource) }
                    Toast.makeText(baseContext, "Loaded is Ok", Toast.LENGTH_SHORT).show()
                    return true
                }
            })
            .placeholder(circularProgressDrawable)
            //.override(300, 200)
            //.fitCenter()
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