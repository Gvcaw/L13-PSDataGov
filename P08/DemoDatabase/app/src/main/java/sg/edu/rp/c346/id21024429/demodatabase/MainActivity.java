package sg.edu.rp.c346.id21024429.demodatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lvTasks;
    ArrayList<Task> alTask;
    ArrayAdapter<Task> aaTasks;
    EditText etTask,etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        lvTasks = findViewById(R.id.lv);
        etDate = findViewById(R.id.editTextDate);
        etTask = findViewById(R.id.editTextTask);




        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask(etTask.getText().toString(),etDate.getText().toString());
                db.close();

            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);

                //populate listView

                alTask = db.getTasks(true);
                aaTasks = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alTask);
                lvTasks.setAdapter(aaTasks);
            }
        });


    }



}

