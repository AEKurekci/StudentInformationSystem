package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamCalendar extends AppCompatActivity {

    List<ExamDates> examDates = new ArrayList<>();
    List<ExamDatesOfPrep> examDatesOfPreps = new ArrayList<>();
    List<ExamDatesOfPrep> examGradeOfPreps = new ArrayList<>();
    Map<String, Object> datasFromDatabase = new HashMap<>();
    Map<String, Object> datasFromDatabaseForPrep = new HashMap<>();
    List<String> temp = new ArrayList<>();
    String studentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_calendar);

        Bundle extras = getIntent().getExtras();
        String type = extras.getString("type");

        Bundle bundleForUserNumber = getIntent().getExtras();
        if (bundleForUserNumber != null) {
            studentNumber = bundleForUserNumber.getString("userNumber");
        }

        ListView lv = findViewById(R.id.listOfExamDates);

        if(type.equals("fromMain")) {
            Bundle b = extras.getBundle("examCal");
            datasFromDatabase = (Map<String, Object>) b.getSerializable("examCalendar");
            for (String lessonName : datasFromDatabase.keySet()){
                if(datasFromDatabase.get(lessonName) != null){
                    temp = (List<String>) datasFromDatabase.get(lessonName);
                    examDates.add(new ExamDates(lessonName,temp.get(0),temp.get(1)));
                }
            }
            ExamCalendarAdapter adapter = new ExamCalendarAdapter(this, examDates);
            lv.setAdapter(adapter);
        }else if(type.equals("fromPrepForCal")) {
            Bundle b = extras.getBundle("bundleOfPrep");
            datasFromDatabaseForPrep = (Map<String, Object>) b.getSerializable("examCalendarOfPrep");
            datasFromDatabaseForPrep = (Map<String, Object>) datasFromDatabaseForPrep.get("Bahar");
            for(String exams : datasFromDatabaseForPrep.keySet()){
                if (datasFromDatabaseForPrep.get(exams) != null){
                    String dates = (String) datasFromDatabaseForPrep.get(exams);
                    examDatesOfPreps.add(new ExamDatesOfPrep(exams,dates));
                }
            }
            ExamCalAdapterOfPrep adapterOfPrep = new ExamCalAdapterOfPrep(this, examDatesOfPreps);
            lv.setAdapter(adapterOfPrep);
        }else if(type.equals("fromPrepForGrade")){
            Bundle b = extras.getBundle("bundleOfPrep");
            datasFromDatabaseForPrep = (Map<String, Object>) b.getSerializable("gradeInfoOfPrep");
            datasFromDatabaseForPrep = (Map<String, Object>) datasFromDatabaseForPrep.get("Bahar");
            for(String exams : datasFromDatabaseForPrep.keySet()){
                if (datasFromDatabaseForPrep.get(exams) != null){
                    String dates = datasFromDatabaseForPrep.get(exams).toString();
                    Log.d("AEK", dates + exams);
                    examGradeOfPreps.add(new ExamDatesOfPrep(exams,"0",dates));
                }
            }
            ExamGradeAdapterOfPrep adapterOfPrep = new ExamGradeAdapterOfPrep(this, examGradeOfPreps);
            lv.setAdapter(adapterOfPrep);
        }
        else{
            Log.d("AEK", type);
        }

        FloatingActionButton fabBack = findViewById(R.id.fabBackExamCal);

        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ExamCalendar.this, MainPage.class);
                i.putExtra("userNumber", studentNumber);
                startActivity(i);
            }
        });
    }
}
