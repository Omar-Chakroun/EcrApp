package com.example.tmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class connection_status : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connection_status)

        val connectionStatus: TextView = findViewById(R.id.connection_status)
        val connectButton: Button = findViewById(R.id.connect_button)
        val disconnectButton: Button = findViewById(R.id.disconnect_button)

        // Display the current connection status
        updateConnectionStatus()

        connectButton.setOnClickListener {
            val intent = Intent(this, connection::class.java)
            startActivity(intent)
        }

        disconnectButton.setOnClickListener {
            // Handle disconnect logic
            ConnectionManager.updateConnectionStatus(false, "Disconnected")
            updateConnectionStatus()
        }
    }

    private fun updateConnectionStatus() {
        val connectionStatus: TextView = findViewById(R.id.connection_status)
        connectionStatus.text = ConnectionManager.connectionStatusMessage
        connectionStatus.setBackgroundColor(
            if (ConnectionManager.isConnected) getColor(android.R.color.holo_green_light)
            else getColor(android.R.color.holo_red_light)
        )
    }}
