package com.example.monquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Quizhistoire extends AppCompatActivity {
    TextView rep1,rep2,rep3,message;
    ImageView suivant ;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizhistoire);

        rep1 =findViewById(R.id.rep1);
        rep2 =findViewById(R.id.rep2);
        rep3=findViewById(R.id.rep3);
        message=findViewById(R.id.message);
        suivant= findViewById(R.id.suivant);

        rep1.setOnClickListener((view) -> {
            message.setText("Désolé, réponse incorrect");
            score=0;
        });

        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("Bravo, réponse correct");
                score=10;
            }

        });

        rep3.setOnClickListener((view) -> {
            message.setText("Désolé, réponse incorrect");
            score=0;
        });

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(Quizhistoire.this, QuizCulture.class);
                intent.putExtra("Score ", score);
                startActivity(intent);
            }
        });
    }
}