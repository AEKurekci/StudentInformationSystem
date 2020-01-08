package com.example.studentinformationsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryGradeFrag extends Fragment {

    final List<Nots> nots = new ArrayList<>();

    private Map<String, Object> datasFromDatabase = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();
    private String TAG = "FirebaseSummaryGrade";
    private Bundle bundle;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary_grade_layout, container, false);

        bundle = getArguments();
        datasFromDatabase = (Map<String, Object>) bundle.getSerializable("summaryGrade");
        if (datasFromDatabase.get("Algorithm") != null) {
            data = (Map<String, Object>) datasFromDatabase.get("Algorithm");
            nots.add(new Nots("Algorithm",Integer.parseInt(data.get("vize").toString()),
                    Integer.parseInt(data.get("final").toString()), data.get("harfNotu").toString(),
                    data.get("durumu").toString()));
        }
        if (datasFromDatabase.get("Grafical User Interface") != null) {
            data = (Map<String, Object>) datasFromDatabase.get("Grafical User Interface");
            nots.add(new Nots("Grafical User Interface",Integer.parseInt(data.get("vize").toString()),
                    Integer.parseInt(data.get("final").toString()), data.get("harfNotu").toString(),
                    data.get("durumu").toString()));
        }
        if (datasFromDatabase.get("Artificial Intelligence") != null) {
            data = (Map<String, Object>) datasFromDatabase.get("Artificial Intelligence");
            nots.add(new Nots("Artificial Intelligence",Integer.parseInt(data.get("vize").toString()),
                    Integer.parseInt(data.get("final").toString()), data.get("harfNotu").toString(),
                    data.get("durumu").toString()));
        }
        if (datasFromDatabase.get("Computer Network") != null) {
            data = (Map<String, Object>) datasFromDatabase.get("Computer Network");
            nots.add(new Nots("Computer Network",Integer.parseInt(data.get("vize").toString()),
                    Integer.parseInt(data.get("final").toString()), data.get("harfNotu").toString(),
                    data.get("durumu").toString()));
        }
        if (datasFromDatabase.get("Cyber Security") != null) {
            data = (Map<String, Object>) datasFromDatabase.get("Cyber Security");
            nots.add(new Nots("Cyber Security",Integer.parseInt(data.get("vize").toString()),
                    Integer.parseInt(data.get("final").toString()), data.get("harfNotu").toString(),
                    data.get("durumu").toString()));
        }
        final ListView lv = view.findViewById(R.id.listGrades);

        SummaryAdapter adapter = new SummaryAdapter(SummaryGradeFrag.this, nots);
        lv.setAdapter(adapter);

        return view;
    }

}
