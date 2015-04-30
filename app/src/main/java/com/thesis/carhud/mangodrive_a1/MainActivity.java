package com.thesis.carhud.mangodrive_a1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

public static String call1="",call2="",call3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);


        View mCustomView = mInflater.inflate(R.layout.actionbarcustum, null);
        TextView im2 = (TextView)mCustomView.findViewById(R.id.imageButton2);
        ImageButton im1 = (ImageButton)mCustomView.findViewById(R.id.imageButton);
        im1.setVisibility(mCustomView.INVISIBLE);
        im2.setVisibility(mCustomView.INVISIBLE);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        //Spanned text = Html.fromHtml("<b>" + "Main" + "</b>" + "<i>" + "Activity" + "</i>" + "<small>" + "C@" + "</small>");
        //mTitleTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        final SpannableStringBuilder sb = new SpannableStringBuilder("MAIN ACTIVITIES");
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        final StyleSpan iss = new StyleSpan(android.graphics.Typeface.ITALIC);
        sb.setSpan(bss, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold
        sb.setSpan(iss, 6, 15, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 2 characters Italic
        mTitleTextView.setText(sb);
        ImageButton imageButton = (ImageButton) mCustomView.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
                        Toast.LENGTH_LONG).show();

            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        final ImageButton imgbtn = (ImageButton) findViewById(R.id.imb1);
        imgbtn.setImageResource(R.drawable.clock);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Clock", "Check");
                Intent intent = new Intent(MainActivity.this,ClockPage.class);
                startActivity(intent);
            }
        });

        //ปุ่ม2
        final ImageButton imgbtn1 = (ImageButton) findViewById(R.id.imb2);
        imgbtn1.setImageResource(R.drawable.music);
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Music", "Check");
                Intent intent = new Intent(MainActivity.this,MusicPage.class);
                startActivity(intent);
            }
        });


        final ImageButton imgbtn2 = (ImageButton) findViewById(R.id.imb3);
        imgbtn2.setImageResource(R.drawable.map);
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Map", "Check");
                Intent intent = new Intent(MainActivity.this,FindLocationFromName.class);
                startActivity(intent);
            }
        });


        final ImageButton imgbtn3 = (ImageButton) findViewById(R.id.imb4);
        imgbtn3.setImageResource(R.drawable.setting);
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Setting", "Check");
                Intent intent = new Intent(MainActivity.this,CallPage.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
