package com.example.marciacavalcante.semeatacarvouatacar;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayMeme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_display_meme);

        Uri imageUri = Uri.parse("https://68.media.tumblr.com/tumblr_m2ns32J1Mz1qexf5wo1_500.gif");

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setAutoPlayAnimations(true)
                .build();
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.sdvImage);
        draweeView.setController(controller);
    }
}
