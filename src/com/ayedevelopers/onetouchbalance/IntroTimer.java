package com.ayedevelopers.onetouchbalance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by mufasil on 17-07-2015.
 */
public class IntroTimer extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(IntroTimer.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}