package sg.edu.rp.c346.id21024429.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class edit extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etSongs, etSingers, etYear;
    TextView tvIDNo;
    RadioGroup rdGroup;
    Song data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);
        rdGroup = findViewById(R.id.rdGroup);
        etSongs = findViewById(R.id.etSongs);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        tvIDNo = findViewById(R.id.tvIDNo);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvIDNo.setText("ID: " + data.getId());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(edit.this);
                data.setSingers(etSingers.getText().toString());
                data.setTitle(etSongs.getText().toString());
                int years = Integer.parseInt(etYear.getText().toString());
                data.setYear(years);
                int intStars = rdGroup.getCheckedRadioButtonId();
                data.setStars(intStars);
                dbh.updateSong(data);
                dbh.close();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(edit.this);
                dbh.deleteSong(data.getId());

            }
        });


    }
}