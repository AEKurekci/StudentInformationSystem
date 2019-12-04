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

public class DetailedGradeFrag extends Fragment {

    List<Nots> nots = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nots.add(new Nots("Algorithm",65,75,"BB","Geçti","CENG-3004",
                55,"01/12/2019",4,"Dr.Tuğba Süzek"));
        nots.add(new Nots("Grafical User Interface",75,85,"AA","Geçti","CENG-3005",
                63,"05/12/2019",4,"Dr. Özgür Kılıç"));
        nots.add(new Nots("Artificial Intelligence",45,65,"CB","Geçti","CENG-3030",
                67,"04/12/2019",4,"Arş.Gör.Dr.Cihat Çetinkaya"));
        nots.add(new Nots("Siber Security",15,45,"FF","Kaldı","CENG-3008",
                53,"07/12/2019",4,"Öğr. Grv. Murat Sakal"));
        nots.add(new Nots("Network",62,70,"BA","Geçti","CENG-3006",
                54,"03/12/2019",4,"Dr. Enis Karaarslan"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detailed_grade_layout, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.listGradesDetailed);

        DetailedAdapter adapter = new DetailedAdapter(DetailedGradeFrag.this, nots);
        lv.setAdapter(adapter);

        return view;
    }

}
