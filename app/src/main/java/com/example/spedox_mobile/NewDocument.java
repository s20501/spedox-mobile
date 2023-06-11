package com.example.spedox_mobile;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.enums.DocumentTypeEnum;
import org.apache.commons.io.FilenameUtils;

public class NewDocument extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_CODE_SELECT_IMAGE = 100;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView photoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_document);

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
        selectedValue = (String) parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            System.out.println(selectedValue);
            System.out.println(getFileNameFromUri(selectedImageUri));
            photoName.setText(getFileNameFromUri(selectedImageUri).toString());

        }
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


}
