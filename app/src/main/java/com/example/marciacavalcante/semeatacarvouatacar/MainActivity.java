package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceItentizinha = new Intent(this, ConnectionServer.class);
        startService(serviceItentizinha);


        Button getMeme = (Button) findViewById(R.id.getMemebtn);
        getMeme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GetMeme.class);
                startActivity(intent);
            }
        });

        Button displayMemes = (Button) findViewById(R.id.displayMemeBtn);
        displayMemes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DisplayAllMemes.class);
                startActivity(intent);
            }
        });

        Button fight = (Button) findViewById(R.id.fightBtn);
        fight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseOpponet.class);
                startActivity(intent);
            }
        });
    }
}
