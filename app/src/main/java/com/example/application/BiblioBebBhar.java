package com.example.application;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class BiblioBebBhar extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private ViewPager2 viewPager3;
    private TextView textView9;
    private Handler sliderHandler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblio_beb_bhar);
        textView9=(TextView)findViewById(R.id.textView9);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.facebook.com/المكتبة-الجهوية-بصفاقس-638805129527718'> http://www.facebook.com/المكتبة-الجهوية-بصفاقس-638805129527718 </a>";
        textView9.setText(Html.fromHtml(text));




    }}

