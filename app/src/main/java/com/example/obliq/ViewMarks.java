package com.example.obliq;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewMarks extends AppCompatActivity {

    ListView myListView;
    List<Marks> marksList;
    DatabaseReference marksDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);

        myListView = findViewById(R.id.myListView);
        marksList = new ArrayList<>();

        marksDbRef = FirebaseDatabase.getInstance().getReference("Marks");

        marksDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                marksList.clear();

                for(DataSnapshot marksDatasnap : dataSnapshot.getChildren()){
                    Marks marks = marksDatasnap.getValue(Marks.class);
                    marksList.add(marks);

                }

                ListAdapter adapter = new ListAdapter(ViewMarks.this, marksList);
                myListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
