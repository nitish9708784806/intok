package com.example.panel;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

import static com.example.panel.R.*;
import static com.example.panel.R.string.*;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_second);


        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(id.drawer_layout);

        NavigationView navigationView = findViewById(id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case id.dashboard:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new dashboardfragment()).commit();

               break;

           case id.admin:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new adminfragment()).commit();

               break;


           case id.b_images:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new bimagefragment()).commit();

               break;


           case id.image:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new cameraragment()).commit();

               break;


           case id.message:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new messagefragment()).commit();

               break;


           case id.resume:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new resumefragment()).commit();

               break;


           case id.addmi:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new admissionfragment()).commit();

               break;


           case id.notic:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new noticefragment()).commit();

               break;

           case id.sub:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new subscryptionfragment()).commit();

               break;

       }
        return true;
    }
}
