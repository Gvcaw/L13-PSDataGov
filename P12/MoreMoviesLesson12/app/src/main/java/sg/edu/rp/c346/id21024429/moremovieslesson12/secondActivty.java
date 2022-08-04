package sg.edu.rp.c346.id21024429.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class secondActivty extends AppCompatActivity {

    ListView lv;
    Button btnPG;
    CustomAdapter ca;
    ArrayList<Movie> al,alAfter;
    ArrayAdapter<Movie> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activty);

        lv = findViewById(R.id.lv);
        btnPG = findViewById(R.id.btnPG);

        al = new ArrayList<Movie>();
        alAfter = new ArrayList<Movie>();
        aa = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, al);

        DBHelper dbh =new DBHelper(secondActivty.this);
        al.addAll(dbh.getAllMovies());
        lv.setAdapter(aa);
        ca = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(ca);

        btnPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                al.clear();
                al.addAll(dbh.getAllMovies());
                for (int i = 0; i < al.size(); i++) {
                    if (!al.get(i).getRating().equalsIgnoreCase("PG13")) {
                        alAfter.add(al.get(i));
                    }
                }
                al.removeAll(alAfter);

                aa.notifyDataSetChanged();
                ca.notifyDataSetChanged();


            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(secondActivty.this, thirdActivity.class);
                i.putExtra("Movie", al.get(position));
                startActivity(i);
            }
        });



    }
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(secondActivty.this);
        al.clear();
        al.addAll(dbh.getAllMovies());
        ca.notifyDataSetChanged();


    }
}