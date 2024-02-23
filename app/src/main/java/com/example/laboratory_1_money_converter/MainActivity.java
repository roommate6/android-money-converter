package com.example.laboratory_1_money_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText _euroEditText, _dollarEditText, _ronEditText;

    private final double _dollarRate = 1.234;
    private final double _ronRate = 5.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire objects with components
        _euroEditText = findViewById(R.id.euroEditText);
        _dollarEditText = findViewById(R.id.dollarEditText);
        _ronEditText = findViewById(R.id.ronEditText);

        Button _convertButton = findViewById(R.id.convertButton);
        Button _clearButton = findViewById(R.id.clearButton);

        // deal with events from buttons
        _clearButton.setOnClickListener(view -> handleClearButtonClickEvent());

        _convertButton.setOnClickListener(view -> handleConvertButtonClickEvent());
    }

    private void clear(){
        _euroEditText.setText("");
        _dollarEditText.setText("");
        _ronEditText.setText("");
    }

    private void handleClearButtonClickEvent() {
        clear();
    }
    private void handleConvertButtonClickEvent() {
        String euroRowValue = _euroEditText.getText().toString();
        String dollarRowValue = _dollarEditText.getText().toString();
        String ronRowValue = _ronEditText.getText().toString();

        if (!euroRowValue.equals("")){
            convertFromEuro(Double.parseDouble(euroRowValue));
            return;
        }

        if (!dollarRowValue.equals("")){
            convertFromDollar(Double.parseDouble(dollarRowValue));
            return;
        }

        convertFromRon(Double.parseDouble(ronRowValue));
    }

    private void convertFromEuro(double euros){
        double dollars = euros*_dollarRate;
        double rons = euros*_ronRate;

        _dollarEditText.setText(String.valueOf(dollars));
        _ronEditText.setText(String.valueOf(rons));
    }

    private void convertFromDollar(double dollars){
        double euros = dollars/_dollarRate;
        double rons = euros*_ronRate;

        _euroEditText.setText(String.valueOf(euros));
        _ronEditText.setText(String.valueOf(rons));
    }

    private void convertFromRon(double rons){
        double euros = rons/_ronRate;
        double dollars = euros*_dollarRate;

        _euroEditText.setText(String.valueOf(euros));
        _dollarEditText.setText(String.valueOf(dollars));
    }
}