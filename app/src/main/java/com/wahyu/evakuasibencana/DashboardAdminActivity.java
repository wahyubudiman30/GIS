package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
    }

    public void Pengungsian(View view) {
        Intent pengungsian = new Intent(DashboardAdminActivity.this, PengungsianActivity.class);
        startActivity(pengungsian);
    }

    public void About(View view) {
        Intent about = new Intent(DashboardAdminActivity.this, AboutActivity.class);
        startActivity(about);
    }

    public void Profile(View view) {
        Intent profil = new Intent(DashboardAdminActivity.this, ProfilActivity.class);
        startActivity(profil);
    }


    public void Setting(View view) {
        Intent setting = new Intent(DashboardAdminActivity.this, SettingtActivity.class);
        startActivity(setting);
    }

    public void Maps(View view) {
        Intent contact = new Intent(DashboardAdminActivity.this, MapsAdminActivity.class);
        startActivity(contact);
    }
}