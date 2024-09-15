package com.duytai.btcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_calculate;
    private EditText edt_a;
    private EditText edt_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        btn_calculate = findViewById(R.id.btn_calculate);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = edt_a.getText().toString();
                String strB = edt_b.getText().toString();

                if(!strA.isEmpty() || !strB.isEmpty()){
                    if(strA.length() < 8 && strB.length() < 8){
                        int a = Integer.parseInt(strA);
                        int b = Integer.parseInt(strB);
                        int result = a + b;

                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                        intent.putExtra("a", a);
                        intent.putExtra("b", b);
                        intent.putExtra("result", result);

                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị nhỏ hơn", Toast.LENGTH_LONG).show();;
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Vui lòng nhập a & b",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}