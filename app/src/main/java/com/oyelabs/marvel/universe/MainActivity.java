package com.oyelabs.marvel.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
//import android.widget.Toolbar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oyelabs.marvel.universe.adapters.gridAdapter;
import com.oyelabs.marvel.universe.models.marvelData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String url = "https://gateway.marvel.com/v1/public/characters?limit=7" +
            "0&offset=0&ts=n2&apikey=a63ab407257f9ea65a55b8044240838a&hash=" +
            "9fea84ee6ad1dcab6ec2d6d2db7de855";

    RecyclerView recyclerView;
    ArrayList<marvelData> marvellist;
    gridAdapter gridAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Marvel Universe ");
        setSupportActionBar(toolbar);

        marvellist = new ArrayList<>();

        //downloading data using volley library

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("C",response+"KKK");
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("results");
                    Log.d("D",jsonArray.toString());

                    for(int i  = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject data = jsonArray.getJSONObject(i);

                        String imgurl = data.getJSONObject("thumbnail").getString("path");
                        String imgformat = data.getJSONObject("thumbnail").getString("extension");

                        String imageURI = imgurl + "." + imgformat;


                        Log.d("IMG", "onResponse: " + imageURI);

                        marvellist.add(new marvelData(imageURI,data.getString("name"),
                                data.getString("id"),data.getString("description")));
                    }

                    recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                    gridAdapter = new gridAdapter(marvellist,getApplicationContext());
                    recyclerView.setAdapter(gridAdapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Volley.newRequestQueue(getApplicationContext()).add(request);

        //intialising variables
        recyclerView = findViewById(R.id.marvelblocks);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchbutton,menu);
        MenuItem item = menu.findItem(R.id.searchbtn1);


        SearchView searchView =(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //made static from the suggestion of the editor
                gridAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }



}