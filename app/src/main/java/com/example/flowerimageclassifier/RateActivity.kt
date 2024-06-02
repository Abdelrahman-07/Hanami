package com.example.flowerimageclassifier

import androidx.activity.ComponentActivity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

// class for the rate us page
class RateActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)

        val rBar = findViewById<RatingBar>(R.id.ratingBar)
        if (rBar != null) {
            val button = findViewById<Button>(R.id.button)
            button?.setOnClickListener {
                val msg = rBar.rating.toString()
                // display rating for the user
                Toast.makeText(this, "Thank you for giving us a rating of "+msg+" stars", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
