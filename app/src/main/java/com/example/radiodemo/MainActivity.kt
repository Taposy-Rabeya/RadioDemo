package com.example.radiodemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.tvText)
        val radioGroup = findViewById<RadioGroup>(R.id.rgOption)
        val rdSubmit = findViewById<Button>(R.id.btnSubmit)
        val rdResult = findViewById<TextView>(R.id.tvResult)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val complement = findViewById<TextView>(R.id.tvCoplement)
        val giveRate = findViewById<Button>(R.id.btnGiveRate)
        val ratingResult = findViewById<TextView>(R.id.tvRatingResult)

        rdSubmit.setOnClickListener {
            var selectButton: Int = radioGroup!!.checkedRadioButtonId
            if (selectButton!= -1) {
                val rdSubmit: RadioButton = findViewById(selectButton)
                val radio = rdSubmit.text.toString()
                rdResult.setText(radio)
            } else {
                Toast.makeText(applicationContext, "Please select one", Toast.LENGTH_SHORT).show()
            }
        }
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            complement.text = fromUser.toString()
            when (ratingBar.rating.toInt()) {
                1 -> complement.text = "Bad"
                2 -> complement.text = "Good"
                3 -> complement.text = "Well"
                4 -> complement.text = "Great"
                5 -> complement.text = "Awesome"
                else -> complement.text = " "
            }
        }
        giveRate.setOnClickListener {
            val message = ratingBar.rating.toString()
            ratingResult.setText(message)
        }

    }

}