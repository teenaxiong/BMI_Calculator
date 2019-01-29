/*

Teena Xiong
 */


package com.example.android.inclass2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText weightInputVal;
    EditText heightInputFeetVal;
    EditText heightInputInchesVal;
    Button submitButton;
    TextView resultValue;
    TextView resultStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI Calculator");

        weightInputVal = findViewById(R.id.weightInput);
        heightInputFeetVal = findViewById(R.id.heightInputFeet);
        heightInputInchesVal = findViewById(R.id.heightInputInches);
        submitButton = findViewById(R.id.buttonCalculateBMI);
        resultValue = findViewById(R.id.result);
        resultStatus = findViewById(R.id.status);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String weightString = weightInputVal.getText().toString();
                String heightFeetString = heightInputFeetVal.getText().toString();
                String heightInchesString = heightInputInchesVal.getText().toString();
                if(weightString.equals("") ){
                    weightInputVal.setError("Enter a number");
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else if (heightFeetString.equals("")){
                    heightInputFeetVal.setError("Enter a number");
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else if(heightInchesString.equals("")) {
                    heightInputInchesVal.setError("Enter a number");
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else {
                    double userWeight = Double.parseDouble(weightInputVal.getText().toString());
                    double userHeightFeetToInches = Double.parseDouble(heightInputFeetVal.getText().toString()) * 12;
                    double userHeightInches = Double.parseDouble(heightInputInchesVal.getText().toString());

                    double totalHeight = userHeightFeetToInches + userHeightInches;
                    double result = (userWeight / (totalHeight * totalHeight)) * 703;

                    resultValue.setText("Your BMI: " +  String.format("%.2f", result) );

                    if(result <18.5){
                        resultStatus.setText("You are underweight.");
                    }else if(result >=18.5 && result<=24.9){
                        resultStatus.setText("You are at a normal weight.");
                    }else if(result >=25 && result<=29.9){
                        resultStatus.setText("You are overweight.");
                    }else if(result >=30){
                        resultStatus.setText("You are Obese.");
                    }

                    Toast toast = Toast.makeText(getApplicationContext(), "BMI CALCULATED", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });



    }
}
