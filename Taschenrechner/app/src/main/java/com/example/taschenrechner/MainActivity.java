package com.example.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import arithmeticutils.PostFixConverter;
import arithmeticutils.PostfixCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterValue(View view) {
        // Eingabe TextView
        TextView input = findViewById(R.id.input);

        if (view instanceof Button) {
            Button button = (Button) view;

            // Wenn Button clear Eingabe loeschen
            if (button.getText().toString().equals("clear")) {
                input.setText("");
            }

            // Wenn Button gleich Ergebnis berechnen
            else if (button.getText().toString().equals("=")) {
                PostFixConverter converter = new PostFixConverter(input.getText().toString());
                String expression = converter.getPostfixExpression();
                PostfixCalculator calculator = new PostfixCalculator(expression);

                // Ergebnis des mathematischen Ausdrucks berechnen
                BigDecimal result = calculator.getResult();

                // Ergebnis in input view schreiben
                input.setText(String.valueOf(result.doubleValue()));
            }
            // ansonsten Neue Eingabe hinzufuegen
            else {
                input.setText(input.getText().toString() + button.getText());
            }
        }
    }
}
