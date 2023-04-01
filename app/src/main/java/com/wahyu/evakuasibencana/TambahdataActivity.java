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

import java.util.HashMap;

import android.os.Bundle;

public class TambahdataActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText TxNamaLokasi;
    private EditText TxAlamatPengungsian;
    private EditText TxKelurahan;
    private EditText Txkecamatan;
    private EditText TxLatitude;
    private EditText TxLongitude;

    private Button BtnSimpanPengungsian;
    private Button BtnLihatData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahdata);

        //Inisialisasi dari View
        TxNamaLokasi = (EditText) findViewById(R.id.TxNamaLokasi);
        TxAlamatPengungsian = (EditText) findViewById(R.id.TxAlamatPengungsian);
        TxKelurahan = (EditText) findViewById(R.id.TxKelurahan);
        Txkecamatan = (EditText) findViewById(R.id.Txkecamatan);
        TxLatitude = (EditText) findViewById(R.id.TxLatitude);
        TxLongitude = (EditText) findViewById(R.id.TxLongitude);

        BtnSimpanPengungsian = (Button) findViewById(R.id.BtnSimpanPengungsian);
        BtnLihatData = (Button) findViewById(R.id.BtnLihatData);

        //Setting listeners to button
        BtnSimpanPengungsian.setOnClickListener(this);
        BtnLihatData.setOnClickListener(this);
    }
    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String name = TxNamaLokasi.getText().toString().trim();
        final String alamat = TxAlamatPengungsian.getText().toString().trim();
        final String kelurahan = TxKelurahan.getText().toString().trim();
        final String kecamatan = Txkecamatan.getText().toString().trim();
        final String latitude = TxLatitude.getText().toString().trim();
        final String longitude = TxLongitude.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahdataActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahdataActivity.this,s,android.widget.Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(DbContract.KEY_EMP_NAMA,name);
                params.put(DbContract.KEY_EMP_ALAMAT, alamat);
                params.put(DbContract.KEY_EMP_KELURAHAN,kelurahan);
                params.put(DbContract.KEY_EMP_KECAMATAN,kecamatan);
                params.put(DbContract.KEY_EMP_LATITUDE,latitude);
                params.put(DbContract.KEY_EMP_LONGITUDE,longitude);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(DbContract.URL_ADD, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();
    }
    @Override
    public void onClick(View v) {
        if(v == BtnSimpanPengungsian){
            addEmployee();
        }

        if(v == BtnLihatData){
            startActivity(new Intent(this,PengungsianActivity.class));
        }
    }}