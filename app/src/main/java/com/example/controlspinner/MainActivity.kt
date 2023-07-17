package com.example.controlspinner



import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var operationSpinner: Spinner
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        operationSpinner = findViewById(R.id.operationSpinner)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        val operationOptions = arrayOf(
            "Sumar",
            "Restar",
            "Multiplicar",
            "Dividir"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            operationOptions
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        operationSpinner.adapter = adapter

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDouble()
            val number2 = number2EditText.text.toString().toDouble()

            val result = when (operationSpinner.selectedItem.toString()) {
                "Sumar" -> number1 + number2
                "Restar" -> number1 - number2
                "Multiplicar" -> number1 * number2
                "Dividir" -> number1 / number2
                else -> 0.0
            }

            resultTextView.text = "El resultado es: $result"
        }
    }
}
