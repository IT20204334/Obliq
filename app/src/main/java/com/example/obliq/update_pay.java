package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update_pay extends AppCompatActivity {

    EditText stu_name,Card_nu,stuu_ID,expir_date,et_CVV,etSubject;
    RadioButton Visa_card,master_card;
    DatabaseReference ref;
    FirebaseDatabase database;
    Payment pay;
    Button update_paym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pay);
        stu_name =findViewById(R.id.et_stuname);
        Card_nu = findViewById(R.id.Card_nu);
        stuu_ID=findViewById(R.id.stuu_ID);
        update_paym =findViewById(R.id.update_paym);
        Visa_card=findViewById(R.id.Visa_card);
        master_card=findViewById(R.id.master_card);
        expir_date = findViewById(R.id.expir_date);
        et_CVV = findViewById(R.id.et_CVV);
        etSubject = findViewById(R.id.etSubject);
        pay=new Payment();

        ref = database.getInstance().getReference().child("Payment");

        update_paym.setOnClickListener(view -> {
            pay.setStuID(stuu_ID.getText().toString().trim());
            String pID = pay.getStuID();
            if(stuu_ID.getText().toString().trim().isEmpty()){
                Toast.makeText(update_pay.this,"ID is required",Toast.LENGTH_SHORT).show();
            }
            else if(Card_nu.length()!=6){
                Toast.makeText(update_pay.this,"card no should have 6 numbers",Toast.LENGTH_SHORT).show();
            }
            else if(stuu_ID.length()!=4){
                Toast.makeText(update_pay.this,"Stu ID has 4 characters",Toast.LENGTH_SHORT).show();
            }
            else if(et_CVV.length()!=3){
                Toast.makeText(update_pay.this,"CVV has 3 numbers",Toast.LENGTH_SHORT).show();
            }
            else{
                pay.setName(stu_name.getText().toString().trim());
                String pname = pay.getName();
                pay.setCardNumber(Card_nu.getText().toString().trim());
                String pcard = pay.getCardNumber();
                pay.setCVV(et_CVV.getText().toString().trim());
                String pcvv = pay.getCVV();
                pay.setExpirydate(expir_date.getText().toString().trim());
                String pexpire = pay.getExpirydate();
                pay.setCardtype(Visa_card.getText().toString().trim());
                String pvisa = pay.getCardtype();
                pay.setCardtype(master_card.getText().toString().trim());
                String pmaster =pay.getCardtype();
                pay.setSubject(etSubject.getText().toString().trim());
                String psub =pay.getCardtype();
                updatePayment(pID,pname,pcard,pcvv,pexpire,pvisa,pmaster,psub);
            }
        });
    }

    private void updatePayment(String pID,String pname, String pcard, String pcvv, String pexpire, String pvisa, String pmaster,String psub) {
        Payment payment = new Payment(pID,pname, pcard,pvisa,pmaster,pcvv,pexpire,psub);
        ref = FirebaseDatabase.getInstance().getReference().child("Payment").child(pID);
        ref.setValue(pay);
        Toast.makeText(update_pay.this,"Updated successfully",Toast.LENGTH_SHORT).show();
        clearAll();
    }

    private void clearAll() {
        stu_name.setText("");
        Card_nu.setText("");
        stuu_ID.setText("");
        et_CVV.setText("");
        expir_date.setText("");
        etSubject.setText("");



    }
}
