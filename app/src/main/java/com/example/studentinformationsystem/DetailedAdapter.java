package com.example.studentinformationsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DetailedAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Nots> nots;

    public DetailedAdapter(DetailedGradeFrag activity, List<Nots> nots){
        mInflater = (LayoutInflater) activity.getActivity().getSystemService((Context.LAYOUT_INFLATER_SERVICE));//.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        rowView = mInflater.inflate(R.layout.detailed_row_of_listview, null);
        TextView tvClass = (TextView) rowView.findViewById(R.id.txtClassName);
        TextView tvClassCode = (TextView) rowView.findViewById(R.id.txtClassCode);
        TextView tvAverage = (TextView) rowView.findViewById(R.id.txtAverageOfClass);
        TextView tvDate = (TextView) rowView.findViewById(R.id.txtDateOfAnnouncement);

        TextView tvVise = (TextView) rowView.findViewById(R.id.txtViseGradeOfDetailed);
        TextView tvFinal = (TextView) rowView.findViewById(R.id.txtFinalGradeOfDetailed);
        TextView tvCreadit = (TextView) rowView.findViewById(R.id.txtCredit);
        TextView tvteacherName = (TextView) rowView.findViewById(R.id.txtTeacherName);

        Nots not = nots.get(position);

        tvClass.setText(not.getClassName());
        tvClassCode.setText(not.getClassCode());
        Integer avg = not.getAverageGrade();
        tvAverage.setText(avg.toString());
        tvDate.setText(not.getDateOfAnnounce());

        Integer vise = not.getViseGrade();
        tvVise.setText(vise.toString());
        Integer finalGr = not.getFinalGrade();
        tvFinal.setText(finalGr.toString());
        Float cre = not.getCredit();
        tvCreadit.setText(cre.toString());
        tvteacherName.setText(not.getTeacherName());

        return rowView;
    }
}
