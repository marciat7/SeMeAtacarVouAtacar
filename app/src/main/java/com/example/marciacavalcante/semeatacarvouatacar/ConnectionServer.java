package com.example.marciacavalcante.semeatacarvouatacar;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Marcia Cavalcante on 02/07/2017.
 */

public class ConnectionServer extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public ConnectionServer() {
        super("SocketServer");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("Service", "Executando Service");
       try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket client = serverSocket.accept();
            InputStream inputstream = client.getInputStream();
            DataInputStream dIn = new DataInputStream(inputstream);
            Log.i("Recebidos", "onHandleIntent: " + dIn.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
