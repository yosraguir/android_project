package com.example.tp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class Breceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Attention , Broadcast Intent Detected",Toast.LENGTH_LONG).show();
    }
}
