package com.example.cms_admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity
{
    public EditText user_name;
    public EditText user_pass;
    public Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        user_name = findViewById(R.id.ed_username);
        user_pass = findViewById(R.id.ed_pass);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(view -> {

            /*Database code here
              validate admin from firebase and then execute below code
            */

            Toast.makeText(AdminLogin.this, "Clicked", Toast.LENGTH_SHORT).show();
            if (user_name.getText().toString().equals("admin") && user_pass.getText().toString().equals("admin@123456"))
            {
                Toast.makeText(AdminLogin.this, "Validated", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
