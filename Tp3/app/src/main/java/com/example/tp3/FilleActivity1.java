package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FilleActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fille1);
        TextView labelNom = (TextView)findViewById(R.id.salutText);
        TextView labelPrenom = (TextView)findViewById(R.id.prenomText);

        Bundle extras = getIntent().getExtras();
        String nom = extras.getString("nom");
        String prenom = extras.getString("prenom");

        labelNom.setText("bonjour madame "+nom);
        labelPrenom.setText("bonjour mr "+prenom);


    }
}