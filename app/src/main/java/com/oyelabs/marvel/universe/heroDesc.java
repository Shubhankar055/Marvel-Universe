package com.oyelabs.marvel.universe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

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

        //SETTING IMAGE AND DESC

//        Picasso.get()
//                .load("https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
//                .resize(50, 50)
//                .centerCrop()
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(IVhero);

        Glide.with(this)
                .load(ImgURL)
                .into(IVhero);

        if(Desc.isEmpty()){
            TVDescription.setText("No Description Found");
        }

        else {
            TVDescription.setText(Desc);
        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}