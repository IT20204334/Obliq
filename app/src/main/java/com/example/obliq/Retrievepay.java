package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;

public class Retrievepay extends AppCompatActivity {

    ListView myView;
    List<Payment> paymentList;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrievepay);

        myView = findViewById(R.id.myView);
        paymentList = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("Payment");

        ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    paymentList.clear();

                    for (DataSnapshot paymentDatasnap : dataSnapshot.getChildren()) {
                        Payment payment = paymentDatasnap.getValue(Payment.class);
                        paymentList.add(payment);
                    }

                    view_pay adapter = new view_pay(Retrievepay.this, paymentList);
                    myView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


}