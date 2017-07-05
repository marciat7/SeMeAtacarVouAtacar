package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by Marcia Cavalcante on 01/07/2017.
 */

public class OpponentAdapter extends RecyclerView.Adapter {
    private List<Opponent> oponentes;
    private Context context;
    OpponentAdapter(List<Opponent> oponentes, Context context){
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        OpponentViewHolder opponentViewHolder = (OpponentViewHolder) holder;
        opponentViewHolder.nome.setText(oponentes.get(position).getOp().deviceName);
        opponentViewHolder.nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WifiP2pConfig config = new WifiP2pConfig();
                config.deviceAddress = oponentes.get(position).getOp().deviceAddress;
                oponentes.get(position).getmManager().connect(oponentes.get(position).getmChannel(), config, new WifiP2pManager.ActionListener() {

                    @Override
                    public void onSuccess() {
                        Log.i("WIFICONEc", "onSuccess: conectado");
                        Log.i("WIFICONEc", oponentes.get(position).getOp().deviceName);
                        Intent intent = new Intent(context, ChooseMeme.class);
                        intent.putExtra("HOST", oponentes.get(position).getOp().deviceName);
                        context.startActivity(intent);



                    }

                    @Override
                    public void onFailure(int reason) {
                        Log.i("WIFICONEc", "falhou");
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        if (oponentes != null){
            return oponentes.size();
        }else {
            return 0;
        }
    }

    public void updateList(Opponent oponente) {
        insertItem(oponente);
    }

    // Método responsável por inserir um novo usuário na lista e notificar que há novos itens.
    private void insertItem(Opponent oponente) {
        oponentes.add(oponente);
        notifyItemInserted(getItemCount());
    }
}
