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
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.graphics.drawable.GradientDrawable;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeInfo> {
    private static final String LOCATION_SEPARATOR = " of ";
    String primaryLocation;
    String locationOffset;

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
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String formattedMagnitude = magnitudeFormat.format(currentEarthquakeInfo.getMagntitude());
        magntitudeTextView.setText(formattedMagnitude);

        //Split the location into Primary and Off-set
        String originalLocation = currentEarthquakeInfo.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "Near The";
            primaryLocation = originalLocation;
        }


        //Set the Text for Primary Location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        locationTextView.setText(primaryLocation);

        //set text for Offset Location
        TextView offSetLocationTextView = listItemView.findViewById(R.id.offSet_location);
        offSetLocationTextView.setText(locationOffset);

        //Set the text for date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String formattedDate = dateFormat.format(dateObject);
        dateTextView.setText(formattedDate);
        //Set the text for time
        TextView timeTextView = listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(dateObject);
        timeTextView.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magntitudeTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquakeInfo.getMagntitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }
}
