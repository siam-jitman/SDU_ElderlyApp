package th.in.streetfood.elderlyapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import org.apache.cordova.DroidGap;

public class MainActivity extends DroidGap {

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        MainActivity.super.setIntegerProperty("splashscreen", R.drawable.logo);
//        MainActivity.super.onMessage("splashscreen",R.drawable.logo);
//        MainActivity.super.setIntegerProperty("backgroundColor", Integer.parseInt("#3F51B5".replaceFirst("^#",""), 16));
//        MainActivity.super.loadUrl("http://tayaitourism.com");
//        MainActivity.super.onMessage("splashscreen","hide");
//
//    }


    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000L;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        handler = new Handler();

        runnable = new Runnable() {
            public void run() {
                MainActivity.super.setIntegerProperty("backgroundColor", Integer.parseInt("#3F51B5".replaceFirst("^#", ""), 16));
                MainActivity.super.loadUrl("http://tayaitourism.com");
            }
        };
    }

    public void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }
}

