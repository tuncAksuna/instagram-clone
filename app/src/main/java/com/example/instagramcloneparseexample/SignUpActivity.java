package com.example.instagramcloneparseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    EditText userNameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userNameText = findViewById(R.id.sign_up_activity_name_text);
        passwordText = findViewById(R.id.sign_up_activity_password_text);

        //GİRİŞ YAPMIŞ BİR KULLANICI VARSA
        ParseUser parseUser = ParseUser.getCurrentUser();
        if (parseUser != null) {
            Intent intentToFeed = new Intent(getApplicationContext(), FeedActivity.class);
            startActivity(intentToFeed);
        }
    }

    public void signIn(View view) {
        ParseUser.logInInBackground(userNameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    //KULLANICI ÖRN ŞİFREYİ YANLIŞ GİRDİYSE
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                } else {
                    //GİRİLEN BİLGİLER DOĞRUYSA
                    Toast.makeText(getApplicationContext(), "Welcome " + user.getUsername(), Toast.LENGTH_LONG).show();
                    //intent ile feed'e aktaralım
                    Intent intentToFeed = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity(intentToFeed);
                }
            }
        });
    }

    public void signUp(View view) {
        final ParseUser user = new ParseUser();
        user.setUsername(userNameText.getText().toString());
        user.setPassword(passwordText.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "The User Created " + "Welcome : " +
                            userNameText.getText(), Toast.LENGTH_LONG).show();
                    //intent ile feed'e aktaralım
                    Intent intentToFeed = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity(intentToFeed);
                }
            }
        });

    }
}