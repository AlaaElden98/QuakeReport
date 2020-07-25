package com.example.quakereport;

public class EarthquakeInfo {
    private String mLocation;
    private double mMagntitude;
    private long mTimeInMilliseconds;

    public EarthquakeInfo(String location, double magntitude, long timeInMilliseconds) {
        mLocation = location;
        mMagntitude = magntitude;
        mTimeInMilliseconds = timeInMilliseconds;
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

}
