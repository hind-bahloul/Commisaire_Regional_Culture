package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Association_dev_durable extends AppCompatActivity {
    private TextView textView9;
    private Handler sliderHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_dev_durable);
        textView9=(TextView)findViewById(R.id.textView16);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/JmytAlmlAlajtmayLltnmytAlmstdamtSfaqs'> https://www.facebook.com/JmytAlmlAlajtmayLltnmytAlmstdamtSfaqs</a>";
        textView9.setText(Html.fromHtml(text));
    }
}
