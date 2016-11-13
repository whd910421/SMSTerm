package com.arirus.beatbox.smsterm;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by whd on 2016/11/13.
 */

public class StartUpService extends IntentService {
    private static final String TAG = "SMSTerm_StartUpService";

    public StartUpService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
