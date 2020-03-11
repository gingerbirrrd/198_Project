package com.example.a198_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class manages the About page.
 */

public class activity_about extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // clicking the CLOSE button takes you to the MAIN page
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMain();
            }
        });
    }

    public void openMain(){
        Intent intent = new Intent(activity_about.this, MainActivity.class);
        startActivity(intent);
    }
}
