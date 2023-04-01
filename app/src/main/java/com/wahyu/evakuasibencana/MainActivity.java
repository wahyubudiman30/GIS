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

        BtnPengguna = (Button) findViewById(R.id.BtnPengguna);

        BtnPengguna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, DashboardUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public void LoginAdm(View view) {
        Intent LogAdm = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(LogAdm);
    }
}