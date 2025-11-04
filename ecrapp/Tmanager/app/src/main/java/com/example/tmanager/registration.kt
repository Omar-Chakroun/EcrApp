package com.example.tmanager

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val submitButton = findViewById<Button>(R.id.button)
        submitButton.setOnClickListener {
            onOkClick(it)
        }
    }

    fun onCancelClick(view: View) {
        // Handle Cancel button click here
        finish() // Close activity without saving
    }

    private fun generateByteCode(
        classEditText: String,
        instructorEditText: String,
        password: String,
        configByte: String,
        currency: String,
        bmp06: String,
        printerLineWidth: String,
        knownCommands: String
    ): String {
        // This function may not be necessary if you are directly sending a predefined hex string.
        // For this case, we are directly using a predefined hex string, so this function can be skipped.
        return "0600190102038E09780682000F120124268200080A0206D30A020F2A"
    }

    fun onOkClick(view: View) {
        // Predefined hexadecimal string to be sent
        val hexString = "0600190102038E09780682000F120124268200080A0206D30A020F2A"

        // Send the byte code using the ConnectionManager
        ConnectionManager.sendCommand(hexString)

        Toast.makeText(this, "Hexadecimal code sent!", Toast.LENGTH_SHORT).show()
        finish() // Close activity after sending
    }
}



