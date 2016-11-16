package com.ayedevelopers.onetouchbalance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by mufasil on 16-07-2015.
 */
public class Autostart extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent serviceIntent = new Intent(context, AppService.class);
            context.startService(serviceIntent);

        }
    }
}
