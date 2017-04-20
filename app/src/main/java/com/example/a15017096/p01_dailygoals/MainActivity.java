package com.example.a15017096.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tvMaterial1, tvProblem1, tvTime1, tvReflection;
    RadioGroup rgMaterial1, rgProblem1, rgTime1;
    EditText etReflection;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMaterial1 = (TextView)findViewById(R.id.tvMaterial);
        tvTime1 = (TextView)findViewById(R.id.tvTime);
        tvProblem1 = (TextView)findViewById(R.id.tvProblem);
        tvReflection = (TextView)findViewById(R.id.tvReflection);
        rgMaterial1 = (RadioGroup)findViewById(R.id.rgMaterial);
        rgProblem1 = (RadioGroup)findViewById(R.id.rgProblem);
        rgTime1 = (RadioGroup)findViewById(R.id.rgTime);
        etReflection = (EditText)findViewById(R.id.etReflection);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the Id of the selected radio button in the RadioGroup
                int sbMaterial1 = rgMaterial1.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rbMaterial1 = (RadioButton) findViewById(sbMaterial1);

                int sbProblem1 = rgProblem1.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rbProblem1 = (RadioButton) findViewById(sbProblem1);

                int sbTime1 = rgTime1.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rbTime1 = (RadioButton) findViewById(sbTime1);

                Map<String, String> info = new HashMap<String,String>();
                String tv1 = tvMaterial1.getText().toString()+"= "+ rbMaterial1.getText().toString();
                String tv2 = tvProblem1.getText().toString()+"= "+ rbProblem1.getText().toString();
                String tv3 = tvTime1.getText().toString()+"= "+ rbTime1.getText().toString();
                String tv4 = tvReflection.getText().toString()+"= "+ etReflection.getText().toString();
                String[] data = {tv1, tv2, tv3, tv4};



                Intent i = new Intent(MainActivity.this, DataActivity.class);
                i.putExtra("data", data);
                startActivity(i);



            }
        });




    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putInt("material",rgMaterial1.getCheckedRadioButtonId());
        prefEdit.putInt("problem", rgProblem1.getCheckedRadioButtonId());
        prefEdit.putInt("time",rgTime1.getCheckedRadioButtonId());
        prefEdit.putString("reflect",etReflection.getText().toString());
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String reflect = pref.getString("reflect","");
        int material = pref.getInt("material",0);
        int problem = pref.getInt("problem",0);
        int time = pref.getInt("time",0);
        etReflection.setText(reflect);
        rgProblem1.check(problem);
        rgTime1.check(time);
        rgMaterial1.check(material);

    }
}
