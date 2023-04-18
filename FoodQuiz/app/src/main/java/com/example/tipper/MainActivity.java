package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.EditText; // for bill amount input
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView; // for displaying text
import android.widget.Button;

import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();
    private TextView heightTextView;
    private TextView weightTextView;
    private TextView bmiTextView;
    private TextView ageTextView;
    private TextView kcalTextView;
    private EditText ageEditText;
    private RadioButton radioButtonMen;
    private RadioButton radioButtonWomen;

    private RadioGroup radioGroupGender;
    private int height = 0;
    private int weight = 0;
    private int age = 0;
    private double bmi = 0;
    private double kcal = 0;
    private Button buttonGoToFood;

    private Button buttonGoToQuiz;
    private Button buttonGoToGraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightTextView = findViewById(R.id.heightTextView);
        weightTextView = findViewById(R.id.weightTextView);
        bmiTextView = findViewById(R.id.bmiTextView);
        kcalTextView = findViewById(R.id.kcalTextView);
        ageTextView = findViewById(R.id.ageTextView);
        radioButtonMen = findViewById(R.id.radioButtonMen);
        radioButtonWomen = findViewById(R.id.radioButtonWoman);

//        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        EditText heightEditText = findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText weightEditText = findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText ageEditText = findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);

        buttonGoToFood = findViewById(R.id.buttonGoToFood);

        /// NEW --------------------------------------------------
        buttonGoToQuiz = findViewById(R.id.buttonGoToQuiz);
        buttonGoToGraph = findViewById(R.id.buttonGoToGraph);

        /// NEW --------------------------------------------------

        buttonGoToFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        buttonGoToQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        buttonGoToGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculate() {
        double heightInMeters = (double) height / 100;
        bmi = (double) weight / (heightInMeters * heightInMeters);
        bmiTextView.setText(String.format("%.2f", bmi));

        // Calculate BMR using Harris-Benedict formula
        if (radioButtonMen.isChecked()) {
            kcal = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else if (radioButtonWomen.isChecked()) {
            kcal = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
        kcalTextView.setText(String.format("%.2f", kcal));
    }

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            try {
                height = Integer.parseInt(s.toString());
                heightTextView.setText(String.valueOf(height));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Integer.parseInt(s.toString());
                weightTextView.setText(String.valueOf(weight));
            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher ageEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                age = Integer.parseInt(s.toString());
                ageTextView.setText(String.valueOf(age));
            } catch (NumberFormatException e) {
                ageTextView.setText("");
                age = 0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
}

