package com.example.studentinformationsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ExamCalendarAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ExamDates> exams;

    public ExamCalendarAdapter(Activity activity, List<ExamDates> exams){
        this.mInflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.exams = exams;
    }

    @Override
    public int getCount() {
        return exams.size();
    }

    @Override
    public Object getItem(int position) {
        return exams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.row_of_exam_calendar,null);
        TextView tvClassName = rowView.findViewById(R.id.txtClassNameOfExamCal);
        TextView tvDate = rowView.findViewById(R.id.txtDateOfExamCal);
        TextView tvClassRoom = rowView.findViewById(R.id.txtClassRoomOfExamCal);

        ExamDates examDates = exams.get(position);

        tvClassName.setText(examDates.getClassName());
        tvDate.setText(examDates.getDate());
        tvClassRoom.setText(examDates.getClassRoom());

        return rowView;
    }
}
