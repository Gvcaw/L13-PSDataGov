package sg.edu.rp.c346.id21024429.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnList;
    RadioGroup rdGroup;
    EditText etSongs, etSingers, etYear;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        rdGroup = findViewById(R.id.rdGroup);
        etSongs = findViewById(R.id.etSongs);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String dataSongs = etSongs.getText().toString();
                String dataSingers = etSingers.getText().toString();
                String dataYear = etYear.getText().toString();
                int intStar = rdGroup.getCheckedRadioButtonId();
                String dataStar = Integer.toString(intStar);
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(dataSongs,dataSingers,dataYear,dataStar);

                if (inserted_id != -1){
                    al.clear();
                    al.addAll(dbh.getAllSongs());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, lists.class);
                startActivity(i);

            }
        });

    }
}