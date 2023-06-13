package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.Manifest;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;


import android.os.Bundle;

import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.enums.DocumentTypeEnum;
import com.example.spedox_mobile.models.DocumentRestModel;
import com.example.spedox_mobile.models.ShipmentModel;
import com.example.spedox_mobile.services.DocumentServiceApi;

import org.apache.commons.io.FilenameUtils;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class NewDocument extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_CODE_SELECT_IMAGE = 100;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView photoName;
    private static final int REQUEST_CAMERA_PERMISSION = 200;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private Button btnOpenCamera;
    private ImageView imageView;

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

        btnOpenCamera = findViewById(R.id.btnOpenCamera);
        imageView = findViewById(R.id.imageView);

        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(NewDocument.this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    ActivityCompat.requestPermissions(NewDocument.this, new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA_PERMISSION);
                }
            }
        });

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

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedValue = DocumentTypeEnum.values()[position].toString();

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


            RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(selectedImageUri)), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
            RequestBody shipmentId = RequestBody.create(MediaType.parse("text/plain"), selectedShipmentId);
            RequestBody type = RequestBody.create(MediaType.parse("text/plain"), selectedValue);

            makeRequest(body,shipmentId,type);

        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Save the image to a file
            File imageFile = null;
            try {
                imageFile = createImageFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (imageFile != null) {
                try (FileOutputStream outputStream = new FileOutputStream(imageFile)) {
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    // Do something with the image file here
                    Uri selectedImageUri = data.getData();
                    String selectedShipmentId = selectedShipment.getId();
                    RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(selectedImageUri)), imageFile);
                    MultipartBody.Part body = MultipartBody.Part.createFormData("file", imageFile.getName(), requestFile);
                    RequestBody shipmentId = RequestBody.create(MediaType.parse("text/plain"), selectedShipmentId);
                    RequestBody type = RequestBody.create(MediaType.parse("text/plain"), selectedValue);

                    makeRequest(body,shipmentId,type);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void makeRequest(
            MultipartBody.Part body,
            RequestBody shipmentId,
            RequestBody type) {
        Call<String> call = documentService.addDocument(body, shipmentId, type, "Bearer " + getToken());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String result = response.body();
                    System.out.println(result);
                } else {


                    System.out.println();
                    System.out.println(response.code());
                    System.out.println(response.body());
                    System.out.println(response.errorBody().toString());
                    System.out.println("else: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage().toString());
            }
        });

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        return imageFile;
    }

    public void selectImageFromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE);
    }

    private String getFileNameFromUri(Uri uri) {
        String filePath = uri.getPath();
        String fileName = FilenameUtils.getName(filePath);
        return fileName;
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
