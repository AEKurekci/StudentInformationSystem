package com.example.studentinformationsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studentinformationsystem.ui.main.DatesOfAcademic;

import java.util.List;

public class AcademicAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<DatesOfAcademic> dates;
    public AcademicAdapter(Activity activity, List<DatesOfAcademic> dates){
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dates = dates;
    }

    @Override
    public int getCount() {
        return dates.size();
    }

    @Override
    public Object getItem(int position) {
        return dates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.row_of_academic_calendar, null);
        TextView tvAction = rowView.findViewById(R.id.txtActionOfAcademic);
        TextView tvStartD = rowView.findViewById(R.id.txtStartDateOfAcademic);
        TextView tvEndD = rowView.findViewById(R.id.txtEndDateOfAcademic);

        DatesOfAcademic datesOfAcademic = dates.get(position);
        tvAction.setText(datesOfAcademic.getAction());
        tvStartD.setText(datesOfAcademic.getStartDate());
        tvEndD.setText(datesOfAcademic.getEndDate());

        return rowView;
    }
}
