package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Associations extends AppCompatActivity {
private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        img8=findViewById(R.id.img8);
        img9=findViewById(R.id.img9);
        ajouterEcouteur();
    }
    private void ajouterEcouteur() {
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, Association_Volunteer.class);
                startActivity(i);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, ettawasel.class);
                startActivity(i);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, radros.class);
                startActivity(i);

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, association_khebra.class);
                startActivity(i);

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, association_tourisme.class);
                startActivity(i);

            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, Association_Environment.class);
                startActivity(i);

            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, Association_Cooperation.class);
                startActivity(i);

            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, Association_Positive.class);
                startActivity(i);

            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Associations.this, Association_dev_durable.class);
                startActivity(i);

            }
        });
    }
}
