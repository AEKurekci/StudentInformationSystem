package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class StudentEntry extends AppCompatActivity {
    Button btnEntry;
    ImageButton randomButton;
    EditText dogrulama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_entry);

        final TextView sayilarToplami  = (TextView) findViewById(R.id.textView6);

        btnEntry = findViewById(R.id.btnEntry);
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentEntry.this, MainPage.class);
                startActivity(i);
            }
        });




        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bilgi = "";
                Random randomSayiOlusturucu = new Random();

                Integer randomSayi = randomSayiOlusturucu.nextInt(99);
                Integer randomSayi2 = randomSayiOlusturucu.nextInt(99);

                bilgi = randomSayi.toString() +" + "+ randomSayi2.toString();
                sayilarToplami.setText(bilgi);

            }
        };
        randomButton = findViewById(R.id.refreshButton);
        randomButton.setOnClickListener(listener);
    }
}
