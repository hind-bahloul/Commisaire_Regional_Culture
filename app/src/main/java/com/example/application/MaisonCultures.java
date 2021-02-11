package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MaisonCultures extends AppCompatActivity {
private TextView textReg2,textReg3,textLoc1,textLoc2,textLoc22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maison_cultures);
            init();


    }

    private void init() {
        textReg2=findViewById(R.id.textReg2);
        textReg3=findViewById(R.id.textReg3);
        textLoc1=findViewById(R.id.textloc1);
        textLoc2=findViewById(R.id.textloc2);
        textLoc22=findViewById(R.id.textloc22);
        ajouterEcouteur();
    }

    private void ajouterEcouteur() {
    textReg2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Intent i = new Intent(MaisonCultures.this, MaisonCulture.class);
           // startActivity(i);

        }
    });
        textReg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCultures.this, MaisonCultureBebBhar.class);
                startActivity(i);

            }
        });
        textLoc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCultures.this, MaisonCulture.class);
                startActivity(i);

            }
        });
        textLoc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCultures.this, MaisonCultureGhraiba.class);
                startActivity(i);

            }
        });
        textLoc22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MaisonCultures.this, MaisonCultureFondo9_Haddedin.class);
                startActivity(i);

            }
        });
}
}