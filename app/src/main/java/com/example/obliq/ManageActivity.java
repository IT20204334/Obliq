package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManageActivity extends AppCompatActivity {

    Button marksBtn;
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        marksBtn = (Button) findViewById(R.id.marksBtn);
        regBtn = (Button)findViewById(R.id.addNoticeBtn);

        marksBtn.setOnClickListener(view -> {
            openManageMarks();
        });

        regBtn.setOnClickListener(view -> {
            openTestActivity();
        });

    }

    public void openManageMarks(){
        Intent intent = new Intent(this,ManageMarksActivity.class);
        startActivity(intent);
    }

    public void openTestActivity(){
        Intent intent = new Intent(this,testActivity.class);
        startActivity(intent);
    }
}