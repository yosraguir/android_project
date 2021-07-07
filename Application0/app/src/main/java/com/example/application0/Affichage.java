package com.example.application0;

import android.Manifest;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import static android.Manifest.permission.CALL_PHONE;

public class Affichage  extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    TextView tv_recheche;
    EditText ed_recherche;
    ListView lv;
    ArrayList<Contact> mydata;
    private Contact c;
    private ContactAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        ed_recherche = findViewById(R.id.ed_recherche);
        lv = findViewById(R.id.list_view);
        mydata = Acceuil.data;
        ad = new ContactAdapter(Affichage.this, Acceuil.data);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
        
}
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Affichage.this);
        dialog.setTitle("Action");
        dialog.setMessage("Veuiller choisir une action");
        dialog.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Acceuil.data.remove(position);
                lv.invalidateViews();
            }
        });
        dialog.setNeutralButton("modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String user_id = (String) lv.getItemAtPosition(position);
                finish();
            Intent i = new Intent(Affichage.this,UpdateActivity.class);


            i.putExtra("position",position+"");
            startActivity(i);


            }
        });
        dialog.setNegativeButton("Supprime Tous", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Acceuil.data.clear();
                lv.invalidateViews();
            }
        });
        dialog.show();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        c = Acceuil.data.get(position);
        String phoneNumber = c.numero;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", c.numero, null));

        if (ActivityCompat.checkSelfPermission(Affichage.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

        }
        startActivity(intent);
        return false;
    }
    /* c = Acceuil.data.get(position);
            String phoneNumber = c.numero;*/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + c.numero));
                startActivity(intent);
            }
            else {

            }
        }
    }



}
