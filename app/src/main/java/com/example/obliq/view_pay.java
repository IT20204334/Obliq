package com.example.obliq;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class view_pay extends ArrayAdapter {

    private Activity mContext;
    List<Payment> paymentList;


    public view_pay(Activity mContext, List<Payment> paymentList){
        super(mContext,R.layout.list_item2,paymentList);
        this.mContext = mContext;
        this.paymentList = paymentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View ListItem2View = inflater.inflate(R.layout.list_item2,null,true);


        TextView tvcardtype = ListItem2View.findViewById(R.id.tvcardtype);
        TextView tvsubject= ListItem2View.findViewById(R.id.tvsubject);
        TextView tvexpiredate =ListItem2View.findViewById(R.id.tvexpiredate);
        TextView tvname = ListItem2View.findViewById(R.id.tvname);
        TextView tvStuID = ListItem2View.findViewById(R.id.tvStuID);

        Payment payment = paymentList.get(position);


        tvcardtype.setText(payment.getCardtype());
        tvsubject.setText(payment.getSubject());
        tvexpiredate.setText(payment.getExpirydate());
        tvname.setText(payment.getName());
        tvStuID.setText(payment.getStuID());

        return ListItem2View;

    }
}
