package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MereActivity extends AppCompatActivity {

    EditText letNom;
    EditText letPrenom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mere);
        letNom = (EditText)findViewById(R.id.zoneNom);
        letPrenom = (EditText)findViewById(R.id.zonePrenom);
        Button go = (Button)findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Intent Fille = new Intent(MereActivity.this, FilleActivity1.class);
                Fille.putExtra("nom", letNom.getText().toString());
                Fille.putExtra("prenom",letPrenom.getText().toString());*/

                Intent i =new Intent("coucou");
                sendBroadcast(i);
                IntentFilter i1= new IntentFilter("coucou");
                Breceiver rc=new Breceiver();
                registerReceiver(rc,i1);




                //startActivityForResult(Fille,1);
            }
        });

        /*Button but = (Button) findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IN = new Intent(getApplicationContext(),FilleActivity.class);
                startActivityForResult(IN,1);
            }
        });*/
    }
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        switch (resultcode){
            case RESULT_OK:
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
            case RESULT_CANCELED:
                Toast.makeText(getApplicationContext(),"annuler",Toast.LENGTH_LONG).show();
        }
    }
}