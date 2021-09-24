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

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;

public class retreveActivity extends AppCompatActivity {

    ListView myLisview;
    List<Ntice> nticeList;

    DatabaseReference nticeDbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreve);

        myLisview = findViewById(R.id.myListView);
        nticeList = new ArrayList<>();

        nticeDbRef = FirebaseDatabase.getInstance().getReference("Ntice");

        nticeDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nticeList.clear();



                for(DataSnapshot nticeDatasnap : dataSnapshot.getChildren()){

                    Ntice ntice = nticeDatasnap.getValue(Ntice.class);
                    nticeList.add(ntice);
                }

                ListAdapter1 adapter = new ListAdapter1(retreveActivity.this,nticeList);
                myLisview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}