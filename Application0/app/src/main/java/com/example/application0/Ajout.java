package com.example.application0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends Activity implements View.OnClickListener {
    Button btn_valider_ajout;
    Button btn_quiter_ajout;
    EditText ed_nom_ajout;
    EditText ed_prenom_ajout;
    EditText ed_numero_ajout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        btn_valider_ajout = findViewById(R.id.btn_valider_ajout);
        btn_quiter_ajout = findViewById(R.id.btn_quiter_ajout);
        ed_nom_ajout = findViewById(R.id.ed_recherche);
        ed_prenom_ajout = findViewById(R.id.ed_prenom_ajout);
        ed_numero_ajout = findViewById(R.id.ed_numero_ajout);

        btn_valider_ajout.setOnClickListener(this);
        btn_quiter_ajout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String nom = ed_nom_ajout.getText().toString();
        String prenom = ed_prenom_ajout.getText().toString();
        String numero = ed_numero_ajout.getText().toString();
        if (v == btn_quiter_ajout)
        {
            Ajout.this.finish();
        }
        if(v == btn_valider_ajout)
        {

            Toast.makeText(this, nom + prenom + numero, Toast.LENGTH_SHORT).show();
            Contact c = new Contact(nom , prenom , numero);
            Acceuil.data.add(c);

            startActivity(new Intent(Ajout.this, Acceuil.class));




        }
    }



}
