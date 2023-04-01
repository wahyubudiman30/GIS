package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class UbahprofilActivity extends AppCompatActivity {

    private EditText EdID;
    private EditText EdNama;
    private EditText EdEmail;
    private EditText EdTTL;
    private EditText EdJK;
    private EditText EdTelepon;
    private EditText EdJabatan;
    private EditText EdAlamat;

    private Button BtnSimpan;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubahprofil);

        Intent intent = getIntent();

        id = intent.getStringExtra(DbContract.EMP_ID_ADM);

        EdID = (EditText) findViewById(R.id.TxID);
        EdNama = (EditText) findViewById(R.id.TxEmail);
        EdEmail = (EditText) findViewById(R.id.TxEmail);
        EdTTL = (EditText) findViewById(R.id.TxTtlAdmin);
        EdJK = (EditText) findViewById(R.id.TxJenisKelamin);
        EdTelepon = (EditText) findViewById(R.id.TxTelepon);
        EdJabatan = (EditText) findViewById(R.id.TxJabatan);
        EdAlamat = (EditText) findViewById(R.id.TxAlamat);

        BtnSimpan = (Button) findViewById(R.id.BtnSimpanProfil);

        BtnSimpan.setOnClickListener(this::onClick);

        EdID.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UbahprofilActivity.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(DbContract.URL_GET_EMP_ADM,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(DbContract.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String nama = c.getString(DbContract.TAG_NAMA_ADM);
            String email = c.getString(DbContract.TAG_EMAIL_ADM);
            String ttl = c.getString(DbContract.TAG_TTL_ADM);
            String jk = c.getString(DbContract.TAG_JK_ADM);
            String telepon = c.getString(DbContract.TAG_TELEPON_ADM);
            String jabatan = c.getString(DbContract.TAG_JABATAN_ADM);
            String alamat = c.getString(DbContract.TAG_ALAMAT_ADM);

            EdNama.setText(nama);
            EdEmail.setText(email);
            EdTTL.setText(ttl);
            EdJK.setText(jk);
            EdTelepon.setText(telepon);
            EdJabatan.setText(jabatan);
            EdAlamat.setText(alamat);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void simpanEmployee(){
        final String name = EdNama.getText().toString().trim();
        final String email = EdEmail.getText().toString().trim();
        final String ttl = EdTTL.getText().toString().trim();
        final String jk = EdJK.getText().toString().trim();
        final String telepon = EdTelepon.getText().toString().trim();
        final String jabatan = EdJabatan.getText().toString().trim();
        final String alamat = EdAlamat.getText().toString().trim();

        class simpanEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UbahprofilActivity.this,"Updating...","Wait...",false,false);
                Intent intent= new Intent(UbahprofilActivity.this, ProfilActivity.class);
                startActivity(intent);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(UbahprofilActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(DbContract.KEY_EMP_ID_ADM,id);
                hashMap.put(DbContract.KEY_EMP_NAMA_ADM,name);
                hashMap.put(DbContract.KEY_EMP_EMAIL_ADM,email);
                hashMap.put(DbContract.KEY_EMP_TTL_ADM,ttl);
                hashMap.put(DbContract.KEY_EMP_JK_ADM,jk);
                hashMap.put(DbContract.KEY_EMP_TELEPON_ADM,telepon);
                hashMap.put(DbContract.KEY_EMP_JABATAN_ADM,jabatan);
                hashMap.put(DbContract.KEY_EMP_ALAMAT_ADM,alamat);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(DbContract.URL_UPDATE_EMP_ADM,hashMap);

                return s;
            }
        }

        simpanEmployee ue = new simpanEmployee();
        ue.execute();
    }

    public void onClick(View v) {
        if(v == BtnSimpan){
            simpanEmployee();
        }
    }
}