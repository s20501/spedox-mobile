package com.example.spedox_mobile;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.models.AuthTokenResponse;
import com.example.spedox_mobile.models.LoginModel;
import com.example.spedox_mobile.services.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private Button loginButton;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    LoginService loginService = retrofit.create(LoginService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnClick();
    }


    private void login(String email, String password) {

        LoginModel loginModel = new LoginModel(email, password);
        Call<AuthTokenResponse> call = loginService.login(loginModel);
        call.enqueue(new Callback<AuthTokenResponse>() {
            @Override
            public void onResponse(Call<AuthTokenResponse> call, Response<AuthTokenResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println("login successful");
                } else {
                    System.out.println(response.errorBody().toString());
                    System.out.println("login not successful");
                }
            }

            @Override
            public void onFailure(Call<AuthTokenResponse> call, Throwable t) {
                System.out.println(t);
                System.out.println("failure");
            }
        });

    }

    public void addListenerOnClick() {
        emailField = (EditText) findViewById(R.id.text_email_field);
        passwordField = (EditText) findViewById(R.id.text_password_field);
        loginButton = (Button) findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login(emailField.getText().toString(), passwordField.getText().toString());
            }
        });
    }

    //szymon17@gmail.com szymon17 -- data for login
}