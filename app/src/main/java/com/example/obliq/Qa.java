package com.example.obliq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Qa extends AppCompatActivity {
    EditText etQuestion, etQsid, etQaname;
    Button btn_add, btn_deleteqa, btn_updateqa;
    DatabaseReference dbref;
    Question question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);

        etQuestion = (EditText) findViewById(R.id.et_question);
        etQsid = (EditText) findViewById(R.id.et_qsid);
        etQaname = (EditText) findViewById(R.id.et_qaname);
        btn_add = (Button) findViewById(R.id.btn_22);
        btn_updateqa = (Button) findViewById(R.id.btn_updateqa);
        btn_deleteqa = (Button) findViewById(R.id.btn_deleteqa);

        question = new Question();
        dbref = FirebaseDatabase.getInstance("https://obliq-4bef4-default-rtdb.firebaseio.com/").getReference().child("Question");
        btn_add.setOnClickListener(view -> {
            question.setQuestion(etQuestion.getText().toString().trim());
            String Question = question.getQuestion();
            question.setQsid(etQsid.getText().toString().trim());
            String Qsid = question.getQsid();
            question.setQaname(etQaname.getText().toString().trim());
            String Qaname = question.getQaname();

            dbref.push().getKey();
            Question question = new Question(Question, Qaname);

            dbref.child(Qsid).setValue(question);
            Toast.makeText(Qa.this, "Question Inserted Successfully", Toast.LENGTH_SHORT).show();
            clearAll();
        });

        btn_deleteqa.setOnClickListener(view -> {
            question.setQsid(etQsid.getText().toString().trim());
            String Qsid = question.getQsid();
            deleteQuestion(Qsid);
        });

        btn_updateqa.setOnClickListener(view ->

        {
            question.setQuestion(etQuestion.getText().toString().trim());
            String Question = question.getQuestion();
            question.setQsid(etQsid.getText().toString().trim());
            String Qsid = question.getQsid();
            question.setQaname(etQaname.getText().toString().trim());
            String Qaname = question.getQaname();
            updateQuestion(Qsid, Qaname, Question);


        });


    }

    public void clearAll(){
        etQuestion.setText("");
        etQsid.setText("");
        etQaname.setText("");
    }


    public void deleteQuestion(String Qsid) {
        dbref = FirebaseDatabase.getInstance().getReference().child("Question").child(Qsid);
        dbref.removeValue();

        Toast.makeText(Qa.this, "Question deleted Successfully", Toast.LENGTH_LONG).show();
        clearAll();
    }

    public void updateQuestion(String Qsid, String Qaname, String Question){
        dbref = FirebaseDatabase.getInstance().getReference().child("Question").child(Qsid);
        Question question = new Question(Question, Qaname);
        dbref.setValue(question);
        Toast.makeText(Qa.this, "Question deleted Successfully", Toast.LENGTH_LONG).show();
        clearAll();

    }
}