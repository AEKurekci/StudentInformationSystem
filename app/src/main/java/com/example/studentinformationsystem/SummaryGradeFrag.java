package com.example.studentinformationsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryGradeFrag extends Fragment {

    final List<Nots> nots = new ArrayList<>();
    private Map<String, Object> data = new HashMap<>();
    private String TAG = "FirebaseSummaryGrade";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docUser = db.collection("160709031").document("SummaryGrade");
        docUser.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, document.getId() + "=>" + document.get("Algorithm"));
                        data = (Map<String, Object>) document.get("Algorithm");
                        Log.d("Public data", data.get("durumu").toString());
                    }else{
                        Log.w(TAG, "No such document");
                    }
                }else {
                    Log.e(TAG,"Error Getting Documents.", task.getException());
                }
            }
        });

        nots.add(new Nots("Algorithm",65,75,"BB","Geçti"));
        nots.add(new Nots("Grafical User Interface",75,85,"AA","Geçti"));
        nots.add(new Nots("Artificial Intelligence",45,65,"CB","Geçti"));
        nots.add(new Nots("Siber Security",15,45,"FF","Kaldı"));
        nots.add(new Nots("Network",62,70,"BA","Geçti"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary_grade_layout, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.listGrades);

        SummaryAdapter adapter = new SummaryAdapter(SummaryGradeFrag.this, nots);
        lv.setAdapter(adapter);

        return view;
    }

}
