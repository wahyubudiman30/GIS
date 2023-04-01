package com.wahyu.evakuasibencana;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProfilActivity extends AppCompatActivity {

    ImageView profile_image;
    TextView username_txt, ttl_txt, jk_txt, telepon_txt, jabatan_txt, alamat_txt, email_txt;
    private EditText email, passlama, passbaru1, passbaru2;
    private Button cPass;
    private String strJson;

    private OkHttpClient client;
    private Response response;
    private RequestBody requestBody;
    private Request request;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);

        profile_image = findViewById(R.id.profile_image);
        username_txt = findViewById(R.id.TplNamaAdmin);
        ttl_txt = findViewById(R.id.TplTtlAdmin);
        jk_txt = findViewById(R.id.TplJkAdmin);
        telepon_txt = findViewById(R.id.TplTelepon);
        jabatan_txt = findViewById(R.id.TplJabatan);
        alamat_txt = findViewById(R.id.TplAlamat);
        email_txt = findViewById(R.id.TplEmail);

        progressDialog.show();
        client = new OkHttpClient();
        new GetUserDataRequest().execute();

        email = (EditText) findViewById(R.id.TxResetEmail);
        passlama = (EditText) findViewById(R.id.TxResetPassLama);
        passbaru1 = (EditText) findViewById(R.id.TxResetPassBaru);
        passbaru2 = (EditText) findViewById(R.id.TxResetConPass);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        Intent i = getIntent();
        final String mName = i.getStringExtra("username");
        final String mEmail = i.getStringExtra("email");


        cPass = findViewById(R.id.BtnUbahAkun);

        cPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View resetpasslayout = LayoutInflater.from(ProfilActivity.this).inflate(R.layout.activity_resetpass,null);
                EditText Email = resetpasslayout.findViewById(R.id.TxResetEmail);
                EditText OldPass = resetpasslayout.findViewById(R.id.TxResetPassLama);
                EditText NewPass = resetpasslayout.findViewById(R.id.TxResetPassBaru);
                EditText ConNewPass = resetpasslayout.findViewById(R.id.TxResetConPass);

                AlertDialog.Builder builder = new AlertDialog.Builder(ProfilActivity.this);
                builder.setTitle("RESET PASSWORD");
                builder.setView(resetpasslayout);
                builder.setPositiveButton("RESET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String email = Email.getText().toString().trim();
                        String oldpassword = OldPass.getText().toString().trim();
                        String newpassword = NewPass.getText().toString().trim();
                        String newconpassword = ConNewPass.getText().toString().trim();

                        //
                        if (email.isEmpty()||oldpassword.isEmpty()||newpassword.isEmpty()||newconpassword.isEmpty()){
                            massage("Isi semua kolom");
                        }
                        else {
                            progressDialog.show();
                            StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, DbContract.URL_RESETPASS,
                                    new com.android.volley.Response.Listener<String>()
                                    {
                                        @Override
                                        public void onResponse(String response) {
                                            progressDialog.dismiss();
                                            massage(response);
                                        }
                                    }, new com.android.volley.Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressDialog.dismiss();
                                    massage(error.getMessage());
                                }
                            }){
                                @Nullable
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params = new HashMap<>();
                                    params.put("oldpassword",oldpassword);
                                    params.put("newpassword",newpassword);
                                    params.put("conpassword",newconpassword);
                                    params.put("email",mEmail);
                                    return params;
                                }
                            };
                            RequestQueue queue = Volley.newRequestQueue(ProfilActivity.this);
                            queue.add(stringRequest);
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
    public void massage(String massage){
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    public class GetUserDataRequest extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            request = new Request.Builder().url(DbContract.SERVER_READ_URL).build();
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            try {
                strJson = response.body().string();
                updateUserData(strJson);
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private void updateUserData(String strJson) {
        try {
            JSONArray parent = new JSONArray(strJson);
            JSONObject child = parent.getJSONObject(0);
            String imgUrl = child.getString("imageLink");
            String username = child.getString("username");
            String ttl = child.getString("ttl");
            String jk = child.getString("jk");
            String telepon = child.getString("telepon");
            String jabatan = child.getString("jabatan");
            String alamat = child.getString("alamat");
            String email = child.getString("email");
            Glide.with(this).load(imgUrl).into(profile_image);

            username_txt.setText(username);
            ttl_txt.setText(ttl);
            jk_txt.setText(jk);
            telepon_txt.setText(telepon);
            jabatan_txt.setText(jabatan);
            alamat_txt.setText(alamat);
            email_txt.setText(email);
            progressDialog.hide();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Tambahadmin(View view) {
        Intent intent= new Intent(ProfilActivity.this, TambahakunActivity.class);
        startActivity(intent);
    }

    public void EditProfil(View view) {
        Intent intent= new Intent(ProfilActivity.this, UbahprofilActivity.class);
        startActivity(intent);
    }
}