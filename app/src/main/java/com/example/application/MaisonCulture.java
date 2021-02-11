package com.example.application;

import android.content.Intent;
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

public class MaisonCulture extends AppCompatActivity {
        private TextView txt6,textView9;
    private TextView txtEv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maison_culture);
        txt6=(TextView)findViewById(R.id.txt6);
        textView9=(TextView)findViewById(R.id.textView9);
        txtEv=(TextView)findViewById(R.id.txtEv);
        textView9=(TextView)findViewById(R.id.textView9);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.facebook.com/دار-الثقافة-ساقية-الدائر-صفاقس-908207952683908'> http://www.facebook.com/دار-الثقافة-ساقية-الدائر-صفاقس-908207952683908 </a>";
        textView9.setText(Html.fromHtml(text));

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCulture.this, ClubsSakietEddayer.class);
                startActivity(i);
            }
        });
        txtEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCulture.this, Evenements.class);
                startActivity(i);
            }
        });
    }
}
