package com.example.obliq;



import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity2 extends AppCompatActivity {
    EditText etName, etID, etSubject, etDate, etNotice;
    Button btn_add, btn_deleteno, btn_updatenotice;
    DatabaseReference dbref;
    Ntice ntice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = (EditText) findViewById(R.id.et_name);
        etID = (EditText) findViewById(R.id.et_id);
        etSubject = (EditText) findViewById(R.id.et_subject);
        etDate = (EditText) findViewById(R.id.et_date);
        etNotice = (EditText) findViewById(R.id.et_notice);
        btn_add = (Button) findViewById(R.id.bt_add);
        btn_updatenotice = (Button) findViewById(R.id.btn_updatenotice);
        btn_deleteno = (Button) findViewById(R.id.btn_deleteno);
        ntice = new Ntice();
        dbref = FirebaseDatabase.getInstance("https://obliq-4bef4-default-rtdb.firebaseio.com/").getReference().child("Ntice");
        btn_add.setOnClickListener(view -> {
            ntice.setName(etName.getText().toString().trim());
            String Name = ntice.getName();
            ntice.setID(etID.getText().toString().trim());
            String ID = ntice.getID();
            ntice.setSubject(etSubject.getText().toString().trim());
            String Subject = ntice.getSubject();
            ntice.setDate(etDate.getText().toString().trim());
            String Date = ntice.getDate();
            ntice.setNotice(etNotice.getText().toString().trim());
            String Notice = ntice.getNotice();
            dbref.push().getKey();
            Ntice ntice = new Ntice(Name, Subject, Date, Notice);

            dbref.child(ID).setValue(ntice);
            Toast.makeText(MainActivity2.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
            clearAll();

        });

        btn_deleteno.setOnClickListener(view -> {
            ntice.setID(etID.getText().toString().trim());
            String ID = ntice.getID();
            deleteNtice(ID);
        });


        btn_updatenotice.setOnClickListener(view ->

        {
            ntice.setName(etName.getText().toString().trim());
            String Name = ntice.getName();
            ntice.setID(etID.getText().toString().trim());
            String ID = ntice.getID();
            ntice.setSubject(etSubject.getText().toString().trim());
            String Subject = ntice.getSubject();
            ntice.setDate(etDate.getText().toString().trim());
            String Date = ntice.getDate();
            ntice.setNotice(etNotice.getText().toString().trim());
            String Notice = ntice.getNotice();
            updateNtice(Name, ID, Subject, Date, Notice);


        });
    }

    public void clearAll(){
        etName.setText("");
        etID.setText("");
        etSubject.setText("");
        etDate.setText("");
        etNotice.setText("");
    }

    public void deleteNtice(String ID) {
        dbref = FirebaseDatabase.getInstance().getReference().child("Ntice").child(ID);
        dbref.removeValue();

        Toast.makeText(MainActivity2.this, "Notice deleted Successfully", Toast.LENGTH_LONG).show();
        clearAll();
    }

    public void updateNtice(String Name, String ID, String Subject, String Date,String Notice) {
        dbref = FirebaseDatabase.getInstance().getReference().child("Ntice").child(ID);
        Ntice ntice = new Ntice(Name, Subject, Date, Notice);
        dbref.setValue(ntice);
        Toast.makeText(MainActivity2.this, "Notice updated Successfully", Toast.LENGTH_LONG).show();
        clearAll();

    }
}


