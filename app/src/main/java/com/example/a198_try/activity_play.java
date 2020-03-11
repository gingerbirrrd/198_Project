package com.example.a198_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This class manages the Playing page.
 */

public class activity_play extends AppCompatActivity {

    ImageButton button;
    Spinner spinner;
    MediaPlayer player;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final String str[] = {
                "Gangsa 1 using Hand", "Gangsa 1 using Stick",
                "Gangsa 2 using Hand", "Gangsa 2 using Stick",
                "Gangsa 3 using Hand", "Gangsa 3 using Stick",
                "Gangsa 4 using Hand", "Gangsa 4 using Stick",
                "Gangsa 5 using Hand", "Gangsa 5 using Stick",
                "Gangsa 6 using Hand", "Gangsa 6 using Stick"};

        spinner = findViewById(R.id.spinner1);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.options)
        );
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);
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



        button = findViewById(R.id.button_gangsa);
        button.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {

                playHandSliding(v);

                Toast.makeText(getApplicationContext(), "Swiped", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {

                playHandSliding(v);

                Toast.makeText(getApplicationContext(), "Swiped", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {

                playHandSliding(v);

                Toast.makeText(getApplicationContext(), "Swiped", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {

                playHandSliding(v);

               Toast.makeText(getApplicationContext(), "Swiped", Toast.LENGTH_SHORT).show();
            }

        });
    }

    class OnSwipeTouchListener implements View.OnTouchListener {

        private final GestureDetector gestureDetector;

        public OnSwipeTouchListener(Context ctx) {
            gestureDetector = new GestureDetector(ctx, new GestureListener());
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

            private static final int SWIPE_THRESHOLD = 300;
            private static final int SWIPE_VELOCITY_THRESHOLD = 300;

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {

                playStickRinging(v);

                Log.i("TAG", "onSingleTapConfirmed:");
                Toast.makeText(getApplicationContext(), "Single Tap Detected", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {

                playStickDamping(v);

                Log.i("TAG", "onLongPress:");
                Toast.makeText(getApplicationContext(), "Long Press Detected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                boolean result = false;
                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX > 0) {
                                onSwipeRight();
                            } else {
                                onSwipeLeft();
                            }
                            result = true;
                        }
                    } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeBottom();
                        } else {
                            onSwipeTop();
                        }
                        result = true;
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return result;
            }

        }



        public void onSwipeRight() {
        }

        public void onSwipeLeft() {
        }

        public void onSwipeTop() {
        }

        public void onSwipeBottom() {
        }
    }

    public void playStickRinging(View v){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.gsr1_synth);
        }

        player.start();
    }

    public void playStickDamping(View v){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.gsd1_synth);
        }

        player.start();
    }

    public void playHandSliding(View v){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.ghd1_synth);
        }

        player.start();
    }

}
