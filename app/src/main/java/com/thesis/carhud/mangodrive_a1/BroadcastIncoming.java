package com.thesis.carhud.mangodrive_a1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BroadcastIncoming extends BroadcastReceiver {

    RoundImage roundedImage;

    public BroadcastIncoming() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT |
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);

        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.gravity = Gravity.TOP;


        ImageView rocketImage1 = new ImageView(context);
        rocketImage1.setId(R.id.pic01);
        rocketImage1.setBackgroundResource(R.drawable.clock);
        int widths = 300;
        int heights = 300;
        RelativeLayout.LayoutParams parmsImg = new RelativeLayout.LayoutParams(widths,heights);
        parmsImg.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        parmsImg.setMargins(0,150,0,0);
        rocketImage1.setLayoutParams(parmsImg);

        TextView Name = new TextView(context);
        Name.setId(R.id.name);
        RelativeLayout.LayoutParams parmsTna = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT ,RelativeLayout.LayoutParams.WRAP_CONTENT);
        parmsTna.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        parmsTna.addRule(RelativeLayout.BELOW, R.id.pic01);
        Name.setTextSize(50);
        Name.setText("Incoming");
        Name.setLayoutParams(parmsTna);


        TextView Number = new TextView(context);
        Number.setId(R.id.number);
        RelativeLayout.LayoutParams parmsTnu = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT  ,RelativeLayout.LayoutParams.WRAP_CONTENT );
        parmsTnu.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        parmsTnu.addRule(RelativeLayout.BELOW, R.id.name);
        Number.setTextSize(30);
        Number.setText("Number");
        Number.setLayoutParams(parmsTnu);


        ImageView Answer = new ImageView(context);
        Answer.setId(R.id.ba);
        Answer.setImageResource(R.drawable.answer);
        int widthsBa = 350;
        int heightsBa = 350;
        RelativeLayout.LayoutParams parmsImgBa = new RelativeLayout.LayoutParams(widthsBa,heightsBa);
        parmsImgBa.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        parmsImgBa.addRule(RelativeLayout.BELOW, R.id.number);
        parmsImgBa.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        parmsImgBa.setMargins(0,100,0,0);
        Answer.setLayoutParams(parmsImgBa);


        ImageView Reject = new ImageView(context);
        Reject.setId(R.id.br);
        Reject.setImageResource(R.drawable.reject);
        int widthsBr = 350;
        int heightsBr = 350;
        RelativeLayout.LayoutParams parmsImgBr = new RelativeLayout.LayoutParams(widthsBr,heightsBr);
        parmsImgBr.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        parmsImgBr.addRule(RelativeLayout.BELOW, R.id.number);
        parmsImgBr.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        parmsImgBr.setMargins(0,100,0,0);
        Reject.setLayoutParams(parmsImgBr);



        final RelativeLayout ly = new RelativeLayout(context);
        ly.addView(rocketImage1);
        ly.addView(Name);
        ly.addView(Number);
        ly.addView(Answer);
        ly.addView(Reject);
        ly.setBackgroundColor(Color.YELLOW);
        wm.addView(ly, params);


        Answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Check Answer", "Answer");
                wm.removeView(ly);
            }
        });

        Reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Check Reject", "Reject");
            }
        });

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
    }
}
