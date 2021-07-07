package com.example.application0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity  {
    ArrayList<Contact> mydata;
    Button btn_valider_ajout_update;
    Button btn_quiter_ajout_update;
    EditText ed_nom_ajout_update;
    EditText ed_prenom_ajout_update;
    EditText ed_numero_ajout_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        btn_valider_ajout_update = findViewById(R.id.btn_valider_ajout_update);
        btn_quiter_ajout_update = findViewById(R.id.btn_quiter_ajout_update);
        ed_nom_ajout_update = findViewById(R.id.ed_recherche_update);
        ed_prenom_ajout_update = findViewById(R.id.ed_prenom_ajout_update);
        ed_numero_ajout_update = findViewById(R.id.ed_numero_ajout_update);



        btn_valider_ajout_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydata = Acceuil.data;
                Contact contact = mydata.get(Integer.parseInt(getIntent().getStringExtra("position")));
                contact.getNom();
                contact.getNumero();
                contact.getPrenom();

                contact.setNom(ed_nom_ajout_update.getText().toString());
                contact.setNumero(ed_numero_ajout_update.getText().toString());
                contact.setPrenom(ed_prenom_ajout_update.getText().toString());

                startActivity(new Intent(UpdateActivity.this,Affichage.class));
            }
        });


    }
}