package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


public class moti extends AppCompatActivity {
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FirebaseAuth auth;
    ActionBar actionbar;
    ImageView im,mm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moti);

        im=findViewById(R.id.imageView6);
        mm=findViewById(R.id.imageView7);
        im.setVisibility(View.VISIBLE);
        mm.setVisibility(View.VISIBLE);

        setUpToolbar();
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        finish();
                        Intent intent = new Intent(moti.this, moti.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_notify:
                        finish();
                        Intent intent1 = new Intent(moti.this, add.class);
                        startActivity(intent1);
                        Toast.makeText(moti.this, "no notifications", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_rec:
                        Toast.makeText(moti.this, "yeah this is recent", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_track:
                        Toast.makeText(moti.this, "yeah this is track", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_set1:
                        Toast.makeText(moti.this, "yeah this is settings", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_about1:
                        Toast.makeText(moti.this, "we are great", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_cont1:
                        Toast.makeText(moti.this, "hiiiiiiii", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_logout1:
                        logOut();
                }
                return false;
            }
        });


    }

    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout1);
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    public void logOut(){
            auth=FirebaseAuth.getInstance();
            auth.signOut();
            finish();
            Intent intent = new Intent(moti.this,student.class);
            startActivity(intent);
        }
    }


