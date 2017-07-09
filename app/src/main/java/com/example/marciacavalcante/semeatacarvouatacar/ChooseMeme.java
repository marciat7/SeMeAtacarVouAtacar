package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChooseMeme extends AppCompatActivity {

    GridView gridView;
    MemeAdpeter memeAdpeter;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_meme);

        dataBase = new DataBase(this);
        final List<Meme> memes = dataBase.getMemes();

        gridView = (GridView) findViewById(R.id.chooseMemeGridView);
        memeAdpeter = new MemeAdpeter(this, R.layout.grid_item_layout, memes);
        gridView.setAdapter(memeAdpeter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Fight.class);
                intent.putExtra("URL", memes.get(position).getUrl());
                startActivity(intent);
                finish();

            }
        });

        String host = "";
        if (savedInstanceState != null){
            host = (String) savedInstanceState.get("HOST");
            Log.i("Hostname: ", host);
            new Client(host).execute();
        }else{
            Bundle extras = getIntent().getExtras();
            if(extras == null) {

            } else {
                Log.i("Hostname: ", host);
                host = extras.getString("HOST");
                new Client(host).execute();
            }
        }

    }


    public static class Client extends AsyncTask{
        String host;

        public Client(String host){
            this.host = host;
        }

        @Override
        protected Object doInBackground(Object[] params) {


            int len;
            Socket socket = new Socket();
            byte buf[]  = new byte[1024];

            try {
                /**
                 * Create a client socket with the host,
                 * port, and timeout information.
                 */
                socket.bind(null);
                socket.connect((new InetSocketAddress(host, 8888)), 500);

                /**
                 * Create a byte stream from a JPEG file and pipe it to the output stream
                 * of the socket. This data will be retrieved by the server device.
                 */
                OutputStream outputStream = socket.getOutputStream();
                //ContentResolver cr = context.getContentResolver();

                PrintWriter out = new PrintWriter(outputStream);

                String toSend = "String to send";

                outputStream.close();

            } catch (FileNotFoundException e) {
                //catch logic
            } catch (IOException e) {
                //catch logic
            }

/**
 * Clean up any open sockets when done
 * transferring or if an exception occurred.
 */
            finally {
                if (socket != null) {
                    if (socket.isConnected()) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            //catch logic
                        }
                    }
                }
            }

            return null;
        }
    }
}
