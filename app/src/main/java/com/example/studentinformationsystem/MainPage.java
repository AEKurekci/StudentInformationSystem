package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    Button btnNot;
    Button btnDevam;
    Button btnTranscript;
    Button btnAcademic;
    Button btnSinav;
    Button btnMuf;
    Button btnHazirlik;
    ImageButton btnMessage;

    ListView listBtn;
    ArrayList<Button> lButtons = new ArrayList<>();

    LayoutInflater layoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnMessage = findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(MainPage.this, GradeInformation.class);
                //startActivity(i);
            }
        });

        /*View buttons;
        layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        buttons = layoutInflater.inflate(R.layout.buttons_of_main_page,null);
        btnNot = buttons.findViewById(R.id.btnNot);
        btnDevam = buttons.findViewById(R.id.btnDevamsizlik);
        btnTranscript = buttons.findViewById(R.id.btnTranscript);
        btnAcademic = buttons.findViewById(R.id.btnAcademic);
        btnSinav = buttons.findViewById(R.id.btnSinav);
        btnMuf = buttons.findViewById(R.id.btnSyllabus);
        btnHazirlik = buttons.findViewById(R.id.btnHazirlik);*/

        btnNot = findViewById(R.id.btnNot2);
        btnDevam = findViewById(R.id.btnDevamsizlik2);
        btnTranscript = findViewById(R.id.btnTranscript2);
        btnAcademic = findViewById(R.id.btnAcademic2);
        btnSinav = findViewById(R.id.btnSinav2);
        btnMuf = findViewById(R.id.btnSyllabus2);
        btnHazirlik = findViewById(R.id.btnHazirlik2);


        btnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, GradeInformation.class);
                startActivity(i);
            }
        });

        btnDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, Attendance.class);
                startActivity(i);
            }
        });

        listBtn = findViewById(R.id.listButtons);
        lButtons.add(btnNot);
        lButtons.add(btnDevam);
        lButtons.add(btnTranscript);
        lButtons.add(btnAcademic);
        lButtons.add(btnSinav);
        lButtons.add(btnMuf);
        lButtons.add(btnHazirlik);

        final ListView listView = findViewById(R.id.listButtons);
        ButtonAdaptor adaptor = new ButtonAdaptor(this, lButtons);
        listView.setAdapter(adaptor);
    }
}
