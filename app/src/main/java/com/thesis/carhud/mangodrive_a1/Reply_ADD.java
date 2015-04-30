package com.thesis.carhud.mangodrive_a1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by l2ol3otic2 on 4/22/2015.
 */
public class Reply_ADD extends Activity {

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editors;
    AlertDialog adl;
    int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reply_add_layout);
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.actionbarcustum, null);
        mCustomView.setBackgroundColor(getResources().getColor(R.color.purple));
        TextView im2 = (TextView)mCustomView.findViewById(R.id.imageButton2);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("MessageManagement");
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        sharedpreferences = getSharedPreferences("Message", Context.MODE_PRIVATE);
        final TextView ms1 = (TextView)findViewById(R.id.ms1);
        TextView ms2 = (TextView)findViewById(R.id.ms2);
        TextView ms3 = (TextView)findViewById(R.id.ms3);
        final TextView ms4 = (TextView)findViewById(R.id.ms4);
        final TextView ms5 = (TextView)findViewById(R.id.ms5);
        final TextView ms6 = (TextView)findViewById(R.id.ms6);

        ms1.setText(sharedpreferences.getString("Massage1","กำลังขับรถค่ะ อีดอก"));
        ms2.setText(sharedpreferences.getString("Massage2","ไม่อยากคุย ตอนนี้ ค่อยโทรนะ "));
        ms3.setText(sharedpreferences.getString("Massage3","โทรมาทำเหี้ยไร อีดอก"));
        ms4.setText(sharedpreferences.getString("Massage4","ข้อความที่4"));
        ms5.setText(sharedpreferences.getString("Massage5","ข้อความที่5"));
        ms6.setText(sharedpreferences.getString("Massage6","ข้อความที่6"));
        mCount = sharedpreferences.getInt("mCount",4);
        Log.d("check count", String.valueOf(mCount));

        final ImageButton imb = (ImageButton) findViewById(R.id.imageButton);
        imb.setImageResource(R.drawable.abc_spinner_mtrl_am_alpha);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = Reply_ADD.this.getLayoutInflater();
                adl = new AlertDialog.Builder(Reply_ADD.this).setView(li.inflate(R.layout.dialog_add_massage,null))
                        .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                editors = sharedpreferences.edit();
                                Toast.makeText(getApplicationContext(), "ADD!",Toast.LENGTH_LONG).show();
                                EditText massageIn = (EditText)adl.findViewById(R.id.massage);
                                String massageText = massageIn.getText().toString();
                                Log.d("Check Massage",massageText);
                                Log.d("check count", String.valueOf(mCount));
                                editors.putString("Massage"+String.valueOf(mCount),massageText);
                                editors.commit();
                                if(mCount==4){
                                    ms4.setText(sharedpreferences.getString("Massage4",""));
                                    editors.putInt("mCount", 5);
                                    editors.commit();
                                    mCount++;                                }
                                else if(mCount==5){
                                    ms5.setText(sharedpreferences.getString("Massage5",""));
                                    editors.putInt("mCount",6);
                                    editors.commit();
                                    mCount++;
                                }
                                else if(mCount==6){
                                    ms6.setText(sharedpreferences.getString("Massage6",""));
                                }


                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Cancal!",
                                Toast.LENGTH_LONG).show();
                        editors = sharedpreferences.edit();
                        editors.clear();
                        editors.commit();
                    }
                }).show();
            }
        });
        final TextView imb2 = (TextView) findViewById(R.id.imageButton2);
        imb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
