package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        String url;

        if (savedInstanceState != null){
            url = (String) savedInstanceState.get("URL");
            Meme meme = new Meme(url, 0);
            simularBatalha(meme);

        }else{
            Bundle extras = getIntent().getExtras();
            if(extras == null) {

            } else {
                url = extras.getString("URL");
                Meme meme = new Meme(url, 0);
                simularBatalha(meme);
            }
        }
    }

    private void simularBatalha(Meme meme){
        ImageView view = (ImageView) findViewById(R.id.fightMemeView);
        DataBase db = new DataBase(this);
        if (Math.random() >= 0.5){
            Meme novo = new Meme("http://www.cin.ufpe.br/~mctc/memes/8.png", 6);
            db.insertMeme(novo);
            Picasso.with(this)
                    .load(novo.getUrl())
                    .placeholder(R.drawable.cast_ic_mini_controller_skip_next)
                    .fit()
                    .into(view);
            Toast toast = Toast.makeText(this, "Aee Caralh*", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            db.removerMeme(meme);
            Picasso.with(this)
                    .load("http://www.cin.ufpe.br/~mctc/memes/31.png")
                    .placeholder(R.drawable.cast_ic_mini_controller_skip_next)
                    .fit()
                    .into(view);
            Toast toast = Toast.makeText(this, "Not Today Satan", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


