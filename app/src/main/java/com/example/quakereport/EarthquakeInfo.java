package com.example.quakereport;

public class EarthquakeInfo {
    private String mLocation;
    private String mMagntitude;
    private long mTimeInMilliseconds;

    public EarthquakeInfo(String location, String magntitude, long timeInMilliseconds) {
        mLocation = location;
        mMagntitude = magntitude;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getMagntitude() {
        return mMagntitude;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
