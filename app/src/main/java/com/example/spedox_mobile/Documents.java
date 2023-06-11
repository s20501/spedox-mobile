package com.example.spedox_mobile;

import android.content.Intent;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.adapters.DocumentAdapter;
import com.example.spedox_mobile.models.DocumentModel;
import com.example.spedox_mobile.models.ShipmentModel;

import java.util.List;

import static java.security.AccessController.getContext;

public class Documents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        ShipmentModel selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");


        List<DocumentModel> documents = selectedShipment.getDocuments();

// Utwórz instancję adaptera DocumentsAdapter
        DocumentAdapter documentsAdapter = new DocumentAdapter(Documents.this, R.layout.activity_document_item, documents);
// Ustaw adapter na ListView
        ListView documentsListView = findViewById(R.id.documents_list_view);
        documentsListView.setAdapter(documentsAdapter);


    }
}