package com.thesis.carhud.mangodrive_a1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by l2ol3otic2 on 3/30/2015.
 */
public class SplashScreenControl extends Activity {
    private static String TAG = SplashScreenControl.class.getName();
    private static long SLEEP_TIME = 5 ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);

        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
        final ImageView imgView1 = (ImageView) findViewById(R.id.imageView1);
        imgView1.setImageResource(R.drawable.startscreen);


    }
    private class IntentLauncher extends Thread {
        @Override
        public void run(){
            try{
                Thread.sleep(SLEEP_TIME*1000);
            }catch (Exception e){
                Log.e(TAG, e.getMessage());
            }
            Intent intent = new Intent(SplashScreenControl.this,MainActivity.class);
            SplashScreenControl.this.startActivity(intent);
            SplashScreenControl.this.finish();
        }
    }
}
