package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AcademicCalendar extends AppCompatActivity {

    List<DatesOfAcademic> dates = new ArrayList<>();
    Map<String, Object> datasFromDatabase = new HashMap<>();
    List<String> eventStart = new ArrayList<>();
    List<String> eventEnd = new ArrayList<>();
    List<String> events = new ArrayList<>();
    int counter = 0;
    int top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);
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
        }/*
        dates.add(new DatesOfAcademic("Yeni Öğrenci Ön Kayıt","16.08.2019 08:30","22.10.2019 23:59"));
        dates.add(new DatesOfAcademic("Ders Kayıt","09.09.2019 08:30","13.10.2019 23:59"));
        dates.add(new DatesOfAcademic("Mazeretli Ders Kayıt","16.09.2019 08:30","30.10.2019 23:59"));
        dates.add(new DatesOfAcademic("Ara Sınav Not Giriş","09.09.2019 08:30","21.12.2019 23:59"));
        dates.add(new DatesOfAcademic("Yarıyıl Sınav Not Giriş","28.12.2019 08:30","10.01.2019 23:59"));
        dates.add(new DatesOfAcademic("Bütünleme Not Giriş","15.01.2019 08:30","21.01.2019 23:59"));
        dates.add(new DatesOfAcademic("Harf Notlarının Yayınlanması","28.12.2019 08:30","22.10.2019 23:59"));
        dates.add(new DatesOfAcademic("Öğretim Elemanı Yoklama Giriş","16.09.2019 08:30","27.12.2019 23:59"));
*/
        final ListView listView = findViewById(R.id.listOfAcademicCal);
        AcademicAdapter adapter = new AcademicAdapter(this, dates);
        listView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fabOfCalender);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AcademicCalendar.this, MainPage.class);
                startActivity(i);
            }
        });
    }

}
