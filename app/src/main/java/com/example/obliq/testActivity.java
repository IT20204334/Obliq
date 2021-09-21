package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class testActivity extends AppCompatActivity {

    CheckBox chkTheory, chkPapers, chkRevision;
    Button btnCalcRegFee;
    EditText etRegFee;
    Integer tFee, pFee, rFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        chkTheory = (CheckBox)findViewById(R.id.chkTheory);
        chkPapers = (CheckBox)findViewById(R.id.chkPapers);
        chkRevision = (CheckBox)findViewById(R.id.chkRevision);
        btnCalcRegFee = (Button)findViewById(R.id.btnCalcRegFee);
        etRegFee = (EditText)findViewById(R.id.etRegFee);

        btnCalcRegFee.setOnClickListener(view ->{
            if(chkTheory.isChecked()){
                tFee = 500;
                if(chkPapers.isChecked()){
                    tFee = 1000;
                    if(chkRevision.isChecked()){
                        tFee = 1500;
                    }
                }
            }
            else if(chkPapers.isChecked()){
                pFee=500;
                if(chkRevision.isChecked()){
                    tFee = 1000;
                    if(chkTheory.isChecked()){
                        tFee = 1500;
                    }
                }
            }
            else if(chkRevision.isChecked()){
                tFee = 500;
                if(chkTheory.isChecked()){
                    tFee = 1000;
                    if(chkPapers.isChecked()){
                        tFee = 1500;
                    }
                }
            }
            else{
                tFee = 0;
            }
            calcRegistrationFee(tFee);
        });
    }

    public void calcRegistrationFee(Integer tFee){
        etRegFee.setText("Registration Fee: " + tFee);
    }
}