package sg.edu.rp.c346.id21024429.demotodolisr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ToDoItem> {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> ItemList;

    public CustomAdapter(Context context, int resource,  ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        ItemList = objects;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewTop);
        TextView tvVersion = rowView.findViewById(R.id.textViewBottom);

        // Obtain the Android Version information based on the position
        ToDoItem currentPlace = ItemList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentPlace.getTitle());
        tvVersion.setText(currentPlace.toString());

        return rowView;
    }




}
