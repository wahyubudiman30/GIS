package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DashboardAdminActivity extends AppCompatActivity {

    private TextView nama, email, telepon;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        nama = findViewById(R.id.prfnama);
        email = findViewById(R.id.prfemail);
        telepon = findViewById(R.id.prftelepon);
        requestQueue = Volley.newRequestQueue(this);

        String loginId = "1";

        String url = "http://192.168.1.23/ApiEvakuasiBencana/profil.php?id=" + loginId;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Ambil data dari JSON response dan tampilkan
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject dataObject = response.getJSONObject(i);
                                String data = dataObject.getString("your_data_column");
                                nama.append(data + "\n");
                                email.append(data + "\n");
                                telepon.append(data + "\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        requestQueue.add(jsonArrayRequest);

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