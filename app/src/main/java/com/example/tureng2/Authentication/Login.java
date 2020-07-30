package com.example.tureng2.Authentication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    public static String loggedUser;
    public static int loggedScore;

    private BootstrapEditText edt_Email, edt_Password;
    private BootstrapButton sign_up,login,refresh;
    private FirebaseAuth auth;
    private TextView forgotPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        TypefaceProvider.registerDefaultIconSets();

        refresh = findViewById(R.id.refresh);
        sign_up = findViewById(R.id.btn_signup);
        edt_Email = findViewById(R.id.e_mail);
        edt_Password = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        forgotPasswd = findViewById(R.id.btn_forgotPasswd);

        checkDeviceNetworkConnection();
    }

    public void loginIntoDatabase() {
        try {
            auth = FirebaseAuth.getInstance();

            forgotPasswd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, PasswordReset.class);
                    startActivity(intent);
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email = edt_Email.getText().toString();
                    final String password = edt_Password.getText().toString();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Lütfen bir e-mail adresini giriniz.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(getApplicationContext(), "Lütfen bir şifre giriniz.", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    //authenticate user
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        if (password.length() < 6) {
                                            Toast.makeText(getApplicationContext(), "Şifreniz en az 6 karakter içermelidir.", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Giriş başarısız e-mail ya da şifre hatalı olabilir.", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Başarılı bir şekilde girildi.", Toast.LENGTH_SHORT).show();
                                        loggedUser = email;
                                        getLoggedUserInfo();
                                        Intent intent = new Intent(Login.this, HomeScreen.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                }
            });
        }
        catch(Exception e)
        {
            Log.e("Authentication/Login","Login Exception", e);
        }
    }

    public void goToPasswordResetScreen(View view)
    {
        try {
            Intent intent = new Intent(this, PasswordReset.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Authentication/Login","Intent Exception", e);
        }
    }

    public void refreshOnClick(View view) {
        try {
            checkDeviceNetworkConnection();
        }
        catch (Exception e)
        {
            Log.e("Authentication/Login","Network Connection Check Exception", e);
        }
    }

    public void getLoggedUserInfo() {
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
                            String score = task.getResult().getData().get("score").toString();
                            loggedScore = Integer.parseInt((score));
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
            Log.e("Authentication/Login","Getting User Info Exception", e);
        }

    }

    public boolean checkDeviceNetworkConnection() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                refresh.setVisibility(View.INVISIBLE);
                forgotPasswd.setVisibility(View.VISIBLE);
                sign_up.setEnabled(true);
                login.setEnabled(true);
                forgotPasswd.setEnabled(true);
                loginIntoDatabase();
                return true;
            } else {
                Toast.makeText(getApplicationContext(), "İnternet Bağlantısı Yok.", Toast.LENGTH_SHORT).show();
                refresh.setVisibility(View.VISIBLE);
                forgotPasswd.setVisibility(View.INVISIBLE);
                sign_up.setEnabled(false);
                login.setEnabled(false);
                forgotPasswd.setEnabled(false);
                return false;
            }
        }
        catch(Exception e)
        {
            Log.e("Authentication/Login","Network Connection Check Exception", e);
            return false;
        }
    }

    public void goToSignUpScreen(View view) {
        try {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        }
        catch(Exception e)
        {
            Log.e("Authentication/Login","Intent Exception", e);
        }
    }
}


