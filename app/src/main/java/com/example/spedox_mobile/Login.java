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

/**

 Represents an activity for login form.
 Extends the AppCompatActivity class.
 */
public class Login extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private Button loginButton;

    Retrofit retrofit = ApiManager.getRetrofitInstance();
    LoginServiceApi loginServiceApi = retrofit.create(LoginServiceApi.class);

    /**
     * Called when the activity is created.
     * Initializes the activity and sets the content view to the layout resource file.
     * Retrieves references to the email field, password field, and login button.
     * Sets up the click listener for the login button.
     *
     * @param savedInstanceState The saved instance state of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = (EditText) findViewById(R.id.text_email_field);
        passwordField = (EditText) findViewById(R.id.text_password_field);
        loginButton = (Button) findViewById(R.id.button_login);

        addListenerOnClick();
    }

    /**
     * Performs the login operation.
     * Creates a login model with the provided email and password.
     * Sends a login request to the server using the login service API.
     * Handles the response from the server and saves the authentication token if the login is successful.
     * Displays a toast message to indicate the success or failure of the login attempt.
     *
     * @param email    The email entered by the user.
     * @param password The password entered by the user.
     */
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
    /**
     * Sets up the click listener for the login button.
     * When the login button is clicked, the login operation is performed using the email and password entered by the user.
     */
    public void addListenerOnClick() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(emailField.getText().toString(), passwordField.getText().toString());
            }
        });
    }
    /**
     * Saves the authentication token to shared preferences.
     *
     * @param token The authentication token to be saved.
     */
    public void saveToken(String token){
        SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("AUTH_TOKEN", token);
        editor.apply();
    }
}