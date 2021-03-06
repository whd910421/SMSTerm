package com.arirus.beatbox.smsterm;

import android.Manifest;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by whd on 2016/11/13.
 */

public class TermService extends Service {
    private static final String TAG = "SMSTerm_TermService";
    private static MessageReceiver sMessageReceiver = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         Log.i(TAG,"onStartCommand");
         if (sMessageReceiver == null) {
            sMessageReceiver = new MessageReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.provider.Telephony.SMS_RECEIVED");
            registerReceiver(sMessageReceiver,filter);
         }
        return super.onStartCommand(intent, flags, startId);
    }

    public static void startService(Context context)
    {
        context.startService(new Intent(context,TermService.class));
    }
    public static void stopService(Context context)
    {
        context.stopService(new Intent(context,TermService.class));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"33333333");
        if (sMessageReceiver != null)
            unregisterReceiver(sMessageReceiver);
    }


}
