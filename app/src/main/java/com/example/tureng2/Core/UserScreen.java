package com.example.tureng2.Core;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.example.tureng2.Authentication.Login.loggedUser;


public class UserScreen extends AppCompatActivity {

    private TextView sendMail;

    private TextView email, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userscreen);

        try {
            TypefaceProvider.registerDefaultIconSets();

            email = findViewById(R.id.email);
            score = findViewById(R.id.score);
            sendMail = findViewById(R.id.btn_sendEmail);

            email.setVisibility(View.INVISIBLE);
            score.setVisibility(View.INVISIBLE);

            getInfo();
        }
        catch (Exception e)
        {
            Log.e("Core/UserScreen","OnCreate Exception", e);
        }
    }

    public void getInfo() {
        try {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference docRef = db.collection("users").document(loggedUser);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null) {
                            //Log.d("", "DocumentSnapshot data: " + task.getResult().getData());
                            String id = task.getResult().getData().get("id").toString();
                            String scorex = task.getResult().getData().get("score").toString();
                            email.setText(id);
                            score.setText(scorex);
                            email.setVisibility(View.VISIBLE);
                            score.setVisibility(View.VISIBLE);
                        } else {
                            //Log.d("FirestoreDemo", "No such document");
                        }
                    } else {
                        //Log.d("FirestoreDemo", "get failed with ", task.getException());
                    }
                }
            });
        }
        catch (Exception e)
        {
            Log.e("Core/UserScreen","GetInfo Exception", e);
        }
    }


    @SuppressLint("IntentReset")
    public void sendEmail(View view) {
        Log.i("Send email", "");
        String[] TO = {"lixt1@outlook.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        //emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Göndereceğiniz mailin konusunu buraya yazın");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Mailinizi buraya yazın");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Mail gönderildi", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "E-Mail istemcisi yüklü değil.", Toast.LENGTH_SHORT).show();
        }
    }

}
