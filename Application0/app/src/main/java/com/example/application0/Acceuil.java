package com.example.application0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Acceuil extends AppCompatActivity   implements View.OnClickListener {

         static ArrayList<Contact> data = new ArrayList<Contact>();
         Button btn_afficher_acceuil;
         Button btn_ajouter_acceuil;
         TextView tv_acceuil;
        boolean  write_permission = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        // gestion des autorisation
        // tester si la permission est deja accordée
        if (ContextCompat.checkSelfPermission(Acceuil.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
        {
            // permission est deja accordée
            write_permission = true;
        }
        else
        {
            write_permission = false;
            // demande de permission
            ActivityCompat.requestPermissions(Acceuil.this , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE} , 1);
            // affiche une boite de dialogue (allow or denied)
            // --> pour gerer les resultat redefinir onrequestpermissionresult
        }
        if (write_permission)
            importer();

        btn_afficher_acceuil = findViewById(R.id.btn_afficher_acceuil);
        btn_ajouter_acceuil = findViewById(R.id.btn_ajouter_acceuil);
        tv_acceuil = findViewById(R.id.tv_acceuil);
        btn_afficher_acceuil.setOnClickListener(this);
        btn_ajouter_acceuil.setOnClickListener(this);


        }
    @Override
    public void onClick(View v){
        if (v == btn_ajouter_acceuil)
        {
            Intent i = new Intent(this , Ajout.class);
            startActivity(i);
        }
        if (v == btn_afficher_acceuil)
        {
            Intent j = new Intent(this , Affichage.class);
            startActivity(j);
        }



    }
    public void sauvgarder()
    {
        //ecriture dans un fichier
        String root = Environment.getExternalStorageDirectory().getPath();
        File f = new File(root , "mesContacts.csv");

        try {
            FileWriter fw = new FileWriter(f, false); // creation du fichier s'il n'existe pas
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0; i<data.size();i++)
            bw.write(data.get(i).nom+","+data.get(i).prenom+","+data.get(i).numero+"\n");
            bw.close();
            fw.close();//sauvgarder
        } catch (IOException e) {
            Log.e("msg", " erreur ecriture"+e.getMessage());
        }
    }
    public void importer()
    {
        // lecture depuis un ficheir
        String root = Environment.getExternalStorageDirectory().getPath();
        File f = new File(root , "mesContacts.csv");
        if (f.exists())
        {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String ligne = null;
                while ((ligne = br.readLine()) != null) {
                    ligne = br.readLine();
                    String[] t = ligne.split(",");
                    Contact c = new Contact(t[0], t[1], t[2]);
                    data.add(c);
                }
                br.close();
                br.close();

            } catch (IOException e) {
                Log.e("msg", " erreur lecture"+e.getMessage());
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"acceuil started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"acceuil stopedd", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        sauvgarder();
        Toast.makeText(this,"acceuil destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1)
        {
            if (grantResults.length>0)
            {
                write_permission=true;
            }
            else
            {
                write_permission=false;
            }
        }
    }
}