package com.wahyu.evakuasibencana;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class UserPoskoFragment extends Fragment {

    private ListView listView;
    private String JSON_STRING;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_itemuser,container,false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) view.findViewById(R.id.listView2);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        getJSON();
    }
    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(DbContract.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(DbContract.TAG_ID);
                String name = jo.getString(DbContract.TAG_NAMA);
                String alamat = jo.getString(DbContract.TAG_ALAMAT);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(DbContract.TAG_ID,id);
                employees.put(DbContract.TAG_NAMA,name);
                employees.put(DbContract.TAG_ALAMAT,alamat);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                getActivity(), list, R.layout.list_itemuser,
                new String[]{DbContract.TAG_ID, DbContract.TAG_NAMA, DbContract.TAG_ALAMAT},
                new int[]{R.id.id, R.id.name, R.id.alamat});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getActivity(),"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(DbContract.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), UserDetailPosko.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(DbContract.TAG_ID).toString();
        intent.putExtra(DbContract.EMP_ID,empId);
        startActivity(intent);
    }
}