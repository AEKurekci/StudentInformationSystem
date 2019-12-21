package com.example.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainPage extends AppCompatActivity {
    Button btnNot;
    Button btnDevam;
    Button btnTranscript;
    Button btnAcademic;
    Button btnSinav;
    Button btnMuf;
    Button btnHazirlik;

    ImageButton btnMessage;
    ImageButton btnOut;

    FirebaseUser user;

    ListView listBtn;
    ArrayList<Button> lButtons = new ArrayList<>();
    Map<String, Object> summaryGradeData = new HashMap<>();
    private String TAG = "MainPageData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docUser = db.collection("160709031").document("SummaryGrade");
        docUser.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, document.getId() + "=>" + document.getData());
                        summaryGradeData = document.getData();
                        Log.d("AEK",summaryGradeData.get("Algorithm").toString());
                    }else{
                        Log.w(TAG, "No such document");
                    }
                }else {
                    Log.e(TAG,"Error Getting Documents.", task.getException());
                }
            }
        });


        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            user = bundle.getParcelable("theUser");

        btnMessage = findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPage.this, Messages.class);
                startActivity(i);
            }
        });

        btnOut = findViewById(R.id.btnOut);
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, StudentEntry.class);
                startActivity(i);
            }
        });

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

        btnTranscript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this,Transcript.class);
                startActivity(i);
            }
        });

        btnAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this,AcademicCalendar.class);
                startActivity(i);
            }
        });

        btnSinav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this,ExamCalendar.class);
                String str = "fromMain";
                i.putExtra("type",str);
                startActivity(i);
            }
        });

        btnMuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this,Syllabus.class);
                startActivity(i);
            }
        });

        btnHazirlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this,PrepSchoolProcess.class);
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
