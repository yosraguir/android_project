package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ProduitsActivity extends AppCompatActivity {

    ListView ls ;
    String txtnom , txtprix;
    HashMap<String,String> map ;
    Params p = new Params();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        ls=findViewById(R.id.list);

        Bundle extras=getIntent().getExtras();
        if(extras!=null) {
            txtnom=extras.getString("nom");
            txtprix=extras.getString("prix");
            map=new HashMap<String, String>();
            map.put("nom",txtnom);
            map.put("prix",txtprix);
            p.values.add(map);


        }
        SimpleAdapter adapter=new SimpleAdapter(ProduitsActivity.this,p.values,R.layout.item,
               new String []{"nom","prix"},
                new int[]{R.id.txtnom,R.id.txtprix}

                );
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getApplicationContext(),DetailActitvity.class);
                    i.putExtra("position",position);
                    startActivity(i);
            }
        });
    }
}