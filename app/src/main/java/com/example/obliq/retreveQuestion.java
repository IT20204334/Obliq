package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class retreveQuestion extends AppCompatActivity {

    ListView hLisview;
    List<Question> questionList;

    DatabaseReference questionDbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreve_question);

        hLisview = findViewById(R.id.hListView);
        questionList = new ArrayList<>();

        questionDbRef = FirebaseDatabase.getInstance().getReference("Question");

        questionDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionList.clear();



                for(DataSnapshot questionDatasnap : dataSnapshot.getChildren()){

                    Question question = questionDatasnap.getValue(Question.class);
                    questionList.add(question);
                }

                ListAdapter2 adapter = new ListAdapter2(retreveQuestion.this,questionList);
                hLisview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}