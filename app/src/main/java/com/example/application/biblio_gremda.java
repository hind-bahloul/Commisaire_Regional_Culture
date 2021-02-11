package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class biblio_gremda extends AppCompatActivity  {
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private int i;
    private LocationManager mg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblio_gremda);

    }

    /*@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng tunisie = new LatLng(34.76701627266555, 10.735951376647728);
        mMap.addMarker(new MarkerOptions().position(tunisie).title("المندوبية الجهوية للثقافة بصفاقس"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tunisie,18),6000,null);
        i = 0;
        init();
    }
    private void init() {
        mg = (LocationManager) getSystemService(LOCATION_SERVICE);

        ajouterEcouteur();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Location l = mg.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (l != null)
            afficher(l);
    }

    @SuppressLint("MissingPermission")

    private void ajouterEcouteur() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

    }
    private void afficher(Location arg0) {
        Toast t = Toast.makeText(biblio_gremda.this, "lat" + arg0.getLatitude(), Toast.LENGTH_LONG);
        t.show();
        Toast k = Toast.makeText(biblio_gremda.this, "long" + arg0.getLongitude(), Toast.LENGTH_LONG);
        k.show();


    }
*/
}
