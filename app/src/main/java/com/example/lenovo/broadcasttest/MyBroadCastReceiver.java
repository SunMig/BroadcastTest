package com.example.lenovo.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Lenovo on 2018/10/14.
 */

public class MyBroadCastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Received LocalBroadcast!!",Toast.LENGTH_SHORT).show();
    }
}
