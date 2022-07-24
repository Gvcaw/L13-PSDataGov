package sg.edu.rp.c346.id21024429.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class editActivity extends AppCompatActivity {

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
        btnDelete= findViewById(R.id.btnDelete);
        rdGroup = findViewById(R.id.rdGroup);
        etSongs = findViewById(R.id.etSongs);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        tvIDNo = findViewById(R.id.tvIDNo);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvIDNo.setText("ID: " + data.getId());
        etSongs.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(data.getYear());
        rdGroup.check(data.getStars());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editActivity.this);
                String newSong = etSongs.getText().toString();
                String newSinger = etSingers.getText().toString();
                int newYear = Integer.parseInt(etYear.getText().toString());
                int newRdg = rdGroup.getCheckedRadioButtonId();
                data.setSingers(newSinger);
                data.setStars(newRdg);
                data.setYear(newYear);
                data.setTitle(newSong);
                dbh.updateSong(data);
                dbh.close();
            }

        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editActivity.this);
                dbh.deleteNote(data.getId());

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}