package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class AttendanceOfPrep extends AppCompatActivity {

    TextView txtAps;
    TextView txtPos;
    String studentNumber;
    Bundle bundleFromPrep;
    Map<String, Object> datasFromDatabaseForPrep = new HashMap<>();
    String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_of_prep);
        Bundle bundleForUserNumber = getIntent().getExtras();
        if (bundleForUserNumber != null) {
            studentNumber = bundleForUserNumber.getString("userNumber");
            studentName = bundleForUserNumber.getString("userName");
            bundleFromPrep = bundleForUserNumber.getBundle("bundleOfPrep");
        }

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
                i.putExtra("userNumber",studentNumber);
                i.putExtra("userName",studentName);
                startActivity(i);
            }
        });
    }
}
