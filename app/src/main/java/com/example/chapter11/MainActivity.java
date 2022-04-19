package com.example.chapter11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int years;
    int amount;
    float rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText numYears = (EditText) findViewById(R.id.editText1);
        EditText loanAmount = (EditText) findViewById(R.id.editText2);
        EditText interestRate = (EditText) findViewById(R.id.editText3);
        Button button = (Button) findViewById(R.id.button);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               years = Integer.parseInt(numYears.getText().toString());
                amount = Integer.parseInt(loanAmount.getText().toString());
                rate = Float.parseFloat(interestRate.getText().toString());
                SharedPreferences.Editor editor = shared.edit();

                editor.putInt("years",years);
                editor.putInt("amount",amount);
                editor.putFloat("rate",rate);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}