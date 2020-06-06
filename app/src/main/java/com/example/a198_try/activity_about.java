package com.example.a198_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * This class manages the About page.
 */

public class activity_about extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SET APP TO FULL SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_about);

        // CLICKING THE CLOSE BUTTON TAKES THE USER TO THE MAIN PAGE
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMain();
            }
        });
    }

    // GO TO THE MAIN PAGE
    public void openMain(){
        Intent intent = new Intent(activity_about.this, MainActivity.class);
        startActivity(intent);
    }
}
