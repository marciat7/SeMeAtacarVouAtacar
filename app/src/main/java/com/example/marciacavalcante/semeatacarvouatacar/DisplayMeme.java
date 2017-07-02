package com.example.marciacavalcante.semeatacarvouatacar;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayMeme extends AppCompatActivity {
    GridView gd;
    MemeAdpeter memeAdpeter;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_display_meme);
        String url = "";
        dataBase = new DataBase(this);


        if (savedInstanceState != null){
            url = (String) savedInstanceState.get("URL");
        }else{
            Bundle extras = getIntent().getExtras();
            if(extras == null) {

            } else {
                Log.i("MemeUrlOutra: ", url);
                url = extras.getString("URL");
                Meme meme = new Meme(url.substring(0, url.indexOf(",")), Integer.parseInt(url.substring(url.indexOf(",")+1)));
                dataBase.insertMeme(meme);


            }
        }


        Uri imageUri = Uri.parse(url);

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setAutoPlayAnimations(true)
                .build();
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setController(controller);



    }
}
