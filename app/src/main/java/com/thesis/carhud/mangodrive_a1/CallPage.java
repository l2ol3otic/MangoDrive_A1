package com.thesis.carhud.mangodrive_a1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by l2ol3otic2 on 3/30/2015.
 */
public class CallPage extends Activity {

    private ImageView imageViewRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callpagelayout);
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.actionbarcustum, null);
        mCustomView.setBackgroundColor(getResources().getColor(R.color.purple));
        TextView im2 = (TextView)mCustomView.findViewById(R.id.imageButton2);
        ImageButton im1 = (ImageButton)mCustomView.findViewById(R.id.imageButton);
        im1.setVisibility(mCustomView.INVISIBLE);
        im2.setVisibility(mCustomView.INVISIBLE);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Call Setting");


        Button settingBtn = (Button) findViewById(R.id.settingbtn);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showDialog();
                Intent intent = new Intent(CallPage.this, ContactControl.class);
                startActivity(intent);
            }
        });
        Button replysettingBtn = (Button) findViewById(R.id.Reply);
        replysettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showDialog();
                Intent intent = new Intent(CallPage.this, Reply_ADD.class);
                startActivity(intent);
            }
        });

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
    public void showDialog() {
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
        final LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        //View layout = inflater.inflate(R.layout.popcallanswer,
                //(ViewGroup) findViewById(R.id.layout_popup));

        popDialog.setIcon(android.R.drawable.btn_star_big_on);
        popDialog.setTitle("Popup Detail ");
        //popDialog.setView(layout);


        popDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        popDialog.create();
        popDialog.show();

    }
   /* @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        try {
            if (resultCode == Activity.RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cur = managedQuery(contactData, null, null, null, null);
                ContentResolver contect_resolver = getContentResolver();

                if (cur.moveToFirst()) {
                    String id = cur.getString(cur.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                    String name = "";
                    String no = "";

                    Cursor phoneCur = contect_resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[] { id }, null);

                    if (phoneCur.moveToFirst()) {
                        name = phoneCur.getString(phoneCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        no = phoneCur.getString(phoneCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }

                    Log.e("Phone no & name :***: ", name + " : " + no);
                    id = null;
                    name = null;
                    no = null;
                    phoneCur = null;
                }
                contect_resolver = null;
                cur = null;
                //                      populateContacts();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error :: ", e.toString());
        }
    }*/
}
