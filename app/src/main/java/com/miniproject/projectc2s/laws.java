package com.miniproject.projectc2s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class laws extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.law);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                NavigationActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.law:
                        return true;

                    case R.id.map:
                        startActivity(new Intent(getApplicationContext(),
                                maps.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.video:
                        startActivity(new Intent(getApplicationContext(),
                                video.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.helpline:
                        startActivity(new Intent(getApplicationContext(),
                                helpline.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }
}