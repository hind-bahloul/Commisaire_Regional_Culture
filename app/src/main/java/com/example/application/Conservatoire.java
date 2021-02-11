package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class Conservatoire extends AppCompatActivity {
    private TextView textView9;
    private TextView txt4;
    private EditText edtPhone;
private ImageView imageView5;
private static final int REQUEST_CALL=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conservatoire);
        textView9 = (TextView) findViewById(R.id.textView9);
        txt4 = (TextView) findViewById(R.id.txt4);
        imageView5=(ImageView)findViewById(R.id.imageView5);
        //textView9.setLinksClickable(true);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.facebook.com/Conservatoire-Public-de-Musique-et-de-Dance-de-sfax-1772529906331449/about'>https://www.facebook.com/Conservatoire-Public-de-Musique-et-de-Dance-de-sfax-1772529906331449/about  </a>";
        textView9.setText(Html.fromHtml(text));

     /*   imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=edtPhone.getText().toString();
                if (number.trim().length()>0)
                {
if (ContextCompat.checkSelfPermission(Conservatoire.this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
{
ActivityCompat.requestPermissions(Conservatoire.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
}
else
{
    String dial="tel" + number;
    startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
}
                }
                else
                {
                    Toast.makeText(Conservatoire.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
                }
            }

        });
*/
    }
}
