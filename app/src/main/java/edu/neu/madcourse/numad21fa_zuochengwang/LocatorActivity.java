package edu.neu.madcourse.numad21fa_zuochengwang;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.security.acl.Permission;
import java.util.List;

public class LocatorActivity extends AppCompatActivity implements LocationListener {

    TextView latitude_view;
    TextView longitude_view;

    public double current_latitude;
    public double current_longitude;

    LocationManager location_manager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);

        latitude_view = findViewById(R.id.latitude);
        longitude_view = findViewById(R.id.longitude);
        location_manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        boolean permission_approval;
        permission_approval = ActivityCompat.checkSelfPermission(LocatorActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
        == PackageManager.PERMISSION_GRANTED;

        String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION};


        if (permission_approval != true) {
            ActivityCompat.requestPermissions(LocatorActivity.this, permission, 1);
        }
        
        location_manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);
    }

    protected void onDestroy(Bundle savedInstanceState)
    {
        super.onDestroy();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        current_latitude = location.getLatitude();
        current_longitude = location.getLongitude();
        latitude_view.setText(String.valueOf(current_latitude).substring(0,8));
        longitude_view.setText(String.valueOf(current_longitude).substring(0,8));

        Toast.makeText(LocatorActivity.this, "Location is updated", Toast.LENGTH_LONG).show();

        location_manager.removeUpdates(this);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        Toast.makeText(LocatorActivity.this, "GPS Provider is enabled", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toast.makeText(LocatorActivity.this, "GPS Provider is disabled", Toast.LENGTH_LONG).show();
    }

}
