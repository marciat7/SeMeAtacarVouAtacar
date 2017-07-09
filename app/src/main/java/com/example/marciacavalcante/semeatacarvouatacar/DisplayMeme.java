package com.example.marciacavalcante.semeatacarvouatacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DisplayMeme extends AppCompatActivity {
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_meme);
        String url = "";
        dataBase = new DataBase(this);

        Meme meme = null;


        if (savedInstanceState != null){
            url = (String) savedInstanceState.get("URL");
            meme = new Meme(url.substring(0, url.indexOf(",")), Integer.parseInt(url.substring(url.indexOf(",")+1)));
            dataBase.insertMeme(meme);
        }else{
            Bundle extras = getIntent().getExtras();
            if(extras == null) {

            } else {
                url = extras.getString("URL");
                meme = new Meme(url.substring(0, url.indexOf(",")), Integer.parseInt(url.substring(url.indexOf(",")+1)));
                dataBase.insertMeme(meme);
            }
        }

        if (!url.contains("http://")){
            url = "http://" + url;
        }
        ImageView memeView = (ImageView) findViewById(R.id.memeView);
        Picasso.with(this)
                .load(url.substring(0, url.indexOf(",")))
                .placeholder(R.drawable.cast_ic_mini_controller_skip_next)
                .fit()
                .into(memeView);

        TextView forceView = (TextView) findViewById(R.id.forceView);
        if (meme != null){
            forceView.setText("Força: " + meme.getForce());
        }

    }
}
