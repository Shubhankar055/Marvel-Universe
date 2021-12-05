package com.oyelabs.marvel.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Toolbar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oyelabs.marvel.universe.adapters.gridAdapter;
import com.oyelabs.marvel.universe.models.marvelData;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<marvelData> marvellist;
    gridAdapter gridAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Marvel Universe...");
        setSupportActionBar(toolbar);

        //getMenuInflater().inflate(R.menu.searchbutton, menu);

        //intialising variables
        recyclerView = findViewById(R.id.marvelblocks);

        //populating arraylist
        marvellist = new ArrayList<>();

        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));
        marvellist.add(new marvelData("hello","hello","hello"));


        //temporary checking recyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        gridAdapter = new gridAdapter(marvellist,getApplicationContext());
        recyclerView.setAdapter(gridAdapter);



    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.searchbutton,menu);
//        MenuItem item = menu.findItem(R.id.searchbtn);
//
//        SearchView searchView = (SearchView) item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                //made static from the suggestion of the editor
//                gridAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }
}