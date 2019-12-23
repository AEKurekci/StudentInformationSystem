package com.example.studentinformationsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AttendanceAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<AttendanceInfo> AInfo;
    public AttendanceAdapter(Activity activity, List<AttendanceInfo> attendanceInfo){
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.AInfo = attendanceInfo;
    }

    @Override
    public int getCount() {
        return AInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return AInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = mInflater.inflate(R.layout.row_of_attendance,null);
        TextView tvClassName = rowView.findViewById(R.id.txtClassNameOfAttendance);
        TextView tvCredit = rowView.findViewById(R.id.txtCreditOfAttendance);
        TextView tvClassNo = rowView.findViewById(R.id.txtClassNoOfAttendance);
        TextView tvHours = rowView.findViewById(R.id.txtAttendanceHours);

        AttendanceInfo attendanceInfo = AInfo.get(position);

        tvClassName.setText(attendanceInfo.getClassName());
        Float credit = attendanceInfo.getCredit();
        tvCredit.setText(credit.toString());
        Integer classNo = attendanceInfo.getClassNo();
        tvClassNo.setText(classNo.toString());
        Integer hours = attendanceInfo.getAttendanceHours();
        tvHours.setText(hours.toString());

        return rowView;
    }
}
