package com.example.studentinformationsystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SummaryAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Nots> nots;

    public SummaryAdapter(SummaryGradeFrag activity, List<Nots> nots){
        mInflater = (LayoutInflater) activity.getActivity().getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        this.nots = nots;
    }

    @Override
    public int getCount() {
        return nots.size();
    }

    @Override
    public Object getItem(int position) {
        return nots.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = mInflater.inflate(R.layout.summary_row_of_listview, null);
        TextView tvClass = (TextView) rowView.findViewById(R.id.txtClassNameOfSummary);
        TextView tvVise = (TextView) rowView.findViewById(R.id.txtViseGrade);
        TextView tvFinal = (TextView) rowView.findViewById(R.id.txtFinalGrade);
        TextView tvLetter = (TextView) rowView.findViewById(R.id.txtLetter);
        TextView tvSituation = (TextView) rowView.findViewById(R.id.txtSituation);

        Nots not = nots.get(position);

        tvClass.setText(not.getClassName());

        Integer vise = not.getViseGrade();
        tvVise.setText(vise.toString());

        Integer finalGr = not.getFinalGrade();
        tvFinal.setText(finalGr.toString());

        tvLetter.setText(not.getLetterGrade());

        tvSituation.setText(not.getSituation());

        return rowView;
    }
}
