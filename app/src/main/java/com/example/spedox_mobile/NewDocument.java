package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.enums.DocumentTypeEnum;
import com.example.spedox_mobile.models.DocumentRestModel;
import com.example.spedox_mobile.models.ShipmentModel;
import com.example.spedox_mobile.services.DocumentServiceApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.io.File;


public class NewDocument extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_CODE_SELECT_IMAGE = 100;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView photoName;

    private ShipmentModel selectedShipment;
    private DocumentServiceApi documentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_document);

        Retrofit retrofit = ApiManager.getRetrofitInstance();
        documentService = retrofit.create(DocumentServiceApi.class);

        photoName = findViewById(R.id.photo_name);

        spinner = findViewById(R.id.spinner);

        DocumentTypeEnum[] values = DocumentTypeEnum.getAllValues();

        String[] displayValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            displayValues[i] = values[i].getValue();
        }

        spinnerAdapter = new ArrayAdapter<>(NewDocument.this, android.R.layout.simple_spinner_item, displayValues);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(this);
    }

    String selectedValue;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedValue = DocumentTypeEnum.values()[position].toString();
        //selectedValue = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ShipmentModel selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");

        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();

            String selectedShipmentId = selectedShipment.getId();
            File file = new File(getRealPathFromUri(selectedImageUri));

            DocumentRestModel documentRestModel = new DocumentRestModel();

            documentRestModel.setFile(file);
            documentRestModel.setShipmentId(selectedShipmentId);
            documentRestModel.setType(selectedValue);

            RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(selectedImageUri)), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
            RequestBody shipmentId = RequestBody.create(MediaType.parse("text/plain"), selectedShipmentId);
            RequestBody type = RequestBody.create(MediaType.parse("text/plain"), selectedValue);

            Call<String> call = documentService.addDocument(body, shipmentId, type, "Bearer " + getToken());

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String result = response.body();
                        System.out.println(result);
                    } else {
                        System.out.println(documentRestModel.getShipmentId());
                        System.out.println(documentRestModel.getFile().toString());
                        System.out.println();
                        System.out.println(response.code());
                    }
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    System.out.println(t.getMessage().toString());
                }
            });
        }
    }

    public void selectImageFromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE);

    }


    private String getToken() {
        SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
        return preferences.getString("AUTH_TOKEN", null);
    }

    private String getRealPathFromUri(Uri uri) {
        String filePath = null;
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            if (cursor.moveToFirst()) {
                filePath = cursor.getString(columnIndex);
            }
            cursor.close();
        }
        return filePath;
    }




}