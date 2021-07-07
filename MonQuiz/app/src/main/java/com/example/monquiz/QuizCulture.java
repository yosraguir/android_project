package com.example.monquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizCulture extends AppCompatActivity {
TextView rep1,rep2,rep3,message3;
ImageView suivant ;
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_culture);

        rep1 =findViewById(R.id.rep1);
        rep2 =findViewById(R.id.rep2);
        rep3=findViewById(R.id.rep3);
        message3=findViewById(R.id.message3);
        suivant= findViewById(R.id.suivant2);

        Intent intent=getIntent();
        final int score1 = intent.getIntExtra("Score", 0); // recuperé une valeur de type entier

        rep1.setOnClickListener((view) ->{
            message3.setText("Désolé, réponse incorrect");
            score=score1+0;
        });

        rep2.setOnClickListener((view) ->{
            message3.setText("Désolé, réponse incorrect");
            score=score1+0;
        });

        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message3.setText("Bravo, réponse correct");
                score=score1+10;
            }

        });

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizCulture.this, Quizsport.class);
                intent.putExtra("Score" , score);
                startActivity(intent);
            }
        });
    }
}