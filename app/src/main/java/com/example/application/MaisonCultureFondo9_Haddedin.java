package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MaisonCultureFondo9_Haddedin extends AppCompatActivity {
private TextView txt6,textView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maison_culture_fondo9__haddedin);
        txt6 = (TextView) findViewById(R.id.txt6);
        textView9=(TextView)findViewById(R.id.textView9);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/FHSfax'> https://www.facebook.com/FHSfax </a>";
        textView9.setText(Html.fromHtml(text));
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCultureFondo9_Haddedin.this, ClubsFondokHaddedin.class);
                startActivity(i);
            }
        });

    }
}
