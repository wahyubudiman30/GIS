package com.wahyu.evakuasibencana;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TambahakunActivity extends AppCompatActivity {
    private EditText username, ttl, jk, telepon, jabatan, alamat, email, password, confPassword;
    private Button BtnRegister;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahakun);

        username = findViewById(R.id.TxUsernameBaru);
        ttl = findViewById(R.id.TxTtlAdminBaru);
        jk = findViewById(R.id.TxJenisKelaminBaru);
        telepon = findViewById(R.id.TxTeleponBaru);
        jabatan = findViewById(R.id.TxJabatanBaru);
        alamat = findViewById(R.id.TxAlamatBaru);
        email = findViewById(R.id.TxEmailBaru);
        password = findViewById(R.id.TxPassAdmBaru);
        confPassword = findViewById(R.id.TxConfPassAdmBaru);
        BtnRegister = findViewById(R.id.BtnRegister);
        progressDialog = new ProgressDialog(TambahakunActivity.this);

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername = username.getText().toString();
                String sTtl = ttl.getText().toString();
                String sJk = jk.getText().toString();
                String sTelepon = telepon.getText().toString();
                String sJabatan = jabatan.getText().toString();
                String sAlamat = alamat.getText().toString();
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                String sConfPassword = confPassword.getText().toString();

                if (sPassword.equals(sConfPassword) && !sPassword.equals("")) {
                    CreateDataToServer(sUsername,sTtl,sJk,sTelepon,sJabatan,sAlamat, sEmail, sPassword);
                    Intent loginIntent = new Intent(TambahakunActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Gagal! Pasword tidak cocok!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void CreateDataToServer(final String username, final String ttl, final String jk, final String telepon, final String jabatan, final String alamat, final String email, final String password) {
        if (checkNetworkConnection()) {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String resp = jsonObject.getString("server_response");
                                if (resp.equals("[{\"status\":\"OK\"}]")) {
                                    Toast.makeText(getApplicationContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), resp, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", username);
                    params.put("ttl", ttl);
                    params.put("jk", jk);
                    params.put("telepon", telepon);
                    params.put("jabatan", jabatan);
                    params.put("alamat", alamat);
                    params.put("email", email);
                    params.put("password", password);
                    return params;
                }
            };

            VolleyConnection.getInstance(TambahakunActivity.this).addToRequestQue(stringRequest);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();
                }
            }, 2000);
        } else {
            Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkNetworkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}