package com.example.laboratory_1_money_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText _euroEditText, _dollarEditText, _ronEditText;
    private Button _clearButton, _convertButton;

    private final double _dollarRate = 1.234;
    private final double _ronRate = 5.897;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire objects with components
        _euroEditText = findViewById(R.id.euroEditText);
        _dollarEditText = findViewById(R.id.dollarEditText);
        _ronEditText = findViewById(R.id.ronEditText);

        _convertButton = findViewById(R.id.convertButton);
        _clearButton = findViewById(R.id.clearButton);

        // deal with events from buttons
        _clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                _euroEditText.setText("");
                _dollarEditText.setText("");
                _ronEditText.setText("");
            }
        });

        _convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                double euros = Double.parseDouble(_euroEditText.getText().toString());
                double dollars = euros*_dollarRate;
                double rons = euros*_ronRate;

                _dollarEditText.setText(String.valueOf(dollars));
                _ronEditText.setText(String.valueOf(rons));
            }
        });
    }
}