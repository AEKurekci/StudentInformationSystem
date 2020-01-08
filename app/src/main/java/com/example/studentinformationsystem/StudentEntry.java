package com.example.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StudentEntry extends AppCompatActivity {
    Button btnEntry;
    ImageButton randomButton;

    EditText txtEmail;
    EditText txtPassword;

    TextView txtPostaUzn;
    TextView txtSecureCode;

    String strEmail;
    String strPassword;

    private FirebaseAuth mAuth;
    private String TAG = "Authentication";
    private String TAGFire = "Firebase";
    private FirebaseFirestore dbOfUser;
    private CollectionReference colRef;
    private DocumentReference docRef;

    Random randomNumberCreater = new Random();
    Integer RANDOM_NUMBER_1;
    Integer RANDOM_NUMBER_2;

    String randomToShowforUser;
    TextView sumOfRandoms;

    Map<String, Object> emails = new HashMap<>();

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_entry);

        mAuth = FirebaseAuth.getInstance();
        dbOfUser = FirebaseFirestore.getInstance();
        colRef = dbOfUser.collection("emails");
        docRef = colRef.document("users");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()){
                        emails = document.getData();
                    }else {
                        Log.w(TAGFire, "No such document");
                    }
                }else{
                    Log.e(TAGFire,"Error Getting Documents.", task.getException());
                }
            }
        });

        txtEmail = findViewById(R.id.edtPosta);
        txtPassword = findViewById(R.id.edtPassword);
        txtPostaUzn = findViewById(R.id.txtPostaUzantisi);
        txtSecureCode = findViewById(R.id.edtSecureCode);

        sumOfRandoms = findViewById(R.id.txtShowingRandom);

        btnEntry = findViewById(R.id.btnEntry);
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = txtEmail.getText().toString() + "" + txtPostaUzn.getText().toString();
                strPassword = txtPassword.getText().toString();
                if(checkRandoms())
                    signIn(strEmail,strPassword);
            }
        });

        randomNumberCreate();
        //make new randoms
        randomButton = findViewById(R.id.refreshButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumberCreate();
            }
        });
    }

    private void randomNumberCreate(){
        //created 2 random numbers
        RANDOM_NUMBER_1 = randomNumberCreater.nextInt(99);
        RANDOM_NUMBER_2 = randomNumberCreater.nextInt(99);

        //set to TextView
        randomToShowforUser = RANDOM_NUMBER_1.toString() +" + "+ RANDOM_NUMBER_2.toString();
        sumOfRandoms.setText(randomToShowforUser);
    }

    private boolean checkRandoms() {
        if (!validateForm())
            return false;

        Log.d("AEK","checkRandoms");
        String code = txtSecureCode.getText().toString();
        Integer sum = RANDOM_NUMBER_1 + RANDOM_NUMBER_2;
        Integer codeInt = Integer.parseInt(code);
        if (sum.equals(codeInt))
            return true;
        else
            return false;
    }

    public void signIn(final String email, String password){
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Intent i = new Intent(StudentEntry.this, MainPage.class);
                            FirebaseUser user = mAuth.getCurrentUser();

                            Log.d("USER ", user.getEmail());
                            i.putExtra("theUser", user);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(StudentEntry.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = txtEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            txtEmail.setError("Required.");
            valid = false;
        } else {
            txtEmail.setError(null);
        }

        String password = txtPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            txtPassword.setError("Required.");
            valid = false;
        } else {
            txtPassword.setError(null);
        }

        String secureCode = txtSecureCode.getText().toString();
        if (TextUtils.isEmpty(secureCode)) {
            txtSecureCode.setError("Required.");
            valid = false;
        } else {
            txtSecureCode.setError(null);
        }

        return valid;
    }

    class DataBaseTask extends AsyncTask<String, Object, Object>{

        @Override
        protected Object doInBackground(String... studentNumber) {
            
            return null;
        }
    }
}
