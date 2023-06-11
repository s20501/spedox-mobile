package com.example.spedox_mobile;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.enums.DocumentTypeEnum;

public class NewDocument extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_document);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedValue = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
