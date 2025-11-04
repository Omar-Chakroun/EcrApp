package com.example.tmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress

class connection : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connection) // Ensure this is the correct XML layout file

        // Initialize Connection Type Spinner
        val connectionTypeSpinner: Spinner = findViewById(R.id.connection_type)
        val connectionTypeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.connection_type_array, // Ensure you have this array defined in strings.xml
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        connectionTypeSpinner.adapter = connectionTypeAdapter
        connectionTypeSpinner.setSelection(0, false) // Default text is "TCP/IP"

        // Initialize IP Address EditText
        val ipAddressInput: EditText = findViewById(R.id.ip_address)

        // Initialize Port Number EditText
        val portNumberInput: EditText = findViewById(R.id.port_number)

        // Initialize Connect Button
        val connectButton: Button = findViewById(R.id.connect_button)
        connectButton.setOnClickListener {
            // Handle the connect button click
            val connectionType = connectionTypeSpinner.selectedItem.toString()
            val ipAddress = ipAddressInput.text.toString()
            val portNumberStr = portNumberInput.text.toString()

            if (connectionType.isNotEmpty() && ipAddress.isNotEmpty() && portNumberStr.isNotEmpty()) {
                val portNumber = portNumberStr.toIntOrNull()
                if (portNumber != null) {
                    connectToTerminal(connectionType, ipAddress, portNumber)
                } else {
                    Toast.makeText(this, "Invalid port number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun connectToTerminal(connectionType: String, ipAddress: String, portNumber: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            var socket: Socket? = null

            try {
                Log.d("TCP", "Attempting to connect to IP: $ipAddress, Port: $portNumber")

                socket = Socket()
                val socketAddress: SocketAddress = InetSocketAddress(ipAddress, portNumber)
                socket.connect(socketAddress, 5000) // 5 seconds timeout

                if (socket.isConnected) {
                    val remoteAddress = (socket.remoteSocketAddress as InetSocketAddress).address.hostAddress
                    Log.d("TCP", "Connected to IP: $remoteAddress")

                    ConnectionManager.updateConnectionStatus(true, "Connected to $remoteAddress", socket)

                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@connection, "Connected to $remoteAddress", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        ConnectionManager.updateConnectionStatus(false, "Failed to connect to Terminal")
                        Toast.makeText(this@connection, "Failed to connect", Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    ConnectionManager.updateConnectionStatus(false, "Connection failed: ${e.message}")
                    Toast.makeText(this@connection, "Connection failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
