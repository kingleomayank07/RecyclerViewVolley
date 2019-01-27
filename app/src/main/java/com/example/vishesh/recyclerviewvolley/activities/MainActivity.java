package com.example.vishesh.recyclerviewvolley.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.vishesh.recyclerviewvolley.Adapter.MyAdapter;
import com.example.vishesh.recyclerviewvolley.Model.List1;
import com.example.vishesh.recyclerviewvolley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private JsonArrayRequest request;
    private final String url = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
        private RequestQueue requestQueue;
        private List<List1>list1s;
        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1s = new ArrayList<>();
        recyclerView = findViewById(R.id.Rv1);
        jsonrequest();

    }

    private void jsonrequest() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
         request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                    for (int i=0;i<response.length();i++){
                        try {
                        jsonObject = response.getJSONObject(i);
                        List1 list = new List1();
                        list.setName(jsonObject.getString("name"));
                        list.setId(jsonObject.getString("Rating"));
                        list.setImg(jsonObject.getString("img"));
                        list1s.add(list);

                    }catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"hiiiiiiiii",Toast.LENGTH_LONG).show();
                            e.printStackTrace();
//                    Log.d("fetch",e.toString());
                        }

                }
                progressDialog.dismiss();
                setuprecyclerview(list1s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
        }

    private void setuprecyclerview(List<List1> list1s) {
        MyAdapter myAdapter = new MyAdapter(this,list1s);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }

}
