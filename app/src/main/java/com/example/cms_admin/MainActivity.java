package com.example.cms_admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public ArrayList<Club_Details> clubArrayList;
    public CustomAdapter adapter;
    public EditText searchView;
    public TextView txt_club_full_name;
    public TextView txt_club_creation_date;
    public AppCompatButton btn_delete;
    public FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clubArrayList = new ArrayList<>();

        clubArrayList.add(new Club_Details("SAIT","Student Association of Information Technology","21/6/2003","Departmental club",R.drawable.img));
        clubArrayList.add(new Club_Details("WLUG","Walchand Linux Users Group","4/2/2004","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("ACSES","Association of Computer Science and Engineering Students","23/12/1989","Departmental Club",R.drawable.img));
        clubArrayList.add(new Club_Details("PACE","Pace","12/12/22","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("ACM Student Chapter","ACM Student Chapter","19/10/2001","General club",R.drawable.img));
        clubArrayList.add(new Club_Details("Roteract","Roteract","10/10/2000","General club",R.drawable.img));
//        clubArrayList.add(new Club_Details("CLUB 1 ","Departmental club",R.drawable.img));
//        clubArrayList.add(new Club_Details("CLUB 2","Departmental club",R.drawable.img));

        adapter = new CustomAdapter(clubArrayList, cd -> {
            Toast.makeText(getApplicationContext(), cd.getName() +"Clicked",Toast.LENGTH_SHORT).show();
            final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            View view2 = getLayoutInflater().inflate(R.layout.club_account,null);
            alert.setView(view2);
            final AlertDialog alertDialog = alert.create();
            txt_club_full_name = view2.findViewById(R.id.txt_club_name);
            txt_club_creation_date = view2.findViewById(R.id.txt_date);
            btn_delete = view2.findViewById(R.id.btn_delete);
            txt_club_full_name.setText(cd.getFull_name());
            txt_club_creation_date.setText(cd.getDate());
            btn_delete.setOnClickListener(view -> {
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
                SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this,SweetAlertDialog.WARNING_TYPE);
                dialog.setTitleText("Are you Sure ?");
                dialog.setContentText("Want to delete this account ?");
                dialog.setConfirmClickListener(sweetAlertDialog -> {
                    Toast.makeText(getApplicationContext(),"Account Deleted",Toast.LENGTH_SHORT).show();
                    alertDialog.cancel();
                    dialog.cancel();
                });
                dialog.show();
            });
            alertDialog.show();
        });
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