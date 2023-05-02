package com.example.spedox_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.models.AuthTokenResponse;
import com.example.spedox_mobile.models.ShipmentModel;
import com.example.spedox_mobile.services.LoginServiceApi;
import com.example.spedox_mobile.services.ShippingServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        Call<ShipmentModel> call = shippingService.getAllShipments(getToken());
        call.enqueue(new Callback<ShipmentModel>() {
            @Override
            public void onResponse(Call<ShipmentModel> call, Response<ShipmentModel> response) {

            }

            @Override
            public void onFailure(Call<ShipmentModel> call, Throwable t) {

            }
        });
    }

    private String getToken(){
        SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
        return preferences.getString("AUTH_TOKEN", null);
    }
}