package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Attendance extends AppCompatActivity {

    List<AttendanceInfo> listOfAttendance = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        listOfAttendance.add(new AttendanceInfo("Grafical User Interface", 6, (short) 3,12));
        listOfAttendance.add(new AttendanceInfo("Algorithm", 6, (short) 3,5));
        listOfAttendance.add(new AttendanceInfo("Network", 5, (short) 3,10));
        listOfAttendance.add(new AttendanceInfo("Artificial Intelligence", 4, (short) 3,6));
        listOfAttendance.add(new AttendanceInfo("Siber Security", 2, (short) 1,4));

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
