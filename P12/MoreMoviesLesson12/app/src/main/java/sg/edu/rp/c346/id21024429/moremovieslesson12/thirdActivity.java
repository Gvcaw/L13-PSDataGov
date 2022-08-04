package sg.edu.rp.c346.id21024429.moremovieslesson12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
            AlertDialog.Builder soBuilder = new AlertDialog.Builder(thirdActivity.this);
            soBuilder.setTitle("Danger");
            soBuilder.setMessage("Are you sure you want to delete the movie" + data.getTitle());
            soBuilder.setCancelable(false);
            DBHelper dbh = new DBHelper(thirdActivity.this);
            soBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    dbh.deleteMovie(data.getId());
                    startActivity(old);
                }
            });
            soBuilder.setNeutralButton("Cancel",null);
            AlertDialog myDialog = soBuilder.create();
            myDialog.show();
        }
    });
        btCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder toBuilder = new AlertDialog.Builder(thirdActivity.this);
            toBuilder.setTitle("Danger");
            toBuilder.setMessage("Are you sure you want to discard te changes");
            toBuilder.setCancelable(false);
            toBuilder.setPositiveButton("Discard", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    startActivity(old);
                }
            });
            toBuilder.setNeutralButton("Do Not Discard",null);
            AlertDialog myDialog2 = toBuilder.create();
            myDialog2.show();
        }
    });



    }
}