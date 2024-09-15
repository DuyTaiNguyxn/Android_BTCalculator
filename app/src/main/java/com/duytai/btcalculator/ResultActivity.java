package com.duytai.btcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private TextView tv_expression;
    private TextView tv_result;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        tv_expression = findViewById(R.id.tv_expression);
        tv_result = findViewById(R.id.tv_result);
        btn_back = findViewById(R.id.btn_back);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int a = intent.getIntExtra("a",0);
        int b = intent.getIntExtra("b",0);
        int result = intent.getIntExtra("result",0);

        String expression = String.valueOf(a) + " + " + String.valueOf(b) +" =";
        String strResult = String.valueOf(result);
        tv_expression.setText(expression);
        tv_result.setText(strResult);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}