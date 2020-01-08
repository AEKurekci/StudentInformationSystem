package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LessonProgram extends AppCompatActivity {

    String studentNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_program);

        Bundle bundleForUserNumber = getIntent().getExtras();
        if (bundleForUserNumber != null) {
            studentNumber = bundleForUserNumber.getString("userNumber");
        }

        FloatingActionButton fabBack = findViewById(R.id.fabBackPrepOfLessons);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonProgram.this, PrepSchoolProcess.class);
                i.putExtra("userNumber", studentNumber);
                startActivity(i);
            }
        });
    }
}
