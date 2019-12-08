package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ExamCalendar extends AppCompatActivity {

    List<ExamDates> examDates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_calendar);

        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));
        examDates.add(new ExamDates("Grafical User Interface","15/12/2019","C105"));

        ListView lv = findViewById(R.id.listOfExamDates);
        ExamCalendarAdapter adapter = new ExamCalendarAdapter(this, examDates);
        lv.setAdapter(adapter);

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
