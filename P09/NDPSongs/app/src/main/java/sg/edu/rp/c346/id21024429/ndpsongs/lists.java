package sg.edu.rp.c346.id21024429.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class lists extends AppCompatActivity {

    Button btnFive;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<Song> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        btnFive = findViewById(R.id.btnFive);
        lv = findViewById(R.id.lv);
        al = new ArrayList<>();
        aa = new ArrayAdapter(lists.this, android.R.layout.simple_expandable_list_item_1, al);
        lv.setAdapter(aa);

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbs = new DBHelper(lists.this);


                al.clear();
                al.addAll(dbs.getAllSongs());
                aa.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(lists.this,
                        edit.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
}