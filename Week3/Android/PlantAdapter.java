// Change this to your own package
package com.example.username.someappname;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/*
    Adapter to show plant objects inside listview, displaying the properties on each row.
*/
public class PlantAdapter extends ArrayAdapter {

    private List plants;

    public PlantAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        // Make scope classwide
        plants = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // A new view must be inflated
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        // Access the right object in the list
        // ...

        // Make changes to the convertView, such as displaying a certain text
        // ...

        // Return the altered convertview
        return convertView;
    }
}
