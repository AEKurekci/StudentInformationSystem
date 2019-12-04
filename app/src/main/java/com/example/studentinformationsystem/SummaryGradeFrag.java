package com.example.studentinformationsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SummaryGradeFrag extends Fragment {

    final List<Nots> nots = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nots.add(new Nots("Algorithm",65,75,"BB","Geçti"));
        nots.add(new Nots("Grafical User Interface",75,85,"AA","Geçti"));
        nots.add(new Nots("Artificial Intelligence",45,65,"CB","Geçti"));
        nots.add(new Nots("Siber Security",15,45,"FF","Kaldı"));
        nots.add(new Nots("Network",62,70,"BA","Geçti"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary_grade_layout, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.listGrades);

        SummaryAdapter adapter = new SummaryAdapter(SummaryGradeFrag.this, nots);
        lv.setAdapter(adapter);

        return view;
    }

}
