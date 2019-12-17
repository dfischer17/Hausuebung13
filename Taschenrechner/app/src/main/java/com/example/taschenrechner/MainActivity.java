package com.example.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

            }
            // ansonsten Neue Eingabe hinzufuegen
            else {
                input.setText(input.getText().toString() + button.getText());
            }
        }
    }
}
