package com.example.application;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.VideoView;

/*import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;*/

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.database.DatabaseReference;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,LocationListener{
    private NavigationView navigationView;
    private AppBarConfiguration mAppBarConfiguration;
    private  DrawerLayout drawer;
    private int i;
    private LocationManager mg;
    private LatLng l1, l2;
    private LocationListener locationListener;
    Marker marker = null;
    private GoogleMap mMap;
    private ViewPager2 viewPager2;
    private Handler sliderHandler =new Handler();
    private SearchView searchView;
    private  LocationManager locationManager;
    private VideoView videoView;
    //private MapView myOpenMapView;
    SupportMapFragment mapFragment;


    @SuppressLint("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
videoView=(VideoView)findViewById(R.id.videoView);
String videoPath="android.resource://" + getPackageName()+ "/" + R.raw.video1;
Uri uri=Uri.parse(videoPath);
videoView.setVideoURI(uri);
videoView.start();

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


LocationManager locationManager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        NavigationView navigationView = findViewById(R.id.nav_view);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_one,R.id.nav_two,R.id.nav_three,R.id.nav_four,R.id.nav_five,R.id.nav_six,R.id.nav_sept,R.id.nav_huit)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id) {
                    case R.id.nav_one:
                        //Toast.makeText(MainActivity.this,"navOne",Toast.LENGTH_LONG).show();
                        MaisonCulture();
                        return true;
                    case R.id.nav_two:
                        //Toast.makeText(MainActivity.this,"navTwo",Toast.LENGTH_LONG).show();
                        Bibliotheque();
                        return true;
                    case R.id.nav_three:
                       // Toast.makeText(MainActivity.this,"navThree",Toast.LENGTH_LONG).show();
                        evenementsCulturels();
                        return true;
                    case R.id.nav_four:
                       // Toast.makeText(MainActivity.this,"navFour",Toast.LENGTH_LONG).show();
                        Evenements();
                        return true;
                    case R.id.nav_five:
                        //Toast.makeText(MainActivity.this,"navFive",Toast.LENGTH_LONG).show();
                        Musique();
                        return true;
                    case R.id.nav_six:
                        //Toast.makeText(MainActivity.this,"navFive",Toast.LENGTH_LONG).show();
                        Association();
                        return true;

                    case R.id.nav_sept:
                        //Toast.makeText(MainActivity.this,"navFive",Toast.LENGTH_LONG).show();
                        Festival();
                        return true;

                    case R.id.nav_huit:
                        //Toast.makeText(MainActivity.this,"navFive",Toast.LENGTH_LONG).show();
                        Image();
                        return true;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        /*viewPager2=findViewById(R.id.viewPagerSlider);
        List<SliderItem> sliderItems=new ArrayList<>();
        sliderItems.add(new SliderItem(R.mipmap.image1));
        sliderItems.add(new SliderItem(R.mipmap.image2));
        sliderItems.add(new SliderItem(R.mipmap.image3));
        sliderItems.add(new SliderItem(R.mipmap.image6));
        sliderItems.add(new SliderItem(R.mipmap.image7));
        sliderItems.add(new SliderItem(R.mipmap.image8));
        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });*/
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
                    Geocoder geocoder=new Geocoder(MainActivity.this);
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
       ActivityCompat.requestPermissions(this,  new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);

        mapFragment.getMapAsync(this);
    }


   /* private Runnable sliderRunnable =new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1 );

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
      // videoView.suspend();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable,3000);
        //videoView.start();
    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
/*
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=34.734353,10.764184");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }*/
        mg=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        LatLng tunisie = new LatLng(34.734353, 10.764184);
        mMap.addMarker(new MarkerOptions().position(tunisie).title("المندوبية الجهوية للثقافة بصفاقس"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tunisie, 18), 4000, null);
        init();
    }


    private void init() {
        mg = (LocationManager) getSystemService(LOCATION_SERVICE);

        ajouterEcouteur();


    }

    @SuppressLint("MissingPermission")

    private void ajouterEcouteur() {

        mMap.setMyLocationEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mg.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });

    }

    private void afficher(Location arg0) {
        //String res="";
        // res="latitude : \n " ;
        // tvPosition.setText(arg0.getLatitude()+"");
        Toast t = Toast.makeText(MainActivity.this, "lat" + arg0.getLatitude(), Toast.LENGTH_LONG);
        //t.show();
        Toast k = Toast.makeText(MainActivity.this, "long" + arg0.getLongitude(), Toast.LENGTH_LONG);
        //k.show();



}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return true;


    }

    private void MaisonCulture()
    {
        Intent i = new Intent(MainActivity.this, MaisonCultures.class);
        startActivity(i);

    }
    private void  Bibliotheque()
    {
        Intent i = new Intent(MainActivity.this, Bibliotheques.class);
        startActivity(i);
    }
    private void evenementsCulturels()
    {
        Intent i = new Intent(MainActivity.this, CentreDramatique.class);
        startActivity(i);
    }
    private void Evenements()
    {
    Intent i = new Intent(MainActivity.this,Evenement_culturels.class);
    startActivity(i);
}
    private void Musique(){
        Intent i = new Intent(MainActivity.this, Conservatoire.class);
        startActivity(i);

}

    private void Association()
    {
        Intent i = new Intent(MainActivity.this, Associations.class);
        startActivity(i);
    }
    private void Festival()
    {
        Intent i = new Intent(MainActivity.this, Festival.class);
        startActivity(i);
    }
    private void Image() {
        Intent i = new Intent(MainActivity.this, Gallery.class);
        startActivity(i);
    }
    LocationListener ecouteurGPS = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };
    @Override
    public void onLocationChanged(Location location) {
       // afficher(location);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
