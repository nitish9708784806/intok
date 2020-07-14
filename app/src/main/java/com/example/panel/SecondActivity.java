package com.example.panel;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

import static com.example.panel.R.*;
import static com.example.panel.R.string.*;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int SELECT_IMAGE = 0;
    private DrawerLayout drawer;
    private int requestCode;
    private int resultCode;
    private Intent data;

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


//TO OPEN CAMERA
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
            }
        }


        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = data;
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1234:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    assert selectedImage != null;
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                    /* Now you have choosen image in Bitmap format in object "yourSelectedImage". You can use it in way you want! */
                }
        }

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
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new dashboardfragment()).commit();


               break;

           case id.admin:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new adminfragment()).commit();

               break;


           case id.b_images:


               View.OnClickListener btnChoosePhotoPressed = new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(Intent.ACTION_PICK,
                               android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                       final int ACTIVITY_SELECT_IMAGE = 1234;
                       startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
                   }
               };



               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new bimagefragment()).commit();

               break;


           case id.image:

               Intent intent = new Intent();
               intent.setType("image/*");
               intent.setAction(Intent.ACTION_GET_CONTENT);
               startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);


               break;


           case id.messages:
               getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new messagesfragment()).commit();

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
