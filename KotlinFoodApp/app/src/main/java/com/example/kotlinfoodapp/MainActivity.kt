package com.example.kotlinfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private val numberFormat = NumberFormat.getNumberInstance()
    private lateinit var heightTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var bmiTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var kcalTextView: TextView
    private lateinit var ageEditText: EditText
    private lateinit var radioButtonMen: RadioButton
    private lateinit var radioButtonWomen: RadioButton
    private lateinit var radioGroupGender: RadioGroup
    private var height = 0
    private var weight = 0
    private var age = 0
    private var bmi = 0.0
    private var kcal = 0.0
    private lateinit var buttonGoToFood: Button
    private lateinit var buttonGoToQuiz: Button
    private lateinit var buttonGoToGraph: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightTextView = findViewById(R.id.heightTextView)
        weightTextView = findViewById(R.id.weightTextView)
        bmiTextView = findViewById(R.id.bmiTextView)
        kcalTextView = findViewById(R.id.kcalTextView)
        ageTextView = findViewById(R.id.ageTextView)
        radioButtonMen = findViewById(R.id.radioButtonMen)
        radioButtonWomen = findViewById(R.id.radioButtonWoman)
        radioGroupGender = findViewById(R.id.radioGroupGender)

        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        heightEditText.addTextChangedListener(heightEditTextWatcher)

        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        weightEditText.addTextChangedListener(weightEditTextWatcher)

        ageEditText = findViewById(R.id.ageEditText)
        ageEditText.addTextChangedListener(ageEditTextWatcher)

        buttonGoToFood = findViewById(R.id.buttonGoToFood)

        buttonGoToQuiz = findViewById(R.id.buttonGoToQuiz)
        buttonGoToGraph = findViewById(R.id.buttonGoToGraph)

        buttonGoToFood.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }

        buttonGoToQuiz.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        buttonGoToGraph.setOnClickListener {
            val intent = Intent(this, GraphActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculate() {
        val heightInMeters = height.toDouble() / 100
        bmi = weight.toDouble() / (heightInMeters * heightInMeters)
        bmiTextView.text = String.format("%.2f", bmi)
        // Calculate BMR using Harris-Benedict formula
        if (radioButtonMen.isChecked) {
            kcal = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
        } else if (radioButtonWomen.isChecked) {
            kcal = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
        }
        kcalTextView.text = String.format("%.2f", kcal)
    }

    private val heightEditTextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            try {
                height = s.toString().toInt()
                heightTextView.text = height.toString()
            } catch (e: NumberFormatException) {
                heightTextView.text = ""
                height = 0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    }

    private val weightEditTextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            try {
                weight = s.toString().toInt()
                weightTextView.text = weight.toString()
            } catch (e: NumberFormatException) {
                weightTextView.text = ""
                weight = 0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    }

    private val ageEditTextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            try {
                age = s.toString().toInt()
                ageTextView.text = age.toString()
            } catch (e: NumberFormatException) {
                ageTextView.text = ""
                age = 0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    }
}




