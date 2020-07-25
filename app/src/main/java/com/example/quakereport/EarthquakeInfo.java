package com.example.quakereport;

public class EarthquakeInfo {
    private String mLocation,mUrl;
    private double mMagntitude;
    private long mTimeInMilliseconds;

    public EarthquakeInfo(String location, double magntitude, long timeInMilliseconds, String url) {
        mLocation = location;
        mMagntitude = magntitude;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl=url;
    }

    public String getLocation() {
        return mLocation;
    }

    public double getMagntitude() {
        return mMagntitude;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return mUrl;
    }
}
