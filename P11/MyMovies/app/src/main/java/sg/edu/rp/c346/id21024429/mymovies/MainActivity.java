package sg.edu.rp.c346.id21024429.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnList;
    Spinner spinner;
    EditText etMovies, etGenre, etYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        spinner = findViewById(R.id.spinner);
        etMovies = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        secondActivty.class);
                startActivity(i);

            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DBHelper dbh = new DBHelper(MainActivity.this);
                String title = etMovies.getText().toString();
                String genre = etGenre.getText().toString();
                String rating = spinner.getSelectedItem().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                long inserted_id = dbh.insertMovie(title, genre, year, rating);
                if (inserted_id != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }

                etMovies.getText().clear();
                etGenre.getText().clear();
                etYear.getText().clear();
                spinner.setSelection(0);

            }

        });




    }
}
