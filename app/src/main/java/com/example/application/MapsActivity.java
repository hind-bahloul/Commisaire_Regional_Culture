package com.example.application;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.firebase.database.DatabaseReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private int i;
    private LocationManager mg;
    private LatLng l1, l2;
    Marker marker = null;
    private GoogleMap mMap;
    private SearchView searchView;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        searchView=findViewById(R.id.sv_location);
        mapFragment=(SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.map);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String location=searchView.getQuery().toString();
                List<Address>addressList=null;
                if(location!=null || !location.equals(""))
                {
                    Geocoder geocoder=new Geocoder(MapsActivity.this);
                    try{
                        addressList=geocoder.getFromLocationName(location,1);

                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    Address address=addressList.get(0);
                    LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                }

                return false;
            }

            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng tunisie = new LatLng(34.734353, 10.764184);
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
        Toast t = Toast.makeText(MapsActivity.this, "lat" + arg0.getLatitude(), Toast.LENGTH_LONG);
        t.show();
        Toast k = Toast.makeText(MapsActivity.this, "long" + arg0.getLongitude(), Toast.LENGTH_LONG);
        k.show();


    }
}