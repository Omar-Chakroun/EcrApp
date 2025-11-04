package com.example.tmanager

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

object ConnectionManager {
    var isConnected: Boolean = false
    var connectionStatusMessage: String = "Not Connected"
    private var socket: Socket? = null
    private var reader: BufferedReader? = null
    private var writer: PrintWriter? = null

    fun updateConnectionStatus(connected: Boolean, message: String, socket: Socket? = null) {
        isConnected = connected
        connectionStatusMessage = message
        this.socket = socket
        if (connected) {
            // Initialize reader and writer for communication
            if (socket != null) {
                reader = BufferedReader(InputStreamReader(socket!!.getInputStream()))
                writer = PrintWriter(socket.getOutputStream(), true)
                // Start a coroutine to read responses
                CoroutineScope(Dispatchers.IO).launch {
                    listenForResponses()
                }
            }
        } else {
            // Clean up resources
            reader?.close()
            writer?.close()
            reader = null
            writer = null
        }
    }

    private suspend fun listenForResponses() {
        try {
            while (isConnected) {
                val response = reader?.readLine()
                if (response != null) {
                    withContext(Dispatchers.Main) {
                        Log.d("TCP", "Response received: $response")
                        // Optionally, you can display the response in UI if needed
                        // For example: Toast.makeText(context, "Response: $response", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("TCP", "Error reading response: ${e.message}")
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun sendCommand(command: String) {
        if (isConnected && writer != null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {

                    Log.d("TCP", "Attempting to send command: $command")
                    writer?.apply {
                        println(command.toByteArray())
                        flush()  // Ensure the data is sent immediately
                    }
                    Log.d("TCP", "Command sent: $command")
                } catch (e: Exception) {
                    Log.e("TCP", "Error sending command: ${e.message}")
                }
            }
        } else {
            Log.e("TCP", "Not connected to a terminal or writer is null")
        }
    }

    fun sendFieldsregistration(
        classValue: String,
        instructorValue: String,
        password: String,
        configByte: String,
        currencyCode: String,
        bmp: String,
        lineWidth: String,
        knownCommands: String
    ) {
        if (isConnected && writer != null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // Format the fields with their labels
                    val fields = listOf(
                        "Class: $classValue",
                        "Instructor: $instructorValue",
                        "Password: $password",
                        "Config Byte: $configByte",
                        "Currency Code: $currencyCode",
                        "BMP: $bmp",
                        "Line Width: $lineWidth",
                        "Known Commands: $knownCommands"
                    ).joinToString(separator = "\n")

                    // Send the formatted fields
                    Log.d("TCP", "Attempting to send fields:\n$fields")
                    writer?.apply {
                        println(fields)
                        flush()  // Ensure the data is sent immediately
                    }
                    Log.d("TCP", "Fields sent:\n$fields")
                } catch (e: Exception) {
                    Log.e("TCP", "Error sending fields: ${e.message}")
                }
            }
        } else {
            Log.e("TCP", "Not connected to a terminal or writer is null")
        }
    }
    fun sendFieldsAuthorization(
        c: String,
        instr: String,
        amount: String,
        cashbackAmount: String,
        tipAmount: String,
        partialDeliveryAmount: String,
        currency: String,
        cardNumber: String,
        currencyCode: String,
        cvv: String,
        pan: String,
        expiryDate: String,
        cardType: String,
        bmpText: String
    ) {
        if (isConnected && writer != null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // Format the fields with their labels
                    val fields = listOf(
                        "Class: $c",
                        "Instructor: $instr",
                        "Amount: $amount",
                        "Cashback Amount: $cashbackAmount",
                        "Tip Amount: $tipAmount",
                        "Partial Delivery Amount: $partialDeliveryAmount",
                        "Currency: $currency",
                        "Card Number: $cardNumber",
                        "Currency Code: $currencyCode",
                        "CVV: $cvv",
                        "PAN: $pan",
                        "Expiry Date: $expiryDate",
                        "Card Type: $cardType",
                        "BMP Text: $bmpText"
                    ).joinToString(separator = "\n")

                    // Send the formatted fields
                    Log.d("TCP", "Attempting to send fields:\n$fields")
                    writer?.apply {
                        println(fields)
                        flush()  // Ensure the data is sent immediately
                    }
                    Log.d("TCP", "Fields sent:\n$fields")
                } catch (e: Exception) {
                    Log.e("TCP", "Error sending fields: ${e.message}")
                }
            }
        } else {
            Log.e("TCP", "Not connected to a terminal or writer is null")
        }
    }

}


