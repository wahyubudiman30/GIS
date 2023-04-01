package com.wahyu.evakuasibencana;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "NAME";
    public static final String TTL = "TTL";
    public static final String JK = "JK";
    public static final String TELEPON = "TELEPON";
    public static final String ALAMAT = "ALAMAT";
    public static final String JABATAN = "JABATAN";
    public static final String EMAIL = "EMAIL";
    public static final String ID = "ID";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String username, String ttl, String jk, String telepon, String jabatan, String alamat, String email, String id) {

        editor.putBoolean(LOGIN, true);
        editor.putString(NAME, username);
        editor.putString(TTL, ttl);
        editor.putString(JK, jk);
        editor.putString(TELEPON, telepon);
        editor.putString(JABATAN, jabatan);
        editor.putString(ALAMAT, alamat);
        editor.putString(EMAIL, email);
        editor.putString(ID, id);
        editor.apply();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }

    public void checkLogin(){
        if(!this.isLoggin()){
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((ProfilActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(TTL, sharedPreferences.getString(TTL, null));
        user.put(JK, sharedPreferences.getString(JK, null));
        user.put(TELEPON, sharedPreferences.getString(TELEPON, null));
        user.put(JABATAN, sharedPreferences.getString(JABATAN, null));
        user.put(ALAMAT, sharedPreferences.getString(JABATAN, null));
        user.put(EMAIL, sharedPreferences.getString(ALAMAT, null));
        user.put(ID, sharedPreferences.getString(ID, null));
        return user;
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((ProfilActivity) context).finish();
    }
}
