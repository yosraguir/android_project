package com.example.computeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.aa);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup rGrp, int i) {
                switch (i) {
                    case R.id.contact:
                        Intent i1 = new Intent(getApplicationContext(), ContactActivity.class);
                        startActivity(i1);
                        break;
                    case R.id.calculatrice:
                        Intent i2 = new Intent(getApplicationContext(), CalculatriceActivity.class);
                        startActivity(i2);
                    case R.id.moyenne:
                        Intent i3 = new Intent(getApplicationContext(), MoyenneActivity.class);
                        startActivity(i3);
                }
            }
        });

    }
}