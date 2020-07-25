package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthQuakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        //Create an ArrayList of EarthquakeInfo class,The Arraylist have the data from QueryUtils
        ArrayList<EarthquakeInfo>earthquakeInfos=QueryUtils.extractEarthquakes();

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this,earthquakeInfos);

       earthquakeListView.setAdapter(earthquakeAdapter);



    }
}
