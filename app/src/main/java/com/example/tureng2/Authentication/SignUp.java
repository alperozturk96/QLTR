package com.example.tureng2.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {

    private BootstrapEditText edt_email, edt_password, edt_password2;
    private String str_email, str_password, str_password2;
    private BootstrapButton btnSignUp;
    private FirebaseAuth auth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TypefaceProvider.registerDefaultIconSets();

        auth = FirebaseAuth.getInstance();

        btnSignUp = findViewById(R.id.btn_create_user);
        edt_email = findViewById(R.id.e_mail);
        edt_password = findViewById(R.id.password);
        edt_password2 = findViewById(R.id.password_repeat);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    str_email = edt_email.getText().toString();
                    str_password = edt_password.getText().toString().trim();
                    str_password2 = edt_password2.getText().toString().trim();

                    if (str_password.equals(str_password2)) {
                        addAuth(str_email, str_password);
                        addDocument(str_email, str_password);
                    } else {
                        Toast.makeText(SignUp.this, "Girilen şifre aynı değil, lütfen tekrar kontrol ediniz.", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    Log.e("Authentication/SignUp","Sign Up Button Exception", e);
                }
                //startActivity(new Intent(signup.this, loginscreen.class));
                //finish();
            }
        });
    }

    public void returnLoginOnClick(View view) {
        try {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Authentication/SignUp","Intent Exception", e);
        }
    }


    public void addAuth(String str_email, String str_password) {
        try {
            auth.createUserWithEmailAndPassword(str_email, str_password)
                    .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(SignUp.this, "Kayıt işlemi başarı ile tamamlandı.", Toast.LENGTH_SHORT).show();
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Kayıt işlemi başarız.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUp.this, "Kayıt işlemi başarı ile tamamlandı.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        catch (Exception e)
        {
            Log.e("Authentication/SignUp","Adding Authentication Into Database Exception", e);
        }
        //Login sayfasına düşmüyor, yanlış feedback veriyor.
    }

    public void addDocument(String str_email, final String str_password) {
        try {
            if (TextUtils.isEmpty(str_email)) {
                Toast.makeText(getApplicationContext(), "Lütfen geçerli bir e-mail adresi girin.", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(str_password)) {
                Toast.makeText(getApplicationContext(), "Lütfen bir şifre giriniz.", Toast.LENGTH_SHORT).show();
            } else if (str_password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Şifre minimum 6 karakter içermelidir.", Toast.LENGTH_SHORT).show();
            } else {

                Map<String, Object> user = new HashMap<>();
                user.put("id", str_email);
                user.put("password", str_password);
                user.put("score", 0);
                db.collection("users")
                        .document(str_email)
                        .set(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void thisVoid) {
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                            }
                        });


            }
        }
        catch (Exception e)
        {
            Log.e("Authentication/SignUp","Adding Document Into Database Exception", e);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}




