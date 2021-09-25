package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManageActivity extends AppCompatActivity {

    Button marksBtn;
    Button addNoticeBtn;
    Button btn_newhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        marksBtn = (Button) findViewById(R.id.marksBtn);
        addNoticeBtn = (Button)findViewById(R.id.addNoticeBtn);
        btn_newhome = (Button)findViewById(R.id.btn_newhome);

        marksBtn.setOnClickListener(view -> {
            openManageMarks();
        });

        addNoticeBtn.setOnClickListener(view -> {
            openNotices();
        });

        btn_newhome.setOnClickListener(view -> {
            openHome();
        });



    }

    public void openManageMarks(){
        Intent intent = new Intent(this,ManageMarksActivity.class);
        startActivity(intent);
    }

    public void openNotices(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}