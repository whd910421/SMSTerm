package com.arirus.beatbox.smsterm;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SMSTerm_mainActivity";
    ToggleButton mToggleButton;
//    BroadcastReceiver mReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
//        unregisterReceiver(mReceiver);
    }
}
