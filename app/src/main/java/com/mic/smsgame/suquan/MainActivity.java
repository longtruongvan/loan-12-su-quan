package com.mic.smsgame.suquan;

import android.app.Activity;
import android.os.Bundle;
import javax.microedition.midlet.MIDlet;

public class MainActivity extends Activity {
    private SQMidlet midlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MIDlet.setActivity(this);
        midlet = new SQMidlet();
        midlet.startApp();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (midlet != null) {
            midlet.pauseApp();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (midlet != null) {
            midlet.destroyApp(true);
        }
    }
}
