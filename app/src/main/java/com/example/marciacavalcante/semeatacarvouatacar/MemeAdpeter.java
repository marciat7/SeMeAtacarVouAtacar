package com.example.marciacavalcante.semeatacarvouatacar;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Marcia Cavalcante on 05/06/2017.
 */

public class MemeAdpeter extends BaseAdapter {
    private List<String> urls;
    private final Activity a;

    public MemeAdpeter( Activity a) {
        this.urls = urls;
        this.a = a;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Uri imageUri = Uri.parse("https://68.media.tumblr.com/tumblr_m2ns32J1Mz1qexf5wo1_500.gif");

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setAutoPlayAnimations(true)
                .build();
        SimpleDraweeView draweeView = (SimpleDraweeView) a.findViewById(R.id.my_image_view);
        draweeView.setController(controller);
        return draweeView;
    }
}
