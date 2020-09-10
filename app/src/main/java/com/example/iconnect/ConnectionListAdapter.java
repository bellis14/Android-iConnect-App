package com.example.iconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Date;

/*************************************************************
 * Class: Connection List Adapter
 * Function: Format the information correctly in all list views used
 *************************************************************/
public class ConnectionListAdapter extends ArrayAdapter<Connection> {

    private static final String TAG = "ConnectionListAdapter";
    private Context mContext;
    private int mResource;

    public ConnectionListAdapter(Context context, int resource, ArrayList<Connection> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Get the days to count down correctly
        Date date = new Date();
        int difference = Integer.parseInt(getItem(position).getFrequency()) - (int) ((date.getTime() / 86400000) - Long.parseLong(getItem(position).getSetCount()));

        // Get the information from the connection item
        String name = getItem(position).getName();
        String frequency = Integer.toString(difference);
        String subtitle = getItem(position).getSubtitle();

        //Create the connection object with the information
        Connection connection = new Connection(name);
        connection.setFrequency(frequency);
        connection.setSubtitle(subtitle);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvFrequency = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvSubtitle = (TextView) convertView.findViewById(R.id.textView3);


        // Format the information correctly
        tvName.setText(name);
        tvSubtitle.setText(subtitle);
        if (getItem(position).getFrequency().equals("0")) {
            tvFrequency.setText("");
        }
        else if (connection.getFrequency().equals("1")) {
            tvFrequency.setText(frequency + " day");
        }
        else if (difference <= 0) {
            tvFrequency.setText("Today");
        }
        else {
            tvFrequency.setText(frequency + " days");
        }
        return convertView;
    }
}

