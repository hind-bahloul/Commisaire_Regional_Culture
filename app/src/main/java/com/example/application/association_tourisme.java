package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class association_tourisme extends AppCompatActivity {
    private TextView textView9;
    private Handler sliderHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_tourisme);
        textView9=(TextView)findViewById(R.id.textView16);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/Association-syndicat-dinitiative-touristique-de-sfax-109800080602379'> https://www.facebook.com/Association-syndicat-dinitiative-touristique-de-sfax-109800080602379</a>";
        textView9.setText(Html.fromHtml(text));
    }
}
