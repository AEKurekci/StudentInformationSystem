package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {
    Button btnNot;
    Button btnDevam;
    Button btnTranscript;
    Button btnAcademic;
    Button btnSinav;
    Button btnMuf;
    Button btnHazirlik;

    ListView listBtn;
    ArrayList<Button> lButtons = new ArrayList<>();

    ArrayAdapter<Button> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnNot = findViewById(R.id.btnNot);
        btnDevam = findViewById(R.id.btnDevamsizlik);
        btnTranscript = findViewById(R.id.btnTranscript);
        btnAcademic = findViewById(R.id.btnAcademic);
        btnSinav = findViewById(R.id.btnSinav);
        btnMuf = findViewById(R.id.btnSyllabus);
        btnHazirlik = findViewById(R.id.btnHazirlik);

        listBtn = findViewById(R.id.listButtons);
        lButtons.add(btnNot);
        lButtons.add(btnDevam);
        lButtons.add(btnTranscript);
        lButtons.add(btnAcademic);
        lButtons.add(btnSinav);
        lButtons.add(btnMuf);
        lButtons.add(btnHazirlik);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lButtons);
        listBtn.setAdapter(adapter);
    }
}
