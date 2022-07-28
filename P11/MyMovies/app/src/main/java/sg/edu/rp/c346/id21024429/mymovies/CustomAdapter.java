package sg.edu.rp.c346.id21024429.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        ImageView ivPG = rowView.findViewById(R.id.imageView);

        Movie currentMovie = movieList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvGenre.setText(currentMovie.getGenre());
        tvYear.setText(String.valueOf(currentMovie.getYear()));
        if (currentMovie.getRating().equalsIgnoreCase("G")) {
            ivPG.setImageResource(R.drawable.rating_g);
        } else if (currentMovie.getRating().equalsIgnoreCase("PG")) {
            ivPG.setImageResource(R.drawable.rating_pg);
        } else if (currentMovie.getRating().equalsIgnoreCase("PG13")) {
            ivPG.setImageResource(R.drawable.rating_pg13);
        } else if (currentMovie.getRating().equalsIgnoreCase("NC16")) {
            ivPG.setImageResource(R.drawable.rating_nc16);
        } else if (currentMovie.getRating().equalsIgnoreCase("M18")) {
            ivPG.setImageResource(R.drawable.rating_m18);
        } else {
            ivPG.setImageResource(R.drawable.rating_r21);
        }
        return rowView;
    }
}
