package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_pay extends AppCompatActivity {

    TextView Add_pay;
    add_pay payment;
    Payment pay;
    EditText Card_NO, CVV_Card, Expire_date, et_stuname, et_stuID, et_Subject;
    RadioButton Visa_card, master_card;
    Button btn_addp;
    DatabaseReference ref;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pay);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("some") != null) {
                Toast.makeText(getApplicationContext(), "data:" + bundle.getString("some"), Toast.LENGTH_SHORT).show();
            }
        }


        et_stuID = findViewById(R.id.et_stuID);
        et_stuname = findViewById(R.id.et_stuname);
        Card_NO = findViewById(R.id.Card_NO);
        CVV_Card = findViewById(R.id.CVV_Card);
        Expire_date = findViewById(R.id.Expire_date);
        btn_addp = findViewById(R.id.btn_addp);
        Visa_card = findViewById(R.id.Visa_card);
        master_card = findViewById(R.id.master_card);
        et_Subject = findViewById(R.id.et_Subject);
        pay = new Payment();

        ref = database.getInstance().getReference().child("Payment");


        btn_addp.setOnClickListener(view -> {
            pay.setStuID(et_stuID.getText().toString().trim());
            if(et_stuID.getText().toString().trim().isEmpty()){
                Toast.makeText(add_pay.this,"required to enter the student ID",Toast.LENGTH_SHORT).show();
            }
            else if(!et_stuID.getText().toString().trim().startsWith("I")){
                Toast.makeText(add_pay.this,"Invalid student ID",Toast.LENGTH_SHORT).show();
            }
            else if(Card_NO.getText().toString().trim().isEmpty() || CVV_Card.getText().toString().trim().isEmpty() ||
                    et_Subject.getText().toString().trim().isEmpty()){
                Toast.makeText(add_pay.this,"These fields are required",Toast.LENGTH_SHORT).show();
            }
            else {
                String pID = pay.getStuID();
                pay.setName(et_stuname.getText().toString().trim());
                String pname = pay.getName();
                pay.setCardNumber(Card_NO.getText().toString().trim());
                String pcard = pay.getCardNumber();
                pay.setCVV(CVV_Card.getText().toString().trim());
                String pcvv = pay.getCVV();
                pay.setExpirydate(Expire_date.getText().toString().trim());
                String pexpire = pay.getExpirydate();
                pay.setSubject(et_Subject.getText().toString().trim());
                String psub = pay.getSubject();
                String m1 = Visa_card.getText().toString().trim();
                String m2 = master_card.getText().toString().trim();

                if (Visa_card.isChecked()) {
                    pay.setCardtype(m1);
                } else {
                    pay.setCardtype(m2);
                }

                ref.push().getKey();
                Payment payment = new Payment(pname, pcard, pcvv, pexpire, psub);
                ref.child(pID).setValue(pay);
                Toast.makeText(add_pay.this, "Payment details added successfully", Toast.LENGTH_SHORT).show();

                clearAll();
                }

        });
    }


    private void clearAll(){
       et_stuID.setText("");
        et_stuname.setText("");
        Card_NO.setText("");
       CVV_Card.setText("");
        Expire_date.setText("");
       et_Subject.setText("");
    }



}