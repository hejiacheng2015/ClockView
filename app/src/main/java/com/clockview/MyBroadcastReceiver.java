package com.clockview;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by HJC on  2016/11/10 17:21.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            KeyguardManager mKeyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
            boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
            if (flag) {
                Intent sayHelloIntent = new Intent(context, MainActivity.class);
                sayHelloIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(sayHelloIntent);
            }
        }
    }
}