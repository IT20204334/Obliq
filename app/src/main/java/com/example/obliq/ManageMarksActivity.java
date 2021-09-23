package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManageMarksActivity extends AppCompatActivity {

    EditText etStudentID, etPhysics, etChemistry, etBioMaths, etAverage;
    Button addMarksBtn, updateMarksBtn, deleteMarksBtn, btnShowAvg;
    DatabaseReference dbref;
    Marks marks;
    /*long maxid=0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_marks);
        etStudentID = (EditText) findViewById(R.id.etStudentID);
        etPhysics = (EditText)findViewById(R.id.etPhysics);
        etChemistry = (EditText)findViewById(R.id.etChemistry);
        etBioMaths = (EditText)findViewById(R.id.etBioMaths);
        etAverage = (EditText)findViewById(R.id.etAverage);
        btnShowAvg = (Button) findViewById(R.id.btnShowAvg);
        addMarksBtn = (Button) findViewById(R.id.addMarksBtn);
        updateMarksBtn = (Button) findViewById(R.id.updateMarksBtn);
        deleteMarksBtn = (Button) findViewById(R.id.deleteMarksBtn);

        marks = new Marks();
        dbref = FirebaseDatabase.getInstance().getReference().child("Marks");
        /*dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


        addMarksBtn.setOnClickListener(view -> {
                marks.setStudentID(etStudentID.getText().toString().trim());
                if(etStudentID.getText().toString().trim().isEmpty()){
                    Toast.makeText(ManageMarksActivity.this, "Failed to input data. Cannot enter marks without student ID.", Toast.LENGTH_SHORT).show();
                }
                else if(!etStudentID.getText().toString().trim().startsWith("s")){
                    Toast.makeText(ManageMarksActivity.this, "Student ID invalid.", Toast.LENGTH_SHORT).show();
                }
                else {
                    String sid = marks.getStudentID();
                    Double physics = Double.parseDouble(etPhysics.getText().toString());
                    marks.setPhysics(physics);
                    Double chemistry = Double.parseDouble(etChemistry.getText().toString());
                    marks.setChemistry(chemistry);
                    Double biomaths = Double.parseDouble(etBioMaths.getText().toString());
                    marks.setBioMaths(biomaths);
                    addMarks(sid, physics, chemistry, biomaths);
                }

        });

       /*deleteMarksBtn.setOnClickListener(view ->{
            marks.setStudentID(etStudentID.getText().toString().trim());
            String sid = marks.getStudentID();
            deleteMarks(sid);

        });*/

        deleteMarksBtn.setOnClickListener(view -> {
            marks.setStudentID(etStudentID.getText().toString().trim());
            String sid = marks.getStudentID();

            //dbref = FirebaseDatabase.getInstance().getReference();
            DatabaseReference sidReference = FirebaseDatabase.getInstance().getReference().child("Marks").child(sid);
            //DatabaseReference sidReference = marks.child("Users").child("Nick123");
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        deleteMarks(sid);
                    }else{
                        Toast.makeText(ManageMarksActivity.this, "Deletion failed. Student ID does not exist", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            };
            sidReference.addListenerForSingleValueEvent(eventListener);
        });

       updateMarksBtn.setOnClickListener(view ->{
           marks.setStudentID(etStudentID.getText().toString().trim());
           String sid = marks.getStudentID();
           if(etStudentID.getText().toString().trim().isEmpty()){
               Toast.makeText(ManageMarksActivity.this, "Enter student ID to update marks.", Toast.LENGTH_SHORT).show();
           }else {
               Double physics = Double.parseDouble(etPhysics.getText().toString());
               marks.setPhysics(physics);
               Double chemistry = Double.parseDouble(etChemistry.getText().toString());
               marks.setChemistry(chemistry);
               Double biomaths = Double.parseDouble(etBioMaths.getText().toString());
               marks.setBioMaths(biomaths);
               /*marks.setAverage(physics, chemistry, biomaths);
               Double average = marks.getAverage();*/
               updateMarks(sid, physics, chemistry, biomaths);
           }
       });

       btnShowAvg.setOnClickListener(view ->{
           if(!etPhysics.getText().toString().trim().isEmpty()){
               if(!etChemistry.getText().toString().trim().isEmpty()){
                   if(!etBioMaths.getText().toString().trim().isEmpty()){
                       Double physics = Double.parseDouble(etPhysics.getText().toString());
                       Double chemistry = Double.parseDouble(etChemistry.getText().toString());
                       Double biomaths = Double.parseDouble(etBioMaths.getText().toString());
                       double avg = calcStudentAverage(physics, chemistry, biomaths);
                       String avgString = Double.toString(avg);
                       etAverage.setText(avgString);
                   }
                   else{
                       Toast.makeText(ManageMarksActivity.this, "Please enter values for all 3 marks.", Toast.LENGTH_SHORT).show();
                   }
               }
               else{
                   Toast.makeText(ManageMarksActivity.this, "Please enter values for all 3 marks..", Toast.LENGTH_SHORT).show();
               }
           }
           else{
               Toast.makeText(ManageMarksActivity.this, "Please enter values for all 3 marks..", Toast.LENGTH_SHORT).show();
           }

       });




    }

    public void addMarks(String sid, Double physics, Double chemistry, Double biomaths){
            dbref.push().getKey();
            Marks marks = new Marks(sid, physics, chemistry, biomaths);
            dbref.child(sid).setValue(marks);
            Toast.makeText(ManageMarksActivity.this, "Data inserted successfully.", Toast.LENGTH_LONG).show();
            clearAll();
    }

    public void deleteMarks(String sid){
            dbref = FirebaseDatabase.getInstance().getReference().child("Marks").child(sid);
            dbref.removeValue();
            Toast.makeText(ManageMarksActivity.this, "Data deleted successfully", Toast.LENGTH_LONG).show();
            clearAll();
    }

    public void updateMarks(String sid, Double physics, Double chemistry, Double biomaths){
            dbref = FirebaseDatabase.getInstance().getReference().child("Marks").child(sid);
            dbref.setValue(marks);
            Toast.makeText(ManageMarksActivity.this, "Marks updated successfully", Toast.LENGTH_LONG).show();
            clearAll();
    }

    public static double calcStudentAverage(double physics, double chemistry, double biomaths){
        double avg = (physics + chemistry + biomaths) / 3.0;
        //String avgString = Double.toString(avg);
        //etAverage.setText(avgString);
        return avg;
    }

    public void clearAll(){
        etStudentID.setText("");
        etPhysics.setText("");
        etChemistry.setText("");
        etBioMaths.setText("");
        etAverage.setText("");
    }






}