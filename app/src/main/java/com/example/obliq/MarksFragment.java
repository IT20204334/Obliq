package com.example.obliq;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MarksFragment extends Fragment{

    Button toViewMarksBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_marks, container, false);

        toViewMarksBtn = (Button)view.findViewById(R.id.toViewMarksBtn);

        toViewMarksBtn.setOnClickListener(v -> {
            openViewMarksActivity();
        });

        return view;


    }

    public void openViewMarksActivity(){
        Intent intent = new Intent(getActivity(), ViewMarks.class);
        intent.putExtra("some", "some data");
        startActivity(intent);
    }


}
