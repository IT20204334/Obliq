package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    //create object of DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://obliq-676e0-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullName = findViewById(R.id.registerName);
        final EditText email = findViewById(R.id.registerMail);
        final EditText phone = findViewById(R.id.registerMobile);
        final EditText password = findViewById(R.id.registerPassword);
        final EditText confirmPassword = findViewById(R.id.registerConfirmPw);
        final Button registerBtn = findViewById(R.id.registerCreatebtn);
        final CheckBox isTeacherBox = findViewById(R.id.teacherCheckbox);
        final CheckBox isStudentBox = findViewById(R.id.studentCheckbox);

        //check boxes logic
        isStudentBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if(compoundButton.isChecked()){
                isTeacherBox.setChecked(false);
            }
        });
        isTeacherBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if(compoundButton.isChecked()){
                isStudentBox.setChecked(false);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //get data from editTexts into string variables
                final String fullNameTxt = fullName.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String confirmPasswordTxt = confirmPassword.getText().toString();
                final String isTeacherBoxBtn = isTeacherBox.getText().toString();
                final String isStudentBoxBtn = isStudentBox.getText().toString();

                //check if user fill all the fields before sending data to firebase
                if(fullNameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Register.this,"Please fill all the fields.", Toast.LENGTH_SHORT).show();
                }

                //check box validation
                if(!(isTeacherBox.isChecked() || isStudentBox.isChecked())){
                    Toast.makeText(Register.this,"Select the account type", Toast.LENGTH_SHORT).show();
                    return;
                }

                //CHECK IF PASSWORD ARE MATCHING WITH EACH OTHER
                //if not matching each other then show a toast message
                else if(!passwordTxt.equals(confirmPasswordTxt)){
                    Toast.makeText(Register.this,"Passwords are not matching.", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //check if phone is not registered before

                            if(snapshot.hasChild(phoneTxt)){
                                Toast.makeText(Register.this,"Phone Number is already registered.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                //sending data to firebase Realtime Database.
                                //we are using phone number as unique identity of every user.
                                //so all the other details of user comes under phone number.
                                databaseReference.child("users").child(phoneTxt).child("fullName").setValue(fullNameTxt);
                                databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(phoneTxt).child("phone").setValue(phoneTxt);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);

                                if(isTeacherBox.isChecked()){
                                    databaseReference.child("users").child(phoneTxt).child("isTeacherBox").setValue(isTeacherBoxBtn);
                                }
                                if(isStudentBox.isChecked()){
                                    databaseReference.child("users").child(phoneTxt).child("isStudentBox").setValue(isStudentBoxBtn);
                                }

                                if(isTeacherBox.isChecked()){
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                }
                                if(isStudentBox.isChecked()){
                                    startActivity(new Intent(getApplicationContext(),Calculations.class));
                                    finish();
                                }

                                //show a success message then finish the activity
                                Toast.makeText(Register.this,"Registered Successfully...", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });


    }

}