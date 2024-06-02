package com.example.flowerimageclassifier

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class TermsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
        // company email
        val mail= "contact@Hanami.com"
        // variable to hold the textview for the email
        var contact: TextView
        contact = findViewById(R.id.contact_terms)

        // set up intent to open email
        val intentC = Intent(Intent.ACTION_SEND).apply {
            // The intent does not have a URI, so declare the "text/plain" MIME type
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf( mail))

        }
        //start the email activity when the link is clicked
        contact.setOnClickListener {
            startActivity(intentC)
        }
    }
}

