package com.example.obliq;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PaymentsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payments, container, false);

        Button add_pay = (Button) view.findViewById(R.id.add_pay);
        add_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), add_pay.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });

        Button update_paym = (Button) view.findViewById(R.id.update_pay);
        update_paym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), update_pay.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });

        Button view_pay = (Button) view.findViewById(R.id.view_pay);
        view_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Retrievepay.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });

        Button btn_calc = (Button) view.findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Calculatefee.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });


        return view;
    }


}





