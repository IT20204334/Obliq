package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CalPapers extends AppCompatActivity {

    CheckBox cb_1, cb_2, cb_3, cb_4;
    Button bt_total,bt_order;
    EditText et_23;
    Integer tFee, pFee, rFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_papers);



        cb_1 = (CheckBox)findViewById(R.id.cb_1);
        cb_2 = (CheckBox)findViewById(R.id.cb_2);
        cb_3 = (CheckBox)findViewById(R.id.cb_3);
        cb_4 = (CheckBox)findViewById(R.id.cb_4);
        bt_total = (Button)findViewById(R.id.bt_total);
        bt_order = (Button)findViewById(R.id.bt_order);
        et_23 = (EditText)findViewById(R.id.et_23);

        bt_total.setOnClickListener(view ->{
            if(cb_1.isChecked()){
                tFee = 700;
                if(cb_2.isChecked()){
                    tFee = tFee+700;
                    if(cb_3.isChecked()){
                        tFee = tFee+700;
                        if(cb_4.isChecked()){
                            tFee = tFee+700;
                        }
                    }
                }
            }
            else if(cb_2.isChecked()){
                tFee=700;
                if(cb_3.isChecked()){
                    tFee = tFee+700;
                    if(cb_4.isChecked()){
                        tFee = tFee+700;
                        if(cb_1.isChecked()){
                            tFee = tFee+700;
                        }
                    }
                }
            }
            else if(cb_3.isChecked()){
                tFee = 700;
                if(cb_4.isChecked()){
                    tFee = tFee+700;
                    if(cb_1.isChecked()){
                        tFee = tFee+700;
                        if(cb_2.isChecked()){
                            tFee = tFee+700;
                        }
                    }
                }
            }
            else if(cb_4.isChecked()) {
                tFee = 700;
                if (cb_1.isChecked()) {
                    tFee = tFee+700;
                    if (cb_2.isChecked()) {
                        tFee = tFee+700;
                        if (cb_3.isChecked()) {
                            tFee = tFee+700;
                        }
                    }
                }
            }

            else{
                tFee = 0;
            }
            calcPapersFee(tFee);
        });

      //  bt_order.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
          //      FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
           //     fragmentTransaction.replace(R.id.homeContener,new HomeFragment()).commit();
          //  }
       // });

    }



    public void calcPapersFee(Integer tFee){
        et_23.setText("Papers Fee: " + tFee);
    }
}