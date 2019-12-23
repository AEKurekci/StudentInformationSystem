package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attendance extends AppCompatActivity {

    List<AttendanceInfo> listOfAttendance = new ArrayList<>();
    Map<String, Object> datasFromDatabase = new HashMap<>();
    Map<String, Object> data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        Intent i = getIntent();
        Bundle bundle = i.getBundleExtra("attendance");
        datasFromDatabase = (Map<String, Object>) bundle.getSerializable("attendanceSeri");
        if(datasFromDatabase.get("Algorithm") != null){
            data = (Map<String, Object>) datasFromDatabase.get("Algorithm");
            listOfAttendance.add(new AttendanceInfo("Algorithm", Float.parseFloat(data.get("Kredi").toString()),  Integer.parseInt(data.get("Sınıf").toString()),Integer.parseInt(data.get("Saat").toString())));
        }
        if(datasFromDatabase.get("Graphical User Interface") != null){
            data = (Map<String, Object>) datasFromDatabase.get("Graphical User Interface");
            listOfAttendance.add(new AttendanceInfo("Graphical User Interface", Float.parseFloat(data.get("Kredi").toString()),  Integer.parseInt(data.get("Sınıf").toString()),Integer.parseInt(data.get("Saat").toString())));
        }
        if(datasFromDatabase.get("Network") != null){
            data = (Map<String, Object>) datasFromDatabase.get("Network");
            listOfAttendance.add(new AttendanceInfo("Network", Float.parseFloat(data.get("Kredi").toString()),  Integer.parseInt(data.get("Sınıf").toString()),Integer.parseInt(data.get("Saat").toString())));
        }

        if(datasFromDatabase.get("Artificial Intelligence") != null){
            data = (Map<String, Object>) datasFromDatabase.get("Artificial Intelligence");
            listOfAttendance.add(new AttendanceInfo("Artificial Intelligence", Float.parseFloat(data.get("Kredi").toString()),  Integer.parseInt(data.get("Sınıf").toString()),Integer.parseInt(data.get("Saat").toString())));
        }
        if(datasFromDatabase.get("Cyber Security") != null){
            data = (Map<String, Object>) datasFromDatabase.get("Cyber Security");
            listOfAttendance.add(new AttendanceInfo("Cyber Security", Float.parseFloat(data.get("Kredi").toString()),  Integer.parseInt(data.get("Sınıf").toString()),Integer.parseInt(data.get("Saat").toString())));
        }

        final ListView listView = findViewById(R.id.attendanceList);
        AttendanceAdapter adapter = new AttendanceAdapter(this,listOfAttendance);
        listView.setAdapter(adapter);

        FloatingActionButton fabBack = findViewById(R.id.fabBackAttendance);

        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Attendance.this, MainPage.class);
                startActivity(i);
            }
        });
    }
}
