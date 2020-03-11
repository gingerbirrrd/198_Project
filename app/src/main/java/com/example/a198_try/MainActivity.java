package com.example.a198_try;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.DrawerTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutTransformer;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages the Instructions page.
 */

public class MainActivity extends AppCompatActivity {
    private Button button;

    //ViewFlipper v_flipper;

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ABOUT button
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    openAbout();
            }
        });


        // SLIDESHOW
        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);
        mSlideViewPager.setPageTransformer(true, new FlipHorizontalTransformer());


        // GO button
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPlay();
            }
        });
    }


    // go to the ABOUT page
    public void openAbout(){
        Intent intent = new Intent(MainActivity.this, activity_about.class);
        startActivity(intent);
    }

    // go to the PLAY page
    public void openPlay(){
        Intent intent = new Intent(MainActivity.this, activity_play.class);
        startActivity(intent);
    }


    // slideshow dots indicator
    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(55);
            //mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            mDots[i].setTextColor(Color.parseColor("#727272"));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            //mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            mDots[position].setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

// MainActivity is the Instructions page

/**
 sources:
 viewpager: https://www.youtube.com/watch?v=byLKoPgB7yA
 spinner: https://www.youtube.com/watch?v=on_OrrX7Nw4
 play audio file: https://www.youtube.com/watch?v=C_Ka7cKwXW0
 */
