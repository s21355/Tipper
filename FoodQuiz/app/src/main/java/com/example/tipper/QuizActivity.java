package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup radioGroupQuiz1;
    private RadioGroup radioGroupQuiz2;
    private RadioGroup radioGroupQuiz3;
    private RadioGroup radioGroupQuiz4;
    private RadioGroup radioGroupQuiz5;
    private RadioGroup radioGroupQuiz6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        radioGroupQuiz1 = findViewById(R.id.radioGroupQuiz1);
        radioGroupQuiz2 = findViewById(R.id.radioGroupQuiz2);
        radioGroupQuiz3 = findViewById(R.id.radioGroupQuiz3);
        radioGroupQuiz4 = findViewById(R.id.radioGroupQuiz4);
        radioGroupQuiz5 = findViewById(R.id.radioGroupQuiz5);
        radioGroupQuiz6 = findViewById(R.id.radioGroupQuiz6);

        Button submitButton = findViewById(R.id.submit_quiz);
        TextView resultTextView = findViewById(R.id.result_quiz);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView resultTextView = findViewById(R.id.result_quiz);

                int correctAnswers = 0;
                RadioButton radioButton;

                radioButton = findViewById(R.id.radio_button_question_1_yes);
                if (radioButton.isChecked()) {
                    correctAnswers++;
                }

                radioButton = findViewById(R.id.radio_button_question_2_yes);
                if (radioButton.isChecked()) {
                    correctAnswers++;
                }

                radioButton = findViewById(R.id.radio_button_question_3_no);
                if (radioButton.isChecked()) {
                    correctAnswers++;
                }

                radioButton = findViewById(R.id.radio_button_question_4_no);
                if (radioButton.isChecked()) {
                    correctAnswers++;
                }

                radioButton = findViewById(R.id.radio_button_question_5_yes);
                if (radioButton.isChecked()) {
                    correctAnswers++;
                }

                radioButton = findViewById(R.id.radio_button_question_6_yes);
                if (radioButton.isChecked()) {
                    correctAnswers++;
                }
                int totalQuestions = 6;
                int percentage = (correctAnswers * 100) / totalQuestions;

                resultTextView.setText("Twój wynik to " + percentage + "%.");
            }
        });
    }
}