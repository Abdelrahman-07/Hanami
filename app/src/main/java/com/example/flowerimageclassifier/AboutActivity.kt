package com.example.flowerimageclassifier
//import statements
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity


// activity for the about us page
class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the layout of the page
        setContentView(R.layout.activity_about)
        // company email
        val mail= "contact@Hanami.com"
        // variable to hold the textview for the email
        var contact:TextView
        contact = findViewById(R.id.contact)

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

