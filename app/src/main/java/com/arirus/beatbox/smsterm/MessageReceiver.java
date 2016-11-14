package com.arirus.beatbox.smsterm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by whd on 2016/11/13.
 */

public class MessageReceiver extends BroadcastReceiver {
    private static final String TAG = "SMSTerm_MessageReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"4444444");
        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");

        SmsMessage[] smsMessages = new SmsMessage[pdus.length];
        for (int i = 0; i< smsMessages.length; i++)
        {
            smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        }
        String address = smsMessages[0].getOriginatingAddress();
        String fullMessage = "";
        for (SmsMessage message:smsMessages)
        {
            fullMessage += message.getMessageBody();
        }
        Log.i(TAG, "电话号码是"+address);
        Log.i(TAG,"内容是"+fullMessage);
        Toast.makeText(context,"fullMessage",Toast.LENGTH_LONG).show();
    }
}
