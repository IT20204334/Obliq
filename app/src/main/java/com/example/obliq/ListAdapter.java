package com.example.obliq;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Marks> marksList;

    public ListAdapter(Activity mContext, List<Marks> marksList){
        super(mContext, R.layout.list_item, marksList);
        this.mContext = mContext;
        this.marksList = marksList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item, null, true);

        TextView tvSid = listItemView.findViewById(R.id.tvSid);
        TextView tvSphysics = listItemView.findViewById(R.id.tvSphysics);
        TextView tvSchemistry = listItemView.findViewById(R.id.tvSchemistry);
        TextView tvSbiomaths = listItemView.findViewById(R.id.tvSbiomaths);
        TextView tvSaverage = listItemView.findViewById(R.id.tvSaverage);



        Marks marks = marksList.get(position);

        tvSid.setText(marks.getStudentID());

        String marksPhysics = Double.toString(marks.getPhysics());
        tvSphysics.setText(marksPhysics);

        String marksChemistry = Double.toString(marks.getChemistry());
        tvSchemistry.setText(marksChemistry);

        String marksBioMaths = Double.toString(marks.getBioMaths());
        tvSbiomaths.setText(marksBioMaths);

        Double sAverage = ((marks.getPhysics()+marks.getChemistry()+marks.getBioMaths())/3);
        String marksAverage= Double.toString(sAverage);
        tvSaverage.setText(marksAverage);


        return listItemView;
    }
}
