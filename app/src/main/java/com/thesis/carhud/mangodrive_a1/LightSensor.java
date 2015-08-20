package com.thesis.carhud.mangodrive_a1;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LightSensor extends Service {
    SensorManager sensorManager;
    Sensor sensor;
    public String b;
    public int i = 0,t=0;
    float xyz;
    float x=0,xd;
    boolean checkstate = false;
    
@Override
public void onCreate() {
        super.onCreate();
        Log.d("TAG", "LightStart");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        start();
    }
    public void start() {
        sensorManager.registerListener(lightListener, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(lightListener);
    }

    public SensorEventListener lightListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) { }

        public void onSensorChanged(SensorEvent event) {


            x = event.values[0];
            Log.d("LIght Meter : ",String.valueOf(x));
            Log.d("Check State :",String.valueOf(checkstate));
            if(checkstate == false){
                xd=x;
                checkstate = true;
                Log.d("Check State 2 :",String.valueOf(checkstate));
                Log.d("Check XD 2 :",String.valueOf(xd));

            }
            else {
                if (xd/2 > x) {
                    CountDownTimer cdt = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            onDestroy();
                            Log.d("Count", String.valueOf(t));
                            t++;
                        }

                        public void onFinish() {
                            Log.d("Count", "Finish");
                            Toast.makeText(getApplicationContext(), "LightAnswer !!", Toast.LENGTH_LONG).show();
                        }

                    }.start();

                }
            }

            }


    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
