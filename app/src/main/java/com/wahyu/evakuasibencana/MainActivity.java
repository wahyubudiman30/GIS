package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button BtnPengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoginAdm(View view) {
        Intent LogAdm = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(LogAdm);
    }

    public void Adm(View view) {
        Intent Adm = new Intent(MainActivity.this, DashboardAdminActivity.class);
        startActivity(Adm);
    }

    public void LoginUser(View view) {
        Intent intent= new Intent(MainActivity.this, DashboardUserActivity.class);
        startActivity(intent);
    }
}