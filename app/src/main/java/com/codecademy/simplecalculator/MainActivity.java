package com.codecademy.simplecalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText firstNumber = findViewById(R.id.number1);
        EditText secondNumber = findViewById(R.id.number2);
        RadioGroup operators = findViewById(R.id.operators);
        RadioButton add = findViewById(R.id.add);
        RadioButton subtract = findViewById(R.id.subtract);
        RadioButton multiply = findViewById(R.id.multiply);
        RadioButton divide = findViewById(R.id.divide);
        Button equals = findViewById(R.id.equals);
        TextView result = findViewById(R.id.result);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()){
                    result.setText("Please enter both numbers");
                    return;
                }
                int firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
                int secondNumberValue = Integer.parseInt(secondNumber.getText().toString());
                int operatorButtonId = operators.getCheckedRadioButtonId();
                Integer answer;
                if(operatorButtonId == add.getId()){
                    answer = firstNumberValue + secondNumberValue;
                    result.setText(answer.toString());
                } else if(operatorButtonId == subtract.getId()){
                    answer = firstNumberValue - secondNumberValue;
                    result.setText(answer.toString());
                }
                else if(operatorButtonId == multiply.getId()){
                    answer = firstNumberValue * secondNumberValue;
                    result.setText(answer.toString());
                }
                else{
                    answer = firstNumberValue / secondNumberValue;
                    result.setText(answer.toString());
                }
            }
        });
    }
}