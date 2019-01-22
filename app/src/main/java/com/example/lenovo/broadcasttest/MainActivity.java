package com.example.lenovo.broadcasttest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private IntentFilter intentFilter;//动态注册打标签
    private MyBroadCastReceiver myBroadCastReceiver;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        //动态注册
        //intentFilter=new IntentFilter();
        //intentFilter.addAction("com.example.broadcasttest.MyBroadCast_Receiver");
        //myBroadCastReceiver=new MyBroadCastReceiver();
        //registerReceiver(myBroadCastReceiver,intentFilter);
        //本地广播，应用程序只能接收自己的广播，别的应用程序接收不到，LocalBroadCastManager
         */
        intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LocalBroadCast");
        myBroadCastReceiver=new MyBroadCastReceiver();
        localBroadcastManager=LocalBroadcastManager.getInstance(this);//获取实例
        //registerReceiver(myBroadCastReceiver,intentFilter);
        localBroadcastManager.registerReceiver(myBroadCastReceiver,intentFilter);
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.broadcasttest.LocalBroadCast");
                localBroadcastManager.sendBroadcast(intent);
                //sendBroadcast(intent);//这样发送广播是标准广播，应用程序都可以接收
                //sendOrderedBroadcast(intent,null);
                /*
                * 还可以发送有序的广播，这样的广播使用sendOrderedBroadcast(intent,null)发送
                * 可以在xml文件里设置广播的优先级，<intent-filter android:priority="100">,
                * 设置优先级之后，发送广播的方法就改为：absortBroadCast();,这样一条广播就会被
                * 应用程序截断，后续的程序就不会接收到了
                * */
            }
        });
    }

    //广播的取消

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myBroadCastReceiver);
        //unregisterReceiver(myBroadCastReceiver);
    }
}
