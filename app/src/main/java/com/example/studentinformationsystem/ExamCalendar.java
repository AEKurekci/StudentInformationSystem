package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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

    }
}
