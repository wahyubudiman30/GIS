package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

public class TampilLokasiActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText TampilID;
    private EditText TampilNama;
    private EditText TampilAlamat;
    private EditText TampilKelurahan;
    private EditText TampilKecamatan;
    private EditText TampilLatitude;
    private EditText TampilLongitude;


    private Button BtnUpdate;
    private Button BtnHapus;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_lokasi);

        Intent intent = getIntent();

        id = intent.getStringExtra(DbContract.EMP_ID);

        TampilID = (EditText) findViewById(R.id.TampilID);
        TampilNama = (EditText) findViewById(R.id.TampilNama);
        TampilAlamat = (EditText) findViewById(R.id.TampilAlamat);
        TampilKelurahan = (EditText) findViewById(R.id.TampilKelurahan);
        TampilKecamatan = (EditText) findViewById(R.id.TampilKecamatan);
        TampilLatitude = (EditText) findViewById(R.id.TampilLatitude);
        TampilLongitude = (EditText) findViewById(R.id.TampilLongitude);

        BtnUpdate = (Button) findViewById(R.id.BtnUpdate);
        BtnHapus = (Button) findViewById(R.id.BtnHapus);

        BtnUpdate.setOnClickListener(this);
        BtnHapus.setOnClickListener(this);

        TampilID.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilLokasiActivity.this,"Fetching...","Wait...",false,false);
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
                String s = rh.sendGetRequestParam(DbContract.URL_GET_EMP,id);
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
            String name = c.getString(DbContract.TAG_NAMA);
            String alamat = c.getString(DbContract.TAG_ALAMAT);
            String kel = c.getString(DbContract.TAG_KELURAHAN);
            String kec = c.getString(DbContract.TAG_KECAMATAN);
            String lat = c.getString(DbContract.TAG_LATITUDE);
            String longi = c.getString(DbContract.TAG_LONGITUDE);

            TampilNama.setText(name);
            TampilAlamat.setText(alamat);
            TampilKelurahan.setText(kel);
            TampilKecamatan.setText(kec);
            TampilLatitude.setText(lat);
            TampilLongitude.setText(longi);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee(){
        final String name = TampilNama.getText().toString().trim();
        final String alamat = TampilAlamat.getText().toString().trim();
        final String kel = TampilKelurahan.getText().toString().trim();
        final String kec = TampilKecamatan.getText().toString().trim();
        final String lat = TampilLatitude.getText().toString().trim();
        final String longi = TampilLongitude.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilLokasiActivity.this,"Updating...","Wait...",false,false);
                Intent intent= new Intent(TampilLokasiActivity.this, PengungsianActivity.class);
                startActivity(intent);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilLokasiActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(DbContract.KEY_EMP_ID,id);
                hashMap.put(DbContract.KEY_EMP_NAMA,name);
                hashMap.put(DbContract.KEY_EMP_ALAMAT,alamat);
                hashMap.put(DbContract.KEY_EMP_KELURAHAN,kel);
                hashMap.put(DbContract.KEY_EMP_KECAMATAN,kec);
                hashMap.put(DbContract.KEY_EMP_LATITUDE,lat);
                hashMap.put(DbContract.KEY_EMP_LONGITUDE,longi);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(DbContract.URL_UPDATE_EMP,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void deleteEmployee(){
        class DeleteEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilLokasiActivity.this, "Menghapus...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilLokasiActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(DbContract.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Data ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(TampilLokasiActivity.this,PengungsianActivity.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @Override
    public void onClick(View v) {
        if(v == BtnUpdate){
            updateEmployee();
        }

        if(v == BtnHapus){
            confirmDeleteEmployee();
        }
    }
}