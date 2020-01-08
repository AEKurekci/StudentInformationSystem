package com.example.studentinformationsystem;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.studentinformationsystem.ui.main.SectionsPagerAdapter;

public class GradeInformation extends AppCompatActivity {

    String studentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_information);
        Bundle bundleForUserNumber = getIntent().getExtras();

        if (bundleForUserNumber != null) {
            studentNumber = bundleForUserNumber.getString("userNumber");
        }
        Intent i = getIntent();
        Bundle bundleSum = i.getBundleExtra("summaryGrade");
        Bundle bundleDet = i.getBundleExtra("detailedGrade");
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),bundleSum, bundleDet);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GradeInformation.this, MainPage.class);
                i.putExtra("userNumber", studentNumber);
                startActivity(i);
            }
        });
    }
}