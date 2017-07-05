package com.example.marciacavalcante.semeatacarvouatacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

public class DisplayAllMemes extends AppCompatActivity {
    GridView gridView;
    MemeAdpeter memeAdpeter;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_memes);

        dataBase = new DataBase(this);
        List<Meme> memes = dataBase.getMemes();

        gridView = (GridView) findViewById(R.id.memeGridView);
        memeAdpeter = new MemeAdpeter(this, R.layout.grid_item_layout, memes);
        gridView.setAdapter(memeAdpeter);
    }
}
