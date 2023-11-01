package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText celsiusInput, fahrenheitInput;
    private Button celsiusToFahrenheitButton, fahrenheitToCelsiusButton;
    private TextView resultText, textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celsiusInput = findViewById(R.id.editTextCelsius);
        fahrenheitInput = findViewById(R.id.editTextFahrenheit);
        resultText = findViewById(R.id.textViewResult);
        textView=findViewById(R.id.textView1);
        celsiusToFahrenheitButton = findViewById(R.id.buttonCelsiusToFahrenheit);
        fahrenheitToCelsiusButton = findViewById(R.id.buttonFahrenheitToCelsius);

        celsiusToFahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToFahrenheit();
            }
        });

        fahrenheitToCelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToCelsius();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(celsiusInput.getText().toString());
            double fahrenheit = (celsius * 9/5) + 32;
            resultText.setText(String.format("%.2f °F", fahrenheit));
        } catch (NumberFormatException e) {
            resultText.setText("Invalid input. Enter a number.");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitInput.getText().toString());
            double celsius = (fahrenheit - 32) * 5/9;
            resultText.setText(String.format("%.2f °C", celsius));
        } catch (NumberFormatException e) {
            resultText.setText("Invalid input. Enter a number.");
        }

    }
}