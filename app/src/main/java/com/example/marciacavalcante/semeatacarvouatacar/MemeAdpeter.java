package com.example.marciacavalcante.semeatacarvouatacar;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcia Cavalcante on 05/06/2017.
 */

public class MemeAdpeter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList<Meme> data = new ArrayList<Meme>();

    public MemeAdpeter(Context context, int layoutResourceId, ArrayList<Meme> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.memeTxtGridView);
            holder.image = (ImageView) row.findViewById(R.id.memeImgGridView);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Meme item = data.get(position);
        holder.imageTitle.setText(item.getForce());
        //holder.image.setImageURI(item.getUrl());
        Picasso.with(context)
                .load(item.getUrl())
                .centerCrop()
                .placeholder(R.drawable.cast_ic_mini_controller_skip_next)
                .into(holder.image);
        return row;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }
}
