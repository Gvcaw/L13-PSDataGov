package sg.edu.rp.c346.id21024429.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class listViewActivity extends AppCompatActivity {
    Button btnFive;
    ListView lv;
    ArrayList<Song> al,als;
    ArrayAdapter<Song> aa,aas;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        btnFive = findViewById(R.id.btnFive);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);

        als = new ArrayList<Song>();
        aas = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, als);



        Intent i = getIntent();
        al = (ArrayList<Song>) i.getSerializableExtra("ArrayList");

        lv.setAdapter(aa);
        adapter = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(adapter);

        btnFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                for (int i = 0; i < al.size(); i++){
                    if(al.get(i).getStars() != 5){
                        als.add(al.get(i));
                    }
                }

                DBHelper dbs = new DBHelper(listViewActivity.this);
                al = (ArrayList<Song>)als.clone();
                al.addAll(dbs.getAllSongs());
                lv.setAdapter(aa);
                aa.notifyDataSetChanged();


            }

        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long identity) {

                Song data = al.get(position);
                Intent i = new Intent(listViewActivity.this,
                        editActivity.class);
                i.putExtra("data", data);
                startActivity(i);

            }

        });




    }


}