package com.example.computeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgHF);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup rGrp,int checkedId){
                switch (checkedId){
                    case  R.id.h : Toast.makeText(getApplicationContext(),"vous etes un homme",Toast.LENGTH_LONG).show();
                    break;
                    case  R.id.f : Toast.makeText(getApplicationContext(),"vous etes une femme",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}