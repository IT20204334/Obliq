package com.example.obliq;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    Button toAdminPageBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_marks, container, false);

        toAdminPageBtn = (Button)view.findViewById(R.id.toAdminPageBtn);

        toAdminPageBtn.setOnClickListener(v -> {
            openAdminLogin();
        });

        return view;

    }

    public void openAdminLogin(){
        Intent intent = new Intent(getActivity(), AdminLoginActivity.class);
        intent.putExtra("some", "some data");
        startActivity(intent);
    }
}
