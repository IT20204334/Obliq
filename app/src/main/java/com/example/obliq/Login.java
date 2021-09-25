package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://obliq-4bef4-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText phone = findViewById(R.id.loginMobile);
        final EditText password = findViewById(R.id.loginPassword);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final Button gotoRegister = findViewById(R.id.gotoRegister);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Login.this,"Please enter your Phone Number or Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //check if phone is exist in firebase database
                            if(snapshot.hasChild(phoneTxt)){

                                //phone is exist in firebase database
                                //now get password of user from firebase data and match it with user entered password

                                final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);

                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(Login.this,"Successfully Logged in", Toast.LENGTH_SHORT).show();

                                    //user is teacher
                                   if(snapshot.child("isTeacher") != null){
                                       startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                       finish();
                                   }
                                    //user is student
                                    if(snapshot.child("isStudent") != null){
                                       startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                       finish();
                                    }

                                }
                                else{
                                    Toast.makeText(Login.this,"Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this,"Wrong Phone Number", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //open register activity
                startActivity(new Intent(Login.this,Register.class));
            }
        });

    }
}