package com.laioffer.matrix;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;

public class LocationTracker {

    private final Activity mContext;
    private static final int PERMISSIONS_REQUEST_LOCATION = 99;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60;

    private boolean mIsGPSEnabled;
    private boolean mIsNetworkEnabled;

    private Location location;
    private double latitude;
    private double longitude;
    private LocationManager locationManager;


    public LocationTracker(Activity context) {
        this.mContext = context;
    }
}
