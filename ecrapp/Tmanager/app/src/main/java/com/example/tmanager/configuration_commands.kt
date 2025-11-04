package com.example.tmanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class configuration_commands : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuration_commands) // Ensure this matches your layout file name

        // Initialize Back Button
        val backButton: ImageButton = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Initialize GridLayout Buttons
        val gridLayout: GridLayout = findViewById(R.id.grid_layout)
        for (i in 0 until gridLayout.childCount) {
            val view: View = gridLayout.getChildAt(i)
            if (view is Button) {
                view.setOnClickListener { buttonClicked(view) }
            }
        }
    }

    private fun buttonClicked(button: Button) {
        when (button.text) {
            "Connection" -> {
                val intent = Intent(this, connection_status::class.java)
                startActivity(intent)
            }

            // Handle other buttons if needed
        }
    }
}