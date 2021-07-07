package com.example.application0;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Authentification extends Activity implements View.OnClickListener {
    Button btn_val_auth;
    Button btn_quitter_auth;
    EditText ed_nom_auth;
    EditText ed_motdepasse_auth;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
            btn_val_auth = findViewById(R.id.btn_val_auth);
            btn_quitter_auth = findViewById(R.id.btn_quitter_auth);
            ed_nom_auth = findViewById(R.id.ed_nom_auth);
            ed_motdepasse_auth = findViewById(R.id.ed_motdepasse_auth);

            btn_quitter_auth.setOnClickListener(this);
            btn_val_auth.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == btn_quitter_auth)
        {
            Authentification.this.finish();
        }
        if (v == btn_val_auth)
        {
            String nom = ed_nom_auth.getText().toString();
            String mp = ed_motdepasse_auth.getText().toString();
            if (nom.equalsIgnoreCase("azer")
            && mp.equals("000"))
            {
                Intent i = new Intent(this , Acceuil.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "bonjour", Toast.LENGTH_SHORT).show();

            }
        }
    }
}