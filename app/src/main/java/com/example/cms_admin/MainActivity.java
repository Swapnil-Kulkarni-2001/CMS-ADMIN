package com.example.cms_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public ArrayList<Club_Details> clubArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clubArrayList = new ArrayList<>();

        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("WLUG","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("SAIT","Departmental club",R.drawable.img));

        recyclerView.setAdapter(new CustomAdapter(clubArrayList));



    }
}