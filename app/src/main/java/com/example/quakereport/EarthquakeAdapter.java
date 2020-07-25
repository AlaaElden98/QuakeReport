package com.example.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeInfo> {

    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeInfo> earthquakeInfos) {
        super(context, 0, earthquakeInfos);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        EarthquakeInfo currentEarthquakeInfo = getItem(position);

        Date dateObject = new Date(currentEarthquakeInfo.getTimeInMilliseconds());

        //set the text for Magntitude
        TextView magntitudeTextView = (TextView) listItemView.findViewById(R.id.magntitude);
        magntitudeTextView.setText(currentEarthquakeInfo.getMagntitude());
        //Set the Text for Location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(currentEarthquakeInfo.getLocation());

        //Set the text for date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String formattedDate= dateFormat.format(dateObject);
        dateTextView.setText(formattedDate);
        //Set the text for time
        TextView timeTextView = listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime= timeFormat.format(dateObject);
        timeTextView.setText(formattedTime);

        return listItemView;
    }
}
