package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by Marcia Cavalcante on 01/07/2017.
 */

public class OpponentAdapter extends RecyclerView.Adapter {
    private List<String> oponentes;
    private Context context;
    OpponentAdapter(List<String> oponentes, Context context){
        this.oponentes = oponentes;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.opponent, parent, false);
        OpponentViewHolder holder = new OpponentViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OpponentViewHolder opponentViewHolder = (OpponentViewHolder) holder;
        opponentViewHolder.nome.setText(oponentes.get(position));
    }

    @Override
    public int getItemCount() {
        return oponentes.size();
    }
}
