package com.example.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.Random;

public class StudentEntry extends AppCompatActivity {
    Button btnEntry;
    ImageButton randomButton;

    EditText dogrulama;
    EditText txtEmail;
    EditText txtPassword;

    TextView txtPostaUzn;

    String strEmail;
    String strPassword;

    private FirebaseAuth mAuth;
    private String TAG = "Authentication";

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

        txtEmail = (EditText) findViewById(R.id.edtPosta);
        txtPassword = (EditText) findViewById(R.id.edtPassword);
        txtPostaUzn = findViewById(R.id.txtPostaUzantisi);

        final TextView sayilarToplami  = (TextView) findViewById(R.id.textView6);

        btnEntry = findViewById(R.id.btnEntry);
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = txtEmail.getText().toString() + "" + txtPostaUzn.getText().toString();
                strPassword = txtPassword.getText().toString();
                Log.d("AEK",strEmail);
                Log.d("AEK",strPassword);
                signIn(strEmail,strPassword);
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

    public void signIn(String email, String password){
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
        Log.d("AEK",email);
        if (TextUtils.isEmpty(email)) {
            txtEmail.setError("Required.");
            valid = false;
        } else {
            txtEmail.setError(null);
        }

        String password = txtPassword.getText().toString();
        Log.d("AEK",password);
        if (TextUtils.isEmpty(password)) {
            txtPassword.setError("Required.");
            valid = false;
        } else {
            txtPassword.setError(null);
        }

        return valid;
    }
}
