package com.example.tmanager


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        // Initialize Ecr Commands Spinner
        val ecrCommands: Spinner = findViewById(R.id.ecr_commands)
        val ecrCommandsAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.ecr_commands_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        ecrCommands.adapter = ecrCommandsAdapter
        ecrCommands.setSelection(0, false) // Set default item to the placeholder

        ecrCommands.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                if (position > 0) {
                    when (parent.getItemAtPosition(position).toString()) {
                        "See all" -> {
                            val intent = Intent(this@main, ecr_commands::class.java)
                            startActivity(intent)
                        }

                        "Registration" -> {
                            val intent = Intent(this@main, registration::class.java)
                            startActivity(intent)
                        }
                        "Authorisation" -> {
                            val intent = Intent(this@main, authorisation::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Initialize Maintenance Spinner
        val maintenance: Spinner = findViewById(R.id.maintenance)
        val maintenanceAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.maintenance_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        maintenance.adapter = maintenanceAdapter
        maintenance.setSelection(0, false) // Set default item to the placeholder

        maintenance.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Add action for Maintenance Spinner if needed
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Initialize Configuration Spinner
        val configuration: Spinner = findViewById(R.id.configuration)
        val configurationAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.configuration_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        configuration.adapter = configurationAdapter
        configuration.setSelection(0, false) // Set default item to the placeholder

        configuration.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    when (parent.getItemAtPosition(position).toString()) {
                        "Connection" -> {
                            val intent = Intent(this@main, connection_status::class.java)
                            startActivity(intent)
                        }
                        "See all" -> {
                            val intent = Intent(this@main, configuration_commands::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}
