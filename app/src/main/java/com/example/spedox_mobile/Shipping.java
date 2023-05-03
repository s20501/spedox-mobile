package com.example.spedox_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class Shipping extends AppCompatActivity {

    private ListView listView;
    Retrofit retrofit = ApiManager.getRetrofitInstance();
    ShippingServiceApi shippingService = retrofit.create(ShippingServiceApi.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        listView = findViewById(R.id.list_shipment);
        getAllShipments();
    }

    private void getAllShipments(){
        System.out.println(getToken());
        Call<List<ShipmentModel>> call = shippingService.getAllShipments("Bearer " + getToken());
        call.enqueue(new Callback<List<ShipmentModel>>() {
            @Override
            public void onResponse(Call<List<ShipmentModel>> call, Response<List<ShipmentModel>> response) {
                Log.i("SHIPPING", response.errorBody() + " " + response.code());

                if (response.isSuccessful()) {
                    List<ShipmentModel> originalList = response.body();
                    ShipmentAdapter adapter = new ShipmentAdapter(Shipping.this, R.layout.shipment_item, originalList);                    listView.setAdapter(adapter);
                } else{

                }
            }
            @Override
            public void onFailure(Call<List<ShipmentModel>> call, Throwable t) {

            }
        });
    }

    private String getToken(){
        SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
        return preferences.getString("AUTH_TOKEN", null);
    }
}