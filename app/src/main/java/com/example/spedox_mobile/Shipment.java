package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
import java.util.List;

public class Shipment extends AppCompatActivity {
    private ListView listView;
    Retrofit retrofit = ApiManager.getRetrofitInstance();
    ShippingServiceApi shippingService = retrofit.create(ShippingServiceApi.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        listView = findViewById(R.id.list_shipment);
        getDetalisOnClick();
        getAllShipments();
    }

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

    public void getDetalisOnClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShipmentModel shipmentModel = (ShipmentModel) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), ShipmentDetails.class);
                intent.putExtra("shipmentModel", shipmentModel);
                startActivity(intent);
            }
        });
    }

        private String getToken () {
            SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
            return preferences.getString("AUTH_TOKEN", null);
        }
}