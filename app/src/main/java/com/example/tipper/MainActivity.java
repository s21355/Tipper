package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();
    private TextView heightTextView;
    private TextView weightTextView;
    private TextView bmiTextView;
    private int height = 0;
    private int weight = 0;
    private double bmi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightTextView = findViewById(R.id.heightTextView);
        weightTextView = findViewById(R.id.weightTextView);
        bmiTextView = findViewById(R.id.bmiTextView);

        EditText heightEditText = findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText weightEditText = findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
    }

    private void calculate() {
        double heightInMeters = (double) height / 100;
        bmi = (double) weight / (heightInMeters * heightInMeters);
        bmiTextView.setText(String.format("%.2f", bmi));
    }

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            try {
                height = Integer.parseInt(s.toString());
                heightTextView.setText(String.valueOf(height));
            }
            catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Integer.parseInt(s.toString());
                weightTextView.setText(String.valueOf(weight));
            }
            catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
}



/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
