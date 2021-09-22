package com.example.obliq;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter2 extends ArrayAdapter {

    private Activity mContext;
    List<Question> questionList;


    public ListAdapter2(Activity mContext, List<Question> questionList){
        super(mContext,R.layout.list_question,questionList);
        this.mContext = mContext;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = mContext.getLayoutInflater();
        View listQuestionView=inflater.inflate(R.layout.list_question,null,true);

        TextView tvQaname = listQuestionView.findViewById(R.id.tvQaname);
        TextView tvQuestion = listQuestionView.findViewById(R.id.tvQuestion);


        Question question = questionList.get(position);

        tvQaname.setText(question.getQaname());
        tvQuestion.setText(question.getQuestion());


        return listQuestionView;


    }
}
