package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicCalendar extends AppCompatActivity {

    List<DatesOfAcademic> dates = new ArrayList<>();
    Map<String, Object> datasFromDatabase = new HashMap<>();
    List<String> eventStart = new ArrayList<>();
    List<String> eventEnd = new ArrayList<>();
    List<String> events = new ArrayList<>();
    int counter = 0;
    int top;
    String studentNumber;
    String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);

        Bundle bundleForUserNumber = getIntent().getExtras();
        if (bundleForUserNumber != null) {
            studentNumber = bundleForUserNumber.getString("userNumber");
            studentName = bundleForUserNumber.getString("userName");
        }

        Intent i = getIntent();
        Bundle b = i.getBundleExtra("academic");
        datasFromDatabase = (Map<String, Object>) b.getSerializable("academicCalendar");
        if(datasFromDatabase.get("olayBaslamaTarihi") != null){
            eventStart = (List<String>) datasFromDatabase.get("olayBaslamaTarihi");
        }
        if(datasFromDatabase.get("olayBitisTarihi") != null){
            eventEnd = (List<String>) datasFromDatabase.get("olayBitisTarihi");
        }
        if(datasFromDatabase.get("olaylar") != null){
            events = (List<String>) datasFromDatabase.get("olaylar");
        }
        top = events.size();
        while (counter < top){
            dates.add(new DatesOfAcademic(events.get(counter),
                    eventStart.get(counter),eventStart.get(counter)));
            counter++;
        }
        final ListView listView = findViewById(R.id.listOfAcademicCal);
        AcademicAdapter adapter = new AcademicAdapter(this, dates);
        listView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fabOfCalender);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AcademicCalendar.this, MainPage.class);
                i.putExtra("userNumber", studentNumber);
                i.putExtra("userName",studentName);
                startActivity(i);
            }
        });
    }

}
