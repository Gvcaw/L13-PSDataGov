package sg.edu.rp.c346.id21024429.myndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Song> {

    Context parent_context;
    int layout_id;
    ArrayList<Song> SongList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        SongList = objects;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        ListView lv = rowView.findViewById(R.id.lv);
        TextView textViewTitle = rowView.findViewById(R.id.textViewTittle);
        TextView textViewYear= rowView.findViewById(R.id.textViewYEars);
        TextView textViewSinger = rowView.findViewById(R.id.textViewSINGERS);
        TextView textViewStar = rowView.findViewById(R.id.textViewSTARS);


        // Obtain the Android Version information based on the position
        String title = SongList.get(position).getTitle();
        int year = SongList.get(position).getYear();
        String singers = SongList.get(position).getSingers();
        int stars = SongList.get(position).getStars();

        // Set values to the TextView to display the corresponding information
        //not sure how to do the stars

        textViewSinger.setText(singers);
        textViewStar.setText(stars);
        textViewTitle.setText(title);
        textViewYear.setText(year);

        return rowView;
    }
}
