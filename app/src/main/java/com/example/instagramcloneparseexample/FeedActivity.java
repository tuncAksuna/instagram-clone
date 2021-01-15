package com.example.instagramcloneparseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.LogOutCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MENÜYÜ AKTİVİTEYE BAĞLADIK.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //OPTIONSLARA TIKLANILIRSA NE OLACAK :
        if (item.getItemId() == R.id.add_post) {

            Intent intentToUpload = new Intent(getApplicationContext(), UploadActivity.class);
            startActivity(intentToUpload);

        } else if (item.getItemId() == R.id.logout) {
            ParseUser.logOutInBackground(new LogOutCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null) {
                        //ZOR DA OLSA HERHANGİ BİR HATA MEYDANA GELİRSE :
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    } else {
                        Intent intentToSignUp = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(intentToSignUp);
                    }
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
}