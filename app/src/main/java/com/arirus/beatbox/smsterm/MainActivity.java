package com.arirus.beatbox.smsterm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SMSTerm_mainActivity";
    ToggleButton mToggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToggleButton= (ToggleButton)findViewById(R.id.smsterm_activity_toggleButton);
        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mToggleButton.isChecked())
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
                    {
                        requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 0);
                    }
                    else
                    {
                        Log.i(TAG, "1111111");
                        TermService.startService(getApplicationContext());
                    }

                }
                else if (!mToggleButton.isChecked())
                {
                    Log.i(TAG, "2222222");
                    TermService.stopService(getApplicationContext());
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                TermService.startService(getApplicationContext());
            }
            else
            {
                mToggleButton.setChecked(false);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
