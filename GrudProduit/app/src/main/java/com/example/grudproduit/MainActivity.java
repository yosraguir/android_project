package com.example.grudproduit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nom , prix;
    Button add ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        prix=findViewById(R.id.prix);

        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProduitsActivity.class);
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("prix",prix.getText().toString());
                if(v == add) {
                    Toast.makeText(getApplicationContext(),"produit bien ajouté",Toast.LENGTH_LONG).show();

                startActivity(i);
            }
            }

        });
    }
}