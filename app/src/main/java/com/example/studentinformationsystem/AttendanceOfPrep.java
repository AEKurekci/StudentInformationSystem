package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AttendanceOfPrep extends AppCompatActivity {

    TextView txtAps;
    TextView txtPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_of_prep);

        txtAps = findViewById(R.id.txtApsent);
        txtPos = findViewById(R.id.txtPossessions);
        Bundle b = getIntent().getExtras();
        String[] att = b.getStringArray("attendance");

        txtAps.setText(att[0]);
        txtPos.setText(att[1]);

        FloatingActionButton fabBack = findViewById(R.id.fabBackPrepOfAttendance);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AttendanceOfPrep.this, PrepSchoolProcess.class);
                startActivity(i);
            }
        });
    }
}
