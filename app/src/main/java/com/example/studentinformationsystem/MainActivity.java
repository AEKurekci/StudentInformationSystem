package com.example.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean startFromAuthentication = false;
    Button btnStd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStd = findViewById(R.id.btnStd);
        btnStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startFromAuthentication) {
                    Intent intent = new Intent(MainActivity.this, StudentEntry.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, MainPage.class);
                    startActivity(intent);
                }
            }
        });
    }
}
