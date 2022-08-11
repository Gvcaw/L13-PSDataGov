package sg.edu.rp.c346.id21024429.psdatagov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCarpark;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.lv);
        client = new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Carpark> alCarp = new ArrayList<Carpark>();
        ArrayAdapter aa = new ArrayAdapter<Carpark>(this,
                android.R.layout.simple_list_item_1, alCarp);

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String number;
            String lots;
            String lotsAvailable;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCarpInfo = firstObj.getJSONArray("carpark_data");
                    for(int i = 0; i < jsonArrCarpInfo.length(); i++) {
                        JSONObject jsonObjCarpInfo = jsonArrCarpInfo.getJSONObject(i);
                        number = jsonObjCarpInfo.getString("carpark_number");
                        JSONArray jsonExCar = jsonObjCarpInfo.getJSONArray("carpark_info");
                        JSONObject jsonODOFN = jsonExCar.getJSONObject(0);
                        lots = jsonODOFN.getString("total_lots");
                        lotsAvailable = jsonODOFN.getString("lots_available");
                        Carpark carpark = new Carpark(number, lots,lotsAvailable);
                        alCarp.add(carpark);
                    }
                }
                catch(JSONException e){

                }

                lvCarpark.setAdapter(aa);


            }
        });
    }
}