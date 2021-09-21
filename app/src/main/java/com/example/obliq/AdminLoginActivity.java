package com.example.obliq;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    EditText etAdminPwd;
    Button btnAdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etAdminPwd = (EditText)findViewById(R.id.etAdminPwd);
        btnAdminLogin = (Button) findViewById(R.id.btnAdminLogin);

        btnAdminLogin.setOnClickListener(view -> {
            String pwd = "obliq123";
            if(etAdminPwd.getText().toString().equals(pwd)){
                Intent intent = new Intent(this,ManageActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(AdminLoginActivity.this, "Invalid password. You do not have access.", Toast.LENGTH_LONG).show();
            }
        });

    }
}
