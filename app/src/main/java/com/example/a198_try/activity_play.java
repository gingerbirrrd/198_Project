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
    MediaPlayer player_gangsa1_hand_r, player_gangsa1_stick_r,
            player_gangsa2_hand_r, player_gangsa2_stick_r,
            player_gangsa3_hand_r, player_gangsa3_stick_r,
            player_gangsa4_hand_r, player_gangsa4_stick_r,
            player_gangsa5_hand_r, player_gangsa5_stick_r,
            player_gangsa6_hand_r, player_gangsa6_stick_r;
    MediaPlayer player_gangsa1_hand_d, player_gangsa1_stick_d,
            player_gangsa2_hand_d, player_gangsa2_stick_d,
            player_gangsa3_hand_d, player_gangsa3_stick_d,
            player_gangsa4_hand_d, player_gangsa4_stick_d,
            player_gangsa5_hand_d, player_gangsa5_stick_d,
            player_gangsa6_hand_d, player_gangsa6_stick_d;
    MediaPlayer player_gangsa1_hand_s,
            player_gangsa2_hand_s,
            player_gangsa3_hand_s,
            player_gangsa4_hand_s,
            player_gangsa5_hand_s,
            player_gangsa6_hand_s;
    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
    public boolean onTouch (View v, MotionEvent event){
        mGestureDetector.onTouchEvent(event);

        return false;
    }

    // LISTEN FOR GESTURES (FOR WHEN THE USER PERFORMS ANY OF THE THREE(3) GESTURES:
    // SINGLE TAP, LONG PRESS, OR FLING
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A LONG PRESS ON THE SCREEN
        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(activity_play.this,
                    "long press", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT

            if(("Gangsa 1 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickDamping1(v);
            } else if(("Gangsa 2 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickDamping2(v);
            } else if(("Gangsa 3 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickDamping3(v);
            } else if(("Gangsa 4 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickDamping4(v);
            } else if(("Gangsa 5 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickDamping5(v);
            } else if(("Gangsa 6 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickDamping6(v);
            } else if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandDamping1(v);
            } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandDamping2(v);
            } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandDamping3(v);
            } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandDamping4(v);
            } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandDamping5(v);
            } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandDamping6(v);
            }

           // playStickDamping(v);    // AUDIO PLAYBACK

            super.onLongPress(e);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A FLING ON THE SCREEN
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(activity_play.this,
                    "fling", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT

        if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
            playHandSliding1(v);
        } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
            playHandSliding2(v);
        } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
            playHandSliding3(v);
        } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
            playHandSliding4(v);
        } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
            playHandSliding5(v);
        } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
            playHandSliding6(v);
        }

            //playHandSliding(v);    // AUDIO PLAYBACK

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A SINGLE TAP ON THE SCREEN
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(activity_play.this,
                    "single tap", Toast.LENGTH_SHORT).show();   // GESTURE CONFIRMATORY TEXT

            if(("Gangsa 1 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickRinging1(v);
            } else if(("Gangsa 2 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickRinging2(v);
            } else if(("Gangsa 3 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickRinging3(v);
            } else if(("Gangsa 4 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickRinging4(v);
            } else if(("Gangsa 5 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickRinging5(v);
            } else if(("Gangsa 6 using Stick").equals(spinner.getSelectedItem().toString())){
                playStickRinging6(v);
            } else if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandRinging1(v);
            } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandRinging2(v);
            } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandRinging3(v);
            } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandRinging4(v);
            } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandRinging5(v);
            } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
                playHandRinging6(v);
            }

            //playStickRinging(v);    // AUDIO PLAYBACK

            return super.onSingleTapConfirmed(e);
        }
    }

    /*-------------------------------------------------------------------------------------------*/


    /*--------------------------------- AUDIO PLAYBACK ------------------------------------------*/

    // The following section of code manages audio playback.

    //
    public void playStickRinging1 (View v){
        if (player_gangsa1_stick_r == null) {
            player_gangsa1_stick_r = MediaPlayer.create(this, R.raw.gsr1_synth);
        }

        player_gangsa1_stick_r.start();
    }

    public void playStickRinging2 (View v){
        if (player_gangsa2_stick_r == null) {
            player_gangsa2_stick_r = MediaPlayer.create(this, R.raw.gsr2_synth);
        }

        player_gangsa2_stick_r.start();
    }

    public void playStickRinging3 (View v){
        if (player_gangsa3_stick_r == null) {
            player_gangsa3_stick_r = MediaPlayer.create(this, R.raw.gsr3_synth);
        }

        player_gangsa3_stick_r.start();
    }

    public void playStickRinging4 (View v){
        if (player_gangsa4_stick_r == null) {
            player_gangsa4_stick_r = MediaPlayer.create(this, R.raw.gsr4_synth);
        }

        player_gangsa4_stick_r.start();
    }

    public void playStickRinging5 (View v){
        if (player_gangsa5_stick_r == null) {
            player_gangsa5_stick_r = MediaPlayer.create(this, R.raw.gsr5_synth);
        }

        player_gangsa5_stick_r.start();
    }

    public void playStickRinging6 (View v){
        if (player_gangsa6_stick_r == null) {
            player_gangsa6_stick_r = MediaPlayer.create(this, R.raw.gsr6_synth);
        }

        player_gangsa6_stick_r.start();
    }

    public void playHandRinging1 (View v){
        if (player_gangsa1_hand_r == null) {
            player_gangsa1_hand_r = MediaPlayer.create(this, R.raw.ghr1_synth);
        }

        player_gangsa1_hand_r.start();
    }

    public void playHandRinging2 (View v){
        if (player_gangsa2_hand_r == null) {
            player_gangsa2_hand_r = MediaPlayer.create(this, R.raw.ghr2_synth);
        }

        player_gangsa2_hand_r.start();
    }

    public void playHandRinging3 (View v){
        if (player_gangsa3_hand_r == null) {
            player_gangsa3_hand_r = MediaPlayer.create(this, R.raw.ghr3_synth);
        }

        player_gangsa3_hand_r.start();
    }

    public void playHandRinging4 (View v){
        if (player_gangsa4_hand_r == null) {
            player_gangsa4_hand_r = MediaPlayer.create(this, R.raw.ghr4_synth);
        }

        player_gangsa4_hand_r.start();
    }

    public void playHandRinging5 (View v){
        if (player_gangsa5_hand_r == null) {
            player_gangsa5_hand_r = MediaPlayer.create(this, R.raw.ghr5_synth);
        }

        player_gangsa5_hand_r.start();
    }

    public void playHandRinging6 (View v){
        if (player_gangsa6_hand_r == null) {
            player_gangsa6_hand_r= MediaPlayer.create(this, R.raw.ghr6_synth);
        }

        player_gangsa6_hand_r.start();
    }

    //

    public void playStickDamping1 (View v){
        if (player_gangsa1_stick_d == null) {
            player_gangsa1_stick_d = MediaPlayer.create(this, R.raw.gsd1_synth);
        }

        player_gangsa1_stick_d.start();
    }

    public void playStickDamping2 (View v){
        if (player_gangsa2_stick_d == null) {
            player_gangsa2_stick_d = MediaPlayer.create(this, R.raw.gsd2_synth);
        }

        player_gangsa2_stick_d.start();
    }

    public void playStickDamping3 (View v){
        if (player_gangsa3_stick_d == null) {
            player_gangsa3_stick_d = MediaPlayer.create(this, R.raw.gsd3_synth);
        }

        player_gangsa3_stick_d.start();
    }

    public void playStickDamping4 (View v){
        if (player_gangsa4_stick_d == null) {
            player_gangsa4_stick_d = MediaPlayer.create(this, R.raw.gsd4_synth);
        }

        player_gangsa4_stick_d.start();
    }

    public void playStickDamping5 (View v){
        if (player_gangsa5_stick_d == null) {
            player_gangsa5_stick_d = MediaPlayer.create(this, R.raw.gsd5_synth);
        }

        player_gangsa5_stick_d.start();
    }

    public void playStickDamping6 (View v){
        if (player_gangsa6_stick_d == null) {
            player_gangsa6_stick_d = MediaPlayer.create(this, R.raw.gsd6_synth);
        }

        player_gangsa6_stick_d.start();
    }

    public void playHandDamping1 (View v){
        if (player_gangsa1_hand_d == null) {
            player_gangsa1_hand_d = MediaPlayer.create(this, R.raw.ghd1_synth);
        }

        player_gangsa1_hand_d.start();
    }

    public void playHandDamping2 (View v){
        if (player_gangsa2_hand_d == null) {
            player_gangsa2_hand_d = MediaPlayer.create(this, R.raw.ghd2_synth);
        }

        player_gangsa2_hand_d.start();
    }

    public void playHandDamping3 (View v){
        if (player_gangsa3_hand_d == null) {
            player_gangsa3_hand_d = MediaPlayer.create(this, R.raw.ghd3_synth);
        }

        player_gangsa3_hand_d.start();
    }

    public void playHandDamping4 (View v){
        if (player_gangsa4_hand_d == null) {
            player_gangsa4_hand_d = MediaPlayer.create(this, R.raw.ghd4_synth);
        }

        player_gangsa4_hand_d.start();
    }

    public void playHandDamping5 (View v){
        if (player_gangsa5_hand_d == null) {
            player_gangsa5_hand_d = MediaPlayer.create(this, R.raw.ghd5_synth);
        }

        player_gangsa5_hand_d.start();
    }

    public void playHandDamping6 (View v){
        if (player_gangsa6_hand_d == null) {
            player_gangsa6_hand_d= MediaPlayer.create(this, R.raw.ghd6_synth);
        }

        player_gangsa6_hand_d.start();
    }

    //

    public void playHandSliding1 (View v){
        if (player_gangsa1_hand_s == null) {
            player_gangsa1_hand_s = MediaPlayer.create(this, R.raw.ghs1_synth);
        }

        player_gangsa1_hand_s.start();
    }

    public void playHandSliding2 (View v){
        if (player_gangsa2_hand_s == null) {
            player_gangsa2_hand_s = MediaPlayer.create(this, R.raw.ghs2_synth);
        }

        player_gangsa2_hand_s.start();
    }
    public void playHandSliding3 (View v){
        if (player_gangsa3_hand_s == null) {
            player_gangsa3_hand_s = MediaPlayer.create(this, R.raw.ghs3_synth);
        }

        player_gangsa3_hand_s.start();
    }
    public void playHandSliding4 (View v){
        if (player_gangsa4_hand_s == null) {
            player_gangsa4_hand_s = MediaPlayer.create(this, R.raw.ghs4_synth);
        }

        player_gangsa4_hand_s.start();
    }
    public void playHandSliding5 (View v){
        if (player_gangsa5_hand_s == null) {
            player_gangsa5_hand_s = MediaPlayer.create(this, R.raw.ghs5_synth);
        }

        player_gangsa5_hand_s.start();
    }
    public void playHandSliding6 (View v){
        if (player_gangsa6_hand_s == null) {
            player_gangsa6_hand_s = MediaPlayer.create(this, R.raw.ghs6_synth);
        }

        player_gangsa6_hand_s.start();
    }
}
