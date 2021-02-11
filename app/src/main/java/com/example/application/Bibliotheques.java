package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bibliotheques extends AppCompatActivity {
    private TextView textReg2,textloc11,textloc1,textLoc2,text1,textloc2,textloc3,textloc4,textloc5,textloc6,textloc12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliotheques);
        init();


    }

    private void init() {
        textReg2=findViewById(R.id.textReg2);
        textloc1=findViewById(R.id.textloc1);
        text1=findViewById(R.id.text1);
        textloc2=findViewById(R.id.textloc2);
        textloc3=findViewById(R.id.textloc3);
        textloc4=findViewById(R.id.textloc4);
        textloc5=findViewById(R.id.textloc5);
        textloc6=findViewById(R.id.textloc6);

        textloc11=findViewById(R.id.textloc11);

        textloc12=findViewById(R.id.textloc12);






        ajouterEcouteur();
    }

    private void ajouterEcouteur() {
        textReg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Bibliotheques.this, BiblioBebBhar.class);
                startActivity(i);
            }
        });

        textloc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_sakiet_eddayer.class);
                startActivity(i);

            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_mahres.class);
                startActivity(i);

            }
        });


        textloc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_sakiet_ezzite.class);
                startActivity(i);

            }
        });

        textloc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_sfax_jardin.class);
                startActivity(i);

            }
        });

        textloc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_skhira.class);
                startActivity(i);

            }
        });

        textloc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_agerib.class);
                startActivity(i);

            }
        });



        textloc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, biblio_gremda.class);
                startActivity(i);

            }
        });

        textloc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, BiblioMobile.class);
                startActivity(i);

            }
        });

        textloc12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bibliotheques.this, BiblioMobileKerkeneh.class);
                startActivity(i);

            }
        });
    }
}
