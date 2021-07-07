package com.example.grudproduit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailActitvity extends AppCompatActivity {
    EditText nom , prix;
    Button mod , sup ;
    int position;
    Params p = new Params();
    HashMap<String,String> m ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_actitvity);
        nom = findViewById(R.id.editnom);
        prix = findViewById(R.id.editprix);
        mod = findViewById(R.id.modifier);
        sup = findViewById(R.id.supprimer);

        Bundle extras = getIntent().getExtras();
        if (extras!=null) {
            position = extras.getInt("position");
        }
        m = p.values.get(position);
        nom.setText(m.get("nom"));
        prix.setText(m.get("prix"));

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("nom",nom.getText().toString());
                m.put("prix", prix.getText().toString());
                Intent i = new Intent(getApplicationContext(),ProduitsActivity.class);
                startActivity(i);
                finish();

            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.values.remove(position);
                Intent i = new Intent(getApplicationContext(),ProduitsActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}