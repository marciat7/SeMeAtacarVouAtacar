package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
    }
//    public static class FileServerAsyncTask extends AsyncTask {
//
//        private Context context;
//        private TextView statusText;
//
//        public FileServerAsyncTask(Context context, View statusText) {
//            this.context = context;
//            this.statusText = (TextView) statusText;
//        }
//        /**
//         * Start activity that can handle the JPEG image
//         */
//
//        @Override
//        protected void onPostExecute(Object o) {
//           /* if (result != null) {
//                statusText.setText("File copied - " + result);
//                Intent intent = new Intent();
//                intent.setAction(android.content.Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.parse("file://" + result), "image/*");
//                context.startActivity(intent);
//            }*/
//        }
//
//        @Override
//        protected String doInBackground(Object[] params) {
//            try {
//
//                /**
//                 * Create a server socket and wait for client connections. This
//                 * call blocks until a connection is accepted from a client
//                 */
//                ServerSocket serverSocket = new ServerSocket(8888);
//                Socket client = serverSocket.accept();
//
//                InputStream inputstream = client.getInputStream();
//                inputstream.
//
//                String toSend = "String to send";
//
//                /**
//                 * If this code is reached, a client has connected and transferred data
//                 * Save the input stream from the client as a JPEG file
//                 */
//
//                serverSocket.close();
//                return f.getAbsolutePath();
//            } catch (IOException e) {
//                return null;
//            }
//           // return null;
//        }
//    }
}


