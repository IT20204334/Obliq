package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationFee extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button calculate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_fee);

        et1 = (EditText) findViewById(R.id.et_theory);
        et2 = (EditText) findViewById(R.id.et_revision);
        et3 = (EditText) findViewById(R.id.et_paper);
        result = (TextView) findViewById(R.id.result_fee);
        calculate = (Button) findViewById(R.id.btn_regfee);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*if(!et1.getText().toString().trim().startsWith("1000")){
                    Toast.makeText(RegistrationFee.this,"Number invalid",Toast.LENGTH_SHORT).show();
                }
                if(!et2.getText().toString().trim().startsWith("1000")){
                    Toast.makeText(RegistrationFee.this,"Number invalid",Toast.LENGTH_SHORT).show();
                }
                if(!et3.getText().toString().trim().startsWith("1000")){
                    Toast.makeText(RegistrationFee.this,"Number invalid",Toast.LENGTH_SHORT).show();
                }*/
              if(et1.getText().toString().length() == 0){
                    et1.setText("1000");
                }
                if(et2.getText().toString().length() == 0){
                    et2.setText("1000");
                }
                if(et3.getText().toString().length() == 0){
                    et3.setText("1000");
                }
                    int number1 = Integer.parseInt(et1.getText().toString());
                    int number2 = Integer.parseInt(et2.getText().toString());
                    int number3 = Integer.parseInt(et3.getText().toString());
                    int add = number1 + number2 + number3;
                    result.setText(String.valueOf(add));

                }
        });
    }

   public static int btn_regfee(int number1, int number2, int number3) {
        int add = number1 + number2 + number3;
        return add;
    }
}