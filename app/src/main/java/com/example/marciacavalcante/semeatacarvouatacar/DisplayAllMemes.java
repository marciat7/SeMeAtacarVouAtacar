package com.example.marciacavalcante.semeatacarvouatacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class DisplayAllMemes extends AppCompatActivity {
    GridView gridView;
    MemeAdpeter memeAdpeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_memes);
        ArrayList<Meme> memes = new ArrayList<Meme>();
        memes.add(new Meme("cin.ufpe.br/~mctc/memes/1.jpg", 3));
        memes.add(new Meme("cin.ufpe.br/~mctc/memes/1.jpg", 3));



        gridView = (GridView) findViewById(R.id.memeGridView);
        memeAdpeter = new MemeAdpeter(this, R.layout.grid_item_layout, memes);
        gridView.setAdapter(memeAdpeter);
    }
}
