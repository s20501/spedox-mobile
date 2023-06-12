package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.adapters.ShipmentAdapter;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.models.ShipmentModel;
import com.example.spedox_mobile.services.ShippingServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;
/**

 Represents an activity for displaying shipment list.
 Extends the AppCompatActivity class.
 */
public class Shipment extends AppCompatActivity {
    ListView listView;
    Retrofit retrofit = ApiManager.getRetrofitInstance();
    ShippingServiceApi shippingService = retrofit.create(ShippingServiceApi.class);

    /**
     * Called when the activity is created.
     * Initializes the activity and sets the content view to the layout resource file.
     * Retrieves a reference to the ListView used to display shipments.
     * Calls the method to fetch and display all shipments.
     *
     * @param savedInstanceState The saved instance state of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        listView = findViewById(R.id.list_shipment);
        getAllShipments();

    }
    /**
     * Called when the activity is created.
     * Initializes the activity and sets the content view to the layout resource file.
     * Retrieves a reference to the ListView used to display shipments.
     * Calls the method to fetch and display all shipments.
     *
     * @param savedInstanceState The saved instance state of the activity.
     */
    private void getAllShipments() {
        Call<List<ShipmentModel>> call = shippingService.getAllShipments("Bearer " + getToken());
        call.enqueue(new Callback<List<ShipmentModel>>() {
            @Override
            public void onResponse(Call<List<ShipmentModel>> call, Response<List<ShipmentModel>> response) {
                Log.i("SHIPPING", response.errorBody() + " " + response.code());
                if (response.isSuccessful()) {
                    List<ShipmentModel> originalList = response.body();
                    ShipmentAdapter adapter = new ShipmentAdapter(Shipment.this, R.layout.shipment_item, originalList);
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            // Pobierz kliknięty element z listy i przekaż do nowego widoku
                            ShipmentModel selectedShipment = originalList.get(position);
                            Log.d("LIST_CLICK", "Item clicked at position: " + position);

                            // Przenieś do nowego widoku i przekaż dane wybranego elementu
                            Intent intent = new Intent(Shipment.this, ShipmentDetails.class);
                            intent.putExtra("selectedShipment", selectedShipment);
                            startActivity(intent);
                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(), "Nie udalo sie wczytac listy spedycji", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ShipmentModel>> call, Throwable t) {
                Log.i("SHIPPING_FAILURE", t.getMessage());
            }
        });
    }




    /**
     * Retrieves the authentication token from shared preferences.
     *
     * @return The authentication token if found, or null if not found.
     */
        private String getToken() {
            SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
            return preferences.getString("AUTH_TOKEN", null);
        }
}