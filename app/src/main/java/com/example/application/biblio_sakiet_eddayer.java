package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class biblio_sakiet_eddayer extends AppCompatActivity {
    private TextView textView9;
    private Handler sliderHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblio_sakiet_eddayer);
        textView9=(TextView)findViewById(R.id.textView9);
        textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/Biblioth%C3%A8que-publique-de-Sakiet-Eddaer-790488027632819'> https://www.facebook.com/Biblioth%C3%A8que-publique-de-Sakiet-Eddaer-790488027632819</a>";
        textView9.setText(Html.fromHtml(text));
    }
}
