package com.myapplicationdev.android.demoandroidlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvAndroidVersions;
    ArrayList<AndroidVersion> alAndroidVersions;
    ArrayAdapter<AndroidVersion> aaAndroidVersions;

    //ArrayAdapter<AndroidVersion> aaAndroidVersions;

    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAndroidVersions = findViewById(R.id.listViewAndroidVersions);
        alAndroidVersions = new ArrayList<>();

        //create the objects
        AndroidVersion item1 = new AndroidVersion("Pie", "9.0");
        AndroidVersion item2 = new AndroidVersion("Oreo", "8.0 - 8.1");
        AndroidVersion item3 = new AndroidVersion("Nougat", "7.0 - 7.1.2");

        //adding the objects into the ArrayList
        alAndroidVersions.add(item1);
        alAndroidVersions.add(item2);
        alAndroidVersions.add(item3);

        /*alAndroidVersions.add("Pie - 9.0");
        alAndroidVersions.add("Oreo - 8.0 - 8.1");
        alAndroidVersions.add("Nougat - 7.0 - 7.1.2");
        alAndroidVersions.add("Marshmallow - 6.0 - 6.0.1");
        alAndroidVersions.add("Lollipop - 5.0 - 5.1.1");
        alAndroidVersions.add("KitKat - 4.4 - 4.4.4");
        alAndroidVersions.add("Jelly Bean - 4.1 - 4.3.1");
        */
        aaAndroidVersions = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alAndroidVersions);

        lvAndroidVersions.setAdapter(aaAndroidVersions);


        //aaAndroidVersions = new ArrayAdapter<>(this,
        //android.R.layout.simple_list_item_1, alAndroidVersions);


        adapter = new CustomAdapter(this, R.layout.row, alAndroidVersions);


        //lvAndroidVersions.setAdapter(aaAndroidVersions);


        lvAndroidVersions.setAdapter(adapter);

    }

}