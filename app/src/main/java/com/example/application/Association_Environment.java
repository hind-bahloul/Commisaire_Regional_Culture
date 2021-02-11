package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Association_Environment extends AppCompatActivity {
    private TextView textView9;
    private Handler sliderHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association__environment);
        textView9=(TextView)findViewById(R.id.textView16);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/%D8%AC%D9%85%D8%B9%D9%8A%D8%A9-%D8%AD%D9%85%D8%A7%D9%8A%D8%A9-%D8%A7%D9%84%D8%A8%D9%8A%D8%A6%D8%A9-%D9%88%D8%A7%D9%84%D8%B7%D8%A8%D9%8A%D8%B9%D8%A9-830079227071997'> https://www.facebook.com/%D8%AC%D9%85%D8%B9%D9%8A%D8%A9-%D8%AD%D9%85%D8%A7%D9%8A%D8%A9-%D8%A7%D9%84%D8%A8%D9%8A%D8%A6%D8%A9-%D9%88%D8%A7%D9%84%D8%B7%D8%A8%D9%8A%D8%B9%D8%A9-830079227071997</a>";
        textView9.setText(Html.fromHtml(text));
    }
}
