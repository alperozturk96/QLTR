package com.example.tureng2.Database_Operations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tureng2.Authentication.Login;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.example.tureng2.Authentication.Login.loggedScore;
import static com.example.tureng2.Authentication.Login.loggedUser;

public class DbOperations extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Context context;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    public DbOperations(@NonNull Context context)
    {
        this.context = context;
    }

    public void wrongAnswer() {
        Toast.makeText(context, "Yanlış cevap verdiniz.", Toast.LENGTH_SHORT).show();
    }

    public void increaseScore(int score) {
        try {
            Map<String, Object> user = new HashMap<>();
            Log.d("", "SCORE IS -->" + loggedScore);
            loggedScore += score;
            //user.put("score",loggedScore);
            db.collection("users")
                    .document(loggedUser)
                    //.set(user)
                    .update("score", loggedScore)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void thisVoid) {
                            Toast.makeText(context, "Skorunuz başarı ile kaydedildi.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "Skorunuz kaydedilemedi.", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        catch (Exception e)
        {
            Log.e("DbOperations","IncreaseScore Exception", e);
        }
    }

    public void logout()
    {
        try {
            auth = FirebaseAuth.getInstance();
            auth.signOut();
            Intent intent = new Intent(context, Login.class);
            context.startActivity(intent);

            // this listener will be called when there is change in firebase user session
            FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user == null) {
                        // user auth state is changed - user is null
                        // launch login activity
                        Intent intent = new Intent(DbOperations.this, Login.class);
                        context.startActivity(intent);
                    }
                }
            };
        }
        catch (Exception e)
        {
            Log.e("DbOperations","Logout Exception", e);
        }
    }
}
