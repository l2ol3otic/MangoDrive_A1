package com.thesis.carhud.mangodrive_a1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by l2ol3otic2 on 3/30/2015.
 */
public class ContactControlReject extends Activity {
    private static final int REQUEST_CODE_PICK_CONTACTS = 1;
    private final int PICK = 1;
    private ImageView imageViewRound;
    private Uri uriContact;
    private String contactID;
    int a;
    String name;
    int stroke = 20;
    long contactId;
    public static String c1,c2,c3;
    public static String p1,p2,p3,p4,p5,p6;
    RoundImage roundedImage;
    RoundPic roundPic;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearcontactreject);
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.actionbarcustum, null);
        mCustomView.setBackgroundColor(getResources().getColor(R.color.purple));
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("AutoReject");
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);


        sharedpreferences = getSharedPreferences("infopic",Context.MODE_PRIVATE);
        sharedpreferences = getSharedPreferences("callnumber", Context.MODE_PRIVATE);

        final TextView n1 = (TextView) findViewById(R.id.tv1);
        final TextView n2 = (TextView) findViewById(R.id.tv2);
        final TextView n3 = (TextView) findViewById(R.id.tv3);
        final TextView n4 = (TextView) findViewById(R.id.tv4);
        final TextView n5 = (TextView) findViewById(R.id.tv5);
        final TextView n6 = (TextView) findViewById(R.id.tv6);


        n1.setText(sharedpreferences.getString("callnumber1re","No Contact"));
        n2.setText(sharedpreferences.getString("callnumber2re","No Contact"));
        n3.setText(sharedpreferences.getString("callnumber3re","No Contact"));
        n4.setText(sharedpreferences.getString("callnumber4re","No Contact"));
        n5.setText(sharedpreferences.getString("callnumber5re","No Contact"));
        n6.setText(sharedpreferences.getString("callnumber6re","No Contact"));

        Log.d("Check Call 1 ",sharedpreferences.getString("callnumber1re","A"));
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        p1 = sharedpreferences.getString("infopic1re","");
        Log.d("Check p1",p1);
        if(p1.equals("")||p1.equals("null")){
            Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img1);
        }
        else {

            Picasso.with(getApplicationContext()).load(p1).transform(new RoundPic()).into(img1);
        }
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=1;

                Log.d("Check1", "Check");
                Log.d("Pic Chech", String.valueOf(R.drawable.nopicture));
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });

        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        p2 = sharedpreferences.getString("infopic2re","");
        Log.d("Check p2",p2);
        if(p2.equals("")||p2.equals("null")){
            Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img2);
        }
        else {

            Picasso.with(getApplicationContext()).load(p2).transform(new RoundPic()).into(img2);
        }
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=2;
                Log.d("Check2","Check");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });

        final ImageView img3 = (ImageView) findViewById(R.id.img3);
        p3 = sharedpreferences.getString("infopic3re","");
        Log.d("Check p3",p3);
        if(p3.equals("")||p3.equals("null")){
            Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img3);
        }
        else {

            Picasso.with(getApplicationContext()).load(p3).transform(new RoundPic()).into(img3);
        }
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=3;
                Log.d("Check3","Check");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });

        final ImageView img4 = (ImageView) findViewById(R.id.img4);
        p4 = sharedpreferences.getString("infopic4re","");
        Log.d("Check p4",p4);
        if(p4.equals("")||p4.equals("null")){
            Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img4);
        }
        else {

            Picasso.with(getApplicationContext()).load(p4).transform(new RoundPic()).into(img4);
        }
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=4;
                Log.d("Check4","Check");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });

        final ImageView img5 = (ImageView) findViewById(R.id.img5);
        p5 = sharedpreferences.getString("infopic5re","");
        Log.d("Check p5",p5);
        if(p5.equals("")||p5.equals("null")){
            Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img5);
        }
        else {

            Picasso.with(getApplicationContext()).load(p5).transform(new RoundPic()).into(img5);
        }
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=5;
                Log.d("Check5","Check");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });

        final ImageView img6 = (ImageView) findViewById(R.id.img6);
        p6 = sharedpreferences.getString("infopic6re","");
        Log.d("Check p6",p6);
        if(p6.equals("")||p6.equals("null")){
            Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img6);
        }
        else {

            Picasso.with(getApplicationContext()).load(p6).transform(new RoundPic()).into(img6);
        }
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=6;
                Log.d("Check6","Check");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                // calling OnActivityResult with intenet And Some conatct for Identifie
                startActivityForResult(intent, PICK);

            }
        });
        final ImageButton imb = (ImageButton) findViewById(R.id.imageButton);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editors = sharedpreferences.edit();
                editors.clear();
                editors.commit();
                n1.setText(sharedpreferences.getString("callnumber1re","No Contact"));
                n2.setText(sharedpreferences.getString("callnumber2re","No Contact"));
                n3.setText(sharedpreferences.getString("callnumber3re","No Contact"));
                n4.setText(sharedpreferences.getString("callnumber4re","No Contact"));
                n5.setText(sharedpreferences.getString("callnumber5re","No Contact"));
                n6.setText(sharedpreferences.getString("callnumber6re","No Contact"));

                Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img2);
                Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img3);
                Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img4);
                Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img5);
                Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img6);

                Log.d("A",String.valueOf(a));
            }
        });
        TextView im2 = (TextView)mCustomView.findViewById(R.id.imageButton2);
        im2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Next Clicked!",
                        Toast.LENGTH_LONG).show();

                ContactControl.fa.finish();
                finish();

                sharedpreferences = getSharedPreferences("callnumber", Context.MODE_PRIVATE);

                Log.d("Check Call 1 ",sharedpreferences.getString("callnumber1re","A"));
                Log.d("Check Call 2 ",sharedpreferences.getString("callnumber2re","B"));
                Log.d("Check Call 3 ",sharedpreferences.getString("callnumber3re","C"));
                Log.d("Check Call 4 ",sharedpreferences.getString("callnumber4re","D"));
                Log.d("Check Call 5 ",sharedpreferences.getString("callnumber5re","E"));
                Log.d("Check Call 6 ",sharedpreferences.getString("callnumber6re","F"));

            }
        });

        /*Button addcontactM = (Button) findViewById(R.id.ADDM);
        addcontactM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showDialog();
                c1 = sharedpreferences.getString("callnumber1","A");
                c2 = sharedpreferences.getString("callnumber2","B");
                c3 = sharedpreferences.getString("callnumber3","C");
                Intent intent = new Intent(ContactControl.this, Reject.class);
                startActivity(intent);
            }
        });*/

        /*final Button addcontactC = (Button) findViewById(R.id.clear);
        addcontactC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showDialog();
                a=1;
                editors = sharedpreferences.edit();
                editors.clear();
                editors.commit();
                n1.setText(sharedpreferences.getString("callnumber1",""));
                n2.setText(sharedpreferences.getString("callnumber2",""));
                n3.setText(sharedpreferences.getString("callnumber3",""));
                n4.setText(sharedpreferences.getString("callnumber4",""));
                n5.setText(sharedpreferences.getString("callnumber5",""));
                n6.setText(sharedpreferences.getString("callnumber6",""));
                Log.d("A",String.valueOf(a));

            }
        });*/
    }



    @Override
    public void onBackPressed() {

        sharedpreferences = getSharedPreferences("callnumber", Context.MODE_PRIVATE);

        Log.d("Check Call 1 ",sharedpreferences.getString("callnumber1re","A"));
        Log.d("Check Call 2 ",sharedpreferences.getString("callnumber2re","B"));
        Log.d("Check Call 3 ",sharedpreferences.getString("callnumber3re","C"));
        Log.d("Check Call 4 ",sharedpreferences.getString("callnumber4re","D"));
        Log.d("Check Call 5 ",sharedpreferences.getString("callnumber5re","E"));
        Log.d("Check Call 6 ",sharedpreferences.getString("callnumber6re","F"));

        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // a++;
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK) {
                Uri returnUri = data.getData();
                Cursor cursor = getContentResolver().query(returnUri, null, null, null, null);

                if (cursor.moveToNext()) {
                    name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    int columnIndex_ID = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                    String contactID = cursor.getString(columnIndex_ID);
                    String Pic = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
                    int columnIndex_HASPHONENUMBER = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                    String stringHasPhoneNumber = cursor.getString(columnIndex_HASPHONENUMBER);

                    if (stringHasPhoneNumber.equalsIgnoreCase("1")) {
                        Cursor cursorNum = getContentResolver().query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID,
                                null,
                                null);

                        //Get the first phone number
                        if (cursorNum.moveToNext()) {
                            int columnIndex_number = cursorNum.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                            String stringNumber = cursorNum.getString(columnIndex_number);
                            //String Pic2 = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                            //String Pic4 = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
                            //String Pic3 = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI));
                            //Uri myUri = Uri.parse(Pic);
                            Log.d("Number", stringNumber);
                            Log.d("Name", name);
                            //Log.d("PIC",Pic);
                            if(a==1) {
                                TextView n1 = (TextView) findViewById(R.id.tv1);
                                final ImageView img1 = (ImageView) findViewById(R.id.img1);
                                Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));
                               if(String.valueOf(Pic) == "null"){
                                    Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img1);
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber1re",stringNumber);
                                    editors.putString("infopic1re","null");
                                    editors.commit();
                                }
                                else {
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber1re",stringNumber);
                                    editors.putString("infopic1re",String.valueOf(my_contact_Uri));
                                    editors.commit();
                                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                    roundedImage = new RoundImage(my_btmp);
                                    img1.setImageDrawable(roundedImage);

                                    String root = Environment.getExternalStorageDirectory().toString();
                                    File myDir = new File(root + "/saved_imagesFoThesis");
                                    myDir.mkdirs();
                                    String fname = "Image-" + a + ".jpg";
                                    File file = new File(myDir, fname);
                                    if (file.exists()) file.delete();
                                    try {
                                        FileOutputStream out = new FileOutputStream(file);
                                        my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                        out.flush();
                                        out.close();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                               // Log.d("Root", String.valueOf(myDir));
                               // Log.d("NamePic", String.valueOf(fname));
                                //Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg");
                                //img1.setImageBitmap(bitmap);
                                //Drawable drax = new BitmapDrawable(this.getResources(),bitmap);
                                //String pathName = "/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg";
                                //Drawable d = Drawable.createFromPath(pathName);
                                //Picasso.with(getApplicationContext()).load(R.drawable.pic1).transform(new RoundPic()).into(img1);
                                n1.setText(sharedpreferences.getString("callnumber1re","A"));

                            }
                            else if(a==2) {
                                TextView n2 = (TextView) findViewById(R.id.tv2);
                                final ImageView img2 = (ImageView) findViewById(R.id.img2);
                                Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));
                                if(String.valueOf(Pic) == "null"){
                                    Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img2);
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber2re",stringNumber);
                                    editors.putString("infopic2re","null");
                                    editors.commit();
                                }
                                else {
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber2re", stringNumber);
                                    editors.putString("infopic2re", String.valueOf(my_contact_Uri));
                                    editors.commit();
                                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                    roundedImage = new RoundImage(my_btmp);
                                    img2.setImageDrawable(roundedImage);
                                    String root = Environment.getExternalStorageDirectory().toString();
                                    File myDir = new File(root + "/saved_imagesFoThesis");
                                    myDir.mkdirs();
                                    String fname = "Image-" + a + ".jpg";
                                    File file = new File(myDir, fname);
                                    if (file.exists()) file.delete();
                                    try {
                                        FileOutputStream out = new FileOutputStream(file);
                                        my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                        out.flush();
                                        out.close();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    Log.d("Root", String.valueOf(myDir));
                                    Log.d("NamePic", String.valueOf(fname));
                                    //editors.putString("infopic2","/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg");
                                }
                                n2.setText(sharedpreferences.getString("callnumber2re",""));
                            }
                            else if(a==3) {
                                TextView n3 = (TextView) findViewById(R.id.tv3);
                                final ImageView img3 = (ImageView) findViewById(R.id.img3);
                                Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));

                                if(String.valueOf(Pic) == "null"){
                                    Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img3);
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber3re",stringNumber);
                                    editors.putString("infopic3re","null");
                                    editors.commit();
                                }
                                else {
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber3re", stringNumber);
                                    editors.putString("infopic3re", String.valueOf(my_contact_Uri));
                                    editors.commit();
                                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                    roundedImage = new RoundImage(my_btmp);
                                    img3.setImageDrawable(roundedImage);
                                    String root = Environment.getExternalStorageDirectory().toString();
                                    File myDir = new File(root + "/saved_imagesFoThesis");
                                    myDir.mkdirs();
                                    String fname = "Image-" + a + ".jpg";
                                    File file = new File(myDir, fname);
                                    if (file.exists()) file.delete();
                                    try {
                                        FileOutputStream out = new FileOutputStream(file);
                                        my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                        out.flush();
                                        out.close();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    Log.d("Root", String.valueOf(myDir));
                                    Log.d("NamePic", String.valueOf(fname));
                                    //editors.putString("infopic2","/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg");
                                }
                                n3.setText(sharedpreferences.getString("callnumber3re",""));

                            }
                            else if(a==4) {
                                TextView n4 = (TextView) findViewById(R.id.tv4);
                                final ImageView img4 = (ImageView) findViewById(R.id.img4);
                                Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));


                                if(String.valueOf(Pic) == "null"){
                                    Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img4);
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber4re",stringNumber);
                                    editors.putString("infopic4re","null");
                                    editors.commit();
                                }
                                else {
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber4re", stringNumber);
                                    editors.putString("infopic4re", String.valueOf(my_contact_Uri));
                                    editors.commit();
                                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                    roundedImage = new RoundImage(my_btmp);
                                    img4.setImageDrawable(roundedImage);
                                    String root = Environment.getExternalStorageDirectory().toString();
                                    File myDir = new File(root + "/saved_imagesFoThesis");
                                    myDir.mkdirs();
                                    String fname = "Image-" + a + ".jpg";
                                    File file = new File(myDir, fname);
                                    if (file.exists()) file.delete();
                                    try {
                                        FileOutputStream out = new FileOutputStream(file);
                                        my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                        out.flush();
                                        out.close();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    Log.d("Root", String.valueOf(myDir));
                                    Log.d("NamePic", String.valueOf(fname));
                                    //editors.putString("infopic2","/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg");
                                }
                                n4.setText(sharedpreferences.getString("callnumber4re",""));
                            }
                            else if(a==5) {
                                TextView n5 = (TextView) findViewById(R.id.tv5);
                                final ImageView img5 = (ImageView) findViewById(R.id.img5);
                                Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));

                                if(String.valueOf(Pic) == "null"){
                                    Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img5);
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber5re",stringNumber);
                                    editors.putString("infopic5re","null");
                                    editors.commit();
                                }
                                else {
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber5re", stringNumber);
                                    editors.putString("infopic5re", String.valueOf(my_contact_Uri));
                                    editors.commit();
                                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                    roundedImage = new RoundImage(my_btmp);
                                    img5.setImageDrawable(roundedImage);
                                    String root = Environment.getExternalStorageDirectory().toString();
                                    File myDir = new File(root + "/saved_imagesFoThesis");
                                    myDir.mkdirs();
                                    String fname = "Image-" + a + ".jpg";
                                    File file = new File(myDir, fname);
                                    if (file.exists()) file.delete();
                                    try {
                                        FileOutputStream out = new FileOutputStream(file);
                                        my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                        out.flush();
                                        out.close();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    Log.d("Root", String.valueOf(myDir));
                                    Log.d("NamePic", String.valueOf(fname));
                                    //editors.putString("infopic2","/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg");
                                }
                                n5.setText(sharedpreferences.getString("callnumber5re",""));
                            }
                            else if(a==6) {
                                TextView n6 = (TextView) findViewById(R.id.tv6);
                                final ImageView img6 = (ImageView) findViewById(R.id.img6);
                                Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));

                                if(String.valueOf(Pic) == "null"){
                                    Picasso.with(getApplicationContext()).load(R.drawable.nopicture).transform(new RoundPic()).into(img6);
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber6re",stringNumber);
                                    editors.putString("infopic6re","null");
                                    editors.commit();
                                }
                                else {
                                    editors = sharedpreferences.edit();
                                    editors.putString("callnumber6re", stringNumber);
                                    editors.putString("infopic6re", String.valueOf(my_contact_Uri));
                                    editors.commit();
                                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                    roundedImage = new RoundImage(my_btmp);
                                    img6.setImageDrawable(roundedImage);
                                    String root = Environment.getExternalStorageDirectory().toString();
                                    File myDir = new File(root + "/saved_imagesFoThesis");
                                    myDir.mkdirs();
                                    String fname = "Image-" + a + ".jpg";
                                    File file = new File(myDir, fname);
                                    if (file.exists()) file.delete();
                                    try {
                                        FileOutputStream out = new FileOutputStream(file);
                                        my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                        out.flush();
                                        out.close();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    Log.d("Root", String.valueOf(myDir));
                                    Log.d("NamePic", String.valueOf(fname));
                                    //editors.putString("infopic2","/storage/emulated/0/saved_imagesFoThesis/Image-"+a+".jpg");
                                }
                                n6.setText(sharedpreferences.getString("callnumber6re",""));

                            }
                        }

                    } else {
                        Log.d("Number", "NO Phone Number");
                    }

                     Log.d("Count",String.valueOf(a));
                } else {
                    Toast.makeText(getApplicationContext(), "NO data!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}





//Code1
       /* switch (reqCode) {
            case (PICK) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  getContentResolver().query(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        int columnIndex_ID = c.getColumnIndex(ContactsContract.Contacts._ID);
                        String contactID = c.getString(columnIndex_ID);
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String d = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        int columnIndex_HASPHONENUMBER = c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                        String stringHasPhoneNumber = c.getString(columnIndex_HASPHONENUMBER);

                        if(stringHasPhoneNumber.equalsIgnoreCase("1")){
                            Cursor cursorNum = getContentResolver().query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID,
                                    null,
                                    null);

                            //Get the first phone number
                            if(cursorNum.moveToNext()){
                                int columnIndex_number = cursorNum.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                                String stringNumber = cursorNum.getString(columnIndex_number);
                                Log.d("Number", stringNumber);
                            }

                        }else{
                            Log.d("Number","NO Phone Number");
                        }


                        Log.d("Name", name);

                    }
                }
                break;
        }*/

//Code2
       /* if (reqCode == PICK)
        {
            //Cursor cursor =  managedQuery(data.getData(), null, null, null, null);
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
            cursor.moveToNext();
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
            String  name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER)) ;
            String c = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.d("Name ", name);
            Log.d("Phone",phone);
            Log.d("Number" ,c);
            if (cursor != null && cursor.getCount() > 0)
                {
                 while (cursor.moveToNext())
                  {

   phNumber = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));

                      callDuration = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION));
                      dur = Integer.parseInt(callDuration);

 }
               }

              cursor.close();

            cursor = null;
            name= null;
            phone = null;
            c=null;

        }*/

/*String root = Environment.getExternalStorageDirectory().toString();
                                File myDir = new File(root + "/saved_imagesFoThesis");
                                myDir.mkdirs();
                                String fname = "Image-"+ a +".jpg";
                                File file = new File (myDir, fname);
                                if (file.exists ()) file.delete ();
                                try {
                                    FileOutputStream out = new FileOutputStream(file);
                                    my_btmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                    out.flush();
                                    out.close();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Log.d("Root", String.valueOf(myDir));
                                Log.d("NamePic", String.valueOf(fname));
                               // Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.image);*/


//Bitmap bitmaps = BitmapFactory.decodeFile(sharedpreferences.getString("infopic1", String.valueOf(R.drawable.pic1)));
//roundedImage = new RoundImage(bitmaps);
//img1.setImageDrawable(roundedImage);