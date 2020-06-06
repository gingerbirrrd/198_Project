package com.example.a198_try;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.gesture.Gesture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This class manages the Playing page.
 */

public class activity_play extends AppCompatActivity implements View.OnTouchListener {

    private ImageView button;
    private GestureDetectorCompat mGestureDetector;
    Spinner spinner;
    MediaPlayer player1, player2, player3;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SET APP TO FULL SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play);

        /*------------------------SPINNER / DROPDOWN MENU ---------------------------------------*/

        // The following section of code manages the spinner (aka dropdown menu) contents.

        // DROPDOWN ITEM LABEL
        final String str[] = {
                "Gangsa 1 using Hand", "Gangsa 1 using Stick",
                "Gangsa 2 using Hand", "Gangsa 2 using Stick",
                "Gangsa 3 using Hand", "Gangsa 3 using Stick",
                "Gangsa 4 using Hand", "Gangsa 4 using Stick",
                "Gangsa 5 using Hand", "Gangsa 5 using Stick",
                "Gangsa 6 using Hand", "Gangsa 6 using Stick"};

        spinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.options)
        );
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);

        // SET GANGSA IMAGE CORRESPONDING TO THE SELECTED SPINNER ITEM
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(str[0].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa1);
                } else if(str[1].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa1);
                } else if(str[2].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa2);
                } else if(str[3].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa2);
                } else if(str[4].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa3);
                } else if(str[5].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa3);
                } else if(str[6].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa4);
                } else if(str[7].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa4);
                } else if(str[8].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa5);
                } else if(str[9].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa5);
                } else if(str[10].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa6);
                } else if(str[11].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa6);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*---------------------------------------------------------------------------------------*/

        // DECLARATIONS FOR THE NEXT SECTION OF CODE (ON GESTURES DETECTION)
        button = findViewById(R.id.button_gangsa);
        button.setOnTouchListener((View.OnTouchListener) this);
        mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
    }

    /*-------------------- ON TOUCH LISTENER & GESTURE DETECTOR ---------------------------------*/

    // The following section of code manages gesture detection (touch listener and gesture detector).

    // LISTEN FOR TOUCH EVENTS (FOR WHEN THE USER TOUCHES THE SCREEN)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mGestureDetector.onTouchEvent(event);

        return false;
    }

    // LISTEN FOR GESTURES (FOR WHEN THE USER PERFORMS ANY OF THE THREE(3) GESTURES:
    // SINGLE TAP, LONG PRESS, OR FLING
    private class GestureListener extends GestureDetector.SimpleOnGestureListener{

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A LONG PRESS ON THE SCREEN
        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(activity_play.this,
                    "long press", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT

            playStickDamping(v);    // AUDIO PLAYBACK

            super.onLongPress(e);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A FLING ON THE SCREEN
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(activity_play.this,
                    "fling", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT

            playHandSliding(v);    // AUDIO PLAYBACK

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A SINGLE TAP ON THE SCREEN
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(activity_play.this,
                    "single tap", Toast.LENGTH_SHORT).show();   // GESTURE CONFIRMATORY TEXT

            playStickRinging(v);    // AUDIO PLAYBACK

            return super.onSingleTapConfirmed(e);
        }
    }

    /*-------------------------------------------------------------------------------------------*/


    /*--------------------------------- AUDIO PLAYBACK ------------------------------------------*/

    // The following section of code manages audio playback.

    //
    public void playStickRinging(View v){
        if(player1 == null){
            player1 = MediaPlayer.create(this, R.raw.gsr1_synth);
        }

        player1.start();
    }

    public void playStickDamping(View v){
        if(player2 == null){
            player2 = MediaPlayer.create(this, R.raw.gsd1_synth);
        }

        player2.start();
    }

    public void playHandSliding(View v){
        if(player3 == null){
            player3 = MediaPlayer.create(this, R.raw.ghd1_synth);
        }

        player3.start();
    }

}
