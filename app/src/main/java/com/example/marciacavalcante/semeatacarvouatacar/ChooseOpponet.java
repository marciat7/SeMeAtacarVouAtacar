package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChooseOpponet extends AppCompatActivity {

    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;
    List<Opponent> oponentes;
    OpponentAdapter opponentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_opponet);

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReceiver = new WiFiDirectBroadcastReceiver(mManager, mChannel, this);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        oponentes = new ArrayList<Opponent>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        opponentAdapter = new OpponentAdapter(oponentes, this);
        recyclerView.setAdapter(opponentAdapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);


    }

    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Log.i("wifi", "onSuccess: achou peer ");
            }

            @Override
            public void onFailure(int reasonCode) {
                Log.i("wifi", "onSuccess: nao achou peer");

            }
        });
    }
    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    public void achouPeers(WifiP2pDeviceList peers){
        List<WifiP2pDevice> lista = new ArrayList<WifiP2pDevice>();
        lista.addAll(peers.getDeviceList());
        for (int i = 0; i < lista.size(); i++) {
            Log.i("wifidirect", "achouPeers: " + lista.get(i).deviceName);
            opponentAdapter.updateList(new Opponent(lista.get(i), mChannel, mManager));

        }

    }
}
