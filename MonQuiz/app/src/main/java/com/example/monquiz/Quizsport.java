package com.example.monquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Quizsport extends AppCompatActivity {
    TextView rep1,rep2,rep3,message2;
    ImageView suivant ;
    int score ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizsport);

        rep1 =findViewById(R.id.rep1);
        rep2 =findViewById(R.id.rep2);
        rep3=findViewById(R.id.rep3);
        message2=findViewById(R.id.message2);
        suivant= findViewById(R.id.suivant3);

        Intent intent=getIntent();
        int score2 = intent.getIntExtra("Score", 0);

        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message2.setText("Bravo, réponse correct");
                score=score2+10;
            }

        });

        rep2.setOnClickListener((view) ->{
            message2.setText("Désolé, réponse incorrect");
            score=score2+0;
        });

        rep3.setOnClickListener((view) ->{
            message2.setText("Désolé, réponse incorrect");
            score=score2+0;
        });
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quizsport.this, Score.class);
                intent.putExtra("Score ", score);
                startActivity(intent);
            }
        });
    }
}