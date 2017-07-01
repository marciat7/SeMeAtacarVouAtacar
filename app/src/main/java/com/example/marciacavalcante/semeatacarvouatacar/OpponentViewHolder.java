package com.example.marciacavalcante.semeatacarvouatacar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcia Cavalcante on 01/07/2017.
 */

public class OpponentViewHolder extends RecyclerView.ViewHolder {
    final TextView nome;
    public OpponentViewHolder(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.nomeOpponent);
    }
}
