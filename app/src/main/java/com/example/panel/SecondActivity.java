package com.example.panel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import static com.example.panel.R.id;
import static com.example.panel.R.layout;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    private DrawerLayout drawer;
    private CardView card1,card2,card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_second);

        card1=(CardView)  findViewById(R.id.c1);
        card2=(CardView)  findViewById(R.id.c2);
        card3=(CardView)  findViewById(R.id.c3);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);



        drawer = findViewById(id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private Context getActivity() {
        return null;
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

              Intent intent=new Intent(SecondActivity.this,SecondActivity.class);
              startActivity(intent);
               break;

           case id.admin:
               Intent intent1=new Intent(SecondActivity.this,admin.class);
               startActivity(intent1);
               break;

           case id.messages:
               Intent intent2=new Intent(SecondActivity.this,Total_message.class);
               startActivity(intent2);
               break;


           case id.addmi:
               Intent intent3=new Intent(SecondActivity.this,enquiry.class);
               startActivity(intent3);

               break;


           case id.notic:
               Intent intent4=new Intent(SecondActivity.this,notice.class);
               startActivity(intent4);
               break;


           case id.country:
               Intent intent5 =new Intent(SecondActivity.this,country.class);
               startActivity(intent5);

               break;
           case id.city:
               Intent intent6=new Intent(SecondActivity.this,city.class);
               startActivity(intent6);

               break;


           case id.sub:
               Intent intent7=new Intent(SecondActivity.this,hotel.class);
               startActivity(intent7);
               break;

       }
        return true;

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.c1){
            Intent intent=new Intent(SecondActivity.this,Total_message.class);
            startActivity( intent);
        }
        if(v.getId()==R.id.c2){
            Intent intent1=new Intent(SecondActivity.this,new_message.class);
            startActivity(intent1);

        }
        if(v.getId()==R.id.c3)
        {
            Intent intent2=new Intent(SecondActivity.this,subscryption.class);
            startActivity(intent2);
        }

    }
}
