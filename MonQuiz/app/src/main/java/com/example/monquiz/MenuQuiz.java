package com.example.monquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuQuiz extends AppCompatActivity {
Button histo , sport , culture ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_quiz);

        histo=findViewById(R.id.btnhistoire);
        culture=findViewById(R.id.btnculture);
        sport=findViewById(R.id.btnsport);

        histo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuQuiz.this,Quizhistoire.class);
                startActivity(intent);
            }
        });
    }
}