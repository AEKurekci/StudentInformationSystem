package com.example.studentinformationsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ExamCalAdapterOfPrep extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ExamDatesOfPrep> examDates;

    public ExamCalAdapterOfPrep(Activity activity, List<ExamDatesOfPrep> dates){
        this.mInflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.examDates = dates;
    }

    @Override
    public int getCount() {
        return examDates.size();
    }

    @Override
    public Object getItem(int position) {
        return examDates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.row_exam_of_prep,null);
        TextView tvExamName = rowView.findViewById(R.id.txtExamNameOfPrep);
        TextView tvDate = rowView.findViewById(R.id.txtDateOfExamOfPrep);

        ExamDatesOfPrep examDatesOfPrep = examDates.get(position);

        tvExamName.setText(examDatesOfPrep.getClassName());
        tvDate.setText(examDatesOfPrep.getDate());

        return rowView;
    }
}
