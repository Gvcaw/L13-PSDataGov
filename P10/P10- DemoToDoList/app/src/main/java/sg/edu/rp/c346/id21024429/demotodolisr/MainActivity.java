package sg.edu.rp.c346.id21024429.demotodolisr;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvToDo;
    ArrayList<ToDoItem> alToDoList;
    ArrayAdapter<ToDoItem> aaToDoList;
    CustomAdapter caToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvToDo = findViewById(R.id.listViewToDo);

        alToDoList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2020,8,1);
        Calendar date2 = Calendar.getInstance();
        date2.set(2020,8,2);
        ToDoItem item1 = new ToDoItem("Go for movie", date1);
        ToDoItem item2 = new ToDoItem("Go for haircut", date2);
        alToDoList.add(item1);
        alToDoList.add(item2);

        aaToDoList = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alToDoList);

        lvToDo.setAdapter(aaToDoList);

        caToDo = new CustomAdapter(this, R.layout.row, alToDoList);

        lvToDo.setAdapter(caToDo);

    }
}
