package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Calculations extends AppCompatActivity {

    CheckBox theoryCheckbox, revisionCheckbox, paperCheckbox;
    Button btnCheck, confirm;
    TextView answer;
    int count;
    static int tFee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);

        theoryCheckbox = (CheckBox) findViewById(R.id.theoryCheckbox);
        revisionCheckbox = (CheckBox) findViewById(R.id.revisionCheckbox);
        paperCheckbox = (CheckBox) findViewById(R.id.paperCheckbox);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        answer = (TextView) findViewById(R.id.answer);
         confirm = (Button)findViewById(R.id.confirm);


        btnCheck.setOnClickListener(view -> {
            if (theoryCheckbox.isChecked()) {
                count = 1;
                if (revisionCheckbox.isChecked()) {
                    count = 2;
                    if (paperCheckbox.isChecked()) {
                        count = 3;
                    }
                }
            }
            else if(revisionCheckbox.isChecked()) {
                    count = 1;
                    if (paperCheckbox.isChecked()) {
                        count = 2;
                        if (theoryCheckbox.isChecked()) {
                            count = 3;
                        }
                    }
                }
            else if(paperCheckbox.isChecked()) {
                    count = 1;
                    if (theoryCheckbox.isChecked()) {
                        count = 2;
                        if (revisionCheckbox.isChecked()) {
                            count = 3;
                        }
                    }
                }
                else{
                   tFee = 0;
                Toast.makeText(Calculations.this,"Select checkbox to calculate registration fee",Toast.LENGTH_SHORT).show();
                }
                calcRegFee(count);
                calcRegistrationFee(tFee);

        });

        confirm.setOnClickListener(view -> {
            clearAll();
            startActivity(new Intent(Calculations.this,MainActivity.class));
        });

    }

    public static int calcRegFee(int count) {
        if (count == 1) {
            tFee = 500;
        }
        else if (count == 2)
        {
            tFee = tFee+1000;
        }
        else if (count == 3) {
            tFee = tFee+1500;
        }
        else{
          // Toast.makeText(Calculations.this,"select checkbox to calculate registration fee",Toast.LENGTH_SHORT).show();
            }
        return tFee;
    }


    public void calcRegistrationFee(Integer tFee) {
        answer.setText("" + tFee);


    }
   public void clearAll(){
       answer.setText("");
   }




}



