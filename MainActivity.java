package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputFirst, inputSecond;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirst = findViewById(R.id.input_first);
        inputSecond = findViewById(R.id.input_second);
        txtResult = findViewById(R.id.txt_result);

        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSubtract = findViewById(R.id.btn_subtract);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSubtract.setOnClickListener(v -> calculate('-'));
        btnMultiply.setOnClickListener(v -> calculate('*'));
        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String firstInput = inputFirst.getText().toString();
        String secondInput = inputSecond.getText().toString();

        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            txtResult.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(firstInput);
        double num2 = Double.parseDouble(secondInput);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    txtResult.setText("Cannot divide by zero");
                    return;
                }
                break;
        }
        txtResult.setText("Hasil: " + result);
    }
}