package com.example.ers.uppgift_731;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mTextView  = (TextView) findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean connection = internetConenctionOK();
                if (connection == true) {
                    mTextView.setText("We have an internet connection");
                }
                else if (connection == false) {
                    mTextView.setText("No internet connection!");
                }
            }
        });
    }

    private boolean internetConenctionOK() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo internetConnection = cm.getActiveNetworkInfo();
        return internetConnection != null && internetConnection.isConnected();
    }
}
