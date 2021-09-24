package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

public class Calculatefee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatefee);
    }

    public void onButtonClick(View view){
        EditText e1 = (EditText) findViewById(R.id.et_name);
        EditText e2 = (EditText) findViewById(R.id.No_days);
        EditText e3 = (EditText) findViewById(R.id.day_fee);
        TextView t1= (TextView) findViewById(R.id.Class_fee);
        int multiply = calClassFee(Integer.parseInt(e2.getText().toString()),Integer.parseInt(e3.getText().toString()));
        t1.setText(Integer.toString(multiply));

    }

    public static int calClassFee(int num1, int num2){
        int multiply = num1 * num2;
        return multiply;
    }
}