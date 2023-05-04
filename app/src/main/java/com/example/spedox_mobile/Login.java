package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.models.AuthTokenResponse;
import com.example.spedox_mobile.models.LoginModel;
import com.example.spedox_mobile.services.LoginServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private Button loginButton;

    Retrofit retrofit = ApiManager.getRetrofitInstance();
    LoginServiceApi loginServiceApi = retrofit.create(LoginServiceApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = (EditText) findViewById(R.id.text_email_field);
        passwordField = (EditText) findViewById(R.id.text_password_field);
        loginButton = (Button) findViewById(R.id.button_login);

        addListenerOnClick();
    }


    private void login(String email, String password) {
        LoginModel loginModel = new LoginModel(email, password);
        Call<AuthTokenResponse> call = loginServiceApi.login(loginModel);

        call.enqueue(new Callback<AuthTokenResponse>() {
            @Override
            public void onResponse(Call<AuthTokenResponse> call, Response<AuthTokenResponse> response) {
                if (response.isSuccessful()) {

                    saveToken(response.body().getAccessToken());

                    Toast.makeText(getApplicationContext(), "Logowanie powiodlo sie", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Shipment.class);
                    startActivity(intent);

                } else
                    Toast.makeText(getApplicationContext(), "Logowanie nie powiodlo sie", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<AuthTokenResponse> call, Throwable t) {
                Log.i("LOGIN", t.toString());
            }
        });

    }

    public void addListenerOnClick() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(emailField.getText().toString(), passwordField.getText().toString());
            }
        });
    }

    public void saveToken(String token){
        SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("AUTH_TOKEN", token);
        editor.apply();
    }
}