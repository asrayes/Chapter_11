package com.example.chapter11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView textView = (TextView) findViewById(R.id.txtMonthlyPayment);
        ImageView imageView = (ImageView) findViewById(R.id.imgYears);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);

        int years = shared.getInt("years",0);
        int loan = shared.getInt("loan",0);
        float interest = shared.getFloat("interest",0);
        float monthlyPayment;

        monthlyPayment = loan + 1 + ((interest * years) /(12*years));
        DecimalFormat currency = new DecimalFormat("$###,###.##");

        textView.setText("Monthly Payment: " + currency.format(monthlyPayment));

        if(years == 3) {
            imageView.setImageResource(R.drawable.three);
        }
        else if(years == 4) {
            imageView.setImageResource(R.drawable.four);
        }
        else if(years == 5) {
            imageView.setImageResource(R.drawable.five);
        }
        else {
            textView.setText("Please enter 3,4, or 5 years");
        }

    }
}