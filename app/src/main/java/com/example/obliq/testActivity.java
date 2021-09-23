package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class testActivity extends AppCompatActivity {

    CheckBox chkTheory, chkPapers, chkRevision;
    Button btnCalcRegFee, btnConfirm;
    EditText etRegFee;
    static int tFee;
        int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        chkTheory = (CheckBox)findViewById(R.id.chkTheory);
        chkPapers = (CheckBox)findViewById(R.id.chkPapers);
        chkRevision = (CheckBox)findViewById(R.id.chkRevision);
        btnCalcRegFee = (Button)findViewById(R.id.btnCalcRegFee);
        btnConfirm = (Button)findViewById(R.id.btnConfirm);
        etRegFee = (EditText)findViewById(R.id.etRegFee);

        btnCalcRegFee.setOnClickListener(view ->{
            if(chkTheory.isChecked()){
               count = 1;
               if(chkPapers.isChecked()){
                   count = 2;
                if(chkRevision.isChecked()){
                    count = 3;
                }
               }
               else if(chkPapers.isChecked()) {
                   count = 1;
                   if (chkRevision.isChecked()) {
                       count = 2;
                       if (chkTheory.isChecked()) {
                           count = 3;
                       }
                   }
               }else if(chkRevision.isChecked()) {
                   count = 1;
                   if (chkTheory.isChecked()) {
                       count = 2;
                       if (chkPapers.isChecked()) {
                           count = 3;
                       }
                   }
               }
            }
            calcRegFee(count);
            calcRegistrationFee(tFee);

        });

        btnConfirm.setOnClickListener(view -> {
            clearAll();
        });
    }

    public void calcRegistrationFee(Integer tFee){
        etRegFee.setText("Registration Fee: " + tFee);
    }



    public static int calcRegFee(int count){
        if(count == 1){
            tFee = 500;
        }
        else if(count == 2){
            tFee = 1000;
        }
        else if(count == 3){
            tFee = 1500;
        }
        else{
            //Toast.makeText(testActivity.this, "Select checkboxes to calculate registration fee.", Toast.LENGTH_SHORT).show();
        }
        return tFee;
    }

    public void clearAll(){
        etRegFee.setText("");
    }
}