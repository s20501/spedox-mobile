package com.example.spedox_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.models.ShipmentModel;
import com.example.spedox_mobile.services.ShippingServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

public class Shipping extends AppCompatActivity {

    Retrofit retrofit = ApiManager.getRetrofitInstance();
    ShippingServiceApi shippingService = retrofit.create(ShippingServiceApi.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        getAllShipments();
    }

    private void getAllShipments(){
        System.out.println(getToken());
        Call<List<ShipmentModel>> call = shippingService.getAllShipments("Bearer " + getToken());
        call.enqueue(new Callback<List<ShipmentModel>>() {
            @Override
            public void onResponse(Call<List<ShipmentModel>> call, Response<List<ShipmentModel>> response) {
                System.out.println(response.errorBody());
                System.out.println(response.code());
                System.out.println(response.isSuccessful());

             if (response.isSuccessful()){
                 List<ShipmentModel> shipmentList = response.body();
                 System.out.println(shipmentList);
             }else
                 System.out.println("else statement ");

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