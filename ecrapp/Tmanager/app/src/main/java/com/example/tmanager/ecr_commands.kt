package com.example.tmanager


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ecr_commands : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ecr_commands) // Ensure this matches your layout file name


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

    private fun setupSpinner(spinner: Spinner, arrayResId: Int) {
        val adapter = ArrayAdapter.createFromResource(
            this,
            arrayResId,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun buttonClicked(button: Button) {
        // Handle button click events here
        when (button.text) {
            "Registration" -> {
                val intent = Intent(this@ecr_commands, registration::class.java)
                startActivity(intent)
            }

            "Authorisation" -> {
                val intent = Intent(this@ecr_commands, authorisation::class.java)
                startActivity(intent)
            }

            "Reversal" -> {
                val ch: String =
                    "0600190102038E09780682000F120124268200080A0206D30A020F2A"
                ConnectionManager.sendCommand(ch)
            }

            "Refund" -> { /* Handle Refund click */
            }

            "Log-off" -> { /* Handle Log-off click */
            }

            "Log-on" -> {
                sendLogOnCommand()
            }

            "Display Text" -> { /* Handle Display Text click */
            }
        }
    }

    private fun sendLogOnCommand() {
        val command = "0600190102038E09780682000F120124268200080A0206D30A020F2A"
        if (ConnectionManager.isConnected) {
            ConnectionManager.sendCommand(command)
            Toast.makeText(this@ecr_commands, "Log-on command sent", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@ecr_commands, "Not connected to a terminal", Toast.LENGTH_SHORT).show()
            Log.e("TCP", "Attempted to send log-on command but not connected")
        }
    }


}
