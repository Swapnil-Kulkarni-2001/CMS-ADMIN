package com.example.cms_admin;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.checkbox.MaterialCheckBox;

import cn.pedant.SweetAlert.SweetAlertDialog;
import papaya.in.sendmail.SendMail;

public class CreateClub extends AppCompatActivity
{
    public EditText club_email;
    public EditText club_pass;
    public EditText club_conf_pass;
    public EditText dialog_pass;
    public AppCompatButton dialog_btn;
    public MaterialCheckBox cb_agree;
    public MaterialCheckBox cb_terms;
    public AppCompatButton btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_club);

        club_email = findViewById(R.id.ed_club_email);
        club_pass = findViewById(R.id.ed_pass);
        club_conf_pass = findViewById(R.id.ed_conf_pass);
        cb_agree = findViewById(R.id.cb_agree);
        cb_terms = findViewById(R.id.cb_terms);
        btn_create = findViewById(R.id.btn_create);

        cb_agree.setOnClickListener(view -> {
            if (cb_agree.isChecked() == true && cb_terms.isChecked() == true)
            {
                btn_create.setEnabled(true);
            }
            else
            {
                btn_create.setEnabled(false);
            }
        });

        cb_terms.setOnClickListener(view -> {
            if (cb_terms.isChecked() == true && cb_agree.isChecked() == true)
            {
                btn_create.setEnabled(true);
            }
            else
            {
                btn_create.setEnabled(false);
            }
        });

        btn_create.setOnClickListener(view -> {
            Toast.makeText(CreateClub.this, "Clicked", Toast.LENGTH_SHORT).show();
            if(club_email.getText().toString().equals("") || club_pass.getText().toString().equals("")
                    || club_conf_pass.getText().toString().equals(""))
            {
                new SweetAlertDialog(
                        CreateClub.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show();

            }
            else if(!(club_pass.getText().toString().equals(club_conf_pass.getText().toString())))
            {
                new SweetAlertDialog(
                        CreateClub.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Error")
                        .setContentText("Password not matches!")
                        .show();
            }
            else
            {
                final AlertDialog.Builder alert = new AlertDialog.Builder(CreateClub.this);
                View view2 = getLayoutInflater().inflate(R.layout.password_dialog,null);
                alert.setView(view2);
                final AlertDialog alertDialog = alert.create();

                dialog_pass = view2.findViewById(R.id.ed_dialog_pass);
                dialog_btn = view2.findViewById(R.id.ed_dialog_btn_create);

                dialog_btn.setOnClickListener(view1 -> {
                    if (dialog_pass.getText().toString().equals("admin@123456"))
                    {
                        alertDialog.cancel();
                        String email = club_email.getText().toString();
                        String pass = club_pass.getText().toString();
                        SendMail mail = new SendMail("clubmanagementsystem84@gmail.com","cms@989810",
                                email,
                                "Club Credentials",
                                "Club account username : "+email+"\n"+"Club account password : "+pass);
                        mail.execute();
                        SweetAlertDialog dialog = new SweetAlertDialog(CreateClub.this,SweetAlertDialog.SUCCESS_TYPE);
                        dialog.setCancelable(false);
                        dialog.setTitleText("Success");
                        dialog.setContentText("Club credentials created");
                        dialog.setConfirmClickListener(sweetAlertDialog -> finish());
                        dialog.show();
                    }
                });

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }
        });
    }
}
