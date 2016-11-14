package com.arirus.beatbox.smsterm;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SMSTerm_mainActivity";
    ToggleButton mToggleButton;
    BroadcastReceiver mReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            int permissionCheck = checkSelfPermission(  Manifest.permission.RECEIVE_SMS);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 0);
            } else {
                mReceiver = new MessageReceiver();
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.provider.Telephony.SMS_RECEIVED");
                registerReceiver(mReceiver,filter);
            }
        }
        else
        {
            mReceiver = new MessageReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.provider.Telephony.SMS_RECEIVED");
            registerReceiver(mReceiver,filter);
        }



        mToggleButton= (ToggleButton)findViewById(R.id.smsterm_activity_toggleButton);
        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mToggleButton.isChecked())
//                {
//                    Log.i(TAG, "1111111");
////                    TermService.startService(getApplicationContext());
//                    mReceiver = new MessageReceiver();
//                    IntentFilter filter = new IntentFilter();
//                    filter.addAction("android.provider.Telephony.SMS_RECEIVED");
//                    registerReceiver(mReceiver,filter);
//                }
//                else if (!mToggleButton.isChecked())
//                {
//                    Log.i(TAG, "2222222");
////                    TermService.stopService(getApplicationContext());
//                    unregisterReceiver(mReceiver);
//                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
