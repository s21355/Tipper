package com.example.kotlinfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    private lateinit var radioGroupQuiz1: RadioGroup
    private lateinit var radioGroupQuiz2: RadioGroup
    private lateinit var radioGroupQuiz3: RadioGroup
    private lateinit var radioGroupQuiz4: RadioGroup
    private lateinit var radioGroupQuiz5: RadioGroup
    private lateinit var radioGroupQuiz6: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        radioGroupQuiz1 = findViewById(R.id.radioGroupQuiz1)
        radioGroupQuiz2 = findViewById(R.id.radioGroupQuiz2)
        radioGroupQuiz3 = findViewById(R.id.radioGroupQuiz3)
        radioGroupQuiz4 = findViewById(R.id.radioGroupQuiz4)
        radioGroupQuiz5 = findViewById(R.id.radioGroupQuiz5)
        radioGroupQuiz6 = findViewById(R.id.radioGroupQuiz6)

        val submitButton = findViewById<Button>(R.id.submit_quiz)
        val resultTextView = findViewById<TextView>(R.id.result_quiz)

        submitButton.setOnClickListener {
            val correctAnswers = calculateCorrectAnswers()
            val totalQuestions = 6
            val percentage = (correctAnswers * 100) / totalQuestions

            resultTextView.text = "Twój wynik to $percentage%."
        }
    }

    private fun calculateCorrectAnswers(): Int {
        val answers = arrayOf(R.id.radio_button_question_1_yes, R.id.radio_button_question_2_yes, R.id.radio_button_question_3_no, R.id.radio_button_question_4_no, R.id.radio_button_question_5_yes, R.id.radio_button_question_6_yes)
        var correctAnswers = 0

        for (answer in answers) {
            val radioButton = findViewById<RadioButton>(answer)
            if (radioButton.isChecked) {
                correctAnswers++
            }
        }

        return correctAnswers
    }

}