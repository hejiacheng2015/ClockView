package com.clockview;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by HJC on  2016/11/10 17:38.
 */
public class MyService extends Service {
    public static final String TAG = "MyService";
    private MyBroadcastReceiver receiver;

    @Override
    public void onCreate() {
        super.onCreate();
        registSreenStatusReceiver();
        Log.e(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand() executed");

        /**
         *创建Notification
         */
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        builder.setSmallIcon(R.mipmap.ic_launcher);
//        builder.setContentTitle("前台服务");
//        builder.setContentText("这是前台服务");
        Intent intent2 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity
                (this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        startForeground(1, notification);
        return super.onStartCommand(intent, flags, Service.START_NOT_STICKY);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        Intent localIntent = new Intent();
        localIntent.setClass(this, MyService.class); // 销毁时重新启动Service
        this.startService(localIntent);
        Log.e(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void registSreenStatusReceiver() {
        receiver = new MyBroadcastReceiver();
        IntentFilter screenStatusIF = new IntentFilter();
        screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(receiver, screenStatusIF);
    }

}