package com.thesis.carhud.mangodrive_a1;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.internal.telephony.ITelephony;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Method;

public class MainCallBroadcast extends BroadcastReceiver implements View.OnTouchListener {
    public static boolean Statuscheck = false;
    SharedPreferences sharedpreferences;
    RoundImage roundedImage;
    private ITelephony telephonyService;
    String message = "Test";
    final String a1 = " ";
    int t =1;
    int td = 3;
    String incomingNumber =" ";
    TextView Replyt;
    float x1,x2;
    float y1, y2;
    int Countertext=1;


    @Override
    public void onReceive(final Context context, final Intent intent) {
        sharedpreferences = context.getSharedPreferences("callnumber", Context.MODE_PRIVATE);
        //sharedpreferences = context.getSharedPreferences("Message", Context.MODE_PRIVATE);
        Log.d("Status", "CallBroadcasting Start");
        Log.d("Call 1 ",sharedpreferences.getString("callnumber1","No Contact"));
        Log.d("Call 2 ",sharedpreferences.getString("callnumber2","No Contact"));
        Log.d("Call 3 ",sharedpreferences.getString("callnumber3","No Contact"));
        Log.d("Call 4 ",sharedpreferences.getString("callnumber4","No Contact"));
        Log.d("Call 5 ",sharedpreferences.getString("callnumber5","No Contact"));
        Log.d("Call 6 ",sharedpreferences.getString("callnumber6","No Contact"));


        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (!TelephonyManager.EXTRA_STATE_RINGING.equals(state)){
            Log.d("Status  ", String.valueOf(state));
            Statuscheck = false;
        }

        else if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)&&(state != "IDELL") ) {
            incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, incomingNumber + "  Incoming", Toast.LENGTH_LONG).show();

            if (incomingNumber.equals(sharedpreferences.getString("callnumber1","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber2","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber3","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber4","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber5","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber6","No Contact"))){
                final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                final RelativeLayout ly = new RelativeLayout(context);
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

                final String a1 = getContactDisplayNameByNumber(context);

                ImageView rocketImage1 = new ImageView(context);
                rocketImage1.setId(R.id.pic01);
                if (a1 == "null") {
                    Picasso.with(context.getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(rocketImage1);
                }
                else{
                    Picasso.with(context.getApplicationContext()).load(a1).transform(new RoundPic()).into(rocketImage1);
                }

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
                Number.setText(incomingNumber);
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
                parmsImgBa.setMargins(0,0,0,0);
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
                parmsImgBr.setMargins(0,0,0,0);
                Reject.setLayoutParams(parmsImgBr);

                final TextView Reply = new TextView(context);
                Reply.setId(R.id.Reply);
                Reply.setVisibility(View.INVISIBLE);
                Reply.setTextColor(R.color.Black);
                RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT  ,RelativeLayout.LayoutParams.WRAP_CONTENT );
                parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                Reply.setTextSize(20);
                Reply.setText("Reply1");
                Reply.setLayoutParams(parmsTrp);

                final ImageView Replyt = new ImageView(context);
                Replyt.setId(R.id.Replyt);
                Replyt.setImageResource(R.drawable.reply);
                int widthsBrp = 350;
                int heightsBrp = 350;
                RelativeLayout.LayoutParams parmsImgBrp = new RelativeLayout.LayoutParams(widthsBrp,heightsBrp);
                parmsImgBrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                parmsImgBrp.addRule(RelativeLayout.BELOW, R.id.br);
                Replyt.setLayoutParams(parmsImgBrp);



                ly.addView(rocketImage1);
                ly.addView(Name);
                ly.addView(Number);
                ly.addView(Answer);
                ly.addView(Reject);
                ly.addView(Reply);
                ly.addView(Replyt);
                ly.setBackgroundResource(R.drawable.bg);
                wm.addView(ly, params);
                Toast.makeText(context, "LightSensorService Will Start"     , Toast.LENGTH_LONG).show();
                CountDownTimer cdt = new CountDownTimer(7000, 1000) {
                    @Override
                    public void onTick(long l) {

                        Log.d("Count", String.valueOf(t));
                        if(t==4){
                            //ly.removeView(Replyt);
                            //Reply.setVisibility(View.VISIBLE);
                           // Reply.setText("Light Answer  Start ");
                        }
                        else if(t>4){
                            //Reply.setText(String.valueOf(td));
                           // td--;
                            ly.removeView(Replyt);
                            Reply.setVisibility(View.VISIBLE);
                            Reply.setText("Light Answer  Start ");
                        }
                        t++;
                    }

                    @Override
                    public void onFinish() {
                        Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
                        i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(
                                KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
                        context.sendOrderedBroadcast(i, null);
                        Log.d("Incomeing" ,"AutoAnswer Incoming");
                        wm.removeView(ly);
                    }
                }.start();

            }
            else if (incomingNumber.equals(sharedpreferences.getString("callnumber1re","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber2re","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber3re","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber4re","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber5re","No Contact"))
                    ||incomingNumber.equals(sharedpreferences.getString("callnumber6re","No Contact"))){

                final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                final RelativeLayout ly = new RelativeLayout(context);
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

                final String a1 = getContactDisplayNameByNumber(context);

                ImageView rocketImage1 = new ImageView(context);
                rocketImage1.setId(R.id.pic01);
                if (a1 == "null") {
                    Picasso.with(context.getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(rocketImage1);
                }
                else{
                    Picasso.with(context.getApplicationContext()).load(a1).transform(new RoundPic()).into(rocketImage1);
                }

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
                Number.setText(incomingNumber);
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
                parmsImgBa.setMargins(0,0,0,0);
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
                parmsImgBr.setMargins(0,0,0,0);
                Reject.setLayoutParams(parmsImgBr);

                final TextView Reply = new TextView(context);
                Reply.setId(R.id.Reply);
                Reply.setVisibility(View.INVISIBLE);
                Reply.setTextColor(R.color.Black);
                RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT  ,RelativeLayout.LayoutParams.WRAP_CONTENT );
                parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                Reply.setTextSize(20);
                Reply.setText("Reply1");
                Reply.setLayoutParams(parmsTrp);

                final ImageView Replyt = new ImageView(context);
                Replyt.setId(R.id.Replyt);
                Replyt.setImageResource(R.drawable.reply);
                int widthsBrp = 350;
                int heightsBrp = 350;
                RelativeLayout.LayoutParams parmsImgBrp = new RelativeLayout.LayoutParams(widthsBrp,heightsBrp);
                parmsImgBrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                parmsImgBrp.addRule(RelativeLayout.BELOW, R.id.br);
                Replyt.setLayoutParams(parmsImgBrp);



                ly.addView(rocketImage1);
                ly.addView(Name);
                ly.addView(Number);
                ly.addView(Answer);
                ly.addView(Reject);
                ly.addView(Reply);
                ly.addView(Replyt);
                ly.setBackgroundResource(R.drawable.bg);
                wm.addView(ly, params);
                CountDownTimer cdt = new CountDownTimer(7000, 1000) {
                    @Override
                    public void onTick(long l) {

                        Log.d("Count", String.valueOf(t));
                        if(t==1){
                            ly.removeView(Replyt);
                            Reply.setVisibility(View.VISIBLE);
                            Reply.setText("Auto Reject Will Start ");
                        }
                        else if(t>2 && t<6){
                            Reply.setText(String.valueOf(td));
                            td--;
                        }
                        else if(t>5){
                            Reply.setText("Reply message Sent! \n"+"ขับรถอยู่ เดี๋ยวโทรกลับ");
                        }

                       t++;
                    }

                    @Override
                    public void onFinish() {
                        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                        try {
                            Class c = Class.forName(tm.getClass().getName());
                            Method m = c.getDeclaredMethod("getITelephony");
                            m.setAccessible(true);
                            telephonyService = (ITelephony) m.invoke(tm);
                            Bundle bundle = intent.getExtras();
                            String phoneNumber = bundle.getString("incoming_number");
                            Log.d("INCOMING", phoneNumber);
                            if ((phoneNumber != null)) {
                                telephonyService.endCall();
                                Log.d("HANG UP", phoneNumber);
                                wm.removeView(ly);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();


            }
            else{

                final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                final RelativeLayout ly = new RelativeLayout(context);
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

                final String a1 = getContactDisplayNameByNumber(context);

                ImageView rocketImage1 = new ImageView(context);
                rocketImage1.setId(R.id.pic01);
                if (a1 == "null") {
                    Picasso.with(context.getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(rocketImage1);
                }
                else{
                    Picasso.with(context.getApplicationContext()).load(a1).transform(new RoundPic()).into(rocketImage1);
                }

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
                Number.setText(incomingNumber);
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
                parmsImgBa.setMargins(0,0,0,0);
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
                parmsImgBr.setMargins(0,0,0,0);
                Reject.setLayoutParams(parmsImgBr);

                final TextView Reply = new TextView(context);
                Reply.setId(R.id.Reply);
                RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT  ,RelativeLayout.LayoutParams.WRAP_CONTENT );
                parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                Reply.setTextSize(20);
                Reply.setText("Reply1");
                Reply.setLayoutParams(parmsTrp);

                final ImageView Replyt = new ImageView(context);
                Replyt.setId(R.id.Replyt);
                Replyt.setImageResource(R.drawable.reply);
                int widthsBrp = 350;
                int heightsBrp = 350;
                RelativeLayout.LayoutParams parmsImgBrp = new RelativeLayout.LayoutParams(widthsBrp,heightsBrp);
                parmsImgBrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                parmsImgBrp.addRule(RelativeLayout.BELOW, R.id.br);
                Replyt.setLayoutParams(parmsImgBrp);



                ly.addView(rocketImage1);
                ly.addView(Name);
                ly.addView(Number);
                ly.addView(Answer);
                ly.addView(Reject);
                //ly.addView(Reply);
                ly.addView(Replyt);
                ly.setBackgroundResource(R.drawable.bg);
                wm.addView(ly, params);

                if(String.valueOf(state).equals("IDLE")){
                    wm.removeView(ly);
                }

                Answer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
                        i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
                        context.sendOrderedBroadcast(i, null);
                        Log.d("Incomeing" ,"AutoAnswer Incoming");
                        wm.removeView(ly);
                    }
                });

                Reject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("Check Reject", "Reject");
                        wm.removeView(ly);
                    }
                });
                Replyt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("Check Answer", "Reply");
                        ly.removeView(Replyt);
                        ly.addView(Reply);

                    }
                });
                Reply.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("Check Reply", "Reply");
                        sendSMS(incomingNumber, message);
                        Toast.makeText(context  , "Message has sent", Toast.LENGTH_SHORT).show();

                    }
                });
                Reply.setOnTouchListener((View.OnTouchListener) this);

                Toast.makeText(context, "LightSensorService Is Start"     , Toast.LENGTH_LONG).show();
                Intent intentLight = new Intent(context,LightSensor.class);
                context.startService(intentLight);


            }

        }
    }


    public String getContactDisplayNameByNumber(Context context ) {
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(incomingNumber));
        String name = "?";
        String contactId ="?";
        String Pic ="?";
        String contactID="?";
        Uri my_contact_Uri = null;

        ContentResolver contentResolver = context.getContentResolver();
        Cursor contactLookup = contentResolver.query(uri, new String[] {BaseColumns._ID,
                ContactsContract.PhoneLookup.DISPLAY_NAME,ContactsContract.PhoneLookup.PHOTO_URI }, null, null, null);

        try {
            if (contactLookup != null && contactLookup.getCount() > 0) {
                contactLookup.moveToNext();
                name = contactLookup.getString(contactLookup.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                contactId = contactLookup.getString(contactLookup.getColumnIndex(BaseColumns._ID));
                Pic = contactLookup.getString(contactLookup.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
                int columnIndex_ID = contactLookup.getColumnIndex(ContactsContract.Contacts._ID);
                contactID = contactLookup.getString(columnIndex_ID);
                my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));

            }
        } finally {
            if (contactLookup != null) {
                contactLookup.close();
            }
        }
        Log.d("Name",name);
        Log.d("CheckID",contactId);
        Log.d("Picture",Pic);
        Log.d("Picture2",contactID);
        Log.d("Picture3",String.valueOf(my_contact_Uri));
        return String.valueOf(my_contact_Uri);
    }
    public void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
    public void  removeView(Context context){


    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                x2 = event.getX();
                y2 = event.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x1 = event.getX();
                y1 = event.getY();
                if (x1 < x2)
                    if (x1 > x2) {
                        Log.d("slide", String.valueOf(Countertext));
                        if (Countertext > 2) {
                            RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                            parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                            Replyt.setTextSize(20);
                            Replyt.setText(sharedpreferences.getString("Massage3", "โทรมาทำเหี้ยไร อีดอก"));
                            Replyt.setLayoutParams(parmsTrp);
                        }
                        else {
                            Countertext++;
                            RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                            parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                            Replyt.setTextSize(20);
                            Log.d("","Left to Right");
                            Replyt.setText(sharedpreferences.getString("Massage" + Countertext, ""));
                            Replyt.setLayoutParams(parmsTrp);
                        }

                    }



                if (x1 < x2) {
                    if (Countertext < 2) {
                        RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                        parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                        Replyt.setTextSize(20);
                        Replyt.setText(sharedpreferences.getString("Massage1", "กำลังขับรถค่ะ อีดอก"));
                        Replyt.setLayoutParams(parmsTrp);
                    }
                    else {
                        Countertext--;
                        RelativeLayout.LayoutParams parmsTrp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        parmsTrp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                        parmsTrp.addRule(RelativeLayout.BELOW, R.id.br);
                        Replyt.setTextSize(20);
                        Log.d("","Right to Left");
                        Replyt.setText(sharedpreferences.getString("Massage" + Countertext, ""));
                        Replyt.setLayoutParams(parmsTrp);
                    }

                }
                break;
            }
            case MotionEvent.ACTION_MOVE:
            {

                break;
            }
        }
        return true;
    }

}
