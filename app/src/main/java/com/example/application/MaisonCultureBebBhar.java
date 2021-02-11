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

public class MaisonCultureBebBhar extends AppCompatActivity {
    private TextView txt6;
    private TextView textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maison_culture_bebbhar);
        txt6 = (TextView) findViewById(R.id.txt6);


        textView9=(TextView)findViewById(R.id.textView9);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href=' https://www.facebook.com/MC.Bab.Bhar.SFAX'> https://www.facebook.com/MC.Bab.Bhar.SFAX </a>";
        textView9.setText(Html.fromHtml(text));

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCultureBebBhar.this, Club_MaisonCulture_BebBhar.class);
                startActivity(i);
            }
        });


    }
}