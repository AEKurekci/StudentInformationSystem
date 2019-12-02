package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

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

    LayoutInflater layoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        View buttons;
        layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        buttons = layoutInflater.inflate(R.layout.buttons_of_main_page,null);
        btnNot = buttons.findViewById(R.id.btnNot2);
        btnDevam = buttons.findViewById(R.id.btnDevamsizlik2);
        btnTranscript = buttons.findViewById(R.id.btnTranscript2);
        btnAcademic = buttons.findViewById(R.id.btnAcademic2);
        btnSinav = buttons.findViewById(R.id.btnSinav2);
        btnMuf = buttons.findViewById(R.id.btnSyllabus2);
        btnHazirlik = buttons.findViewById(R.id.btnHazirlik2);

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
