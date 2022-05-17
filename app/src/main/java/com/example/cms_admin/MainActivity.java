package com.example.cms_admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public ArrayList<Club_Details> clubArrayList;
    public CustomAdapter adapter;
    public EditText searchView;
    public FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clubArrayList = new ArrayList<>();

        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("WLUG","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("ACSES","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("PACE","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("ACM Student Chapter","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("Roteract","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("CLUB 1 ","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("CLUB 2","Departmental club",R.drawable.img));

        adapter = new CustomAdapter(clubArrayList);
        recyclerView.setAdapter(adapter);

        searchView = findViewById(R.id.ed_search);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        floatingActionButton.setOnClickListener(view -> {

            Toast.makeText(getApplicationContext(),"FAB Clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,CreateClub.class);
            startActivity(intent);

        });
    }


    private void filter(String text) {
        ArrayList<Club_Details> filteredlist = new ArrayList<>();
        for (Club_Details item : clubArrayList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {

            adapter.filterList(filteredlist);
        }
    }

}