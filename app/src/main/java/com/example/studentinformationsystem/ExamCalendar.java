package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ExamCalendar extends AppCompatActivity {

    List<ExamDates> examDates = new ArrayList<>();
    List<ExamDatesOfPrep> examDatesOfPreps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_calendar);

        Bundle extras = getIntent().getExtras();
        String type = extras.getString("type");

        ListView lv = findViewById(R.id.listOfExamDates);

        if(type.equals("fromMain")) {
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
            ExamCalendarAdapter adapter = new ExamCalendarAdapter(this, examDates);
            lv.setAdapter(adapter);
        }else if(type.equals("fromPrep")) {
            examDatesOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","13.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","13.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","13.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","13.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2016"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","13.05.2016"));
            ExamCalAdapterOfPrep adapterOfPrep = new ExamCalAdapterOfPrep(this, examDatesOfPreps);
            lv.setAdapter(adapterOfPrep);
        }else{
            Log.d("AEK", type);
        }

        FloatingActionButton fabBack = findViewById(R.id.fabBackExamCal);

        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ExamCalendar.this, MainPage.class);
                startActivity(i);
            }
        });
    }
}
