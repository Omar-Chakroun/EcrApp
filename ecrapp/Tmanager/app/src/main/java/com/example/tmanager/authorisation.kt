package com.example.tmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class authorisation : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorisation)

        // Retrieve all EditText fields
        val cfield = findViewById<EditText>(R.id.class_edit_text)
        val instrfield = findViewById<EditText>(R.id.instructor_edit_text)
        val amountField = findViewById<EditText>(R.id.amount_edit_text)
        val cashbackAmountField = findViewById<EditText>(R.id.cashback_edit_text)
        val tipAmountField = findViewById<EditText>(R.id.tipAmount_edit_text)
        val partialDeliveryAmountField = findViewById<EditText>(R.id.partial_edit_text)
        val currencyField = findViewById<EditText>(R.id.currency_code_edit_text)
        val cardNumberField = findViewById<EditText>(R.id.payment_type_edit_text)
        val currencyCodeField = findViewById<EditText>(R.id.currency_edit_text)
        val cvvField = findViewById<EditText>(R.id.cvv_edit_text)
        val panField = findViewById<EditText>(R.id.PAN_edit_text)
        val expiryDateField = findViewById<EditText>(R.id.data_edit_text)
        val cardTypeField = findViewById<EditText>(R.id.card_type_text)
        val bmpTextField = findViewById<EditText>(R.id.bmp_text)

        val submitButton = findViewById<Button>(R.id.button)
        submitButton.setOnClickListener {
            val c = cfield.text.toString()
            val instr = instrfield.text.toString()
            val amount = amountField.text.toString()
            val cashbackAmount = cashbackAmountField.text.toString()
            val tipAmount = tipAmountField.text.toString()
            val partialDeliveryAmount = partialDeliveryAmountField.text.toString()
            val currency = currencyField.text.toString()
            val cardNumber = cardNumberField.text.toString()
            val currencyCode = currencyCodeField.text.toString()
            val cvv = cvvField.text.toString()
            val pan = panField.text.toString()
            val expiryDate = expiryDateField.text.toString()
            val cardType = cardTypeField.text.toString()
            val bmpText = bmpTextField.text.toString()

            // Generate byte code and send command
            val byteCode = generateByteCode(
                c, instr, amount, cashbackAmount, tipAmount,
                partialDeliveryAmount, currency, cardNumber, currencyCode,
                cvv, pan, expiryDate, cardType, bmpText
            )
            ConnectionManager.sendCommand(byteCode)

            Toast.makeText(this, "Registration details saved and sent!", Toast.LENGTH_SHORT).show()

            // Send fields with labels
            ConnectionManager.sendFieldsAuthorization(
                c, instr, amount, cashbackAmount, tipAmount, partialDeliveryAmount, currency,
                cardNumber, currencyCode, cvv, pan, expiryDate, cardType, bmpText
            )
        }
    }

    private fun generateByteCode(
        c: String, instr: String, amount: String, cashbackAmount: String, tipAmount: String,
        partialDeliveryAmount: String, currency: String, cardNumber: String,
        currencyCode: String, cvv: String, pan: String, expiryDate: String,
        cardType: String, bmpText: String
    ): String {
        // Combine all fields into a single string in the specified order
        return "$c$instr$amount$cashbackAmount$tipAmount$partialDeliveryAmount$currency$cardNumber$currencyCode$cvv$pan$expiryDate$cardType$bmpText"
    }
}
