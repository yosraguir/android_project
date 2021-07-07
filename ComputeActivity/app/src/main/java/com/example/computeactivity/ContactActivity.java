package com.example.computeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
Button Concat=(Button) findViewById(R.id.button2);
TextView C1 =(TextView) findViewById(R.id.txtchaine1);
TextView C2 = (TextView) findViewById(R.id.txtchaine2);
CheckBox check=(CheckBox) findViewById(R.id.checkBox);
//ContactActivity.setOnClickListener(new View.OnClickListener);

     @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

    }
}