package sg.edu.rp.c346.id21024429.rando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddProd;
    Button btnDelProd;
    Button btnTotalProd;
    EditText etProdName;
    EditText etProdPrice;
    EditText etProdPos;
    ListView lvProd;

    ArrayAdapter productAdapter;

    ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddProd = findViewById(R.id.btnAdd);
        btnDelProd = findViewById(R.id.btnDel);
        btnTotalProd = findViewById(R.id.btnTotal);
        etProdName = findViewById(R.id.etName);
        etProdPrice = findViewById(R.id.etPrice);
        etProdPos = findViewById(R.id.etPos);
        lvProd = findViewById(R.id.lvProduct);

        PopulateProductList();

        btnAddProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // POINT A


            }
        });

        btnDelProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // POINT B

            }
        });

        btnTotalProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // POINT C

            }
        });
    }

    void PopulateProductList() {
        //POINT X

    }
}