package com.suhovey73.a04_basicuiconponents

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.TypedValue
import com.suhovey73.a04_basicuiconponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {
            btnChangeFontFamily.setOnClickListener {
                val face = Typeface.create("casual", textView.typeface.style)
                textView.typeface = face
            }

            btnChangeLinesCount.setOnClickListener {
                textView.setLines(3)
            }

            btnChangeSize.setOnClickListener {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,25F);
            }

            btnChangeStyle.setOnClickListener {
                textView.setTypeface(textView.typeface, Typeface.BOLD);
            }

            btnChangeText.setOnClickListener {
                textView.setLines(1)
                textView.ellipsize = TextUtils.TruncateAt.END
                textView.text = getString(R.string.test)
            }
        }
    }
}