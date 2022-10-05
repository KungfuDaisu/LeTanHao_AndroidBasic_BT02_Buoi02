package com.example.letanhao_bt02_buoi2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.intellij.lang.annotations.JdkConstants;

public class MainActivity extends AppCompatActivity {

    private int age = 0;
    private int weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ageNumber = findViewById(R.id.ageNumber);
        EditText weightNumber = findViewById(R.id.weightNumber);

        ageNumber.setTextSize(70);
        ageNumber.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ageNumber.setText(Integer.toString(age));

        weightNumber.setTextSize(70);
        weightNumber.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        weightNumber.setText(Integer.toString(weight));

    }

    public void onAgeDecreaseClick(View view) {
        EditText ageNumber = findViewById(R.id.ageNumber);
        age--;
        ageNumber.setText(Integer.toString(age));
    }

    public void onAgeIncreaseClick(View view) {
        EditText ageNumber = findViewById(R.id.ageNumber);
        age++;
        ageNumber.setText(Integer.toString(age));
    }

    public void onWeightDecreaseClick(View view) {
        EditText weightNumber = findViewById(R.id.weightNumber);
        weight--;
        weightNumber.setText(Integer.toString(weight));
    }

    public void onWeightIncreaseClick(View view) {
        EditText weightNumber = findViewById(R.id.weightNumber);
        weight++;
        weightNumber.setText(Integer.toString(weight));
    }

    public void onCalculateButtonClick(View view) {
        TextInputEditText highHalf = findViewById(R.id.higherHalfText);
        TextInputEditText lowHalf = findViewById(R.id.lowerHalfText);
        Switch unit = findViewById(R.id.unitSwitch);
        double heightInMeter;
        if (unit.isChecked()) {
            heightInMeter = (Float.parseFloat((highHalf.getEditableText().toString())) * 0.3048) + (Float.parseFloat((lowHalf.getEditableText().toString())) * 0.0254);
        } else
            heightInMeter = (Float.parseFloat((highHalf.getEditableText().toString()))) + (Float.parseFloat((lowHalf.getEditableText().toString())) * 0.01);
        double BMI = weight / (heightInMeter * heightInMeter);
        System.out.println(weight);
        System.out.println(heightInMeter);
        String message;
        if (BMI < 18.5) {
            message ="Underweight.";
        } else if (18.5 <= BMI  &&  BMI < 24.9)
        {
            message="Normal";
        } else if (25 <= BMI && BMI < 29.9)
        {
            message = "Overweight.";
        }
        else message ="Obese";

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}