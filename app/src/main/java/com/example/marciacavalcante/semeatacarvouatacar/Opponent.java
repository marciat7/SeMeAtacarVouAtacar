package com.example.marciacavalcante.semeatacarvouatacar;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;

/**
 * Created by Marcia Cavalcante on 02/07/2017.
 */

public class Opponent {
    private WifiP2pDevice op;
    private WifiP2pManager.Channel mChannel;
    private WifiP2pManager mManager;

    public Opponent (WifiP2pDevice op, WifiP2pManager.Channel mChannel, WifiP2pManager mManager){
        this.op = op;
        this.mChannel = mChannel;
        this.mManager = mManager;
    }

    public WifiP2pManager getmManager() {
        return mManager;
    }

    public WifiP2pManager.Channel getmChannel() {
        return mChannel;
    }

    public WifiP2pDevice getOp() {
        return op;
    }
}
