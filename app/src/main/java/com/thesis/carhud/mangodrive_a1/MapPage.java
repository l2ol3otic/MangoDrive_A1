package com.thesis.carhud.mangodrive_a1;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by l2ol3otic2 on 3/30/2015.
 */
public class MapPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mappagelayout);
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.actionbarcustum, null);
        mCustomView.setBackgroundColor(getResources().getColor(R.color.red));
        TextView im2 = (TextView)mCustomView.findViewById(R.id.imageButton2);
        ImageButton im1 = (ImageButton)mCustomView.findViewById(R.id.imageButton);
        im1.setVisibility(mCustomView.INVISIBLE);
        im2.setVisibility(mCustomView.INVISIBLE);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Map");

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

    }
}
