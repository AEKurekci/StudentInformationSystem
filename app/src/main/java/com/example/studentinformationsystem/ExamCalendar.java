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
    List<String> temp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_calendar);

        Bundle extras = getIntent().getExtras();
        String type = extras.getString("type");
        Bundle b = extras.getBundle("examCal");

        ListView lv = findViewById(R.id.listOfExamDates);

        if(type.equals("fromMain")) {
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
            examDatesOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","21.05.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Başarı Sınavı:","09.05.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Proje Çalışması:","05.05.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Konuşma Sınavı:","18.04.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Dilin Kullanımı Sınavı 3:","24.03.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Başarı Sınavı 2:","21.05.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Dilin Kullanımı Sınavı 2:","07.03.2019"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Başarı Sınavı 3:","18.11.2018"));
            examDatesOfPreps.add(new ExamDatesOfPrep("Dilin Kullanımı Sınavı 1:","25.10.2019"));
            ExamCalAdapterOfPrep adapterOfPrep = new ExamCalAdapterOfPrep(this, examDatesOfPreps);
            lv.setAdapter(adapterOfPrep);
        }else if(type.equals("fromPrepForGrade")){
            examGradeOfPreps.add(new ExamDatesOfPrep("Sınıf İçi Performans:","21.05.2016","65"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Yazma Portfolyosu:","13.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Başarı Sınavı::","21.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Proje Çalışması:","13.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Konuşma Sınavı:","21.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Dilin Kullanımı Sınavı 3:","13.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Başarı Sınavı 2:","21.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Dilin Kullanımı Sınavı 2","13.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Başarı Sınavı 3:","21.05.2016","55"));
            examGradeOfPreps.add(new ExamDatesOfPrep("Dilin Kullanımı Sınavı 1:","13.05.2016","55"));
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
                startActivity(i);
            }
        });
    }
}
