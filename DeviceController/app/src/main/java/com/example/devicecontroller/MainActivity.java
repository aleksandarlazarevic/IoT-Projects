package com.example.devicecontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TcpClient mTcpClient;
    Button mButton;
    EditText mIPAddressEditText;
    EditText mPortNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.ConnectButton);
        mIPAddressEditText = (EditText)findViewById(R.id.IPAddress);
        mPortNumberEditText = (EditText)findViewById(R.id.PortNumber);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Constants.ipAddress = mIPAddressEditText.getText().toString();
                        Constants.portNumber = Integer.parseInt(mPortNumberEditText.getText().toString());

                        // start connection to the server
                        new ConnectTask().execute("");
                        // send a message to the server
                        if (mTcpClient != null){
                            mTcpClient.sendMessage("TestMessage");
                        }
                        // close the connection to the server
                        if (mTcpClient != null){
                            mTcpClient.stopClient();
                        }
                    }
                });
    }
}
