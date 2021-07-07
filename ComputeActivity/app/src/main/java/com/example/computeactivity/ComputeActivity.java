package com.example.computeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

public class ComputeActivity extends AppCompatActivity {
    private EditText et1 = null;
    private EditText et2 = null;
    private Button btn = null;
    private  int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        et1 = (EditText)findViewById(R.id.input1);
        et2 = (EditText)findViewById(R.id.input2);
        btn = (Button)findViewById(R.id.myButton);
        btn.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            int v1 = Integer.parseInt(str1);
            int v2 = Integer.parseInt(str2);
            while(i<=v2) {
                for (int i = v1; i <= v2; i++) {

                }
            }

        }
    }
}