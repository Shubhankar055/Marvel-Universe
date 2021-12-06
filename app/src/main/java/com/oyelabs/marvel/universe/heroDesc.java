package com.oyelabs.marvel.universe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class heroDesc extends AppCompatActivity {
    TextView TVDescription;
    ImageView IVhero;

    String ImgURL,Desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_desc);

        Toolbar toolbar = findViewById(R.id.toolbar);

        Intent i = getIntent();

        String Name = i.getStringExtra("NAME");

        ImgURL = i.getStringExtra("URL");
        Desc = i.getStringExtra("DESC");

        toolbar.setTitle(Name);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //INITIALISING VARIABLES

        TVDescription = findViewById(R.id.gridText);
        IVhero = findViewById(R.id.gridImage);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}