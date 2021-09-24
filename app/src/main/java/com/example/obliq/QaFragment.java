package com.example.obliq;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class QaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qa, container, false);
        Button btn_qa = (Button) view.findViewById(R.id.btn_qa);
        btn_qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Qa.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });
        Button btn_viewqa = (Button) view.findViewById(R.id.btn_viewqa);
        btn_viewqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),retreveQuestion.class);
                in.putExtra("some","some data");
                startActivity(in);
            }
        });
        return view;
    }
}