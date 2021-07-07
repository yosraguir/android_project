package com.example.authenticationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthenticationActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        Button btn = (Button)findViewById(R.id.b);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText)findViewById(R.id.etlog);
                String ch1 = e1.getText().toString();
                EditText e2 = (EditText)findViewById(R.id.etps);
                String ch2 = e1.getText().toString();
                if((ch1.equals("yosr"))){
                    Toast.makeText(v.getContext(),"ok",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }


            }
        });





    }



}