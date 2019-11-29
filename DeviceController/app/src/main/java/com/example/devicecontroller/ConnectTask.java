package com.example.devicecontroller;

import android.os.AsyncTask;
import android.util.Log;

public class ConnectTask extends AsyncTask<String, String, TcpClient> {
    @Override
    protected TcpClient doInBackground(String... message){
        // creating TCPClient object
        TcpClient mTcpClient = new TcpClient(new TcpClient.OnMessageReceived() {
            @Override
            // here the messageReceived method is implemented
            public void messageReceived(String message) {
                // this method calls teh onProgressUpdate
                publishProgress(message);
            }
        });
        mTcpClient.TcpConnect(Constants.ipAddress, Constants.portNumber);
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values){
        super.onProgressUpdate(values);
        // response received from server
        Log.d("test", "response " + values[0]);
        // process server response here
    }
}
