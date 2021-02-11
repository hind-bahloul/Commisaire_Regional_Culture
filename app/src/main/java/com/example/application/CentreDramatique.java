package com.example.application;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CentreDramatique extends AppCompatActivity {
    private ViewPager2 viewPager2;
private TextView textView16;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_dramatique);

        textView16=(TextView)findViewById(R.id.textView16);
        //textView9.setLinksClickable(true);
        textView16.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/CAD.Sfax'> https://www.facebook.com/CAD.Sfax </a>";
        textView16.setText(Html.fromHtml(text));
        viewPager2 = findViewById(R.id.viewPagerSlider2);

        List<SliderItem1> sliderItems1 = new ArrayList<>();


        sliderItems1.add(new SliderItem1(R.mipmap.art1));
        sliderItems1.add(new SliderItem1(R.mipmap.art2));
        sliderItems1.add(new SliderItem1(R.mipmap.art3));
        sliderItems1.add(new SliderItem1(R.mipmap.art4));
        sliderItems1.add(new SliderItem1(R.mipmap.art5));
        viewPager2.setAdapter(new SliderَAdapterCentreDramatique(sliderItems1, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        //Slider 2
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
    }
        private Runnable sliderRunnable = new Runnable() {
            @Override
            public void run() {

                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

            }
        };

        @Override
        protected void onPause () {
            super.onPause();
            sliderHandler.removeCallbacks(sliderRunnable);

        }

        @Override
        protected void onResume () {
            super.onResume();
            sliderHandler.postDelayed(sliderRunnable, 3000);

        }
    }
