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

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Ntice> nticeList;


    public ListAdapter(Activity mContext, List<Ntice> nticeList){
        super(mContext,R.layout.list_notice,nticeList);
        this.mContext = mContext;
        this.nticeList=nticeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = mContext.getLayoutInflater();
        View listNticeView=inflater.inflate(R.layout.list_notice,null,true);

        TextView tvDate = listNticeView.findViewById(R.id.tvDate);
        TextView tvName = listNticeView.findViewById(R.id.tvName);
        TextView tvNotice = listNticeView.findViewById(R.id.tvNotice);
        TextView tvSubject = listNticeView.findViewById(R.id.tvSubject);

        Ntice ntice = nticeList.get(position);

        tvDate.setText(ntice.getDate());
        tvName.setText(ntice.getName());
        tvNotice.setText(ntice.getNotice());
        tvSubject.setText(ntice.getSubject());

        return listNticeView;


    }
}
