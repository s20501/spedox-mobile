package com.example.spedox_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.services.LoginServiceApi;
import com.example.spedox_mobile.services.ShippingServiceApi;
import retrofit2.Retrofit;

public class Shipping extends AppCompatActivity {

    Retrofit retrofit = ApiManager.getRetrofitInstance();
    ShippingServiceApi shippingService = retrofit.create(ShippingServiceApi.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
    }


}