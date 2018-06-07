package com.Company.avion;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineListener;
import com.mapbox.android.core.location.LocationEnginePriority;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerPlugin;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.unity3d.player.UnityPlayerActivity;
import com.unity3d.player.UnityPlayerNativeActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Geolocalizacion_MapBox extends Activity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1Ijoiam9zZXBocm9zZXJvIiwiYSI6ImNqaTNzMGpmYTAwYngzd3M0NHV4eG9ldzkifQ.fLPhy4GUO_4yd5THLA7CMQ");
        setContentView(R.layout.activity_geolocalizacion__map_box);
        mapView = (MapView) findViewById(R.id.mapView);


      mapView.onCreate(savedInstanceState);


controlador();

    }

    public void controlador() {
        Button button = (Button)findViewById(R.id.bnt);
//hago clic y se abre el 2
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Toast.makeText(Geolocalizacion_MapBox.this, "Bienvenido",Toast.LENGTH_LONG).show();

             Intent ListSong = new Intent(Geolocalizacion_MapBox.this, com.Company.avion.UnityPlayerActivity.class);
               startActivity(ListSong);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
       // if (locationEngine != null) {
         //   locationEngine.requestLocationUpdates();
        //}
       // if (locationPlugin != null) {
       //     locationPlugin.onStart();
       // }
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //if (locationEngine != null) {
        //    locationEngine.removeLocationUpdates();
       // }
       // if (locationPlugin != null) {
       //     locationPlugin.onStop();
      //  }
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        //if (locationEngine != null) {
        //    locationEngine.deactivate();
       // }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }



}
