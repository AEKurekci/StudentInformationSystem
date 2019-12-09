package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PrepSchoolProcess extends AppCompatActivity {

    Button btnExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep_school_process);

        btnExam = findViewById(R.id.btnExamCalOfPrep);
        btnExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrepSchoolProcess.this,ExamCalendar.class);
                String str = "fromPrep";
                i.putExtra("type",str);
                startActivity(i);
            }
        });

        FloatingActionButton fabBack = findViewById(R.id.fabBackPrep);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrepSchoolProcess.this, MainPage.class);
                startActivity(i);
            }
        });
    }
}
