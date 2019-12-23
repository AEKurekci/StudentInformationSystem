package com.example.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.model.DocumentCollections;

import org.w3c.dom.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainPage extends AppCompatActivity implements Parcelable {
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
    Map<String, Object> detailedGradeData = new HashMap<>();

    Bundle bundleForSummaryGrade;
    Bundle bundleForDetailedGrade;

    FirebaseFirestore db;
    DocumentReference docUserReference;
    CollectionReference colUserReference;

    private String TAG = "MainPageData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        if (savedInstanceState != null){
            summaryGradeData = savedInstanceState.getParcelable("summary");
            //bundleForSummaryGrade = savedInstanceState.getBundle("summaryInBundle");
        }else {
            bundleForSummaryGrade = new Bundle();
            bundleForDetailedGrade = new Bundle();
        }

        db = FirebaseFirestore.getInstance();
        colUserReference = db.collection("160709031");
        docUserReference = colUserReference.document("SummaryGrade");
        docUserReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, document.getId() + "=>" + document.getData());
                        summaryGradeData = document.getData();
                        bundleForSummaryGrade.putSerializable("summaryGrade", (Serializable) summaryGradeData);
                        summaryGradeData = (Map<String, Object>) bundleForSummaryGrade.getSerializable("summaryGrade");
                        Log.d("AEK",summaryGradeData.get("Algorithm").toString());
                    }else{
                        Log.w(TAG, "No such document");
                    }
                }else {
                    Log.e(TAG,"Error Getting Documents.", task.getException());
                }
            }
        });
        docUserReference = colUserReference.document("Detailed Grade");
        docUserReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, document.getId() + "=>" + document.getData());
                        detailedGradeData = document.getData();
                        Log.d("AEK",detailedGradeData.get("Algorithm").toString());
                        bundleForDetailedGrade.putSerializable("detailedGrade", (Serializable) detailedGradeData);
                        detailedGradeData = (Map<String, Object>) bundleForDetailedGrade.getSerializable("detailedGrade");
                        Log.d("AEK",detailedGradeData.get("Algorithm").toString());
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
                i.putExtra("summaryGrade", bundleForSummaryGrade);
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle("summaryInBundle", bundleForSummaryGrade);
        //outState.putParcelable("summary", (Parcelable) summaryGradeData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.summaryGradeData.size());
        for (Map.Entry<String, Object> entry : this.summaryGradeData.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable((Parcelable) entry.getValue(), flags);
        }
    }

    public MainPage() {
    }

    protected MainPage(Parcel in) {
        int summaryGradeDataSize = in.readInt();
        this.summaryGradeData = new HashMap<String, Object>(summaryGradeDataSize);
        for (int i = 0; i < summaryGradeDataSize; i++) {
            String key = in.readString();
            Object value = in.readParcelable(Object.class.getClassLoader());
            this.summaryGradeData.put(key, value);
        }
    }

    public static final Parcelable.Creator<MainPage> CREATOR = new Parcelable.Creator<MainPage>() {
        @Override
        public MainPage createFromParcel(Parcel source) {
            return new MainPage(source);
        }

        @Override
        public MainPage[] newArray(int size) {
            return new MainPage[size];
        }
    };
}
