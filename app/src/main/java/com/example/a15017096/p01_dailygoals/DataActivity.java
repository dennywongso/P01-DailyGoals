package com.example.a15017096.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class DataActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        btnBack = (Button)findViewById(R.id.btnBack);
        Intent i = getIntent();
        String[] data = i.getStringArrayExtra("data");
        tv1.setText(data[0].toString());
        tv2.setText(data[1].toString());
        tv3.setText(data[2].toString());
        tv4.setText(data[3].toString());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DataActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }



}
