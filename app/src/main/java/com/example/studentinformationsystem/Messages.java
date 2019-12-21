package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Messages extends AppCompatActivity {
    FloatingActionButton btnSearch;
    FloatingActionButton btnBack;

    TextView txtMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        txtMessageView = findViewById(R.id.txtMessageView);

        btnSearch = findViewById(R.id.btnSearchOfMessages);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessageView.setText("Kayıt Yok...");
            }
        });

        btnBack = findViewById(R.id.fabBackMessages);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Messages.this, MainPage.class);
                startActivity(i);
            }
        });
    }
}
