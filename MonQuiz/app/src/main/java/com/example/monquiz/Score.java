package com.example.monquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {
TextView score ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

     score=findViewById(R.id.score2);

        Intent intent=getIntent();
        final int scf = intent.getIntExtra("Score", 0);

        score.setText(scf+" / 30");

    }
}