package com.thesis.carhud.mangodrive_a1;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Document;

import java.util.ArrayList;

/**
 * Created by l2ol3otic2 on 4/27/2015.
 */
public class GetDataForMapActivity extends FragmentActivity {
    GoogleMap mMap;
    GMapV2Direction md;

    LatLng startPosition = new LatLng(13.776158,100.573457);
    LatLng endPosition = new LatLng(13.778336,100.569820);
    //LatLng startPosition = new LatLng(13.746430,100.529178);
   // LatLng endPosition = new LatLng(13.729242,20100.536419);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapactivity_layout);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy
                    = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        md = new GMapV2Direction();
        mMap = ((SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        LatLng coordinates = new LatLng(13.776158,100.573457);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16));

        mMap.addMarker(new MarkerOptions().position(startPosition).title("Start"));
        mMap.addMarker(new MarkerOptions().position(endPosition).title("End"));
        Document doc = md.getDocument(startPosition
                , endPosition, GMapV2Direction.MODE_DRIVING);
        int duration = md.getDurationValue(doc);
        String distance = md.getDistanceText(doc);
        String start_address = md.getStartAddress(doc);
        String copy_right = md.getCopyRights(doc);
        ArrayList<String> turnByturnDistance = new ArrayList();
        turnByturnDistance = md.getDistanceTBT(doc);
        ArrayList<String> ProcessDistanceturnByturn = new ArrayList();
        if(turnByturnDistance.size()>0){
            for (int i = 0; i < turnByturnDistance.size(); i++) {
                String T4 = turnByturnDistance.get(i);
                Log.i("NodeDistance",T4);
                ProcessDistanceturnByturn.add(T4);
            }
        }
        ArrayList<String> turnByturn = new ArrayList();
        turnByturn = md.getTBT(doc);
        ArrayList<String> ProcessturnByturn = new ArrayList();
        if(turnByturn.size()>0){
            for (int i = 0; i < turnByturn.size(); i++) {
                  String T4 = turnByturn.get(i);
                  Log.i("Node1",T4);
                  String newWord = T4.replace("<b>","");
                  String newWord2 = newWord.replace("</b>","");
                  ProcessturnByturn.add(newWord2);
                  Log.i("Node2",ProcessturnByturn.get(i));
            }
        }

        TextView t1 = (TextView)findViewById(R.id.T1);
        StringBuilder b = new StringBuilder();
        for (Object s : ProcessturnByturn){
            b.append(s + "\n");
        }
        t1.setText(b.toString());

        ArrayList<LatLng> directionPoint = md.getDirection(doc);

    }
}
