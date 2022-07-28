package sg.edu.rp.c346.id21024429.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class thirdActivity extends AppCompatActivity {

    EditText etTitle, etGenre, etYear;
    TextView tvID;
    Spinner spinner;
    Button btnUpdate, btnDelete, btCancel;
    Movie data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        tvID = findViewById(R.id.movieIDs2);
        spinner = findViewById(R.id.spinner);
        btnDelete = findViewById(R.id.btnDelete);
        btCancel = findViewById(R.id.btnCancel);
        btnUpdate = findViewById(R.id.btnUpdate);

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("Movie");

        Intent old = new Intent(thirdActivity.this, secondActivty.class);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(thirdActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setRating(spinner.getSelectedItem().toString());

                dbh.updateMovie(data);
                dbh.close();
                startActivity(old);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DBHelper dbh = new DBHelper(thirdActivity.this);
            dbh.deleteMovie(data.getId());
            startActivity(old);
        }
    });
        btCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(old);
        }
    });



    }
}